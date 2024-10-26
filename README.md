# java-racingcar-precourse

## 기능 요구사항
1. 입력
- [X] 자동차 이름들을 입력받는다.
  - [X]  각 자동차들은 쉼표(,)를 기준으로 구분된다.
  - [X] 자동차 이름은 5자 이하만 가능하다.
    - [X] 자동차 이름이 5자를 초과한다면 IllegalArgumentException을 발생시킨다.
  - [X] 자동차 이름은 적어도 두개 입력받아야 한다.
    - [X] 자동차 이름을 두개 이상 입력하지 않았다면 IllegalArgumentException을 발생시킨다.
- [X] 몇 번의 이동을 할 것인지 입력받는다.
  - [X] 입력값은 양수이다.
    - [X] 양수가 아닌 값을 입력받았다면 IllgerArgumentException을 발생시킨다.

2. 무작위 값 생성
- [X] 0 ~ 9 사이의 무작위 값을 생성한다.

3. 경주
- [ ] 각 자동차들은 이동 턴마다 무작위 값 계산 결과가 4 이상일 경우 전진한다.
- [ ] 이동을 시도 할 횟수를 다 소모하면 게임이 종료된다.
- [ ] 가장 많이 전진한 자동차가 우승자이다.
  - [ ] 우승자는 여러명 일 수 있다.

4. 출력
- [X] 프로그램 시작 시 "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 메시지를 출력한다.
- [X] 자동차 이름들을 입력받은 후 "시도할 횟수는 몇 회인가요?" 메시지를 출력한다.
- [ ] 이동 턴마다 현재 각 차들의 진행결과를 출력한다 (예시: gyeom : ---)
