# java-racingcar-precourse

## - 학습 목표
- 여러 역할을 수행하는 큰 함수를 단일 역할을 하는 작은 함수로 분리하는 법 익히기
- 테스트 도구를 사용하는 방법을 배우고, 프로그램이 제대로 작동하는지 테스트하기
- 1주 차 공통 피드백 최대한 반영하기
- TDD로 개발하기
- JDK 21의 신기능 적용해보기

## - 기능 요구사항
**기능 핵심 : 입력받은 자동차 이름과 이동 횟수를 가지고 자동차 경주 게임을 구현한다.**
- [x] 각 자동차에 이름을 부여할 수 있다.
  - [x] 이름은 5자 이하만 가능하다.
  - [x] 각 자동차는 전진할 수 있다.
- [x] 사용자에게서 자동차 이름을 입력받는다.
- [x] 자동차 이름은 쉼표로 구분한다.
- [x] 사용자는 몇 번 이동할 건지 입력할 수 있다.
  - [x] 입력받은 횟수동안 N대의 자동차는 전진 혹은 멈출 수 있다.
  - [x] 매번 자동차들의 이름과 위치를 출력한다.
- [x] 자동차가 전진하는 조건은 0에서 9사이의 무작위 값에서 4 이상인 경우이다.
- [x] 입력받은 횟수만큼 완료한 후 누가 우승자인지 알려준다. (공동 우승이 가능하다.)
  - [x] 우승자가 여러명일 경우 쉼표를 이용해서 구분한다.
- [] 잘못된 입력을 할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션 종료한다.
    - [] 자동차 이름으로 빈 값을 입력한 경우 (null, 공백, "" 등)
    - [] 자동차 이름으로 중복된 이름을 입력한 경우 (준기,준기)
    - [] 자동차 이름을 100대 이상 등록한 경우
    - [] 시도할 횟수에 0 이하 2,147,483,648 이상의 숫자를 입력한 경우
    - [x] 시도할 횟수에 숫자가 아닌 값을 입력한 경우

## - 입출력 요구사항
- [x] 입력
  - [x] 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분 (예: pobi,woni,jun))
  - [x] 시도할 횟수 (문자가 아닌 양수 (예: 1, 2, 3))
- [] 출력
  - [] 차수별 실행 결과 (pobi : --)
  - [] 우승자 안내 문구
    - [] 단독일 경우 (최종 우승자 : pobi)
    - [] 공동일 경우 (최종 우승자 : pobi, jun)

## - 프로그래밍 요구사항
- [] JDK 21 버전에서 실행 가능해야한다.
- [] 프로그램 실행의 시작점은 Application의 main() 이다.
- [] 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [] 프로그램 종료시 System.exit()를 호출하지 않는다.
- [] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [] 자바 코드 컨벤션을 준수한다. (Java Style Guide를 원칙으로 한다.)
- [] 사용자 입력은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
- [] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- [] 들여쓰기 깊이는 3이 넘지 않도록 구현한다. (깊이 2까지 가능하다.)
- [] 3항 연산자는 사용하지 않는다.
- [] 함수가 한 가지 일만 하도록 최대한 작게 만든다.
- [] 정리한 기능이 정상적으로 작동하는지 테스트 코드로 확인한다. (JUnit, AssertJ 이용)