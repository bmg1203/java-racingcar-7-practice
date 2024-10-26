# java-racingcar-precourse

---

# 🚘 초간단 경주 게임

---

## 프로그래밍 요구 사항

---

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
- 3항 연산자를 쓰지 않는다
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.


## 기능 목록

---

- [ ] 자동차 이름을 생성한다.
  - 자동차 이름이 5자보다 크다면 IllegalArgumentException을 발생시킨다.
- [ ] 자동차를 생성한다.
  - 자동차는 이름과 거리를 가진다.
    - 거리의 기본값은 0이다.
- [ ] 자동차들을 생성한다.
  - 입력에서 쉼표(,)를 기준으로 자동차 이름을 구분하여 이름을 포함한 자동차를 만들 수 있다.
    - 문자열 입력을 받을 수 있다.
    - 쉼표(,)를 기준으로 자동차 이름을 만든다.
    - 이름의 갯수만큼 자동차를 만든다.
- [ ] 자동차는 전진하거나 멈출 수 있다.
    - 자동차는 자신의 이름을 출력할 수 있다.
    - 자동차는 자신이 이동한 거리를 출력할 수 있다.
    - 전진하는 조건은 무작위 값이 4 이상일 경우이다.
        - 0에서 9 사이에서 무작위 값을 구한다.
- [ ] 입력받은 횟수만큼 자동차는 움직일 수 있다.
  - 횟수를 입력받을 차례에 정수타입이 아니라면 IllegalArgumentException를 발생시킨다.
- [ ] 자동차가 이동한 거리를 바탕으로 어떤 자동차가 우승했는 지를 출력한다.
  - 더 많이 전진한 자동차가 우승한다.
  - 우승한 자동차는 2개 이상일 수 있다.
  - 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분한다.
