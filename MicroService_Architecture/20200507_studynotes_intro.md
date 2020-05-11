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

-netflex API gateway(권한 인증, 권한 제어와 보안을 작업,)

Fault Tolerance(문제가 생기는 서비스가있으면 우회하여 제공.)-hystrix



웹앱으로 만들수 있는 것들은 모두 마이크로서비스로 개발 가능하다.



SOA(Service oriented Architecture)와 MSA차이

SOA - 여러개의 서비스를 한 데모아 같이 관리하고 운영 / web service(SOAP 사용)- 필수적으로 어떠한데이터가 어떠한 요청으로 가는지 header와 body 정의 필, WSDL이라고 어떠한 리소스가 들어가는지 정의되는 문서 존재.

MAS - 각각의 서비스들이 RESTapi를 기반으로 운영하고 송수신, 로드발란서 지원  -- +a = 이를 Cloud Native 환경

		- http프로토콜과 메소드 보내고 GET PUT POST DELETE를 이용하여 정의

각각의 서비스 공유를 최대화/최소화 차이



REST

+ Level 0
  + localhost:0000/user
  + localhost:0000/userlist
  + localhost:0000/userinfo
+ Level 1 
  + localhost:0000/user
  + localhost:0000/user/10
+ Level2
  + Level1 + Http Methods(GET POST PUT DELETE)
+ Level3
  + Level2 + HATAOAS
  + 링크적으로 전달해주는 방식 12345번이면 서로 별모양으로 통신하듯이
  + 가급적 복수형 명사형 형태로 만듦 (예외 제외 - 고유명사일때)
+ Response Status
  + 200-Succees
  + 201-Created 
  + 400 번대 - client잘못
    + 405-Clent 호출 잘못 (ex 지원하지 않는 메소드 호출시)
  + 500 - Server



Cloud Native 환경 Application

클라우드 네이티브 환경에서 SaaS나 F(function)aaS 형태로 서비스되는 Application

MSA들을 올려서 다양하게 서비스하거나 Application을 배포



**형상관리** 

**12 개의 Factors**

1. **CodeBase**
   + Application 집중하는데 있어서 코드를 한곳에 보관해야한다. (ex cloud) 
   + 하나의 단일 코드관리 저장소 필
   + 운영환경에 맞춘 다양한 CodeBase를 만드는 것도 좋다. (개발상태, 테스트 상태, 운영상태 레파지토리)
2. Dependency(독립성) Isolation
   + AOP library / CI library,,, 팀원들끼리 공유가 되어져야한다.
   + ex) pom.xml 파일만 동일하게 작성한다면 `.jar`파일이 생성되어 직접 설치하는 번거로움X
3. Configuration
   + 환경설정공간 (ex 자주사용 -> git 형상관리 tool / history를 같이 관리 가능)
4. Backing Services
   + 백단에서 관리할수 있는.  cloud환경에서 필요한 백업시스템 구현
   + DB같은거 백업
5. Build, Release, Run
   + 컴파일 -> 패키징 -> 실행
   + 각각 독립적으로 수행
   + Dev, QA, Production 환경에서도 각각의 build, release,Run이 수행되어져야 함.
6. Process
   + 하나의 어플리케이션이 다른쪽에 종속이 지양
7. Port binding
   + 기존에 사용하던 포트를 적절하게 다른환경에 맞춰서 서비스가 될 수 있도록 하는 것.
   + 포트가 자유롭게 전환 될수 있어야함
8. Concurrency
   + Must be able to span multiple machines, or containers
9. Disposability
   + 필요하지않는 데이터는 즉시적으로 삭제되어져야함
   + Enhances scalability and fault tolerance
10. Dev.Prod parity
    + 운영, 테스트, 개발 환경들이 각 독립적으로 나뉘어져 실행되어져야함
    + 환경자체를 분리해서 사용 DB도 분리해서 테스트
11. Logs
    + Logging as a Service
    + 로그 단의 개별적으로 분리시켜 서비스 할 수도있다. -> 정확한 로그를 확인하기 위해 (디버그나 사용자가 호출한 내역 확인을 위함)
    + 로그 확인을 위해 print문장을 수행하다 다른 단에서 오류가 날수 있기 때문
12. Admin processes 관리자 process, tool
    + MSA Application 상태확인 용도
    + Database의 Migrations이 잘 수행하는지 확인 등

최근엔 여기서 +3가지 추가 **(about Pivotal)**



Cloud Native Architecture

+ 확장 가능한 

+ 탄력적 

+ 오류나도 다른 서비스에 영향이 미치지 않음

+ *컨테이너기반* _ 시스템 || 서비스 단위의 패키지

+ 동적 관리 -> 변경 서비스 가 있다면 파악 가능

+ __CI__ (Continuous Integration) 통합서버, 소스관리, 빌드 tool, test tool 

  ex) 젠킨스_CI/CD용 오픈 소스 git에서 데이터를 가져와 사용함.

+ 지속적인 배포 용이 Continuous Deployment(+Delivery) = __CD__



---

DevOps(Developments + Operations)

-> engineer의 역할 많아짐 (Programming, Build, Deploy, Run the service)

->매일 설계, 구현, 테스트를 한다. (매주X)



Agile : 고객의 needs사항을 바로 반영하기 위함. (가장 큰 사용 요인)

특징

경량 프로세스

cooperation biz, feedback

Development Cycle 짧은 단위의 반복되는 개발 -> 개선사항 발생> 고객의 만족도> 퀄리티 향상> 지속적인 release

문서를 통한 개발 방법론 X  / **실질적인 코딩을 통한 방법론 O**



### Working Software



빌드한 것 =>> Dev서버에 배포 =>> 유저의 테스트 =>> 유저의 Sign-up =>> Staging =>> PROD (실제 운영 확인)

> 용어 정리
>
> Staging : 운영환경과 비슷한 환경을 개발한 후, 운영환경으로 이전하기 전, 보안, 성능, 장애요인과 같은 것들을 검증하는 환경 단계
>
> Poligrot: 전체 서비스를 하면서 각각 다른 언어를 사용가능하다.



Bounded Context(독립적인 서비스)

+ 독립적으로 실행이 되어야한다. 타 서비스와 결합이 없어야 함.
+ 타 서비스 의 장애에 대해 영향 맞지 않아야 함.

응집된 서비스

+ 관계가 있는 데이터 끼리는 통합해보자

자율적 서비스

+ 독립적인 오너십을 가지고 있어야한다. ==>> 독립적인 서버가 인대도 가능
+ 협력 관계의 프로젝트를 진행시 타 부서의 프로젝트와 관계없(신경 쓰지 않고) 개발이 가능



마이크로서비스 기획

+ 마이크로서비스 식별 전략

  + 개념, 기능, 데이터

  + 구분, 도메인 이해, 마이크로 서비스

  + 업무 기능(업무 특성, 기능 분할) ==>> 우선순위(중요도, 영향도, Pilot, MVP대상)

  + 특화, 공용, 일반, 솔루션 대체 기능, 배치, 인터페이스

  + 데이터간 관계확인(단어, 용어의 의미 , 스키마 중복데이터 허용할건지 등등 설정)

  + 원칙 시준 ==>

  + 분할된 서비스(마이크로서비스 후보)

  + 서비스 식별 전략 - 상관 분석(쪼갠 데이터의 사용자, 업무, 데이터 간 상관관계)

    + 하향식 접근 

      : 

    + 상향식 접근

    + 서비스 일부 분리

      : 서비스가 준비 되어있는 상태에서는 서비스의 일부 분리가 가능

    ----

    + 서비스와 데이터 관계

    + 서비스 간의 종속성

      : 하나의 서비스안에 포함되는 것이 독립적으로 실행되고 배포될수 있는 지의 여부

    + 데이터간의 종속성

      : DB는 서비스 별로 쪼개야 한다. 라이센스 비용을 지불해야하는데 이에 맞춰서 MSA를 잘 구분할 수 있는지의 여부 중요, `두개의 스키마를 쪼갰다고 가정할 경우, 하나의 데이터가 잘못되었을 때 롤백과 커밋 즉 데이타를 트랜직션 처리할수 있는 매커니즘이 있어야 하는지 정해야한다.` 

      : 마이크로서비스 간 데이터 연계 =>> 메시지 Queue방식 사용, 

      `localost:8088/users`hostmapping해서 data를 보낸다 가정하자, payload랑 endpoint어쩌구,,,,

  + 데이터 분할 전략

+ 마이크로서비스 고려사항

  1. 조직의 구성

     + 구축 || 조직(소규모 팀, 역할별 팀원, 자율적 권한) || 운영

     + `애자일`과 `데브 옵스`

       : 무한 사이클, 무한 피드백을 받고 개선사항을 수정하고 개발, 테스트, 배포하고 반복

  2. 클라우드 네이티브 기술환경

     + CI(통합)/CD(배포)
     + 데브옵스 : 빌드 릴리즈 개발 배포 모니터링 등등을 반복 `8` 
     + 마이크로서비스들
     + 컨테이너

     결국 개발 조직과 운영 조직을 혼합하겠다는 뜻.



Microservices Architetecture and __`Polyglot`__ Persistence

​	



---

spring boot 상속관계설명(++ 제약조건 포함)

implements(class -> interface상속)

extends(class-> class)

interface -> class **X**

extends (interface -> interface)



**인터페이스 완벽하게 구현!!**

```java
    @Override
    public User removeUser(Integer id) {
        // list, -> map(key, value), not ordering
        // list -> ordering 지원가능 순차적인 데이터 참조
        // map -> ordering 지원이 어려우나 key값을 참조해서 접근가능, duplicate 중복 허용
            // HashMap, HashTable
            // SortMap
        // set -> set ordering, not duplicate 중복을 허용하지 않음
        Iterator<User> iterator = list.iterator();
        while(iterator.hasNext()){ // 메소드를 읽어올 요소 확인 false, true
            User user = iterator.next(); // Object의 메소드를 읽어올 요소 확인 false, true
            if(user.getId() == id){
                // next로 읽어온 요소를 삭제 next 호출한 다음에 remove 를 선택적으로 사용한다.
                iterator.remove();
                return user;
            }
        }
        return null;
    }
```

---

두번째 실습

application.yml 

```
server:
  port: 8088

spring:
  datasource:
    url:  jdbc:mysql://localhost:3306/springboot
    username: username 설정
    password: password 설정
    driver-class-name: com.mysql.cj.jdbc.Driver

mybatis:
  type-aliases-package: com.example.springbootmybatis.entity
  mapper-locations: mapper/**/*.xml
```



UserMapper.xml 작성

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

// 해당 패키지내의 해당 인터페이스 클래스와 매핑해주겠다는 뜻
// 그럼 nampespace에 작성한대로 클래스를 생성해줘야하고 데이터 정의를 할 예정
<mapper namespace="com.example.springbootmybatis.repository.UserMapper">
    <select id="selectAllUsers"
            resultType="com.example.springbootmybatis.entity.Users">
        select id, name, email, createAt from users
        order by createAt desc
    </select>
    <select id="selectUserById"
        resultType="com.example.springbootmybatis.entity.Users"
        parameterType="string">
        select id, name, email, createAt from users
        where id=#{id}
    </select>
    <insert id="insertUser"
            parameterType="com.example.springbootmybatis.entity.Users">
        insert into users(id,name,email) values(#{id},#{name},#{email})
    </insert>
    <update id="updateUser">
        update users set name=#{name}, email=#{email}, where  id=#{id}
    </update>
    <delete id="deleteUser">
        delete from users where id=#{id}
    </delete>
</mapper>
```





---

코드 참고

https://www.springboottutorial.com/microservices-and-restful-services-with-spring-boot-for-beginners

