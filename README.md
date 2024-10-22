## 🎯 목표
- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- 1주 차 공통 피드백을 최대한 반영한다.

## 👟 추가 목표
- `gitignore`로 관리할 자원을 고려한다.
- 오류를 찾을 때 출력 함수 대신 디버거를 사용한다.
- `Info`, `Data` 등 불용어를 사용하지 않는다.
- `ParameterizedTest`를 활용하여 테스트를 진행한다.

## 🤗 요구사항
- JDK 21 버전에서 실행 가능해야 한다.
-
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

## 🛠️ 기능 구현 목록

### 🏎️ 자동차: Car
- **이름**과 **현재위치**를 가진다.
- 자동차는 전진할 수 있다.
    - 전진하는 조건은 `0`에서 `9` 사이에서 무작위 값을 구한 후 무작위 값이 `4`이상일 경우이다.

### 🕹️ 레이싱 게임: CarRacing
- 자동차를 이름으로 등록할 수 있다.
- 시도 횟수 만큼 자동차를 전진 시킨다.

### ⌨️ 입력: InputView
- 자동차 이름 입력안내 문구 출력 후 사용자의 입력을 받는다.
    - 입력안내 문구 : **경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)**
- 시도 횟수 입력안내 문구 출력 후 사용자의 입력을 받는다.
    - 입력안내 문구 : **시도할 횟수는 몇 회인가요?**

### 💻 출력: OutputView
- 경주 현황을 출력한다.
- 최종 우승자를 출력한다.
    - 출력 문구 : **최종 우승자 : {CarName}, {CarName} ...**

### 👀 검증: InputValidator
- 자동차의 이름은 5자 이하의 한글, 소문자 영어로 이루어져있다.
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
- 시도 횟수는 1이상의 정수이다.
    - 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
