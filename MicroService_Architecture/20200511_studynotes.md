20200511

----

http://server/users ?id=1	->> requestparam



http://server/users?searchValue=test

http://server/users?searchValue=java

http://server/users?search_start=2019&search_end=2020



http://server/users/2019/2020



rest api

http://server/users/1  ?start=yew  ->> pathvariable

request body{

​	-> post(form)

}



---

실습 예제1

고객 ==주문==> 커피 <==제공== 커피 전문점 직원

===상세===> (회원, 비회원) ===주문===> 커피(커피 종류) <==제공(결제 및 주문처리)=== 커피 전문점 직원



커피주문 (화면) ==== 주문 처리 (서비스) ==== 데이터(커피 주문)



데이터 총 세개 /회원(회원확인 (서비스), 커피주문(커피주문 서비스),<--메세지큐--->  주문 처리 상태 확인 DB

도메인영역 -> 비즈니스 로직 관리 영역

스프링 부트 영역 -> 기술 종속적 영역, repository, test, service,congifuration, messageq



리소스 영역-> application.yml 형태로 작업할 예정



총 세가지 프로젝트

Root -> msa-book 설명:마이크로서비스 루트 프로젝트

Microservice -> msa-service-coffee-member,order, status 		회원정보서비스 프로젝트(데이터제어 - Mybatis), 커피주문서비스 프로젝트(데이터제어 - JPA  큐잉시스템 - Kafka 메시지 발행), 주문 처리 상태 확인 서비스 프로젝트(데이터제어 - Mybatis  큐잉시스템 - Kafka 메시지 구독)

