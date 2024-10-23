# java-racingcar-precourse

## ✨ 작성자
> JGoo99

<br/>

## ✨ 과제 요구사항
- [x] : 기능 목록 정리
- [ ] : 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가

<br/>

## ✨ 기능 요구사항

### 역할
- 사용자 : 경주할 **자동차 리스트**와 **시도할 횟수**를 입력한다.
- 자동차 : n 회 자동차를 이동하는 모습과 우승한 자동차를 출력한다.

### 흐름도
1. 사용자가 자동차 리스트를 입력한다.
2. 사용자가 시도할 횟수를 입력한다.
2. 입력 받은 자동차를 등록한다.
3. 시도 횟수 만큼 자동차 경주를 진행한다.
4. 자동차 경주 실황을 출력한다.
5. 최종 우승자를 출력한다.

### 기능 리스트
- [ ] : 사용자에게 자동차 이름 리스트와 시도할 횟수를 입력받는다.
- [ ] : 자동차 객체를 만든다. (이름, 전진 횟수)
- [ ] : 자동차 이름을 초기화한 자동차를 자동차 리스트에 등록한다.
- [ ] : 자동차 정보를 출력한다. (이름, 경주 현황)
- [ ] : 0 에서 9 사이의 무작위 값을 구한다.
- [ ] : 무작위 값이 4 이상일 경우 전진 횟수를 증가시킨다.
- [ ] : 전진 횟수를 기준으로 우승자를 판별한다. (한 명 이상 가능)
- [ ] : 우승자를 출력한다. (여러명일 겨우 쉼표 구분)

<br/>

## ✨ 프로그래밍 요구사항
- [ ] : indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- [ ] : 3항 연산자를 쓰지 않는다.
- [ ] : 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] : JUnit5 와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- [ ] : Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- [ ] : 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.