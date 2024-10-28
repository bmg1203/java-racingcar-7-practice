# 💪 프로젝트 개요

- 초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

# 📝기능 목록

### 프로그램 상수 설정(RacingConstant)
- [x] 이름 구분자(,) 설정
- [x] 전진 조건 관련 범위 및 조건 상수 설정
- [x] 전진을 표시하는 문자(-) 설정
- [x] 이름 사이즈 조건 상수 설정

### 사용자가 자동차 이름을 입력 받는 기능(InputView)
- [x] 자동차의 이름들을 받아온다.
  - [x] null을 받아오거나 Console이 닫혀 있는 경우 error를 보낸다.

### 전진을 시도할 횟수를 입력 받는 기능(InputView)
-  [x] 시도할 횟수 n을 얻는다.
  - [x] 양의 정수여야한다.
  - [x] 정수가 아닌 다른 문자가 오면 안된다.
  - [x] 빈 문자열 및 null을 받을 수 없다.

### 메시지를 출력하는 기능(OutputView)
- [x] 게임을 시작할 때 메시지 "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"를 출력한다.
- [x] 전진 횟수를 입력하라는 메시지 출력 "시도할 횟수는 몇 회인가요?"
- [x] 우승자를 출력하는 메시지를 위해 CarDto List를 받아와 출력한다.

### 문자열에서 자동차 이름을 추출하는 기능(ParseCarNames)
- [x] 자동차 이름을 쉼표(,)를 기준으로 추출한다.

### 자동차 객체 기능(Car)
- [x] 생성자를 통해 이름을 받아오는 기능
- [x] carDTO를 만드는 기능
- [x] 위치를 비교하는 함수
- [x] 자동차의 위치를 이동 시키는 기능
  - [x] 0~9 사이의 랜덤 숫자를 각각 자동차마다 발생시켜 4 이상이면 이동
- [x] 이름 관련 유효성 검사
  - [x] 이름은 5글자 이하이다.
  - [x] 이름은 " " 빈 공백으로만 이루어져있으면 안된다.
  - [x] 숫자, 문자, 특수 문자에 제한이 없다.
  
### 자동차의 정보를 CarDto에 담아 보내는 기능(Car)
- 자동차의 이름과 위치를 담은 객체를 만든다.

### 자동차 객체들을 담는 객체(Cars)
-  [x] 자동차들을 n번 이동 시키는 기능

### 우승자를 찾는 기능(Cars && Car)
- [x] Car 객체의 position을 get으로 얻어오지 않고 우승자를 찾는 기능
  - [x] Car 객체 끼리 비교하는 함수 생성
  - [x] Cars 객체에서 Car 객체의 비교 함수를 통해 우승자를 찾는다.

# 프로젝트 구성
- RacingConstant : Racing 게임 관련 상수 관리
- RacingController : 데이터 전달 및 중계
- Car : 자동차에 관한 정보를 담는 객체
- Cars : 자동차를 관리하는 일급 컬렉션
- InputView : 입력을 담당하는 class
- OutputView : 출력을 담당하는 class