# 🎯 2주차 미션 목표

## 🏗️ 단일 책임 원칙 적용
- 각 구성 요소와 메서드는 단일 책임을 가지도록 설계하여, 역할을 명확히 정의한다.
- 여러 역할을 수행하는 큰 함수는 단일 역할을 수행하는 작은 함수로 분리하여 가독성을 높이고 유지보수를 용이하게 한다.

## ✅ 테스트 코드 작성 및 확인
- JUnit 5와 AssertJ를 활용해 각 기능이 올바르게 동작하는지 검증하는 테스트 코드를 작성한다.
- 테스트 도구 사용법을 익히고 테스트를 통해 기능을 검증하여 코드의 신뢰성을 높인다.

## 🔄 피드백 반영
- 1주 차 코드 리뷰와 공통 피드백을 반영하여 코드 품질을 개선하고 기능 요구 사항을 충족하도록 노력한다.

---

# 기능 요구 사항
- [x] 초간단 자동차 경주 게임을 구현한다. 🚗🏁

---

## 👨‍✈️ 자동차 경주 게임 진행

`RaceController`는 자동차 경주 게임의 전반적인 흐름을 제어하며, 게임을 시작하고 결과를 출력하는 역할을 담당합니다.

### 💻 입력 처리
- [x] `RaceSetupFacade`를 통해 사용자로부터 자동차 이름과 이동 횟수를 입력받습니다.
  - [x] **자동차 이름 입력**: 쉼표(,)를 기준으로 자동차 이름을 입력받아 리스트로 관리합니다.
  - [x] **이동 횟수 입력**: 게임을 진행할 시도 횟수를 입력받습니다.

### 🏁 게임 진행
- [x] `RaceController`가 자동차 경주 게임을 진행하는 메서드를 호출하여 라운드별 진행 상황을 제어합니다.
  - [x] **자동차 전진 조건 확인**: `RandomNumberGenerator`가 생성한 무작위 값(0-9)을 `MovementPolicy`에 전달하여, 값이 4 이상일 경우 자동차는 전진합니다.
  - [x] **자동차 이동 상태 출력**: 자동차가 전진할 때마다 `RaceProgressFormatter`를 통해 시각화된 이동 상태를 생성하고, `OutputView`에서 해당 상태를 출력합니다.

### 🏆 우승자 결정
- [x] 모든 라운드가 끝난 후 `WinnerDecider`를 통해 우승자를 결정하고 `OutputView`를 통해 결과를 출력합니다.
  - [x] **우승자 판정**: `raceProgressManager`에서 최종 이동 거리가 가장 먼 자동차를 우승자로 판단합니다.
  - [x] **우승자 출력**: 여러 명의 우승자가 있을 경우 `WinnerFormatter`를 사용해 쉼표(,)로 구분하여 출력합니다.

---

## 🚙 자동차

`RacingCar` 클래스는 각 자동차의 이름과 이동 기능을 관리하며, 주어진 조건에 따라 전진하거나 멈춥니다.

### 🛠️ 기능 요구사항

#### 🚗 자동차 생성
- [x] **자동차 이름 설정**: 각 자동차는 5자 이하의 이름을 가집니다. `RacingCar` 클래스 생성 시 이름이 설정되며, `getName` 메서드를 통해 이름을 조회할 수 있습니다.

#### 🚗💨 자동차 전진
- [x] **자동차 전진 여부 결정**: `MovementPolicy`에서 전진 조건을 확인합니다. 무작위로 생성된 값이 4 이상일 경우 자동차는 전진합니다.
  - [x] **전진 실행**: `executeForward` 메서드는 `MovementPolicy`의 `shouldMove` 결과에 따라 전진 여부를 결정하며, `RaceProgressManager`를 통해 자동차의 진행 상황을 업데이트합니다.

#### 🚦 자동차 정지
- [x] **자동차 정지**: `MovementPolicy`의 전진 조건(4 이상)에 미달할 경우 자동차는 전진하지 않고 정지 상태를 유지합니다.

### 🚨 의존성 검증
- `executeForward` 메서드는 `MovementPolicy`와 `RaceProgressManager`가 null이 아님을 확인한 후 전진 여부를 결정합니다.
  - **정책 검증**: `MovementPolicy`가 null일 경우 `MOVEMENT_POLICY_NULL` 예외 메시지로 `RacingCarException`을 발생시킵니다.
  - **진행 관리 검증**: `RaceProgressManager`가 null일 경우 `RACE_PROGRESS_MANAGER_NULL` 예외 메시지로 `RacingCarException`을 발생시킵니다.


---

## 🎲 무작위 값 생성

`RandomNumberGenerator` 클래스는 자동차가 전진할지 여부를 결정하는 데 필요한 0에서 9 사이의 무작위 값을 생성하고 검증합니다.

### 🛠️ 기능 요구사항

- [x] **무작위 값 생성**: `RandomNumberGenerator` 클래스의 `randomNumber()` 메서드는 0에서 9 사이의 무작위 값을 생성하여 반환합니다.

- [x] **전진 조건 확인**: 생성된 무작위 값이 4 이상일 경우 자동차는 전진합니다. `MovementPolicy`에서 이 값을 확인하여 전진 여부를 결정합니다.

### 🚨 값 검증
- `RandomNumberGenerator`는 생성된 무작위 값에 대해 다음 검증을 수행합니다.
  - **Null 값 검증**: `validateNull` 메서드를 통해 무작위 값이 null이 아닌지 확인합니다. null일 경우 `RacingCarException`이 발생합니다.
  - **범위 검증**: `validateRange` 메서드를 통해 무작위 값이 0에서 9 사이의 범위 내에 있는지 확인합니다. 범위를 벗어나면 `RacingCarException`이 발생합니다.


---

## 💻 입력 관리

`InputView` 클래스는 사용자로부터 자동차 이름과 이동 횟수를 입력받고, 입력값의 유효성을 검증하는 역할을 수행합니다.

### 🛠️ 기능 요구사항

#### 💻 입력받기
- [x] **자동차 이름 입력**: `readRacingCarNames` 메서드는 쉼표(,)로 구분된 자동차 이름을 입력받아 `RacingCarNames` 객체로 변환합니다.
- [x] **이동 횟수 입력**: `readNumberOfAttemptCount` 메서드는 이동 횟수를 입력받아 `AttemptCount` 객체로 변환합니다.

### 🚨 입력 검증
`InputView`는 입력값에 대해 다음 검증을 수행합니다.

- **빈 입력 검증**: `validateNonEmptyInput` 메서드를 통해 입력값이 비어 있지 않은지 확인합니다.
  - 비어 있을 경우 `EMPTY_INPUT` 예외 메시지와 함께 `RacingCarException`을 발생시킵니다.

---

## 🖥️ 출력 관리

`OutputView` 클래스는 게임의 진행 상황과 사용자에게 필요한 메시지를 화면에 출력하는 역할을 수행합니다.

### 🛠️ 기능 요구사항

#### 💻 입력 메시지 출력
- [x] **자동차 이름 입력 메시지**: `printCarNameInputPrompt` 메서드는 "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 메시지를 출력합니다.
- [x] **시도 횟수 입력 메시지**: `printNumberOfAttemptCountMessage` 메서드는 "시도할 횟수는 몇 회인가요?" 메시지를 출력합니다.

#### 📊 진행 결과 출력
- [x] **차수별 결과 출력**: `printRoundProgress` 메서드는 각 차수별로 자동차의 이동 상태와 이름을 출력합니다.

#### 🏆 우승자 결과 출력
- [x] **단독 우승자 출력**: 우승자가 한 명일 경우 `printWinners` 메서드를 통해 해당 자동차의 이름을 출력합니다.
- [x] **공동 우승자 출력**: 여러 명의 우승자가 있을 경우 `printWinners` 메서드를 통해 쉼표(,)로 구분된 이름을 출력합니다.

### 🚨 출력 메시지
- `OutputView`는 다음과 같은 메시지를 출력합니다.
  - **자동차 이름 입력 메시지**: `INPUT_CAR_NAMES_MESSAGE`
  - **시도 횟수 입력 메시지**: `INPUT_ATTEMPT_COUNT_MESSAGE`
  - **실행 결과 메시지**: `EXECUTION_RESULT_MESSAGE`