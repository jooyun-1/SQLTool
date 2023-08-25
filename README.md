# 💾 SQLTool 
SQL Developer, Dbeaver와 같은 기능을 가진 SQLTool 구현


## 🖊 요구사항 분석


### 📝 Usecase Diagram
-----------------------------

![Untitled](https://github.com/jooyun-1/SQLTool/assets/71087271/486d3c59-1a24-4dff-a671-2891671daef3)

- 사용할 Database 관리 필요
- 제공된 Database에 따른 알맞은 접속과 종료
    
    (단, 접속 시 별도의 세션 부여, 차단 IP일 경우는 접속 차단)
    
- 연결한 Database에서 입력한 쿼리 수행 기능 구현
- DB 정보, 접속 로그, 쿼리 수행 로그, 차단 정보 기록


### 📃 API 명세서

-----------------------------
![Untitled (1)](https://github.com/jooyun-1/SQLTool/assets/71087271/abb261df-a979-4421-929e-4d8b20444075)
![Untitled (3)](https://github.com/jooyun-1/SQLTool/assets/71087271/e174e2b2-9fba-412c-b41c-5b35638834a9)


### 📊 Flow Chart

-----------------------------------------
![Untitled (2)](https://github.com/jooyun-1/SQLTool/assets/71087271/680d4d76-8f6e-4307-8cc4-20671c026482)


## 💻 구현

--------------------------------------------------------------

### 📕 기술 스택

--------------------------------------------------------------

- Spring Boot
- Java
- MySQL
- JWT


### 💡 기능

-------------------------------------------------------------


- **IP 차단**
    
    로컬에서 테스트하기위해 Request의 헤더를 이용해 로컬 IP를 차단하여 테스트
    

- **jwt**
    
    DB 접속마다 세션을 부여하여 별도의 id를 주기 위해 jwt 토큰을 사용
    
    (단순히 세션으로 처리한다면 같은 DB 접속은 추가로 접속해도 id가 추가로 안 주어지는 현상을 해결해주기 위함)
    
- **Postman**
    
    API가 올바르게 구현되었나 테스트하기 위해 Postman 활용
    
- **JDBC**
    
    쿼리 기능을 구현할 때, 입력된 쿼리를 구별하여 구현하기 위해 raw쿼리를 받아 처리할 수 있는 JDBC 사용
