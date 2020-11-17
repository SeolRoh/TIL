AES256  암호화시 중요 체크 포인트 (양방향 암호화에 해당 / Bcrypt는 단방향)

1. 암호화에 사용되는 키
2. 암호화에 사용되는 주요키 말고 IV(Initial Vector)라는 키가 존재한다.
   + 초기 블록 유추 어렵도록 key이외에 IV사용
3. ChainingMode의 종류가 ECB,CBC,GCM 등 여러개가 있으나 나는 CBC사용예정
   + ECB보다 CBC를 이미지 암호화시 암호 처리 정도가 높은 보안성을 가지고있다.
   + 단 CBC는 Padding 필수 / 70년대 말에 개발되어서 병렬처리불가 + 멀티프로세서 장점 못살림
   + 제일 좋은건 GCM이나 이에 대한 레퍼런스가 부족한 편





C#에서는 ChainingMode를 `CipherMode.CBC`라 한다.

​	.NET에서는 CBC사용가능 / VB에서는 XX

​	CBC(Cipher Block chaining)

C#의 PaddingMode는 `PKCS7` 이며 Java는  PKCS5라고 한다.

​	서로 호환이 되고 동일한 결과가 나온다는 사람이 있다.

```
public static string Decrypt(string text)
        {
            var sessionKey = AppSettings.SessionKey + "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";

            var str = FromHexToByteArray(sessionKey);
            var iv = Convert.FromBase64String(AppSettings.HandleBase64);
           
            var estring = Encoding.UTF8.GetString(iv);

            AesManaged AesEncryption = new AesManaged();
            AesEncryption.Mode = CipherMode.CBC;
            AesEncryption.Padding = PaddingMode.PKCS7;
            AesEncryption.Key = str;
            AesEncryption.IV = iv;
            ICryptoTransform decryptor = AesEncryption.CreateDecryptor();
            var encrypted = Convert.FromBase64String(text);
            var dataString = Encoding.UTF8.GetString(decryptor.TransformFinalBlock(encrypted, 0, encrypted.Length));

            return dataString;
        }
```





참고블로그

 https://bigenergy.tistory.com/687

 https://www.slideshare.net/ssuser800974/ss-76664853
