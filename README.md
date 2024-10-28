# java-racingcar-precourse
# **자동차 경주**

## **과제 진행 요구 사항**

- 미션은 [자동차 경주](https://github.com/woowacourse-precourse/java-racingcar-7) 저장소를 포크하고 클론하는 것으로 시작한다.
- **기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리**해 추가한다.
- Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
    - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## **기능 요구 사항**

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### **입출력 요구 사항**

### **입력**

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun

```

- 시도할 횟수

```
5

```

### **출력**

- 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---

```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi

```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun

```

### **실행 결과 예시**

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni :
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun

```

---

# 구현할 기능 목록

### 기능

- [x]  사용자는 자동차 이름을 입력할 수 있다.
- [x]  쉼표를 구분자로 자동차를 구분하여 리스트로 반환한다.
- [x]  자동차들을 저장소에 저장할 수 있다.
- [x]  사용자는 몇 번의 이동을 할 것인지 입력할 수 있다.
- [x]  무작위 값의 결과에 따라 각 자동차는 전진 또는 멈출 수 있다.
   - [x]  각 자동차는 이동 횟수 한 번당 무작위 번호를 0~9까지 할당받는다.
- [x]  이동 횟수 한번마다 이동 결과를 저장할 수 있다.
- [x]  이동을 모두 마친 뒤 모든 자동차의 전진 또는 정지 결과를 이동 횟수만큼 출력한다.
- [x]  사용자가 입력한 횟수를 모두 이동하면, 가장 많이 전진한 자동차를 우승자로 선정한다.
- [x]  우승자를 출력할 수 있다.
   - [x]  우승자가 2 명 이상일 경우 쉼표를 이용하여 구분한 뒤 출력한다.

### 예외

- [X]  사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨다.
    - [x]  자동차 이름을 5자 이상 입력할 경우 예외 처리한다.
    - [x]  이동 횟수를 숫자가 아닌 문자를 입력할 경우
    - [x]  이동 횟수를 음수로 입력할 경우
    - [x]  사용자가 자동차의 이름으로 빈값을 입력할 경우
    - [x]  자동차 이름이 중복될 경우 예외를 발생시킨다.


### 테스트
- [x]  가장 많이 이동한 자동차를 우승자로 선별한다.
- [x]  우승자가 2명 이상일 경우도 있다.
- [x]  쉼표(,)를 구분자로 자동차 이름 문자열을 객체 리스트로 변환할 수 있다.
- [x]  CarRacer로 구성된 리스트를 한번에 저장할 수 있다.
- [x]  시도할 횟수를 숫자가 아닌 문자로 입력하였을 시 예외를 발생시킨다.
- [x]  시도할 횟수를 음수로 입력하였을 시 예외를 발생시킨다.
- [x]  자동차 이름이 비어있다면 예외를 발생시킨다.
- [x]  자동차 이름이 중복될 경우 예외를 발생시킨다.

## 패키지 구조

```mathematica
src
└── java
    └── racingcar
        ├── application
        │   ├── implement
        │   │   ├── MovementStrategy.java
        │   │   ├── CarRaceHistoryManager.java
        │   │   ├── CarRaceHistoryWriter.java
        │   │   ├── CarRaceStarter.java
        │   │   ├── CarRaceWinnerIdentifier.java
        │   │   ├── RaceHistoryManager.java
        │   │   ├── RaceStarter.java
        │   │   └── RaceWinnerIdentifier.java
        │   ├── service
        │   │   ├── RacingCarManager.java
        │   │   └── RacingManager.java
        │   ├── vo
        │   │   └── RaceResult.java
        │   ├── Game.java
        │   └── RacingCarGame.java
        ├── common
        │   ├── config
        │   │   └── GameConfig.java
        │   ├── constant
        │   │   ├── ConsoleMessage.java
        │   │   ├── ExceptionMessage.java
        │   │   ├── FormatConstants.java
        │   │   └── RacingCarConstant.java
        │   └── support
        │       ├── ObjectConverter.java
        │       ├── PositiveNumberParser.java
        │       ├── RacingCarComparator.java
        │       └── RacingCarConverter.java
        ├── domain
        │   ├── CarRacer.java
        │   └── Racer.java
        ├── persistence
        │   ├── CarRaceHistoryRepository.java
        │   ├── CarRacerRepository.java
        │   └── InMemoryCarRacerRepository.java
        ├── view
        │   ├── ApplicationConsoleView.java
        │   └── ApplicationView.java
        └── Application.java

```
