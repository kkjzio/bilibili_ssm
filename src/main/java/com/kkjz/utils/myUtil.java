package com.kkjz.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author kkjz
 * @create 2022-09-22 15:23
 */
public class myUtil {

    // MD5转换
    public final static String getMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");//创建具有指定算法名称的摘要
            md.update(str.getBytes());                    //使用指定的字节数组更新摘要
            byte mdBytes[] = md.digest();                 //进行哈希计算并返回一个字节数组

            String hash = "";
            for (int i = 0; i < mdBytes.length; i++) {           //循环字节数组
                int temp;
                if (mdBytes[i] < 0)                          //如果有小于0的字节,则转换为正数
                    temp = 256 + mdBytes[i];
                else
                    temp = mdBytes[i];
                if (temp < 16)
                    hash += "0";
                hash += Integer.toString(temp, 16);         //将字节转换为16进制后，转换为字符串
            }
            return hash;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 文件删除
    public final static boolean delFile(String path) {
        File obj = new File(path);
        if (obj.delete()) {
            System.out.println("删除成功");
            return true;
        } else
            return false;
    }

    //文件写入函数 返回存储的sql路径
    // filePath为文件基于webapp的相对路径
    public final static String fileSave(MultipartFile file, String filePath, HttpServletRequest request, String fileName) throws IOException {
        //处理文件存储的真实物理路径
        String savePath = request.getServletContext().getRealPath(filePath);
        // 如果目录不存在则创建
        File uploadDir = new File(savePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }


//        String fileName = file.getOriginalFilename();
//        // 处理不在表单中的字段
//        String reg = "[\u4e00-\u9fa5]";
//        Pattern pat = Pattern.compile(reg);
//        Matcher mat = pat.matcher(fileName);
//        fileName = mat.replaceAll("");


        // 存放的文件的绝对路径和sql存放的值
        String realPath = savePath + File.separator + fileName;
        String SqlPath = filePath + fileName;
//                filePath = filePath.replace("\\", "/");

        /******************** 文件写入 **************************/
        File storeFile = new File(realPath);
        System.out.println("文件上传位置： " + realPath);
        // 得到输入流
        InputStream in = file.getInputStream();
        // 得到文件的输出流
        OutputStream out = new FileOutputStream(storeFile);
        // 文件总大小
//        long fileSize = file.getSize();
        int len = 0;
        // 读写缓冲
        byte[] b = new byte[300];
        // 循环从输入流写入到输出流,结束循环是len==-1
        while ((len = in.read(b)) != -1) {
            out.write(b, 0, len);
        }
        out.flush();// 刷新
        out.close();// 关闭
        in.close();// 关闭

        return SqlPath;

    }


}
