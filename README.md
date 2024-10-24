# java-racingcar-precourse

## 구현할 기능 목록

### RacingCar

- [ ] 경주할 자동차 이름을 입력받는다.
  - [ ] 이름은 쉼표(,) 기준으로 구분한다.
  - [ ] 이름은 5자 이하만 가능하다.
- [ ] 각 자동차에 입력받은 이름을 부여한다.
- [ ] 자동차가 전진한 횟수를 유지해야 한다.

### RacingCars

- [ ] 자동차들 목록을 유지한다.
- [ ] 랜덤하게 전진하도록 한다.
  - [ ] 전진 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

### GameControl

- [ ] 몇 번의 이동을 할 것인지를 입력 받는다.
- [ ] 입력한 이동 횟수 만큼 반복한다.
  - [ ] 자동차들을 전진시키거나 멈추도록 한다.
  - [ ] 이동 결과를 자동차 이름과 함께 출력한다.
- [ ] 게임을 종료한다.
  - [ ] 누가 우승했는지 출력한다.
    - [ ] 승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

### 예외 처리

- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 예시

### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```text
pobi,woni,jun
```

- 시도할 횟수
```text
5
```

### 출력

- 차수별 실행 결과
```text
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구
```text
최종 우승자 : pobi
```

- 공동 우승자 안내 문구
```text
최종 우승자 : pobi, jun
```

### 실행 결과 예시
```text
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
