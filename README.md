# java-racingcar-precourse

## 구현할 기능 목록

1. 경주할 자동차 이름 입력 값 받기
    - `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` 라는 메세지를 출력하여 문자열을 입력 받는다.
        - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
    - 중복된 자동차 이름이 존재할 경우, `IllegalArgumentException`을 발생시킨다.
        - 예시: `pobi,pobi,woni`
    - 자동차 이름이 빈 값일 경우, `IllegalArgumentException`을 발생시킨다.
        - 예시: `pobi,,woni`
    - 자동차 이름이 5자를 초과할 경우, `IllegalArgumentException`을 발생시킨다.
        - 예시: `pobipobi,woni,jun`
    - 경주에 참여하는 차량이 한대 이하일 경우 `IllegalArgumentException`을 발생시킨다.
        - 예시: `pobi`
2. 자동차가 몇 번 이동할 지 입력 값 받기
    - `시도할 횟수는 몇 회인가요?` 라는 메세지를 출력하여 문자열을 입력 받는다.
        - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
    - 시도 할 횟수는 `int` 타입으로 입력 받는다.
    - 시도 할 횟수가 자연수가 아닐 경우, `IllegalArgumentException`을 발생시킨다.
        - 예시: `-1`, `0`, `1.2`, `a`
3. 자동차가 전진하는 조건 판단하기
    - `0 ~ 9` 사이에서 무작위 값을 구한다.
        - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 위에서 구한 무작위 값이 `4` 이상일 경우에만 전진한다.
    - 차수별 실행 결과를 출력한다.
        - 출력은 입력한 자동차 순서대로 한다.
        - 예시:

```
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
```

4. 자동차 경주 우승자 출력하기
    - 우승자는 한명 또는 여러명일 수 있다.
    - 우승자가 여러명일 경우 `쉼표(,)`로 구분한다.
        - 단독 우승자 안내 문구
            - 예시: `최종 우승자 : pobi`
        - 공동 우승자 안내 문구
            - 예시: `최종 우승자 : pobi, jun`

---

## 실행 결과

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

## 프로젝트 구조

```
├── main
│   └── java
│       └── racingcar
│           ├── Application.java
│           ├── common
│           │   ├── CarParser.java
│           │   ├── InputSplitter.java
│           │   └── RandomNumber.java
│           ├── controller
│           │   └── RacingCarController.java
│           ├── domain
│           │   ├── Car.java
│           │   ├── CarName.java
│           │   ├── RacingGame.java
│           │   └── RacingGameRound.java
│           ├── dto
│           │   ├── RacingCarRequestDto.java
│           │   └── RacingCarResponseDto.java
│           ├── exception
│           │   ├── RacingCarException.java
│           │   └── constants
│           │       └── ErrorMessage.java
│           ├── service
│           │   └── RacingCarService.java
│           └── view
│               ├── InputView.java
│               ├── OutputView.java
│               └── constants
│                   └── ViewMessage.java
└── test
    └── java
        └── racingcar
            ├── ApplicationTest.java
            ├── common
            │   ├── CarParserTest.java
            │   ├── InputSplitterTest.java
            │   └── RandomNumberTest.java
            ├── domain
            │   ├── CarNameTest.java
            │   ├── CarTest.java
            │   ├── RacingGameRoundTest.java
            │   └── RacingGameTest.java
            └── service
                └── RacingCarServiceTest.java
```

---

## 테스트 커버리지

![test_coverage.png](docs/test_coverage.png)