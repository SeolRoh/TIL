# 오픈스택으로 구현하는 클라우드 컴퓨팅

## 1. 오픈스택 개요

### 1.1 클라우드 컴퓨팅

> `#인터넷 기반` `#사용자의요청` `#IT리소스임대(시대)` `#On_demand방식`  `#종량과금제`
>
> `#Iaas` `#Paas` `#Saas`

+ Iaas 

  - IT관계자나 고급 end-user level, 3-tier 아키텍쳐 구현. 30%이나 감소하는 추세.

  + 통합 개발 환경, 스토리지, 네트워크, 다른 기본적인 컴퓨팅 자원들을 사용자에게 제공.

+ Paas 

  + 데이터베이스나 웹 서버, 윈도우의 Azure과 같이 Infra자체를 하나의 플랫폼으로 자동화한 서비스. 
  + 소비자는 주로 Application 개발자 층. 10%이나 증가하는 추세.

+ Saas 

  + 클라우드 환경에서 운영 중인 서비스 제공자의 애플리케이션을 사용자가 사용할 수 있는 클라우드 컴퓨팅 모델.
  + 주요 타겟층은 End-user. 60%.



### 1.2 오픈스택 소개

> 클라우드 컴퓨팅의 `Iaas`로서 클라우드 컴퓨팅환경에서 사용되는 무료 오픈소스 클라우드 소프트웨어.
>
> Public과 Private 클라우드를 구축하기 위한 오픈소스 플랫폼

+ Public : 데이타가 덜 민감한 서비스를 올린다.
+ Private : 제한적인 데이터, 특정 인가된 사용자만 Private 클라우드를 사용.
  + 예시) NHN사의 TOAST서비스. 오픈스택기반.

+ 오픈스택 구성도

  + **코어**서비스 (Havana, Icehouse 배포판에서 코어서비스가 완성)

  | 서비스            | 코드 이름 | 소개                                           |
  | ----------------- | --------- | ---------------------------------------------- |
  | 인증서비스        | Keystone  | 사용자관리                                     |
  | 컴퓨트서비스      | Nova      | 가상머신관리(VM, like as EC2 of AWS)           |
  | 이미지서비스      | Glance    | 커널이나 디스크 이미지와 같은 가상 이미지 관리 |
  | 대시보드          | Horizon   | 웹 브라우저를 이용해 GUI콘솔 제공              |
  | 오브젝트 스토리지 | Swift     | 클라우드 저장 스토리지 제공                    |
  | 블록 스토리지     | Cinder    | 가상머신을 위한 스토리지 제공                  |
  | 네트워크 서비스   | Neutron   | 가상 네트워크 관리 (퀀텀에서 뉴트론으로 변경)  |

  

### 1.3 오픈스택 릴리즈 별 서비스 종류

위키백과 - [Liberty 시리즈](https://wiki.openstack.org/wiki/ReleaseNotes/Liberty/ko) , 오픈스택 홈페이지 - [Rocky 시리즈](https://docs.openstack.org/install-guide/overview.html)

각 버젼마다 디테일한 부분은 있으나 관련 다운로드 overview는 Ocata버전을 참고하면된다.

[관련링크](https://docs.openstack.org/ocata/install/rdo-services.html)

### 1.4 로키(Rocky) version 사용

오픈소스 Infrastructer의 18번째 버전.