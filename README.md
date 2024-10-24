# java-racingcar-precourse

## 자동차 경주

### 기능 목록

- [x] **자동차 이름 입력**
    - 사용자가 경주에 참가할 자동차 이름을 쉼표(,)로 구분하여 입력한다.
    - 자동차 이름은 5자 이하만 가능하다.
    - 예시: `pobi,woni,jun`

- [x] **시도 횟수 입력**
    - 사용자가 경주할 시도 횟수를 입력한다.
    - 예시: `5`

- [ ] **자동차 전진 조건**
    - 각 자동차는 0에서 9 사이의 무작위 값을 생성하고, 그 값이 4 이상일 경우에 전진한다.
    - 예시: `무작위 값이 6일 경우 자동차 전진, 3일 경우 멈춤`

- [ ] **경주 진행**
    - 입력된 시도 횟수 동안 각 자동차는 조건에 따라 전진 또는 멈춘다.
    - 전진 결과를 차수별로 출력한다.
    - 예시:
        ```
        pobi : --
        woni : ---
        jun  : --
        ```

- [ ] **우승자 결정**
    - 가장 멀리 이동한 자동차가 우승자가 된다.
    - 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력한다.
    - 예시: `최종 우승자 : pobi, jun`

- [ ] **결과 출력**
    - 매 차수마다 각 자동차의 이동 결과를 출력한다.
    - 경주가 끝난 후 최종 우승자를 출력한다.
    - 예시:
        ```
        pobi : -----
        woni : ----
        jun  : -----
        최종 우승자 : pobi, jun
        ```

### 예외 처리

- [ ] **잘못된 자동차 이름 입력**
    - 자동차 이름이 5자를 초과하거나 비어 있는 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
    - 예시: `cherryiju`, ` `

- [ ] **잘못된 시도 횟수 입력**
    - 시도 횟수가 숫자가 아니거나 1보다 작은 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.
    - 예시: `0`, `a`

### 테스트 목록

- [ ] **자동차 이름 유효성 검사 테스트**
    - 이름이 5자를 초과하는지 여부를 확인하고 예외를 발생시키는지 테스트한다.
    - 이름이 비어 있을 경우 예외가 발생하는지 테스트한다.
    - 예시: `pobi,woni,abcdef`, ` ,poni` → `IllegalArgumentException` 발생

- [ ] **시도 횟수 유효성 검사 테스트**
    - 시도 횟수가 숫자가 아닌 경우 예외가 발생하는지 테스트한다.
    - 시도 횟수가 1보다 작은 경우 예외가 발생하는지 테스트한다.
    - 예시: `abc`, `0` → `IllegalArgumentException` 발생

- [ ] **자동차 전진 조건 테스트**
    - 무작위 값이 4 이상일 때만 전진하는지 테스트한다.
    - 예시: `무작위 값이 6일 경우 전진, 3일 경우 멈춤`

- [ ] **우승자 결정 테스트**
    - 가장 멀리 이동한 자동차가 우승자로 선택되는지 테스트한다.
    - 여러 명의 우승자가 있을 경우 제대로 구분되어 출력되는지 테스트한다.
    - 예시: `최종 우승자 : pobi, jun`

- [ ] **결과 출력 테스트**
    - 매 차수별 자동차의 전진 결과가 출력되는지 테스트한다.
    - 경주가 끝난 후 최종 우승자가 제대로 출력되는지 테스트한다.
    - 예시:
        ```
        pobi : ---
        woni : --
        jun  : ----
        최종 우승자 : jun
        ```