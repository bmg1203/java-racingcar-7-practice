# java-racingcar-precourse

# 어떤 객체가 필요할까?
- [x] 필요한 객체 파악하기
- 사용자의 입력을 받을 `InputView`
- 경주 결과를 알려줄 `OutputView`
- `View`와 `Service` 사이의 중재자 `RacingController`
- 메인 로직이 수행될 `RacingService`
- 하나의 차 정보가 저장될 `Car`
- 경주에 참여할 차들의 정보가 저장될 `Cars`
- 경주를 담당할 `Racing`

# 기능 목록

### 1. 입력 로직
- [x] 경주에 참여할 자동차들을 입력받는다.
- [x] 시도 횟수를 입력받는다.
- [x] 자동차의 이름을 `,`를 이용하여 구분한다.

### 2. 경주 로직
- [x] Racing, Cars, Car 객체 구현
- [x] 0 ~ 9 의 난수를 구하여 4 이상의 자동차 전진시키기
- [x] 매 경기 기록 저장
- [x] 레이싱 우승 차 구하기

### 3. 출력 로직
- [x] 경기 기록 및 우승 자동차이름 출력

# 예외 상황

### 1. 자동차 이름 관려 예외
- [ ] 자동차 이름이 중복된 경우 ex) `pobi,pobi,pobi`
- [ ] (고민필요) 공백이 포함된 경우 ex) `pobi, jason, alice`
### 2. 시도횟수 관련 예외
- [x] 시도횟수가 `0`이 입력된 경우 ex) `0`
- [x] 시도횟수가 숫자가 아닌 경우 ex) `a`, `,`