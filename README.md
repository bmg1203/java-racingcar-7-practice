# java-racingcar-precourse

# 우테코 7기 프리코스 2주차: 자동차 경주

[https://apply.techcourse.co.kr/assignment/14/mission/46](https://apply.techcourse.co.kr/assignment/14/mission/46)

# 목표

## 학습 목표

- [ ]  여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- [ ]  테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- [ ]  [1주차 공통 피드백](https://docs.google.com/document/d/1MdiqBV5nhSfFB96-p5LlKrGM8uLopXslh1vEzwxR9Bo/edit?usp=sharing)을 최대한 반영한다.

## 회고

- [ ]  아래 질문에 대한 중간 회고를 진행하고 소감에 구체적인 결과를 작성한다. 소감은 텍스트로 작성해야 하며 외부 링크를 허용하지 않는다.
   - 지원서에 작성한 목표를 얼마나 달성하고 있다고 생각하나요? 그 이유는 무엇인가요?
   - 지원서에 작서항 목표를 변경해야 한다고 생각하시나요? 그렇다면 그 이유와 어떤 목표로 변경하고 싶으신가요?
   - 프리코스를 진행하면서 눈에 띄는 변화나 깨달은 점이 있나요?

---

# 요구 사항

## 과제 진행 요구 사항

- [x]  미션은 [자동차 경주](https://github.com/woowacourse-precourse/java-racingcar-7) 저장소를 포크하고 클론하는 것으로 시작한다.
- [x]  **기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리**해 추가한다.
- [x]  Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
   - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- [x]  주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x]  각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x]  자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [x]  사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x]  전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [x]  자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [x]  우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [ ]  사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 횟수

```
5
```

출력

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

실행 결과 예시

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

## 프로그래밍 요구 사항

- [x]  JDK 21 버전에서 실행 가능해야 한다.
- [x]  프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [x]  `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- [x]  프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [x]  프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x]  자바 코드 컨벤션을 지키면서 프로그래밍한다.
   - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.
- [ ]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
   - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
      - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [ ]  3항 연산자를 쓰지 않는다.
- [ ]  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ]  JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
   - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
      - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
      - [AssertJ User Guide](https://assertj.github.io/doc)
      - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
      - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### 라이브러리

- [x]  `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
- [x]  Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.

```java
// 0에서 9까지의 정수 중 한 개의 정수 반환
Randoms.pickNumberInRange(0, 9);
```

- [x]  사용자가 입력하는 값은`camp.nextstep.edu.missionutils.Console`의`readLine()`을 활용한다.

---

# 기능 목록

## 사용자 입력 `input`

- [x]  `camp.nextstep.edu.missionutils.Console`의 `readLine()` 사용하여 사용자 입력 구현
- [x]  입력한 문자열에서 쉼표(,)를 기준으로 구분하여 자동차 이름(5자 이하) 분리
- [x]  이동 횟수 입력

## 설계 `design`

- [x]  자동차 클래스 구현

## 경주 진행 `progress`

- [x]  `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용하여 랜덤값 추출
- [x]  추출한 랜덤값이 4 이상일 경우 전진
- [x]  자동차 객체 생성 기능 추가
- [x]  자동차 전진 기능 추가
- [x]  자동차 경주 진행 기능 추가

## 결과 출력  `output`

- [x]  시도할 횟수마다 실행결과 출력
- [x]  경주 진행을 완료한 후 우승자 출력
- [x]  우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분

## 예외상황

# 1주차 공통 피드백 체크리스트

- [ ]  커밋 메세지를 의미 있게 작성한다.
- [ ]  커밋 메세지에 이슈 또는 풀 리퀘스트 번호를 포함하지 않는다.
- [ ]  풀 리퀘스트를 만든 후에는 닫지 말고 추가 커밋을 한다.
- [ ]  오류를 찾을 때 출력 함수 대신 디버거를 사용한다.
- [ ]  이름을 통해 의도를 드러낸다.
- [ ]  축약하지 않는다.
- [ ]  공백 라인을 의미 있게 사용한다.
- [ ]  스페이스와 탭을 혼용하지 않는다.
- [ ]  의미 없는 주석을 달지 않는다.
- [ ]  코드 포매팅을 사용한다.
- [ ]  Java에서 제공하는 API를 적극 활용한다.
- [ ]  배열 대신 컬렉션을 사용한다.