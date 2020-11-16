AES256  암호화시 중요 체크 포인트

1. 암호화에 사용되는 키
2. 암호화에 사용되는 주요키 말고 IV라는 키가 존재한다.
3. ChainingMode의 종류가 ECB,CBC,GCM 등 여러개가 있으나 나는 CBC사용예정





C#에서는 ChainingMode를 `CipherMode.CBC`라 한다.

​	.NET에서는 CBC사용가능 / VB에서는 XX

C#의 PaddingMode는 `PKCS7` 이며 Java는  PKCS5라고 한다.

​	서로 호환이 되고 동일한 결과가 나온다는 사람이 있다.





참고블로그 https://bigenergy.tistory.com/687