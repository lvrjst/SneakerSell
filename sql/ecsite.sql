set names utf8;
set foreign_key_checks = 0;
drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
	id int not null primary key auto_increment,
	login_id varchar(16) unique,
	login_pass varchar(16),
	user_name varchar(50),
	name varchar(50),
	furigana varchar(50),
	zip varchar(8),
	address varchar(255),
	telephone varchar(15),
	mail_address varchar(255),
	birthday_year int,
	birthday_month int,
	birthday_day int,
	direct_mail varchar(11),
	insert_date datetime,
	updated_date datetime);

drop table if exists item_info_transaction;

create table item_info_transaction(
	id int not null primary key auto_increment,
	item_id varchar(255),
	item_name varchar(255),
	item_title varchar(255),
	pic_url0 varchar(255),
	pic_url1 varchar(255),
	pic_url2 varchar(255),
	pic_url3 varchar(255),
	pic_url4 varchar(255),
	pic_url5 varchar(255),
	pic_url6 varchar(255),
	pic_url7 varchar(255),
	pic_url8 varchar(255),
	pic_url9 varchar(255),
	pic_url10 varchar(255),
	pic_url11 varchar(255),
	pic_url12 varchar(255),
	pic_url13 varchar(255),
	pic_url14 varchar(255),
	pic_url15 varchar(255),
	pic_url16 varchar(255),
	pic_url17 varchar(255),
	pic_url18 varchar(255),
	pic_url19 varchar(255),
	pic_url20 varchar(255),
	pic_url21 varchar(255),
	pic_url22 varchar(255),
	pic_url23 varchar(255),
	pic_url24 varchar(255),
	pic_url25 varchar(255),
	pic_url26 varchar(255),
	item_price int,
	item_text varchar(2055),
	item_stock int,
	post_time varchar(30),
	maker varchar(30),
	color1 varchar(30),
	color2 varchar(30),
	insert_date datetime,
	update_date datetime
);


drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
	id int not null primary key auto_increment,
	item_transaction_id int,
	total_price int,
	total_count int,
	user_master_id varchar(16),
	pay varchar(30),
	insert_date datetime,
	delete_date datetime
);

drop table if exists cart_info;

create table cart_info(
	id int not null primary key auto_increment,
	user_id varchar(16),
	temp_user_id varchar(128),
	item_id varchar(20) ,
	item_count int ,
	item_totl_price int ,
	insert_date datetime ,
	update_date datetime
);


INSERT INTO login_user_transaction(login_id,login_pass,user_name)VALUES("admin","admin","admin");

INSERT INTO item_info_transaction( item_id, item_name, item_title, pic_url0, pic_url1, pic_url2, pic_url3, pic_url4, pic_url5, pic_url6, pic_url7, pic_url8, item_price, item_text, item_stock, post_time, maker, color1, color2)VALUES("jordan1","エアジョーダンI","エアジョーダンIタイトル","images/jordan1/larges/jordan1-1.jpeg","images/jordan1/larges/jordan1-2.jpeg","images/jordan1/larges/jordan1-3.jpeg"," "," "," "," "," "," ","5000","jordan1の詳細","5","2018.04.26 12:30","エアジョーダン","ホワイト","レッド");

