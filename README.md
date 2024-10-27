# java-racingcar-precourse

### RaceController

애플리케이션의 전반적인 동작을 담당한다.

- [x] 입력에 따라 CarFactory가 Car을 생산하도록 한다.
- [x] 시도 횟수를 입력받고 경주를 운영하게 한다.

### InputView

콘솔을 이용해 사용자와의 상호작용을 담당한다.

- [x] 자동차 이름들을 입력받는다.
- [x] 시도 횟수를 입력받는다.

### Validator

입력에 대한 검증을 담당한다.

- [x] 자동차 이름: 쉼표(,)를 기준으로 구분하며 이름은 1자 이상, 5자 이하만 허용한다.
- [x] 시도 횟수: 양의 정수만 허용한다.
- [x] 중복된 차량 이름을 허용하지 않는다.

### OutputView

콘솔을 이용해 사용자와의 상호작용을 담당한다.

- [x] 시도마다 실행 결과를 출력한다.
- [x] 우승자 안내를 출력한다.

### CarFactory

자동차를 생산한다.

- [x] Car 객체를 생성한다.

### Car

자동차로써 기능한다.

- [x] 이름과 거리를 가진다.
- [x] 게임의 진행에 따라 전진한다.

### Race

경주를 운영한다.

- [x] Cars와 시도횟수를 가진다.
- [x] Random을 이용해 Cars를 전진시킨다.
- [x] 우승자들을 결정한다.
