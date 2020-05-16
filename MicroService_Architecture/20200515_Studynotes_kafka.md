20200515 kafka zookeeper

---

zookeeprt 

current working dir>

C:\Users\HPE\work\kafka_2.12-2.3.1 //현재 디렉토리라고 가정하자

​									\bin

​								    \config

(linux or mac)

./bin/zookeeper-server-start.sh config/zookeep.properties

(windows)

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties (cmd1번 흰창)

.\bin\windows\kafka-server-start.bat .\config\server.properties(cmd2번 노란창)

>cmd창 네개
>
>주키퍼 창
>
>카프카
>
>command창
>
>message를 보내는 test용 창

발행과 구독

각자 토픽이 있다. 관심이 있다고 한 토픽을 주고 받게된다.

```powershell
cmd3번 파란창
C:\Users\HPE\work\kafka_2.12-2.3.1>.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic msa_20200515
WARNING: Due to limitations in metric names, topics with a period ('.') or underscore ('_') could collide. To avoid issues it is best to use either, but not both.
Created topic msa_20200515.

정상적으로 만들었는지 확인하기
C:\Users\HPE\work\kafka_2.12-2.3.1>.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
msa_20200515
```



13:56 PM 현 상황

<img src="https://user-images.githubusercontent.com/34231229/82012855-e3009500-96b3-11ea-9778-719868a81d2c.jpg" alt="1" style="zoom: 50%;" />

계속 **카프카로 큐잉 테스트 해보기**

---

```
파란거
C:\Users\HPE\work\kafka_2.12-2.3.1>.\bin\windows\kafka-console-consumer.bat  --bootstrap-server localhost:9092 --topic msa_20200515
```

```powershell
새로판거 주황배경(프로듀서)
C:\Users\HPE\work\kafka_2.12-2.3.1>.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic msa_20200515
>Hello
>Hi there
>americano.1
>
///라고 입력을 했더니
파란색 창에(컨슈머)
Hello
Hi there
americano.1
이게 실시간으로 틀어졌다.

이 위의 두개창은 껏다!!! 단순히 테스트용!
```

---

커피예제 돌아가서 수행해보자!

순서대로 실행하기

1. 주키퍼, 카프카 cmd로
2. config server :8888
3. Eureka server:9091
4. Zuul Server:9090 나는 포트 충돌로 9089
5. Turbine server:9599
6. Hystrix Dashboard :7070
7. Book 프로젝트 내의 member, order, status순서대로 실행

`localhost:9999/turbine.stream`

`http://localhost:7070/hystrix.stream`로 접속

---

Eureka server 접속

http://localhost:9091/

Hystrix Dashboard

http://localhost:7070/hystrix.stream  => Hystrix Stream: http://localhost:9999/turbine.stream

H2-Console접속

http://localhost:8081/console/ 테스트 하고있는 member 서비스 

http://localhost:8082/console/ 테스트 하고있는 Status 서비스

---

member테이블 / member데이터 / status테이블 / 넣기

> 1. http://localhost:9090/member/createMemberTable db접속 => http://localhost:8081/console/
>
> 2. http://localhost:9090/member/insertMemberData db접속=> http://localhost:8081/console/
>
> 3. http://localhost:9090/status/createStatusTable db접속=> http://localhost:8082/console/



version config 변경 `gradle`

3_msa

```
buildscript {
	ext {
		springBootVersion = '1.5.22.RELEASE'
	}}
```

---

Hystrix Dashboard

http://localhost:7070/hystrix.stream  => Hystrix Stream: http://localhost:9999/turbine.stream



order DB table에 주문을 넣고 대시보드로 확인

![1](https://user-images.githubusercontent.com/34231229/82108301-90cd7b80-9768-11ea-922e-97a47ddb35be.jpg)

---

주문 정보를 메시지 큐에 발행되었다 확인은 ==> console창

```powershell
###########주문 정보를 메시지 큐에 발행#######
KafkaProducer send data from msa-service-coffee-order: CoffeeOrderCVO(id=, orderNumber=1, coffeeName=espresso, coffeeCount=2, customerName=kevin)
```

```powershell
###########coffee order msa에서 발행한 주문 내역 messager 구독 part #######
kafkaMessage : =====> {"id":"","orderNumber":"1","coffeeName":"americano","coffeeCount":"2","customerName":"kevin"}
kafkaMessage : =====> {"id":"","orderNumber":"2","coffeeName":"water","coffeeCount":"2","customerName":"kevin"}
```

---

그다음 `status` DB에 저장된다.

---

***fallbackTest*** 하기

Postman Get방식 => http://localhost:9090/member/fallbackTest => 반환값: `fallbackFunction()`

에러가 발생시 에러의 요구를 실행시켜준다. 예외 발생하면 500번과같은 에러 대신에 `fallbackFunction()` 리턴

200 OK가 나와 사용자입장에서는 오류가 난 상황이지만 실제로 서버단에서는 예외가 발생했다. (오류발생으로)

> ```java
> @HystrixCommand(fallbackMethod = "fallbackFunction")
> @RequestMapping(value = "/fallbackTest", method = RequestMethod.GET)
> public String fallbackTest() throws Throwable {
>     throw new Throwable("fallbackTest");
> }
> 
> public String fallbackFunction() {
>     return "fallbackFunction()";
> }
> ```

Hystrix Steam에 즉각 반영됨을 알수 있다.

---

`fallbackTest`예외처리에 대한 __`오류의 수치`__를 제한하기 `폴백전략`

> 폴백 전략은 MSA가 데이터를 검색할 호출이 실해하는 상황에 매우 적합
>
> 자원이 타임아웃되거나 실패할 때 행동 방침을 제공하는 메커니즘
>
> 폴백을 사용해 타임아웃 예외를 잡아내고 에러 로깅만 한다면 서비스 호출 전후로 try~catch블록을 사용하고 로깅 로직을 그 블록 안에 넣어도 된다.
>
> 폴백 서비스에서 다른 분산 서비스를 호출한다면, @HystrixCommand 어노테이션으로 폴백을 반드시 감싸야한다. => 방어적 코딩 요함

히스트릭스 세부 설정

실습커맨드가 발동하는 조건

```java
//해당 히스트릭스 메소드의 어노테이션에 추가
//총 두개의 옵션값
    @HystrixCommand(fallbackMethod = "fallbackFunction",
    commandProperties = {
        	//3초동안에
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
            value = "3000"),
            // 50퍼센트 오류발생시 발동 에러에 대한 기본 임계치 50퍼센트
            @HystrixProperty(
                    name = "circuitBreaker.errorThresholdPercentage",
                    value = "50"
            ),
            //히스트릭스가 호출 차단을 고려하는데 필요하는 3초 시간대 동안 연속 호출 횟수를 제어
        	@HystrixProperty(
                    name = "circuitBreaker.requestVolumeThreshold",
                    value = "2"
            ),
        	//차단되고 나서 히스트릭스가 서비스의 회복 상태를 확인할 때까지 대기할 시간 간격
            @HystrixProperty(
                    name = "circuitBreaker.sleepWindowInMilliseconds",
                    value = "5000"
            )
    })

```

```java
@Slf4j //로그 출력을 위해

    public String fallbackFunction(Throwable t) {
    	//로그 출력 부분 추가
        log.info(t.getMessage());
        return "fallbackFunction()";
    }

//후, 멤버 프로젝트 재실행

```



책 179 184 185 페이지 참고 = `스프링마이크로서비스 코딩 공작소 _길벗`