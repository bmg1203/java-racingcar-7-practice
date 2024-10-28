# java-racingcar-precourse

# 자동차 경주

## 목표

- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- 1주 차 공통 피드백을 최대한 반영한다.

## 기능 요구 사항 

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 기능 목록

1. **자동차 이름 입력 및 검증**
    - 쉼표(`,`)를 기준으로 자동차 이름을 분리한다.
    - 각 이름이 5자 이하인지 검증하고, 조건에 맞지 않으면 `IllegalArgumentException`을 발생시킨다.

2. **이동 횟수 입력 및 검증**
    - 사용자가 시도할 이동 횟수를 입력받고, 입력값이 양의 정수인지 검증한다.
    - 조건에 맞지 않는 경우 `IllegalArgumentException`을 발생시킨다.

3. **자동차 객체 생성**
    - 입력받은 이름으로 자동차 객체를 생성한다.
    - 각 자동차 객체는 자신의 이름과 위치를 관리할 수 있어야 한다.

4. **자동차 전진 조건 구현**
    - `Randoms.pickNumberInRange(0, 9)`를 사용하여 0에서 9까지의 무작위 값을 생성한다.
    - 값이 4 이상일 경우 자동차가 전진하고, 그렇지 않으면 멈춘다.

5. **자동차 경주 진행**
    - 사용자가 입력한 횟수만큼 경주를 반복한다.
    - 각 회차에서 모든 자동차의 전진 여부를 결정하고, 결과를 출력한다.

6. **경주 결과 출력**
    - 각 자동차의 이름과 위치를 출력 형식에 맞춰 보여준다.
    - 각 회차가 종료될 때마다 자동차의 진행 상황을 출력한다.

7. **우승자 결정 및 출력**
    - 경주가 종료된 후 가장 멀리 이동한 자동차를 우승자로 결정한다.
    - 우승자가 여러 명일 경우, 쉼표(`,`)로 구분하여 출력한다.

8. **예외 처리**
    - 잘못된 입력이 발생할 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
