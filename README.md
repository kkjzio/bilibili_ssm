# 项目展示地址

 [http://114.115.133.60:9993/](http://114.115.133.60:9993/)



# 项目简介

ssm（spring5+springmvc+mybatis）仿bilibili视频网站，实现简单的视频网站所需要的功能

![](https://img.kkjz.xyz/usr/uploads/2022/10/QQ图片20220914184321.jpg)

将视频分类并呈现在首页上，并且将视频推荐在首页，可以在线观看视频，能够完成注册、登录、收藏、投稿等的视频网站常见功能。



## 功能展示

+ 注册

![](https://img.kkjz.xyz/usr/uploads/2022/10/2022108-103949.jpg)

+ 视频播放

![](https://img.kkjz.xyz/usr/uploads/2022/10/2022108-104853.jpg)



原jsp前端来源原项目：

https://github.com/ArvinZhangX/ssm_bilibili

改写全部前端为Thymeleaf，加入一些js和css，实现一些ajax

重写所有后端，实现视频播放、评论、后台管理、收藏等的功能



## 环境要求

```
jdk 　1.8
mysql 　5.7
tomcat 　8.0.42（8.5也行）
```



# Get-start

## ready

1. 将`sqlbak`中的sql文件执行到数据库中

2. 进入`src\main\resources`下，修改`jdbc.properties`文件，填入自己的数据库地址和账号密码

（以下为可选）

修改`slidePic.properties`中的首页信息。

更改`log4j.properties`中的`log4j.appender.file.File`和`log4j.appender.E.File`否则**生成的日志文件默认存在tomcat的执行目录下**。



## 1.IDEA

直接读取`kkjzArt.iml`，保留了artifacts信息，直接配置tomcat即可启用



## 2.war文件

放入tomcat目录下webapp文件夹下，开启tomcat后，浏览器输入`http://[你的ip]:[tomcat的端口]/bilibili`即可启动



默认账号:

```
user:admin
password:123456
```



------



# 其他信息：

## 1.已经实现和将要实现的功能

- [x] 视频播放

- [x] 收藏

- [x] 收藏管理

- [x] 评论

- [x] 用户登录和注册

- [x] 注册验证码

- [x] 后台密码MD5加密

- [x] 用户信息修改

- [x] 头像修改

- [x] 视频文件投稿和视频管理

- [x] Restful 风格

- [x] 前端thymeleaf

- [ ] 评论管理

- [ ] 管理员后台、用户信息管理、网页外观设置

- [ ] 视频推荐机制（目前是随机首页推荐）

- [ ] 密码找回

- [ ] 增加视频路径换cdn前缀功能

- [ ] 后台换成springBoot

- [ ] 搜索功能

  



## 2.一些比较重要的技术栈

+ 项目整体使用maven进行管理
+ 前端使用thymeleaf编译
+ 后端使用spring5套件

+ 数据库使用Mysql 5.7，使用5.1.3的jdbc通过c3p0数据连接池进行连接，MyBatis进行后端和数据库的交互
+ 利用`mybatis.generator`逆向分析数据库生成了部分sql语句
+ 验证码的生成使用了开源的kaptcha包
+ 日志使用slf4j + log4j的组合，日志生成的log4j版本为1.2.17，日志输出和存储的slf4j版本为1.7.25
+ 视频的播放使用开源软件为ArtPlayers 4.5.5



# Reference

[ArtPlayer](https://github.com/zhw2590582/ArtPlayer)

[kaptcha](https://code.google.com/archive/p/kaptcha/)
