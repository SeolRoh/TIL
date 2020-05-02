20200501 리액트 복습React_and_Babelcompiler

---

1. create-react-app 설치(node.js 설치 후)

   ```powershell
   npm install -g create-react-app // -g는 전역에 설치하기 위함
   ```

2. react 프로젝트 생성(생성하고자하는 파일 디렉토리에서)

   ```powershell
   C:\React\hello-react-app> create-react-app hello-react-app // (만들고자하는 prj_name)
   ```

3. start (생성한 프로젝트 디렉토리에서)

   ```powershell
   C:\React\hello-react-app> npm start
   ```

4. build 할때는?  build후에 디렉토리로 가면 `build` 폴더가 생겼음을 확인가능하다.

   ```powershell
   C:\React\hello-react-app>npm run build
   > hello-react-app@0.1.0 build C:\React\hello-react-app
   > react-scripts build
   
   Creating an optimized production build...
   Compiled successfully.
   
   File sizes after gzip:
   
     39.39 KB  build\static\js\2.4d122768.chunk.js
     780 B     build\static\js\runtime-main.62519794.js
     651 B     build\static\js\main.0d274c7c.chunk.js
     556 B     build\static\css\main.d1b05096.chunk.css                         
   The project was built assuming it is hosted at /.
   You can control this with the homepage field in your package.json.
   
   The build folder is ready to be deployed.
   You may serve it with a static server:
   
     npm install -g serve
     serve -s build
   
   Find out more about deployment here:
   
     bit.ly/CRA-deploy                                                          
   
   ```

   

---

package.json

>Babel https://babeljs.io/
>
>ESLint https://eslint.org/
>
>Sass [Sass (스타일시트 언어) - 위키백과, 우리 모두의 백과사전](https://ko.wikipedia.org/wiki/Sass_(스타일시트_언어)) ) ,`CSS의 확장`
>
>WebPack [웹팩(Webpack) 이란, 웹팩 간단 정리 및 리액트 기본](https://jusungpark.tistory.com/52)
>
>

