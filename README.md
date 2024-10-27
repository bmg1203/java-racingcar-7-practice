# 미션 - 자동차 경주 
## 🔊기능 요구 사항 
초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
### 입출력 요구 사항
#### 입력
* 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
    ```declarative
    pobi, woni, jun
    ```
* 시도할 횟수
    ```declarative
    5
    ```
#### 출력
* 차수별 실행 결과
  ```declarative
  pobi : --<br>
  woni : --<br>
  jun  : --
  ```
* 단독 우승자 안내 문구
  ```declarative
  최종 우승자 : pobi
  ```
* 공동 우승자 안내 문구
  ```declarative
  최종 우승자 : pobi, jun
  ```
* 실행 결과 예시 
  ```declarative
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

## 🔊 프로그래밍 요구 사항 
* 프리코스 1주차 문자열 덧셈 계산기에서 제시한 [프로그래밍 요구사항](https://github.com/usnijee/java-calculator-7/tree/usnijee)
* 추가 요구 사항
    * indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
        * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
        * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
    * 3항 연산자를 쓰지 않는다.
    * 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
    * JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
        * 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
            *  [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
            *  [AssertJ User Guide](https://assertj.github.io/doc)
            *  [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
            *  [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

## 📄 Directory Tree
```declarative
main
└── java
    └── racingcar
        ├── domain
        │   ├── Car
        │   └── Race
        ├── io
        │   ├── InputReader
        │   └── OutputWriter
        ├── strategy
        │   ├── MoveStrategy
        │   └── RandomMoveStrategy1
        ├── validation
        │   └── InputValidator
        └── Application
test
└── java
    └── racingcar
        └── ApplicationTest
```