 20200424 

---

+ @ModelAttribute 어노테이션

  :form data를VO객체에 저장
  
+ @Valid 어노테이션

  :@ModelAttribute +입력항목 검증

+ server에서 입력항목 검증 validation api - javax.validation 사용

  :@NotBlank

+ public String userCreate(@Valid UserVO user){

  }

**Thymeleaf(server-side template engine)의 장점**

spring의 객체를 태그로 지원한다.

+ th:class 
+ th:action="@{/adduser}"
+ th:object="${user}"
+ th:field="*{name}"
+ th:errors="*{all}"
+ th:if="${#fields.hasErroes('all')}" `#fields`는 spring result에 있는 `BindingResult`-UserController.java이다. 
+ th:each
+ th:text
+ th:href="@{/edit/{id}(id=${user.id})}" -> 사용하면서 url문자열에 id값을 넣어준다.