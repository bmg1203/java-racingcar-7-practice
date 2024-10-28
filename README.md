# java-racingcar-precourse

구현할 기능 : 초간단 자동차 경주 게임

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


Application.java
- 프로그램의 시작
- InputHandler를 호출해서 안내문을 출력하고, List<Car>, int값으로 변환된 입력값을 받음
- 변환받은 입력값을 RacingGame으로 넘김

InputHandler.java
- 값을 입력받고 변환하는 클래스
- 자동차 이름을 입력하라는 안내문구 출력
    - String을 입력받아서 List<Car>로 변환
- 게임 횟수를 입력하라는 안내문구 출력
    - String을 입력받아서 int로 변환

RacingGame.java
- 게임을 진행하는 클래스
- 입력된 게임 횟수만큼 무작위 값을 받아서 각 라운드 결과 결정
  - 각 라운드 결과를 ResultPrinter로 출력
- 모든 게임이 종료되었을 때 최종 승자(들)를 결정
  - 최종 승자를 ResultPrinter로 출력

ResultPrinter
- 결과를 출력하는 클래스
  - 각 라운드의 결과와 최종 승자(들)를 출력

Car.java
- 자동차 이름과 전진 횟수를 변수로 가진 클래스