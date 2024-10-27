# java-racingcar-precourse

## 기능 요구사항

- [ ] 경주할 자동차 이름을 사용자에게 입력으로 받는다.
  - [ ] 자동차 이름은 쉼표로 구분한다.
  - [ ] 자동차 이름은 1글자 이상 5글자 이하만 가능하다.
  - [ ] 중복된 자동차 이름은 사용할 수 없다.
  - 가능한 예시 : 
    - "pobi,woni,jun"
  - 불가능한 예시 :
    - "pobi,carname"
    - "pobi,,"
    - "pobi, pobi"
- [ ] 자동차 경주를 시도할 횟수를 사용자에게 입력으로 받는다.

- 각 자동차는 횟수만큼 전진 또는 멈출 수 있다. 
    - [ ] 각 자동차 별로 0부터 9사이의 무작위 값을 구한다.
        - [ ] 무작위 값이 4이상이면 전진한다.
- [ ] 주어진 횟수만큼 반복한 이후 가장 멀리 간 사람이 우승자이다.
  - 우승자는 여러 명일 수 있다.

- [ ] 차수마다 차수별 실행 결과를 출력한다.
  - [ ] 자동차 이름과 차수별 실행 결과를 함께 출력한다.
  - 예시 :
    - pobi : ----
- [ ] 우승자의 자동차 이름을 출력한다.
  - [ ] 우승자가 여러 명일 경우 쉼표로 구분하여 우승자를 출력한다.
  - 예시 :
    - 최종우승자 : pobi, woni
    - 최종우승자 : pobi