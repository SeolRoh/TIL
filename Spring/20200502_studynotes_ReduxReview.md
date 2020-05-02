20200502 리덕스 복습

---

이전에 공부한 부분 링크 : [05.Redux.md](https://github.com/SeolRoh/TIL/blob/master/React/05.Redux.md)

+ Redux (생활코딩 블로그 참고하기)

  + 상태 관리 라이브러리(리액트에서의 상태를 더 효율적으로 관리하기 위함이다.)

  + Redux helps you write applications that **behave consistently**, run in different environments (client, server, and native), and are **easy to test**.

  + Centralizing your application's state and logic enables powerful capabilities like **undo/redo**, **state persistence**, and much more.

  + The Redux DevTools make it easy to trace **when, where, why, and how your application's state changed**. Redux's architecture lets you log changes, use **"time-travel debugging"**, and even send complete error reports to a server.

  + Redux **works with any UI layer**, and has **a large ecosystem of addons** to fit your needs.

    상단의 리덕스 특징은 `redux.js.org` 에서 그대로 가져왔다.

  + Redux Api Docs https://redux.js.org/api/api-reference







---

(실습) Redux - count App

```powershell
C:\React>create-react-app redux-counter-app

Creating a new React app in C:\React\redux-counter-app.
C:\React\redux-counter-app>npm i--save reduxreact-redux
C:\React\redux-counter-app>npm start
```

+ src 디렉토리에 5개 디렉토리 생성

  actions, components, containers, reducers, utils

+ App.js를 새 디렉토리를 내부에서 작성한다면, index.js 에서 import되어있는 App.js의 주소를 고쳐야 한다.

  `import App from './containers/App';`

+ 기본 세팅 : Counter.css / 

+ **Counter` presentational Component` 생성**

  + const Counter 생성 후, 숫자, 색상, 증가기능, 감소기능, 색싱 변경기능에대해 작성한다.

    ```js
    // 특정 이벤트 동작 시 
    Counter.propTypes = { ... };
    // 초기 설정
    Counter.defaultProps = { ... };
    ```

+ **Action 생성**

  + ActionTypes.js 작성
    + action 종류 선언해 놓기 후에 import 하기위해서 `export const` 로 선언한다.
  + actions/index.js 작성
    + action객체를 만드는 생성함수 선언 부분

+ **Reducer 생성**

  > Reducer란?
  >
  > Action의 Type에 따라 변경? 변화? 바뀌는 함수.