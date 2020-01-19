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
   
   8) Answerfile.txt으로 팩스택 설치 (한 사십분 넘게 소요)
   [root@controller ~]# packstack --answer-file=/root/answerfile.txt
   Welcome to the Packstack setup utility
   
   The installation log file is available at: /var/tmp/packstack/20200119-211159-1kTzOT/openstack-setup.log
   
   Installing:
   Clean Up                                             [ DONE ]
   Discovering ip protocol version                      [ DONE ]
   root@10.0.0.201's password: 
   root@10.0.0.200's password: # 여기서 abc123입력
   
   
   
   ```

   