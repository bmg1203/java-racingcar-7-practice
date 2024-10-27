# 2️⃣ 자동차 경주

## 💡 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다. 
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. 
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 🎯 입력
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
- 시도할 횟수
### 🎯 출력
- 차수별 실행 결과
- 단독 우승자 안내 문구
- 공동 우승자 안내 문구

## ✅ 기능 목록

### 1. 게임 시작

- [X] 경주를 진행할 각 자동차 이름을 입력받는다.
    - [X] 각 자동차 이름을 쉼표(`,`)를 이용해 구분하여 입력한다.
    - [X] 이름은 5자 이하만 가능하다.
    - [X] 이름에 숫자는 들어갈 수 없다.
- [X] 몇 번의 이동을 할 것인지 이동 회수를 입력받는다.

### 2. 게임 진행

- [ ] 자동차 경주 게임을 시작한다.
    - [ ] 0에서 9 사이의 임의의 값을 구한 후 4 이상일 경우 전진한다.
    - [ ] 각 차수별 실행 결과를 자동차 이름과 이동 거리를 함께 출력한다.

### 3. 게임 종료

- [ ] 게임 완료 후 우승자를 출력한다.
    - [ ] 우승자는 1명 이상일 수 있다.
    - [ ] 우승자가 여러 명일 경우 쉼표(`,`)를 이용해 구분하여 출력한다.
    - [ ] 우승자가 없는 경우 "우승자가 없습니다."를 출력한다.

### 4. 예외 처리
- [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션을 종료한다.