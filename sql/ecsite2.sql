set names utf8;
set foreign_key_checks = 0;
use ecsite;

drop table if exists cart_info;

create table cart_info(
	id int not null primary key auto_increment,
	user_id varchar(16),
	temp_user_id varchar(128),
	item_id varchar(20) not null,
	item_count int not null,
	item_totl_price int not null,
	insert_date datetime not null,
	update_date datetime
);
