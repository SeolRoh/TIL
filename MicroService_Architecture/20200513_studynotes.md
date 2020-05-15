20200513 여기서 회원가입부분은 **마이크로 서비스**에 해당하는 부분

----

Zuul

> 넷플릭스에서 사용하는 JVM 기반의 라우터ㅡ 로드발란서
>
> 인증, 보안 기능
>
> 모니터링, 분석 기능
>
> 동적라우팅
>
> 트래픽 조정 
>
> (각각의 서비스 와 로드발란서 사이 단에 Zuul을 심어 놓는다.example> client단과 member-api단 사이에! )
>
> 기본적으로 Apache HTTP client 사용
>
> 유레카도 같이 사용 가능
>
> Pre filter, Post filter, Router filter

---

actuator를 이용하면 서버의 상태를 확인 가능

config 서버 만들때 Application에 2가지 annoataion 必

- @SpringBootApplication
- @EnableConfigServer

**<u> spring.application.name** 은 unique 해야함  **중요!!** </u>



---



]**User Sign Up** Architecture

+ Create User(Sign-up)
+ User login(Sign-in or 승인-인증 토큰 사용)
+ Get User Detail
+ Update User
+ Delete User

----

**설계**

 --> 최상단 Client App / 중간단 API Gateway / 최하단 Users 마이크로서비스들, Photos 마이크로서비스, Albums마이크로 서비스 (이외 Upload단을 위한 마이크로 서비스) ===> 이렇게 기능에 맞추어 구분하여 개발

---

Application Layer(Postman 사용 예정)

디바이스 ====> Presentation 층(고객이 볼 단) ====> Service 층 ====> Data 층 ===============>|| 		 ||

​	UserModelRest => UsersRestController				   ===>UserDto              ==>UserRepository ==>||   My  ||

​												||										||				||	          ||									  ||  SQL ||

​												===> UserDto ==>UsersService		  ====>UserEntity							   ||	      ||

---

RequestModel 만들기



---

서버 켜는 순서

유레카 서버(discovery) OR 컨피그서버 -> 줄 서버 ->  그다음 myapp-api-users 프로젝트 실행

