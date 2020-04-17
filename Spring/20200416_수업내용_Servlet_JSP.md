 20200416

---

1. Mybatis 20200416 리뷰 : 오전 9시

   ​	+ 테이블간 의존관계가 있는 경우 컬럼명과 VO의 getter/setter이름이 일치하지 않는경우   [20200416_수업내용_MyBatis_리뷰.md](https://github.com/SeolRoh/TIL/blob/master/Spring/20200416_수업내용_MyBatis_리뷰.md)

오늘 배울 파트

1. **J2EE (Enterprise Edition)**

2. **J2SSE,J2EE - 웹서비스의 기반이 되는 기술 살펴보기** 

   **:Servlet, JSP(Java SErver page, JSTL(Java Standart Tag Library)**

3. **Spring MVC구조와 핵심컴포넌트**

   포트 번호 8087

---

오늘 배울 파트

**J2EE (Enterprise Edition)**

1. 기술 종류 : Servlet과 JSP(java server page), JSTL(java standard tag library)

2. Tomcat (web Container) 서버에서 동자한다.

3. Servlet은 클래스, JSP 스크립트

4. JSP와 비슷한 종류는 php, asp

5. html, css, javascript:정적인(static) 컨텐츠 생산
   
   + html에서UserDAO(DB연동) 객체의 method를 호출할수 있을까? 없음
   
6. servlet과 jsp는 동적인 컨텐츠 생산
   
   + html -> servlet/jsp -> dao객체
   
7. MVC 패턴
   + Model/ View/ Controller

   + Seperation of Concerns(=Responsibility 책임, 역할)- 역할을 분리->유지보수성을 높이는 것이 MVC 패턴 (반대_ 스파게티 코드)

     + MVC 패턴을 기반으로 하는 web architecture

       + Model 1 아키텍쳐

         + Model - Java (DAO, Service, VO)
         + View - JSP, Html
         + Controller - JSP

       + Model 2 아키텍쳐

         + Model - Java (DAO, Service, VO)
         + View - JSP, Html
         + Controller - Servlet 

       + Spring MVC는 Model2의 아키텍쳐,

         Front Controller의 URL 매핑을 맡는다. Front Controller의 역할을 하는 `DispatcherServlet.class`제공

         Model, Controller, Front Controller, View 를 잘 구조화하는 것이 MVC 모델을 제어하고 있는 라이브러리가 해야하는 역할이다.

   ---

   **JSP 실습환경 구성하기**

   1. 다이내믹 웹 프로젝트 생성하기
      + new -> Dynamic Web Project -> 파일명`model2Project` 생성 -> next -> next -> Web Module 세팅에서 directory:WebContent, `Generate web.xml deployment descriptor` 체크박스에 체크하기

   2. 브라우져 세팅 - chrome
      + Window -> Web Browser -> Chrome
   3. JSP인코딩을 UTF-8로하기
      + Window -> Preferences -> Web -> JSP Files -> Encoding: `ISO 10646/Unicode(UTF-8)`
   4. WebContent 밑에 JSP 파일 생성하기
      + new -> Other -> Web -> JSP file -> next -> 파일명 `index.jsp` -> next -> 버전설정 `html5`

   ---

   **JSP 실습하기**

   WebContent > WEB-INF  > index.jsp 파일

   ```jsp
   <%@ page language="java" contentType="text/html; charset=UTF-8"
   	pageEncoding="UTF-8"%>
   <%@ page import="java.util.Date"%>
   <!DOCTYPE html>
   <html>
   <head>
   <meta charset="UTF-8">
   <title>Insert title here</title>
   </head>
   <body>
   	<h2>사용자 관리 메인</h2>
   	<!-- html 주석 -->
   	<%-- jsp 주석 
   		<% %> : jsp에 java code를 자유롭게 기술할 수 있는 영역, scriptlet tag
   		<%= %> : java에 method의 실행결과, 변수를 입력, expression태그 
   	--%>
   	<%
   		Date date = new Date();
   		out.println(date); //콘솔이 아닌 브라우저 상에 뿌려준다.	
   	%>
   	<h4>현재 날짜는 <%=date%></h4>
   </body>
   </html>
   ```

   

   index.jsp 파일에 서버 설정하기

   ![Model2Project서버등록하기](https://user-images.githubusercontent.com/34231229/79409793-c51f1200-7fd9-11ea-876c-3b7ef80550b3.jpg)

   

   index.jsp Run 결과 (Run as -> Run on sever(Alt + Shift + X, R))

   <img src="https://user-images.githubusercontent.com/34231229/79410136-8dfd3080-7fda-11ea-8949-5da23b9fb346.jpg" alt="Runresult" style="zoom:50%;" />

   

   HelloServlet.java 파일 만들기

   주의: ProJect -> Build Automatically 체크 되어있어야한다.

   ---

   **GET/POST방식이 무엇이고 차이점은 무엇인지 (http통신방식)**

   GET, POST:클라이언트가 서버로 데이터를 보내는 방식

   

   request:클라이언트가 서버로 데이터를 주는거

   response : 서버에서 클라이언트에게 주는것

   

   **HelloServlet 클래스의 객체 생성은 누가 할까?**

   개발자는 클래스를 만들기만 한다.  -> xml 에다가 무엇을 만들었는지 설정을 추가로해야한다.

   WAS(Tomcat)이 수행한다.

   `@WebServlet("/Hello")` 방식을 사용하면 xml을 세팅하지 않아도 된다. @방식을 사용하면 이거를 통해 WAS가 알고 수행함.

   + **@없이 수행하기 (xml세팅하기)**

     ```xml
       <servlet>
       	<servlet-name>HelloServlet</servlet-name>
       	<servlet-class>Controller.HelloServlet</servlet-class>
       </servlet>
       <servlet-mapping>
       	<servlet-name>HelloServlet</servlet-name>
       	<url-pattern>/hello</url-pattern>
       </servlet-mapping>
     ```

   ---

   **JSTL(Java Standart Tag Library)**

   : JSP를 작성 시, java code를 사용하지 말자, **scriptless** `<% %>` 스크립트 태그 만 사용하자.

   > example}
   >
   > `<c:forEach>`
   >
   > `</c:foreach>`

   

   ---

   참고

   이러쿵저러쿵 블로그

   https://ooz.co.kr/219?category=818548