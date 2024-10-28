# java-racingcar-precourse
## 기능
- 사용자가 입력한 이름으로 여러대의 자동차 생성
- 각 자동차는 랜덤 값에 의해 멈추거나 전진
- 사용자가 입력한 경기 횟수로 진행
- 게임 결과 차수별 출력 기능
- 모든 경기 종료 후 우승자 출력 기능

## 예외사항
- 자동차 이름이 6글자 이상이면 예외
- 시도 횟수가 양수 숫자가 아닌 경우 예외

## 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.