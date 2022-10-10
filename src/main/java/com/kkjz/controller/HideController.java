package com.kkjz.controller;

import com.google.gson.Gson;
import com.kkjz.pojo.Favourite;
import com.kkjz.pojo.Message;
import com.kkjz.pojo.User;
import com.kkjz.pojo.Video;
import com.kkjz.service.FavouriteService;
import com.kkjz.service.MessageService;
import com.kkjz.service.impl.UserListServiceImpl;
import com.kkjz.service.impl.VideoServiceImpl;
import com.kkjz.utils.myUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author kkjz
 * @create 2022-09-01 16:33
 */

@Controller
public class HideController {

    @Autowired
    VideoServiceImpl videoServiceImpl;
    @Autowired
    UserListServiceImpl userListServiceImpl;
    @Autowired
    MessageService messageServiceImpl;
    @Autowired
    FavouriteService favouriteServiceImpl;


    public void ajaxTj(HttpServletRequest request, HttpServletResponse response, char Category) throws IOException {
        // 没写推荐逻辑 这里直接随机出来
        List<Video> list = videoServiceImpl.videoBycategoryWithlimit(Category, 7);
        // 设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        // 打包成json格式
        String gjson = gson.toJson(list);
        out.write(gjson);
    }

    //@ResponseBody 表示该方法的返回结果直接写入 HTTP response body 中
    @RequestMapping(value = "ajaxTuiJian", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void ajaxTuiJian(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ajaxTj(request, response, '0');
    }

    @RequestMapping(value = "ajaxTuiJian1", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void ajaxTuiJian1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ajaxTj(request, response, '1');
    }

    @RequestMapping(value = "ajaxTuiJian2", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void ajaxTuiJian2(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ajaxTj(request, response, '2');
    }

    @RequestMapping(value = "ajaxTuiJian3", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public void ajaxTuiJian3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ajaxTj(request, response, '3');
    }


    /**
     * 以下为上传头像设置
     */
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "/static/userHand_Top/upload/";

    @RequestMapping(value = "UploadServlet", method = RequestMethod.POST)
    public String upHandImg(MultipartFile[] uploadFile, HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return null;
        }

        //处理文件存储的真实物理路径
        String filePath = UPLOAD_DIRECTORY;
        String fileName;
        String sqlPath;

        for (MultipartFile file : uploadFile) {

            fileName = file.getOriginalFilename();
            // 获取最后一个.的位置
            int lastIndexOf = fileName.lastIndexOf(".");
            // 获取文件的后缀名 .jpg
            String suffix = fileName.substring(lastIndexOf);
            // 用时间函数定义文件名
            Date date = new Date();
            fileName = Long.toString(date.getTime()) + suffix;
            // 文件存入
            sqlPath = myUtil.fileSave(file, filePath, request, fileName);


            HttpSession session = request.getSession();
            String userID = (String) session.getAttribute("userID");

            // 暂存原头像路径
            User user = userListServiceImpl.getUser(userID);
            String oriImgPath = user.getUserHand();
            oriImgPath = request.getServletContext().getRealPath(oriImgPath);

            // 上传完毕后往sql写入
            if (userListServiceImpl.changeUserHand(userID, sqlPath) >= 0) {
                request.setAttribute("upSuccess", true);
                //更新头像信息
                request.getSession().setAttribute("userHand", sqlPath);

                // 刪除原头像文件
                myUtil.delFile(oriImgPath);

                // 把回复中的头像地址都换成新的(可优化)
                messageServiceImpl.updateHandimg(userID,sqlPath);

            } else {
                return "sqlfail";
            }


        }


        return "User_full_information";
    }


    // 以下为文件上传的ajax设置
    String UPLOAD_DIRECTORY_VIDEO = "/static/videolook/";


    // ajax文件信息上传 视频信息上传
    @RequestMapping(value = "ajaxvideoFileTop", method = RequestMethod.POST)
    @ResponseBody
    public String ajaxVideoup(@RequestParam("files") MultipartFile[] files,
                              @RequestParam String title,
                              @RequestParam String describe,
                              @RequestParam String vType,
                              HttpServletRequest request) {


        String videoSqlPath = "";
        String imgSqlPath = "";
        // 对应webapp后的存储路径
        String filePath;
        String fileName;
        String fileType;
        Date date = new Date();
        boolean flag = false;
        for (MultipartFile file : files) {
            System.out.println("files:" + file.getContentType());

            fileType = file.getContentType();

            // 处理视频文件
            if (fileType.matches("video/.*")) {
                flag = true;
                //存放视频的目录
                filePath = UPLOAD_DIRECTORY_VIDEO;
                // media后缀
                String originalFilename = file.getOriginalFilename();
                //获取最后一个.的位置
                int lastIndexOf = originalFilename.lastIndexOf(".");
                //获取文件的后缀名
                String suffix = originalFilename.substring(lastIndexOf);
                //使用时间当作文件的存储名
                fileName = Long.toString(date.getTime()) + suffix;

                try {
                    videoSqlPath = myUtil.fileSave(file, filePath, request, fileName);
                    System.out.println("视频上传成功");
                } catch (IOException e) {
                    e.printStackTrace();
                    return "video save fail";
                }
            }
            if (fileType.matches("image/.*")) {
                flag = true;
                //存放视频封面的目录
                filePath = UPLOAD_DIRECTORY_VIDEO + "videolookimg/";
                // media后缀
                String originalFilename = file.getOriginalFilename();
                //获取最后一个.的位置
                int lastIndexOf = originalFilename.lastIndexOf(".");
                //获取文件的后缀名
                String suffix = originalFilename.substring(lastIndexOf);
                fileName = Long.toString(date.getTime()) + suffix;

                try {
                    imgSqlPath = myUtil.fileSave(file, filePath, request, fileName);
                    System.out.println("视频封面上传成功");
                } catch (IOException e) {
                    e.printStackTrace();
                    return "image save fail";
                }
            }


        }

        //test
        if (!flag) {
            return "save file fail!";
        }

        /******************** 文件写入成功后 sql写入 **************************/

        Video video = new Video();
        video.setVideoName(title);
        //暂时没做观看次数统计
        video.setVideolookTime("114");
        //要获取视频的准确播放时间可以用jave，这里为了项目体积暂不引入
        video.setVideoTime("5:14");
        video.setVideoState("1");
        // 视频分类
        video.setVideocAtegory(vType);
        video.setVideoImage(imgSqlPath);
        video.setVideoAddress(videoSqlPath);
        // 通过session中的用户名写入上传者的ID（不是用户名）
        String useName = (String) request.getSession().getAttribute("userName");
        video.setUserID(userListServiceImpl.findUseID(useName));
        video.setvideoDescribe(describe);

        // video构造完成后写入sql
        videoServiceImpl.uploadVideo(video);

        return "success";

    }

    // ajax视频留言
    @RequestMapping(value = "ajaxMessageUp", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String ajaxMessageUp(HttpServletRequest request, String message, String videoID) {
        HttpSession session = request.getSession();
        User user = userListServiceImpl.getUser((String) session.getAttribute("userID"));
        // 生成留言UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        Message ms = new Message();

        // mapper中用了NOW()函数，不需要提供时间
        ms.setMessageID(uuid);
        ms.setMessagevideoID(videoID);
        ms.setMessageuserID(user.getUserID());
        ms.setMessageuserName(user.getUserName());
        ms.setMessage(message);
        ms.setMessageHand(user.getUserHand());

        // 写入sql
        messageServiceImpl.addMessage(ms);

        return "留言成功";
    }


    // ajax修改用户信息
    @RequestMapping(value = "ajaxInformationUp", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String ajaxInformationUp(@RequestBody Map<String, String> userJson, HttpServletRequest request) {

//        response.setCharacterEncoding("UTF-8");
//        request.setCharacterEncoding("UTF-8");

        User user = userListServiceImpl.getUser((String) request.getSession().getAttribute("userID"));
        String newUserId = userListServiceImpl.findUseID(userJson.get("userName"));


        System.out.println("进入函数！");
        System.out.println(userJson.toString());
        // 首先判断新用户名是否存在，再判断和原来的是否一致UserID
        if (!(newUserId.equals("")) && !(user.getUserID().equals(newUserId))) {
            return "该用户名已存在!";
        }

        // 检查邮箱是否合法
        String reg = "[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+";
        if (!(userJson.get("userEmial").matches(reg))) {
            return "邮箱格式不合法！";
        }


        // 更新对应的用户信息
        user.setUserName(userJson.get("userName"));
        user.setUserAddress(userJson.get("userAddress"));
        user.setUserPhone(userJson.get("userPhone"));
        user.setUserQQ(userJson.get("userQQ"));
        user.setUserEmial(userJson.get("userEmial"));


        // update到mysql

        if (userListServiceImpl.updateUserbyUser(user) > 0) {
            return "数据修改成功！";
        }

        return "数据存储失败！";

    }

    // 查询用户是否已收藏
    @RequestMapping("ajaxinquireFavourite")
    @ResponseBody
    public String ajaxinquireFavourite(HttpServletRequest request, String videoID) {
        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("userID");

        //判断用户 是否登录 是否已经收藏
        if (userID != null &&
                favouriteServiceImpl.getCountByID(userID, videoID) > 0) {
            return "success";
        }
        return "fail";
    }


    // 给用户添加收藏
    @RequestMapping("ajaxAddFavourite")
    @ResponseBody
    public String ajaxAddFavourite(HttpServletRequest request, String videoID) {
        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("userID");
        Video video = videoServiceImpl.videoByID(videoID);

        Favourite favourite = new Favourite();
        favourite.setVideoID(videoID);
        favourite.setVideoName(video.getVideoName());
        favourite.setVideoImage(video.getVideoImage());
        favourite.setUserID(userID);

        // 将favourite记录加入sql
        if (favouriteServiceImpl.addRecode(favourite) > 0)
            return "success";

        return "fail";
    }

    // 取消收藏
    @RequestMapping(value = "ajaxDeleteFavourite", method = RequestMethod.DELETE)
    @ResponseBody
    public String ajaxDeleteFavourite(HttpServletRequest request, String videoID) {
        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("userID");

        if (favouriteServiceImpl.deleRecode(userID, videoID) > 0)
            return "success";

        return "fail";
    }

    // 视频删除
    @RequestMapping(value = "ajaxDeleteVideo", method = RequestMethod.DELETE)
    @ResponseBody
    public String ajaxDeleteVideo(HttpServletRequest request, String videoID) {
        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("userID");

        Video video = videoServiceImpl.videoByID(videoID);

        //获取视频和视频头图存放的绝对路径
        String filePath1 = request.getServletContext().getRealPath(video.getVideoAddress());
        String filePath2 = request.getServletContext().getRealPath(video.getVideoImage());
//        System.out.println("1: " + filePath1 + "\n" + "2: " + filePath2);

        if (!myUtil.delFile(filePath1))
            System.out.println("找不到视频文件位置：" + filePath1);

        if (!myUtil.delFile(filePath2))
            System.out.println("找不到视频图像位置：" + filePath2);

        // 执行sql删除 对应收藏也会全部删除
        if (videoServiceImpl.delVideoByVideoIDAndUserID(videoID, userID) < 1)
            return "fail";

        // 对应底下的留言全部删除
        messageServiceImpl.delByvideoID(videoID);

        favouriteServiceImpl.deleByvideoID(videoID);

        return "success";
    }


    // 评论查询
    @RequestMapping(value = "ajaxQueryMessage",method = RequestMethod.GET)
    @ResponseBody
    public void ajaxQueryMessage(HttpServletRequest request,HttpServletResponse response,
                                 String videoID,String messagePage) throws IOException {
        // 字符串转int
        int page = Integer.parseInt(messagePage);
        // 获取总页数：
        int count = messageServiceImpl.getAllCountByVideoID(videoID);
        int allPage = (count / 5);
        if(count>0)
            allPage++;
        //判断页数是否过多或过少
        if (page > allPage) page = allPage;
        if (page < 1) page = 1;
        List<Message> messageList = messageServiceImpl.messageVideoByIDAndPage(videoID,page);

        // 设置编码
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        // 打包成json格式
        String gjson = gson.toJson(messageList);
        out.write(gjson);

    }

}
