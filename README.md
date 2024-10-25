# java-racingcar-precourse
## 입력
- [x] 첫번째 입력 : 사용자로부터 readline()을 통해 자동차 이름들을 문자열로 입력받는다. 예시) `pobi,woni,jun`
- [ ] 두번째 입력 : 사용자로부터 readline()을 통해 이동시도횟수를 입력받는다. 예시) `5`

<br>

## 입력 예외
- [x] 자동차이름은 영어 대소문자와 숫자만 가능하다. 그 외엔 예외를 발생시킨다.
- [x] 자동차이름은 5자이하만 가능하다. 그 외엔 예외를 발생시킨다.
- [x] 자동차 이름이 없으면 예외를 발생시킨다. ex) `pobi,,son`
- [x] 자동차 개수가 100개 초과이면 예외를 발생시킨다. (자동차개수는 최대 100개로 한다.)
- [x] 자동차들의 이름이 중복되면 예외를 발생시킨다.
- [x] 이동시도 횟수 입력을 받을때 숫자외에 문자가 포함되면 예외를 발생시킨다.
- [x] 이동시도 횟수 입력을 받을때 1~100이 아니면 예외를 발생시킨다. (이동시도 횟수는 최대 100으로 한다.)

<br>

## 플레이
- [ ] 0에서 9 사이의 무작위 값이 4 이상일 경우 전진한다.
- [ ] 각 라운드마다 모든 자동차들의 이름과 전진상태를 출력한다.
- [ ] n번의 라운드를 진행하고 우승자를 출력하는 기능

<br>

## 출력
- [ ] 현재까지 모든 자동차들에 이동상태를 출력한다.
- [ ] 우승자 출력 : 가장 멀리 전진한 자동차를 출력한다. 예시) `최종 우승자 : pobi`
	 
