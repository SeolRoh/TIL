20200515

---

1. **왜 yml파일을 작성하는가? (1. application.yml 2. bootstrap.yml)**

   > 공통 환경 설정을 위해서

   ```yaml
   # application.yml 공통 환경설정 파일. 기본 프로파일은 native로 지정
   server:
     port: 9000
   spring:
     profiles:
       active: native
   ```

   local 환경설정 - 로컬 환경설정 파일을 사용하는 방법

   profile명 : native. 로컬의 경우에 환경설정 파일이 git이나 db에 없고 로컬에 있어서 자유롭게 수정하고 개발하기 위해서 이다. 

    @하단 native.search-location 설정 부분 참고

    @@하단 ${user.home} 참고 ==> 사용자의 홈디렉토리 의미 (윈도우: C:\Users\HPE) 하지만 호출시에는 `/`가 더 붙는다. 그리고 `\`는`/`로 바꿔서 yml파일 내에 작성해야한다.

   ```yaml
   # application.yml 로컬 환경설정 파일
   spring:
     profile: native
     cloud:
       config:
         server:
           native: # 서버 실행시 profile 설정시 native를 지정해야 적용됩니다.
             search-locations: file:///${user.home}/work/dev
             # window - C:\Users\계정명\server-configs
             #search-locations: file://${user.home}/server-configs # mac, linux
             #search-locations: classpath:/server-configs
   ```

   서비스별 환경 설정 추가

   위의 `file:///${user.home}/work/dev` 디렉토리에 `application.yml`과 `users-ws.yml` 파일을 작성한다.  [**Dev 레파지토리 내부에 두개의 yml파일 생성 (file:///C:/Users/HPE/work/dev)**](https://github.com/SeolRoh/TIL/blob/master/MicroService_Architecture/20200514_studynotes_BearerToken.md) 부분 참고



​		환경설정 확인

​		ConfigServer를 실행하고 POSTMAN이나 콘솔로 확인. 

​		`localhost:8011/ConfigServer`, `$ curl http://localhost:8011/ConfigServer`



​		Client Service 서비스 만들기

		+ Configuration 서버에서 설정값을 읽어 시스템을 구성하는 Client 서버를 2대 더 생성합니다. 각각 member-service, contents-service로 어플리케이션을 설정하고 8080, 8081 포트로 서버를 실행하여 테스트를 진행합니다.+ 라고 블로그글을 가져옴.





2. **왜 두개의 yml파일을 작성했는가?** **********

   > bootstrap.yml파일은 application.yml보다 먼저 로드 되어 적용된다. ----------블로그 코드 가져옴
   >
   > **spring.application.name은 config서버에서 설정값을 조회할때 구분하기 위한 서비스 이름.**

   ```yaml
   # member-service bootstrap.yml
   server:
     port: 8080
   spring:
     profiles:
       active: local
     application:
       name: member-service
   management:
     endpoints:
       web:
         exposure:
           include: info, refresh
   # contents-service bootstrap.yml
   server:
     port: 8081
   spring:
     profiles:
       active: local
     application:
       name: contents-service
   management:
     endpoints:
       web:
         exposure:
           include: info, refresh
   ```



​		local 환경설정

+ 서버의 환경 설정은 config서버에서 받아와야한다. ==> config서버의 주소를 명시한다.

  ```yaml
  # member-service, contents-service bootstrap-local.yml 
  spring:
    profiles: local
    cloud:
      config:
        uri: http://localhost:9000
        fail-fast: true 
        # client server를 시작할 때 config서버에서 정보를 로드할 수 없을 경우 ,
        # 서버를 실행하지 않겠다고 하는 설정
  ```



​		Applicatin설정

​		블로그에서는 두개의 서버설정과 두개의 프로젝트를 MSA하고 있다.

​		각각의 @SpringBootApplication확인 - 따로 추가되는 설정은 X



 3. **왜 github에 yml파일을 올렸을까? (새 레파지토리를 생성해서 넣음)**]

    > 블로그에서는 
    >
    > ===> local서버는 local환경의 파일을 읽어 설정 값을 가져오게 하였고 (수업시 dev파일내에 작성한 두개의 yaml파일을 떠올려보자.)
    >
    > ===>alpha서버는 github에 설정된 값을 이용해 실습해 보고자 한다. (블로그에서는 그냥 실습용도로 한것같다. ++ 두개의 yaml파일을 github에 commit하였고 이부분에서 한개만 commit한 **수업과 다름!!)**
>
    > ​			또, git에다올리면 msa설정을 바꾸지 않고 사용할수 있다.
    
    ```yaml
    #application.yml파일 내에 작성한다.
    gateway:
        ip: 172.28.39.97
    
    token:
        expiration_time: 864000000
        secret: test_secret
    ```



​		config서버 alpha 설정 추가

​		알파환경으로 서버를 띄울경우 github의 특정 디렉터리 하위의 파일을 읽도록 yml파일에 설정한다.

​		git의 public repository를 사용한다면 인증이 필요X private repository를 사용한다면 

+ 아래의 yml파일처럼 설정에 인증내용도 추가해야한다. 

  ```yaml
  # bootstrap-alpha.yml
  spring:
    profile: alpha
    cloud:
      config:
        server:
          git:
            uri: https://github.com/SeolRoh/MyAppConfiguration
            # username: SeolRoh #수업에서 추가한 부분
            # password: 해당 깃 계정의 비밀번호
            # clone-on-start: true #클론이 필요하다.(private기준)
            search-paths: server-configs
  ```



​		github에 설정추가

​		github에서 yml파일 두개를 생성하고 commit한다. (블로그 기준에서)





4. **config(profile 관리 설정 서버)/ 유레카서버/ Zuul 서버 차이는?** (coffee 실습에서의 역할) 

   > ☻config(profile 관리 설정 서버 ☻
   >
   > : 깃 저장소에 등록된 프로파일 연계
   >
   > ☻유레카서버☻
   >
   > : 마이크로 서비스 등록 및 발견
   >
   > ☻Zuul 서버☻
   >
   > : 마이크로 서비스 부하 분산 및 서비스 라우팅
   >
   > ☻Queuing system☻
   >
   > : 마이크로서비스 간 메시지 발행 및 구독 
   >
   > : 카프카-> bigdata시 용이 아파치 하둡(대용량+하둡을 서포트해주는 제품이 많다=hadoop echo system ==> 이 시스템을 관리하는 것이 **Zookeeper**라는 제품)
   >
   > : rabbitMQ
   >
   > Git repository
   >
   > : 마이크로 서비스 소스 관리 및 프로파일 관리
   >
   > MicroService
   >
   > : 커피주문, 회원 확인, 주문 처리 상태 확인 서비스
   >
   > Turbine Server
   >
   > : 마이크로 서비스의 스트림 데이터/로그파일 수집
   >
   > Hystrix Dashboard
   >
   > : 마이크로서비스 스트림 데이터 모니터링 및 시각화
   >
   > : 수업 실습시간에 대시보드를 가려줄수 있는 용도와 해쉬태그? 어쩌고 용도로 사용할 예정이다.
   >
   > 
   >
   > **** 해당 글은 강의내에 수업한 PDF파일 속 한 페이지를 그대로 가져왔습니다.





---

해당 부분 사이트 참고 

https://daddyprogrammer.org/post/4347/spring-cloud-msa-configuration-server/

 