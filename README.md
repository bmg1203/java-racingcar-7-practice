# java-racingcar-precourse

## 자동차 경주 게임

### 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 구현할 기능 목록

- [x] 5자 이하의 자동차 이름 입력 받기 기능(이름 입력 시 공백 있을 경우 불필요하다고 생각되어 제거할 수 있도록 구현,
  이유는 공백까지 닉네임이라고 생각하여 이름을 짓는 경우 없다고 판단하였기 때문)
- [x] 자동차 이동 횟수 입력 받기 기능(숫자 외 입력될 경우 임의로 Exception 발생하도록 구현)
- [x] 5자 이하의 자동차 이름 입력에 기반한 자동차 생성 기능(Car 클래스를 만들어 Car의 객체를 생성)
- [x] 무작위 값이 4 이상일 경우 자동차 전진 기능(전진 기능은 자동차 자체의 기능으로 구현,
  Car 클래스가 가진 메서드로 충분하다고 판단)
- [ ] 쉼표로 구분한 1명 이상의 자동차 경주 게임 완료 시 우승자 출력 기능
- [x] 잘못된 입력 시 IllegalArgumentException 발생 후 애플리케이션 종료(기본적으로 입력이 없거나
  5글자 이상의 이름을 입력할 경우 예외 처리)


