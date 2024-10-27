# java-racingcar-precourse

## Model

### Car

- 레이싱에 참여하는 자동차와 관련된 역할을 담당하는 객체
- [x] 랜덤 값을 기준으로 자동차 전진 여부를 결정한다.
- [x] 자동차의 이름을 정한다.
- [x] 라운드 값을 입력받는다.

### Race

- 레이스를 진행하는데 필요한 역할을 맡는 객체
- [x] 레이스에 참가할 자동차를 생성
- [x] 라운드를 진행한다.
- [x] 우승자를 결정한다.

## View

### InputView

- 값을 입력받는 역할을 담당하는 객체
- [x] 경주할 자동차 이름을 주어진 형식에 맞게 입력받는다.
- [x] 라운드 시도 횟수를 주어진 형식에 맞게 입력받는다.

### OutputView

- 값을 출력하는 역할을 담당하는 객체
- [x] 각 라운드 마다 실행 결과를 주어진 형식에 맞게 출력한다.
- [x] 우승자를 주어진 형식에 맞게 출력한다.

## Controller

### Controller

- 주어진 기능을 수행하는 역할을 담당하는 객체

## Exception

### Race

- CarName을 Argument로 받을 때 발생할 수 있는 예외상황
- [x] 같은 이름의 Car가 존재할 때
- [x] 이름 없는 Car가 존재할 때
- [x] ','(구분자) 기호를 연속해서 사용한 경우 (""을 입력한 것으로 판단)
- [x] 이름이 5자 초과인 경우
- round를 Argument로 받을 때 발생할 수 있는 예외 상황
- [x] 인자가 정수가 아닐 때
- [x] 아무 입력도 없을 때
- [x] 0 이 주어졌을 때
- [x] 음수가 주어졌을 때
