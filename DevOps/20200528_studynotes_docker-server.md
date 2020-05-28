#### 20200528 Docker-server

---

+ docker-server

  + vurtual machine 설정에서 cpu: 2, 메모리: 2048

  + port 38080 ==>아직 안함

  + docker ce설치

    ```zsh
    C:\Users\HPE\work\Vagrant>vagrant ssh docker-server
    Last login: Tue May 26 00:39:52 2020 from 10.0.2.2
    [vagrant@docker-server ~]$ sudo yum install -y yum-utils
    Updated:
      yum-utils.noarch 0:1.1.31-54.el7_8
    
    Complete!
    [vagrant@docker-server ~]$ sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo
    Complete!
    [vagrant@docker-server ~]$ sudo yum install docker-ce docker-ce-cli containerd.io
    ```

  + docker-server 시작

    ```zsh
    [vagrant@docker-server ~]$ sudo systemctl start docker
    [vagrant@docker-server ~]$ sudo docker run hello-world
    Unable to find image 'hello-world:latest' locally
    latest: Pulling from library/hello-world
    0e03bdcc26d7: Pull complete
    Digest: sha256:6a65f928fb91fcfbc963f7aa6d57c8eeb426ad9a20c7ee045538ef34847f44f1
    Status: Downloaded newer image for hello-world:latest
    
    Hello from Docker!
    This message shows that your installation appears to be working correctly.
    
    To generate this message, Docker took the following steps:
     1. The Docker client contacted the Docker daemon.
     2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
        (amd64)
     3. The Docker daemon created a new container from that image which runs the
        executable that produces the output you are currently reading.
     4. The Docker daemon streamed that output to the Docker client, which sent it
        to your terminal.
    
    To try something more ambitious, you can run an Ubuntu container with:
     $ docker run -it ubuntu bash
    
    Share images, automate workflows, and more with a free Docker ID:
     https://hub.docker.com/
    
    For more examples and ideas, visit:
     https://docs.docker.com/get-started/
    ```

  + docker admin 계정 생성하기 (password: dockeradmin)

    ```zsh
    [vagrant@docker-server ~]$ sudo useradd dockeradmin
    [vagrant@docker-server ~]$ sudo passwd dockeradmin
    Changing password for user dockeradmin.
    New password:
    BAD PASSWORD: The password contains the user name in some form
    Retype new password:
    passwd: all authentication tokens updated successfully.
    ```

  + dockeradmin에 docker 그룹추가하기

    ```zsh
    [vagrant@docker-server ~]$ sudo usermod -aG docker dockeradmin
    ```

    + docker ps 하기 전, dockeradmin으로 접속하기

      ```zsh
      [vagrant@docker-server ~]$ su dockeradmin
      Password:
      [dockeradmin@docker-server vagrant]$ docker ps
      CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS              PORTS               NAMES
      ```

  + 1, 2, 3 모두 docker 설치해야한다. (ansiable, jenkins, tomcat)

    + Vagrantfile 내부에 넣기 for ansiable

      ```
        # Ansible
        config.vm.define:"ansible-server" do |cfg|
          cfg.vm.box = "centos/7"
          cfg.vm.provider:virtualbox do |vb|
              vb.name="ansible-server"
              vb.customize ["modifyvm", :id, "--cpus", 2]
              vb.customize ["modifyvm", :id, "--memory", 2048]
          end
          cfg.vm.host_name="ansible-server"
          cfg.vm.network "private_network", ip: "192.168.56.10"
          cfg.vm.network "forwarded_port", guest: 22, host: 9211, auto_correct: false, id: "ssh"
        end
      ```

    + vagrant reload 명령어 사용

      + vagrant 다시 시자하기

      vagrant ssh 서버이름: 콘솔서 접속시 사용

      + 다른 곳에서 사용하고 자 한다면? 

        `vagrant ssh-config`명령 사용해서 private key값을 확인해보자.

        ssh 뒤에 id와password가 필요하다.

        ```
        ssh -p 22 -i 키값파일주소 vagrant@ip주소
        # 또는
        ssh id@ip주소 -p 설정파일port번호
        password : "private_key 값"
        ```

        

  + docker-server에 `tomcat`설치하기

    ```zsh
    [vagrant@docker-server ~]$ sudo docker pull tomcat
    Status: Downloaded newer image for tomcat:latest
    docker.io/library/tomcat:latest
    [vagrant@docker-server ~]$ su dockeradmin
    Password:
    [dockeradmin@docker-server vagrant]$ docker run -d -p8080:8080 --name tomcat tomcat
    d1b553bb84327874cbeb363d7be2ad95b5a27164855c1349a6abbb57cb225a84
    [dockeradmin@docker-server vagrant]$ docker ps
    CONTAINER ID        IMAGE               COMMAND             CREATED             STATUS              PORTS                    NAMES
    d1b553bb8432        tomcat              "catalina.sh run"   5 seconds ago       Up 4 seconds        0.0.0.0:8080->8080/tcp   tomcat
    ```

    + container 안의 webapp의 내용을 copy

      ```zsh
      [dockeradmin@docker-server vagrant]$ docker exec -it d1b553bb8432 bash
      root@d1b553bb8432:/usr/local/tomcat# cp -R ./webapps.dist/ROOT ./webapps
      root@d1b553bb8432:/usr/local/tomcat# exit
      exit
      [dockeradmin@docker-server vagrant]$ docker restart tomcat
      tomcat
      ```

  + docker instance에 각각 하나의 `war`파일을 올려서 `MSA`로 사용이 가능하다.!!!

  + `http://localhost:38080/webapp` 실행시 도커에 있는 webapp이라는 마이크로서비스 실행할 예정

+ jenkins-server

  + publish over ssh 플러그인 설치
    + ![캡처](https://user-images.githubusercontent.com/34231229/83149631-48816680-a135-11ea-9e78-63582507a4d5.JPG)
    + 새 ITem 생성
    + Item의 이름 입력 후 하단부의 `copy from`에 Deploy_to_Tomcat 적기
    + 빌드 후 조치 수정
      + send vuild artifact over SSH
        + ![캡처](https://user-images.githubusercontent.com/34231229/83152098-600e1e80-a138-11ea-8d6d-2ad3e7a11b9e.JPG)
        + SSH설정한대로 클릭
      + Transfer
      + Tansfer Set
        + Source files
          + jenkins-server에 `/var/lib/jenkins/workspace/Deploy_to_Tomcat_server/webapp/target` 에 있는 war 파일
          + webapp/target/*.war
          + ![캡처](https://user-images.githubusercontent.com/34231229/83152314-a4012380-a138-11ea-97fa-6f4b4b670e22.JPG)
  + 폴더 구조까지 복사 되었기 때문에 제외시킨다==>무슨말일까.

+ docker-server

  + 해당 내용이 복사되었는지 webapp으로 확인하기!!

  + tomcat container의 webapp폴더에 war파일을 넣는다.

    + Dockerfile 생성

      ```dockerfile
      FROM tomcat
      COPY ./webapp.war /usr/local/tomcat/webapps
      ```

    + 이미지 빌드

  + maven이미지로 만들고 싶다면?

