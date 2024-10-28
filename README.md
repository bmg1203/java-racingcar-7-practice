# java-racingcar-precourse
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

## **프로그래밍 요구 사항 1**

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.

## **프로그래밍 요구 사항 2**

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
        - [AssertJ User Guide](https://assertj.github.io/doc)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### **라이브러리**

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

### **사용 예시**

- 0에서 9까지의 정수 중 한 개의 정수 반환

```java
Randoms.pickNumberInRange(0, 9);
```

### 기능명세서

1. **게임 초기 설정**
    - **자동차 이름 입력**: 사용자로부터 자동차 이름 목록을 입력받아, 쉼표로 구분하고 5자 이하인지 검증합니다.
    - **시도 횟수 입력**: 사용자가 몇 번 경주를 진행할지 횟수를 입력받습니다.
2. **자동차 이동 로직**
    - **자동차 전진 조건**: 0~9 사이의 무작위 값을 생성하여 값이 4 이상일 때만 자동차가 전진합니다.
    - **자동차 위치 업데이트**: 전진할 때마다 자동차의 위치 정보를 업데이트합니다.
3. **경주 실행**
    - **각 회차 결과 출력**: 시도 횟수마다 각 자동차의 이름과 전진한 정도를 출력합니다.
4. **우승자 결정 및 출력**
    - **최종 우승자 결정**: 모든 시도가 끝난 후 가장 멀리 이동한 자동차를 결정합니다.
    - **우승자 출력**: 최종 우승자를 출력하며, 여러 명일 경우 쉼표로 구분하여 표시합니다.
5. **입력 검증 및 예외 처리**
    - **이름 입력 예외 처리**: 이름이 5자를 초과할 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료합니다.
    - **횟수 입력 예외 처리**: 유효하지 않은 값(숫자가 아닌 값 등) 입력 시 예외를 발생시키고 프로그램을 종료합니다.
6. **테스트 코드 작성**
    - **이름 검증 테스트**: 이름이 5자 이하인지 검증하는 테스트 작성.
    - **전진 조건 테스트**: 무작위 값에 따라 전진 여부가 올바르게 결정되는지 테스트 작성.
    - **우승자 결정 테스트**: 시도 후 올바르게 우승자가 결정되는지 테스트 작성.

### Todo-List

- **프로젝트 기본 설정**
    - [x]  Git 저장소 포크 및 클론
    - [x]  `.gitignore` 추가 작성
    - [x]  `README.md`에 기능 명세서 추가
- **게임 초기 설정**
    - [x]  사용자에게 자동차 이름을 입력받는 메서드 구현
    - [x]  사용자에게 시도 횟수를 입력받는 메서드 구현
- **자동차 이동 로직**
    - [x]  숫자가 4 이상일 때 전진하는 조건 구현
    - [x]  자동차 위치 정보를 업데이트하는 메서드 구현
- **경주 실행**
    - [x]  입력된 시도 횟수만큼 경주 반복 로직 구현
    - [x]  각 회차의 결과를 출력하는 메서드 구현
- **우승자 결정 및 출력**
    - [x]  최종 우승자를 판별하는 메서드 구현
    - [x]  우승자 출력 메서드 구현
- **입력 예외 처리**
    - [x]  이름이 5자를 초과할 경우 예외 처리 구현
    - [x]  유효하지 않은 시도 횟수 입력에 대한 예외 처리 구현
    - [x]  공백을 입력했을 경우 예외처리 구현
    - [x]  자동차를 1대만 입력했을 경우 예외처리 구현
    - [x]  쉼표사이에 공백이나 아무 것도 없을 경우 예외처리 구현
- **테스트 코드 작성**
    - [x]  이름 검증 테스트 구현
    - [x]  무작위 전진 조건 테스트 구현
    - [ ]  우승자 판별 로직 테스트 구현