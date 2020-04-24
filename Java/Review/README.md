# JAVA

생활코딩 블로그를 통해 자바를 복습한다.

https://opentutorials.org/



**<u>1주차 - '마이크로서비스를 위한 자바'-복습</u>**

2주차 - '스프링부트를 이용한 마이크로서비스 구축' 예습

---

### 용어정리

1. 객체란?

   변수와 메소드를 grouping 한 것. 클래스와 인스턴스도 객체라고 불린다.

   

2. 객체 지향 프로그래밍이란?

   내가 이해한 객체지향프로그래밍은 프로그램이 커질수록 꼭 필요한 것같다. 모듈화를 시켜 재사용할 수 있고, 대규모의 프로젝트시에 코드의 수를 간소화 할 수 있다. 그룹핑이라는 단어가 어울린다.

   

3. 클래스와 인스턴스

   하나의 클래스를 통해 여러개의 인스턴스를 생산해 낼수 있다. 책 속의 예시를 빌리자면 붕어빵 틀은 클래스 , 이를 통해 초코맛 붕어빵, 슈크림맛 붕어빵, 팥이 들어간 붕어빵이라는 인스턴스가 나온다.

   

4. 클래스 변수와 인스턴스 변수
   
   1. 인스턴스 멤버는 클래스 멤버에 접근할 수 있고,
   2. 클래스 멤버는 인스턴스 멤버에 접근할 수 있다.
   
   + 인스턴스 변수:  Non-Static Field
   + 클래스 변수: Static Field
     + 정적 메소드, 인스턴스, 인스턴스 변수, 인스턴스  메소드, 클래스, 클래스 변수, 클래스 메소드
   
5. 유효범위(scope)

   1. 암시적인 기능으로 부품으로서의 로직이라는 가치가 얼만큼 중요, 필요한지 생각 => 프로그램들이 확장되면서 클래스와 메소드, 변수가 많아지기 마련이다. 그럴 경우 각 이름들이 같거나 비슷해 겹치게 되는데 같더라도 해당 이름이 지역변수, 전역변수 여서 데이터가 영향이 미칠때도 있고 그렇지 않는 경우가 있다. 이런 문제를 해결하기 위해 만들어진 것 같다.
   2. 개인적으로 생각하는 유효범위는 객체지향 프로그래밍의 특징중 하나이다. 또한 (이름이 같은)전역변수와 지역변수 사이에서 원하는대로 결과값을 도출해 낼 수 있다. 또한 `this`를 사용해서 전역변수를 사용한다. 철저한 정의된 시점에서의 유효범위 즉 정의된 순서가 우선인 `정적 스코프`라는걸 알아 두어야 한다.