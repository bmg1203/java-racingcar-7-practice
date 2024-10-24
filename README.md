# java-racingcar-precourse

**입력 기능**

- [ ]  쉼표로 구분된 자동차(들)의 입력을 받는다.
- [ ]  시도할 횟수를 입력 받는다.

**출력 기능**

- [ ]  회차별 출력을 한다. 형식은 : 이름 : (총 전진 회수) * -
- [ ]  우승자를 출력한다.

**경주 기능**

- [ ]  입력 값을 정제한다.
- [ ]  자동차의 개수를 구한다.
- [ ]  자동차별 무작위 값을 구한다
    - [ ]  무작위 값이 4이상인지 구한다
- [ ]  자동차별 전진 상태를 출력한다
    - [ ]  전진 상태는 입력 순서로 출력한다.
    - [ ]  각 라운드 사이에 개행을 출력한다.
- [ ]  우승자를 판별한다
- [ ]  우승자가 여러명일 경우 공동 우승자를 판별한다
    - [ ]  우승자는 입력 순서로 출력한다

**예외 처리 기능**

- [x]  자동차의 이름이 입력 되었는지 확인한다
- [x]  자동차의 이름이 중복되었는지 확인한다
- [x]  자동차의 이름이 비어있는지 확인한다
- [ ]  자동차 이름에 특수문자 혹은 숫자가 입력되었는지 확인한다
- [ ]  , 외에 다른 방법으로 구분되었는지 확인한다
- [ ]  시도할 횟수가 숫자인지 확인한다
- [ ]  시도할 횟수가 0 혹은 음수인지 확인한다.
- [ ]  자동차 이름이 5글자 이하인지 확인한다.
- [ ] , 로 끝나는 경우

**Test**
- [x] 정상 입력 (pobi,woni,jun) , 5
- [x] 공동 우승 
- [ ] 아무도 전진하지 않은 경우 



**UnitTest**
- [x] 시도 횟수 음수 : IllegalArgumentException
- [x] 시도 횟수 숫자가 아닌 경우 : IllegalArgumentException
- [x] 빈 자동차 : IllegalArgumentException
- [x] 이름 사이에 공백이 포함 : IllegalArgumentException
- [x] 자동차 이름 5자 이상 : IllegalArgumentException
- [x] 이름에 공백이 포함 : 양끝 -> 정상 출력
- [x] 렌덤값이 4 이상만 전진
- [x] 렌덤값 생성기 테스트