### ✋ 안녕하세요!
```
반갑습니다.
```
* 2주차 과제하시느라 다들 고생 많으셨습니다.
* 코드 리뷰해주시는 분들을 위해 작성했습니다.
* 감사합니다. 행운을 빕니다.

### 📦 패키지 구조
```
└── src
    ├── main
    │   └── java
    │       └── racingcar
    │           ├── Application.java
    │           ├── configuration
    │           │   └── AppConfig.java
    │           ├── controller
    │           │   └── RacingController.java
    │           ├── model
    │           │   ├── dto
    │           │   │   ├── CarNames.java
    │           │   │   ├── RacingProgress.java
    │           │   │   ├── RacingRecording.java
    │           │   │   └── RacingWinners.java
    │           │   └── entity
    │           │       ├── Car.java
    │           │       ├── Cars.java
    │           │       ├── RacingChance.java
    │           │       ├── RacingTurn.java
    │           │       ├── RacingTurns.java
    │           │       └── StrategiesAtCarNames.java
    │           ├── repository
    │           │   ├── MemoryRepository.java
    │           │   └── Repository.java
    │           ├── service
    │           │   ├── RacingService.java
    │           │   └── RacingServiceImpl.java
    │           ├── strategy
    │           │   └── MoveStrategy.java
    │           ├── utils
    │           │   ├── message
    │           │   │   ├── ErrorMessage.java
    │           │   │   └── IOMessage.java
    │           │   └── validator
    │           │       └── CarNamesValidator.java
    │           └── view
    │               ├── ConsoleInputView.java
    │               ├── ConsoleOutputView.java
    │               ├── InputView.java
    │               └── OutputView.java
    └── test
        └── java
            └── racingcar
                ├── ApplicationTest.java
                ├── CarNamesFormatValidateTest.java
                ├── ExceptionMessageTest.java
                └── RacingChanceFormatValidationTest.java
```
🤔 집중한 요소
1. 확장에 유연한 구조
2. mvc 패턴
3. 함수형 프로그래밍 도입
4. 객체 지향 생활체조 9원칙 준수
5. 가독성 있는 네이밍
