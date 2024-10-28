# java-racingcar-precourse



## 구현할 기능 목록

### n대의 자동차 입력받고 저장하기
### 주어진 횟수(이동 횟수) 입력받고 저장하기
### 자동차 전진 또는 멈춤(랜덤값)
### 차수별 실행 결과 출력하기
### 우승자 출력하기
### 예외 처리
 - 자동차 이름이 5자를 넘을 경우
 - 자동차 이름을 입력하지 않을 경우 (ex. null, "")
 - 이동 횟수 입력시 숫자를 입력하지 않을 경우 (ex. "m")
 - 이동 횟수를 입력하지 않을 경우 (ex. null, 0)

+ 그 외 상황
 - 이동 횟수 입력시 앞에 0을 붙일 경우 (ex. 025) -> 그대로 진행
 - 자동차 이름을 한 개만 입력할 경우 -> 그대로 진행
 - 자동차 이름 중간에 공백이 있는 경우 (ex. "a,,b") -> 공백 제외하고 그대로 진행 (a, b)

## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.