20200520 zipkins

---

https://zipkin.io/pages/quickstart.html install zipkins



```
C:\Users\HPE\work>java -jar zipkin-server-2.21.1-exec.jar

                  oo
                 oooo
                oooooo
               oooooooo
              oooooooooo
             oooooooooooo
           ooooooo  ooooooo
          oooooo     ooooooo
         oooooo       ooooooo
        oooooo   o  o   oooooo
       oooooo   oo  oo   oooooo
     ooooooo  oooo  oooo  ooooooo
    oooooo   ooooo  ooooo  ooooooo
   oooooo   oooooo  oooooo  ooooooo
  oooooooo      oo  oo      oooooooo
  ooooooooooooo oo  oo ooooooooooooo
      oooooooooooo  oooooooooooo
          oooooooo  oooooooo
              oooo  oooo

     ________ ____  _  _____ _   _
    |__  /_ _|  _ \| |/ /_ _| \ | |
      / / | || |_) | ' / | ||  \| |
     / /_ | ||  __/| . \ | || |\  |
    |____|___|_|   |_|\_\___|_| \_|

:: version 2.21.1 :: commit c30ffc5 ::

2020-05-20 10:16:40.788  INFO 11696 --- [           main] z.s.ZipkinServer                         : Starting ZipkinServer on DESKTOP-GG5C4KI with PID 11696 (C:\Users\HPE\work\zipkin-server-2.21.1-exec.jar started by HPE in C:\Users\HPE\work)
2020-05-20 10:16:40.794  INFO 11696 --- [           main] z.s.ZipkinServer                         : The following profiles are active: shared
2020-05-20 10:16:42.884  INFO 11696 --- [           main] c.l.a.c.u.SystemInfo                     : Hostname: desktop-gg5c4ki (from 'hostname' command)
2020-05-20 10:16:43.853  INFO 11696 --- [oss-http-*:9411] c.l.a.s.Server                           : Serving HTTP at /0:0:0:0:0:0:0:0:9411 - http://127.0.0.1:9411/
2020-05-20 10:16:43.857  INFO 11696 --- [           main] c.l.a.s.ArmeriaAutoConfiguration         : Armeria server started at ports: {/0:0:0:0:0:0:0:0:9411=ServerPort(/0:0:0:0:0:0:0:0:9411, [http])}
2020-05-20 10:16:43.905  INFO 11696 --- [           main] z.s.ZipkinServer                         : Started ZipkinServer in 4.748 seconds (JVM running for 6.734)

```



trace ID



span ID 



1. 검색창에 넣고 확인하기 => users-ws: get /useres/{userid}
2. log하고 after만 두가지 정보 출력하기

```yaml
#users applicaion.yml
jpa: <1key>

zipkin:
	base-url: http://localhost:9421
	sender:
		type: web
	sleuth:
		sampler:
			probability: 1
		
eureka:
```

```
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-sleuth-zipkin</artifactId>
        </dependency>
```

```java
serviceimpl.java

        log.info("Before calling albums microservice");
        List<AlbumResponseModel> albumsList = albumServiceClient.getAlbums(userId);
        log.info("After calling albums microservice");
        userDto.setAlbums(albumsList);

```



---

11:11 AM

> discovery service
>
> 1.spring.security.user.name, spring.security.user.password
>
> 2.move to the configuration server
>
> 3.encryption(user,password)
>
> discovery server -> config 서버로 가져와서 코딩하는게 필요하다. ==> discovery server.yml 내 security부분 주석 
>
> 
>
> 주석처리한부분을 config서버로 옮겨졌으면 암호화가 필요하다.
>
> discovery는 config서버로 의 회원정보 값을 가져와 로그인 시켜줘야한다. 



rabbitmq doker로 실행

```
docker run -d --name rabbitmq -p 5672:5672 -p 9090:15672 --restart=unless-stopped -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin rabbitmq:management
```

포트번호 충돌시

> docker rm -f ... 후 재실행
>
> docker ps로 확인

```powershell
C:\Users\HPE\work>docker images
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
rabbitmq            management          이미지 아이디         8 days ago          181MB

C:\Users\HPE\work>docker ps
CONTAINER ID        IMAGE                 COMMAND                  CREATED             STATUS              PORTS                                                                                       NAMES
컨테이너 아이디       rabbitmq:management   "docker-entrypoint.s…"   26 minutes ago      Up 26 minutes       4369/tcp, 5671/tcp, 15671/tcp, 25672/tcp, 0.0.0.0:5672->5672/tcp, 0.0.0.0:9090->15672/tcp   rabbitmq
```

도커 불필요한거 삭제

```
C:\Users\HPE\work>docker system prune
WARNING! This will remove:
  - all stopped containers
  - all networks not used by at least one container
  - all dangling images
  - all dangling build cache

Are you sure you want to continue? [y/N] y
```



---

13:35 PM



버전일치 = release 시키는 부분 예시)

> master brach에 merger => 내가 가지고 있던것과 합쳐짐
>
> 홍길동이 merger => 초기 + 내가 가진거 + 홍길동것과 통합
>
> 이를 가지고 testversion or 운영버젼을 만들수 있다.
>
> 통합해주세요 기능 ==> pull request기능
>
> + 개발자 개개인이 머지를 할수 있는 권한자(관리자)에게 pull request를 보낸다.
> + 그다음 관리자가 가진 brach를 해서 merge 시킨다.
> + 문제사항시 관리자는 reject를 보낸다. 그뜻은 문제가있는지 check를 판단후 push를 하고 관리자에게 pullrequest 요청을 보낸다.
> + 관리자는 요청 받은것을 merger한다.하고 문제가 생긴다면 reject한다.
> + 두번째 사람이 똑같은 요청 시행
> + 개발자 ver1.01 홍길동 ver1.02 ====> 각각의 개발자가 이거두개를 머지시킴.

방법 

: 각각의 개발 환경에 release note만들기



Docker에다가 버전 일치시키는 부분 실습해보기



---

14:10 PM

1. 도커랑 EC2



2. 도커랑 도커스웜모드랑 EC2



3. 도커랑 쿠버네티스랑 EC2



**EC2를 이용해서 리눅스를 배포하는 것이 가장 일반적인 방법이다.**

local에는 유저스 서비스(R), 앨범서비스(R), 컨피그서버 서비스(8012), 유레카 서버 서비스(8010), APIgateway(8011), rabitMq(도커에다), Mysql(3306), zipkin(9421) 



실행 순서

1) config 2)rabbitmg -- ec2 	<==========> git repository

3)eureka -- ec2

4)Juul api gateway --ec2



그다음 마이크로 서비스 배치

5) 앨범 --ec2



그다음 AWS RDS 

MySQL



마지막 마이크로 서비스 배치

6) 유저 --ec2





postman ===> EC2에 내 IP와 내부전용 private IP 두가지 설정 

앞에 있는 인스턴스를 사용할수 있도록 보안그룹 설정

해당 인스턴스 실행시켜서 도커 설치

```dockerfile
docker 설치
sudo yum update
sud tum
~~
~~

rabbitmq설치 -- 로컬에는 이미 있어서 생략한다.
docker run -d --name rabbitmq -p 5672:5672 -p 9090:15672 --restart=unless-stopped -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin rabbitmq:management

create config server docker image 생성하기 ==>추후 배포할 예정

mvn 설치하기 

dockerfile만들기
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY apiEncryptionKey.jks apiEncryptionKey.jks
COPY UnlimitedJCEPolicyJDK8/* /usr/lib/jvm/java-1.8-openjdk/jre/lib/security
COPY target/myapp-config-server-0.1 ConfigServer.jar
ENTRYPOINT ["java","-Djava.security.egd=/file:/den/./urandom","-jar","ConfigServer.jar"]

// 보안설정의 값을 random 하기위함 ==> "-Djava.security.egd=/file:/den/./urandom"

docker build => terminal => 해당 디렉토리로가기 (프로젝트)
C:\Users\HPE\IdeaProjects\myapp-config-server>mvn clean
C:\Users\HPE\IdeaProjects\myapp-config-server>mvn package
C:\Users\HPE\IdeaProjects\myapp-config-server>docker build --tag seolroh/config-server --force-rm=true .
> \

수정해야할 일이 생기면 yml파일을 보면 rabbitmq에서 host: local host port: 5672

나머지 Eureka랑 Juul api gateway도 config 했던것처럼 이어서 하면된다.
>docker push seolroh/config-server
docker 잘 기동되는지 확인하기 - 포스트맨
AWS에서 사용한 주소와 같이 사용한다.
깃에서 데이터 정보를 가져와 뿌려 줄것이다.

```



