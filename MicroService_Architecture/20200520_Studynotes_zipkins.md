20200520 zipkins

---

https://zipkin.io/pages/quickstart.html install zipkins



```
C:\Users\HPE\work>java -jar zipkin-server-2.21.1-exec.jar

                  oo
                 oooo
                oooooo
               oooooooo
              oooooooooo
             oooooooooooo
           ooooooo  ooooooo
          oooooo     ooooooo
         oooooo       ooooooo
        oooooo   o  o   oooooo
       oooooo   oo  oo   oooooo
     ooooooo  oooo  oooo  ooooooo
    oooooo   ooooo  ooooo  ooooooo
   oooooo   oooooo  oooooo  ooooooo
  oooooooo      oo  oo      oooooooo
  ooooooooooooo oo  oo ooooooooooooo
      oooooooooooo  oooooooooooo
          oooooooo  oooooooo
              oooo  oooo

     ________ ____  _  _____ _   _
    |__  /_ _|  _ \| |/ /_ _| \ | |
      / / | || |_) | ' / | ||  \| |
     / /_ | ||  __/| . \ | || |\  |
    |____|___|_|   |_|\_\___|_| \_|

:: version 2.21.1 :: commit c30ffc5 ::

2020-05-20 10:16:40.788  INFO 11696 --- [           main] z.s.ZipkinServer                         : Starting ZipkinServer on DESKTOP-GG5C4KI with PID 11696 (C:\Users\HPE\work\zipkin-server-2.21.1-exec.jar started by HPE in C:\Users\HPE\work)
2020-05-20 10:16:40.794  INFO 11696 --- [           main] z.s.ZipkinServer                         : The following profiles are active: shared
2020-05-20 10:16:42.884  INFO 11696 --- [           main] c.l.a.c.u.SystemInfo                     : Hostname: desktop-gg5c4ki (from 'hostname' command)
2020-05-20 10:16:43.853  INFO 11696 --- [oss-http-*:9411] c.l.a.s.Server                           : Serving HTTP at /0:0:0:0:0:0:0:0:9411 - http://127.0.0.1:9411/
2020-05-20 10:16:43.857  INFO 11696 --- [           main] c.l.a.s.ArmeriaAutoConfiguration         : Armeria server started at ports: {/0:0:0:0:0:0:0:0:9411=ServerPort(/0:0:0:0:0:0:0:0:9411, [http])}
2020-05-20 10:16:43.905  INFO 11696 --- [           main] z.s.ZipkinServer                         : Started ZipkinServer in 4.748 seconds (JVM running for 6.734)

```



trace ID



span ID 



1. 검색창에 넣고 확인하기 => users-ws: get /useres/{userid}

2. log하고 after만 두가지 정보 출력하기