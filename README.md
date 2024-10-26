# java-racingcar-precourse

## 2주차 - 자동차 경주

## 🎯 목표
1. 메서드 분리를 철저히 한다.
    - 각 메서드는 15줄을 넘기면 안되며, 하나의 기능만 수행
    - 메서드명은 의미있고 목적을 나타내야 함
2. 테스트 코드
    - 하나의 기능이 완성되면 테스트 코드를 통해 검증
    - 다양한 예외사항에 따른 테스트 케이스를 고려
3. MVC 패턴
    - MVC 패턴을 적용해 각 패키지를 의미 있게 구분한다.
    - MVC 패턴에서 사용하는 각 클래스의 역할과 책임을 분리한다.

---
## 1주차 코드 리뷰 피드백
- 명확하고 의미있는 변수, 메서드, 클래스 네이밍
- 상수 처리
- 메서드 분리
- static 메서드 사용 이유
- 단일 책임 원칙과 관심사 분리
---

## 🚀 기능 목록
### 1. 무작위 숫자 생성 기능
- [X] 0~9 사이의 무작위 숫자를 반환한다.

### 2. 자동차 기능
- [X] 자동차는 이름을 갖는다.
  - [X] `예외사항` : 이름이 null 또는 빈 문자열인 경우 예외 발생
  - [X] `예외사항` : 이름이 한글, 영어가 아닌 경우 예외 발생
  - [X] `예외사항` : 이름이 5자 이하가 아닌 경우 예외 발생
- [X] 자동차는 위치를 갖는다.
- [X] 자동차는 조건에 따라 이동 또는 정지한다.
  - [X] 랜덤 숫자가 4 이상인 경우 전진

### 3. 자동차 목록 기능
- [X] 자동차 목록에 대한 유효성 검사를 한다.
    - [X] `예외사항` : 자동차가 1대 미만, 또는 10대 초과인 경우 예외 발생
    - [X] `예외사항` : 자동차 이름이 중복된 경우 예외 발생
- [X] 무작위 숫자를 통해 자동차를 이동한다.
- [X] 모든 자동차의 이름, 위치 정보를 반환한다.

### 4. 자동차 이름 파싱 기능
- [X] 자동차 이름은 쉼표(,)를 기준으로 파싱한다.
    - [X] `예외사항` : null 또는 빈 문자열인 경우 예외 발생
    - [X] `예외사항` : 쉼표(,)로 구분할 수 없는 경우 예외 발생

### 5. 경주 게임 기능
- [X] 게임을 세팅한다.
- [X] 게임을 진행한다.
    - [X] 라운드를 진행하고 결과를 반환한다.
    - [X] 게임 종료 여부를 판단한다.
    - [X] 다음 라운드를 진행한다.
- [X] 게임 우승자를 반환한다.
  - [X] 가장 멀리 이동한 자동차가 우승한다.
  - [X] 우승자는 한 명 이상일 수 있다.

### 6. 출력 기능
- [X] 자동차 이름 입력 요청 메시지를 출력한다.
- [X] 게임 횟수 입력 요청 메시지를 출력한다.
- [X] 라운드별 게임 결과를 출력한다.
    - [X] `이름 : {이동거리}` 에서 이동거리는 `-`로 나타낸다.
    - [X] 입력한 순서대로 이름을 나타낸다.
- [X] 최종 우승자 이름을 출력한다.
    - [X] `최종 우승자 : {이름, 이름, ..]`

### 7. 입력 기능
- [ ] 자동차 이름을 입력 받는다.
    - [ ] `예외사항` : 공백인 경우 예외 발생
- [ ] 게임 시도 횟수를 입력 받는다.
    - [ ] `예외사항` : 공백인 경우 예외 발생
    - [ ] `예외사항` : 숫자가 아닌 경우 예외 발생
    - [ ] `예외사항` : 1~15 사이의 숫자가 아닌 경우 예외 발생

--- 

## ⚙️ 테스트 목록
### 1. NameTest
- 이름이 null 또는 빈 문자열인 경우 예외 발생 테스트
- 동일한 값인 경우 equals, hashCode 반환값 동등성 테스트
- 이름이 영어 또는 한글이 아닌 경우 예외 발생 테스트
- 이름이 5자를 초과하는 경우 예외 발생 테스트

### 2. PositionTest
- 기본 위치 값 테스트
- 위치 이동 테스트
- 위치 비교 테스트

### 3. CarTest
- 같은 이름인 경우 자동차 동등성 테스트
- 이동 조건에 따른 정지, 전진 테스트
- 위치 조건에 따른 자동차 위치 동등성 테스트

### 4. CarsTest
- 자동차가 1대 미만인 경우 예외 발생 테스트
- 자동차가 10대 초과인 경우 예외 발생 테스트
- 중복된 이름의 자동차가 존재할 경우 예외 발생 테스트
- 모든 자동차의 이름, 위치 반환 테스트

### 5. StringSplitterTest
- null 또는 빈 문자열인 경우 예외 발생 테스트
- 문자열을 쉼표로 분리 가능한 경우 테스트
- 문자열 앞 뒤에 쉼표가 존재할 경우 예외 발생 테스트
