CREATE TABLE `hero_games` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `game_name` varchar(255) NOT NULL,
  `winner_id` int(11) not NULL,
  `loser_id` int(11) not NULL,
  `desc` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`,`game_name`)
);
insert into hero_games (id, game_name,winner_id,loser_id,`desc`) values (1, '忍者大战',1,2,'非常精彩');
insert into hero_games (id, game_name,winner_id,loser_id,`desc`) values (2, '下饭局',1,3,'非常下饭');
insert into hero_games (id, game_name,winner_id,loser_id,`desc`) values (3, '正义之战',2,2,'非常精彩');
