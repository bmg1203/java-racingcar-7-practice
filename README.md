# java-racingcar-precourse

## 기능
- 시도 횟수 입력
  - [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
  - [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 자동차 생성
  - [x] 각 자동차에 이름을 부여할 수 있다. 
  - [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 이동 규칙
  - [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  - [x] 매 라운드마다 각 자동차의 이동거리를 출력한다.
  - [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 결과 출력
  - [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. 
  - [ ] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 예외 처리
  - [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.