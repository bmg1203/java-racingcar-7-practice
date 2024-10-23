# java-racingcar-precourse

# 기능 요구사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

#### 입력

- 경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 회수

```
5
```

#### 출력

- 각 차수별 실행 결과

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

#### 실행 결과 예시

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 회수는 몇회인가요?
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

# 구현할 기능 목록

- [X] 경주 할 자동차 이름들을 쉼표를 기준으로 입력받는 기능.
    - [X] 사용자에게 입력을 요청하는 메시지를 출력하는 기능.

- [X] 쉼표를 기준으로 자동차 이름들을 구분해 저장하는 기능.
    - [X] 쉼표를 기준으로 자동차 이름들을 구분하는 기능.
    - [X] 자동차 이름이 5자 이하인지 확인하는 기능.
    - [X] 자동차 이름들을 저장하는 기능.

- [X] 시도할 횟수를 입력받는 기능.
    - [X] 사용자에게 입력을 요청하는 메시지를 출력하는 기능.

- [ ] 0 부터 9 사이의 랜덤 값을 구하는 기능.
    - [ ] `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용.

- [ ] 랜덤 값이 4 이상일 경우 자동차를 전진하는 기능.

- [ ] 매 차수별 실행 결과를 출력하는 기능.
    - [ ] 자동차별로 이름과 이동 거리를 출력하는 기능.

- [ ] 우승자를 판별하는 기능.
    - [ ] 가장 멀리 이동한 자동차(들)을 추출하는 기능.

- [ ] 우승자를 출력하는 기능.
    - [ ] 우승 자동차명을 쉼표를 기준으로 출력하는 기능.

- [ ] **공통: 잘못된 입력에 대해 `IllegalArgumentException`을 발생시킨 후, 애플리케이션을 종료하는 기능.**

# 예외 처리 목록

- [X] 자동차 이름이 5자를 초과하는 경우
- [X] 자동차 이름이 공백인 경우
- [X] 자동차 이름이 중복되는 경우
- [X] 자동차의 수가 1 대 미만인 경우
- [X] 시도 횟수가 0 이하인 경우
- [X] 시도 횟수가 숫자가 아닌 경우
- [X] 시도 횟수가 정수(Long) 범위를 초과하는 경우