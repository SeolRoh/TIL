#### 20200613 Docker에 구현한 프로젝트를 올리면서 마주한 오류

---

오류 설명

> local에서는 해당 프로젝트를 구동시킬 시 회원가입 화면이 잘 띄워진다. 
>
> Docker위에 올리면 회원가입창 에러 발생!

```
This application has no explicit mapping for /error, so you are seeing this as a fallback. 500
```

![dockerError](https://user-images.githubusercontent.com/34231229/84608238-6a783880-aeec-11ea-8de8-af1e4ef6b55f.JPG)

여기서 /error가 진짜 슬래시에러인줄 몰랐다.,,,,,, 헤메고 헤멤.



문제 찾기

회원가입창 에러 

1. ==> DB mySQL내부 테이블 생성이 되지 않은 듯?

   ==> NO!

​		MyBatis로 구현하기 때문에 Docker Container로 띄운 Mysql내부에 DB table을 이미 생성해준 상태,

2. ==>로그인을 해야 안 내부 파일 업로드 및 비식별 프로그램 사용가능. 로그인이라도 해보자!

   ==> NO!

​		현재 insert문을 사용해서 table내부에 데이터를 넣더라도 회원가입시 JBcrypt라는 인코딩을 이용한 패스워드 암호화를 사용중이기 때문에 내부에 입력을 하더라도 로그인시 암호화 되어있는 비밀번호를 읽어오니 에러 발생!!

3. 그렇다면 Docker위에 있는 mysql과 프로젝트가 서로를 못읽어내는 것일까?

   ==> NO!

   ==> Port번호를 지정해주었고 해당 프로젝트 yml 설정에서 작성한대로 맞추어 docker위에 올렸음!

   

4. 과연 문제가 뭘까..

   docker를 logging해보자.

   docker logs 명령어 관련 옵션들 : `-tale`마지막줄만 가져오기 `--since`유닉스 시간 이후의 로그확인

   `-t`타임스탬프 표시 `-f`실시간으로 로그를 출력

   -f명령을 사용해 회원가입 페이지를 접속해서 로그를 보았더니 `/`관련 문제 였다.

5. 문제의 원인은 바로 `ModelAndView`

   프론트 단으로 출력을 할때 controller에서 return 값으로 ModelAndview의 객체를 출력하지만 특정 메소드는 이를 사용하지않고 그냥 return 값으로 `return "/signup";` 으로 구현했었다. 그러다보니 해당 슬래시 부분으로 인해 인식을 docker에서는 하지 못하여 View단으로 출력이 되지 않았던 것이다.



이틀정도 걸린,,,, 에러 찾기.

