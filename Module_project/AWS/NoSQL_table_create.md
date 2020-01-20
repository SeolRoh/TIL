### NoSQL 테이블 생성 및 쿼리

> https://aws.amazon.com/ko/getting-started/tutorials/create-nosql-table/ - 2

1.  [AWS Management Console](https://console.aws.amazon.com/console/home)에서 *DynamoDB*를 입력하고 DynamoDB 콘솔을 오픈

   ![1](https://user-images.githubusercontent.com/34231229/72705108-dbb1fa80-3b9d-11ea-956a-809335b11def.JPG)

2.  테이블 만들기 버튼 클릭

   ![2](https://user-images.githubusercontent.com/34231229/72705152-000dd700-3b9e-11ea-9feb-619f4c70d601.JPG)

3.  원본 SQL만들기 

   음악 라이브러리 사용 사례로 사용하기

   테이블 이름 상자에 Musicc 입력

   파티션 키는 확장성을 위해 파티션에 데이터를 분산하는 데 사용된다. 균등하게 분산된 액세스 패턴을 가질 가능성이 크고 다양한 값을 가진 속성을 입력하는 것이 중요하다. 파티션 키 상자에 Artist를 입력했다.

   각 아티스트가 여러곡을 작성할 확률이 높으니 정렬 키 추가를 하고 그 상자에 songTitle 하다. 파티션 키 상자에 Artist를 입력했다.

   각 아티스트가 여러곡을 작성할 확률이 높으니 정렬 키 추가를 하고 그 상자에 songTitle 입력.

   ![image-20200120160550585](C:\Users\HPE\AppData\Roaming\Typora\typora-user-images\image-20200120160550585.png)

4. 테이블 만들기 버튼을 누른 후,  항목 버튼을 눌러 항목을 만든다.

   각각 Artist와 SongTitle를 밑에 사진과 같이 만들어 주었다.

   ![4](https://user-images.githubusercontent.com/34231229/72705668-68a98380-3b9f-11ea-9a47-ae953f1c88f0.JPG)

5. NoSQL 테이블 쿼리하기

   > 여기서는 쿼리 작업을 사용해 테이블에서 데이터를 검색한다. DynamoDB에서는 쿼리 작업이 효율적이고 또 정보를 찾기 쉽다.

   + 아래 사진과 같이 스캔을 쿼리로 변경한다.

     그다음 artist 상자에 *The Acme Band* 입력, **songTitle** 상자의 드롭다운 목록에서 **Begins with**를 선택하고 *S*를 입력했다. 검색 결과로 하단의 사진을 참고한다.

     ![5](https://user-images.githubusercontent.com/34231229/72705859-dc4b9080-3b9f-11ea-87ad-eb023c9739c5.JPG)

     

#### 결론

> aws DynamoDB 콘솔을 이용해 UI환경에서 쉽게 데이터 베이스를 관리 할 수 있었다. 또한 테이블 생성과 관리 삭제를 마우스 클릭 한번으로 생성이 되고, 또 유연함을 느꼈다. 또한 처리 용량도 자동으로 조정이 가능했다.



