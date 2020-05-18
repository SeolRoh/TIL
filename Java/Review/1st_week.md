**[학습과제 제출 - B반 노설]**

▶1주차(3월25일~3월29일 11시59분PM) - "마이크로서비스를 위한 자바"-복습 교육생 문의가 많아 전체 공지드립니다. 교재 전체 단원 안 하셔도 되고, 복습인 만큼 본인이 취약한 부분, 미흡하다고 생각하는 단원들을 집중적으로 공부하시고 결과물을 제출해주시면 됩니다.

------

1. Java 배열 (5/6) : for-each

   - 배열에 담겨있는 것을 탐색하면서 반복시킬 때 사용함. 간결.

   - ```
     String[] members = {"가나다", "라마바", "사아자"};
     for(String e : members){
     	System.out.println(e + "이 상담을 받았습니다.");
     }
     ```

2. Java 배열(6/6): 배열의 오류와 한계

   - 인덱스에 없는 값을 출력을 할 시에 해당 오류가 발생한다.

     ```
     Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 10 at example1.main(example1.java:8)
     ```

   - 초기에 설정한 배열의 크기보다 넘치게 값을 추가 했을때 오류가 발생한다.

   - 배열의 한계

     - 배열은 초기화 할 때 크기를 미리 선언하고 정해진 크기 만큼까지만 데이터를 넣을 수 있다. 유연성이 떨어진다.
     - 자바에 컬렉션(Collection 또는 컨테이너)이라는 기능을 통해 배열의 한계를 유연하게 만들 수 있다. 편리하게 데이터를 핸들링 할 수 있다.

3. Java 메소드(1/6): 메소드 오리엔테이션

   - method, function, **함수**라 말한다. 자바: method 타 언어: 함수

     ```
     public static void main(String[] args){}
     ```

4. Java 메소드(2/6): 메소드의 정의와 호출 (define과 call)

   ```
   public class MethodDemo1{
   	public static void numbering(){
   	int i = 0;
   	while(i<10){
   		System.out.println(i);
   		i++;
   		}
   	}
   	public static void main(String[] args){
   		numbering(); 
           // 위의 numbering()이라는 이름을 가지고있는 이 메소드를 
           // 호출하여 사용할 수 있다.
   	}
   }
   ```

5. Java 메소드(3/6): 메소드가 없다면?

   - 이미 정의해 논 로직을 **재활용** 할 수 있음. -> **코드의 간소화**, **유지보수 용이**

6. Java 메소드(6/6): 복잡하게 데이터를 리턴하는 이유는?

   - **결론: 메소드(함수) 부품으로서의 가치를 높이기 위해서_ 강의내용**

   - 결과 값을 파일, 이메일, 화면에 출력하라는 식으로 요건을 바꾸게 된다면, 그에 맞추어 매번 `System.out.print`를 사용해 출력하면 번거롭고 어렵다.

     ```
     try{//무시
         // out.txt라는 파일에 numbering이라는 메소드가 반환한 값을 
         // 저장
         BufferedWritter out = new BufferedWritter(new FileWriter("out.txt"));
         out.write(result);
         out.close();
     }catch (IOException e){
     } // 무시;
     ```

     => 실행 시 root 디렉토리에 `out.txt`라는 파일이 생성됨을 확인할 수 있다.

   - **배열 메소드의 리턴**

     ```
     public class ReturnDemo4{
     	public static String[] getMembers(){ 
             //getMembers가 리턴하는 값이 문자열이라고 선언
             
     		String[] members = {"가나다", "라마바","사아자"};
     		return members;
     	}
     	
     	public static void main(String[] args){
     		String[] members = getMembers();
     	}
     }
     ```

7. Java 객체 지향 프로그래밍(3/3): 추상화- abstract 부품화-module

   - OOP(Object Oriented Programing)
   - 추상화 -> 지도 내의 지하철 선로 모습 -> ... -> 지하철 노선도
   - 객체 = 변수와 메소드를 **grouping** 한 것. 또 이를 일종의 부품이 된다.
   - 부품화 = 재활용

8. Java 클래스와 인스턴스 그리고 객체지향(5/5): 객체화

   - instance: 설계도에 따라 만들어진 구체적인 제품들

     ***Calculator c1 = new Calculator();***

     ***Calculator c2 = new Calculator();***

   - class: 설계도

     ***class Caculator***

     > **class라는 설계도는 new사용해서 선언. => 객체가 만들어짐 = 인스턴스**
     >
     > 그리고 class 내부적으로 변수를 가지고 있다.

   - 상태(state)와 행동(behave)

     - 변수: 상태 메소드:행동

     - 블로그의 문장을 그대로 붙임

       > 하나의 클래스를 바탕으로 서로 다른 상태를 가진 인스턴스를 만들면 서로 다른 행동을 하게 된다는 것을 알 수 있다.

       하나의 클래스가 여러개의 인스턴스가 될수 있다는 점이 객체 지향이 제공하는 가장 기본적인 **재활용성**

9. Java 클래스 멤버, 인스턴스 멤버(4/4): 멤버란?

   - 인스턴스 변수: Non-Static Field

   - 클래스 변수: Static Field

   - 각각 클래스 멤버와 인스턴스 멤버안에는 변수와 메소드가 들어있다.

     - **클래스 메소드를 선언할 때는 반드시 `static`과 선언한다.**

     ```
     class Calculator{ }
     public class CalculatorDemo1{
     	public static void main(String[] args){
     		Calculator c1 = new Calculator();
     		System.out.println(c1.PI);
     		//c1 인스턴스 생성 후 출력
             
     		Calculator c2 = new Calculator();
     		System.out.println(c2.PI);
     		//c2 인스턴스 생성 후 출력		
     		
     		System.out.println(Calculator.PI);
     		//클래스를 통해 직접적으로 접근이 가능
             
             //결국 위의 두개 인스턴스와 클래스 접근을 통한 출력 3.14 로 출력된다.
     	}
     }
     ```

   - 클래스로 접근한 후에 인스턴스 출력할 때,

     ```
     class Calculator2{
         static double PI = 3.14;
         static int base = 0;
         int left,right;
     
         public void setOprands(int left, int right){
             this.left = left;
             this.right = right;
         }
         
     	public void sum(){
             System.out.println(this.left + this.right + base);
         }
     	public static void main(String[] args){
     		Calculator c1 = new Calculator2();
     		c1.setOprands(10,20);
     		//30출력
     		c1.sum();
     		
     		Calculator c2 = new Calculator2();
     		c2.setOprands(20,40);
     		//60출력
     		c2.sum();		
         
         	//클래스 변수 base의 값을 10으로 지정
         	Calculator2.base =10;
         
         	c1.sum(); //40 출력
         
         	c2.sum(); //70 출력
     	}
     }
     ```

10. Java 유효범위(4/4): 유효범위란?, 인스턴스의 유효범위 `scope`

    - 프로그램이 커지면 여러가지 이유로 이름이 겹칠 수 있다. 이를 해결하기 위한 것이 유효범위 = `scope` = 암시적인 기능

    - 

    - ##### 클래스 아래에서 선언된 변수는 클래스 전역에 영향을 미친다.

    - ##### 하지만, 메소드 내에서 선언된 변수는 클래스 아래에서 선언된 변수보다 우선순위가 높다.

    - ##### 즉, 지역 보다 전역이 우선순위가 높다.

      - ```
        public class ScopeDemo4{
        	static void a(){
        		String title = "coding everybody";
        	}
        	public static void main(String[] args){
        		a();
        		//System.out.pringln(title);
        	}
        }
        ```

      - 위의 코드 속 주석처리를 해제한다면 오류가 발생한다. 해당 title이라는 변수는 메소드 a에 있는 변수이기 때문에 해당 지역변수 내에서만 접근이 가능하기 때문이다.

      - ```
        public class ScopeDemo6 {
            static int i = 5;
        
            static  void  a(){
                int i = 10;
                b();
            }
        
            static void b(){
                System.out.println(i);
            }
            public static void main(String[] args) {
                a();
            }
        }
        ```

      - 결과는 10이 아닌 5

      - 메소드 b 내에 지역변수가 있지 않은 한 전역변수 i인 5가 호출된다.

      - 이런 방식을 정적 스코프(static scope) 또는 lexical scope라고 부른다. `사용되는 시점에서의 유효범위 (메소드 a의 i) X` `정의된 시점에서의 유효범위 (i=5)` 사용 ##### 내생각에는 그냥 우선순위로 정의된 순서가 우선... 인듯하다.

      - 동적 스코프도 있지만 대부분의 언어들이 정적 스코프 방식을 이용한다고 한다.

      - 참고 https://opentutorials.org/module/516/5447

    - **인스턴스의 유효범위 `this`** ------------------------------------------------------

      - ```
        class C {
        	int v = 10;
        	
        	void m() {
                //int v =20;
        		System.out.println(v);
                //	// System.out.println(this.v)
        	}
        }
        public class ScopeDemo7{
        	public static void main(String[] args){
        		C c1 = new C();
        		c1.m();
        	}
        }
        ```

        결과 : 10

        주석을 제거했을 경우 결과: 20

        이유 : 메소드 m 의 지역변수인 v가 인스턴스 전역에서 유효한 인스턴스 변수 v 보다 우선순위가 높다.

        여기서 인스턴스 변수 v에 접근하려면 `this`를 사용하면 된다.

        **`this`는 인스턴스 자신을 의미하는 키워드 자체**

11. 상속(1/3):상속의 개념

    - 상속(Inheritance)란 기존에 있던 객체(변수,메소드)를 이어받으면서 기존에 있던것을 변경(수정)하거나 사용할 수 있는 것이 상속.
    - 재활용성, 중복의 최소화, 유지보수의 편의성

12. 상속과 생성자(1/2):기본생성자, super

    - 자기 자신을 main()에서 인스턴스 화 할수 있다.
    - 하위클래스에서 super(left,right); // 이경우 부모클래스 내의 매개변수가 두개인 생성자를 호출한다.
    - super는 부모클래스를 의미한다. **super사용시 가장 먼저 사용한다음에 초기화해야한다.**
    - **하위클래스에서 상위클래스를 참조할수 있는 방법**

13. 오버라이딩(1/2):창의적인상속 `재정의`

    - 부모클래스의 기능을 변경할 수 있는 메소드 오버라이딩

    - 상속은 상위클래스의 기능을 하위 클래스에게 물려주는 기능이다. => 하위클래스는 상위클래스의 메소드를 있는 그대로 사용해야한다 => 이 제약을 벗어나기 위해 만들어진 **오버라이딩**

    - 부모클래스와 자식클래스 안에 같은 이름의 생성자 가 존재할시 우선순위가 하위로 간다.

      ```java
      class Calculator {
          int left;
          int right;
      
          void setOperands(int left, int right) {
              this.left = left;
              this.right = right;
          }
      
          public void add(){
              System.out.println(left-right);
          }
          public int avg() {
              return ((this.left + this.right) / 2);
          }
      }
      class substractionableCalculator extends Calculator{
          int substract(){
              return left - right;
          }
          public void add(){
              System.out.println("결과는 " + (left-right) );
          }
          public int avg() {
              return super.avg(); //중복을 최소화하기 위해 리턴값에 super()사용
          }
      }
      
      public class CalculatorDemo {
          public static void main(String[] args) {
              int result;
      
              substractionableCalculator a1 = new substractionableCalculator();
              //자식클래스로 인스턴스 변수 생성
              a1.setOperands(10,20);
              a1.add();
              System.out.println("실행 결과는" + a1.avg());
          }
      }
      ```

14. 오버로딩(1/2):오버로딩의 규칙

    - 가장 중요한건 매개변수!
    - 상속의 관계에서도 오버로딩을 사용할수 있다.

15. 접근제어자(1/5): public과 private

    ```java
    class A {
        public String y(){
            return "y()";
        }
        private String z(){
            return "z()";
        }
        public String x(){
            return z();
        }
    }
    public class AccessDemo1 {
        public static void main(String[] args) {
            A a = new A();
            System.out.println(a.y());
            //System.out.println(a.z()); // 에러 발생
            System.out.println(a.x());
        }
    }
    ```

    private으로 바로 들어가기 어려우나 같은 클래스내의 public 생성자를 통해 접근이 가능하다.

    + public 접근제어자 클래스는 다른 패키지의 클래스에서 사용가능. default는 같은 패키지만.

    + 하나의 java class 파일내에는 오로지 한개의 public class 만 존재할 수 있다.

      ![접근제어자](https://user-images.githubusercontent.com/34231229/80234210-b51ac880-8692-11ea-9928-a6ed834836ec.JPG)

      그림 출처) Opentutorials.org 블로그 https://opentutorials.org/module/516/6061

16. abstract(1/3):문법 

    + 추상 메소드는 정의된부분이 비어져있다. *하단의 주석처리부분 참고
    
    + 추상 클래스내 추상 메소드를 사용해서 직접적으로 인스턴스화하여 사용할수 없다.
    
    + 사용하고자 한다면 반드시 `상속을 강제` 한다. + `override`
    
    + 추상클래스(설계자), 실행요원(클래스1), 실행요원2(클래스2)
    
    + 자식클래스 내부에 super도 함께 쓰이곤한다.
    
      ```java
      abstract class A{
          public abstract int b();
          //아래는 에러 발생!! 본체가 있는 메소드는 추상화 키워드를 가질수 없다.
          //public abstract int c(){System.out.pringln("Hello");}
          public void d(){
              System.out.println("world");
          }
      }
      class B extends A{
          //override했음을 알수 있다.
          public int b(){
              return 1;
          }
      }
      public class DemoAbstract {
          public static void main(String[] args) {
              B obj = new B();
              System.out.println(obj);
          }
      }
      ```
    
    + abstract를 사용하는 이유?
    
      + 실제 동작 방법은 abstract를 상속받은 하위클래스의 책임으로 설정한다.
      + 규모가 큰 프로젝트에서 사용하면 좀 낫다.
      + 모든 클래스의 공통분모를 상위클래스에 두어서 코드중복이나, 유지보수가 편할수 있다.
    
    + abstract pattern
    
17. final(1/1):필드, 메소드, 클래스

    + `상속이나 변경을 금지하는 규제` | abstract와 정반대

      ```java
      // 바뀌지 않는 절대의 값
      static final double PI = 3.24;
      ```

    + final 메소드로 생성된 b를 상속할수 없다. + 오버라이딩도 불가능하다.

    + final 클래스도 마찬가지로 상속할수 없다. 
    
18. 인터페이스(1/3): 문법

    + 강제하는 것

    + abstract, final과 같이 대표적인 규제

    + 어떤 객체가 있고 그 객체가 특정한 인터페이스를 사용한 다면 그 객체는 반드시 인터페이스의 메소드를 구현해야함!! 강제강제

      ````java
      interface I {
      	public void z();
      }
      
      class A implements I{
      	public void z(); // 반드시 구현해야한다. 미구현시 빌드 X
      }
      // 클래스 에이는 인터페이스 I를 구현한다
      ````

      상속 -> extends	인터페이스->implements

    + 인터페이스를 사용하는 이유는?

      코드 예시

      ```java
      public interface Calculatable{
      	public void setOperands(int first, int second, int third);
      	public int sum();
      	public int avg();
      }
      ```

      ```java
      class Calculator implements Calculatable{
      	int first, second, third;
      	public void setOperands(int first, int second, int third){
      		this.first = first;
      		this.second = second;
      		this.third = third;
      	}
      	public int sum(){
      		return this.first + this.second + this.third;
      	}
      	public int avg(){
      		return (this.first + this.second + this.third)/ 3;
      	}
      	
      }
      ```

      즉 interface는 각자의 목표를 위해 구현을 해야하지만 서로 짜는 로직이 다를 수 있으므로 이를 구성하는 메소드나 변수들을 지정해주고 이 틀에 맞추어 작성해주는 (다만 구체적이진 않고 메소드 정도로만??? )작성방법문이라고 보면된다. interface를 구현했으면 반드시 implements를 사용해 해당 인터페이스를 구현해야 한다.

    + 인터페이스의 규칙

      + **하나의 클래스가 여러개의 인터페이스를 구현할수 있다.!!!!! ** 콤마로하고 그대로하면됨
      + 또 상속받은 인터페이스를 구현한다면 부모클래스의 객체와 인터페이스내에 작성한 객체들 모두 작성해줘야함!!
      + 인터페이스의 멤버는 반드시 __public__ 임!

    + 추상클래스와 인터페이스의 차이

      + 추상클래스

        : 일반적인 클래스

        : 구체적인 로직이나 상태를 가지고 있을 수 가있음

      + 인터페이스

        : 클래스가 아님. 그냥 인터페이스임

        : 구체적인 로직이나 상태를 못가짐 ex) 메소드를 넣어도 그안의 변수명들은 없음

19. 다형성(1/6): 메소드와 다형성(Polymorphism), 클래스와 다형성

    + 다형성은 하나의 메소드나 클래스가 있을 경우, 어떤 방식으로 동작하고 동작 되는지. 조작 방법은 같으나 이 조작으로 동작시키면 동작방법은 다르다. 

      -> 키보드 누른다. -> 하지만 무엇을 누르냐? -> ESC 누르기 || ENTER 누르기 ||동시에누르기

      -> 누르는 것은 같지만 결과는 달라짐  (비유는 비유일뿐!! 이해를 위함.)

    + 다형성의 쉬운예제 == 오버로딩 (매개타입, 개수 , 같은 이름 다른 동작방법이여서)

    +  클래스와 다형성

      처음보면 요상해보이는 다형성 예제

      ```java
      class A{
          public String x(){return "x";}
      }
      class B extends A {
          public String y(){return "y";}
      }
      public class PolumorphismDemo1{
      	public static void main(String[] args){
      		A obj = new B();
              obj.x(); // 정상적으로 실행 // class A에 x 메소드가 있어서
              obj.y(); // 오류발생 //  class A에 y 메소드가 존재X라고 자바가 간주
              //-------------------------------------------------------------
              //이유: 데이터타입이 class A이기때문이다. 중요!!!!
              //-------------------------------------------------------------
      	}
      }
      ```

      위의 예제를 수정한 코드

      ```java
      class A{
          public String x(){return "A.x";}
      }
      class B extends A{
          public String x(){return "B.x";}
          public String y(){return "y";}
      }
      public class PolymorphismDemo2 {
          public static void main(String[] args) {
              A obj = new B();
              System.out.println(obj.x());
              
              //예상 : A.x를 실행할 것이다.
              //정답 : B.x를 실행
              //이유 : 클래스 A의 행세를 하지만 메소드 X는 클래스B에 정의되어있는
              //		메소드 x부분이 실행된다.
              
              //추가로 정의한것은 사용못한다. 하지만 상위 클래스에 있는 메소드를
              //오버라이딩 한다면 해당 인스턴스를 호출하여 수행한다.
              //즉 A클래스와 B클래스를 보면 동일한 x메소드를 가지고 있으니
              // 하위클래스에있는 x메소드를 실행시켜서 답이 B.x가 된다.
              
           // 하지만 여기서 호출을 obj.y()를 println했다면 또 위의 예제처럼 에러가 난다.
          }
      }
      ```

      또다른 예제

      ```java
      class A{
          public String x(){return "A.x";}
      }
      class B extends A{
          public String x(){return "B.x";}
          public String y(){return "y";}
      }
      class B2 extends A{
          public String x(){return "B2.x";}
      }
      public class PolymorphismDemo3 {
          public static void main(String[] args) {
              A obj = new B();
              A obj2 = new B2();
              System.out.println(obj.x());
              System.out.println(obj2.x());
          }
          
          //맞추기
          //예상 b.X, B2.x
          //정답 b.x, B2.x
      }
      ```

      =========================================================================

      =========================================================================

      **다형성의 꽃**  -> 이거 이해하면 다형성 마스터 + 반복적인 코드의 라인수 줄어든다.

      ```java
      public class CalculatorDemo {
          public static void execute(Calculator cal){
              System.out.println("실행결과");
              cal.run();
          }
          public static void main(String[] args) { 
              Calculator c1 = new CalculatorDecoPlus();
              c1.setOprands(10, 20);
               
              Calculator c2 = new CalculatorDecoMinus();
              c2.setOprands(10, 20);
               
              execute(c1);
              execute(c2);
          }
      }
      ```

      =========================================================================

      =========================================================================

    + 인터페이스와 다형성

      ```java
      interface I {}
      class A implements I {}
      public class 다형성Demo2{
      	public static void main(String[] args){
              // class A를 인스턴스화
      		I obj = new A();
      	}
      }
      ```

20. 예외1-문법(1/12): 예외란 무엇인가,뒷 수습

    + 예외 = 보안, 실패하지 않는 법

      > 계산기 예제에서 operand(10,0) => divide 메소드로 전달 시 ====> 에러 발생
      >
      > 해당 에러가 발생하는 divide메소드 내의 객체를 try()문으로 감싸고
      >
      > catch(Exeption e){System.out.println("오류발생: "+ e.getMessage();)}로 만든다.

      ```java
      try{
      	예외의 발생이 예상되는 로직
      }catch(Exception e /*예외 클래스 인스턴스*/){
      	예외가 발생했을 떄 실행되는 로직
      }finally{
          예외여부와 관계없이 실행되는 로직
      }// finally는 try구문에서 예외가 발생하는 것과 상관없이
       // 언제나 실행되는 로직이다.즉 try내의 구문 실행시 바로ㄱㄱ
      ```

    + **printStackTrace()** 

      + 내부적으로 화면에 에러사항을 출력하는 메서드
      + 밑에 두개의 메서드아 다르게 printStackTrace는 리턴값이 없다.
      + 이 메서드를 호출하면 메서드가 내부적으로 예외결과를 화면에 출력한다. 가장 자세한 예외정보를 제공한다.

    + toString()

      + getMessage보다 더 자세한 예외정보를 제공한다.
      + 0으로 나누고있을 때 `java.lang.ArithmeticException: `이 출력 되었는데 이는 수학적인 계산의 과정에서 발생하는 예외상황을 의미한다.

    + getMessage()

      + 오류에 대한 기본적인 내용을 출력해준다. 자세하지 않음.

21. 예외2-예외던지기(6/12):예외의 던지기/강제

    + 예외는 폭탄과 같다. = 던지기를 설명하는 듯하다.

      ```java
      //읽어오고싶은 파일
      //여기서 해당 자바클래스 파일의 디렉토리에
      //열고픈파일.txt가 반드시 있어야한다.
      public class CheckedExceptionDemo{
      	public static void main(String[] args){
              BufferedReader bReader = null;
              String input = null;
              try{
      			bReader = new BufferedReade(new FileReader("열고픈파일.txt"));
              } catch(FileNotFoundException e){
                  e.printStackTrace();
              }
              try{
                  input = bReader.readLine();
              }catch(IOExeption e){
                  e.printStackTrace();
              }
              system.out.println(input);
          }
      }
      ```

      FileReader생성자 API DOCS [FileReader 생성자](http://docs.oracle.com/javase/7/docs/api/java/io/FileReader.html#FileReader(java.io.File))

22. 예외2(7/12): 예외사슬

    + 예외 강제 형태 / 반대의 형태
    + 나는 지금 사용하지 않으나 다음사용자에게 예외를 주는 방법
    + 하지 않아도 된다는 상황이 어떻게 해서 이루어지는 지

    + `new FileReader("out.txt") `

      파일을 읽기 위한 생성자. out.txt라는 인자값 전달

    + try~catch~finally

      + <u>위의 try catch finally문 이외의 다른 방법이 있다.</u>

        throw를 사용하는 것이다!!!!!

        throw는 예외처리를 다음 사용자에게 넘기는 것이다. 

        Q 다음 사용자는 누구일까?

        ```java
        //구조 B -> C -> Throw~~
        class B {
            void run(){
                
            }
        }
        class C{
            void run(){
                
            }
        }
        public class ThrowExceptionDemo{
        	public static void main(String[] args){
        		C c = new C();
        		c.run();
        	}
        }
        // ThrowExceptionDemo.main(클래스 ThrowExceptionDemo의 메소드 main)은 C.run의 사용자이다. C.run은 B.run의 사용자이다. 반대로 B.run의 다음 사용자는 C.run 이고 C.run의 다음 사용자는 ThrowExceptionDemo.main이 되는 셈이다. 파일을 읽은 로직을 추가해보자!
        ```

      + 책임의 전가 throws

        + class B의 void run()에 `throws` FileNotFoundException추가

        ```java
        //위의 코드들을 그대로 가져옴
        class B { // 집어서 class C에게 예외처리를 던짐
            void run() throws FileNotFoundException, IOException{
                BufferedReader bReader = null;
                String input = null;
        //        try{
        //			bReader = new BufferedReade(new FileReader("열고픈파일.txt"));
        //        } catch(FileNotFoundException e){
        //            e.printStackTrace();
        //        }
        //        try{
        //            input = bReader.readLine();
        //        }catch(IOExeption e){
        //            e.printStackTrace();
        //        }
        //        system.out.println(input);
                bReader = new BufferedReade(new FileReader("열고픈파일.txt"));
                input = bReader.readLine();
                system.out.println(input);
                //예외를 class C로 던지니 확 줄었다.
            }
        }
        class C{
            void run(){
                B b = new B();
                
                // 추가 부분
                try{
                    b.run();
                }catch(FileNotFoundException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        public class ThrowExceptionDemo{
        	public static void main(String[] args){
        		C c = new C();
        		c.run();
        	}
        }
        ```

23. 예외3-만들기(9/12):예외 만들기

    + 주요 Exception들의 리스트

      + illegalArgumentException

        : 매개변수가 의도하지 않은 상황을 유발시킬 때

      + illegalStateException

        : 메서드를 호출하기 위한 상태가 아닐 때

      + NullPointerException

        : 매개 변수 값이 범위를 벗어날 때

      + indexOutOfBoundsException

        : 인덱스 매개 변수 값이 범위를 벗어날 때

      + ArithmeticException

        : 산술적인 연산에 오류가 있을 때

    +  예외3-만들기(10/12): 예외의 여러가지 상황들

       +  `throw new`
       +  ---------------------- 이하 추후에 공부예정 https://opentutorials.org/course/1223/6228

24. Object 클래스(1/5):소개 

25. 상수와 enum(1/4):

26. 참조(1/4):복제란?

27. 제네릭(1/5):제네릭의 사용

28. Collections Framework(1/9): Arraylist, set, Iterator, Map, Collection의 사용

------

(참고 페이지)

1. 블로그 https://opentutorials.org/
2. 유튜브 https://youtu.be/Yu49BOJueaw