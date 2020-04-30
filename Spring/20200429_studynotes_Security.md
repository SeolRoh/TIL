 20200429 Security basic 인증 구현

---

의존성 추가 pom.xml

```xml
<dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

Username : user 

Password : 애플리케이션을 실행할 때 마다 랜덤 값 생성 (콘솔로 확인하자)

```
Using generated security password: e11d1111-1ccc-1111-11b1-1c111b11fc11
```

실행시 `localhost:8085/login`이동하고 다음과 같은 화면이 출력된다.

<img src="https://user-images.githubusercontent.com/34231229/80552824-cd784380-8a02-11ea-94ce-e89741f6c717.JPG" alt="100" style="zoom:50%;" />

로그인한 설정을 취소하기 위해서는 개발자도구 -> Application -> storage -> Cookies -> 해당 JSESSIONID 지우기



**응용하기 <특정페이지를 접근시 위와같은 로그인 창이 출력되도록 하기>**

+ 패스워드 인코딩이 필요한 순간

  > <Console 창> 과 500에러가 함께 발생
  >
  > java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"

+ 인코딩된 패스워드 Command line으로 확인

  + 관리자들이 볼수없도록 유저들의 비밀번호를 인코딩하기 위함.

  ```mariadb
  MariaDB [spring_db]> select * from account;
  +----+-------+----------------------------------------------------------------------+----------+
  | id | email | password                                                             | username |
  +----+-------+----------------------------------------------------------------------+----------+
  |  3 | NULL  | 1234                                                                 | test     |
  |  4 | NULL  | {bcrypt}$2a$10$12jk3XN7ExEX5Db5E9GkDeXxHUJyalUYvyjBGIKMfdLY1.mOv06Z2 | test1    |
  +----+-------+----------------------------------------------------------------------+----------+
  2 rows in set (0.001 sec)
  ```

  