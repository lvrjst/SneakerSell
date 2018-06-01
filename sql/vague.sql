set names utf8;
set foreign_key_checks = 0;
drop database if exists Vague;

create database if not exists Vague DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;;

use Vague;


/*
 * 会員情報テーブル
 */

drop table if exists user_info;

create table user_info(
	id int not null primary key auto_increment,
	user_id varchar (16) not null unique,
	password varchar (16) not null,
	family_name varchar (32) not null,
	first_name varchar (32) not null,
	family_name_kana varchar (32) not null,
	first_name_kana varchar (32) not null,
	sex tinyint default 0,
	email varchar (50) not null,
	status tinyint default 0,
	login_flg tinyint default 0,
	m_flg tinyint default 0,
	question int(255) not null,/* 例：１嫌いな食べ物は？２：好きな映画は？ */
    answer varchar(255) not null,
	insert_date datetime not null,
	update_date datetime
);

/*
 * 商品情報テーブル
 */

drop table if exists product_info;

create table product_info(
	id int not null primary key auto_increment,
	product_id int not null unique,
	product_name varchar (100) not null unique,
	product_name_kana varchar (100) not null unique,
	product_description varchar (255) not null,
	category_id int not null,
	product_stock int not null,
	price int not null,
	image_file_path varchar (100),
	image_file_name varchar (50),
	release_date datetime not null,
	release_company varchar (50),
	status tinyint default 0 not null,
	insert_date datetime not null,
	update_date datetime
);

/*
*カート情報テーブル
*/

drop table if exists cart_info;

create table cart_info(
	id int not null primary key auto_increment,
	user_id varchar(16),
	temp_user_id varchar(128) not null,
	product_id int not null,
	product_count int not null,
	price int not null,
	insert_date datetime not null,
	update_date datetime
);

/*
*購入履歴情報テーブル
*/

drop table if exists purchase_history_info;

create table purchase_history_info(
	id int not null primary key auto_increment,
	user_id varchar (16) not null,
	product_id int not null,
	product_count int not null,
	price int not null,
	insert_date datetime not null,
	update_date datetime
);

/*
*宛先情報テーブル
*/

drop table if exists destination_info;

create table destination_info(
	id int not null primary key auto_increment,
	user_id varchar (16) not null,
	family_name varchar (32) not null,
	first_name varchar (32) not null,
	family_name_kana varchar (32) not null,
	first_name_kana varchar (32) not null,
	email varchar (32) not null,
	tel_number varchar (13) not null,
	user_address varchar (50) not null,
	insert_date datetime not null,
	update_date datetime
);

/*
*カテゴリーマスターテーブル
*/

drop table if exists m_category;

create table m_category(
	id int primary key not null auto_increment,
	category_id int not null unique,
	categry_name varchar (20) not null unique,
	category_description varchar (100),
	insert_date datetime not null,
	update_date datetime
);

/*
*レビューテーブル
*/

drop table if exists review;

create table review (
	id int not null primary key auto_increment,
	user_id varchar (16) not null,
	product_id int not null,
	review_title varchar (100),
	review_body varchar (255),
	review_score int not null,
	insert_date datetime not null,
	update_date datetime
);


/*
 * ユーザーテーブルに情報挿入
 */

INSERT INTO user_info(user_id, password, family_name, first_name, family_name_kana,
	first_name_kana, sex, email, question, answer, m_flg, insert_date)
	values("guest","guest","一般","太郎","いっぱん","たろう",0,"ippan@yahoo.co.jp",1,"ピーマン",0,now()),
		  ("admin","admin","管理者","太郎","かんりしゃ","たろう",0,"kannrisya@yahoo.co.jp",1,"ピーマン",1,now()),
		  ("miyazaki","miyazaki","宮崎","瞬","みやざき","しゅん",0,"miyazaki@yahoo.co.jp",1,"かぼちゃ",0,now());


/*
 * 商品テーブルに情報挿入
 */

INSERT INTO product_info (product_id, product_name, product_name_kana, product_description,
						 category_id, product_stock,price, image_file_path, image_file_name, release_date, release_company,status,insert_date)
 						 values(1,"カウンターチェア","かうんたーちぇあ","シンプルかつエレガント！座りやすさまで考慮された椅子です",1,30,3000,"images/1Chair/counterChair.jpg","counterChair.jpg",19950809,"ニチョリ",1,now()),
 						 	   (2,"宇宙椅子","うちゅういす","まるで宇宙船にいるかのような気分に浸れます",1,40,6000,"images/1Chair/universChair.jpg","universChair.jpg",19950809,"ニチョリ",1,now()),

 						 	   (3,"ビンテージレーザーソファ","びんてーじれざぁそふぁ","最高級品質の皮を使用。ひとたび座れば最高の時間をもたらしてくれます",2,50,100000,"images/2Sofa/biitejiLeatherSofa.jpg","biitejiLeatherSofa.jpg",19950809,"ニチョリ",1,now()),
 						 	   (4,"カジュアルソファ","かじゅあるそふぁ","ソファとしてだけでなく、ベッドとしても使える多機能ソファです",2,80,3000,"images/2Sofa/casualSofa.jpg","casualSofa.jpg",19950809,"ニチョリ",1,now()),

 						 	   (5,"フロアランプ","ふろあらんぷ","間接照明として、リビングや寝室に灯りを補いたい時におすすめ。",3,30,2000,"images/3Lighting/floorLighting.jpg","floorLighting.jpg",19950809,"ニチョリ",1,now()),
 						 	   (6,"テーブルランプ","てーぶるらんぷ","柔らかな光がユニークなシェードからこぼれて、美しく落ち着いた雰囲気を演出します",3,40,1500,"images/3Lighting/tableLighting.jpg","tableLighting.jpg",19950809,"ニチョリ",1,now()),

 						 	   (7,"センターテーブル","せんたーてーぶる","天然石が作り上げるこの世にふたつとない独特の模様と風合いを生かした素材感溢れるガラス・テーブルです。",4,60,8000,"images/4Table/centerTable.jpg","centerTable.jpg",19950809,"ニチョリ",1,now()),
 						 	   (8,"サイドテーブル","さいどてーぶる","シックな水色と縦長のスマートなフォルムがおしゃれな一品です。",4,60,4000,"images/4Table/sideTable.jpg","sideTable.jpg",19950809,"ニチョリ",1,now());



/*
 * レビューテーブルに情報挿入
 */


INSERT INTO review (user_id, product_id, review_title, review_body, review_score, insert_date)
			values ("miyazaki",1,"素晴らしい！","使いごこち最高です",5,now());
