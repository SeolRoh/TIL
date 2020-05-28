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

  + docker-server에 `tomcat`설치하기

    ```zsh
    
    ```

    