use springboot;
desc fileinfo;
create table fileinfo(
	id int(20) auto_increment primary key not null,
    file_name varchar(255) not null,
    upload_date datetime,
    upload_position varchar(255) not null    
);
select * from fileinfo;
insert into fileinfo(file_name, upload_position)values('upload2', 'c://users/upload2');