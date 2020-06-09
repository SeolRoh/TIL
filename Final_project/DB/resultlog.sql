select * from result_log;
insert into result_log(user_name, created_date, file_name, origin_location, result_location) 
values("test", now(), "DS.xlsx", "/c/d/f/", "C:\\Users\\HPE\\Desktop\\DS.xlsx");
desc result_log;

desc result_log;
use springboot;
select * from result_log;

drop table result_log;

create table result_log(
	id int(20) auto_increment primary key not null,
    user_name varchar(255) not null,
    created_date datetime,
    download_cnt int(11),
    download_date datetime,
    file_name varchar(255) not null,
    is_succeed int(1),
    origin_location varchar(255) not null,
    result_location varchar(255) 
);

desc result_log;
delete from result_log where id=2; 