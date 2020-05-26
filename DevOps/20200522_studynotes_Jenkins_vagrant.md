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



----

메모장

sudo cat /var/lib/jenkins/secrets/initialAdminPassword ~~~~ 
===>젠킨스 초기 페이지==> localhost:18080 접속

wget -p /sw http://mirror.navercorp.com/apache/tomcat/tomcat-9/v9.0.35/bin/apache-tomcat-9.0.35.tar.gz

