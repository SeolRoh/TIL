20200520 docker에 올리기

---

>적당히 사용한 docker명령어
>
>docker inspect 해당ps이름 ==> IPADDRESS 확인
>
>docker log 해당작동하는ps ==> error log확인

어제 이미 config는 올림

### config-server

docker file

```dockerfile
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY apiEncryptionKey.jks apiEncryptionKey.jks
COPY UnlimitedJCEPolicyJDK8/* /usr/lib/jvm/java-1.8-openjdk/jre/lib/security/
COPY target/myapp-config-server-0.1.jar ConfigServer.jar
ENTRYPOINT ["java","-Djava.security.egd=/file:/den/./urandom","-jar","ConfigServer.jar"]
```

```powershell
C:\Users\HPE\IdeaProjects\myapp-config-server>docker build --tag=seolroh/config-server --force-rm=true .

C:\Users\HPE\IdeaProjects\myapp-config-server>docker push seolroh/config-server

C:\Users\HPE\IdeaProjects\myapp-config-server>docker run -d -p 8012:8012 --name config-server -e "spring.rabbitmq.host=172.17.0.2"  -e "spring.profiles.active=default" seolroh/config-server
```

yml file

```yaml
server:
  port: 8012

spring:
  application:
    name: ConfigServer

  profiles:
    active: native

  cloud:
    config:
      server:
        git:
          uri: https://github.com/SeolRoh/MyAppConfiguration.git
          username: 
          password: 
          clone-on-start: true
        native:
          search-locations: file:///${user.home}/work/dev

    rabbitmq:
      host: 172.17.0.2
      port: 5672
      username: admin
      password: admin

management:
  endpoints:
    web:
      exposure:
        include: bus-refresh
```

---



오전

#### eureka, zuul-gateway올리기

- mvn clean
  - /target 에 있는 정보 초기화
- mvn package
  - /target 에 파일들이 생긴다.
- -d : 백그라운드로 실행하겠다는 옵션
- -p : 포트번호 설정 옵션
- -e : 환경을 설정하겠다는 옵션
  - 이렇게 실행하면 rabbitmq에 대한 설정정보를 수정했기 때문에 amqp에 대한 warn이 뜨지 않는다

### eureka-server

dockerfile

```dockerfile
FROM openjdk:8-jdk-alpine
COPY target/myapp-discovery-service-0.1.jar DiscoveryService.jar
ENTRYPOINT ["java","-jar","DiscoveryService.jar"]
```

```powershell
>mvn clean
>mvn package

C:\Users\HPE\IdeaProjects\myapp-discovery-service>docker build --tag=seolroh/eureka-server --force-rm=true .

C:\Users\HPE\IdeaProjects\myapp-discovery-service>docker push seolroh/eureka-server

C:\Users\HPE\IdeaProjects\myapp-discovery-service>docker run -d -p 8010:8010 --name eureka-server -e "spring.cloud.config.uri=http://172.17.0.3:8012" seolroh/eureka-server
```

yml file

```yaml
application.yml

server:
  port: 8010

spring:
  application:
    name: DiscoveryService
  security:
    user:
      name: test
      password: test

#    rabbitmq:
#      host: localhost
#      port: 5672
#      username: admin
#      password: admin

eureka:
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://test:test@localhost:${server.port}/eureka/

bootstrap.yml

spring:
  cloud:
    config:
      uri: http://localhost:8012
      name: DiscoveryService
```



### zuul-gateway

dockerfile

```dockerfile
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/myapp-zuul-gateway-0.0.1-SNAPSHOT.jar ZuulApiGateway.jar
ENTRYPOINT ["java","-jar","ZuulApiGateway.jar"]
```

```powershell
>mvn clean
>mvn package

C:\Users\HPE\IdeaProjects\myapp-zuul-gateway>docker build --tag=seolroh/zuul-gateway --force-rm=true .

C:\Users\HPE\IdeaProjects\myapp-zuul-gateway>docker push seolroh/zuul-gateway

C:\Users\HPE\IdeaProjects\myapp-zuul-gateway>docker run -d -p 8011:8011 --name zuul-gateway -e "spring.rabbitmq.host=172.17.0.2" -e "eureka.client.serviceUrl.defaultZone=http://test:test@172.17.0.4:8010/eureka/" -e "spring.cloud.config.uri=http://172.17.0.3:8012"  seolroh/zuul-gateway
```

yml file

```yaml
application.ymlk

server:
  port: 8011

spring:
  application:
    name: ZuulServer
    cloud:

    rabbitmq:
      host: localhost 
      port: 5672
      username: admin
      password: admin

eureka:
  client:
    serviceUrl:
     defaultZone: http://test:test@localhost:8010/eureka  

api:
  h2console:
    url:
      path: /users-ws/h2-console/**
  login:
    url:
      path: /users-ws/users/login
  registration:
    url:
      path: /users-ws/users

authorization:
  token:
    header:
      name: Authorization
      prefix: Bearer

token:
  secret: test_secret


bootstrap.yml

spring:
  cloud:
    config:
      uri: http://localhost:8012 #여기에도 맞게해야함
      name: ConfigServer
```



---

### albums-msa

dockerfile

```dockerfile
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/myapp-api-albums-0.0.1-SNAPSHOT.jar PhotoAppApiAlbums.jar
ENTRYPOINT ["java","-jar","PhotoAppApiAlbums.jar"]
```

```powershell
>mvn clean
>mvn package

C:\Users\HPE\IdeaProjects\PhotoAlbumService-master>docker build --tag=seolroh/albums-microservice --force-rm=true .

C:\Users\HPE\IdeaProjects\PhotoAlbumService-master>docker push seolroh/albums-microservice

C:\Users\HPE\IdeaProjects\PhotoAlbumService-master>docker run -d --name albums-msa  -e "server.port=30000" -p 30000:30000 -e "eureka.client.serviceUrl.defaultZone=http://test:test@172.17.0.4:8010/eureka" seolroh/albums-microservice
```

yml file

```yaml
server:
  port: ${PORT:0}

spring:
  application:
    name: albums-ws

eureka:
  client:
    serviceUrl:
      defaultZone: http://test:test@localhost:8010/eureka/
  instance:
    instance-id: ${spring.application.name}:${spring.application.instance_id:${random.value}}

  devtools:
    restart:
      enabled: true

```



### users-msa

docker file

```dockerfile
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/myapp-api-users-0.1-SNAPSHOT.jar MyAppApiUsers.jar
ENTRYPOINT ["java","-jar","MyAppApiUsers.jar"]
```

```powershell
>mvn clean
>mvn package

C:\Users\HPE\IdeaProjects\myapp-api-users>docker build --tag=seolroh/users-microservice --force-rm=true .

C:\Users\HPE\IdeaProjects\myapp-api-users>docker push seolroh/users-microservice

C:\Users\HPE\IdeaProjects\myapp-api-users>docker run -d --name users-msa -e "server.port=40000" -p 40000:40000 -e "spring.rabbitmq.host=172.17.0.2" -e "spring.zipkin.base-url=http://test:test@172.17.0.7:9411/" -e "eureka.client.serviceUrl.defaultZone=http://test:test@172.17.0.4:8010/eureka" -e "spring.cloud.config.uri=http://172.17.0.3:8012" -e "spring.datasource.url=jdbc:mysql://172.17.0.9:3307/springboot?serverTimezone=Asia/Seoul" seolroh/users-microservice
```

```
docker run -d 
-e "spring.zipkin.base-url=172.17.0.7:5673" 
-e "spring.cloud.config.url=172.17.03:8012" 
-e "spring.rabbitmq.host=172.17.0.2" 
-e "eureka.client.serviceUrl.defaultZone=http://test:test@172.17.0.4:8010/eureka/" 
-e "server.port=40000" 
-e "spring.datasource.url=jdbc:mysql://172.17.0.8:3306/spring_db?serverTimezone=UTC&characterEncoding=UTF-8"
-p 40000:40000 ry7791/users-microservice
```





yml file

```yaml
application.yml

server:
  port: 0

spring:
  application:
    name: users-ws
  rabbitmq:
    host: localhost
    port: 5672
    username: admin
    password: admin

# db 생성할 때.
  jpa:
    hibernate:
      ddl-auto: update

  devtools:
    restart:
      enable: true

  h2:
    console:
      enabled: true
      settings:
        web-allow-others: true

  zipkin:
    base-url: http://test:test@localhost:9411/
    sender:
      type: web
    sleuth:
      sampler:
        probability: 1  #1은 모든 요구가 다 된다라는 뜻

#  datasource:
#    url: jdbc:h2:mem:testdb

eureka:
  client:
    serviceUrl:
      defaultZone: http://test:test@localhost:8010/eureka
  instance:
    instance-id: ${spring.application.name}:${spring.application.instance_id:${random.value}}

gateway:
  ip: 172.24.231.49

#token:
#  expiration_time: 86400000 # 10 days (milliseconds) - 10일 동안은 token 사용 가능하다는 의미.
#  secret: local_secret

login:
  url:
    path: /users/login

logging:
  level:
    package com.example.myappapiusers.client: DEBUG

feign:
  hystrix:
    enabled: true

bootstrap.yml

spring:
  cloud:
    config:
      uri: http://localhost:8012
      name: users-ws
#     name:ConfigServer
```



---

### rabitmq

```powershell
docker run -d --name rabbitmq -p 5672:5672 -p 9090:15672 --restart=unless-stopped -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin rabbitmq:management
```



### zipkin

```powershell
docker run -d -p 5673:5673 --name zipkin openzipkin/zipkin -p 9091:15673 --restart=unless-stopped -e ZIPKIN_DEFAULT_USER=admin -e ZIPKIN_DEFAULT_PASS=admin zipkin:management
```



### mysql

```
// 도커에 mysql 깔아서 spring_db 만들어주자
docker pull mysql
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mysql --name mysql1 mysql
docker exec -i -t mysql1 bash
mysql -u root -p
create database spring_db;
```

