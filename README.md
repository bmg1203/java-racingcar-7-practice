# java-racingcar-precourse

### 1) 프로그램 메시지 출력 기능

- [x] `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` 메시지를 출력
- [x] `시도할 회수는 몇회인가요?` 메시지 출력
- [x] `실행 결과` 메시지와 함께 경주 과정 출력
- [x] `최종 우승자 : ` 메시지와 함께 우승자 출력

### 2) 사용자 문자열 입력 및 검증 기능

- [x] 사용자 자동차 이름 입력
  - [x] 사용자가 입력한 문자열이 비어 있는지 검증
    - [x] 예외인 경우 IllegalArgumentException 발생
  - [x] 사용자가 입력한 문자열에 구분자(,)가 포함된 문자열인지 검증
    - [x] 예외인 경우 IllegalArgumentException 발생
- [x] 사용자 시도 횟수 입력
  - [x] 사용자가 입력한 문자열이 비어 있는지 검증
    - [x] 예외인 경우 IllegalArgumentException 발생
  - [x] 사용자가 입력한 문자열이 숫자인지 검증
    - [x] 예외인 경우 IllegalArgumentException 발생

### 3) 자동차 생성 및 검증 기능

- [x] 사용자가 입력한 자동차 이름 문자열을 구분자(,)를 사용하여 분리
  - [x] 자동차 이름 배열 생성
- [x] 자동차 이름을 바탕으로 자동차 생성
  - [x] 빈 문자열인지 검증
    - [x] 예외인 경우 IllegalArgumentException 발생
  - [x] 자동차 이름 길이 검증
    - [x] 예외인 경우 IllegalArgumentException 발생
- [x] 참가 자동차 리스트 생성
  - [x] 참가 자동차 이름 중복 검증
    - [x] 예외인 경우 IllegalArgumentException 발생

### 4) 참가 자동차 경주 기능

- [x] 참가 자동차 경주
    - [x] 무작위 숫자가 4이상인 경우 전진
- [x] 현재 위치 표시
  - [x] 자동차의 현재 위치를 `-`로 변환
- [x] 우승자 선정
  - [x] 참가 자동차들 중 가장 많이 전진한 자동차 선정
  - [x] 우승한 자동차들을 (,)로 분리
  
## 초기 구현 할 클래스 UML 설계

<p align="center">
  <img src="Initial Design UML.png" alt="Initial Design UML" width="300" height="400">
</p>

## 구현 완료된 클래스 UML

<p align="center">
  <img src="Implementation Complete UML.png" alt="Initial Design UML" width="400" height="600">
</p>