20200507 인텔리제이로 생성하는 스프링부트

---

HATEOAS 

- Hypermedia As the Engine Of Application State

- dependency추가

  ```xml
  <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-hateoas -->
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-hateoas</artifactId>
      <version>2.1.8.RELEASE</version> 
  </dependency>
  
  ```

  

- resource와 연관된 자원상태의 정보를 제공받을 수 있다.



Richardson Maturity Model

+ 레오날드 리차드슨
+  @JsonUnwrapped 
+ 총 Level3
+ Level 0
  + soap web 서비스 RESTstyle기반
+ Level 1
  + resources 클래스와 그에 적합한 uri
  + http methid
+ Level2
+ Level 3

---

Swagger-ui

```
http://localhost:9999/swagger-ui.htm
```

![캡처](https://user-images.githubusercontent.com/34231229/81248403-3725cc80-9057-11ea-9627-7603a7930dfa.JPG)



package파일 config > class SwaggerConfig사용

```java
@Configuration
@EnableSwagger2
public class Swaggerconfig{
		// 작업자의 연락, 이메일 등등의 정보 private static final 로 생성
		//apiInfo(DEFAULT_API_INFO)
        //produces(DEFAULT_PRODUCES_AND_CONSUMES)
        //consumes(DEFAULT_PRODUCES_AND_CONSUMES)
        //같은 것들
        
        @Bean
        public Docker api() {
        	// 위의 어노테이션과 return으로 Swagger2를 리턴
        	return new Docker(DocumentationType.SWAGGER_2);
        }
        
        //Error 발생시 아래 코드 사용
        @Bean
        public LinkDiscoverers disconverers(){
        	// List<> plugins 생성
        	// 플러그인을 추가.add
        	// return 하기
        }
}
```

