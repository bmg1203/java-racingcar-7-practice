# java-racingcar-precourse

## 구현 기능 목록

---

### 입력 기능

- [x] 경주할 자동차 이름
    - 이름은 쉼표(,) 기준으로 구분
    - 자동차 이름의 길이는 5자 이하
- [x] 시도할 횟수
    - 시도 횟수는 숫자로 입력
    - 최소 시도 횟수는 1 이상

### 핵심 기능

- [ ] 주어진 횟수동안 경주를 진행하는 기능
- [ ] 0 에서 9 사이의 무작위 값이 4 이상이면 자동차가 전진하는 기능
- [ ] 모든 경주가 끝나면 우승자를 계산하는 기능
- [ ] 사용자가 잘못된 값을 입력한 경우 `IllegalArgumentException` 을 발생시키고, 애플리케이션을 종료하는 기능

### 출력 기능

- [ ] 자동차 이름 입력 안내 메세지 출력 기능
- [x] 시도 횟수 입력 안내 메세지 출력 기능
- [ ] 경주 실행 결과 출력 기능
- [ ] 최종 우승자 출력 기능
- [ ] 우승자가 여러명이라면 쉼표(,)로 구분하여 출력하는 기능

### 예외 상황

- [x] 자동차 이름을 입력하지 않은 경우
- [x] 공백을 입력한 경우
- [ ] 경주할 자동차 이름을 쉼표(,)로 구분하지 않은 경우
- [x] 자동차 이름의 길이가 5를 초과한 경우
- [x] 시도 횟수를 입력하지 않은 경우
- [x] 시도 횟수를 숫자로 입력하지 않은 경우
- [ ] 시도 횟수가 1보다 작은 경우 (음수 포함)

## 프로그램 흐름도

---

1. 경주할 자동차 이름을 입력받는다.
2. 시도할 횟수를 입력받는다.
3. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈춘다.
4. 각 경주마다 자동차 이름과 전진 결과를 출력한다.
5. 모든 경주가 끝나면 우승자를 계산하여 출력한다.
