insert into ee_role(name,permissions) values('ADMINITRATOR','CRUD');
insert into ee_role(name,permissions) values('MANGER','CRU');
insert into ee_role(name,permissions) values('GUEST','R');

insert into ee_account(username,password,email,mobile,salt,status) values('digitalplayer1','ieiorjmdfasoe23dls0094','dg1@gmailcom','15826248972','xmankillthebody','ACTIVE');
insert into ee_account(username,password,email,mobile,salt,status) values('digitalplayer2','ieiorjmdfasoe23dls0094','dg2@gmail.com','NA','ppooewxwwq32','DEAD');
insert into ee_account(username,password,email,mobile,salt,status) values('digitalplayer3','ieiorjmdfasoe23dls0094','NA','18963181202','ioemdfqwlkddf323','IDLE');
;
insert into ee_account_role(account_id,role_id) values (1,1);
insert into ee_account_role(account_id,role_id) values (1,2);
insert into ee_account_role(account_id,role_id) values (1,3);
insert into ee_account_role(account_id,role_id) values (2,2);
insert into ee_account_role(account_id,role_id) values (2,3);
insert into ee_account_role(account_id,role_id) values (3,3);
insert into ee_account_role(account_id,role_id) values (2,1);
insert into ee_account_role(account_id,role_id) values (3,1);

insert into ee_author(name, email,sex,status) values ('柳下挥 ', 'liuxiahui@163.com','F','Active');
insert into ee_author(name, email,sex,status) values ('关中老人', 'gzlr@163.com','M','Active');
insert into ee_author(name, email,sex,status) values ('乱世狂刀 ', 'lskd@163.com','M','Active');
insert into ee_author(name, email,sex,status) values ('潇铭  ', 'xm@163.com','F','Active');

insert into ee_category(name,status) values('玄幻','Active');
insert into ee_category(name,status) values('奇幻','Active');
insert into ee_category(name,status) values('仙侠','Active');
insert into ee_category(name,status) values('都市','Active');
insert into ee_category(name,status) values('历史','Active');
insert into ee_category(name,status) values('军事','Active');

insert into ee_tag(name) values ('扮猪吃虎');
insert into ee_tag(name) values ('爽文');
insert into ee_tag(name) values ('热血');
insert into ee_tag(name) values ('古典仙侠');
insert into ee_tag(name) values ('争霸');

insert into ee_book(author_id,category_id,name, description) values (1,4,'天才医生', '掌握亿万家财、无上权力又如何？ 我，能够掌握你的生命。 一个小医生弘扬中医的励志故事！ 大家要记得注册收藏哦，在书评区留下你性感美丽的脚印！！！');
insert into ee_book(author_id,category_id,name, description) values (1,3,'火爆天王', '狱中走出来的妖孽少年，代替自己病重的妹妹加入一个偶像组合。 于是，娱乐圈的火爆天王就此诞生。 背负‘天王’身份的大学生游走在菁菁校园，又将发生怎样有趣的故事？');
insert into ee_book(author_id,category_id,name, description) values (1,1,'太极世家', '方炎原是太极世家传人，因为不堪忍受一个野蛮女人的暴力欺负而翘家逃跑，弃武从文成为一所私立学校的高中语文老师。 　　 于是，一个传奇教师就此诞生！');

insert into ee_book(author_id,category_id,name, description) values (2,1,'般.若', '夕阳西下，破落古宅，不知年轮的老槐树下，眯着眼睛佝偻着身躯的老头对着坐在地上的孙子说道“三生啊，你这辈子先要为你活一生，要为你父母活一生，最后还要为老李家活人活的都要好” 我们总以为这个世界欠自己太多，到头来才发现，自己欠了很多人');
insert into ee_book(author_id,category_id,name, description) values (2,2,'混世刁民', '最穷不过要饭，不死总会出头。 这一年，在祁连大山里混吃等死了二十多年的刁民赵出息终于选择走出大山，带着最庸俗的想法来到大城市。 不富贵、不还乡…… （ 这是一本纯粹的、可歌可泣、可悲可笑的小人物奋斗史');

insert into ee_book(author_id,category_id,name, description) values (3,2,'刀剑神皇', '一口冰剑，一柄炎刀，一个屹立绝巅的不朽神皇传说！ 乱世狂刀，热血新作《御天神帝》，2015年4月2日八点十八分，正式起航，欢迎大家关注！');
insert into ee_book(author_id,category_id,name, description) values (3,2,'御天神帝', '大千世界，界域三千。人族少年名青羽，自雪国出，威御诸天！ 乱世狂刀，2015热血新作！');

insert into ee_book(author_id,category_id,name, description) values (4,5,'近身狂兵', '华夏兵王混迹西方，一个人，一把枪在黑暗中闯出一片希望，遥望曙光。 精彩与热血正在进行中，这是一曲真男人的血泪之歌！');

insert into ee_book_tag(book_id,tag_id) values(1,1);
insert into ee_book_tag(book_id,tag_id) values(1,2);
insert into ee_book_tag(book_id,tag_id) values(1,3);
insert into ee_book_tag(book_id,tag_id) values(2,1);
insert into ee_book_tag(book_id,tag_id) values(2,2);
insert into ee_book_tag(book_id,tag_id) values(3,3);
insert into ee_book_tag(book_id,tag_id) values(3,4);

insert into ee_book_tag(book_id,tag_id) values(4,1);
insert into ee_book_tag(book_id,tag_id) values(4,2);
insert into ee_book_tag(book_id,tag_id) values(4,3);
insert into ee_book_tag(book_id,tag_id) values(5,5);
insert into ee_book_tag(book_id,tag_id) values(5,4);

insert into ee_book_tag(book_id,tag_id) values(6,4);
insert into ee_book_tag(book_id,tag_id) values(7,5);

insert into ee_book_tag(book_id,tag_id) values(8,5);

insert into ee_book_subscribe(account_id,book_id) values(1,1);
insert into ee_book_subscribe(account_id,book_id) values(1,2);
insert into ee_book_subscribe(account_id,book_id) values(1,3);
insert into ee_book_subscribe(account_id,book_id) values(1,4);
insert into ee_book_subscribe(account_id,book_id) values(1,5);
insert into ee_book_subscribe(account_id,book_id) values(1,6);
insert into ee_book_subscribe(account_id,book_id) values(2,1);
insert into ee_book_subscribe(account_id,book_id) values(2,6);
insert into ee_book_subscribe(account_id,book_id) values(3,3);
insert into ee_book_subscribe(account_id,book_id) values(3,4);
insert into ee_book_subscribe(account_id,book_id) values(3,5);
insert into ee_book_subscribe(account_id,book_id) values(2,8);
insert into ee_book_subscribe(account_id,book_id) values(2,7);
insert into ee_book_subscribe(account_id,book_id) values(1,8);

