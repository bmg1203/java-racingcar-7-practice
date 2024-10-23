# 🚗자동차 경주🚗 기능목록

## 📚 프로젝트 개요
- 사용자가 입력한 자동차들에 대해 자동차 경주 게임을 구현한다
- 입력한 횟수 만큼 경주 게임을 진행하고 게임을 완료한 후 우승자를 출력한다
## 📚 구현 기능 목록

### 💫입력

#### 💣예외처리
- [ ] 자동차 이름
    - [ ] null 혹은 빈 문자열 입력한 경우 `IllegalArgumentException`
  <!-- - [ ] 구분자인 쉼표 입력하지 않은 경우 `IllegalArgumentException` -->
    - [ ] 쉼표로 구분된 자동차 이름이 5자 초과한 입력한 경우 `IllegalArgumentException`
    - [ ] 자동차 이름에 공백 포함된 경우 `IllegalArgumentException`
    - [ ] 중복된 자동차 이름 입력한 경우 `IllegalArgumentException`
    - [ ] 입력값 쉼표 split, 빈 리스트 무시 ex) 입력 : `pobi,,woni,` 저장 : [pobi woni]

- [ ] 시도할 횟수
    - [ ] 입력값이 정수가 아닐 경우 `IllegalArgumentException`
    - [ ] isDigit(입력값)이 0 이하일 경우 `IllegalArgumentException`


### 💫진행
- [ ] 시도할 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다
    - [ ] `Randoms.pickNumberInRange(0, 9);` 값이 4 이상이면 전진
    - [ ] `Randoms.pickNumberInRange(0, 9);` 값이 3 이하이면 멈춤
- [ ] 횟수마다 각각의 자동차가 전진한 횟수를 `-`으로 출력한다
  ```
  pobi : ----
  woni : --
  jun : ---
  ```

### 💫출력
- [ ] 시도한 횟수가 완료된 후 전진한 횟수가 가장 많은 우승자(들)를 출력한다
    - [ ] 단독 우승자인 경우 우승자 이름을 출력한다
      ```
      최종 우승자 : pobi
      ```
    - [ ] 공동 우승자인 경우 우승자들 이름을 쉼표로 구분해 출력한다
      ```
      최종 우승자 : pobi, jun
      ```