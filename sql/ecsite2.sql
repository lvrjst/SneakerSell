set names utf8;
set foreign_key_checks = 0;
use ecsite;

drop table if exists post_info;

create table post_info(
	id int not null primary key auto_increment,
	user_id varchar(16),
	temp_user_id varchar(128),
	name varchar(16)
	email varchar(32),
	player varchar(32),
	message varchar(255) ,
	insert_date datetime ,
	update_date datetime
);
