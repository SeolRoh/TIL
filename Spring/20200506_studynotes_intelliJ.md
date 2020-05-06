20200506 인텔리제이로 스프링부트 프로젝트 생성하기

---

.jar 파일로 배포

```powershell
C:\Users\HPE\IdeaProjects\demo\target>java -jar demo-0.1.jar
=================================================================
My Seoul Spring Boot 2.1.13.RELEASE / 0.1
=================================================================

```

propertises - local버전 으로 .jar 파일 배포

```powershell
C:\Users\HPE\IdeaProjects\demo\target>java -jar -Dspring.profiles.active=local demo-0.1.jar
```

양쪽 버전은 각각 포트번호를 달리해 확인해본다.



해당 코드를 github에 포스팅해보기

1. 본인계정에 레파지토리 만들기
2. 해당 주소 복사
3. 프로젝트에 추가 -> VCS창의 두번째줄 클릭 -> git 
4. 해당 프로젝트 우클릭 후 git -> add 클릭 // 파일들이 초록이 되었음
5. 다시 git ->  커밋 버튼 -> commit message 작성 -> commit &push
6. maste -> Define remote 클릭 후 copy한 Url 입력

---

