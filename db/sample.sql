-- MariaDB dump 10.19  Distrib 10.5.9-MariaDB, for osx10.16 (x86_64)
--
-- Host: localhost    Database: general_reading_system
-- ------------------------------------------------------
-- Server version	10.5.9-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account_book_index`
--

DROP TABLE IF EXISTS `account_book_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_book_index` (
  `id` varchar(128) NOT NULL,
  `account_id` varchar(128) NOT NULL,
  `book_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_book_index`
--

LOCK TABLES `account_book_index` WRITE;
/*!40000 ALTER TABLE `account_book_index` DISABLE KEYS */;
INSERT INTO `account_book_index` VALUES ('047bc2641a4844b0b038fda804f95933','10000','dce7ac00b74e425b82f31b2e3e90fac2'),('181447c1614c4540bcf6bb3faf07a2ee','10000','3bee69b0d36d46e8b14c30dcb13775c2'),('4078675460824361a5c414a0c75d81d0','10000','bbfe78691897488a9f7506fd394974c2'),('467e2f0db15f42a4bef6e60d0e4a3f10','10000','9b53736bf8584c1eb221f7d2b4bf9e6b'),('5e38a6b9c63b4b7f8b5fd016301bb174','10000','30ce0e89282c4f3d99b6bc1d5cb99afb'),('5eebab71d8eb4b118ceadd4bf9f6b974','10000','5290326704ec44869f980d57a362c305'),('5f213c693f324a22b8212aa04b2fdb95','10000','3742a477b32445e8952175efd131f44b'),('698d3414dc274731946e23991242c1a2','10000','c7204693bff54c4a9c55ff5d13ae2a34'),('6ca59f24b93a43b9a292bfdcec78685b','10000','13efac074436493980ce1d1153004730'),('70a4c09f30b040149be9e117e5bb5254','10000','2f210345ea2944b68a184b4be6ff6644'),('74f331f06a0740c3a842095f00cd81ee','10000','7be03df0f92c49d689311cff03d55192'),('803364fd0f154f98b09e22f791268aa7','10000','07c7c9bc06944c6bb71097500fc26194'),('aafc3f624ace40b4946d3096723eda3f','10000','bdf1f2d1237f4606bc952e7dcbe69042'),('e28883435cd4403d83bb23b848d25c3e','10000','c7e150c83c724070b12ae93e2474655d'),('e897e1debd4a47a894954345831f1e6f','10000','0c1ce0d83065439aad31f137e32dbe20'),('f162b2944e954d25a6ff5ef6700e47b6','10000','1debb16247b04e9cac67d54ab9bdd059'),('f5cb9536c426419b85f5bc5b980cd112','10000','43e82f91e3a04ff8b2b280f3c096b198');
/*!40000 ALTER TABLE `account_book_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_user`
--

DROP TABLE IF EXISTS `account_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_user` (
  `id` varchar(128) NOT NULL,
  `user_name` varchar(64) DEFAULT NULL,
  `user_certification` varchar(1024) DEFAULT NULL,
  `user_type` varchar(8) DEFAULT NULL,
  `user_security_key` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_user`
--

LOCK TABLES `account_user` WRITE;
/*!40000 ALTER TABLE `account_user` DISABLE KEYS */;
INSERT INTO `account_user` VALUES ('10000','Shuheng Zhang',NULL,'admin',NULL),('138f2aeb4d404863b5cb8cfeb7c5d378','root','root','root',NULL);
/*!40000 ALTER TABLE `account_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_bookmark_index`
--

DROP TABLE IF EXISTS `book_bookmark_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_bookmark_index` (
  `id` varchar(128) NOT NULL,
  `book_id` varchar(128) DEFAULT NULL,
  `bookmark_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_bookmark_index`
--

LOCK TABLES `book_bookmark_index` WRITE;
/*!40000 ALTER TABLE `book_bookmark_index` DISABLE KEYS */;
INSERT INTO `book_bookmark_index` VALUES ('30f644b53ecf4db5af791726459f0e65','07c7c9bc06944c6bb71097500fc26194','d6b4d2b6f2b2464aa155dcb865c34f46'),('4bb2f8cf37ed4213a477ad93e6b9ffbc','07c7c9bc06944c6bb71097500fc26194','119da40551474907a10270f5cfa29b64'),('5bbce05cfdc04d4cbe28d1bb55348c3f','07c7c9bc06944c6bb71097500fc26194','cbd64f510937492d85e929fa5c1d7c31'),('6c407c5cdd3a40028c07dcf473f66db3','07c7c9bc06944c6bb71097500fc26194','c9e7ceef4d0b45e98918096ebe856ad4'),('93ace6aed89f438f9f07dd2b8be449b8','07c7c9bc06944c6bb71097500fc26194','3000a817c2d2451b8b57c6964e8e56a0'),('b40cec5c14b243d4be77ab950d6c5989','07c7c9bc06944c6bb71097500fc26194','2f74a71cc7cc4f97a3b48a13c9f5a10c');
/*!40000 ALTER TABLE `book_bookmark_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_config_index`
--

DROP TABLE IF EXISTS `book_config_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_config_index` (
  `id` varchar(128) NOT NULL,
  `book_id` varchar(128) DEFAULT NULL,
  `config_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_config_index`
--

LOCK TABLES `book_config_index` WRITE;
/*!40000 ALTER TABLE `book_config_index` DISABLE KEYS */;
/*!40000 ALTER TABLE `book_config_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_progress_index`
--

DROP TABLE IF EXISTS `book_progress_index`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_progress_index` (
  `id` varchar(128) NOT NULL,
  `book_id` varchar(128) DEFAULT NULL,
  `progress_id` varchar(128) DEFAULT NULL,
  `updated_time` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_progress_index`
--

LOCK TABLES `book_progress_index` WRITE;
/*!40000 ALTER TABLE `book_progress_index` DISABLE KEYS */;
INSERT INTO `book_progress_index` VALUES ('4e23584e7b3643b385eb4171e60d1602','07c7c9bc06944c6bb71097500fc26194','447fa44843244eada3cc2f61762eeb31','2021-06-06 21:01:40');
/*!40000 ALTER TABLE `book_progress_index` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_book`
--

DROP TABLE IF EXISTS `general_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `general_book` (
  `id` varchar(128) NOT NULL,
  `book_title` varchar(512) DEFAULT NULL,
  `book_authors` varchar(512) DEFAULT NULL,
  `book_description` longtext DEFAULT NULL,
  `book_cover_url` longtext DEFAULT NULL,
  `book_size` varchar(32) DEFAULT NULL,
  `book_pushed_time` varchar(32) DEFAULT NULL,
  `book_file_url` longtext DEFAULT NULL,
  `book_opf_url` longtext DEFAULT NULL COMMENT 'OPF资源索引文件相对路径',
  `book_unpacked_dir_url` longtext DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_book`
--

LOCK TABLES `general_book` WRITE;
/*!40000 ALTER TABLE `general_book` DISABLE KEYS */;
INSERT INTO `general_book` VALUES ('07c7c9bc06944c6bb71097500fc26194','机巧少女不会受伤 2','海冬レイジ, ','机巧魔法——那是内置魔法回路的人偶和人偶师使用的魔法。作为这方面的最高学府英国瓦尔普吉斯之夜皇家机巧学院现在正在举办名为「夜会」的比赛，决出最强人偶师——「魔王」。此时，两个人影在校门口徘徊，那是从日本来的留学生雷真和他的少女型人偶搭档——夜夜。雷真决定从参赛候选人那里用武力夺取夜会的参加资格。他的目标就是下任魔王的热门候补，拥有「暴龙」名号的美少女夏儿！但是正在雷真向她挑战的时候，意想不到的事情发生了……？学院战斗正式开始！','/10000/covers/0477744a001a477a89d91d4c78b03caf.jpg','6.58M','2021-06-05 12:09:42','/10000/epub/6cc1009eef1546578a92183967b79eda.epub','/10000/unpack/6cc1009eef1546578a92183967b79eda/OPS/fb.opf','/10000/unpack/6cc1009eef1546578a92183967b79eda'),('0c1ce0d83065439aad31f137e32dbe20','机巧少女不会受伤 12','海冬レイジ, ','机巧魔术——那是由内置魔术回路的自动人偶与人偶使所使用的魔术。雷真虽在日轮帮助下苟且一生，但是醒来时夜夜性命的时限已过——“夜夜怎么样了！？”“对不起。我……将夜夜小姐……”\n另一方面，学院则是由王妃格洛丽亚担任了新学院长一职。学院被英国所掌握，开始进行起将阿斯拉推为魔王的谋略。在这么个状况下，被杀害姐姐而受复仇心驱使的洛基独自一人伺机准备反击……！当硝子秘密的过去得到明了的时候，少女们明白了雪月花诞生的【意义】——！学园战斗交响曲！','/10000/covers/07740d1f6872404e8544ffd93475b237.jpg','6.96M','2021-06-05 12:09:46','/10000/epub/25eeb1d90675400fac4ed1702fad9585.epub','/10000/unpack/25eeb1d90675400fac4ed1702fad9585/OPS/fb.opf','/10000/unpack/25eeb1d90675400fac4ed1702fad9585'),('13efac074436493980ce1d1153004730','[机巧少女][VOL.1]','海冬レイジ, ','','/10000/covers/b3562be03ce94d54b92f1400fac700c2.jpg','6.90M','2021-06-05 12:09:41','/10000/epub/3d2dbe0eebda44ee8fa29b1ada7c6759.epub','/10000/unpack/3d2dbe0eebda44ee8fa29b1ada7c6759/OPS/fb.opf','/10000/unpack/3d2dbe0eebda44ee8fa29b1ada7c6759'),('1debb16247b04e9cac67d54ab9bdd059','机巧少女不会受伤 5','海冬レイジ, ','机巧魔术——那是只有内藏魔术回路的自动人偶和人偶师才能使用的魔术。机巧都市利物浦正因为在准备明天的自动人偶祭典而欢腾着。另一方面，却发生了<夜会>的参加者陆续失踪的事件。而雷真奉硝子之命前去和掌握着事件关键的人偶师·艾莉安蒂教授接触。但是，她居然是个和雷真同样年纪的少女（虽然是全裸加白大褂！）！为了让雷真把夜夜让给自己，她使出了各种各样的手段——？！「果然……不献出身体不行？」「献出身体也不行！」交响曲风学院战斗动作剧第5弹！','/10000/covers/c50121bbc7c249a49d95927206a20bce.jpg','2.42M','2021-06-05 12:09:43','/10000/epub/356fe85b679f4b598e4d00c47662ac29.epub','/10000/unpack/356fe85b679f4b598e4d00c47662ac29/OPS/fb.opf','/10000/unpack/356fe85b679f4b598e4d00c47662ac29'),('2f210345ea2944b68a184b4be6ff6644','机巧少女不会受伤 3','海冬レイジ, ','机巧魔法——那是内置魔法回路的人偶和人偶师使用的魔法。作为这方面的最高学府英国瓦尔普吉斯之夜皇家机巧学院现在正在举办名为「夜会」的比赛，决出最强人偶师——「魔王」。此时，两个人影在校门口徘徊，那是从日本来的留学生雷真和他的少女型人偶搭档——夜夜。雷真决定从参赛候选人那里用武力夺取夜会的参加资格。他的目标就是下任魔王的热门候补，拥有「暴龙」名号的美少女夏儿！但是正在雷真向她挑战的时候，意想不到的事情发生了……？学院战斗正式开始！','/10000/covers/a5dc625d26c74bd0979d6061089f1b65.jpg','5.07M','2021-06-05 12:09:42','/10000/epub/7baeb9dfeb254f639b00439d8ec62035.epub','/10000/unpack/7baeb9dfeb254f639b00439d8ec62035/OPS/fb.opf','/10000/unpack/7baeb9dfeb254f639b00439d8ec62035'),('30ce0e89282c4f3d99b6bc1d5cb99afb','机巧少女不会受伤 第8卷','海冬レイジ, ','机巧魔术，那是人偶师通过内置魔法回路的人偶使用的魔法。「如果日轮赢了的话，就请让我做雷真大人的妻子吧！」说着这样的话站在雷真面前的是〈十三人〉中的一位，是雷真未婚妻·日轮。面对为了追逐雷真甚至跨海而来的日轮（吐个槽：追你到天涯海角啊！情深似海啊！夜夜！你……不要再执着雷真了，多少汉纸望着你呢啊/泪目...），夜夜完全无法掩饰自己的嫉妒和对抗心（夜夜...）。与此同时，为了阻止雷真一行在夜会的不断前进，以学生代表奥尔加为首的〈十三人〉都自降排名，各自开始组织自己的军队。另一方面，似乎又有谁的的魔爪迫近了日轮的周围……！？学园战斗交响曲第8弹！','/10000/covers/06b0cc6915fd4f5abbef0e5505b771ef.jpg','3.39M','2021-06-05 12:09:44','/10000/epub/dc132244a0c74022830e47cf9b176a2c.epub','/10000/unpack/dc132244a0c74022830e47cf9b176a2c/OPS/fb.opf','/10000/unpack/dc132244a0c74022830e47cf9b176a2c'),('3742a477b32445e8952175efd131f44b','机巧少女不会受伤15 Facing \"Machine doll Ⅰ\"','海东零儿, ','','/10000/covers/907d5824d41f4ce78f153a92021119d9.jpg','6.78M','2021-06-05 12:09:50','/10000/epub/6bfc6f7c028c4e209aa032b5be9b0a5d.epub','/10000/unpack/6bfc6f7c028c4e209aa032b5be9b0a5d/OPS/fb.opf','/10000/unpack/6bfc6f7c028c4e209aa032b5be9b0a5d'),('3bee69b0d36d46e8b14c30dcb13775c2','机巧少女不会受伤 4','[海冬レイジ, ','机巧魔术——那是魔术回路内置自动跟人偶内，让人偶使用魔法的技术。时计塔事件也告一段落,雷真拖着受伤的身体和夜夜一起参加〈夜会〉并成功险胜。但是, 把雷真的负伤当成自己过错的夜夜,突然失踪了。好不容易找到她的雷真,却发现这一切都是敌人的圈套! 夜夜与自称为了支配〈夜会〉而存在的十字架的骑士一起赶往雷真身边。被打倒的雷真面前，出现了是硝子，硝子告诉他——“放弃夜夜吧。现在开始使用いろり来战斗。”然而雷真决断是!?','/10000/covers/90f0188bc36b49f4b3eb382bb07d17ec.jpg','2.66M','2021-06-05 12:09:43','/10000/epub/63a924a472e74668a5b51e2bdec9acb7.epub','/10000/unpack/63a924a472e74668a5b51e2bdec9acb7/OPS/fb.opf','/10000/unpack/63a924a472e74668a5b51e2bdec9acb7'),('43e82f91e3a04ff8b2b280f3c096b198','机巧少女不会受伤13','海冬零儿, ','机巧魔术——那是由内藏魔术回路的“自动人偶”与“人偶使”所使用的魔术。在英国最高学府的华尔普吉斯皇家机巧学院里，正举行着一场选出顶尖人偶使“魔王”的战斗“夜会”。来自日本的留学生雷真和他的搭档——少女型态的人偶夜夜，为了参加“夜会”，打算挑战其他入选者，夺取对方的资格。他们锁定的目标是下届魔王呼声极高的候选人，别名“暴龙”的美少女夏儿！然而就在雷真向她挑战时，突然出现意外的伏兵……？','/10000/covers/8f8467c283644536b867bbca92aae8e6.jpg','18.24M','2021-06-05 12:09:48','/10000/epub/a32e6c9b70fe47e1b3192ffa5185ff09.epub','/10000/unpack/a32e6c9b70fe47e1b3192ffa5185ff09/OPS/fb.opf','/10000/unpack/a32e6c9b70fe47e1b3192ffa5185ff09'),('5290326704ec44869f980d57a362c305','机巧少女不会受伤16上-台简','handy, ','','/10000/covers/b0a71dcc81c64269bbedff5f3d0ef43a.jpg','3.03M','2021-06-05 12:09:50','/10000/epub/84814f770d5b45198bc1cdc3980610cd.epub','/10000/unpack/84814f770d5b45198bc1cdc3980610cd/OEBPS/content.opf','/10000/unpack/84814f770d5b45198bc1cdc3980610cd'),('7be03df0f92c49d689311cff03d55192','机巧少女不会受伤14','海冬零儿, ','　　机巧魔术，那是人偶师通过内置魔法回路的人偶使用的魔法。距离夜会完结，还有两天。如约获得要石的雷真再度开始了赌博。“打倒两名魔女。这样就能拯救她们了。”为了让未婚妻日轮和比劳姐妹摆脱结社的控制，危险的反攻作战开始了。但是，魔女的策略超乎雷真的预料，连爱丽丝都没想到的严重失算在等着他们……就这样，在“预见之子”候补缺席的学院里，“精灵女王”安丽和最强最大的“神话级”自动人偶利维坦的淫威袭来了——学园战斗交响曲第14弹！','/10000/covers/4091f3fb454e42cebc80ed65f4a5cfa3.jpg','2.76M','2021-06-05 12:09:49','/10000/epub/acc53707151b4a799915278c0edccd39.epub','/10000/unpack/acc53707151b4a799915278c0edccd39/OPS/fb.opf','/10000/unpack/acc53707151b4a799915278c0edccd39'),('9b53736bf8584c1eb221f7d2b4bf9e6b','机巧少女不会受伤 16下','海冬零儿, handy, 尤巴连结体, ','','/10000/covers/81739c2138844893aa3beb9d097fcca4.jpg','4.98M','2021-06-05 12:09:49','/10000/epub/6304ebde7b8c45b4854c7d3952281afa.epub','/10000/unpack/6304ebde7b8c45b4854c7d3952281afa/OEBPS/content.opf','/10000/unpack/6304ebde7b8c45b4854c7d3952281afa'),('bbfe78691897488a9f7506fd394974c2','机巧少女不会受伤 6','海冬レイジ, ','机巧魔术——那是只有内藏魔术回路的自动人偶和人偶师才能使用的魔术。暑假已经过半，为了从夜会中胜出而每日努力修习<红翼阵>的雷真接到了硝子的命令前去查探某个人物的情况。那个人物就是四年前夜会的胜者，<迷宫的魔王>古莉珊露达·温斯顿。代替无法走出学校的夜夜，小紫陪同雷真前往古莉珊露达处，却惊奇地发现她居然拥有和<红翼阵>及其相似的能力……？「让我当你的徒弟吧」「委……委婉的求婚？」「别在那自己做奇怪的结论！」交响曲风学院战斗动作剧第6弹！','/10000/covers/4522c24f78554c0e84535f942d255649.jpg','2.02M','2021-06-05 12:09:43','/10000/epub/df437f4bc49743d8b0942dafa503546e.epub','/10000/unpack/df437f4bc49743d8b0942dafa503546e/OPS/fb.opf','/10000/unpack/df437f4bc49743d8b0942dafa503546e'),('bdf1f2d1237f4606bc952e7dcbe69042','机巧少女不会受伤 9','海冬レイジ, ','','/10000/covers/eacdbbd04e0a4b24ab3eb637311db3a1.jpg','4.53M','2021-06-05 12:09:45','/10000/epub/b548ec6c3cc143edb40f2f43846998ae.epub','/10000/unpack/b548ec6c3cc143edb40f2f43846998ae/OPS/fb.opf','/10000/unpack/b548ec6c3cc143edb40f2f43846998ae'),('c7204693bff54c4a9c55ff5d13ae2a34','机巧少女不会受伤10','海冬レイジ, ','机巧魔术，那是人偶师通过内置魔法回路的人偶使用的魔法。“请让我代替夜夜，成为您的妻子！”“姐姐大人，你终于，你、终、于！”伊吕利的爆炸性发言让雷真与夜夜大为惊愕。就在此时，卢瑟福因“流星群”骚乱被问责而下台、“烧却之魔王”莱科宁就任学院长的消息发布了。在这围绕自治权的混乱之中，“结社”袭击了学院——未曾有过的危机袭向了学生们！日本军决定趁此机会侵入“愚者的圣堂”，然而，挡在前往圣堂的雷真面前的，是仇敌马格纳斯和他的战队……学园战斗交响曲第10弹！','/10000/covers/a53270535ff9492184dfc1a82ecfb34e.jpg','5.32M','2021-06-05 12:09:45','/10000/epub/8106bd39ff6245adb08339e3602b8eb3.epub','/10000/unpack/8106bd39ff6245adb08339e3602b8eb3/OPS/fb.opf','/10000/unpack/8106bd39ff6245adb08339e3602b8eb3'),('c7e150c83c724070b12ae93e2474655d','机巧少女不会受伤7','海冬レイジ, ','机巧魔术，那是人偶师通过内置魔法回路的人偶使用的魔法。“不怕你误会，这个夏天，夜夜和雷真已经越过那条线了。”“骗人……的吧。”就这样，夏天结束，在“迷宫之魔王”格丽泽尔达门下修行而提升了实力的雷真，与洛基和芙蕾一道顺利地在夜会中一路获胜、前进着。但是，发生了夏儿不知被谁诅咒、变得像人偶一样大的事件。另一方面，雷真又遭到了学生总代表、“十三人”的第三位、奥尔嘉·萨拉丁的胁迫。接着，雷真和奥尔嘉的婚约发表了？！学园战斗交响曲第7弹！','/10000/covers/1077904096ff475e9c79bbe859bb7c5b.jpg','4.14M','2021-06-05 12:09:44','/10000/epub/6aed9e6022744e618f80ce8f4687fa4f.epub','/10000/unpack/6aed9e6022744e618f80ce8f4687fa4f/OPS/fb.opf','/10000/unpack/6aed9e6022744e618f80ce8f4687fa4f'),('dce7ac00b74e425b82f31b2e3e90fac2','机巧少女不会受伤 11','海冬レイジ, ','帛帛制作，请勿转载\n　　机巧魔术，那是人偶师通过内置魔法回路的人偶使用的魔法。雷真他们击退了结社大干部“金蔷薇”魔女阿斯特丽德对学院的袭击，但是，付出的代价太过高昂了：夜夜的金刚力魔术回路消失，陷入了严重的危机。能够修复夜夜的，只有她的创造者硝子，可是，关键人物硝子行踪不明了。另一方面，学院也因接连发生的恶性事件丧失了威信。“让夜会重来”的论调在各国间开始抬头，英国终于向学院派出了机巧师团！生命的终点迫近，只有一昼夜的缓期。雷真赌上一线希望前往了帝都，可是——学园战斗交响曲！','/10000/covers/a860563b7d5d4679be4c06f0b33100d5.jpg','4.21M','2021-06-05 12:09:45','/10000/epub/ad7900297e98428da7515dcbb700d0d1.epub','/10000/unpack/ad7900297e98428da7515dcbb700d0d1/OPS/fb.opf','/10000/unpack/ad7900297e98428da7515dcbb700d0d1');
/*!40000 ALTER TABLE `general_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_bookmark`
--

DROP TABLE IF EXISTS `general_bookmark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `general_bookmark` (
  `id` varchar(128) NOT NULL,
  `bookmark_title` varchar(64) DEFAULT NULL,
  `bookmark_created_time` varchar(32) DEFAULT NULL,
  `bookmark_location_index` longtext DEFAULT NULL,
  `bookmark_location_content` longtext DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_bookmark`
--

LOCK TABLES `general_bookmark` WRITE;
/*!40000 ALTER TABLE `general_bookmark` DISABLE KEYS */;
INSERT INTO `general_bookmark` VALUES ('119da40551474907a10270f5cfa29b64','Test Chapter 05','2021-06-06 22:34:33','testLocationIndex_05','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),('2f74a71cc7cc4f97a3b48a13c9f5a10c','Test Chapter 06','2021-06-06 22:34:40','testLocationIndex_06','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),('3000a817c2d2451b8b57c6964e8e56a0','Test Chapter 04','2021-06-06 22:34:26','testLocationIndex_04','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),('c9e7ceef4d0b45e98918096ebe856ad4','Test Chapter 01','2021-06-06 22:34:03','testLocationIndex_01','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),('cbd64f510937492d85e929fa5c1d7c31','Test Chapter 03','2021-06-06 22:34:18','testLocationIndex_03','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),('d6b4d2b6f2b2464aa155dcb865c34f46','Test Chapter 02','2021-06-06 22:34:11','testLocationIndex_02','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.');
/*!40000 ALTER TABLE `general_bookmark` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_reading_config`
--

DROP TABLE IF EXISTS `general_reading_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `general_reading_config` (
  `id` varchar(128) NOT NULL,
  `config_font_family` varchar(32) DEFAULT NULL,
  `config_font_size` varchar(32) DEFAULT NULL,
  `config_font_style` varchar(32) DEFAULT NULL,
  `config_theme` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_reading_config`
--

LOCK TABLES `general_reading_config` WRITE;
/*!40000 ALTER TABLE `general_reading_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `general_reading_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `general_reading_progress`
--

DROP TABLE IF EXISTS `general_reading_progress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `general_reading_progress` (
  `id` varchar(128) NOT NULL,
  `progress_title` varchar(64) DEFAULT NULL,
  `progress_location_index` longtext DEFAULT NULL,
  `progress_location_content` longtext DEFAULT NULL,
  `progress_updated_time` varchar(32) DEFAULT NULL,
  `progress_percentage` varchar(32) DEFAULT NULL COMMENT '阅读进度百分比',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `general_reading_progress`
--

LOCK TABLES `general_reading_progress` WRITE;
/*!40000 ALTER TABLE `general_reading_progress` DISABLE KEYS */;
INSERT INTO `general_reading_progress` VALUES ('447fa44843244eada3cc2f61762eeb31','Test Title 12','newTestIndex','Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.','2021-06-06 21:01:40','55');
/*!40000 ALTER TABLE `general_reading_progress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'general_reading_system'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-06 23:11:41
