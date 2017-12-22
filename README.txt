目前代码版本：1.0
初始版1.0：参考如下链接实现的Spring 4.3 + Spring MVC + Hibernate 4.2 + Maven代码框架。支持restful。
http://blog.csdn.net/js931178805/article/details/39642743
http://blog.csdn.net/js931178805/article/details/39643981


说明：
1. 本地需要安装MySql，且MySql服务已经启动。注意检查config.properties文件中的数据库连接串信息是否配置正确
2. 执行如下SQL预计新建所需要的user数据库表

/*
Navicat MySQL Data Transfer

Source Server         : local_mysql
Source Server Version : 50638
Source Host           : localhost:3306
Source Database       : sshf

Target Server Type    : MYSQL
Target Server Version : 50638
File Encoding         : 65001

Date: 2017-12-21 19:32:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `age` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

3. 将ssh_arch项目部署到tomcat, 通过访问URL：http://localhost:8080/ssh_arch/user/create_user 即可向数据库插入一条数据
      通过访问URL:http://localhost:8080/ssh_arch/user/count 即可查询user表中有多少条数据 以此检验项目是否运行成功。
