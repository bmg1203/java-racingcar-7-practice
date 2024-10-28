# java-racingcar-precourse

## 미션 주제 : 자동차 경주
초간단 자동차 경주 게임을 구현한다.

## 기능 구현 목록
- [X] 자동차 이름을 입력받는 기능
- [X] 자동차 이름을 쉼표로 구분하는 기능
- [X] 경기 진행 횟수를 입력받는 기능
- [X] 경기 진행마다 경기를 실행하는 기능
- [X] 경기 진행별 실행결과를 출력하는 기능
- [X] 경기 결과를 계산하는 기능
- [X] 경기 결과를 출력하는 기능

## 기능 요구사항
- [X] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [X] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [X] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [X] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [X] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [X] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [X] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. 
- [X] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## I/O 요구사항
### 입력
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
> pobi,woni,jun

- 시도할 횟수
> 5

### 출력
- 차수별 실행 결과
> pobi : --\
woni : ----\
jun : ---

- 단독 우승자 안내 문구
>최종 우승자 : pobi

- 공동 우승자 안내 문구
>최종 우승자 : pobi, jun

### 실행 결과 예시
>경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\
pobi,woni,jun\
시도할 횟수는 몇 회인가요?\
5\
\
실행 결과\
pobi : -\
woni :\
jun : -\
\
pobi : --\
woni : -\
jun : --\
\
pobi : ---\
woni : --\
jun : ---\
\
pobi : ----\
woni : ---\
jun : ----\
\
pobi : -----\
woni : ----\
jun : -----\
\
최종 우승자 : pobi, jun

## 프로그래밍 요구사항1
- [X] JDK 21 버전에서 실행 가능해야 한다.
- [X] 프로그램 실행의 시작점은 Application의 main()이다.
- [X] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [X] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [X] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [X] 자바 코드 컨벤션을 지키면서 프로그래밍한다.

## 프로그래밍 요구사항2
- [X] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [X] 3항 연산자를 쓰지 않는다.
- [X] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [X] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- [X] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- [X] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.