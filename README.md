# 2030 부산 월드 엑스포 외국인 맛집 정보 제공 프로젝트 
 부산 외국인 관괭객을 위한 맛집 정보 제공 프로젝트 입니다

## 프로젝트 개요
2030 부산 엑스포 개최를 희망하며 , 부산을 방문하는 외국인 관광객들을 위한 맛집 정보를 제공 사이트 
한국어와 영어 2개 언어를 지원합니다

## 프로젝트 역할
- K-Digital 부산대학교 - 4회차] AI 활용 빅데이터분석 풀스택웹서비스 SW 개발자 양성과정     
- 3조 Seagull  
- [ ] FrontEnd : @JBK  
- [x] BackEnd : @MCJun  

## 프로젝트 진행 상황
 - [Team SeaGull](https://www.notion.so/2023-9a0cd2e5323d401cab9db29c49586519)

 - 2023-11-20 
   - 회원가입 기능 구현 
      - ResponseEntity , @RequestBody
---
### 실행환경
 - SpringBoot
 - Mysql

### 의존성
- JSON 데이터를 DB에 넣기 위한 JSONObejct 의존성 설정 추가
```
<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1.1</version>
</dependency>
```
- MySql 의존성 추가
```
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```