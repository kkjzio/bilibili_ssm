package com.kkjz.mybatis.test;

import com.google.code.kaptcha.Producer;
import com.kkjz.mapper.VideoMapper;
import com.kkjz.pojo.User;
import com.kkjz.pojo.Video;
import com.kkjz.service.UserListService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import com.kkjz.mapper.UserMapper;
import com.kkjz.utils.myUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author kkjz
 * @create 2022-08-23 17:41
 */
public class MybatisTest {

    @Test
    public void testMybatis() throws IOException {

        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件
        //通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
        User result = userMapper.selectByPrimaryKey("004bcfc8d4bd407bb1a114785539006f");
        //提交事务
        sqlSession.commit();
        System.out.println("result:" + result);

    }

    @Test
    public void testMybatis2() throws IOException{
        ApplicationContext context= new ClassPathXmlApplicationContext("springcontext.xml");
        VideoMapper videoMapper = (VideoMapper) context.getBean("videoMapper");
        List<Video> res = videoMapper.selectByVideoCategory('0',2);
        System.out.println(res);

    }

    @Test
    public void testDataString(){
        Date date = new Date();
        System.out.println(date.getTime());
    }

    @Test
    public void testKaptch(){
        ApplicationContext context= new ClassPathXmlApplicationContext("springcontext.xml");
        Producer pro = (Producer) context.getBean("kaptchaProducer");

        String verifyCode = pro.createText();
        System.out.println(verifyCode);

    }

    @Test
    public void MDtest(){
        String md5 = myUtil.getMD5("123456");
        System.out.println(md5);
    }

    @Test
    public void num(){
        int i = 233;
        System.out.println(i+"ssd"+12/5);
    }

    @Test
    public void filePathTest(){

        String str="";
        System.out.println(str.replaceAll("\n", "<br>"));
    }
}
