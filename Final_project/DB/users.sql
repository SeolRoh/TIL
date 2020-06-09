insert into users(email, username, password, phoneNumber)
values('test@naver.com','seol','1234567','010-0000-0000');
drop table users;
use springboot;
select * from users;
select * from result_log;

CREATE TABLE users (
	id INT(255) NOT NULL AUTO_INCREMENT,
	email VARCHAR(255)  NOT NULL,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	phoneNumber VARCHAR(255) NOT NULL,
    isMember INT(3)  NOT NULL DEFAULT '1',
    admin INT(3) UNSIGNED NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`),
    UNIQUE INDEX `username` (`username`)
);

delete from users where id = 63