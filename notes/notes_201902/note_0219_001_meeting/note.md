# 進捗会議（@遺伝研)

## 議事録

- Spring Boot 2 + Spring Security 5 + bootstrap 3で実装することにした。
    - Web UI部分は以下の参考文献を元に作成した。[Pro Spring Boot 2 (Apress, 2018), Chapter 8. Security with Spring Boot](8.%C2%A0Security%20with%20Spring%20Boot%20-%20Pro%20Spring%20Boot%202_%20An%20Authoritative%20Guide%20to%20Building%20Microservices,%20Web%20and%20Enterprise%20Applications,%20and%20Best%20Practices.pdf)  
- 登録フォームと画面遷移を作成した。画面遷移ではなりすましに気をつける。
- まずはJDBCで認証するが、SAML, OAuth2認証に対応してSingle Sign Onを実現したい。googleアカウントでログインできると良い。
- one-jarですべて事が済みインストール、運用が楽になるように、DBMSはH2 Databaseで実装したい。
- 本人IDを内部に持つ。これは管理者だけが見えるようにする。ユーザーに対してはスパコンアカウントまたはメールアドレスがIDとなる。

## 現状のWeb UI

![](Screen%20Shot%202019-02-19%20at%2013.53.45.png)

![](Screen%20Shot%202019-02-19%20at%2013.53.56.png)

![](Screen%20Shot%202019-02-19%20at%2013.54.09.png)

![](Screen%20Shot%202019-02-19%20at%2013.54.36.png)

![](Screen%20Shot%202019-02-19%20at%2013.54.47.png)

