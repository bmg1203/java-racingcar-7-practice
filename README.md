# java-racingcar-precourse

## 입력 케이스

## 기능 목록

### 입력

- [x] 사용자 입력 받기
    - [x] n대의 자동차,자동차 이름으로 입력
    - [x] 쉼표를 통해 구분
    - [x] 시도 횟수(라운드 수) 입력

### 도메인

- [x] 자동차
    - [x] 전진
    - [x] 전진 조건 판단(랜덤 값 4 이상일 때 전진)
- [x] 값 생성
    - [x] 랜덤 값 생성
- [x] 참가자들
    - [x] 우승자 판단

### 컨트롤러

- [x] 라운드 진행

### 출력

- [x] 자동차 이름
- [x] 라운드 진행 후 위치 상태
- [x] 우승자 출력
    - [x] 2명이상일 시 ,를 기준으로 구분

### 예외 처리

- [x] 자동차 이름이 5자를 초과
- [x] 자동차 이름 중복
- [x] 시도횟수 1미만일 시
- [x] 마지막 자동차 이름 뒤에 ,가 올 시
- [x] 라운드 입력시 정수문자열이 아닌 경우
- [x] 자동차 이름이 공백문자열을 포함하거나 빈문자열이면 안됨
