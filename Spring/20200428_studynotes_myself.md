20200429

---

 Spring Boot를 활용한 Web Application Project 생성하기
1. Spring Boot 프로젝트 
 https://start.spring.io/
    boot 버전 2.1 , java , maven 
    groupid, artifactid 는 소문자로 작성
  >> web dependency  만 추가 or  필요한 denpendency  검색해서 추가하셔도 됩니다.
  >> zip 파일 생성 -> unzip 한후 -> File : Open Project

  Eclipse 프로젝트 안에서 생성해서 됩니다.

1-1. devtools 의존성 추가하세요
  >> devtools 의존성 필요함
  >> : depedency를 추가하는 경우는 cold start  가 필요함

2. DB연결
 : maria db / h2 memory   DB 선택
 : DatabaseRunner 클래스 
     - DataSource 사용 , connection url, username
 >> spring boot jdbc 의존성 추가 되어야 함

3. ORM 선택 
 : JPA, MyBatis
 3.1 JPA 선택
  >> spring boot data jpa 의존성 필요함
  >> : Entity Class  작성 ( Table 1개와 매핑되도록) 
  >> : @Entity
  >> : @Id, @GeneratedValue, @Column   
  >> : unique 컬럼 1개 추가 되도록

 3.2 jpa 관련 설정
 spring.jpa.hibernate.ddl-auto=update
 spring.jpa.show-sql=true
 설정 이후에 Table 생성여부와 구조 확인

 3.3 Repository Interface 
  : findById() 는 자동생성됨
  : PK이외의 칼럼에 대한 finder method를 생성할 수 있다.
   findByUsername /  findByEmail(String email)

 3.4 TestCase 클래스 작성
  : 등록/조회 

4. REST 서비스 작성
 4.1 RestController 클래스 작성
    : 등록/수정/삭제/조회(1개, 전체)
    : 기본 jason format
    : xml format 으로 조회 구현도 해보세요
    >> jackson dependency 추가로 필요함
  >> PostMan 툴을 사용한 테스트 필요합니다. 

 4.2 Controller 클래스 작성
   : 등록/수정/삭제/조회(1개, 전체)
   : static/index.html 작성
   : templates/*.html (타임리프) 작성
  >> Thymeleaf  dependency 추가
  >>  4.3 Exception 처리
  >>  : System error , custom exception 처리 둘다

---

완료--

강의 내용중 포함됨으로 수강생들과 깃내용이 겹칠 수 있습니다.