# 자동차 경주 게임

## 🚀 미션 설명

### 개요

- `경주할 자동차 이름들`과 `이동 시도 횟수`를 입력받아 시도 횟수 동안 `자동차 경주`를 진행하고
  `우승자들`을 안내해 주는 `자동차 경주 게임 프로그램`이다

> 자동차들은 `차수`마다 `전진` 혹은 `멈춤`이 가능하다.<br>
> 자동차들은 `차수`마다 `60% 확률`로 `전진`한다. <br>
> 전진하지 못 하였을 경우 해당 `차수`에는 멈춰있는다. <br>
> `차수`마다 `경주 결과`를 안내한다

# ✅ 기능 목록 정리

구분자 : `,`

### **⚙️ Model**

**InputValidator**

- [x]  input 유효성 검사 기능
    - [x]  이름의 유효성 검사를 실시한다.
        - [x]  이름이 5 자를 초과할 경우, 예외를 발생 시킨다.
        - [x]  구분자로 구분한 이름에 한글 영어 공백 제외 다른 문자가 포함되어 있을 경우, 예외를 발생 시킨다.
            - [x]  구분한 이름 앞 뒤에 공백이 있을 경우 예외를 발생 시킨다.
        - [x] 이름이 중복일 경우, 예외를 발생시킨다.
        - [x]  `null` 혹은 `빈문자열`이 입력될 경우, 예외를 발생 시킨다.
    - [ ]  시도 횟수의 유효성 검사를 실시한다.
        - [ ]  입력된 시도 횟수가 `숫자`가 아닐 경우, 예외를 발생 시킨다.
        - [ ]  입력된 시도 횟수가 `int`범위를 넘을 경우, `long`으로 바꿔준다.
        - [ ]  입력된 시도 횟수가  `long`범위를 넘을 경우, 예외를 발생 시킨다.

**Car**

- [x]  이동하는 기능
    - [x]  무작위 값이 4 이상일 경우, 전진한다.

**RacingRecord**

- [x]  차량들의 경주 상황을 기록하는 기능
    - [x] 매 차수마다 각 차량들의 누적 전진 거리를 저장한다.

**CarsGenerator**

- [x]  입력된 이름들에 따라 차량들을 생성하는 기능
    - [x]  차량을 생성한다.
    - [x]  이름들에 따라 생성된 차량들을 `List<Car>`로 만들고 반환한다.

**RacingGameJudge**

- [x]  우승자들을 판별하는 기능
    - [x]  우승자들을 판별한다.
    - [x]  우승자들을 구분자로 구분된 문자열로 반환한다.

**RacingGame**

- [x]  무작위 값들을 생성하는 기능
- [x]  해당 차수의 무작위값들을 통해 차량들을 움직이는 기능
    - [x] 무작위 값이 유효 범위를 벗어날 경우 예외를 발생 시킵니다.

---

### **💻 View**

**InputView**

- [x]  이름 입력 요청 메세지를 출력하는 기능
- [x]  이름 문자열을 입력 받는 기능
- [x]  시도 횟수 입력 요청 메세지를 출력하는 기능
- [x]  시도 횟수를 입력 받는 기능

**OutputView**

- [ ]  차수별 실행 결과를 출력하는 기능
- [ ]  우승자 안내 문구를 출력하는 기능
    - [ ]  공동, 단독 우승자 안내 문구 모두 출력이 가능하다.

---

### **🕹️ Controller**

**GameController**

- [ ]  게임을 진행하는 기능
    - [ ]  게임을 시작한다.
    - [ ]  입력된 이름을 전달한다.
    - [ ]  경주를 진행한다.
    - [ ]  경주 결과를 전달한다.

---

# 🤔 잘못된 입력 ??

- 빈칸 or 특수 문자도 이름으로 볼 것인가?
    - 이름이라고 명시되어 있으니 허용하지 않음(한글 영어 제외 불가능)
    - 중간 공백은 가능 함 ex) Tom H, Son H
        - 공백만 있는 건 허용되지 않음
        - `,` 기준으로 구분한다고 했으니 `,` 로 구분된 문자열 자체가 이름이 됨
            - 앞 뒤 공백은 허용되지 않음
    - 나머지는 허용하지 않음
- 중복 이름 어떻게 처리할 것인가?
    - 이름이니까 같은 이름 가질 수 있다고 가정함
    - 우승자 출력 시 구분할 수 없음
        - 차량 이름이니 숫자를 허용 <br> → 이름이 중복됨을 알리고 숫자 및 대소문자를 통해 중복 이름을 구분하라고 고지하며 예외 발생