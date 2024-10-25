## java-racingcar-precourse
#### 자동차 경주

---

### 학습 목표
* 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
* **테스트 도구를 사용하는 방법을 배우고** 프로그램이 제대로 동작하는지 테스트한다.
* **1주차 공통 피드백**을 최대한 반영한다.

---

### 과제 진행 요구 사항
* 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다.
* 기능을 구현하기 전 README.md 에 구현할 기능 목록을 정리해 추가한다.
* Git 의 커밋 단위는 앞 단계에서 README.md 에 정리한 기능 목록 단위로 추가한다.
    * [AngularJS Git Commit Message Conventions]() 을 참고해 커밋 메시지를 작성한다.
* 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

<br>

### 기능 요구 사항
1. 자동차 경주 게임 OutputViewer
    * [x] 경주할 자동차 이름 입력에 대한 설명을 출력할 수 있어야 한다.
    * [x] 시도할 횟수에 대한 설명을 출력할 수 있어야 한다.
    * [x] 시도 횟수만큼 진행 상황을 출력할 수 있어야 한다.
    * [x] 최종 우승자에 대한 결과를 출력할 수 있어야 한다.
        * 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

   <br>

2. 자동차 경주 게임 InputReader()
    * [x] 경주할 자동차 이름을 입력할 수 있어야 한다.
    * [x] 입력값이 공백이 아니어야 한다.
    * [x] 시도할 횟수에 대해 입력할 수 있어야 한다.
    * [x] 숫자 이외의 값은 입력할 수 없어야 한다.
      * 0 또는 음수가 아닌 자연수여야 합니다.
    * [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시킨 후 종료되어야 한다.

   <br>

3. 입력값 변환 InputParser()
    * [x] 입력된 이름을 컬렉션으로 변환하여 반환할 수 있어야 한다.
      *  쉼표(,) 기준으로 구분되어야 한다.
    * [x] 이름은 5자 이하만 가능하다.
    * [x] 이름 사이에 공백이 존재하지 않아야 한다.
    * [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시킨 후 종료되어야 한다.

   <br>

4. 자동차 관련 Car()
    * [x] 자동차는 전진 또는 멈출 수 있어야 한다.
    * [x] 자동차 간의 순위를 판별할 수 있어야 한다.
    * [x] 전진하는 조건은 0 에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

   <br>

5. 참가 자동차 관련 Cars()
    * [x] 자동차들의 상태에 대해 반환 받을 수 있어야 한다.
    * [x] 자동차들의 경주를 진행할 수 있어야 한다.
    * [x] 우승한 자동차들을 반환 받을 수 있어야 한다.

   <br>
   
6. 레이싱 매니저 기능
    * [x] 자동차 경주 게임을 시작할 수 있어야 한다.
    * [x] 자동차 경주 게임을 관리할 수 있어야 한다.
    * [x] 최종 우승자의 상태를 나타낼 수 있어야 한다.

<br>

#### 입출력 요구 사항
_**입력**_
* 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```java
pobi,woni,jun
```
* 시도할 횟수
```java
5
```

_**출력**_
* 차수별 실행 결과
```java
pobi : --
woni : ----
jun : ---
```
* 단독 우승자 안내 문구
```java
최종 우승자 : pobi
```
* 공동 우승자 안내 문구
```java
최종 우승자 : pobi, jun
```

_**실행결과 예시**_
```java
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

<br>

### 프로그래밍 요구 사항 (1)
* JDK 21 버전에서 실행 가능해야 한다.
* 프로그램 실행의 시작점은 Application의 `main()`이다.
* build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
* 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
* 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * 기본적으로 `Java Style Guide`를 원칙으로 한다.

<br>

### 프로그래밍 요구 사항 (2)
* indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 3항 연산자를 쓰지 않는다.
* 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
* JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

#### 라이브러리
* `camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API 를 사용하여 구현해야 한다.
    * Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    * 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

_**사용 예시**_
* 0에서 9까지의 정수 중 한 개의 정수 반환
    * `Randoms.pickNumberInRange(0, 9)`;