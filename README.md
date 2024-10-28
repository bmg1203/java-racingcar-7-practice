# java-racingcar-precourse

## 프로젝트 설명
간단한 자동차 경주 게임. 각 자동차는 랜덤한 수 만큼 전진하고, 가장 많이 전진한 자동차가 우승한다.

## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 추가 요구사항

### 1. 자동차 이름 입력 및 처리
- 사용자는 자동차 이름을 쉼표(",")로 구분하여 입력한다.
- 최소 두 명 이상의 참가자가 있어야 하고, 입력 문자열에는 반드시 쉼표 구분자가 포함되어야 한다.
- 각 이름은 5자 이하만 가능하다. 5자 초과 시 예외 처리가 된다.
- 빈 이름은 허용하지 않는다. 이름을 입력하지 않았거나 공백으로만 구성된 경우 예외 처리된다.
- 중복된 이름이 있는 경우 예외 처리한다.

### 2. 이동 횟수 입력 및 처리
- 사용자는 자동차가 이동할 횟수를 입력한다.
- 입력 값이 숫자가 아닌 경우 예외 처리한다.
- 입력 값이 0이거나 음수일 경우에도 예외 처리한다.

### 3. 경주 게임 진행
- 게임 진행 중 각 자동차의 누적 점수를 저장한다.
- 이동 횟수에 따라 자동차가 이동한 횟수만큼 "-"를 출력하여 경주 진행을 시각화한다.

### 4. 우승자 판별
- 게임 종료 후의 최종 점수를 비교하여 가장 멀리 이동한 자동차가 우승한다.
- 동점자 처리 : 최고점이 같은 경우, 동점자 모두를 우승자로 표시한다.


## 예외 사항
- 자동차 이름이 5자를 초과하는 경우
- 빈 이름이 입력된 경우
- 참가자가 2명 미만인 경우
- 이동 횟수가 숫자가 아닌 경우
- 이동 횟수가 0이거나 음수인 경우
- 자동차 이름이 중복되는 경우
