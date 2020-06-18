#### 클라우드 컴퓨팅 책을 읽고

----

3장 클라우드 컴퓨팅의 이해

> "확장가능한 탄력적인 IT기능이 인터넷을 사용하는 고객들에게 제공되는 서비스"
>
> 수평적확장과 수직적확장
>
> : 수평적확장의 경우 자원 복제 및 자동 확장, 하드웨어 용량에 대한 제약X, 저비용
>
> : 수직적확장의 경우 대개 추가 설정이 필요하며 최대 하드웨어 용량에 제약을 받는다. 특성화된 서버사용 ==> 고비용
>
> **클라우드 컴퓨팅의 원동력?**
>
> : 소비자가 원격에서 사용할 수 있는 기능을 제공하면서 다른 IT자원을 캡슐화해 서비스로서 IT자원을 제공하는 데 있다. 
>
> 온프레미스
>
> : 전통적인 방식, 서버실
>
> 온디맨드
>
> : 공급이 아닌 수요에따라 결정 / 요구만 있으면 언제든지~ 여기서 탄력성, 유연성이라는 단어가 따른다.



4장 기본 개념과 모델

> 클라우드의 특징
>
> : 온디맨드 식의 사용
>
> 서비스 기반의 특징과 사용 중심의 기능
>
> ==> 설정을 통해 클라우드 소비자나 제공자의 개입을 하지 않고 IT자원을 자체적으로 공급자동화할수 있음.
>
> : 유비쿼터스 접근
>
> 언제 어디서나. 이를 위해 장비, 전송 프로토콜, 인터페이스 , 보안 기술의 자원이 필요.
>
> ==> 이렇게 하기 위해서는 클라우드 서비스 아키텍처를 여러 클라우드 서비스 소비자의 요구사항에 맞추어야 함.
>
> : 멀티테넌시(자원풀링)
>
> 멀티테넌시란? 
>
> 여러 소비자에게 프로그램 인스턴스를 제공해 각 소비자가 독립적으로 사용하게 하는 소프트웨어 프로그램의 특징. 
>
> : 탄력성
>
> IT자원을 확장하는 자동화된 능력부분! 런타임 상황에서 필요한 만큼, 클라우드 소비자나 클라우드 사용자가 미리 정해 놓은 만큼!
>
> : 사용량 측정
>
>  IT자원의 사용량을 기록하는 클라우드 플랫폼의 능력(온디맨드 특성과 밀접함)
>
> : 복원력
>
>  물리적인 위치를 넘어 IT자원을 중복 구현해 배포한 시스템 장애 조치의 한 형태.
>
> ===> 해당 서비스에 문제가 생기면 중복 구현한 시스템을 대체하여 작동시킨다.
>
> 클라우드 제공모델
>
> 1. IaaS
>
>    : 기반 인프라의 초기 설정 및 필요한 소프트웨어의 설치, 관리, 모니터링
>
> 2. PaaS
>
>    : 클라우드 서비스와 클라우드 기반 솔루션 개발, 테스트, 배포, 관리
>
> 3. SaaS
>
>    : 클라우드 서비스의 사용, 설정