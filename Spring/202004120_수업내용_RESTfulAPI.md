 20200420 spring MVC jsp연동, json,xml 데이터 포맷을 사용해서 REST 방식으로 웹서비스 작성하는 방법

---

17일 복습

> web.xml(web container 설정)
>
> :ContextLoaderListener 설정
>
> 	- Spring Beans Configuration 설정 파일의 위치
>
> :FrontController 역할을 하는 DispatcherServlet 클래스 정보 설정
>
> <url-pattern>*.do</url-pattern>
>
> 2.Controller 클래스 작성
>
> @Controller
>
> <context:component-scan base-packager="myspring.user />"
>
> @RequestMappping("/getUser.do")
>
> ​	:요청과  Controller 내에 선언된 메서드를 매핑해준다.
>
> @RequestParam
>
> :request.getParameter("userid")

@ModelAttribute

:form data 값을 추출해서 VO객체에 자동으로 저장해주는 어노테이션

Encoding

요청(request) 데이터 인코딩 - **요청에 따라 개별적으로 인코딩해야한다.**

:request.setCharacterEncoding("utf-8")

:Servlet Filter (공통적으로 사용되는 기능을 포함한 객체)사용

 Spring 에서 CharacterEncodingFilter클래스를 제공한다.

web.xml에 Filter설정

<filter>

​	<filter-class>CharacterEncodingFilter</filter-class>

​	<filter-class>org.spingframework.web.filterCharaterEncodingFilter

​	</filter-class>

<filter>

<filter-mapping>

​	<filter-name>CharacterEncodingFilter</filter-name>

</filter-mapping>

응답(response) 데이터 인코딩

:response.setContentType("text/html;charset=utf-8")

<%@ page contentType="text/html,charset=utf-8" %>



---

RESTful API란?

HTTP와 URI기반으로 자원에 접근할 수 있도록 제공하는 애플리케이션 개발 인터페이스 ( REST의 원리를 따르는 시스템은 RESTful이라는 용어로 지칭한다. )

GET / POST / DELETE / PUT 약속

읽기 / 등록 / 삭제 / 수정 

json은 xml보다 경량(lightweight)하다.

"name" : "홍길동",

"addr":"서울",

"phone":["01012345678","01023456789"]



UserVO-row1

List<UserVO> -row여러개

java object -> json / json -> java object변환   <u>json변환기 같은 것을 사용해야한다.</u>

:json processor 사용

:jackson opensource 



xml과 html차이 169페이지 참고

| xml      | html |
| -------- | ---- |
| 트리구조 |      |



Spring MVC기반 RESTful 웹서비스 구현 절차

@RestController

+ Rest 방식으로 사용하는 controller =====> ResponseBody처리를 알아서 해준다.
+ spring framework 4.0.1 ver ~

@RequestBody 

+ 요청을 Java객체로 전달 받는다.
+ UserVO앞에 적어줘야한다.

@ResponseBody

+ 응답을 전송 할 수 있다. (실제 변환 처리는 Jackson이 한다.)

REST client Tool (Postman)사용.





수정

데이터 읽어오는 페이지

입력하는 페이지 