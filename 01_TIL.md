# GitHub 관리하기



### 1. 파일내에 .git 폴더 만들기

+ `git init` 명령어를 사용

```shell
$ cd ~
$ cd C:\Users\HPE\TIL #git폴더 'TIL'을 만들어 놓았다.
$ git init
```

```shell
HPE@DESKTOP-94S90OJ MINGW64 ~/TIL
$ git init
Initialized empty Git repository in C:/Users/HPE/TIL/.git/

HPE@DESKTOP-94S90OJ MINGW64 ~/TIL (master) # (master)만들어짐을 알수 있다.
$
```



### 2. '.git' 폴더 삭제하기

```shell
$ rm -r .git/
```



### 3. 작성한 Markdown 파일을 'TIL' 폴더에 넣기

#### 1)`git add` 명령어를 사용해 `a00_markdown_basic.md` 파일을 넣었다.

```shell
HPE@DESKTOP-94S90OJ MINGW64 ~/TIL (master)
$ git add 00_markdown_basic.md
```



#### 2)**`git status` 명령어를 사용해 상태 확인**

```shell
HPE@DESKTOP-94S90OJ MINGW64 ~/TIL (master)
$ git status
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        00_markdown_basic.md

nothing added to commit but untracked files present (use "git add" to track)
```



### 4. git 사용자 이름, 이메일 지정하기

+ Git commit 이란?

  `git commit` 명령어로 저장소에 올리는 작업 기록 공간으로, 파일 및 폴더의 추가/변경 사항을 확인 할 수 있다. (1. 변경 이력확인  2. 이전 버전 확인)

```shell
HPE@DESKTOP-94S90OJ MINGW64 ~/TIL (master)
$ git commit

*** Please tell me who you are.

Run

  git config --global user.email "you@example.com"
  git config --global user.name "Your Name"

to set your account's default identity.
Omit --global to set the identity only in this repository.

fatal: unable to auto-detect email address (got 'HPE@DESKTOP-94S90OJ.(none)')

```

위를 보면 `*** please tell me who you are.` 문장을 볼 수 있다.



+ 해당 깃의 이메일과 유저 확인하는 명령어 (미 등록시 결과값이 도출되지 않는다.)

  ```shell
  $ git config --global user.email
  $ git config --global user.name
  ```



+ 이메일과 유저 등록하는 명령어

  ```shell
  $ git config --global user.name "SeolRoh"
  $ git config --global user.email "seolroh@gmail.com"
  ```




+ `git commit` 명령어를 입력해보자.

  
  + 현재 상태에 대한 스냅샷을 commit하며, 버전 관리를 진행한다.
  
  ```shell
  $ git commit
  [master (root-commit) fc25af2] first commit:
   1 file changed, 175 insertions(+)
   create mode 100644 00_markdown_basic.md
   
   #특정파일만 commit 할시
   $ git commit -m "Add README.md" # ""내부에는 커밋메세지를 입력
  ```



### 5. commit history 조회하기

+ `git log` 명령어를 사용 (아래는 변경사항이 두개가 있음을 알수 있다.)

```shell
$ git log
commit 3f9eb8312f3bda4abb51cd04b9e304ac35055b3e (HEAD -> master)
Author: seolroh <seolroh@gmail.com>
Date:   Fri Dec 27 14:51:41 2019 +0900

    Add README.md

commit fc25af269028095fc808a3e91f7f788ea5e30740
Author: seolroh <seolroh@gmail.com>
Date:   Fri Dec 27 14:41:31 2019 +0900

    first commit:
```



+ `git log --oneline` 점점 늘어나는 history를 한 줄로 확인할수 있는 명령어

  ```shell
  $ git log --oneline
  3f9eb83 (HEAD -> master) Add README.md
  fc25af2 first commit:
  #위의 fc25af2를 통해 이전상태 확인가능하다.
  ```

  + 이전작업 확인하기 `git check (주소)` 명령어 사용

    ```shell
    $ git checkout fc25af2
    
    HPE@DESKTOP-94S90OJ MINGW64 ~/TIL ((fc25af2...)) 
    $ ls
    00_markdown_basic.md # 이전으로 돌아간 것을 알수 있다.
    ```

    위에 보면 `HPE@DESKTOP-94S90OJ MINGW64 ~/TIL ((fc25af2...))` 라고 (master) 표시가 사라짐을 확인할수 있다.

    

  + master 모드로 돌아가기 `git check master` 명령어 사용



### 6.  Git 원격저장소

#### (1)  Commit을 위한 Staging : `git add`

+ 현재 코드 상태의 스냅샷을 직기 위한 파일 선택(== Staging Area에 파일 추가)

```shell
$ git add create_TIL.bd(파일이름) #모든 변경 사항을 Stagind area로 올림
```



#### (2) 버전 관리를 위한 스냅샷 저장: git commit

+ 현재 상태에 대한 스냅샷을 commit하며, 버전 관리를 진행한다.

```shell
$ git commit -m "commit message" 
#현재 상태에 대한 스냅샷을 commit하며, 버전 관리를 진행
```



#### (3) 원격 저장소 정보 추가 : `git remote`

+ Github 원격(remote) 저장소(repository)를 생성하고 `TIL` 폴더와 연결한다.
+ 새로운 원격저장소가 추가될 시에만 

```shell
$ git remote add origin https://github.com/SeolRoh/TIL.git #원격저장소주소

$ git remote #origin 이 들어감을 알수 있다.
origin

$ git remote -v # 자세히 보기
origin  https://github.com/SeolRoh/TIL.git (fetch)
origin  https://github.com/SeolRoh/TIL.git (push)
```



+ Git 계정의 repository에 올리기 **`git push` ** (GitHub 회원가입 필요)

```shell
$ git push origin master # 뒤의 master 자리는 기본브랜치 자리
Enumerating objects: 6, done.
Counting objects: 100% (6/6), done.
Delta compression using up to 4 threads
Compressing objects: 100% (4/4), done.
Writing objects: 100% (6/6), 2.58 KiB | 528.00 KiB/s, done.
Total 6 (delta 0), reused 0 (delta 0)
To https://github.com/SeolRoh/TIL.git
 * [new branch]      master -> master
```

 이제 GitHub 본인 repository에 접속하면 올린 `README.md`파일과 `00_karkdown_basic.md`파일을 확인할 수 있다.



### 7. 집

+ 다른 사용자 -> settings -> 허가해주기

```shell
$ git clone https://github.com/SeolRoh/TIL.git (처음만)

$ git push origin master

$ touch initial

$ git add initial

$ git commit -m "initial commit"

$ git push origin master # GitHub의 로그인 창이 뜰 것이다.

$ git pull origin master
```



### 8. 그 외 명령어

+  `git diff`  명령을 통해 이전과 이후의 변경 내용을 비교할 수 있다.

+ .+ 추가내용 확인 

  ```shell
  $ git diff --staged 
  # Stagind Area에 있는 파일과 Git저장소에 최초 커밋된 파일의 내용을 비교
  diff --git a/README.md b/README.md
  new file mode 100644
  index 0000000..b117ee9
  --- /dev/null
  +++ b/README.md
  @@ -0,0 +1,3 @@
  +# TIL
  +
  +Today I Learned
  \ No newline at end of file
  ```



## 정리

```shell
$ git add 파일이름
$ git commit -m "commit message" 
$ git remote add origin https://github.com/SeolRoh/woedchain.git
$ git remote
$ git push origin master
```

