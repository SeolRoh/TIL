20200526 11:20am with instructor, team A
	1.	어떤 서비스가 DB에서 정보를 가져오는 것을 처리할 지에 대한 여부=> Manager
		⁃	file manager 
			•	1번컬럼 설정
			•	2번컬럼 설정
		⁃	파일을 업로드하고 저장 후 이동
		⁃	비식별 manager
		⁃	출력 manager
	2.	컨테이너 별로 비식별 작업을 처리
		⁃	마스킹, 범주화, 가명화
	3.	출력형태: DB, File for download

상대회사(1조) 협업 파트
	⁃	DB port open
	⁃	사용자가 파일로 올리는 스타일. 최종 모습은 DB 결과 값은 API server내부에 Json으로 출력시키는 구조.
	⁃	KAFKA sever
	•	카프카 데이터를 전송=> 상대방이 받아 서비스.
	•	우리조(4조)에서 만들 예정.

현 문제
	⁃	해당 api에서는 검증과 비식별을 동시해 진행하므로 이부분에서는 서비스 분리가 어려움.
		=> 비식별manager 에서 검증 진행 ✔해결