 20200429 무결성 제약조건 관련 오류 전략 처리 (UNIQUE)

---

```java
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
		
		// Auto는 JPA구현체가 자동으로 생성 전략을 결정한다.
		// IDENTITY는 기본키 생성을 DB에 위입한다
					//예를 들어 MySQL의 경우 AUTO_INCREMENT를 사용해서 기본키를 생성한다.
		// SEQUENCE DB의 특별한 Sequence 오브젝트를 사용해서 기본키를 생성한다.(oracle)
		// TABLE Key를 생성하는 생성 전용 테이블을 하나 만들고 이를 사용해서 기본키를 생성한다.
    	//데이터 무결성으로 인한 문제를 해결하기 위해 default에서 IDENTITY로 설정.
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    	
		private Long id;
		@Column(unique = true)
		private String username;
		@Column(unique = true)
		private String email;
}
```

ORACLE 기반 Command Line

> 이전엔 삭제후 삭제했던 데이터 값과 똑같은 값을 넣었을 때 데이터 무결성 관련 에러가 발생했다. 
>
> 기존의 id에 해당되는 데이터값을 기억하는듯했다.
>
> `MariaDB [spring_db]> select * from hibernate_sequence;` 
>
> 명령어를 실행하면 자동으로 처리해준다.
>
> 
>
> 전략을 `IDENTITY` 로 바꾸니 해당 오류가 해결되었다. 대신 id값만 증가함을 알 수 있다.

```mariadb
MariaDB [spring_db]> show tables;
+---------------------+
| Tables_in_spring_db |
+---------------------+
| account             |
| customer            |
| user                |
+---------------------+
3 rows in set (0.003 sec)

MariaDB [spring_db]> select * from user;
+----+-------------+----------+
| id | email       | username |
+----+-------------+----------+
|  1 | dog@aaa.com | 댕댕이   |
+----+-------------+----------+
1 row in set (0.003 sec)

MariaDB [spring_db]> select * from user;
+----+--------------+----------+
| id | email        | username |
+----+--------------+----------+
|  1 | dog@aaa.com  | 댕댕이   |
|  2 | dog2@aaa.com | 댕댕이2  |
+----+--------------+----------+
2 rows in set (0.001 sec)

MariaDB [spring_db]> select * from user;
+----+--------------+----------+
| id | email        | username |
+----+--------------+----------+
|  1 | dog@aaa.com  | 댕댕이   |
|  3 | dog2@aaa.com | 댕댕이2  |
+----+--------------+----------+
2 rows in set (0.001 sec)
```

