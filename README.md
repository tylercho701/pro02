# 프로젝트 개요

## 프로젝트명 : 다이소 쇼핑몰
## 프로젝트 기간 : 23.05.03 ~ 16
## 프로젝트 참여 : 조교행
## 자바 버전 : JDK 1.8
## 자바 스크립트 버전 : 1.0
## 다이나믹 랩 모듈 : 3.1
## DBMS : Oracle 11g xe
## 자바 라이브러리 : crypto, json, cos, commons, mail
## FrameWork : BootStrap 3.3.2
## 스크립트 플러그인 : jQuery 1 .12 .4
## 스크립트 api : daum 주소 api, json 데이터 처리, iamport 결제 api
## 프로젝트 데이터 처리 패턴 : MVC2 (View -> Controller -> Model -> Controller -> View)
## 프로젝트 주요 기능 : 공지사항 게시판 열람/게시/수정/삭제, 회원 로그인/가입/탈퇴
## 프로젝트 특이사항
  - 회원가입 간 아이디 중복 체크는 json을 통해 별도 팝업 없이 진행
  - 회원가입 간 주소 입력은 daum 주소 api를 통해 입력/전달
  - 회원의 비밀번호 암호화는 AES256으로 처리
  - 공지 사항에 파일 첨부 기능을 구현
  - 공지 사항 내 첨부된 파일은 공지사항 상세를 통해 다운로드 하도록 기능 구현
  - 결제 기능은 결제 api 기능으로 여러 결제 수단을 통한 결제 테스트가 가능
  - 배송 시스템의 배송 상태를 회원이 결제 후 '배송 전'으로, 관리자가 배송을 등록하면 '배송 중' 또는 '배송 완료'로 처리
  - 이용 후기는 댓글과 별점 등으로 구성하여 게시하도록 처리

# 개념적 설계
![유스케이스](/img/usecace.JPG "usecase")

# 논리적 설계
![논리적 설계 ERD](/img/relationchart1.JPG "relation1")

# 물리적 설계
![물리적 설계 ERD](/img/relationchart2.JPG "relation2")

# 클래스 설계
![클래스다이어그램](/img/classdiagram.JPG "classdiagram")

# 시퀀스 설계
![시퀀스1](/img/sequences/sequence1.JPG "sequence1")
![시퀀스2](/img/sequences/sequence2.JPG "sequence2")
![시퀀스3](/img/sequences/sequence3.JPG "sequence3")
![시퀀스4](/img/sequences/sequence4.JPG "sequence4")
![시퀀스5](/img/sequences/sequence5.JPG "sequence5")
![시퀀스6](/img/sequences/sequence6.JPG "sequence6")
![시퀀스7](/img/sequences/sequence7.JPG "sequence7")
![시퀀스8](/img/sequences/sequence8.JPG "sequence8")
![시퀀스9](/img/sequences/sequence9.JPG "sequence9")
![시퀀스10](/img/sequences/sequence10.JPG "sequence10")

# 프로젝트 구성
![구성도](/img/build.JPG "구성도")