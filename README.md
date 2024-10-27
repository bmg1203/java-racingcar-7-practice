# 자동차 경주 (java-racingcar-precourse)

## 자동차 경주 게임 구현 기능 목록
1. [자동차 입력 기능](#1-자동차-입력-기능)
2. [게임 횟수 입력 기능](#2-게임-횟수-입력-기능)
3. [게임 진행 기능](#3-게임-진행-기능)
4. [차수별 실행 결과 출력 기능](#4-차수별-실행-결과-출력-기능)
5. [게임 결과 출력 기능](#5-게임-결과-출력-기능)

### 1. 자동차 입력 기능
- [x] `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)` 메시지를 콘솔에 출력한다.
- [x] 콘솔에서 경주할 자동차 이름을 입력받는다.
    - [x] 사용자가 잘못된 값을 입력하는 경우에 대해 예외 처리한다.
        - [x] 자동차 이름이 5자를 초과하는 경우
        - [x] 자동차를 등록하지 않은 경우
        - [x] 자동차 이름을 빈문자("")로 입력한 경우


<br/>

### 2. 게임 횟수 입력 기능
- [x] `시도할 횟수는 몇 회인가요?` 메시지를 콘솔에 출력한다.
- [x] 콘솔에서 시도 횟수를 입력받는다.
    - [x] 사용자가 잘못된 값을 입력하는 경우에 대해 예외 처리한다.
        - [x] 자연수가 아닌 값을 입력하는 경우
            - [x] 자연수가 아닌 수를 입력한 경우
            - [x] 문자를 입력한 경우
        - [x] 게임이 성립되지 않는 자연수를 입력한 경우
            - [x] 최대 시도 횟수를 초과한 경우

<br/>

### 3. 게임 진행 기능
- [x] 차수별 게임을 진행한다.
    - [x] 각 자동차에 대해 0 - 9 사이에서 무작위값을 생성한다.
        - [x] 무작위 값이 4 이상인 경우 자동차를 1 전진시킨다.
        - [x] 무작위 값이 3 이하인 경우 자동차를 정지시킨다.
- [x] 가장 많이 전진한 최종 우승자를 선정한다.

<br/>

### 4. 차수별 실행 결과 출력 기능
- [x] 차수별 실행 결과를 콘솔에 출력한다.
    - [x] 예시: pobi 자동차가 2 전진한 경우`pobi : --` 와 같이 모든 자동차의 실행 결과를 콘솔에 출력한다.

<br/>

### 5. 게임 결과 출력 기능
- [x] `최종 우승자 : 우승자 이름`  메시지를 콘솔에 출력한다.
    - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

<br/>

### 예외처리
- [x] 기능에 명시한 모든 예외 처리는  `IllegalArgumentException을` 발생시킨 후 애플리케이션을 종료시킨다.

---

## 과제 진행 요구 사항

- 미션은 [자동차 경주](https://github.com/woowacourse-precourse/java-racingcar-7) 저장소를 포크하고 클론하는 것으로 시작한다.
- 기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리해 추가한다.
- Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
    - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException을` 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항
**입력**
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```bash
pobi,woni,jun
```

- 시도할 횟수
```bash
5
```

**출력**
- 차수별 실행 결과
```bash
pobi : --
woni : ----
jun : ---
```
- 단독 우승자 안내 문구
```bash
최종 우승자 : pobi
```
- 공동 우승자 안내 문구
```bash
최종 우승자 : pobi, jun
```

**실행 결과 예시**
```bash
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

## 프로그래밍 요구 사항 1
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application의` `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.

## 프로그래밍 요구 사항 2
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
        - [AssertJ User Guide](https://assertj.github.io/doc/)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

**사용 예시**
- 0에서 9까지의 정수 중 한 개의 정수 반환
```bash
Randoms.pickNumberInRange(0, 9);
```


