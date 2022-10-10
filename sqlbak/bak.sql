/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.7.34-log : Database - bilibili
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bilibili` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bilibili`;

/*Table structure for table `favourite` */

DROP TABLE IF EXISTS `favourite`;

CREATE TABLE `favourite` (
  `favouriteID` int(11) NOT NULL AUTO_INCREMENT,
  `videoID` varchar(32) DEFAULT NULL,
  `videoName` varchar(160) DEFAULT NULL,
  `videoImage` text,
  `userID` varchar(32) DEFAULT NULL,
  `favouriteTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`favouriteID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `favourite` */

insert  into `favourite`(`favouriteID`,`videoID`,`videoName`,`videoImage`,`userID`,`favouriteTime`) values (11,'49','【中字PV_SC】#P对自家偶像的评价也太不得了了吧——闪耀色彩3.5周年纪念视频','/static/videolook/videolookimg/1663298210940.jpg','004bcfc8d4bd407bb1a114785539006f','2022-09-26 17:55:12'),(14,'8','【AMV】 战斗意志不灭 ！！！','/static/videolook/videolookimg/9325861-1-hd.png','004bcfc8d4bd407bb1a114785539006f','2022-09-26 19:41:08'),(21,'11','【炮姐/AMV】我永远都会守护在你的身边！','/static/videolook/videolookimg/1176840-1-hd.png','004bcfc8d4bd407bb1a114785539006f','2022-09-27 09:31:35'),(22,'26','【ASMV综漫燃向】为了什么而战，为了变强，能保护你那么强','/static/videolook/videolookimg/weilebianqiang.png','004bcfc8d4bd407bb1a114785539006f','2022-09-27 09:31:47'),(24,'52','Y2Mate.is - Cyberpunk Edgerunners','/static/videolook/videolookimg/1664525437383.jpg','004bcfc8d4bd407bb1a114785539006f','2022-09-30 16:13:38');

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `messageID` varchar(32) NOT NULL,
  `messagevideoID` varchar(32) NOT NULL,
  `messageuserID` varchar(32) NOT NULL,
  `messageuserName` varchar(32) NOT NULL,
  `messageTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `message` text NOT NULL,
  `messageHand` text NOT NULL,
  PRIMARY KEY (`messageID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `message` */

insert  into `message`(`messageID`,`messagevideoID`,`messageuserID`,`messageuserName`,`messageTime`,`message`,`messageHand`) values ('01f4fff6b56846329a6483917dc30eff','49','283405a2f5f4468184b6e9eab0e33a90','kkjz3','2022-10-04 14:46:59','https://www.youtube.com/watch?v=yoGBXRpUwvw','/static/userHand_Top/upload/MyHand.png'),('2d7229ff55514daa9c1e25634e93099c','49','004bcfc8d4bd407bb1a114785539006f','admin','2022-10-04 21:49:53','233333','/static/userHand_Top/upload/1664939239533.jpg'),('2f57b96d2e4f4e29bbc606d9cae327a5','49','283405a2f5f4468184b6e9eab0e33a90','kkjz3','2022-10-04 14:45:23','testtt','/static/userHand_Top/upload/MyHand.png'),('4b3b930c0f7046648ed4329728fa4e21','49','283405a2f5f4468184b6e9eab0e33a90','kkjz3','2022-10-04 14:46:40','当初见到这个原版PV的时候真的被SC震撼到了','/static/userHand_Top/upload/MyHand.png'),('4dd6800f84994633866553249c7c6ca7','49','004bcfc8d4bd407bb1a114785539006f','admin','2022-10-04 21:49:50','test','/static/userHand_Top/upload/1664939239533.jpg'),('5c053ff67a5f4b799ef538c07e925eac','10','004bcfc8d4bd407bb1a114785539006f','admin','2022-10-04 21:43:53','123','/static/userHand_Top/upload/1664939239533.jpg'),('63b024e9cdd44a268e10dba2bef02075','52','004bcfc8d4bd407bb1a114785539006f','admin','2022-10-03 21:49:53','子弹杯里伏特加加小可乐，生的伟大 死的光荣','/static/userHand_Top/upload/1664939239533.jpg'),('6b644fb2a20c4c95b6d983c8f174197c','49','004bcfc8d4bd407bb1a114785539006f','admin','2022-10-04 14:47:53','水平有限，有错误或不适的地方欢迎大力指正','/static/userHand_Top/upload/1664939239533.jpg'),('bb7cab4a77534fc6b1dd301b156e4ea3','49','283405a2f5f4468184b6e9eab0e33a90','kkjz3','2022-10-04 14:46:53','也非常欢迎大家用这个视频去安利那些想要入坑sc的朋友。','/static/userHand_Top/upload/MyHand.png'),('e976f0de8da34f15969f1933134e03d0','49','283405a2f5f4468184b6e9eab0e33a90','kkjz3','2022-10-04 14:46:47','如果你也能从这个视频了收获到些许的快乐甚至于成为你了解SC的契机那我将非常荣幸','/static/userHand_Top/upload/MyHand.png');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userID` varchar(32) NOT NULL,
  `userMingzi` varchar(32) DEFAULT NULL,
  `userName` varchar(32) NOT NULL,
  `usersex` varchar(10) DEFAULT NULL,
  `passWord` varchar(48) NOT NULL,
  `userHand` text,
  `userAddress` varchar(160) DEFAULT NULL,
  `userPhone` varchar(11) NOT NULL,
  `userQQ` varchar(32) DEFAULT NULL,
  `userEmial` varchar(32) DEFAULT NULL,
  `userCollection` varchar(160) DEFAULT NULL,
  `useryinghangka` varchar(48) DEFAULT NULL,
  `userState` varchar(11) NOT NULL,
  `userLoginTime` varchar(32) DEFAULT NULL,
  `userIP` varchar(32) DEFAULT NULL,
  `userPaypassword` varchar(48) DEFAULT NULL,
  `userRMB` text,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`userID`,`userMingzi`,`userName`,`usersex`,`passWord`,`userHand`,`userAddress`,`userPhone`,`userQQ`,`userEmial`,`userCollection`,`useryinghangka`,`userState`,`userLoginTime`,`userIP`,`userPaypassword`,`userRMB`) values ('004bcfc8d4bd407bb1a114785539006f','佘峰','admin','男','7c4a8d09ca3762af61e59520943dc26494f8941b','/static/userHand_Top/upload/1664939239533.jpg','四川省遂宁市船山区河沙镇中国村中国舌中国区26号','1548765224','794799102','25@14.ccc',NULL,NULL,'正常',NULL,NULL,'73520','15379'),('283405a2f5f4468184b6e9eab0e33a90',NULL,'kkjz3',NULL,'7c4a8d09ca3762af61e59520943dc26494f8941b','/static/userHand_Top/upload/MyHand.png',NULL,'11451476610',NULL,'sd@ads.cc',NULL,NULL,'正常',NULL,NULL,NULL,'0'),('bd677ef840154dcc9105227c5c8d1bd4',NULL,'kkjz',NULL,'2c8509df0df65f9826dc872a9acfea532c1f53c7','/static/userHand_Top/upload/MyHand.png',NULL,'11451476610',NULL,'sd@ads.cc',NULL,NULL,'正常',NULL,NULL,NULL,'0'),('dad65595d7ee44558d18800451d32892',NULL,'kkjz2',NULL,'7c4a8d09ca3762af61e59520943dc26494f8941b','/static/userHand_Top/upload/MyHand.png',NULL,'11451476610',NULL,'sd@ads.cc',NULL,NULL,'正常',NULL,NULL,NULL,'0');

/*Table structure for table `video` */

DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
  `videoID` int(11) NOT NULL AUTO_INCREMENT,
  `videoName` varchar(160) CHARACTER SET utf8mb4 DEFAULT NULL,
  `videolookTime` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `videoTime` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `videoState` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `videocAtegory` varchar(32) CHARACTER SET utf8mb4 NOT NULL,
  `videoImage` text CHARACTER SET utf8mb4 NOT NULL,
  `videoAddress` text CHARACTER SET utf8mb4,
  `videoCollection` text CHARACTER SET utf8mb4,
  `videoLeaving` text CHARACTER SET utf8mb4,
  `userID` varchar(32) DEFAULT NULL,
  `userName` varchar(32) DEFAULT NULL,
  `videoDescribe` text,
  PRIMARY KEY (`videoID`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

/*Data for the table `video` */

insert  into `video`(`videoID`,`videoName`,`videolookTime`,`videoTime`,`videoState`,`videocAtegory`,`videoImage`,`videoAddress`,`videoCollection`,`videoLeaving`,`userID`,`userName`,`videoDescribe`) values (1,'未闻花名纪念演唱会 secret base~你给我的所有~ ','345','6:00','1','1','/static/videolook/videolookimg/10206688-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(2,'【综漫 ASMV】去爱','54','6:00','1','1','/static/videolook/videolookimg/5082973-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(3,'未闻花名 MAD 演唱会','34','8:00','1','1','/static/videolook/videolookimg/6130489-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(4,'【撸SIR谨制】野良神脑洞小剧场第12.5弹更新3P','212','3:00','1','1','/static/videolook/videolookimg/6760443-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(5,'【AMV】 好想大声说出来 ！！！','43','5:00','1','1','/static/videolook/videolookimg/7015300-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(6,'【LL】老司机带带我','44','3:00','1','1','/static/videolook/videolookimg/7190132-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(7,'【Re：从零开始的异世界生活/MAD】 傲慢与怠惰！！','444','4:00','1','2','/static/videolook/videolookimg/8980857-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(8,'【AMV】 战斗意志不灭 ！！！','123','3:00','1','2','/static/videolook/videolookimg/9325861-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(9,'未闻花名 secret base MAD','122','6:00','1','3','/static/videolook/videolookimg/10206688-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(10,'邪王真眼！这才是观看中二病的确方式','12','2:16','1','1','/static/videolook/videolookimg/zhongerbing.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(11,'【炮姐/AMV】我永远都会守护在你的身边！','32','5:00','1','2','/static/videolook/videolookimg/1176840-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(12,'迷你小炮姐-不上你的当','15','1:40','1','1','/static/videolook/videolookimg/paojie.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(13,'妹妹什么的最好了','1243','1:03','1','1','/static/videolook/videolookimg/meimeishenmedezuihaole.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(14,'【综漫治愈向】那句话 竟再也无法说出口','1123','5:20','1','1','/static/videolook/videolookimg/Av6716706.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(15,'【治愈向MAD】我只是很想见你','1123','3:39','1','1','/static/videolook/videolookimg/henxiangjianni.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(16,'【悠哉日常大王】请戴上耳机 感受听觉的莲华','12','4:03','1','3','/static/videolook/videolookimg/youzaidawang.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(17,'【野良神／后方高能】你的挫折，虽败犹荣','1123','3:12','1','3','/static/videolook/videolookimg/yeliangshen.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(18,'【完结纪念从零开始AMV】帅气又燃的扔出一只雷姆','12','3:12','1','1','/static/videolook/videolookimg/yishijieleimu.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(19,'【司徒单曲】多余的解释','12','4:26','1','1','/static/videolook/videolookimg/duoyudejieshi.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(20,'【全明星】告白气球-1.【全明星】告白气球','14','3:06','1','1','/static/videolook/videolookimg/gaobaiqiu.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(21,'【妹妹陪睡】德国骨科：这有个妹控摔倒了，非要妹妹陪睡才肯起来！','13','1:41','1','1','/static/videolook/videolookimg/deguowuke.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(22,'【你的名字/超清画质/1080p】歌曲','42','4:00','1','2','/static/videolook/videolookimg/13143927-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(23,'【龙与虎】因为有你，我依旧相信爱情','144','5:30','1','1','/static/videolook/videolookimg/longyuhu.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(24,' 克计划第2期】缘计划：医生我得了小缘病','155','1:05','1','1','/static/videolook/videolookimg/xiaoyuan.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(25,' 剧情向温馨治愈向】这无法恋爱的世界，摧毁了又如何？','133','4:33','1','2','/static/videolook/videolookimg/Av6716706.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(26,' 【ASMV综漫燃向】为了什么而战，为了变强，能保护你那么强','144','3:45','1','2','/static/videolook/videolookimg/weilebianqiang.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(27,' 【多素材催泪AMV】即便如此还是要向前迈进啊！','109','3:29','1','1','/static/videolook/videolookimg/ganghaoyujianni.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(28,' 【超燃AMV】这所谓的世界，不过是一场幻梦！！','178','1:45','1','1','/static/videolook/videolookimg/wuyu.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(29,' 【百部综漫AMV】电音激荡，燃息不止！！','156','3:47','1','1','/static/videolook/videolookimg/dianying.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(30,' MAD】刀剑神域×前前前世【RADWIMPS】-1.【MAD】ソードアート・オンライ','176','4:41','1','1','/static/videolook/videolookimg/daojian.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(31,' 【FATE综漫高燃微衔接】为何而战？','167','4:23','1','2','/static/videolook/videolookimg/weiheerzhan.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(32,' 【AMV治愈向春物】若能舍弃一切的话','17','4:29','1','1','/static/videolook/videolookimg/weilebianqiang.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(33,'【海妖】前前前世-中文抒情女声版-你的名字剧情','797','3:00','1','2','/static/videolook/videolookimg/13817402-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(34,' 【AMV小林家的龙女仆】康娜真是太可爱了~','789','1:07','1','1','/static/videolook/videolookimg/longnvpu.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(35,' 【AMV催泪】十年的期许 刚好遇见你-1.刚好遇见你','789','2:01','1','1','/static/videolook/videolookimg/ganghaoyujianni.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(36,' 【1080P】Shelter(避难所) OVA【中字】','78','6:06','1','1','/static/videolook/videolookimg/bilansuo.png','/static/videolook/2.mp4','1','1','004bcfc8d4bd407bb1a114785539006f','admin',NULL),(37,'未闻花名 secret base~你给我的所有~ ','78','2:00','1','3','/static/videolook/videolookimg/14779495-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(38,'【综漫 ASMV】 弱者（完整版）/The Weak (Full ver.)','67','10:00','1','3','/static/videolook/videolookimg/2931880-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(39,'未闻花名 secret base MAD','567','6:00','1','3','/static/videolook/videolookimg/3617382hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(40,'【综漫/AMV】绝不原谅！挣脱绝望的最后之战！','57','4:00','1','3','/static/videolook/videolookimg/4624196-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(41,'[FATE/MAD/燃爆]错的不是我，是这个世界 【影之歌】','567','4:00','1','3','/static/videolook/videolookimg/5076187-1-hd.png','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin',NULL),(49,'【中字PV_SC】#P对自家偶像的评价也太不得了了吧——闪耀色彩3.5周年纪念视频','114','5:14','1','2','/static/videolook/videolookimg/1663298210940.jpg','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f','admin','https://www.youtube.com/watch?v=yoGBXRpUwvw\r\n当初见到这个原版PV的时候真的被SC震撼到了，所以想试着自己复刻一下，如果你也能从这个视频了收获到些许的快乐甚至于成为你了解SC的契机那我将非常荣幸。也非常欢迎大家用这个视频去安利那些想要入坑sc的朋友。\r\n\r\nPS：由于本人文字功力与排版需求，文本经过一定程度的润色或修改，可能与原文有较大差异，敬请谅解\r\n\r\n水平有限，有错误或不适的地方欢迎大力指正'),(52,'Y2Mate.is - Cyberpunk Edgerunners','114','5:14','1','3','/static/videolook/videolookimg/1664525437383.jpg','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f',NULL,'ETA: September 13th on Netflix. Get. Ready.\r\n\r\nABOUT CYBERPUNK: EDGERUNNERS\r\nThe series tells a standalone, 10-episode story about a street kid trying to survive in Night City — a technology and body modification-obsessed city of the future. Having everything to lose, he stays alive by becoming an edgerunner — a mercenary outlaw also known as a cyberpunk.\r\n\r\nCD PROJEKT RED, the company behind the Cyberpunk 2077 video game, is producing the series with Rafał Jaki (The Witcher 3: Wild Hunt, Cyberpunk 2077, The Witcher: Ronin) as Showrunner and Executive Producer, with Satoru Homma, Bartosz Sztybor and Saya Elder serving as producers. The team at CD PROJEKT RED has been working on this new series since 2018. Acclaimed Japan-based animation company, Studio Trigger, will serve as the animation studio on the series and bring the world of Cyberpunk to life with their signature, vibrant style. Hiroyuki Imaishi (Gurren Lagann, Kill la Kill, Promare) will direct the series along with creative director Hiromi Wakabayashi (Kill la Kill), character designer and animation director Yoh Yoshinari (Little Witch Academia, BNA: Brand New Animal), and the adapted screenplay by Yoshiki Usa (GRIDMAN UNIVERSE series, Promare) and Masahiko Otsuka (Star Wars: Visions ‘The Elder’). The original score will be composed by Akira Yamaoka (Silent Hill series).'),(53,'【10月/中字首发/大河内一楼】机动战士高达 水星的魔女 正式PV2【MCE汉化组】','114','5:14','1','1','/static/videolook/videolookimg/1664527618506.jpg','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f',NULL,'官方\r\n小林宽×大河内一楼 10月新番《机动战士高达 水星的魔女》正式PV2公开！'),(54,'YOASOBI_祝福(Shukufuku)_Official_Music','114','5:14','1','2','/static/videolook/videolookimg/1664779775877.jpg','/static/videolook/2.mp4',NULL,NULL,'004bcfc8d4bd407bb1a114785539006f',NULL,'\r\n★YOASOBI (https://www.yoasobi-music.jp/)\r\nAyase (composer) / ikura (vocal)');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
