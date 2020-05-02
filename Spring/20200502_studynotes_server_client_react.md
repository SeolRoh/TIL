20200502 리액트_ 서버/클라이언트 부분 `일정관리 todolist-react-app` 프로젝트 생성하기

---



http://localhost:3000//?_react.perf 접속 > 관리자 모드 > Performance 

![1](https://user-images.githubusercontent.com/34231229/80856430-f3147f80-8c84-11ea-9dcf-8d81568ee41f.JPG)



<img src="https://user-images.githubusercontent.com/34231229/80856449-1a6b4c80-8c85-11ea-80ce-cb303dd801b9.JPG" alt="2" style="zoom:67%;" />



---

**Life-Cycle Method의 Overridong** 

: 라이프사이클 메소드는 10가지 종류를 가지고 있으며, 컴포넌트가 생성되거나 삭제될때 어떠한 작업을 하게된다.

: 리액트의 컴포넌트를 만들 때 해당 컴포넌트의 생명주기의 특정한 시점에 Auto로 호출되는 메서드를 선언 가능 하다.

: render(){} 메서드의 호출을 줄일 수 있다.

: **오버라이딩** 사용

```js
// TodoItemList.js 에서 사용했음.
   shouldComponentUpdate(nextProps, nextState){
       return this.props.todos !== nextProps.todos;
}
//적용후에 http://localhost:3000//?_react.perf 접속해서 record 기록남기고 확인하기
```

