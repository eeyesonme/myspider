use ireader;
drop table if exists T_ACCOUNT;
drop table if exists T_ROLE;
drop table if exists T_GROUP;
drop table if exists T_ACCOUNT_GROUP;
drop table if exists T_ACCOUNT_ROLE;
drop table if exists T_AUTHOR;
drop table if exists T_TAG;
drop table if exists T_CATEGORY;
drop table if exists T_BOOK;
drop table if exists T_BOOK_CONTENT;
drop table if exists T_BOOK_TAG;
drop table if exists T_SUBSCRIBE;

create table T_ROLE(
 id bigint,
 name varchar(255) not null unique,
 permissions varchar(255),
 primary key (id)
 );
 
create table T_ACCOUNT (
	id bigint,
    username varchar(64) not null,
    email varchar(128) ,
    mobile varchar(64) ,
	password varchar(255) not null,
	salt varchar(64) not null,
	status varchar(32),
	regist_date timestamp  default current_timestamp,
	primary key (id)
) ;

 create table T_ACCOUNT_ROLE (
 		id bigint,
        account_id bigint not null,
        role_id bigint not null,
        primary key (id)
);

 create table T_GROUP (
       	id bigint,
    	name varchar(255) not null unique,
    	description  varchar(255) not null ,
        primary key (id)
 );
 
create table T_ACCOUNT_GROUP(
		account_id bigint not null,
		group_id bigint not null,
		primary key(account_id,group_id)
);
		
create table T_AUTHOR(
	id bigint ,
    name varchar(64) not null,
    email varchar(128) not null,
	sex varchar(1) not null,
	status varchar(32),
	register_date timestamp not null default current_timestamp,
	primary key (id)
);

create table T_CATEGORY(
	id bigint,
    name varchar(64) not null,
	status varchar(32),
	primary key (id)
);

create table T_TAG(
	id bigint,
    tag_name varchar(64) not null,
	primary key (id)
);
create table T_BOOK(
	id bigint,
	author_id bigint not null,
	category_id bigint not null,
    name varchar(64) not null,
    description varchar(128) not null,
	status varchar(32),
	regist_time timestamp not null default current_timestamp,
	primary key (id)
);

create table T_SUBSCRIBE(
	id bigint,
	book_id bigint not null,
	account_id bigint not null,
	subscribe_time timestamp not null default current_timestamp,
	primary key(id)
);

create table T_BOOK_CONTENT(
	id bigint,
	book_id bigint not null,
	title varchar(64) not null,
	content varchar(255) not null,
	primary key(id)
);

create table T_BOOK_TAG(
	book_id bigint not null,
	tag_id bigint not null,
	primary key(book_id,tag_id)
);
	
create table T_IDGENERATOR(
	id int(20) unsigned NOT NULL auto_increment,
  	gen_name varchar(255) NOT NULL,
  	gen_value int(20) NOT NULL,
  	PRIMARY KEY  (id)
);
/**create table T_book_hit(
	id bigint auto_increment,
	account_id bigint not null,
	book_id bigint not null,
	from_address varchar(64) default 'NA',
	hit_time timestamp not null default current_timestamp,
);

create table T_book_rank(
	id bigint auto_increment,
	book_id bigint not null,
	account_id bigint not null,
	from_address varchar(64) default 'NA',
	rank bigint not null,
	rank_time timestamp not null default current_timestamp,
);**/
		


