# 🏎 자동차 경주
- - -

## 🚀 기능 요구 사항
- - -
### <초간단 자동차 경주 게임 구현>
- 주어진 횟수 동안 n대의 자동차가 전진 or 멈춤
  - 사용자는 몇 번의 이동을 할 것인지 입력 가능
- 각 자동차에 이름 부여 가능
  - 전진하는 자동차 출력 시 자동차 이름을 함께 출력
- 자동차 이름은 `,`를 기준으로 구분
  - 이름은 5자 이하만 가능
- 전진 조건: 0과 9 사이 무작위 값을 구한 후 무작위 값이 4 이상일 경우
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 활용
- 경주 완료 후 우승자를 알림
  - 우승자는 한 명 이상
  - 여러 명일 경우 `,`를 이용하여 구분
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생 후 애플리케이션 종료
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용

## 📃 추가된 프로그래밍 요구 사항
- - -
- indent depth는 2까지만 허용
- 삼항연산자 금지
- 메서드가 한 가지 일만 하도록 최대한 분리
- JUnit 5와 AssertJ를 이용해 기능 테스트

## 📂 패키지 구조
- - -
```
📂 racingcar
 ├── 📂 controller
 │     └── RaceController
 ├── 📂 domain
 │     ├── 📂 car
 │     │     ├── Car
 │     │     ├── MoveStrategy
 │     │     └── RandomMoveStrategy
 │     └── 📂 race
 │           ├── Race
 │           └── RaceResult
 ├── 📂 error
 │     └── ErrorMessage
 ├── 📂 util
 │     ├── Parser
 │     └── Validator
 ├── 📂 view
 │     ├── InputView
 │     └── OutputView
 └── Application
```


## 📌 계획
- - -
- 자동차 경주의 흐름 확인
- 패키지 구조 설계
- 구현할 기능 목록 정리
- README.md 작성
- 프로젝트 초기 설정
- 구현
- 예외 처리에 대한 검토
- 테스트 코드 작성

## 💡 구현할 기능 목록
- - -
### 1. 입력
- [x] 자동차 이름 입력 받기
  - [x] `,` 기준으로 구분하여 입력 받음
  - [x] 빈 문자열이나 `null`, 공백만 입력한 경우 예외 처리
  - [x] 이름의 길이가 1자 이상, 5자 이하인지 확인
  - [x] 조건에 부합하지 않을 경우 예외 처리

- [x] 이동 횟수 입력 받기
  - [x] 1부터 100까지의 정수인지 확인
  - [x] 조건에 부합하지 않을 경우 예외 처리

### 2. 자동차 생성 및 초기화
- [x] 자동차 객체 생성
  - [x] 입력받은 이름을 기준으로 자동차 객체 생성
  - [x] 각 자동차는 이름과 초기 위치인 0을 가짐
- [x] 이동 전략 설정
  - [x] 이동 조건 _(랜덤 값 >= 4일 때 전진)_ 을 구현
  - [x] 각 자동차에 전략으로 설정

### 3. 경주 진행
- [x] 입력된 횟수만큼 경주 과정 반복
- [x] 각 자동차 이동
  - [x] 랜덤 값에 따라 전진 또는 멈춤을 결정
  - [x] 이동 조건에 맞는 경우 위치를 1 증가
  - [x] 추후 출력을 위한 각 시도별 이동 결과 저장

### 4. 결과 출력
- [x] 시도별 경주 상태 출력
  - [x] 각 시도가 끝날 때마다 모든 자동차의 현재 위치 출력
  - [x] 자동차의 이름과 위치를 함께 출력
- [x] 최종 우승자 출력
  - [x] 경주가 끝난 후 가장 멀리 이동한 자동차를 우승자로 출력
  - [x] 우승자가 여러 명일 경우 `,`로 구분하여 출력

### 5. 테스트 작성
- [ ] 단위 테스트
  - [x] 자동차 이동 조건을 만족하는 경우 위치가 올바르게 증가하는지 테스트
  - [x] `Parser`의 메서드에 대한 테스트
  - [x] `Validator`의 유효성 검사 메서드에 대한 테스트
- [x] 통합 테스트
  - [x] 경주 전체 흐름이 올바르게 작동하는지 입력과 출력 테스트

### 6. 구조 개선 및 리팩토링
- [ ] 메서드 분리: 각 메서드는 한 가지 일만 하도록 분리
- [ ] 책임 분리: 각 클래스와 메서드가 단일 책임 원칙을 따르도록 구조 개선
- [ ] 자동차 수의 제한
- [x] 이동 시도 횟수의 제한

## 🤔 생각의 흔적
- - -

### 경주의 흐름
1. 경주할 자동차의 이름을 입력 받는다.
2. 이동 횟수를 입력 받는다.
3. 남은 이동 횟수가 1 이상일 경우 이동을 시도한다.
4. 이동했을 경우 차수별 실행 결과를 출력한다.
5. 남은 이동 횟수가 0이 되면 우승자를 출력한다.

### 고민한 부분
- 객체에는 어떤 것들이 있을까?
- 어느 디자인 패턴으로 패키지 구조를 설정할까?
- 클래스를 어떻게 나눌 수 있을까?
- 결과 출력 시 텀을 주어 재미를 더하는 것은 어떨까?
- 자동차 수, 이동 시도 횟수에 제한을 두는 것이 좋겠다.
- 예외 처리할 경우를 생각해 보자.