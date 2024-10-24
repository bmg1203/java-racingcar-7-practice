# java-racingcar-precourse

<br>

# 🚗 기능 명세

---
- [ ] 경주할 자동차 이름 입력 안내 출력 
      <br>:`경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
  - [ ]  자동차 목록 입력 받기
      - [ ]  자동차 이름은 쉼표(,)를 기준으로 구분
      - [x]  [예외] input 길이가 5 초과인 경우
      - [x]  [예외] 이름이 중복될 경우
      - [x]  [예외] 자동차가 2개 이하일 경우
      - [x]  [예외] 빈 문자열일 경우
      - [ ]  [예외] `,` 사용이 올바르지 않을 경우
- [ ]  시도 횟수 입력 안내 출력
      <br>`시도할 회수는 몇회인가요?`
- [ ]  레이싱 시도 횟수 입력 받기
    - [ ]  [예외] input 속 문자 중 숫자가 아닌 경우
    - [ ]  [예외] 빈 문자열일 경우
    - [x]  [예외] 음수일 경우
- [ ]  자동차 경주 시작 전 `실행 결과` 출력

<br>

- [ ]  매 시도마다 레이싱 시도 횟수만큼 반복
    - [x]  자동차 전진
        - [x]  0에서 9 사이에서 random 값 생성
        - [x]  random 값이 4 이상일 경우 전진
    - [ ]  차수별 실행 결과 출력
- [x]  우승자 선별 : 가장 많은 거리를 이동한 자동차(들)

<br>

- [ ]  우승자 안내 문구 출력
    - [ ]  단독 우승자
    - [ ]  공동 우승자 (”,” 로 구분)