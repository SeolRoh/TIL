2020-08-12 Database 복습

---

SELECT문

```mssql
SELECT (열) AS [지정하고자하는 새 열 이름]

FROM dbName.tableName

WHERE (열)의 검색조건
WHERE HireDate <= '2013-01-01'
```



WHERE 검색 조건 종류

1. Between 열A and 열B

2. AND / OR / NOT

3. IS NULL (널값을 포함하여 연산) / IS NOT NULL (널값을 0값으로 대치)

   

LIKE 범위불러오기

```mysql
SELECT * FROM dbo.Employee
WHERE EmpName LIKE '%[_]%'
WHERE Phone LIKE '010-[1-3]%'
```



ORDER BY 구문

```mysql
SELECT * FROM DBO.Employee
ORDER BY (정렬할 열) ESC, (그다음 정렬할열) DESC
```



DISTINCT 중복제거  / SET ROWCOUNT n 행수를 제한

```mysql
SET ROWCOUNT 5
GO

SELECT DISTINCT 열 FROM dbName.tableName
GO
```



FORMAT 정수의 규격 변환

```mysql
SELECT EmpId, EmpName
, FORMAT(Salary, '#,###,##0.') AS [Salary] 
FROM dbo.employee
WHERE DeptId = 'SYS'
```



CONVERT 행 변환 

```mysql
SELECT EmpName + '(' + EmpId + ')'AS [EmpName]
, Gender, HireDate, Email
FROM dbo.employee
```



문자열 패턴비교

1. 문자개수 패턴비교 `____@` 앞의 네가지 글자만

2. 문자열 패턴비교 `LIKE`연산자 `%`
   + 김 시작 --> WHERE EMPNAME LIKE '김%'
   + 김 이들어간 -->WHERE ENPNAME LIKE  '%김%'





