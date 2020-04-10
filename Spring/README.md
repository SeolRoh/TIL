# Spring Framework

이러쿵저러쿵 블로그와 백엔드 개발 현장 강의를 통해 스프링 프레임워크 기초를 공부한다.



1주차 - '마이크로서비스를 위한 자바'-복습

 https://github.com/SeolRoh/TIL/blob/master/Java/%EB%B3%B5%EC%8A%B5/README.md

**<u>2주차 - '스프링부트를 이용한 마이크로서비스 구축' 예습</u>**

---

사용 프로그램 : MyBatis, JPA(Java Persistence architecture)

### 용어정리

+ `logic`

1. Spring Framwork 란? 

   

   1. Java 플랫폼의 오픈소스 애플리케이션 프레임워크
   2. 자바 엔터프라이즈 개발을 편하게 하는 오픈 소스 경량급 Framework
   3. *자바SE로 된 자바 객체(POJO)를 자바EE에 의존적이지 않게 연결해주는 역할*
   4. Dynamic 웹 사이트 개발 
   5. 대한민국 전자 정부 표준 프레임워크 기반 기술

2. Framwork란?

   **"비기능적인 기능을 제공할 테니, 개발자는 BIZ 로직에 집중해라"**

   1. 개발할 때 필요한 설계의 기본, 베이스, 구조
   2. 재사용, 확장 가능한 라이브러리

3. Framework와 Library이 차이점

   + 제어권을 누가 주도하느냐?

     + 라이브러리 : 개발자가 주도

     + 프레임워크 : 프레임워크가 주도

       + 개발자가 작성한 클래스를 프레임워크의 컨테이너가 객체를 생성하고 setter method를 호출한다.

         

4. ​	DI

   부품들을 생성하고, 제품을 조립해주는 공정과정을 대신해 주는 라이브러리(역할자)

   + setter Ingection
   + Constructor Injection : 생성자의 아규먼트를 통해 한꺼번에 하는 방식으로 주입을 받는다.
   + method Ingection

5.  IoC (Inversion of Control) : 제어권의 역전

   - IoC 컨테이너
   - IoC 구현: DL(Dependency Lookup), DI(Dependency Injection)

6. Junit 

   + TDD, 단위테스트를 지원하는 프레임워크
   + @ 어노테이션 사용
   + @Test @Before @After @Autowired @Component
     + Spring Test Framework 사용





---

#### 출처

spring.io -> docs 페이지

https://docs.spring.io/spring/docs/5.1.14.RELEASE/javadoc-api/

이러쿵 저러쿵 블로그 https://ooz.co.kr/170

POJO (Plain Old Java Object, 평범한 자바빈즈 Javabeans 객체) 

https://ko.wikipedia.org/wiki/Plain_Old_Java_Object



