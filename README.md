# java-racingcar-precourse

## 📌 구현 기능 목록

### RacingCar

* [X]  자동차는 이름을 가진다.
* [X]  자동차는 전진 할 수 있다.

### Racing

* [X]  턴을 진행해 턴마다 결과를 낸다.
  * [X]  0-9 사이의 랜덤한 값을 생성해 4보다 큰 경우에만 자동차를 전진시킨다.
* [X]  자동차 게임을 완료한 후 누가 우승했는지 알려준다.
  * [X]  한 명 이상일 수 있다.(여러 명일 경우 쉼표를 통해 구분한다)

### RacingGameController

* [X]  입력과 출력 Racing을 사용해 RacingGame을 실행
* [X]  RacingGameFactory 클래스를 활용해 DI 문제 해결

### 예외 `IllegalArgumentException`

* [X]  자동차 이름 입력 검증
  * [X]  자동차의 이름은 5자 이하만 가능하다.
  * [X]  입력의 마지막은 콤마(,)로 끝날 수 없다.
  * [X]  이름에 빈 값은 입력할 수 없다.
  * [X]  입력에 공백이 포함될 수 없다.
  * [X]  자동차 이름은 중복될 수 없다.
* [X]  시도 횟수 입력 검증
  * [X]  빈 값은 입력할 수 없다.
  * [X]  양의 정수만 입력 가능하다.
    * [X]  음수는 불가능하다.
    * [X]  '0'으로 시작하는 수는 입력할 수 없다.

### 입력

* [X]  경주할 자동차 이름을 입력 받는다.
* [X]  시도할 횟수를 입력 받는다.

### 출력

* [X]  차수별 실행 결과를 출력한다.
* [X]  게임이 종료된 후 우승자를 안내 한다.
  * [X]  우승자가 여러 명일 경우, 쉼표(,)를 이용하여 구분한다.
