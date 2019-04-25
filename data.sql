DROP DATABASE IF EXISTS `ssm_lab`;

CREATE DATABASE `ssm_lab` /*!40100 COLLATE 'utf8_general_ci' */;
use `ssm_lab`;

-- 用户表
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `sn` char(8) NOT NULL COMMENT '教工号',
  `userName` varchar(25) NOT NULL COMMENT '教工姓名',
  `password` varchar(50) NOT NULL COMMENT '登录密码 默认：111111',
  `sex`  char(2) NOT NULL COMMENT '教工性别',
  `birthday` datetime NOT NULL COMMENT '出生日期',
  `technical` varchar(20) NOT NULL COMMENT '职称',
  `type` varchar(10) DEFAULT '' COMMENT '教师类型：理论教师|实验教师',
  `phone` varchar(50) DEFAULT '' COMMENT '电话号码',
  `email` varchar(50) DEFAULT '' COMMENT '电子邮件',
  `photo` varchar(50) DEFAULT '' COMMENT '照片',
  `role` char(1) NOT NULL COMMENT '用户角色 1 管理员 2 普通用户',
  `is_deleted` char(1) NOT NULL COMMENT '是否删除 1 已删除 2 正常使用',
  PRIMARY KEY (`sn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


INSERT INTO `tb_user` (`sn`, `userName`, `password`, `sex`, `birthday`, `technical`, `type`, `photo`, `role`, `is_deleted`) 
VALUES
('19940002','丁光惠','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','科长','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20131027','于恩淼','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副科长','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20020006','付勇智','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20040010','侯贸军','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20120006','兰建平','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20120031','刘俊','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20060016','刘凌云','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20010018','刘振章','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20111012','刘杰','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('19910004','刘林','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('19950042','刘美怡','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19940021','卢言','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','管理人员','userfiles/avatars/photo.jpg','0','0'),
('20030021','史小平','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19860009','史旅华','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20140016','叶金凤','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19970020','向郑涛','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20120015','吴岳敏','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('19960021','吴年志','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20130025','吴文欢','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20130008','吴浩然','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20020013','吴美霖','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20030029','周奎','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20130026','周海鹰','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20100007','唐海','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19820003','姜木霖','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20010043','孙剑萍','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19840013','孙希平','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19930009','张丽丽','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','科长','管理人员','userfiles/avatars/photo.jpg','0','0'),
('20010033','张吴波','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20010031','张涛','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20120018','张金亮','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19950016','彭强','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('19980017','彭彬','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20010004','徐洪胜','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20150008','徐金瑜','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20060018','徐龙艳','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20050004','文元雄','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20030015','方凯','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20150005','方胜利','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19940016','曹霞','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('19970025','朱贤臣','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19950023','李发海','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20060009','李学兵','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20020031','李学军','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19950013','李慧玲','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20000020','李贵荣','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19930005','李铁','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20010028','杨亚会','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19960005','杨毅','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20110016','柳祥乐','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19940017','柴旺兴','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('19970015','梁玉红','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20070014','梅建伟','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20070015','梅烨','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19950015','梅琴','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20060004','樊红莉','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20060014','江学焕','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20020005','湛柏明','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19830009','潘正清','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20000015','王卫华','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20050017','王思山','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20030006','王文燕','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20000003','王晓东','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19970019','王沛','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20020032','田丽娟','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副科长','管理人员','userfiles/avatars/photo.jpg','0','0'),
('19920002','田漫柳','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('19950024','田艳芳','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20020030','程登良','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20000026','缪勇','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20050034','罗敏','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20070026','翟亚红','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20010014','胡志慧','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20140022','胡舒乐','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19840012','苗暹','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20120029','董秀娟','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20010026','薛礼','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20020026','袁科','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19850014','裘子煦','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('19840018','许玲','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','科长','管理人员','userfiles/avatars/photo.jpg','0','0'),
('20120005','贾蓉','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19850022','赵文兵','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('19850021','赵榕','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20090022','郝夏艳','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20120020','陈凌云','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19970010','陈利','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20020002','陈劲松','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','高级实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('19960016','陈宇峰','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19960017','陈志楚','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20130020','陈欢欢','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','科长','管理人员','userfiles/avatars/photo.jpg','0','0'),
('20070002','陈艳海','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20150006','陈铭','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19970030','雷钧','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20130001','马彬','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20110011','马明','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('19820002','马春江','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20060017','马春艳','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','副教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20020035','高志敏','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','0','0'),
('20150013','魏本昌','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20120032','魏海波','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20070009','黄松柏','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19950012','黄海波','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','教授','理论教师','userfiles/avatars/photo.jpg','0','0'),
('20070008','黄连丽','66E01CC791F37FCC4676B29497A6137C','女','1997-06-22','讲师','理论教师','userfiles/avatars/photo.jpg','0','0'),
('19970016','齐心','66E01CC791F37FCC4676B29497A6137C','男','1997-06-22','实验师','实验教师','userfiles/avatars/photo.jpg','1','0');

-- 文章分类表
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `categoryName` varchar(64) NOT NULL COMMENT '分类名称',
  `description` varchar(250) DEFAULT NULL COMMENT '分类描述',
  `authority` char(1) DEFAULT '0' COMMENT '权限：1: 私密 0: 公开',
  `nums` int(11) DEFAULT 0 COMMENT '分类文章数量',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类表';

-- 文章内容表
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章id',
	`category_id` INT(11) NOT NULL COMMENT '分类id',
	`title` VARCHAR(100) NOT NULL COMMENT '文章标题',
	`content` LONGTEXT NOT NULL COMMENT '文章内容',
	`show_image` VARCHAR(100) DEFAULT NULL COMMENT '文章头图',
	`user_sn` char(8) NOT NULL COMMENT '作者',
	`create_time` DATETIME NOT NULL COMMENT '创建时间',
	`update_time` DATETIME COMMENT '更新时间',
	`hints` int(11) DEFAULT 0 COMMENT '访问量',
	PRIMARY KEY (`id`),
	INDEX `FKefps36p8dyf3t7yjmic1v0jcs` (`category_id`),
	INDEX `FKpxk2jtysqn41oop7lvxcp6dqq` (`user_sn`),
	CONSTRAINT `FKefps36p8dyf3t7yjmic1v0jcs` FOREIGN KEY (`category_id`) REFERENCES `tb_category` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT `FKpxk2jtysqn41oop7lvxcp6dqq` FOREIGN KEY (`user_sn`) REFERENCES `tb_user` (`sn`)  ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';

-- 触发器：插入或删除文章时更新分类文章的数量
delimiter $
DROP TRIGGER IF EXISTS t_category_insert; 
CREATE TRIGGER t_category_insert 
AFTER INSERT ON tb_article 
FOR EACH ROW
BEGIN  
UPDATE tb_category SET nums=nums+1 WHERE cid=NEW.category_id;
END$

delimiter $
DROP TRIGGER IF EXISTS t_category_delete; 
CREATE TRIGGER t_category_delete 
BEFORE DELETE ON tb_article 
FOR EACH ROW
BEGIN  
UPDATE tb_category SET nums=nums-1 WHERE cid=OLD.category_id;
END$

-- 实验室信息单页表
DROP TABLE IF EXISTS `tb_labinfo`;
CREATE TABLE `tb_labinfo` (
	`id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`title` VARCHAR(100) NOT NULL COMMENT '标题',
	`content` LONGTEXT NOT NULL COMMENT '内容',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实验室信息单页表';

INSERT INTO `tb_category` (`cid`, `categoryName`, `description`, `authority`) VALUES
	(1, '实验室新闻', '实验室日常新闻管理', '0'),
	(2, '实验室通知', '实验室日常通知管理', '0'),
	(3, '学校公文', '学校发布的公文信息管理', '0'),
	(4, '学院公文', '学院发布的公文信息管理', '0'),
	(5, '教学文章资料', '实验室教学资料内容管理', '0'),
	(6, '工作总结', '实验室工作总结汇总管理', '1');

-- 实验课程表
DROP TABLE IF EXISTS `tb_course`;
CREATE TABLE IF NOT EXISTS `tb_course` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `cno` char(6) NOT NULL COMMENT '课程编号',
  `cname` varchar(50) NOT NULL COMMENT '课程名称',
  `property` varchar(20) NOT NULL COMMENT '课程性质',
  `precourse` varchar(50) DEFAULT NULL COMMENT '先修课程',
  `totalperiod` tinyint(4) NOT NULL COMMENT '总学时数',
  `credit` float(4,1) NOT NULL COMMENT '学分',
  `theperiod` tinyint(4) NOT NULL COMMENT '理论学时',
  `expperiod` tinyint(4) NOT NULL COMMENT '实验学时',
  `level` varchar(10) NOT NULL COMMENT '适合层次',
  `specialty` varchar(80) NOT NULL COMMENT '适合专业',
  `content` longtext COMMENT '大纲内容',
  `dlurl` varchar(255) DEFAULT NULL COMMENT '大纲下载',
  `bookurl` varchar(255) DEFAULT NULL COMMENT '指导书下载',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程表';


INSERT INTO `tb_course` (`id`, `cno`, `cname`, `property`, `precourse`, `totalperiod`, `credit`, `theperiod`, `expperiod`, `level`, `specialty`, `content`, `dlurl`, `bookurl`) VALUES
	(1, '020720', 'Java程序设计', '专业基础课', '面向对象程序设计', 32, 2.0, 22, 10, '本科', '计算机科学与技术,软件工程等专业', '', '', ''),
	(2, '020470', '计算机网络B', '专业方向课', '电子技术,高级语言程序设计', 40, 2.5, 28, 12, '本科', '非计算机类专业', '', '', ''),
	(3, '020471', '计算机网络A', '专业方向课', '电子技术，高级语言程序设计', 56, 3.5, 38, 18, '本科', '计算机科学与技术，软件工程', '', '', ''),
	(4, '020420', 'C语言程序设计A', '公共基础课', '大学计算机基础', 64, 4.0, 40, 24, '本科', '电类专业', '', '', ''),
	(5, '020423', 'C语言程序设计B', '公共基础课', '大学计算机基础', 48, 3.0, 32, 16, '本科', '非典类理工科专业', '', '', ''),
	(6, '020620', '数据结构A', '专业基础课', '离散数学、C++程序设计', 64, 4.0, 48, 16, '本科', '计算机科学与技术、软件工程专业', '', '', ''),
	(7, '020621', '数据结构B', '专业基础课', 'C语言程序设计', 64, 4.0, 48, 16, '本科', '电子信息类相关专业', '', '', ''),
	(8, '020690', '面向对象程序设计', '专业基础课', 'C语言程序设计', 48, 3.0, 34, 14, '本科', '计算机科学与技术、软件工程专业、自动化、电气工程及其自动化等', '', '', ''),
	(9, '020630', '操作系统原理', '专业基础课', '数据结构', 64, 4.0, 52, 12, '本科', '计算机、软件工程、信息管理与信息系统、电子信息科学与技术', '', '', ''),
	(10, '020530', '多媒体技术', '专业基础课', '面向对象程序设计、计算机网络A、数据库系统原理', 32, 2.0, 26, 6, '本科', '计算机科学与技术、软件工程等专业', '', '', ''),
	(11, '020660', '编译原理', '专业基础课', '离散数学、高级语言程序设计、数据结构', 48, 3.0, 40, 8, '本科', '计算机科学与技术、软件工程专业', '', '', ''),
	(12, '170080', '嵌入式操作系统', '专业基础课', 'C语言程序设计、操作系统原理、计算机网络', 48, 3.0, 30, 18, '本科', '计算机科学与技术、自动化、电子信息工程', '', '', ''),
	(13, '020830', '计算机平面设计概论', '专业课', '大学计算机基础、计算机操作基础、多媒体技术', 32, 2.0, 14, 18, '本科', '软件工程', '', '', ''),
	(14, '020820', '计算机动画设计', '专业课', '计算机平面设计概论、计算机游戏构件设计概论', 32, 2.0, 14, 18, '本科', '软件工程', '', '', ''),
	(15, '020481', '计算机软件技术基础', '专业基础课', '计算机文化基础、C语言程序设计', 40, 2.5, 34, 6, '本科', '机械设计制造及其自动化,材料成型及控制工程,电气工程等专业', '', '', ''),
	(16, '020410', '计算方法', '学科基础课', '高等数学、线性代数、VC++程序设计', 40, 2.5, 28, 12, '本科', '计算机科学与技术、软件工程专业', '', '', ''),
	(17, '020650', '计算机图形学', '专业课', '高等数学、线性代数、数据结构、高级语言程序设计', 40, 2.5, 30, 10, '本科', '软件工程、计算机科学与技术', '', '', ''),
	(18, '020760', '计算机游戏构件设计', '专业课', '大学计算机基础', 32, 2.0, 12, 18, '本科', '软件工程', '', '', ''),
	(19, '020800', '软件项目管理', '专业基础课', '程序设计、软件工程导论', 32, 2.0, 26, 6, '本科', '软件工程', '', '', ''),
	(20, '020600', '数据库技术', '专业课', '计算机软件基础', 40, 2.5, 30, 10, '本科', '自动化、工业工程、电子科学与技术', '', '', ''),
	(21, '020640', '数据库系统原理', '专业课', '离散数学A、数据结构A', 48, 3.0, 38, 10, '本科', '计算机科学与技术、软件工程', '', '', ''),
	(22, '020700', '数据库系统实现', '专业方向课', '数据库系统原理、软件工程、JAVA程序设计', 40, 2.5, 24, 16, '本科', '软件工程、计算机科学与技术', '', '', ''),
	(23, '020730', '算法设计与分析', '学科基础课', '高等数学、高级语言程序设计、数据结构', 40, 2.0, 30, 10, '本科', '计算机科学与技术、软件工程专业', '', '', ''),
	(24, '020710', '网络程序设计', '专业方向课', '程序设计、数据库原理、计算机网络', 40, 2.5, 20, 20, '本科', '计算机软件及相关专业', '', '', ''),
	(25, '021070', 'UML建模技术', '专业方向课', '软件工程、面向对象程序设计', 32, 2.0, 16, 16, '本科', '软件工程、计算机科学与技术', '', '', ''),
	(26, '021060', '设计模式', '专业基础课', '面向对象程序设计、JAVA程序设计、UML建模技术', 40, 2.5, 24, 16, '本科', '软件工程、计算机科学与技术', '', '', ''),
	(27, '020400', '微机原理及应用A', '学科基础课', '数字电子技术基础', 72, 4.5, 60, 12, '本科', '自动化、电气工程及其自动化、电子信息科学、电子信息工程', '', '', ''),
	(28, '020403', '微机原理及应用A', '学科基础课', '数字电子技术基础', 64, 4.0, 52, 12, '本科', '自动化、电气工程及其自动化、电子信息科学、电子信息工程', '', '', ''),
	(29, '020402', '微机原理与接口技术', '专业基础课', '计算机组成原理', 72, 4.5, 54, 18, '本科', '计算机科学与技术、软件工程', '', '', ''),
	(30, '020460', '计算机组成原理', '学科基础课', '计算机组成原理', 72, 4.5, 54, 18, '本科', '计算机科学与技术、软件工程', '', '', ''),
	(31, '020830', '用户界面设计', '专业课', '大学计算机基础，多媒体技术', 32, 2.0, 14, 18, '本科', '计算机科学与技术、软件工程', '', '', ''),
	(32, '021360', '手机应用系统开发', '专业课', 'JAVA程序设计、数据库原理、计算机网络', 32, 2.0, 20, 12, '本科', '软件工程', '', '', ''),
	(33, '021400', '数据库系统原理与实现', '专业课', '数据结构，程序设计语言', 64, 4, 48, 16, '本科', '计算机科学与技术', '', '', ''),
	(34, '021590', '嵌入式系统原理与应用', '专业课', '微机原理与接口技术，嵌入式操作系统', 64, 4.0, 40, 24, '本科', '计算机科学与技术，自动化，电子信息工程', '', '', ''),
	(35, '020425', '高级语言程序设计II', '学科基础课', '计算机组成原理', 32, 2.0, 20, 12, '本科', '计算机科学与技术', '', '', ''),
	(36, '170022', '计算机技术', '公共基础课', '', 64, 4.0, 32, 24, '本科', '汽车类相关专业', '', '', ''),
	(37, '170070', '车载信息系统', '专业方向课', '计算机网络，嵌入式系统原理', 48, 3.0, 38, 10, '本科', '计算机科学与技术', '', '', ''),
	(38, '020404', '微机原理与接口技术B', '专业方向课', 'C语言、电子技术', 56, 3.5, 42, 14, '本科', '测控技术与仪器', '', NULL, NULL);
-- 实验项目表
DROP TABLE IF EXISTS `tb_courseitem`;
CREATE TABLE IF NOT EXISTS `tb_courseitem` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '实验项目id',
  `cid` int(10) NOT NULL COMMENT '实验课程id',
  `itemname` varchar(50) NOT NULL COMMENT '实验项目名称',
  `expdemand` varchar(20) NOT NULL COMMENT '实验项目要求',
  `expperiod` tinyint(4) NOT NULL COMMENT '实验学时',
  `exptype` varchar(20) NOT NULL COMMENT '实验类型',
  `content` longtext COMMENT '实验内容',
  PRIMARY KEY (`id`),
  INDEX `index_course_cid` (`cid`),
	CONSTRAINT `fk_course_cid` FOREIGN KEY (`cid`) REFERENCES `tb_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实验项目表';

INSERT INTO `tb_courseitem` (`cid`, `itemname`, `expdemand`, `expperiod`, `exptype`, `content`) VALUES
	(1, '实验一 Java编程环境使用', '必做', 2, '验证性', ''),
	(1, '实验二 Java类编程练习', '必做', 2, '验证性', ''),
	(1, '实验三 类的继承与派生', '必做', 2, '验证性', ''),
	(1, '实验四 图形用户界面设计', '必做', 2, '综合性', ''),
	(1, '实验五 Java事件处理', '必做', 2, '综合性', ''),
	(1, '实验六 多线程与网络程序设计', '必做', 2, '综合性', ''),
	(2, '实验一 建立对计算机网络的印象和RJ-45接口连线实验', '必做', 2, '验证性', ''),
	(2, '实验二 网络和协议配置及网络诊断实验', '必做', 2, '验证性', ''),
	(2, '实验三 交换机及基本配置实验', '必做', 2, '验证性', ''),
	(2, '实验四 路由器配置实验', '必做', 3, '综合性', ''),
	(2, '实验五 Socket支持下网上点对点通信的实现实验', '必做', 3, '综合性', ''),
	(3, '实验一 局域网组建、协议配置及网络诊断实验', '必做', 2, '验证性', ''),
	(3, '实验二 IEEE802标准和以太网仿真实验', '必做', 2, '验证性', ''),
	(3, '实验三 交换机及基本配置实验', '必做', 2, '验证性', ''),
	(3, '实验四 地址解析协议ARP仿真实验', '必做', 2, '验证性', ''),
	(3, '实验五 网际协议IP仿真实验', '必做', 3, '验证性', ''),
	(3, '实验六 路由器配置实验', '必做', 2, '综合性', ''),
	(3, '实验七 传输控制协议TCP仿真实验', '必做', 2, '验证性', ''),
	(3, '实验八 Socket支持下网上点对点通信的实现实验', '必做', 3, '综合性', ''),
	(4, '实验一 C语言环境实验', '必做', 2, '验证性', ''),
	(4, '实验二 简单程序设计实验', '必做', 2, '验证性', ''),
	(4, '实验三 分支程序设计实验', '必做', 2, '验证性', ''),
	(4, '实验四 循环程序设计实验', '必做', 2, '验证性', ''),
	(4, '实验五 数组程序设计实验', '必做', 2, '验证性', ''),
	(4, '实验六 函数程序设计实验', '必做', 2, '验证性', ''),
	(4, '实验七 指针程序设计实验', '必做', 2, '验证性', ''),
	(4, '实验八 结构体程序设计实验', '必做', 2, '验证性', ''),
	(4, '实验九 文件程序设计实验', '必做', 2, '验证性', ''),
	(4, '实验十 综合设计实验（1）', '必做', 4, '综合性', ''),
	(4, '实验十一 综合设计实验（2）', '必做', 2, '综合性', ''),
	(5, '实验一 C语言环境实验', '必做', 2, '验证性', ''),
	(5, '实验二 简单程序设计实验', '必做', 2, '验证性', ''),
	(5, '实验三 分支程序设计实验', '必做', 2, '验证性', ''),
	(5, '实验四 循环程序设计实验', '必做', 2, '验证性', ''),
	(5, '实验五 数组程序设计实验', '必做', 2, '验证性', ''),
	(5, '实验六 函数程序设计实验', '必做', 2, '验证性', ''),
	(5, '实验七 指针程序设计实验', '必做', 2, '验证性', ''),
	(5, '实验八 综合设计实验', '必做', 2, '综合性', ''),
	(6, '实验一 线性表基本操作的编程实现', '必做', 2, '验证性', ''),
	(6, '实验二 堆栈和队列基本操作的编程实现', '必做', 2, '验证性', ''),
	(6, '实验三 串基本操作的编程实现', '必做', 2, '验证性', ''),
	(6, '实验四 二维数组基本操作的编程实现', '必做', 2, '验证性', ''),
	(6, '实验五 二叉树基本操作的编程实现', '必做', 2, '验证性', ''),
	(6, '实验六 图基本操作的编程实现', '必做', 2, '验证性', ''),
	(6, '实验七 查找技术的编程实现', '必做', 2, '验证性', ''),
	(6, '实验八 排序技术的编程实现', '必做', 2, '验证性', ''),
	(7, '实验一 线性表基本操作', '必做', 2, '验证性', ''),
	(7, '实验二 栈和队列基本操作', '必做', 2, '验证性', ''),
	(7, '实验三 串基本操作', '必做', 2, '验证性', ''),
	(7, '实验四 二维数组基本操作', '必做', 2, '验证性', ''),
	(7, '实验五 二叉树基本操作', '必做', 2, '验证性', ''),
	(7, '实验六 图基本操作', '必做', 2, '验证性', ''),
	(7, '实验七 查找技术', '必做', 2, '综合性', ''),
	(7, '实验八 排序技术', '必做', 2, '综合性', ''),
	(8, '实验一 函数设计实验', '必做', 2, '验证性', ''),
	(8, '实验二 类程序设计实验', '必做', 2, '验证性', ''),
	(8, '实验三 数组与指针程序设计实验', '必做', 2, '验证性', ''),
	(8, '实验四 多态程序设计实验', '必做', 2, '验证性', ''),
	(8, '实验五 输入/输出流程序设计实验', '必做', 2, '验证性', ''),
	(8, '实验六 综合设计实验', '必做', 4, '综合性', ''),
	(9, '实验一 DOS系统调用实验', '必做', 2, '验证性', ''),
	(9, '实验二 熟悉Linux环境实验', '必做', 2, '验证性', ''),
	(9, '实验三 进程控制实验', '必做', 2, '验证性', ''),
	(9, '实验四 进程通信实验', '必做', 2, '验证性', ''),
	(9, '实验五 文件操作实验', '必做', 4, '综合性', ''),
	(10, '实验一 哈夫曼编码压缩数据', '选做', 3, '验证性', ''),
	(10, '实验二 使用PhotoShop进行图像处理', '选做', 3, '验证性', ''),
	(10, '实验三 编写Flash动画游戏', '选做', 3, '验证性', ''),
	(10, '实验四 使用JavaScript编写动态网页', '选做', 3, '验证性', ''),
	(10, '实验五 编写音频播放器', '选做', 3, '设计性', ''),
	(10, '实验六 编写图像处理系统', '选做', 3, '设计性', ''),
	(10, '实验七 设计开发基于多媒体数据库的应用系统', '选做', 3, '设计性', ''),
	(11, '实验一 词法分析器设计实验', '必做', 4, '综合性', ''),
	(11, '实验二 用递归下降法分析表达式实验', '选做', 4, '综合性', ''),
	(11, '实验三 用算符优先法分析表达式实验', '选做', 4, '综合性', ''),
	(12, '实验一 Linux命令使用', '必做', 2, '验证性', ''),
	(12, '实验二 vi编辑器的使用', '必做', 2, '验证性', ''),
	(12, '实验三 shell编程实验', '必做', 4, '综合性', ''),
	(12, '实验四 Linux开发工具的使用', '必做', 4, '验证性', ''),
	(12, '实验五 Linux编程实验', '必做', 4, '综合性', ''),
	(12, '实验六 Linux的系统及网络管理实验', '必做', 2, '验证性', ''),
	(13, '实验一 Photoshop CS4基本界面熟悉', '必做', 2, '验证性', ''),
	(13, '实验二 Photoshop CS4常用工具的使用', '必做', 4, '验证性', ''),
	(13, '实验三 图象和图层的处理', '必做', 4, '验证性', ''),
	(13, '实验四 各种滤镜方式的处理', '必做', 6, '验证性', ''),
	(13, '实验五 Photoshop CS4综合应用', '必做', 2, '综合性', ''),
	(14, '实验一 基本静态动画图形的绘制', '必做', 6, '验证性', ''),
	(14, '实验二 普通类动画的制作', '必做', 9, '验证性', ''),
	(14, '实验三 综合类动画的制作', '必做', 3, '综合性', ''),
	(15, '实验一 线性表／栈与队', '必做', 2, '验证性', ''),
	(15, '实验二 二叉树／查找／排序', '必做', 2, '验证性', ''),
	(15, '实验三 了解进程／数据库系统', '必做', 2, '验证性', ''),
	(16, '实验一 一元非线性方程求根的算法', '必做', 2, '综合性', ''),
	(16, '实验二 解线性方程组的直接方法', '必做', 2, '验证性', ''),
	(16, '实验三 解线性方程组的间接方法', '必做', 2, '验证性', ''),
	(16, '实验四 插值多项式的求法', '必做', 2, '验证性', ''),
	(16, '实验五 数值积分', '必做', 2, '验证性', ''),
	(16, '实验六 常微分方程的数值解', '必做', 2, '验证性', ''),
	(17, '实验一 熟悉Visual C++绘图应用程序的开发过程', '必做', 2, '验证性', ''),
	(17, '实验二 实现直线的生成算法', '必做', 2, '验证性', ''),
	(17, '实验三 实现圆的生成算法', '必做', 2, '验证性', ''),
	(17, '实验四 实现Bezier曲线的生成算法', '必做', 2, '验证性', ''),
	(17, '实验五 实现多边形的种子填充算法', '必做', 2, '验证性', ''),
	(18, '实验一 认识3DS MAX环境，创建简单实体，编辑实体', '必做', 3, '验证性', ''),
	(18, '实验二 使用材质修饰实体', '必做', 3, '验证性', ''),
	(18, '实验三 学用灯光，学用摄像机', '必做', 3, '验证性', ''),
	(18, '实验四 环境设置', '必做', 3, '验证性', ''),
	(18, '实验五 制作动画', '必做', 3, '综合性', ''),
	(18, '实验六 综合运用', '必做', 3, '综合性', ''),
	(19, '实验一 熟识一款通用项目管理软件的基本功能', '必做', 2, '验证性', ''),
	(19, '实验二 应用通用项目管理软件', '必做', 4, '综合性', ''),
	(20, '实验一 关系数据库标准语言SQL', '必做', 4, '验证性', ''),
	(20, '实验二 数据库设计', '必做', 2, '验证性', ''),
	(20, '实验三 数据库应用技术', '必做', 4, '综合性', ''),
	(21, '实验一 关系数据库标准语言SQL', '必做', 2, '验证性', ''),
	(21, '实验二 数据库安全性技术', '必做', 2, '综合性', ''),
	(21, '实验三 数据库完整性技术', '必做', 2, '综合性', ''),
	(21, '实验四 数据库设计', '必做', 2, '验证性', ''),
	(21, '实验五 数据库恢复技术', '必做', 2, '验证性', ''),
	(21, '实验六 数据库编程', '选做', 2, '验证性', ''),
	(22, '实验一 JDBC应用程序设计', '必做', 2, '验证性', ''),
	(22, '实验二 GUI图像用户界面设计', '必做', 2, '验证性', ''),
	(22, '实验三 简单WEB应用程序设计', '必做', 2, '验证性', ''),
	(22, '实验四 存储子程序', '必做', 2, '验证性', ''),
	(22, '实验五 触发器', '必做', 2, '验证性', ''),
	(22, '实验六 C/S架构应用程序', '必做', 3, '综合性', ''),
	(22, '实验七 B/S架构应用程序', '必做', 3, '综合性', ''),
	(23, '实验一 分治与递归', '必做', 2, '验证性', ''),
	(23, '实验二 贪心算法', '必做', 2, '验证性', ''),
	(23, '实验三 动态规划法', '必做', 2, '验证性', ''),
	(23, '实验四 回溯法与分支限界法', '必做', 4, '综合性', ''),
	(24, '实验一 委托与事件', '必做', 3, '验证性', ''),
	(24, '实验二 控件应用', '必做', 3, '验证性', ''),
	(24, '实验三 ADO.NET编程', '必做', 2, '验证性', ''),
	(24, '实验四 开发tcp同步和异步套接字点对点通信/开发UDP点对点、组播程序', '必做', 4, '综合性', ''),
	(24, '实验五 FTP协议开发/SMTP、POP3协议开发', '必做', 4, '综合性', ''),
	(24, '实验六 基于组件的开发技术', '必做', 2, '验证性', ''),
	(24, '实验七 web service的开发与应用', '必做', 2, '验证性', ''),
	(25, '实验一 熟悉Rational Rose建模环境', '必做', 2, '验证性', ''),
	(25, '实验二 Use Case 分析与设计', '必做', 2, '设计性', ''),
	(25, '实验三 顺序图建模', '必做', 2, '设计性', ''),
	(25, '实验四 类分析与包、设计类图与分析', '必做', 2, '设计性', ''),
	(25, '实验五 数据建模', '必做', 2, '设计性', ''),
	(25, '实验六 状态图与活动图', '必做', 2, '设计性', ''),
	(25, '实验七 构件图和部署图建模', '必做', 2, '设计性', ''),
	(25, '实验八 UML与设计模式', '必做', 2, '设计性', ''),
	(26, '实验一 创建型设计模式－单例模式', '必做', 2, '验证性', ''),
	(26, '实验二 创建型设计模式－工厂模式', '必做', 4, '综合性', ''),
	(26, '实验三 结构型设计模式－代理模式', '必做', 2, '验证性', ''),
	(26, '实验四 结构型设计模式－适配器模式', '必做', 4, '验证性', ''),
	(26, '实验五 行为型设计模式－观察者模式', '必做', 4, '综合性', '');

-- 物品借用表
DROP TABLE IF EXISTS `tb_borrow`;
CREATE TABLE IF NOT EXISTS `tb_borrow` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '物品名称',
  `num` tinyint(4) NOT NULL COMMENT '借用数量',
  `unit` char(2) NOT NULL COMMENT '单位',
  `borrow_time` DATETIME NOT NULL COMMENT '借用时间',
  `return_time` DATETIME COMMENT '归还时间',
  `borrow_sn` char(8) NOT NULL COMMENT '借用人',
  `borrow_handle_sn` char(8) NOT NULL COMMENT '借用经手人',
  `return_handle_sn` char(8) DEFAULT NULL COMMENT '归还经手人',
  `remarks` varchar(250) COMMENT '备注',
  `flag` char(1) DEFAULT '0' COMMENT '是否归还：0-未归还 1-已归还',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_borrow_sn` FOREIGN KEY (`borrow_sn`) REFERENCES `tb_user` (`sn`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_borrow_handle_sn` FOREIGN KEY (`borrow_handle_sn`) REFERENCES `tb_user` (`sn`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_return_handle_sn` FOREIGN KEY (`return_handle_sn`) REFERENCES `tb_user` (`sn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物品借用表';

INSERT INTO `tb_borrow` (`name`, `num`, `unit`, `borrow_time`, `return_time`, `borrow_sn`, `borrow_handle_sn`, `return_handle_sn`, `remarks`, `flag`) VALUES
	('S6305钥匙', 1, '把', '2019-03-24 23:01:09', '2019-03-24 23:03:38', '20070026', '19970016', '20010043', NULL, '1'),
	('示波器', 1, '台', '2019-03-24 23:02:49', NULL, '20070008', '19970016', NULL, NULL, '0'),
	('S6307钥匙', 1, '把', '2019-02-24 23:02:49', NULL, '20070008', '19970016', NULL, NULL, '0');

-- 实验工作量表
DROP TABLE IF EXISTS `tb_experiment_workload_item`;
DROP TABLE IF EXISTS `tb_experiment_workload`;
CREATE TABLE `tb_experiment_workload` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `term` varchar(20) NOT NULL COMMENT '学期',
  `workload_type` varchar(10) NOT NULL COMMENT '类型： 本部/科院',
  `cid` int(10) NOT NULL COMMENT '课程id',
  `classes` varchar(200) NOT NULL COMMENT '班级',
  `stu_numbers` int(11) NOT NULL COMMENT '总人数',
  `class_numbers` double(10,2) DEFAULT NULL COMMENT '班级数(计算)',
  `lab_workload` double(10,2) DEFAULT NULL COMMENT '实验工作量',
  `pre_workload` double(10,2) DEFAULT NULL COMMENT '准备工作量',
  `total_workload` double(10,2) DEFAULT NULL COMMENT '总工作量',
  `deduct_pre_workload_rate` tinyint(4) DEFAULT NULL COMMENT '扣除准备工作量_比例',
  `deduct_pre_workload` double(10,2) DEFAULT NULL COMMENT '扣除准备工作量',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_experiment_workload_cid` FOREIGN KEY (`cid`) REFERENCES `tb_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作量表';


-- 实验工作量明细表
CREATE TABLE `tb_experiment_workload_item` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `experiment_workload_id` int(10) NOT NULL COMMENT '实验工作量id',
  `teacher_sn` char(8) DEFAULT NULL COMMENT '任课教师职工号',
  `teacher_workload_rate` tinyint(4) DEFAULT NULL COMMENT '教师工作量比例',
  `teacher_workload` double(10,2) DEFAULT NULL COMMENT '教师工作量',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_experiment_workload_id` FOREIGN KEY (`experiment_workload_id`) REFERENCES `tb_experiment_workload` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_experiment_workload_teacher_sn` FOREIGN KEY (`teacher_sn`) REFERENCES `tb_user` (`sn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作量明细表';

-- 实践课程表
DROP TABLE IF EXISTS `tb_practice_workload_item`;
DROP TABLE IF EXISTS `tb_practice_workload`;
DROP TABLE IF EXISTS `tb_practice_course`;
CREATE TABLE IF NOT EXISTS `tb_practice_course` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `cno` char(6) NOT NULL COMMENT '课程编号',
  `cname` varchar(50) NOT NULL COMMENT '课程名称',
  `property` varchar(20) NOT NULL COMMENT '课程性质: 集中实践环节',
  `level` varchar(10) NOT NULL COMMENT '适合层次',
  `specialty` varchar(80) COMMENT '适合专业',
  `content` longtext COMMENT '大纲内容',
  `dlurl` varchar(255) COMMENT '大纲下载',
  `bookurl` varchar(255) COMMENT '指导书下载',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实践课程表';

INSERT INTO `tb_practice_course` (`id`, `cno`, `cname`, `property`, `level`, `specialty`, `content`, `dlurl`, `bookurl`) VALUES
	(1, '028060', '数据结构课程设计', '学科基础课', '本科', '计算机科学与技术，软件工程，电子信息类相关专业', '', NULL, NULL),
	(2, '028040', '计算机组成原理课程设计', '集中实践环节', '本科', '计算机科学与技术、软件工程等专业', '', NULL, NULL),
	(3, '028020', '面向对象程序设计课程设计', '集中实践环节', '本科', '计算机科学与技术、软件工程、信息管理与信息系统，电子信息科学与技术', '', NULL, NULL),
	(4, '028070', '数据库系统实现课程设计', '集中实践环节', '本科', '软件工程', '', NULL, NULL),
	(5, '028101', '微机原理与接口技术课程设计', '集中实践环节', '本科', '计算机科学与技术、软件工程', '', NULL, NULL),
	(6, '028130', '计算机专业认识实习', '集中实践环节', '本科', '计算机科学与技术', '', NULL, NULL),
	(7, '028210', '计算机专业实习', '集中实践环节', '本科', '计算机科学与技术', '', NULL, NULL),
	(8, '028280', '软件工程课程设计', '集中实践环节', '本科', '计算机科学与技术、软件工程及相关专业', '', NULL, NULL),
	(9, '028290', '软件工程专业认识实习', '集中实践环节', '本科', '软件工程', '', NULL, NULL),
	(10, '028300', '软件工程专业实习', '集中实践环节', '本科', '软件工程', '', NULL, NULL),
	(11, '028430', '计算机网络课程设计', '集中实践环节', '本科', '计算机科学与技术、软件工程及相关专业', '', NULL, NULL),
	(12, '028480', '嵌入式系统开发实训', '集中实践环节', '本科', '计算机科学与技术', '', NULL, NULL),
	(13, '028600', '设计模式课程设计', '集中实践环节', '本科', '软件工程', '', NULL, NULL),
	(14, '028610', 'Java程序设计课程设计', '集中实践环节', '本科', '软件工程', '', NULL, NULL),
	(15, '028611', 'Java程序设计实训', '集中实践环节', '本科', '计算机科学与技术', '', NULL, NULL),
	(16, '028620', '汽车工业信息化软件开发实践', '集中实践环节', '本科', '计算机软件及相关专业', '', NULL, NULL),
	(17, '028830', 'UML建模技术课程设计', '集中实践环节', '本科', '软件工程', '', NULL, NULL),
	(18, '028840', 'C语言程序设计实训', '集中实践环节', '本科', '计算机科学与技术、软件工程等', '', NULL, NULL),
	(19, '028841', 'C语言程序设计课程设计', '集中实践环节', '本科', '大电类工科专业', '', NULL, NULL),
	(20, '028931', '汽车产业信息技术实训', '集中实践环节', '本科', '计算机科学与技术、软件工程等专业', '', NULL, NULL),
	(21, '028950', '软件设计课程综合实训', '集中实践环节', '本科', '计算机科学与技术', '', NULL, NULL),
	(22, '178011', '车载信息系统实训', '集中实践环节', '本科', '软件工程、计算机科学与技术', '', NULL, NULL),
	(23, '028100', '微机原理及应用A课程设计', '集中实践环节', '本科', '自动化、电气工程及其自动化、电子信息科学、电子信息工程', '', NULL, NULL);

-- 实践工作量表
CREATE TABLE `tb_practice_workload` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `term` varchar(20) NOT NULL COMMENT '学期',
  `workload_type` varchar(10) NOT NULL COMMENT '工作量类型： 本部/科院',
  `practice_type` varchar(20) NOT NULL COMMENT '实践类型： 课程设计/校内实习/校外实习',
  `workload_property` varchar(20) NOT NULL COMMENT '工作量性质： 正常/插班重修',
  `cid` int(10) NOT NULL COMMENT '课程id',
  `week_numbers` double(10,2) NOT NULL COMMENT '周数',
  `stu_numbers` int(11) NOT NULL COMMENT '人数',
  `class_numbers` double(10,2) COMMENT '班级数(计算)',
  `total_workload` double(10,2) COMMENT '总工作量',
  `pre_workload_rate` tinyint(4) COMMENT '准备工作量_比例',
  `pre_workload` double(10,2) COMMENT '准备工作量',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_practice_workload_cid` FOREIGN KEY (`cid`) REFERENCES `tb_practice_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实践工作量表';


-- 实践工作量明细表
CREATE TABLE `tb_practice_workload_item` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `practice_workload_id` int(10) NOT NULL COMMENT '实践工作量id',
  `teacher_sn` char(8) COMMENT '任课教师职工号',
  `teacher_workload_rate` tinyint(4) COMMENT '教师工作量比例',
  `teacher_workload` double(10,2) COMMENT '教师工作量',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_practice_workload_id` FOREIGN KEY (`practice_workload_id`) REFERENCES `tb_practice_workload` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_practice_workload_teacher_sn` FOREIGN KEY (`teacher_sn`) REFERENCES `tb_user` (`sn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实践工作量明细表';

-- 工作情况记录表
DROP TABLE IF EXISTS `tb_work_record`;
CREATE TABLE `tb_work_record` (
	`id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`content` varchar(300) NOT NULL COMMENT '工作内容',
	`user_sn` char(8) NOT NULL COMMENT '记录人',
	`create_time` DATETIME NOT NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)	
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作情况记录表';