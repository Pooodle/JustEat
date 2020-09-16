# JustEat
jsp web_food orders

> ### 개발 보고서
> https://drive.google.com/drive/folders/1nzLNIKGGZ9RVT6pon-e8iJqRp6TzEmY4?usp=sharing

## <환경 및 설정>
+ jdk13 
+ apache tomcat9
+ context path 수정 ( 변경 전: /root , 변경 후: / )
+ src/com/persistence/DBQuery.java 의 public final static String ConnectionUrl 경로 수정
<pre><code>
public final static String ConnectionUrl = "jdbc:sqlite:경로\\JE_DB.db";
</code></pre>
