### 1번 manual-controller 이용하여 설치하기

#### - 결과

```shell
== Nova services ==
openstack-nova-api:                     active
openstack-nova-compute:                 active
openstack-nova-network:                 inactive  (disabled on boot)
openstack-nova-scheduler:               active
openstack-nova-conductor:               active
openstack-nova-console:                 inactive  (disabled on boot)
openstack-nova-consoleauth:             active
openstack-nova-xvpvncproxy:             inactive  (disabled on boot)
== Glance services ==
openstack-glance-api:                   active
openstack-glance-registry:              active
== Keystone service ==
openstack-keystone:                     inactive  (disabled on boot)
== Horizon service ==
openstack-dashboard:                    active
== neutron services ==
neutron-server:                         failed
neutron-dhcp-agent:                     active
neutron-l3-agent:                       active
neutron-metadata-agent:                 active
neutron-linuxbridge-agent:              active
== Cinder services ==
openstack-cinder-api:                   active
openstack-cinder-scheduler:             active
openstack-cinder-volume:                inactive  (disabled on boot)
openstack-cinder-backup:                inactive  (disabled on boot)
== Support services ==
mariadb:                                active
libvirtd:                               active
openvswitch:                            inactive  (disabled on boot)
dbus:                                   active
rabbitmq-server:                        active
memcached:                              active
== Keystone users ==
+----------------------------------+-----------+
| ID                               | Name      |
+----------------------------------+-----------+
| 315243a6774b4646a8d95c928cc04f36 | cinder    |
| 3653f1ceedf94c879d87f37cb1c60ae6 | glance    |
| 3fe99103db1342ada42672c2c10d700d | neutron   |
| 5c8f00b25fa64eadb40aad559d381b31 | admin     |
| ad439ecb49a443529d4383ee25c21b3c | nova      |
| be6bdf49d54f4120b112591e80e81c3f | myuser    |
| c81e0e865366422aab71080119b1db6d | placement |
+----------------------------------+-----------+
== Glance images ==

+--------------------------------------+--------+
| ID                                   | Name   |
+--------------------------------------+--------+
| 0d14ae59-a719-4000-b3a4-0ad3341823f5 | cirros |
+--------------------------------------+--------+
== Nova managed services ==

+--------------------------------------+------------------+------------+----------+---------+-------+----------------------------+-----------------+-------------+
| Id                                   | Binary           | Host       | Zone     | Status  | State | Updated_at                 | Disabled Reason | Forced down |
+--------------------------------------+------------------+------------+----------+---------+-------+----------------------------+-----------------+-------------+
| f71ea19c-567e-4200-b326-e7bc6e6832ef | nova-scheduler   | controller | internal | enabled | up    | 2020-01-17T08:43:13.000000 | -               | False       |
| 0e0f902a-ffec-41ee-8c22-7ba398205c9b | nova-consoleauth | controller | internal | enabled | up    | 2020-01-17T08:43:11.000000 | -               | False       |
| b79b6a48-87ae-4610-918a-a7f2424b0056 | nova-conductor   | controller | internal | enabled | up    | 2020-01-17T08:43:13.000000 | -               | False       |
| 546483c9-d8c3-4cd2-bdf2-e48d89c462df | nova-compute     | controller | nova     | enabled | up    | 2020-01-17T08:43:11.000000 | -               | False       |
+--------------------------------------+------------------+------------+----------+---------+-------+----------------------------+-----------------+-------------+

```

- prerequisites 확인 mysql 접속하여 db생성하고 grant 부여(admin-openrc 접속 )

```shell
$openstack user create --domain default --password-prompt nova
$openstack role add --project service --user nova admin
$openstack service create --name nova \
  --description "OpenStack Compute" compute
$openstack endpoint create --region RegionOne \
  compute public http://controller:8774/v2.1 //endpoint 3개 생성
$openstack user create --domain default --password-prompt placement 
$ openstack role add --project service --user placement admin
  
```

- install  components 

```shell
# yum install openstack-nova-api openstack-nova-conductor \
  openstack-nova-console openstack-nova-novncproxy \
  openstack-nova-scheduler openstack-nova-placement-api

```

- etc/nova/nova.conf  수정하기 

```shell
[DEFAULT]
# ...
enabled_apis = osapi_compute,metadata
[database]
# ...
connection = mysql+pymysql://nova:NOVA_DBPASS@controller/nova

[placement_database]
# ...
connection = mysql+pymysql://placement:PLACEMENT_DBPASS@controller/placement // 등 수정하기 
```

- cello databse 설정

```shell
#su -s /bin/sh -c "nova-manage api_db sync" nova
#su -s /bin/sh -c "nova-manage cell_v2 map_cell0" nova
# su -s /bin/sh -c "nova-manage cell_v2 create_cell --name=cell1 --verbose" nova

```

- finallize installation( enable,start )

```shell
systemctl enable openstack-nova-api.service \
  openstack-nova-consoleauth openstack-nova-scheduler.service \
  openstack-nova-conductor.service openstack-nova-novncproxy.service
# systemctl start openstack-nova-api.service \
  openstack-nova-consoleauth openstack-nova-scheduler.service \
  openstack-nova-conductor.service openstack-nova-novncproxy.service
```

### networking service

- /etc/neutron/neutron.conf 파일 수정

```shell
# yum install openstack-neutron-linuxbridge ebtables ipset 
# systemctl restart openstack-nova-compute.service
# systemctl enable neutron-linuxbridge-agent.service
# systemctl start neutron-linuxbridge-agent.service  //서비스 확인하기 
```



```shell
# systemctl restart openstack-nova-api.service
# systemctl enable neutron-server.service \
  neutron-linuxbridge-agent.service neutron-dhcp-agent.service \
  neutron-metadata-agent.service
# systemctl start neutron-server.service \
  neutron-linuxbridge-agent.service neutron-dhcp-agent.service \
  neutron-metadata-agent.service 
```

### dashboard

````shell
# yum install openstack-dashboard
````

- cd /etc/openstack-dashboard/local_settings 파일 수정 

```shell
OPENSTACK_KEYSTONE_URL = "http://%s:5000/v3" % OPENSTACK_HOST

OPENSTACK_API_VERSIONS = {
    "identity": 3,
    "image": 2,
    "volume": 2,
} // 등을 수정 

# systemctl restart httpd.service memcached.service //  http://10.0.0.11/dashboard 접속
default / admin / ADMIN_PASS 로 로그인 가능 
```

 ![d](https://user-images.githubusercontent.com/57612803/72597565-5d611880-3951-11ea-8739-5cf69ddb38a5.PNG)



 

