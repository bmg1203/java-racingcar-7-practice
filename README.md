# 자동차 경주 게임

## 요구사항 분석

초간단 자동차 경주 게임을 구현한다.

- n대의 자동차 이름을 입력 받는다.
    - 이때 자동차 이름은 쉼표(,)로 구분되어 입력된다.
    - 자동차의 이름은 최대 5글자이다.
- 사용자에게 몇 번의 게임을 할 지 수를 입력 받는다.
- 잘못된 값이 들어온 경우 IllegalArgumentException을 발생시키고 종료한다.
- 사용자가 입력한 수 만큼 게임을 반복 한다.
    - 각 게임마다 0~9사이의 랜덤한 숫자 값을 구해 4이상인 경우 전진, 그 외는 정지한다.
    - 게임 진행 상황을 출력한다. 자동차 이름과 옆에 ‘-’를 한칸의 전진으로 표시하는 그림을 출력한다.
- 가장 많이 전진한 자동차가 우승한다.
    - 이때 우승자는 여러 명일 수 있고, 여러 명이라면 쉼표(,) 를 기준으로 출력한다.

## FlowChart

![img.png](img.png)

## 구현해야 하는 기능

- [ ]  게임 실행 메시지를 출력하는 기능
- [ ]  레이싱카 이름을 입력하는 기능
- [ ]  사용자에게 시도하는 횟수를 입력받는 기능
- [ ]  랜덤한 숫자를 만들어내는 기능
- [ ]  시도하는 횟수만큼 경주 게임을 시작하는 기능
- [ ]  각 라운드마다의 결과를 출력하는 기능
- [ ]  우승자를 정하는 기능
- [ ]  우승자를 출력하는 기능

## 구현할 기능 MVC 설계

먼저 요구사항을 만족하는 소스코드를 작성한 뒤 이를 다시 MVC패턴으로 만들어보고자 한다

### Model

- 비즈니스 로직을 수행한다.
    - 사용자의 입력을 분리한다.
    - 자동차 위치를 저장하고 이동 시킨다.

RacingCar

- 레이싱 자동차 정보를 저장하는 기능을 담당

RacingCarManager

- 레이싱 자동차들 관리 기능을 담당

RacingCarNameInput

- 레이싱 자동차 이름 입력 기능을 담당

GameCoinInput

- 게임 시도 횟수 입력 기능을 담당

RandomNumberGenerator

- 랜덤한 수 생성 기능을 담당

WinnerFinder

- 우승자를 찾아내는 기능을 담당

### View

- 사용자에게 보여지는 입력 문구를 출력한다.
- 입력을 받는다.
- 사용자에게 보여지는 문구를 출력한다.

InputView

- 사용자의 입력을 담당

OutputView

- 사용자에게 출력을 담당

### Controller

- Model과 View 사이에서 데이터를 주고 받는다.
- 전체적인 게임의 흐름을 담당한다.

RacingGame

- 전체적인 게임의 관리와 흐름을 담당

## 1주차에 받은 피드백

1주차 미션을 끝내고 받은 피드백들을 정리하여 이번 미션에서 잘 활용하고 한다.

### 개인 피드백

* 수직 공백 줄이기
    * java code convention에서 여러 수직 공백을 허용하되, 지양한다는 말을 잘 준수하도록 할 것이다.
    * 가독성을 올리기 위해 기본으로 한 줄로 설정한다.

* 생성자 사용시 결합도 줄이기
    * new로 생성자를 만드는 과정에서 다른 객체와 결합도가 높다는 점의 피드백을 참고하여 결합도를 낮춰 구현 할 것이다.

* 목적이 뚜렷한 부분 메서드로 만들기
    * 메스드의 역할을 최대한 나눈 것 같았지만, 메서드 안에서도 하나의 기능이라고 볼 수 있는 부분을 최대한 메서화 시켜, 하나의 메서드의 역할을 분담한다.

### 공통 피드백

* Git으로 관리할 자원을 고려한다.
    * gitignore에 대해서 공부하고 적용한다.
* 커밋 메시지를 의미 있게 작성한다.
    * 1주차 미션에서 커밋 메시지를 의미있게 작성하려고 노력하였는데, 이번 미션에서 역시 더 의미 있는 커밋메시지를 작성하는데 노력한다.
* 오류를 찾을 때 출력 함수 대신 디버거를 사용한다.
    * 간단한 알고리즘 문제가 아닐때 디버거 사용에 익숙하지 않았는데, 이번 피드백을 통해 디버거에대해 공부해보도록 한다.
* 공백 라인을 의미 있게 사용한다.
    * 개인피드백에서도 받았듯이 매서드 간의 불필요한 연속적인 공백 라인을 줄여보도록 한다.
