# java-racingcar-precourse

## 구현할 기능 목록

첫 번째 메시지를 시작으로 객체들의 책임을 분배한다.

👀 : 스스로 판단하여 구현한 부분을 이모지로 표시한다.

### 메시지

- 자동차 경주를 시작하라

### 객체

**Racing**

- [x]  자동차 경주를 시작한다.
- [x]  라운드를 진행한다.

**Car**

- [x]  자동차를 생성한다.
    - [x]  자동차 이름이 5자 이하인지 확인한다.
    - [x]  공백이 포함되어 있는지 확인한다. 👀
- [x]  자동차의 전진을 시도한다.
    - [x]  무작위 값이 4 이상일 경우 전진한다.
    - [x]  무작위 값이 3 이하일 경우 정지한다.

**Race**

- [x]  모든 자동차를 생성한다.
    - [x]  자동차 이름을 쉼표(,)를 기준으로 구분한다.
    - [x]  자동차 이름에 중복이 있는지 확인한다. 👀
- [x]  모든 자동차의 전진을 시도한다.
- [x]  우승자를 판별한다.

**Input**

- [x]  자동차 이름을 입력받는다.
- [x]  시도할 횟수를 입력받는다.

**Rounds**

- [x]  반복할 라운드를 생성한다.
    - [x]  숫자인지 확인하고 변환한다. 👀
    - [x]  양수인지 확인한다. 👀
- [x]  라운드를 반복한다.

**Output**

- [x]  차수별 실행 결과를 출력한다.
- [x]  우승자 안내 문구를 출력한다.
