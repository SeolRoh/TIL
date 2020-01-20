### Elastic Beanstalk 사용 시작(Flatform은 도커로)

> Elastic Beanstalk 사용 시작(Flatform은 도커로) -3
>
> https://docs.aws.amazon.com/ko_kr/elasticbeanstalk/latest/dg/GettingStarted.CreateApp.html

1. 예제 애플리케이션 생성

   [웹 앱 생성]: https://ap-northeast-2.console.aws.amazon.com/elasticbeanstalk/home?region=ap-northeast-2#/gettingStarted?applicationName=getting-started-app

   ---

   

   ![1](https://user-images.githubusercontent.com/34231229/72704073-06e71a80-3b9b-11ea-9056-e7b870f51368.JPG)

   플랫폼을 도커 후 생성 버튼 누르기

   ---

   생성중 

   ![2](https://user-images.githubusercontent.com/34231229/72704127-27af7000-3b9b-11ea-9831-d20af4791ddd.JPG)

   ---

   

2. Elastic Beanstalk 콘솔 창을 이용해 대시보드 확인

   ![3](https://user-images.githubusercontent.com/34231229/72704184-5f1e1c80-3b9b-11ea-8f15-8d8da2affed0.JPG)

   

   해당 애플리케이션 클릭

   ![4](https://user-images.githubusercontent.com/34231229/72704248-8d9bf780-3b9b-11ea-880f-5ad2a63cfbca.JPG)

   ---

   

3. 새 버전 애플리케이션 배포

    주기적으로 새 버전의 애플리케이션을 배포해야 할 경우가 있다. 환경에서 다른 업데이트 작업이 진행 중이지 않은 경우에 버전을 배포할 수 있다.

   버전 업데이트 하는 방법

   1. 환경 플랫폼과 일치하는 샘플 애플리케이션을 다운로드

      **단일 컨테이너 Docker** – [docker-singlecontainer-v1.zip](https://docs.aws.amazon.com/ko_kr/elasticbeanstalk/latest/dg/samples/docker-singlecontainer-v1.zip)

   2. Elastic Beanstalk 콘솔창 오픈

   3. 해당 애플리케이션 클릭

   4. upload and deploy 버튼 클릭 후 브라우즈 버튼을 통해 1번에서 다운받은 zip파일을 올린다.

      ![5](https://user-images.githubusercontent.com/34231229/72704410-1b77e280-3b9c-11ea-8fda-90997e058810.JPG)

      

   ---

   

4. 구성(로드 밸런싱-환경의 용량 설정 편집-Auto Scaling 그룹에 최소 2 최대 4개 설정)

   후에 인스턴스 두개 확인

   1. 콘솔창 열기

   2.  구성 탭에서 용량 탭의 수정

      ![6](https://user-images.githubusercontent.com/34231229/72704503-5548e900-3b9c-11ea-8a28-a9a00850dafb.JPG)

      

      3. 원하는 구성대로 auto-scailing 한다.

         ![7](https://user-images.githubusercontent.com/34231229/72704577-81fd0080-3b9c-11ea-9a98-4de8737cf5e9.JPG)

         4. 상태 탭 접근 -> 해당 인스턴스가 두개로 늘어난 것을 확인

            ![8](https://user-images.githubusercontent.com/34231229/72704615-a3f68300-3b9c-11ea-8b61-6ee7a2eaea2d.JPG)

            

