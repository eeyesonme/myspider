use ireader;
drop table if exists ee_account;
drop table if exists ee_role;
drop table if exists ee_group;
drop table if exists ee_account_group;
drop table if exists ee_account_role;
drop table if exists ee_author;
drop table if exists ee_tag;
drop table if exists ee_category;
drop table if exists ee_book;
drop table if exists ee_book_chapter;
drop table if exists ee_book_tag;
drop table if exists ee_book_subscribe;

create table ee_role(
 id bigint auto_increment,
 name varchar(255) not null unique,
 permissions varchar(255),
 primary key (id)
 );
 
create table ee_account (
	id bigint auto_increment,
    username varchar(64) not null,
    email varchar(128) ,
    mobile varchar(64) ,
	password varchar(255) not null,
	salt varchar(64) not null,
	status varchar(32),
	regist_date timestamp  default current_timestamp,
	primary key (id)
) ;

 create table ee_account_role (
        account_id bigint not null,
        role_id bigint not null,
        primary key (account_id, role_id)
);

 create table ee_group (
       	id bigint auto_increment,
    	name varchar(255) not null unique,
    	description  varchar(255) not null ,
        primary key (id)
 );
 
create table ee_account_group(
		account_id bigint not null,
		group_id bigint not null,
		primary key(account_id,group_id)
);
		
create table ee_author(
	id bigint auto_increment,
    name varchar(64) not null,
    email varchar(128) not null,
	sex varchar(1) not null,
	status varchar(32),
	register_date timestamp not null default current_timestamp,
	primary key (id)
);

create table ee_category(
	id bigint auto_increment,
    name varchar(64) not null,
	status varchar(32),
	primary key (id)
);

create table ee_tag(
	id bigint auto_increment,
    name varchar(64) not null,
	primary key (id)
);
create table ee_book(
	id bigint auto_increment,
	author_id bigint not null,
	category_id bigint not null,
    name varchar(64) not null,
    description varchar(128) not null,
	status varchar(32),
	regist_time timestamp not null default current_timestamp,
	primary key (id)
);

create table ee_book_subscribe(
	id bigint auto_increment,
	account_id bigint not null,
	book_id bigint not null,
	subscribe_time timestamp not null default current_timestamp,
	primary key(id)
);

create table ee_book_chapter(
	id bigint auto_increment,
	book_id bigint not null,
	title varchar(64) not null,
	content varchar(255) not null,
	update_time timestamp not null default current_timestamp,
	primary key(id)
);

create table ee_book_tag(
	book_id bigint not null,
	tag_id bigint not null,
	primary key(book_id,tag_id)
);
	
/**create table ee_book_hit(
	id bigint auto_increment,
	account_id bigint not null,
	book_id bigint not null,
	from_address varchar(64) default 'NA',
	hit_time timestamp not null default current_timestamp,
);

create table ee_book_rank(
	id bigint auto_increment,
	book_id bigint not null,
	account_id bigint not null,
	from_address varchar(64) default 'NA',
	rank bigint not null,
	rank_time timestamp not null default current_timestamp,
);**/
		


