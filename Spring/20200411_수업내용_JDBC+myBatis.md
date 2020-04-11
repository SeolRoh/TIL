 20200510_9:00~14:00 Spring Framework 정리 

### Data Acess: ORM (Mybatis)

---

오늘 배울 파트

Construction Injection

JDBC

실습

---

```powershell
conn / as sysdba //시스템 dbs , hr계정의 비밀번호 세팅 ㅡ다음 conn.hr/hr 접속

alter user hr account unlock;

alter user hr identified by hr;

conn hr/hr;
```

```powershell
conn sys as sysdba;

create user scott identified by tiger default tablespace users temporary tablespace temp;

grant connect,resource to scott; //연결하고 관리하고

conn scott/tiger;
```

강사님이 주신 해당 파일 실행하기 

​	1) 탐색기 창에서 해당 파일이있는 경로 복사하기 `C:\java\sql_oracle`

​	2) Run SQL Command Line 창에서 접속하기	

​	3) 아래 파일 순서대로 start 한후 테이블 개수 이름 확인하기

```powershell
SQL*Plus: Release 11.2.0.2.0 Production on 토 4월 11 13:51:46 2020

Copyright (c) 1982, 2014, Oracle.  All rights reserved.

SQL> start C:\java\sql_oracle\hr.sql
Connected.

//여기서 hr.sql만 권한이 없다고 뜰 경우,
//파일 메모장으로열어서 맨 첫번째 줄을 `conn sys as sysdba;`로 바꾸어준다.

User altered.


User altered.

Connected.
SQL>select * from tab;
SQL> select * from tab
SQL> select employee_id from employees;

107 rows selected.

SQL> start C:\java\sql_oracle\scott.sql //새로운 사용자 계정을 만들라고 먼저 입력하기
Enter password:
Connected.

User created.


Grant succeeded.

Connected.

SQL> start C:\java\sql_oracle\user.sql
SQL> select * from users;

SQL> start C:\java\sql_oracle\person.sql
SQL> select * from tab;

SQL> start C:\java\sql_oracle\student.sql

SQL> select * from tab; //해서 start한 .sql 파일 속 테이블 몇개인지 확인
6 rows selected.
```

```powershell
SQL> insert into users values('spring', '스프링','남','부산');

1 row created.

SQL> select userid,name from users;

USERID
------------------------------------------------------------
NAME
--------------------------------------------------------------------------------
gildong
홍길동

spring
스프링
```



---

#### Oracle jdbc driver는 직접 maven에서 내려받지 않고 직접 `jar`을 다운로드 받아서 클래스 패스를 설정한다.

---

build path - configure build path - .jal파일 add

---

#### JDBC (Java Database Connectivity)

인터페이스와 구현을 분리 시켜놓은 구조

개발자가 종속되지 않고 벤더 독립적으로 개발 할 수 있도록 했다.

Database를 바꿀 때 용이하다.

#### JDBC 작성절차

 	1. Driver 등록
 	2. DBMS와 연결 - 이 DB와 실제 연결을 담당하는 객체. Connection 클래스 객체
 	3. Statememt 객체생성 - Statement는 SQL Query를 실행해주는 역할.
 	4. SQL 전송
 	5. 결과 받기 - Query 수행 결과 받음
 	6. 닫기



​		1. Driver 등록  (드라이버 클래스를 찾아서 등록해야하는게 가장 먼저할일)

​			Class.forName("Oracle.jdbc.driver.OracleDriver");

​			// (DB벤더가 만듦) "" 안에있는 클래스를 찾아서 생성한다.

​			//new Class 대신에 Class.forName(); 으로 스레드 객체를 만들어도 된다.

​			//왜 여기서 new 말고 forName();을 사용하는게 좋을까? new로하면 컴파일을 다시 해야한다.

​			// 벤더 중립적으로 만드려고 노력한 것같다.

​		2. DBMS와 연결

​			// Connection이라는 객체가 얻어진다.

​			public static Connection getConnection( String url,                                                                       

​																					String user,String password ) throws SQLException 

​			Connection conn =       DriverManager.getConnection(             	

​													“jdbc:oracle:thin:@192.168.0.200:1521:VCC”,  “SEXXXXX”, “SEXXXXX” ); 

​													프로토콜 : 서브프로토콜 : @아이피 : 포트 : SID

​			또 다른 예시

```java
		//Connection con = new T4CConnection(); // 벤더 종속적이된다.
		//getConnection() -> Factory Method
		con = DriverManager.getConnection(url, user, pass);
		System.out.println(con.getClass().getName());
```
​			Connection < - Oracle 컨넥션 && MySQL컨넥션

​			=> 	Connection con = new Oracle Connection; 

​		**3. Statement 생성**  ** 중요

​			SQL문 실행

```java
	Statememt stmt = conn.createStatement();  // createStatement(); 이거도 팩토리 메서드
```

​			**connection		<---------------------------		T4CConnection() 의 create.statement ()**    

​			**(개발자 영역)																	↓ create 		(vender 영역)**

​			**statement		 <----------------------------		oracle statement 구현체** 



​		개발자는 구현체를 보고 구현을 한다. 

​		4 SQL전송 - Statememt method를 이용하여 SQL실행한다.

​		5 Query 결과 받기 - 실행후 결과를 ResultSet(SELECT) 혹은 int형 변수(DML)로 받아 처리

​			5.1 Select

​				ResultSet rset = stmt.executeQuery( query );  // **executeQuery**는 select(조회)할때 사용

​																								//							도 Factorymethod

​						// rset는 resultset  // 이거는 boolean type // false는 결과가 없는거. // while로 돌린다.

​						// **Resultset**은 결과 데이터. 데이터의 현재 row를 가르키는 포인팅 커서를 가지고 있다.

​						//                  은 getter method를 지원한다. (get) 굉장히 많은 메소드가 오버로딩됬다. 

​						// 오버로딩의 장점 : 인터페이스가 단순해진다.

​						// 				의 규칙 :  메소드 선언부만 똑같고 바디만 다름, 이름 타입인자 반환 같아야 함

​						//  오버라이딩 재정의 왜해야하나: 

​						// 										부모클래스에 있는 메소드와 자식 클래스에 선언해야하는 부분이 다를때.

​			5.2 DML (INSERT, UPDATE, DELETE  = record(row) 단위로 이루어진다.

​				int result = stmt.**executeUpdate**( query ); 

​				// result가 3일 경우, table(row)dl 3번 갱신됬다. // 0일 경우, 갱신이 이루어지지 않았다.

​				// return은 row counter로

​		6 닫기

​			6.1 Select

​				rset.close(); 

​				stmt.close(); 

​				conn.close(); 

​			6.2 DML

​				stmt.close(); 

​				conn.close();



​		이하, 가지고 있는 JDBC.pdf 17page 부터 참고

---

Run SQL Command Line 넘어가서 

```powershell
SQL> conn hr/hr
Connected.
SQL> desc departments
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 DEPARTMENT_ID                             NOT NULL NUMBER(4)
 DEPARTMENT_NAME                           NOT NULL VARCHAR2(30)
 MANAGER_ID                                         NUMBER(6)
 LOCATION_ID                                        NUMBER(4)
```

