20191223
1.grep
mkdir hhs
cd hhs
cp /etc/services data
grep NNTP data (= grep -i nntp data)



[root@centos ~]# grep newuser /etc/passwd /etc/shadow /etc/group

pw변경(root로 로그인)
#passwd newuser

#id -a student
#grep -i docker /etc/group

<우분투에서>
root@Docker: ~# usermod -aG docker
~# id -a student (추가사항 확인가능)
~# id

[root@centos ~]# grep user1 /etc/passwd /etc/shadow /etc/group
[root@centos ~]# ls /home
user1 newuser  student
[root@centos ~]# rm -rf /home/user1
[root@centos ~]# ls /home
newuser  student

[root@centos ~]# grep user1 /etc/passwd /etc/shadow
/etc/passwd:user1:x:1002:1003::/home/user1:/bin/bash
/etc/shadow:user1:!!:18253:0:99999:7:::
[root@centos ~]# change -l user1
bash: change: 명령을 찾을 수 없습니다...
[root@centos ~]# chage -l user1
마지막으로 암호를 바꾼 날					:12월 23, 2019
암호 만료					:안함
암호가 비활성화 기간					:안함
계정 만료						:안함
암호를 바꿀 수 있는 최소 날 수		: 0
암호를 바꿔야 하는 최대 날 수		: 99999
암호 만료 예고를 하는 날 수		: 7

[root@centos ~]# grep user1 /etc/passwd /etc/shadow /etc/group
/etc/passwd:user1:x:1002:1003::/home/user1:/bin/bash
/etc/shadow:user1:!!:18253:0:99999:7:::
/etc/group:user1:x:1003:

[root@centos ~]# chage -m l  -M 180 -W 15 -I 365 -E 12/31/2020 user1

(m 민 최소기간 1일 M 맥스 최대 기간 180일, W 워닝 15일전에 알림 I 로그인 365일동안 한번도 안할시 휴면계정 E계정만료 기간 설정 user1계정의)

Options:
  -d, --lastday LAST_DAY        set date of last password change to LAST_DAY
  -E, --expiredate EXPIRE_DATE  set account expiration date to EXPIRE_DATE
  -h, --help                    display this help message and exit
  -I, --inactive INACTIVE       set password inactive after expiration
                                to INACTIVE
  -l, --list                    show account aging information
  -m, --mindays MIN_DAYS        set minimum number of days before password
                                change to MIN_DAYS
  -M, --maxdays MAX_DAYS        set maximim number of days before password
                                change to MAX_DAYS
  -R, --root CHROOT_DIR         directory to chroot into
  -W, --warndays WARN_DAYS      set expiration warning days to WARN_DAYS


[root@centos ~]# grep pro /etc/group
systemd-bus-proxy:x:998:
project:x:1002:
[root@centos ~]# gpasswd -A student project
[root@centos ~]# su - student
Last login: Fri Dec 20 17:26:35 KST 2019 from localhost on pts/3
[student@centos ~]$ gpasswd -a user1 project
사용자 user1을(를) project 그룹에 등록 중

(멤버관리 가능해짐)
------------------------------------------------------
[root@centos ~]# useradd user2
[root@centos ~]# groups user2
user2 : user2
[root@centos ~]# groups user2
user2 : user2 project
[root@centos ~]# groups user2
user2 : user2
[root@centos ~]# 
-----------------------------------------------------
사용자 user2을(를) project 그룹에 등록 중
[student@centos ~]$ grep user /etc/gshadow
grep: /etc/gshadow: 허가 거부
[student@centos ~]$ sudo grep user /etc/gshadow
users:::
rpcuser:!::
newuser:!::
project:!:student:user1,user2
user1:!::
user2:!::
[student@centos ~]$ gpasswd -d user2 project
사용자 user2을(를) 그룹 project에서 제거하는 중
[student@centos ~]$ sudo grep user /etc/gshadow
users:::
rpcuser:!::
newuser:!::
project:!:student:user1
user1:!::
user2:!::
[student@centos ~]$ 
---------------------------------------------------------

[root@centos ~]# userdel -r user1 (user1 삭제)

---------------------------------------------------------

프로세스 ps 메모리에 동작하는 모든 프로세스 리스트 -ef

레귤러 파일 
스페셜 파일 - 디렉토리
하드웨어 일대일 매핑 - root밑에 B,C에존재하는 장치파일
시불린링 l타입
그외에 소켓파일 파이프 파일 등등

--------------------------------------------------------- 

[root@centos ch5]# cp /etc/hosts test.txt
[root@centos ch5]# ls -l
합계 4
-rw-r--r--. 1 root root 202 12월 23 15:31 test.txt
[root@centos ch5]# chmod u -w test.txt
chmod: cannot access `u': 그런 파일이나 디렉터리가 없습니다
[root@centos ch5]# chmod u-w test.txt
[root@centos ch5]# ls -l
합계 4
-r--r--r--. 1 root root 202 12월 23 15:31 test.txt
[root@centos ch5]# 

---------------------------------------------------------
