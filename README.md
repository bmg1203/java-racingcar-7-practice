# java-racingcar-precourse
# 🚗 초간단 자동차 경주 게임

## 요구사항

---
- 주어진 횟수 동안 여러 대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있으며, 이름은 쉼표(`,`)로 구분하고 5자 이하만 가능하다.
- 사용자는 시도할 횟수를 입력할 수 있다.
- 0에서 9 사이의 무작위 값이 4 이상일 경우에만 자동차가 전진한다.
- 게임 종료 후 가장 멀리 이동한 자동차(들)를 우승자로 출력한다.
- 우승자가 여러 명일 경우 쉼표(`,`)로 구분해 표시한다.
- 잘못된 값 입력 시 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.

---

## 기능 목록

---
### 입출력
- [X] 자동차 이름을 입력받는 기능
- [X] 시도할 횟수를 입력받는 기능
- [X] 매 이동 결과를 출력하는 기능
- [X] 최종 우승자를 출력하는 기능

### 유효성 검사
- [X] 자동차 이름의 길이 검증
- [X] 시도 횟수의 유효성 검증
- [X] 자동차 이름 중복 검증

### 게임 진행
- [X] 랜덤 값(0~9)을 생성하는 기능
- [X] 랜덤 값이 4 이상일 경우에만 자동차가 전진하는 기능
- [X] 각 이동 결과를 저장하고 출력하는 기능
- [X] 게임 종료 시 우승자 계산 기능

### 우승자 계산
- [X] 게임 종료 후 가장 멀리 이동한 자동차(들)를 계산하는 기능
- [X] 우승자가 여러 명일 경우 쉼표(`,`)로 구분하여 출력하는 기능

### 예외 처리
- [X] 비어 있는 자동차 이름에 대한 예외 처리
- [X] 자동차 이름이 5자를 초과할 경우 예외 처리
- [X] 시도 횟수가 정수가 아닌 경우 예외 처리
- [X] 중복된 자동차 이름에 대한 예외 처리
- [X] 예외 발생 시 적절한 메시지 출력 후 프로그램 종료