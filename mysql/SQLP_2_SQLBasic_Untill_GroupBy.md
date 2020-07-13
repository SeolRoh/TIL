SQL 기본 - SQL종류,  WHERE문 사용방법, GROUP 연산, 내장형 함수 등 공부

---

> 용어정리
>
> 1. Column - 칼럼, Attibute, 속성
> 2. Tuple - 튜플, Row, 행

+ RDB(Relation 사용)

  + 집합연산(Join 연산자 사용)
  + 관계연산

+ DB 종류

  + 계층형 (Tree 구조)
  + 네트워크형 (Owner - Member, 1:N, N:M)
  + 관계형 (Relation에 Data 저장 및 관리)

+ DBMS

  + 계층형, 네트워크형, 관계형 DB를 관리하기 위한 SW
  + Oracle, MS-SQL, MySQL, Sybase 등 모두 RDB를 지원

+ 집합연산 - 조회기능

  + UNION (합집합)

    : 두개의 릴레이션을 한개로 합함, 중보 튜플은 1번만 조회됨(튜플 = 행)

  + Difference(차집합)

    : 본래 릴레이션에는 존재하나 다른 릴레이션에 존재 하지 않는 것을 조회

  + Intersection(교집합)

    : 두개의 릴레이션 간 공통된 것을 조회

  + Cartesian product(곱집합)

    : 각 릴레이션에 존재하는 모든 Data를 조합해 연산 수행

+ 관계연산 - 조회기능

  + Selection(선택연산)

    : 릴레이션에서 조건에 맞는 튜플만 조회

  + Projection(투명연산)

    : 릴레이션에서 조건에 맞는 속성만 조회

  + Join(결합연산)

    : 여러 릴레이션의 공통된 속성을 사용해 새로운 릴레이션을 만들어냄

  + Division(나누기연산)

    : 기준 릴레이션에서 나누는 릴레이션이 가진 속성과 동일한 값을 가지는 튜플을 추출하고나누는 릴레이션의 속성을 삭제후 중복된 튜플을 제거.