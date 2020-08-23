SQL 기본 - SQL종류,  WHERE문 사용방법, GROUP 연산, 내장형 함수 등 공부

---

> 용어정리
>
> 1. Column - 칼럼, Attibute, 속성
> 2. Tuple - 튜플, Row, 행
> 3. 참조 무결성 위배 - DEPT TABLE에는 deptno가 없고 EMP TABLE에는 deptno가 있는 경우

> TIP
>
> 1. Table 구조 확인 => DESC EMP;

+ RDB(Relation 사용)

  + 집합연산(Join 연산자 사용)
  + 관계연산

+ DB 종류

  + 계층형 (Tree 구조)
  + 네트워크형 (Owner - Member, 1:N, N:M)
  + 관계형 (Relation에 Data 저장 및 관리)

+ DBMS

  + 계층형, 네트워크형, 관계형 DB를 관리하기 위한 SW
  + Oracle, MS-SQL, MySQL, Sybase 등 모두 RDB를 지원

+ 집합연산 - 조회기능

  + UNION (합집합)

    : 두개의 릴레이션을 한개로 합함, 중보 튜플은 1번만 조회됨(튜플 = 행)

  + Difference(차집합)

    : 본래 릴레이션에는 존재하나 다른 릴레이션에 존재 하지 않는 것을 조회

  + Intersection(교집합)

    : 두개의 릴레이션 간 공통된 것을 조회

  + Cartesian product(곱집합)

    : 각 릴레이션에 존재하는 모든 Data를 조합해 연산 수행

+ 관계연산 - 조회기능

  + Selection(선택연산)

    : 릴레이션에서 조건에 맞는 튜플만 조회

  + Projection(투명연산)

    : 릴레이션에서 조건에 맞는 속성만 조회

  + Join(결합연산)

    : 여러 릴레이션의 공통된 속성을 사용해 새로운 릴레이션을 만들어냄

  + Division(나누기연산)

    : 기준 릴레이션에서 나누는 릴레이션이 가진 속성과 동일한 값을 가지는 튜플을 추출하고나누는 릴레이션의 속성을 삭제후 중복된 튜플을 제거.
  
+ SQL문 실행순서

  1. Parsing(파싱)

     : SQL문 문법을 확인 후 구문분석 함

     : 구문분서한 SQL문은 Library Cache에 저장함.

  2.  Execution(실행)

     : Optimizer가 수립한 실행 계획에 따라 SQL 실행

  3.  Fetch(인출)

     : DATA READ 후 SEND

+ Data Definition Language(DDL)

  + Create Table

    + 새 Table 생성

    + 생성하면 기본키 / 외래키 / 제약사항 등을 설정가능

      Option : Constraint, number(10,2), default sysdate, On Delete Cascade

  + Alter Table

    + 생성된 Table 변경

    + Column을 추가 / 변경 / 삭제

      Option : Rename To, ADD, MODIFY, DROP COLUMN, Rename Column To

  + Drop Table

    + 해당 Table 삭제

    + Table의 Data Structure 뿐만아니라 저장된 DATA도 모두 삭제

      Option : CASCADE CONSTRAINT
    
  + 예시) Table Create 1

    ```sql
    CREATE TABLE DEPT(
        deptno varchar2(4) primary key,
        deptname varchar2(20)
    );
    CREATE TABLE EMP(
    	empno		number(10),
        ename		varchar2(20),
        sal			number(10,2)	default	0,
        deptno		varchar2(4)		not null,
        createdate	date			default		sysdate,
        constraint	emppk			primary key(empno),
        constraint	deptfk			foreign key(deptno)
        							reference dept(deptno)
    );
    ```

    + number(10,2)

      : 해당 sal Column을 소수점 2번째 자리까지 저장.

    + constraint emppk primary key(empno, ename)

      : pk가 두개 일때  'emppk'라는 일므으로 지정

    + constraint deptfk foreign key(deptno) reference dept(deptno)

      : DEPT table의 deptno Column을 참조하여 EMO table의 deptno를 'deptfk' 라는 이름의 **외래키**로 생성

      : 외래키가 기본키를 reference

    + sysdate

      : 오늘의 날짜를 조회. 

      : default Option으로 오늘 날짜를 기본 값으로 입력함.
    
  + 예시) Table Create 2 CASCADE

    1. DEPT Master table 생성 및 입력(Incert~)

    2. EMP Slave table 생성 및 입력

       + Option ' On Delete Cascade'

       + DEPT Master table에서 data 삭제하면 어떻게 될까?

         > ON DELETE CASCADE는 자신이 참조하는 Table (DEPT)의 데이터가 삭제되면 자동으로 자신(EMP)도 삭제되는 옵션.
         >
         > '참조 무결성' 준수

       ```sql
       CREATE TABLE DEPT(
           deptno varchar2(4) primary key,
           deptname varchar2(20)
       );
       
       INCERT INTO DEPT VALUES ('1000', '인사팀');
       INCERT INTO DEPT VALUES ('1001', '총무팀');
       
       CREATE TABLE EMP(
       	empno		number(10),
           ename		varchar2(20),
           sal			number(10,2)	default	0,
           deptno		varchar2(4)		not null,
           createdate	date			default		sysdate,
           constraint	emppk			primary key(empno),
           constraint	deptfk			foreign key(deptno)
           							reference dept(deptno)
       );
       
       INCERT INTO EMP VALUES ('100', 'AAA', 1000, '1000', sysdate);
       INCERT INTO EMP VALUES ('101', 'BBB', 2000, '1001', sysdate);
       
       DELETE FROM DEPT WHERE deptno = '10000';
       ```

       