# 🚗 자동차 경주

우아한테크코스 프리코스 2주차 미션


## 📌 개요

경주할 자동차의 이름과 실행 횟수를 입력받고, 실행결과와 우승자를 출력한다


## 🎯 기능 요구사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 📋 기능 목록

- [x] 자동차 이름과 이동횟수를 입력받아 레이스를 만드는 기능
- [x] 무작위로 전진하는 기능
- [x] 각 자동차의 이동을 출력하는 기능
- [x] 최종 우승자를 출력하는 기능
- [x] 게임을 실행하는 기능
- [ ] 숫자를 판단하는 기능
- [ ] 4 이상인 숫자를 판단하는 기능


- 예외처리
  - [ ] 자동차 이름에 쉼표가 없는 경우
  - [ ] 자동차 이름이 5자를 넘어가는 경우
  - [ ] 시도할 횟수가 int 데이터의 범위를 넘는 경우
  - [ ] 시도할 횟수에 숫자가 아닌 값을 입력받은 경우
  - [ ] 시도할 횟수에 0이하의 숫자를 입력받은 경우