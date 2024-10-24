# java-racingcar-precourse

## 기능 요구 사항

---

> 초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 도메인

---

### 상위 수준 설계

### 개별 객체 수준 설계


### 애그리거트 단위


## 객체 요청 흐름

---


## 구현 계획 목록

### Member

---

- name: String

### Car

---

- member: Member
- racingDistance: Long

### Race

---

- cars: List<Cars>
- List<Cars> `race`(Long times)

### Race Result

---

- raceResult: List<Cars>
- String `result`

### Controller

---

### Validator

---

### Service

---