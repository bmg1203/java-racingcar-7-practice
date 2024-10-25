# java-racingcar-precourse
## 구현할 기능 목록
### 입력
- [x] 경주할 자동차 이름 입력
- [x] 시도할 횟수 입력
### 구분자
- [x] 자동차 이름 쉼표(,)를 기준으로 구분
### 예외 처리
- [x] 자동차 이름 5자 초과시 IllegalArgumentException 발생
- [x] 입력 받은 시도할 횟수 숫자이고 0 이상이 아니라면 IllegalArgumentException 발생
### 자동차 클래스
- [x] 자동차 클래스(이름, 전진 횟수) 생성
- [ ] 자동차 이름 + 전진 횟수 문자열 반환 함수
    ```
  pobi : --
    ```
### 게임 처리
- [ ] 랜덤 값을 구한다.
  - 4 이상 = 전진
  - 3 이하 = 멈춤
- [ ] 전진일 경우: 자동차 전진 횟수 += 1 
### 우승 조건
- [ ] 전진 횟수가 가장 많은 우승자 리스트를 구한다.
### 출력
- [ ] 경주할 자동차 이름 메시지 출력
- [ ] 시도할 횟수 메시지 출력
- [ ] 시도별 메시지 출력
  ```
    pobi : --
    woni : -
    jun : --
    ```
- [ ] 우승자 출력

## 기능 요구 사항

---
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.