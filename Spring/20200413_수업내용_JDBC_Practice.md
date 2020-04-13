 20200513 09:00~12:00

### Data Acess: ORM (MyBatis)

---

오늘 배울 파트

Mybatis

---

ORM(Object Relational Mapping)

:MyBatis(매핑 다 해줌), JPA

:매핑 Rule

​	java														db

​	Class(VO-내가 만든 클래스)	<=>	Table 이 자바 객체 에 저장됨

​	Object									   <=>	Row(Record) 가 자바 객체 에 저장됨

​	Variable									<=>	Column



여러개 Row를 읽으면 ArrayList나 배열을 사용한다. 하지만 배열은 선언시, 사이즈를 유동적으로 할수 없기 때문에 Collection에서 ArrayList를 주로 사용한다.