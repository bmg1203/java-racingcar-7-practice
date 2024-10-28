# java-racingcar-precourse
### 패키지 구조
```
src
 src
 ├── main
     ├── java
         ├── racingcar
             ├── controller
                 ├── RacingCarController.java
             ├── domain
                 ├── Car.java
                 ├── RacingGame.java
                 ├── CarManager.java
                 ├── RoundManager.java
                 ├── RacingResult.java
             ├── service
                 ├── RacingCarService.java
                 ├── RacingCarServiceImpl.java
             ├── utils
                 ├── InputValidator.java
                 ├── RandomNumberGenerator.java
                 ├── RandomNumberGeneratorImpl.java
                 ├── CarNameValidator.java
                 ├── NumberOfTrialsValidator.java
                 ├── ErrorMessages.java
             ├── view
                 ├── InputView.java
                 ├── OutputView.java
             ├── config
                 ├── AppConfig.java
             ├── Application.java

```
### 클래스 다이어 그램
![img.png](img.png)
### 기능 구현 목록

- [x]  경주할 자동차들의 이름과 시도할 횟수를 입력받아 저장한다.
    - [x]  유효성 검사와 예외 처리를 통해 올바른 입력만 허용한다. (예: 빈 입력, 중복된 이름, 자동차 이름 길이 등)
- [x]  회차별로 자동차를 전진시킨 후 모든 회차가 끝난 후 우승한 자동차를 선정한다
    - [x]  회차별로 각 자동차 별로 0~9사이의 무작위 값을 생성한다.
        - [x]  무작위 값 생성 시 테스트를 위해 난수 생성기를 주입할 수 있도록 설계한다.
    - [x]  자동차 이동 여부 판정:
        - [x]  생성된 값이 4 이상이면 1칸 이동
        - [x]  생성된 값이 4 미만이면 변화 없음
    - [x]  회차별로 이동한 횟수만큼 "-"를 통해 이동 상태를 표시한다.
    - [x]  모든 회차가 끝난 후 가장 많이 이동한 자동차를 우승자로 선정한다.
        - [x]  우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분

### 예외처리

`IllegalArgumentException` 이후 프로그램이 종료되도록 한다.

- [x]  **자동차 이름 입력 예외처리**
    - [x]  자동차 이름 길이가 5자를 넘는 경우 
    - [x]  빈 이름이 포함된 경우의 자동차 이름
    - [x]  같은 이름이 있는 경우 중복 처리
- [x]  **시도할 횟수 예외처리**
    - [x]  숫자가 아닌 경우에 대한 처리
    - [x]  음수 또는 0일 경우에 대한 처리
    - [x] 빈 입력에 대한 처리 

### 설계 패턴

- **MVC 구조**
    - 각 컴포넌트의 역할에 대해 명확히 설명하고, 해당 구조를 기반으로 코드를 작성한다.
- **서비스 클래스**
    - 핵심 비즈니스 로직을 수행하는 클래스로 구현한다.
- **단일 책임 원칙**
    - 클래스는 하나의 기능만 수행하도록 분리하여 유지보수성을 높인다.
- **외부 의존성 주입**
    - 필요에 따라 난수 생성기 등 외부 의존성을 주입하여 테스트 및 재사용성을 높인다.
- **인터페이스와 구현체 분리 설계(의존성 역전)**
    - 유연한 설계를 위해 인터페이스와 구체적인 구현을 분리하여 종속성을 줄인다.