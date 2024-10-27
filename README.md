# java-racingcar-precourse

## 요구사항

---

### 기능 요구 사항

---

- 자동차 경주 게임을 구현한다
- n대의 자동차에 각각 이름을 부여할 수 있다
    - 자동차 이름은 쉼표(,)를 기준으로 구분한다
    - 자동차 이름의 길이는 5자 이하이다
- n대의 자동차들은 전진 또는 멈출 수 있다.
    - 자동차가 전진하는 조건은 0~9 사이의 무작위 값을 구한 후 그 값이 4 이상인 경우 전진한다
    - 전진하는 자동차를 출력할 때 자동차 이름도 같이 출력한다
- 자동차 경주 게임을 완료한 경우 누가 우승했는지를 알려준다, 우승자는 한 명이상일 수 있다
    - 만약 우승자가 여러 명일 경우 쉼표(,)를 구분하여 출력해준다.

### 프로그래밍 요구 사항

---

- 자바 코드 컨벤션을 지키면서 프로그래밍을 한다
- indent depth는 최대 2까지 허용한다
- 3항 연산자를 사용하지 않는다
- 함수와 메서드가 한 가지 일만 하도록 만든다
- 정리한 기능이 정상적으로 작동하는지 테스트 코드로 확인한다

## 기능 목록 리스트

---

- [ ] 전체적인 기능을 관리하는  GameManager 클래스
- [x]  자동차들을 관리하는 CarFactory 클래스
- [x]  자동차 Car 클래스
- [x]  문자열을 분리하는 SplitSplitter 클래스
- [x]  입력, 출력 클래스
- [x]  검증 클래스
    - [x]  경주할 자동차 이름 받기
        - [x] 문자열을 나누고 나서 이름이 완전 공백일 때
        - [x] 이름의 길이가 5 초과 일 때
    - [x]  시도할 횟수 입력 받기
        - [x]  숫자가 아닐 때
        - [x]  양수의 정수가 아닐 때
- [ ] 테스트
  - [x] 문자열 분리 테스트
  - [x] Car 생성 테스트
  - [x] CarList 생성 테스트