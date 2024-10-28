# java-racingcar-precourse

## 🚗 자동차 경주 게임

---

## 📝 구현 기능 목록 (Features)

### 1. Model

- **Car 클래스**
    - 자동차의 이름과 위치를 저장합니다.
    - 이동 조건을 판단하여 전진 여부를 결정하는 `move(int randomValue)` 메서드를 포함합니다.
    - 주요 필드:
        - `name`: 자동차의 이름을 나타내는 필드입니다.
        - `position`: 자동차의 현재 위치를 나타내는 필드로, 초기값은 0입니다.

### 2. View

- **InputView 클래스**
    - 사용자에게 **자동차 이름**과 **시도 횟수**를 입력받아, 입력값을 반환합니다.
    - `InputCarNames()`: 자동차 이름을 입력받고, 유효성 검사를 수행합니다.
    - `InputRoundNumber()`: 시도 횟수를 입력받아 정수로 변환하고, 유효성 검사를 수행합니다.
- **OutputView 클래스**
    - **각 라운드별 진행 상황과 결과**를 출력합니다.
    - 최종 우승자를 출력합니다.
    - 주요 메서드:
        - `printRoundResults(List<Car> cars)`: 각 자동차의 현재 위치를 출력합니다.
        - `printWinners(List<String> winners)`: 최종 우승자를 쉼표로 구분하여 출력합니다.

### 3. Controller

- **GameController 클래스**
    - 게임의 전체 흐름을 관리하며, 사용자의 입력을 통해 자동차 경주를 진행합니다.
    - `InputView`에서 받은 입력을 바탕으로 `Car` 객체 리스트를 생성하고, 라운드를 반복하며 경주를 수행합니다.
    - 매 라운드 후 `OutputView`를 통해 경과를 출력하고, 게임 종료 후 최종 우승자를 출력합니다.
    - `InputView`에서 받은 입력값이 유효하지 않은 경우 `IllegalArgumentException`을 발생시키며, 예외 메시지를 출력한 뒤 프로그램을 종료합니다.

### 4. Service

- **RacingGameService 클래스**
    - 각 라운드마다 **자동차의 이동을 처리**합니다.
    - `runRound(List<Car> cars)`: 입력받은 자동차 리스트에서 각 자동차의 이동을 담당하며, 각 자동차가 이동 조건을 충족하는지 확인합니다.

- **CarSetupService 클래스**
    - 자동차의 초기 설정 및 유효성 검사를 담당합니다.
    - `setupCars(String carNamesInput)`: 입력된 자동차 이름 문자열을 받아서 `Car` 리스트를 생성합니다.
    - 내부적으로 `parseCarNames()`와 `validateCarNames()`를 사용하여 입력 검증과 `Car` 객체 생성을 관리합니다.

### 5. Result

- **ResultCalculator 클래스**
    - 게임 종료 후 최종 우승자를 계산하는 역할을 합니다.
    - `determineWinners(List<Car> cars)`: 가장 멀리 이동한 자동차를 우승자로 결정하고, 여러 우승자가 있을 경우 리스트로 반환합니다.

### 6. Util

- **Validator 클래스**
    - 유효성 검사 로직을 담당하는 유틸리티 클래스입니다.
    - 주요 메서드:
        - `checkCarNamesNotEmpty(String carNames)`: 자동차 이름이 빈 값인지 확인하고, 빈 값일 경우 예외를 발생시킵니다.
        - `checkCarNameLength(List<String> carNames)`: 자동차 이름이 5글자 이하인지 확인하며, 초과할 경우 예외를 발생시킵니다.
        - `checkCarNamesUnique(List<String> carNames)`: 자동차 이름이 중복되지 않았는지 확인하고, 중복된 경우 예외를 발생시킵니다.
        - `parseRoundCount(String roundCountInput)`: 문자열로 입력된 라운드 수를 정수로 변환하고, 변환이 불가능할 경우 예외를 발생시킵니다.
        - `checkRoundCountPositive(int roundCount)`: 라운드 수가 양수인지 확인하고, 양수가 아닌 경우 예외를 발생시킵니다.
