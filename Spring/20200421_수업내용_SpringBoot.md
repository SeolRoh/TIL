 20200421

---

third-party library/framework

1. tomcat - web container
2. log4j - logging, log level
3. mybatis - ORM,db연동
4. jackson - json parsor
5. junit - 단위테스트 지원
6. dbcp(database connection pooling)



java

​	1.jdbc

2. Servlet/JSP
3. jaxb

---

##### Spring boot Project 작성 시 유의사항

1. src/main/java 아래에 있는 base packager 와 다른 별도의 package를 작성하며 안된다.

   이유: base package가 componentScan을 시작하는 package이므로

2. src/test/java 하위에 테스트 클래스를 만들어야한다.

   이유: boot test Dependency 설정에서 scope가 test로 범위가 정해져 있기 때문이다.

   <scope>test</scope>

3. src/main/resources 아래에 application.properies 파일이 위치하고

   static: html,css,js 가 이 밑에 와야한다.

   templates: jsp, html(thymeleaf)

   resources: 하위에 sub 폴더를 생성해서 제대로 동작하기 위해서는 <u>반드시 `ConfigClass`에 설정해야한다.</u>



+ MyspringbootApplication

````java
@SpringBootApplication
public class MyspringbootApplication {
			//spring bean클래스를 만들어준다. -- MyspringbootApplication	
	public static void main(String[] args) {
		SpringApplication.run(MyspringbootApplication.class, args);
	}

}
````

+ @MyspringbootApplication

  >+ @MyspringbootConfiguration + @EnableAutoConfiguration + @ComponentScan
  >
  >+ Java Config 프로젝트 기반으로 선언하고 있다.
  >+ @Configuration 어노테이션을 선언한 Config 클래스 작성
  >+ WebMvcConfiguration / DispatcherConfiguration 등

My Spring Boot ${spring-boot.version} / ${application.version}



**Spring Boot 특징**

1. stand-alone, production-grade
2. configuration xml 을 설정하지 않는다.
3. 개발자들이 많이 사용하는 thied-party library(.jar) 들의 dependency
   + boot-starter-web, boot-starter-test, boot-starter-data
4. Actuator(모니터링)제공한다. 
5. .`jar` 형태로 배포가 가능하다.



**Spring Initializer** 

https://start.spring.io/



**Web Application Type**

:default => SEVLET

:REACTIVE

NONE



**프로퍼티 우선순위**

> target>java -jar jartest-0.0.1-SNAPSHOT.jar --seoul.name=springboot

Type-Safe

`@ConfigurationProperties`를 이용해서  Type-Safe Property class를 작성할 수 있다.



**파일이 변경될때 마다 자동으로 restart 해주는 <dependency> (개발모드에서 사용시 유리)**

```
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-devtools</artifactId>
</dependency>
```

