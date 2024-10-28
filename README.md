# java-racingcar-precourse

## 💡 애플리케이션 설명

> ❓ 애플리케이션의 대략적인 설명입니다.
>

- 간단한 자동차 경주 게임 애플리케이션 입니다.

## 🛤️ 애플리케이션 플로우

> ❓ 애플리케이션의 대략적인 흐름을 정리합니다.
>

1. 자동차의 이름과 횟수를 입력받는다.
2. 주어진 횟수마다 자동차를 이동할지, 멈춰있을지 결정한다.
3. 횟수가 종료되면 자동차 게임이 종료된다.
4. 우승자를 출력한다.

## ⚙️ 필수 기능

> ❓ 프로젝트에 필요한 필수 기능 정리을 정리합니다.
>

- 핵심기능 1. 랜덤 숫자가 4 이상인 경우를 판단하는 기능
- 핵심기능 2. 우승자를 판단하는 기능
- 핵심기능 3. 자동차가 움직인 거리를 기록하는 기능

---

- 추가기능 1. 잘못된 값이 입력됐을 경우, 예외를 발생시키고 애플리케이션을 종료시키는 기능.
- 추가기능 2. 우승자가 한명 이상일 경우, 여러 우승자를 판단하는 기능

## ⚒️ 기능 분리

> ❓ 필수 기능을 객체에 분리합니다. 지속적으로 업데이트됩니다.
>

- `Car`
    - 자동차 하나를 담당하는 객체
    - 자동차를 이동시키는 역할
    - 랜덤숫자에 따라 이동할지 말지 결정
    - 현재 자동차의 상태 반환
    - 객체를 구분하는 기능
- `Cars`
    - 경주에 참가한 자동차들을 담당
    - 중복된 자동차가 있는지 확인
    - 경주 한 사이클 진행
    - 경주 전체 사이클 진행
    - 어떤 자동차가 우승했는지 결정함
    - 게임 결과를 저장
- `TryCount`
    - 시도 횟수 담당
    - 시도 횟수 검증
    - 시도 횟수 반환
- `CarName`
    - 자동차의 이름을 담당
    - 객체를 구분하는 기능
- `RacingConfig`
    - 레이싱 게임의 초기화 비지니스 수행
- `RacingGame`
    - 레이싱 게임 전체 비지니스 수행
    -

## 👉 입력

> ❓ 입력 예시입니다. 입력은 `camp.nextstep.edu.missionutils.Console.readLine()`을 사용합니다.
>

```bash
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5
```

## 👈 출력

> ❓ 출력 예시입니다.
>

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

최종 우승자 : pobi, jun
```

## ⛔ 예외 목록

> ❓ 프로그램의 예외 상황입니다. 프로그램이 예외일 경우, `IllegalArgumentException` 이 발생하고 종료됩니다. 사양에 따라 추가되거나 삭제될 수 있습니다.
>

- [x]  입력이 공백이거나 없는 경우. (View Level)
- [x]  시도할 횟수가 0회 이하인 경우.
- [x]  시도할 횟수가 숫자가 아닌 경우.
- [x]  자동차 이름이 0자 이하, 5차 초과인 경우 (Domain Level)
- [x]  중복된 자동차 이름이 있는 경우

## ⭕ 예외가 아닌 경우

> ❓예외가 아닌 경우를 정리합니다.
>

- 자동차 이름에 공백이 들어간 경우
- 공백을 제외했을 때, 같은 자동차가 있는 경우

## 📂 폴더 구성

> ❓ 폴더 및 파일 구성입니다.
>

```bash
└── src
    ├── main
    │   └── java
    │       └── racingcar
    │           ├── Application.java
    │           ├── constants
    │           │   ├── Constants.java
    │           │   ├── ErrorMessages.java
    │           │   └── OutputMessages.java
    │           ├── controller
    │           │   └── RacingController.java
    │           ├── model
    │           │   ├── Car.java
    │           │   ├── CarName.java
    │           │   ├── Cars.java
    │           │   └── TryCount.java
    │           ├── service
    │           │   ├── RacingConfig.java
    │           │   └── RacingGame.java
    │           ├── utils
    │           │   ├── RandomNumberGenerator.java
    │           │   └── StringSplitter.java
    │           └── view
    │               ├── InputView.java
    │               └── OutputView.java
    └── test
        └── java
            └── racingcar
                ├── ApplicationTest.java
                ├── MyApplicationTest.java
                ├── model
                │   ├── CarNameTest.java
                │   ├── CarTest.java
                │   ├── CarsTest.java
                │   └── TryCountTest.java
                └── utils
                    └── StringSplitterTest.java
```
