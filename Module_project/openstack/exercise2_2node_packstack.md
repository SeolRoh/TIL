## Private Cloud 구축을 위한 Openstack

주제2 - packstack을 이용하여 two-nodes openstack 을 구축합니다.   

환경 설정 : Controller.vmdk-10.0.0.200 (6G,2cpus), Compute1.vmdk-10.0.0.201 (2G,2cpus)

>1. vmdk 파일을 구축합니다.
>
>2. packstack 을 설치합니다. - controller 에 설치 (설치 전 compute와 연동) 
>
>3. glance의 backend stores를 swift와 연결합니다.
>
>4. dashboard에 연결하여 cirros 이미지를 등록합니다.
>
>5. swift 사용자로 로그인하여 저장된 container를 확인합니다.
>
>6.  packstack answerfile의 요구사항
>
>   CONFIG_DEFAULT_PASSWORD=abc123 
>   CONFIG_CEILOMETER_INSTALL=n 
>   CONFIG_AODH_INSTALL=n 
>   CONFIG_KEYSTONE_ADMIN_PW=abc123 
>   CONFIG_HEAT_INSTALL=y 
>   CONFIG_MAGNUM_INSTALL=y 
>   CONFIG_TROVE_INSTALL=y 
>   CONFIG_NEUTRON_L2_AGENT=openvswitch 
>   CONFIG_NEUTRON_OVS_BRIDGE_IFACES=br-ex:ens33 
>   CONFIG_COMPUTE_HOSTS=10.0.0.200,10.0.0.201 
>
>   

1. 각각의 vmdk파일에 ip설정을 합니다.
   + vi /etc/sysconfig/network-scripts/ifcfg-ens33
   + ipaddr 부분 10.0.0.200, 201로 설정 후 reboot

2. packstack 설치하기

   ```
   1) yum 업데이트
   [root@controller ~]# yum update
   
   2)오픈스택 ocata 버전 설치를 위한 패키지 설치
   [root@controller /]# yum install centos-release-openstack-ocata epel-release -y
   Complete!
   
   3) 팩스택 패키지 설치(한 130개? y를 두번 눌렀음, 오래걸림)
   [root@controller ~]# yum install openstack-packstack -y
   Complete!
   
   4) 오픈스택 패키지 정보 확인
   [root@controller /]# rpm -qa|grep openstack
   puppet-openstack_extras-13.3.1-1.el7.noarch
   openstack-packstack-puppet-13.0.0-1.el7.noarch
   puppet-openstacklib-13.3.1-1.el7.noarch
   openstack-packstack-13.0.0-1.el7.noarch
   centos-release-openstack-rocky-1-1.el7.centos.noarch
   
   5) network, 방화벽 조건 설정
   [root@controller /]# systemctl disable firewalld
   [root@controller /]# systemctl stop firewalld
   [root@controller /]# setenforce 0
   setenforce: SELinux is disabled
   [root@controller /]# systemctl disable NetworkManager
   [root@controller /]# systemctl stop NetworkManager
   [root@controller /]# systemctl enable network
   network.service is not a native service, redirecting to /sbin/chkconfig.
   Executing /sbin/chkconfig network on
   [root@controller /]# systemctl start network
   
   6) answerfile.txt 수정
   [root@controller ~]# packstack --gen-answer-file=/root/answerfile.txt
   Packstack changed given value  to required value /root/.ssh/id_rsa.pub
   [root@controller ~]# vi answerfile.txt
   
   CONFIG_DEFAULT_PASSWORD=abc123 
   CONFIG_CEILOMETER_INSTALL=n 
   CONFIG_AODH_INSTALL=n 
   CONFIG_KEYSTONE_ADMIN_PW=abc123 
   CONFIG_HEAT_INSTALL=y 
   CONFIG_MAGNUM_INSTALL=y 
   CONFIG_TROVE_INSTALL=y 
   CONFIG_NEUTRON_L2_AGENT=openvswitch 
   CONFIG_NEUTRON_OVS_BRIDGE_IFACES=br-ex:ens33 
   CONFIG_COMPUTE_HOSTS=10.0.0.200,10.0.0.201 
   
   7) hosts 수정
   -----------------------------------------------------------------------------
   [root@controller ~]# vi /etc/hosts
   127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4
   ::1         localhost localhost.localdomain localhost6 localhost6.localdomain6
   10.0.0.200 controller
   10.0.0.201 compute1
   -----------------------------------------------------------------------------
   [root@compute1 ~]# vi /etc/hosts
   127.0.0.1   localhost localhost.localdomain localhost4 localhost4.localdomain4
   ::1         localhost localhost.localdomain localhost6 localhost6.localdomain6
   10.0.0.200 controller
   10.0.0.201 compute1
   [root@compute1 ~]# hostname -i
   10.0.0.201 (이전엔 ip주소만 201이었지 hostname -i는 101이었다.)
   -----------------------------------------------------------------------------
   
   8) Answerfile.txt으로 팩스택 설치 (한 사십분 넘게 소요~ 1:30 It depends on Network)
   [root@controller ~]# packstack --answer-file=/root/answerfile.txt
   Welcome to the Packstack setup utility
   
   The installation log file is available at: /var/tmp/packstack/20200119-211159-1kTzOT/openstack-setup.log
   
   Installing:
   Clean Up                                             [ DONE ]
   Discovering ip protocol version                      [ DONE ]
   root@10.0.0.201's password: 
   root@10.0.0.200's password: # 여기서 abc123입력
   ------------중략---------------
   Finalizing                                           [ DONE ]
   
    **** Installation completed successfully ******

   Additional information:
    * Time synchronization installation was skipped. Please note that unsynchronized time
    * File /root/keystonerc_admin has been created on OpenStack client host 10.0.0.200. T
    * To access the OpenStack Dashboard browse to http://10.0.0.200/dashboard .
   Please, find your login credentials stored in the keystonerc_admin in your home direct
    * The installation log file is available at: /var/tmp/packstack/20200119-211159-1kTzO
    * The generated manifests are available at: /var/tmp/packstack/20200119-211159-1kTzOT
   
   [root@controller ~]# ls (keystonerc_admin이 생겼다.)
   anaconda-ks.cfg  answerfile.txt  keystonerc_admin  keystonerc_demo
   
   [root@controller ~]# . keystonerc_admin (admin계정으로 들어옴) 
   [root@controller ~(keystone_admin)]#  (들어왔다는 표시)
   
   ```
   
   
   
   9) 10.0.0.200/dashboard로 접속하기 사용자는 admin
   
   ![openstack_dashboard](https://user-images.githubusercontent.com/34231229/72682384-d4dca680-3b0f-11ea-9805-68f709931a12.JPG)
   
   3. glance의 backend stores를 swift와 연결 629p
   
      ```powershell
      1) 이미지 확인
      [root@controller ~]# . keystonerc_admin 
      [root@controller ~(keystone_admin)]# openstack image list
      +--------------------------------------+--------+--------+
      | ID                                   | Name   | Status |
      +--------------------------------------+--------+--------+
      | 0faeed75-18b7-45d2-aa36-571cc4214a75 | cirros | active |
      +--------------------------------------+--------+--------+
      
      [root@controller ~(keystone_admin)]# ll /var/lib/glance/images
      합계 12960
      -rw-r----- 1 glance glance 13267968  1월 19 22:03 0faeed75-18b7-45d2-aa36-571cc4214a75
      
      
      -------------------------------------------------------------------------
      궁금해서 보는 /var/lib 파일 내부. keystone, nova, NetworkManager, swift, heat, haproxy, yum, cinder, openstack-dashboard, glance 등이있다.
      -------------------------------------------------------------------------
      [root@controller lib(keystone_admin)]# ls
      NetworkManager  dbus      gssproxy   keystone   mysql                openvswitch  rabbitmq   stateless  unbound
      alternatives    dhclient  haproxy    libvirt    net-snmp             os-prober    rpcbind    swift      vmware
      authconfig      dibbler   heat       logrotate  neutron              plymouth     rpm        systemd    yum
      chrony          dnsmasq   hiera      machines   nfs                  polkit-1     rpm-state  tpm
      cinder          games     initramfs  magnum     nova                 postfix      rsyslog    trove
      dav             glance    iscsi      misc       openstack-dashboard  puppet       selinux    tuned
      -------------------------------------------------------------------------
      여기서 /var/lib 랑 /etc내부랑 다름
      -------------------------------------------------------------------------
      
      2) glance-api.conf 수정
      [root@controller etc(keystone_admin)]# vi /etc/glance/glance-api.conf
      
      --------------------------------------------------------------------------
       **Glance 설정 파일을 열어서 이미지 저장 장치로 swift를 추가한다.
       stores=file,http,swift
      
         **기본 저장 장치를 file 에서 swift로 변경
         2106 #default_store = file
         2107 default_store=swift
      
         **로컬 디렉토리를 사용하지 않도록 코멘트(#)처리
         2440 #filesystem_store_datadir = /var/lib/glance/images
         2441 #filesystem_store_datadir=/var/lib/glance/images/
      
         **주석제거 반드시 버전은 2말고 3으로
         3213 swift_store_auth_version =3
         
         **swift서비스의 인증 정보 추가
         3222 swift_store_auth_address = http://10.0.0.200:5000/v3 (cat keystonerc_admin)
         
         **swift서비스의 프로젝트와 사용자이름 추가 : 이건 대시보드 들어가서 서비스이름확인
         3230 swift_store_user = services:swift 
         
         **answerfile.txt로 해당 키 확인 가능
         [root@controller ~(keystone_admin)]# grep SWIFT answerfile.txt 
      CONFIG_SWIFT_INSTALL=y
      CONFIG_SWIFT_KS_PW=90c4295d6199416c
      CONFIG_SWIFT_STORAGES=
      CONFIG_SWIFT_STORAGE_ZONES=1
      CONFIG_SWIFT_STORAGE_REPLICAS=1
      CONFIG_SWIFT_STORAGE_FSTYPE=ext4
      CONFIG_SWIFT_HASH=9df33b941f184fa9
      CONFIG_SWIFT_STORAGE_SIZE=2G
      
        **keystone을 사용해서 생성한 swift 사용자의 인증 패스워드를 정의한다.
        3239 swift_store_key =90c4295d6199416c
        
        **오브젝트 스토리지 서비스도 이미지 저장 장치로서 추가한다.
        2991 swift_store_create_container_on_put =True
        
        **사용할 컨테이너 이름을 지정한다.
        2921 swift_store_container = glance
        
        **설정 파일 수정 후에 Glance 서비스들을 다시 시작하고 포트 번호를 확인한다.
        3467 os_region_name=RegionOne
      
      ```
   
      
   
   4. dashboard에 연결하여 cirros 이미지를 등록
   
      ```
      [root@controller etc(keystone_admin)]# systemctl restart openstack-glance-api openstack-glance-registry
      [root@controller etc(keystone_admin)]# lsof -i tcp:9292
      COMMAND     PID   USER   FD   TYPE DEVICE SIZE/OFF NODE NAME
      httpd     17045 apache   14u  IPv4 418827      0t0  TCP controller:38558->controller:armtechdaemon (CLOSE_WAIT)
      httpd     17045 apache   30u  IPv4 416696      0t0  TCP controller:38548->controller:armtechdaemon (CLOSE_WAIT)
      httpd     17046 apache   31u  IPv4 416684      0t0  TCP controller:38542->controller:armtechdaemon (CLOSE_WAIT)
      httpd     17046 apache   33u  IPv4 414368      0t0  TCP controller:38442->controller:armtechdaemon (CLOSE_WAIT)
      httpd     17046 apache   34u  IPv4 417944      0t0  TCP controller:38562->controller:armtechdaemon (CLOSE_WAIT)
      glance-ap 43946 glance    4u  IPv4 508087      0t0  TCP *:armtechdaemon (LISTEN)
      glance-ap 44019 glance    4u  IPv4 508087      0t0  TCP *:armtechdaemon (LISTEN)
      glance-ap 44020 glance    4u  IPv4 508087      0t0  TCP *:armtechdaemon (LISTEN)
      
      ```
   
      **admin 이미지 넣기 전**
   
      ![admin_before](https://user-images.githubusercontent.com/34231229/72683002-d198e900-3b16-11ea-84c1-c74a0f0a89b7.JPG)
   
      **swift 이미지 넣기 전**
   
      ![swift_before](https://user-images.githubusercontent.com/34231229/72683021-00af5a80-3b17-11ea-9ef6-7f733e87defc.JPG)
   
      **admin에서 이미지 생성**
   
      ![add_image](https://user-images.githubusercontent.com/34231229/72683047-466c2300-3b17-11ea-9faa-da49f40c75c8.JPG)
   
      
   
      **admin 이미지 생성 후**
   
      ![admin_after](https://user-images.githubusercontent.com/34231229/72683204-a1eae080-3b18-11ea-9eaf-eb395980e21a.JPG)
   
      
   
   ​		**swift로 접속 해 admin에서 만든 이미지가 있는지 확인**
   
   ​		![swift_after](https://user-images.githubusercontent.com/34231229/72683249-03ab4a80-3b19-11ea-9a2c-a1253e49cba4.JPG)
   
   
   
   3. swift 사용자로 로그인하여 저장된 container를 확인합니다.
   
      앞서 파일 수정할때 컨테이너의 이름을 glance 라고 해두었다. `swift_store_continer=glance`
   
      
   
   
   
   
   
   ## 약간의 TIP
   
   keystonerc_admin 파일 안에 들어가 마지막 줄에 해당 명령어를 넣어준다.
   
   `export PSI='[\u@h \W(keystonerc_admin)]\$'`
   
   그러면 `. keystonerc_admin` 으로 접속시 접속 여부를 확인할수 있다. 