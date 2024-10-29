<p align="middle" >
  <img width="344" alt="automobile-2026529_1280" src="https://github.com/user-attachments/assets/7071c058-2db8-47de-958b-a0b1ea3c5eda">
</p>
<h1 align="middle">자동차 경주</h1>

## 🔍 프리코스 진행 방식

### 📑 진행 방식
- 미션은 **과제 진행 요구 사항, 기능 요구 사항, 프로그래밍 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- **기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.**
- 매주 진행할 미션은 화요일 오후 3시부터 확인할 수 있으며, 다음 주 월요일까지 구현을 완료하여 제출해야 한다. **제출은 일요일 오후 3시부터 가능하다.**
  - **정해진 시간을 지키지 않을 경우 미션을 제출하지 않은 것으로 간주한다.**
  - 종료 일시 이후에는 추가 푸시를 허용하지 않는다.

### 📚 미션 제출 방법
- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
  - GitHub을 활용한 제출 방법은 [프리코스 과제 제출 문서](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse)를 참고해 제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원 플랫폼](https://apply.techcourse.co.kr/)에 PR 링크를 포함하여 최종 제출한다.
  - 자세한 안내는 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#%EC%A0%9C%EC%B6%9C-%EA%B0%80%EC%9D%B4%EB%93%9C)를 참고한다.
  - 과제를 수행하면서 느낀 점, 배운 점, 많은 시간을 투자한 부분 등 자유롭게 작성한다.

### 🚨 과제 제출 전 체크 리스트
- 기능을 올바르게 구현했더라도 **요구 사항에 명시된 출력 형식을 따르지 않으면 0점**을 받게 된다.
- 기능 구현을 완료한 후 아래 가이드에 따라 모든 테스트가 성공적으로 실행되는지 확인한다.
- **테스트가 실패하면 점수가 0점**이 되므로 제출하기 전에 반드시 확인한다.

### 🖥️ 테스트 실행 가이드
- 터미널에서 `java -version`을 실행하여 Java 버전이 21인지 확인한다. Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 21로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고, Windows 사용자의 경우 `gradlew.bat clean test` 또는 `./gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.
```
BUILD SUCCESSFUL in 0s
```

---

## 📑 과제 진행 요구 사항
- 미션은 [자동차 경주](https://github.com/woowacourse-precourse/java-racingcar-7) 저장소를 포크하고 클론하는 것으로 시작한다.
- **기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리**해 추가한다.
- Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
  - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

---

## 🚀 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### ⌨️ 입출력 요구 사항
**입력**
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```
pobi,woni,jun
```
- 시도할 횟수
```
5
```
**출력**
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
**실행 결과 예시**
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

## ✏️ 기능 요구 사항 체크리스트 정리

### 1. `문자열 덧셈 계산기` - 기능 요구 사항 세부 정리
✅ **`Main` 클래스**
- 사용자 입력 처리 및 유효성 검증
- 경주 시작
- 우승자 결정 및 결과 출력

✅ **`Car` 클래스**
- 자동차 객체의 상태 관리 및 전진 동작 수행

  ☑️ `Car` 메소드 (`생성자`)
  - 자동차 이름 초기화
  
  ☑️ `move` 메소드
  - 난수가 4 이상일 경우 자동차 전진 후 distance 1 증가
  
  ☑️ `getDistance` 메소드
  - 현재 자동차의 이동 거리 반환
  
  ☑️ `getName` 메소드
  - 현재 자동차의 이름 반환

✅ **`Race` 클래스**
- 경주 전체 관리
- 자동차들 관리 및 주어진 이동 횟수만큼 경주 실행

  ☑️ `Race` 메소드 (`생성자`)
  - 자동차 리스트 및 이동 횟수 초기화
  
  ☑️ `startRace` 메소드
  -  이동 횟수만큼 각 자동차에 대해 move() 메소드 호출 해 경주 진행
  
  ☑️ `getWinner` 메소드
  - 가장 많이 이동한 자동차를 찾아 우승자 리스트 반환

✅ **`InputHandler` 클래스**
- 사용자 입력을 처리
- 입력값의 유효성 검증

  ☑️ `getCarNames` 메소드
  - 자동차 이름 입력 받음
  
  ☑️ `getMoveCnt` 메소드
  - 이동 횟수를 입력 받음
  
  ☑️ `validCarNames` 메소드
  - 자동차 이름 유효성을 검증
  - 이름이 5자 이하인지 확인 후 잘못된 경우 예외 발생
  
  ☑️ `validMoveCnt` 메소드
  - 이동 횟수 유효성 검증
  - 이동 횟수가 음수일 경우 예외 발생

### 2. 예외처리 - InputHandler 클래스
✅ **`validCarNames` 메소드**
- 자동차 이름 유효성을 검증
- 이름이 5자 이하인지 확인 후 잘못된 경우 예외 발생
- 이름이 입력되지 않은 경우 예외 발생

✅ **`validMoveCnt` 메소드**
- 이동 횟수 유효성 검증
- 이동 횟수가 음수일 경우 예외 발생

---

## ✏️  테스트 케이스 정리

### 1. ApplicationTest

☑️ 우승자가 한 명일 경우 출력 형식이 제대로 동작하는 지

☑️ 우승자가 여러 명일 경우 출력 형식이 제대로 동작하는 지

☑️ 예외가 제대로 처리되어 동작되는 지

### 2. InputHandlerTest

☑️ 자동차 이름이 5를 초과할 경우 예외 처리가 제대로 동작하는 지

☑️ 자동차 이름이 “”일 경우 예외 처리가 제대로 동작하는 지

☑️ 이동 횟수가 음수일 경우 예외 처리가 제대로 동작하는 지

### 3. CarTest

☑️ 자동차 이름이 5를 초과할 경우 예외 처리가 제대로 동작하는 지

☑️ 자동차 이름이 “”일 경우 예외 처리가 제대로 동작하는 지

☑️ 이동 횟수가 음수일 경우 예외 처리가 제대로 동작하는 지

### 2. RaceTest

☑️ 자동차 이름이 5를 초과할 경우 예외 처리가 제대로 동작하는 지

☑️ 자동차 이름이 “”일 경우 예외 처리가 제대로 동작하는 지

☑️ 이동 횟수가 음수일 경우 예외 처리가 제대로 동작하는 지

---

## 🎯 프로그래밍 요구 사항 1
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.

## 🎯 프로그래밍 요구 사항 2
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

### 📖 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console API`를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
**사용 예시**
- 0에서 9까지의 정수 중 한 개의 정수 반환
```
Randoms.pickNumberInRange(0, 9);
```
