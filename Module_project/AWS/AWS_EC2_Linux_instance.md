##  AWS EC2 Linux 인스턴스 시작하기

> Amazon EC2 Linux 인스턴스 시작하기 - 1
> https://docs.aws.amazon.com/ko_kr/AWSEC2/latest/UserGuide/EC2_GetStarted.html

1단계: 인스턴스 시작

1. 콘솔 대시보드에서 인스턴스 시작 선택

   ![1](https://user-images.githubusercontent.com/34231229/72694509-8c0d0800-3b78-11ea-90bd-0052ce73c14d.JPG)

2. Amazon Machine Image(AMI) 선택 페이지에서 AMI사용하기

   ![2](https://user-images.githubusercontent.com/34231229/72694648-0a69aa00-3b79-11ea-8d68-2eb5d13f7adc.JPG)

3. 인스턴스 유형 선택 페이지 - 하드웨어 구성 선택 가능, 프리티어인 `t2.micro` 택 후 `검토후 시작`

   ![3](https://user-images.githubusercontent.com/34231229/72694701-4a309180-3b79-11ea-8a4f-f90ccc464054.JPG)

4. 인스턴스 시작 검토 페이지 내의 보안 그룹에서 보안그룹 설정

   ![4](https://user-images.githubusercontent.com/34231229/72694802-9da2df80-3b79-11ea-83ed-a8972a818163.JPG)

5. 보안 그룹 구성 페이지에서 기존 보안 그룹 선택을 하고 그 내에 원하는 보안 그룹을 클리그후 검토후 시작을 클릭

   ![5](https://user-images.githubusercontent.com/34231229/72694895-f1152d80-3b79-11ea-89ef-57076090b4b4.JPG)

6.  시작버튼 클릭

   ![6](https://user-images.githubusercontent.com/34231229/72694919-0c803880-3b7a-11ea-9e7b-481d2b4b3ec1.JPG)

7. 키 페어 메세지 : 기존 키 선택 | 새 키 페어 생성 (키페어 없이 생성한다면 인스턴스에 연결이 어렵다.) -> 인스턴스 시작 버튼 클릭

   ![7](https://user-images.githubusercontent.com/34231229/72695013-67199480-3b7a-11ea-83bc-d1e188668345.JPG)

8. 인스터스 보기 클릭

   ![8](https://user-images.githubusercontent.com/34231229/72695090-b4960180-3b7a-11ea-9eff-8dee17da6184.JPG)

   ![9](https://user-images.githubusercontent.com/34231229/72695189-03439b80-3b7b-11ea-9e1e-93cf317af200.JPG)

2단계: 인스턴스에 연결

 방법 1) 해당 인스턴스 클릭후 마우스 우클릭 할 시 연결 버튼 -> EC2 인스턴스 연결(브라우저 기반 SSH연결)

사용자 이름, 실행에 사용한 AMI의 사용자 이름을 기본값으로 사용해 연결

![10](https://user-images.githubusercontent.com/34231229/72698676-89b2aa00-3b88-11ea-8e79-00caea35f6b4.JPG)



 방법 2) 독립 실행형 SSH클라이언트 - PUTTY.exe 기반

> 1. SSH 클라이언트를 연다. (PUTTY 사용)
>
> 2. 프라이빗 키 파일(.pem) 사용
>
> 3. SSH가 작동하려면 키가 공개적으로 표시되지 않아야한다.
>
>     필요한 경우 `chmod 400 rs_aws_0120.pem`
>
> 4. 퍼블릭 DNS를 사용해 인스턴스 연결
>
>    예시
>
>    ```
>    ec2-15-165-113-252.ap-northeast-2.compute.amazonaws.com 인 경우
>    ssh -i "aws_b_2.pem" ec2-user@ec2-15-165-113-252.ap-northeast-2.compute.amazonaws.com
>    ```