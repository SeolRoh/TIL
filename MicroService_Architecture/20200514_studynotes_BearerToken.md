20200514 Bearer Token Authorization 그리고 (JWT-Json Web Token)

---

OAuth와 JWT는 다름.

+ JWT

   : 토큰 유형

+ OAuth

  : 토큰을 발급하고 인증하는 방법을 설명하는 프레임워크

  + /oauth/token endpoint에 의해 발급되는 모든 토큰은 일종의 OAuth프레임워크에 의해 관리된다고 본다.



Bearer이란?

OAuth에서 주로 사용하는 bearer기반의 토큰 방식 여기서 JWT는 토큰 자체에 user 데이터를 담아서 HTTP헤더로 전달한다!  ========> 가볍게 데이터를 주고 받는다는 장점이 있음.



JWT토큰 기반의 인증시스템 프로세스

1. 로그인 시도
2. 서버는 해당 요청을 확인 후, secret key를 통해 access token발급
3. JWT가 요구되는 API를 요청할 때, 클라이언트가 Authorization header에 Access token을 담아서 보냄
4. 서버는 JWT Signature 체크, Payload로 부터 user정보를 확인후 데이터 리턴
5. 





메세지 큐잉 서버 ====> RabbitMQ ==>조금더 간단한 서비스 메세지(피보탈 서 제공)

아파치 카프카==>빅데이터



**RabbitMQ run ---> yml파일에서 사용하기 위함**

```powershell
PS C:\Users\HPE\work> docker run -d --name rabbitmq -p 5672:5672 -p 9090:15672 --restart=unless-stopped -e RABBITMQ_DEFA
ULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin rabbitmq:management
Unable to find image 'rabbitmq:management' locally
management: Pulling from library/rabbitmq
23884877105a: Pull complete
bc38caa0f5b9: Pull complete
2910811b6c42: Pull complete
36505266dcc6: Pull complete
15c38f93e1dd: Pull complete
5bbf29aa0268: Pull complete
3c6f3aa1c421: Pull complete
2c19dab5d802: Pull complete
ffc19363f52c: Pull complete
766023321682: Pull complete
fd8a4a897d34: Pull complete
53010f28dc34: Pull complete
Digest: sha256:3e3738bfe972c94a966c1746befb6d1d9dd50115e99004e9db391a00a2482516
Status: Downloaded newer image for rabbitmq:management
3969493d8eccd4dfd34e769dd25c6478380c5d4706386f4f3a4e7acc6b1354f4
```



```
gateway:
    ip: 172.28.39.97

token:
    expiration_time: 864000000
    secret: test_secret
```



**Dev 레파지토리 내부에 두개의 yml파일 생성 (file:///C:/Users/HPE/work/dev)**

1. users-ws.yml

   ```yml
   login:
       url:
         path: /users/login
         
   spring:
       datasource:
           url: jdbc:h2:mem:testdb
           username: sa
           password: sa
   ```

2. application.yml

   ```yaml
   gateway:
       ip: 172.28.39.97
   
   token:
       expiration_time: 864000000
       secret: test_secret
   ```

   

---

10:39AM

**시멘틱(Semantic security) 방법으로 암호화하기** 

> bootstrap.yml
> encrypt:
> 	key: abcdefghijklmnopqrstu1234567890 
>
> ​    //이부분 키값이 바뀌는 것에따라서 오류 여부 Test하기 (not~~써있음)
>
> postman
> http://localhost:8012/encrypt
> POST
> Body
> raw
> texts
> Hi encrypt! 입력시 200OK
> 해당 글 암호화 ==> 복사
>
> postman
> POST
> http://localhost:8012/decrypt
> 복사한 것을 그대로 입력 
> 그대로 Hi encrypt! 확인 가능

그 다음 users-ws.yml 파일 수정

```yaml

login:
    url:
      path: /users/login
      
spring:
    datasource:
        url: jdbc:h2:mem:testdb
        username: sa
        % password: sa
        % 위에서 포스트맨으로 encrypt되어 암호화 된것을 입력한다.
        password: '{cipher}_____암호화된것_______'
```

후에 확인해서 보면 encrypt되어 입력한것이 decrypt되어 볼수 있다.