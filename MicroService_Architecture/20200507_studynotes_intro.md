20200507 Intro

---

사용하고자하는 모든 이해관계, 개발과 운영을 포함 -> 안정성을 지향

스타일 -> peer to peer, event ~~~ 이 모든 관계 설정을 포함



**Monolithic Architecture**

폭포수(waterfall)모델

다양한 업무의 로직들이 하나의 어플리케이션에 한곳에 모인 것.

단점: 데이터를 하나 기능을 하나(혹 극히 일부) 바꾸기 위해서도 전체가 다시 빌드와 배포를 이행해야한다.



**MicroServices Architecture**

각자배포

관리해주어야할 서비스와 솔루션이 늘어남에 따라 관리가 어려워짐 -> 관리의 자동화 -> DevOps(개발과 운영의 합)

다른 프로그래밍 언어를 각각의 서비스에 사용가능

각각의 다른 데이터 저장소 사용가능 (오라클~ , 로그 저장분석시 (관계형)RDB는 적정하지 않으니 NoSql이나 MongoDB, 등등)

중앙집중적 관리의 최소화

1)RESTful - http를 이용한 서비스  - 마이크로 서비스의 각각의 서비스가 통신하기 위한 수단으로 사용

2)Small Well Chosen Deployable Units - 작은 단위의 서비스가 구성되어 서로 조화하도록 연결/ 각각의 서비스는 독립적으로 배포함

3)Cloud Enabled - 클라우드 서비스가 가능하면 더 효율적. 아무래도 크기가 많이 커지기 때문

4)dynamic Scale up and Scale Down => Auto Scaling

5)Visibility => 시각적으로 관리할 수 있는 솔루션이 제공되어져야한다.

6)Solution

Centeralized configuration mangement-spring cloud config server

Location transparency-naming server(Eureka)

Load Distribution-로드발란싱ribbon (client side)

Visiiliity and monitoring-zipkin distributed tracing

-netflex API gateway

Fault Tolerance-hystrix

