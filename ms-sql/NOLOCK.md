NOLOCK (MS-SQL)

---

Select 시에 (NOLOCK) 처리시 잠금처리 하지 않고 바로 조회를 수행

MSSQL은 SELECT문이 수행되는 테이블에서 INSERT,UPDATE,DELETE 문이 수행되고 있다면 SELECT문은 선행 작업이 완료 될때까지 LOCK이 걸린다. 이때 SELECT문에 NOLOCK을 추가하면 선행작업의 결과와 관계없이 바로 SELECT문이 수행되어서 결과를 반환한다.

```mssql
SELECT * FROM TABLE1 WITH (NOLOCK)
```



즉 transaction이 수행되고 있다고 생각하면된다. transaction이 수행되고 있으면 Lock이 걸린다. 하지만 nolock설정시 transaction이 수행되고 있어도 select문이 수행되어 결과를 반환한다.