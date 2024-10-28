# java-racingcar-precourse

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 구현 기능 - 서비스 객체
- [x] 입력 받은 문자열을 이름으로 나눈다.(OriginSeparator)
- [x] 무작위 값 생성 후 4이상 여부를 반환한다. (RandomNumberGenerator)
- [x] 값을 형식에 맞게 출력한다. (PrintRacingResult)
- [x] 문자열과 게임횟수를 입력받는다. (ConsoleReader)
- [x] 게임을 실행한다. (GameApplication)
  - [x] 게임 내의 레이싱을 실행한다. (RacingApplication)

### 구현 기능 - 도메인 객체
- [x] 한 대의 자동차 정보를 저장한다. (Car)
- [x] 레이싱을 하는 여러대의 자동차들을 저장한다. (Cars)
- [x] 레이싱 이후 자동차 정보를 관리한다. (Result)
- [x] 게임 진행 횟수를 저장한다. (GameNumber)

### 예외 상황
**IllegalArgumentException을 발생 시키는 상황**
* 입력 받은 문자열이 빈 문자열 일 경우
* 이름이 6자 이상일 경우
* 횟수를 입력하지 않은 경우(빈 문자열 일 경우)
* 횟수가 숫자의 형태가 아닐 경우
