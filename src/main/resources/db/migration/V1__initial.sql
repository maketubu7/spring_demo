CREATE TABLE `make_heros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `q` varchar(255) DEFAULT NULL,
  `w` varchar(255) DEFAULT NULL,
  `e` varchar(255) DEFAULT NULL,
  `r` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`)
);
INSERT INTO make_heros (id, name, q,w,e,r) VALUES (1, '无敌盖伦','无敌金身','冲锋','全图秒杀','原地复活');
INSERT INTO make_heros (id, name, q,w,e,r) VALUES (2, '忍者之极','无敌金身','冲锋','全图秒杀','原地复活');
INSERT INTO make_heros (id, name, q,w,e,r) VALUES (3, '亚索','旋风斩','踏空斩','风来','无敌旋风斩');

