# java-racingcar-precourse
## 미션 2주차 - 자동차 경주

## 학습 목표
- 함수가 하나의 기능만 하도록 분리
- 테스트 도구를 사용하여 프로그램이 제대로 작동되는지 확인 with JUnit, AssertJ
- 1주차 공통 피드백을 최대한 반영하기
- 기능 단위 별 커밋 남기기
- indent depth 가 3이 넘지 않도록 구현하기
- 3항 연산자 사용하지 않기

## 입출력 요구사항
### 입력
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```angular2html
pobi,woni,jun
```
- 시도할 횟수
```angular2html
5
```

### 출력
- 차수별 실행 결과
```angular2html
pobi : --
woni : ----
jun : ---
```
- 단독 우승자 안내 문구
```angular2html
최종 우승자 : pobi
```
- 공동 우승자 안내 문구
```angular2html
최종 우승자 : pobi, jun
```
### 실행 결과 예시
```angular2html
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

## 요구사항 정리(기능 목록)
- [ ] 사용자로부터 값 입력 받기
  - [ ] 경주할 자동차 이름을 입력받기
  - [ ] 시도할 횟수 입력 받기
- [ ] 전진하는 자동차 객체
  - [ ] 자동차의 이름 저장
  - [ ] 얼만큼 전진했는지 저장
  - [ ] 전진 여부를 결정하는 함수
- [ ] 자동차를 관리하는 객체
  - [ ] 자동차 이름을 받아서 자동차 객체에 넣기
- [ ] 사용자가 입력한 횟수만큼 자동차 게임 진행하기
  - [ ] 매 횟수마다 진행결과 출력
- [ ] 우승자를 결정하기
  - [ ] 우승자가 한 명인지, 여러 명인지 구분
  - [ ] 여러 명일 경우 쉼표(,)를 이용하여 구분
- [ ] 문자 출력하기
  - [ ] ```경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)``` 출력하기
  - [ ] ```시도할 횟수는 몇 회인가요?``` 출력하ㅣ
  - [ ] 매 횟수 진행한 실행결과 출력하기
  - [ ] 최종 우승자 출력하기
- [ ] 예외 처리
  - [ ] 경주할 자동차가 한 대 이하로 입력된 경우
  - [ ] 경주할 자동차의 이름이 공백으로 입력될 경우
  - [ ] 경주할 자동차 문자열이 아예 공백인 경우
  - [ ] 시도할 횟수를 입력받을 때 숫자가 아닐 경우
  - [ ] 시도학 횟수를 입력받을 때 값이 1 이하일 경우