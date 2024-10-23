# 자동차 경주

## 기능 구현 목록

- [x]  경주할 자동차들의 이름을 입력받는다.
    - [x] 사용자의 입력을 읽는다.
    - [x]  쉼표 기준으로 구분
    - [x] 구분자 내에 공백이 있을 경우, 차 이름을 잘못 입력했기 때문에 `IllegalArgumentException`을 발생시킨다.
    - [x]  이름은 5자 이하만 가능하다.
        - [x]  6자 이상일 경우, `IllegalArgumentException` 을 발생시킨다.
- [x]  시도할 횟수를 입력한다.
    - [x] 사용자의 입력을 읽는다.
    - [x] 숫자 입력 시, 최대 9,999의 양수로 기능을 제한한다.
        - [x]  범위 해당 안될 시, `IllegalArgumentException` 을 발생시킨다.
- [ ]  자동차를 전진시키거나 유지한다.
    - [ ]  0에서 9 사이의 무작위 값을 구한 후 4 이상인 경우 전진시킨다.
    - [ ]  차수별 실행 결과를 출력한다.
- [ ]  우승자를 출력한다.
    - [ ]  단독 우승자를 출력한다.
    - [ ]  공동 우승자가 존재할 경우, 쉼표를 이용하여 구분한다.
