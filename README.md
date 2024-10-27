# 프리코스 2주차 미션 - 자동차 경주


## 목차
- [기능 요구 사항](#기능-요구-사항)
- [구현할 기능 목록](#구현할-기능-목록)
    - 입력
    - 기능
    - 출력
    - 예외 상황
    - 테스트
- [프로그래밍 요구 사항](#프로그래밍-요구-사항)
- [입출력 요구 사항](#입출력-요구-사항)
    - 입력
    - 출력
    - 실행 결과 예시

---

### 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 을 발생시킨 후 애클리케이션은 종료되어야 한다.

---

### 구현할 기능 목록
#### 입력
- '경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)'  문구 출력
    - [x] `Console.readLine()` 메서드를 통해 경주할 자동차의 이름을 입력 받는다.
    - [x] 사용자가 입력한 문자열을 쉼표(,) 기준으로 분할한다.
  

- '시도할 횟수는 몇 회인가요?' 문구 출력
    - [x] `Console.readLine()` 메서드를 통해 시도할 횟수를 입력 받는다.


#### 기능
- 각 자동차들은 구한 무작위 값이 0 ~ 9 사이의 4이상의 값일 때 전진한다.
    - [x] 무작위 값은 `Randoms.pickNumberInRange()` 를 활용한다.


- [x] 차수별 실행 결과를 모두 합산하여 우승자를 선정한다.


#### 출력
- [x] 전진하는 자동차를 자동차의 이름과 함께 출력한다.
- [x] 최종 우승자를 출력한다.
    - [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.


#### 예외 상황
 - 사용자의 경주할 자동차 이름이 잘못된 경우
    - [x] 여러 자동차의 이름이 쉼표(,) 로 구분되지 않은 상태로 입력되었을 때 
        - `(e.g, pobi woni jun / pobi;woni;jun 등)`
    - [x] 자동차의 이름 중 5자 이하가 아닌 이름이 입력되었을 때
    - [x] 자동차의 이름이 입력되지 않았을 때
 

 - 사용자의 시도할 횟수가 잘못 입력된 경우
    - [x] 숫자가 아닌 문자가 입력된 경우
    - [x] 입력 받은 실행 횟수가 1회 이상이 아닌 경우


#### 테스트
- [x] 자동차 이름이 5자 초과일 경우 예외 발생
- [x] 빈 자동차 이름 입력 시 예외 발생
- [ ] 자동차 이름 입력 구분이 쉼표(,) 외의 문자로 구분될 때 예외 발생
- [x] 자동차 이름 입력 구분이 공백으로 된 경우 예외 발생
- [x] 시도 횟수가 1 미만일 때 예외 발생 -> 음수일 때
- [x] 자동차 이름 중 하나가 빈 문자열인 경우 예외 발생
- [ ] 시도 횟수에 숫자가 아닌 문자가 입력된 경우 예외 발생
- [ ] 자동차가 무작위 값에 따라 전진하거나 멈춤
- [ ] 최대 위치를 가진 자동차가 우승자로 결정되어야 함
- [ ] 우승자가 여러 명일 경우 쉼표(,) 를 이용하여 구분되어 출력됨
- [x] 자동차가 이동하고 최종 우승자가 정확히 출력되는지 확인

---

### 프로그래밍 요구 사항
- [x] JDK 21 버전에서 실행 가능해야 한다.
- [x] 프로그램의 실행의 시작점은 `Application` 의 `main()` 이다.
- [x] 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x] 프로그램 종료시 `System.exit()`를 호출하지 않는다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- [X] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- [x] 라이브러리는 `camp.nextstep.edu.missionutils` 에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.

---

### 입출력 요구 사항
#### 입력
- 경주할 자동차 이름 (이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 횟수

```
5
```

#### 출력
- 차수별 실행 결과

```
pobi : --
woni ; ----
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

- 실행 결과 예시

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