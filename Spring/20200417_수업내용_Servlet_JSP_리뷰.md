 20200417 Servlet_JSP리뷰

---

설정:

Run as >  run configurations > tomcat 8.5 > common > 인코딩 > other > UTF-8 설정

+ 인코딩은 반드시 getPrameter 하기전에 해야한다.

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet doGet() method called!!");
		//요청(request) 데이터의 인코딩 // 인코딩은 반드시 getPrameter 하기전에 해야한다.
		request.setCharacterEncoding("utf-8");
		
		String cmd = request.getParameter("cmd");
```



---

J2SE / J2EE (enterprise edtion)

: j2ee가 제공하는 API에는 대부분이 인터페이스로 구성되어 있다.

: 인터페이스들은 누가 구현하는가? was(web application server) vender

: was는? web container + ejb container = was의 두가지기능

: J2EE의 구성기능 > Servlet_JSP, ejb, jpa(java persistence api), jta(자바 트랜잭션), jms(java messaging service- 비동기- async)

: 대표> Servlet과 JSP

: Java 클래스안에 html 태그를 사용할 수 있다.

	>Servlet : java code 내에 html을 포함 시킬 수 있다. 클래스여서 컴파일 방식으로 바이너리 모드를 만든다. 수정 시 컴파일을 다시 해야한다. println이라는 메서드안에서 계속html태그를 사용해야해서 불편하다. 
	>
	>JSP: html이 주, html안에 java code를 포함 시킬 수 있다. Script(언어) 방식. sevlet의 단점을 보안하기 위해서 나옴. 서버사이드 방식에서 해보자에서 출발.

: html -  Servlet_JSP -> java

: MVC 패턴 (아키텍쳐 패턴 - 역할을 분리하자.)

: MVC 기반 Web application architecture 2 가지는? model1 model2

	>model2 아키텍쳐
	>
	>1.  View: JSP(jstl.jar-라이브러리), Html
	>2. Controller: Servlet
	>3. Model: java(dao, service, vo)

---

**OLTP(Online Transaction Procession)** 

+ 온라인상으로 실시간 요청이들어와 처리하는 방식의 어플리케이션 개발 방식
+ 사용자 업무 중심

**Batch**

+ 운영자 측면에서 데이터가 누적될 시 한꺼번에 처리하는 프로그램을 개발하는 방식
+ 데이터 운영 측면에 짜는 프로그램
+ 주마다 돌아가는 일배치, 월마다 돌아가는 월배치, 분기배치, 일년마다 돌아가는 배치
+ 