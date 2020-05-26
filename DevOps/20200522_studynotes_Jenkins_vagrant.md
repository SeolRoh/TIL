```powershell
C:\Users\HPE\work\Vagrant>vagrant up
Bringing machine 'jenkins-server' up with 'virtualbox' provider...
Bringing machine 'tomcat-server' up with 'virtualbox' provider...
Bringing machine 'docker-server' up with 'virtualbox' provider...
C:\Users\HPE\work\Vagrant>vagrant plugin install vagrant-vbguest
Installing the 'vagrant-vbguest' plugin. This can take a few minutes...
Installed the plugin 'vagrant-vbguest (0.24.0)'!
C:\Users\HPE\work\Vagrant>code .
															// public ==> private 3개
C:\Users\HPE\work\Vagrant>vagrant status
Current machine states:

jenkins-server            running (virtualbox)
tomcat-server             running (virtualbox)
docker-server             running (virtualbox)

This environment represents multiple VMs. The VMs are all listed
above with their current state. For more information about a specific
VM, run `vagrant status NAME`.
C:\Users\HPE\work\Vagrant>vagrant ssh jenkins-server
Last login: Fri May 22 05:14:01 2020 from 10.0.2.2

[vagrant@jenkins-server ~]$ sudo yum install -y java-1.8*
Loaded plugins: fastestmirror
[vagrant@jenkins-server ~]$ java -version
openjdk version "1.8.0_252"
OpenJDK Runtime Environment (build 1.8.0_252-b09)
OpenJDK 64-Bit Server VM (build 25.252-b09, mixed mode)
[vagrant@jenkins-server ~]$ sudo yum install -y wget
Installed:
  wget.x86_64 0:1.14-18.el7_6.1

Complete!
[vagrant@jenkins-server ~]$ sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
--2020-05-22 05:19:37--  https://pkg.jenkins.io/redhat-stable/jenkins.repo
Resolving pkg.jenkins.io (pkg.jenkins.io)... 151.101.230.133, 2a04:4e42:36::645
Connecting to pkg.jenkins.io (pkg.jenkins.io)|151.101.230.133|:443... connected.
HTTP request sent, awaiting response... 200 OK
Length: 85
Saving to: ‘/etc/yum.repos.d/jenkins.repo’

100%[========================================>] 85          --.-K/s   in 0s

2020-05-22 05:19:38 (1.82 MB/s) - ‘/etc/yum.repos.d/jenkins.repo’ saved [85/85]
[vagrant@jenkins-server ~]$ sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key
[vagrant@jenkins-server ~]$ sudo yum -y install jenkins
Installed:
  jenkins.noarch 0:2.222.3-1.1

Complete!
[vagrant@jenkins-server ~]$ sudo service jenkins start
Starting jenkins (via systemctl):                          [  OK  ]
[vagrant@jenkins-server ~]$ chkconfig jenkins on
You do not have enough privileges to perform this operation.
[vagrant@jenkins-server ~]$ sudo chkconfig jenkins on
```

 **localhost:18080 접속 후 화면에 뜬 대로 :   /var/lib/jenkins/secrets/initialAdminPassword 복사**

```powershell
[vagrant@jenkins-server ~]$ sudo cat /var/lib/jenkins/secrets/initialAdminPassword
//여기에 initialAdminPassword 출력되면 localhost:18080에 입력 후 버튼 클릭후 접속
//Jenkins에 오신 것을 환영합니다.
[vagrant@jenkins-server ~]$ sudo cat /etc/hosts
127.0.0.1       jenkins-server  jenkins-server
127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4
::1         localhost localhost.localdomain localhost6 localhost6.localdomain6
[vagrant@jenkins-server ~]$ sudo vi /etc/ssh/sshd_config
검색=> /Password
PasswordAuthentication yes 바꿔줌
"/etc/ssh/sshd_config" 140L, 3916C
[vagrant@jenkins-server ~]$ sudo systemctl restart sshd

도커서버에도 해준다.
C:\Users\HPE\work\Vagrant>vagrant ssh docker-server
[vagrant@docker-server ~]$ sudo vi /etc/ssh/sshd_config
[vagrant@docker-server ~]$  140L, 3917C written
[vagrant@docker-server ~]$ sudo systemctl restart sshd
[vagrant@docker-server ~]$ exit
톰캣서버에도 해준다.
C:\Users\HPE\work\Vagrant>vagrant ssh tomcat-server
Last login: Fri May 22 05:31:00 2020 from 10.0.2.2
[vagrant@tomcat-server ~]$ sudo vi /etc/ssh/sshd_config
[vagrant@tomcat-server ~]$  140L, 3917C written
[vagrant@tomcat-server ~]$ sudo systemctl restart sshd
[vagrant@docker-server ~]$ exit
```



젠킨스에서` http://localhost:18080/job/Jenkins_First_Project/configure` 아이템 생성

```powershell
[vagrant@jenkins-server ~]$ find /usr/lib/jvm/java-1.8* | head -n 3
/usr/lib/jvm/java-1.8.0
/usr/lib/jvm/java-1.8.0-openjdk
/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.252.b09-2.el7_8.x86_64

```

다시 페이지에서 Build => Execute shell => Command `echo "Welcome to DevOps project"` 작성

**끝**

---

젠킨스에 **`*sonarQube*`**를 연동하면 좋은점.

테스트코드를 작성후 돌리면 성공 수치,  어디가 부족한지 통계를 내주는 플러그 인.



tomcat서버에 할일

1.자바설치

2.apache tomcat 설치 버전 9+

3.localhost:28080

```
[vagrant@tomcat-server ~]$ sudo yum install -y java-1.8*
Loaded plugins: fastestmirror
Complete!
[vagrant@tomcat-server ~]$ java -version
openjdk version "1.8.0_252"
OpenJDK Runtime Environment (build 1.8.0_252-b09)
OpenJDK 64-Bit Server VM (build 25.252-b09, mixed mode)
[vagrant@tomcat-server ~]$ sudo yum install -y wget


[vagrant@jenkins-server ~]$ vi ~/.bash_profile

# .bash_profile

# Get the aliases and functions
if [ -f ~/.bashrc ]; then
        . ~/.bashrc
fi

# User specific environment and startup programs
PATH=$PATH:$HOME/.local/bin:$HOME/bin

JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.252.b09-2.el7_8.x86_64

export JAVA_HOME

PATH=$PATH:$JAVA_HOME

export PATH
~                                                                             ~                                                                             "~/.bash_profile" 17L, 305C
```

tomcat관리 계정생성

sudo useradd tomcat

sudo userpasswd tomcattomcat

```
# 생성한 계정으로 JAVA_HOME 및 PATH 설정 진행
[root@localhost sw]# su - tomcat9jdk8
[tomcat9jdk8@localhost ~]$ vi .bash_profile
[출처] [Apache & TOMCAT 연동 3] CentOS7에 톰캣 설치|작성자 tawoo0
```

```
[vagrant@tomcat-server bin]$ ./startup.sh
Using CATALINA_BASE:   /home/vagrant/apache-tomcat-9.0.35
Using CATALINA_HOME:   /home/vagrant/apache-tomcat-9.0.35
Using CATALINA_TMPDIR: /home/vagrant/apache-tomcat-9.0.35/temp
Using JRE_HOME:        /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.252.b09-2.el7_8.x86_64
Using CLASSPATH:       /home/vagrant/apache-tomcat-9.0.35/bin/bootstrap.jar:/home/vagrant/apache-tomcat-9.0.35/bin/tomcat-juli.jar
Tomcat started
```

---

jenkins에서 tomcat 서버에 배포

1. hello-world clone 해서 각자 계정 사용 (checkout)

   ```zsh
   git remote remove origin
   git remote add 저장소_이름 주소
   ```

2. webapp 폴더의 jsp 파일을 변경

3. jenkins 관리 -> 플러그인 관리 -> 설치가능

   1. github
   2. github integration

4. 재시작 없이 설치하기 버튼 클릭 --나는 에러발생하지 않음

   1. 에러 발생시 jenkins war파일 다운로드 -> data폴더로 복사
   2. java -jar jenkins.war
   3. war로 실행시 중간에 password 나옴 (특정 폴더 가서 볼 수도 있긴 함)



maven /git 설치

```powershell
[vagrant@jenkins-server home]$ whereis git
git: /usr/bin/git /usr/share/man/man1/git.1.gz
[vagrant@jenkins-server home]$ mvn -version
Apache Maven 3.0.5 (Red Hat 3.0.5-17)
Maven home: /usr/share/maven
Java version: 1.8.0_252, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.252.b09-2.el7_8.x86_64/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "3.10.0-1127.el7.x86_64", arch: "amd64", family: "unix"
```

젠킨스 콘솔 출력 => 해당 반영사항 확인하기 (git --version/mvn --version)

```
Started by user admin
Running as SYSTEM
Building in workspace /var/lib/jenkins/workspace/Jenkins_First_Project
[Jenkins_First_Project] $ /bin/sh -xe /tmp/jenkins1211596742315771400.sh
+ echo 'Welcome ro DevOps project'
Welcome ro DevOps project
+ git --version
git version 1.8.3.1
+ mvn --version
Apache Maven 3.0.5 (Red Hat 3.0.5-17)
Maven home: /usr/share/maven
Java version: 1.8.0_252, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-1.8.0-openjdk-1.8.0.252.b09-2.el7_8.x86_64/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "3.10.0-1127.el7.x86_64", arch: "amd64", family: "unix"
Finished: SUCCESS
```



plugin 설치

1. deply to container Plugin 2. maven integration



후 새 Item 추가 =>The_Project_maven

Git옵션에 해당 레파지토리 url 입력

Build옵션에 `Goals and options` => `clean install package` 후 Apply => build now



---

동일하게 새 Item 생성 `Deploy_to_Tomcat_server`

The_Project_maven 아이템처럼 그대로 한 상태에서

+ ![11](https://user-images.githubusercontent.com/34231229/82851746-c1b56980-9f3b-11ea-9d0c-d18078305000.JPG)

+ ![11](https://user-images.githubusercontent.com/34231229/82851777-e01b6500-9f3b-11ea-8e41-283b73731cdc.JPG)

+ Tomcat URL은 본인이 가진 Tomcat server의 IPAdress를 작성한다. 해당 서버 터미널에서 `ip a`명령어 사용

  + `**/*.war`

    - 모든 경로의 war파일

  ![11](https://user-images.githubusercontent.com/34231229/82851993-84051080-9f3c-11ea-961c-0e3c572dbd89.JPG)

+ `빌드 후 조치 추가` => war을 이용한 배포를 하기 위해 `Depoy war/ear to a container`

  ![11](https://user-images.githubusercontent.com/34231229/82851719-a2b6d780-9f3b-11ea-94b8-dea95093b218.JPG)

+ 성공

  ![11](https://user-images.githubusercontent.com/34231229/82852816-e6f7a700-9f3e-11ea-973e-3b114a2e69bc.JPG)

  

----

메모장

+ sudo cat /var/lib/jenkins/secrets/initialAdminPassword ~~~~ 
  ===>젠킨스 초기 페이지==> localhost:18080 접속

+ wget -p /sw http://mirror.navercorp.com/apache/tomcat/tomcat-9/v9.0.35/bin/apache-tomcat-9.0.35.tar.gz

---

사용한 리눅스 명령어 메모장

1. tail

   + 파일의 끝단 10줄 출력 cat보다 조금 출력

2. find ./ -name index.jsp

3. whereis ./index.jsp

   

