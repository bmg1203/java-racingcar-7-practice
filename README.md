# 프리코스 2주차 - 자동차 경주 게임

## 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차는 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 구현해야 할 기능 목록
- [x] 경주할 자동차 이름들을 입력받는다. (이름은 쉼표 기준으로 구분)
- [x] 몇 번을 이동할 것인지(시도 횟수)를 입력 받는다.
- [x] 매 시도 마다 자동차 별로 0~9 사이에서 무작위 값을 구한 후, 4 이상일 경우에만 전진시킨다.
- [x] 완료한 후 누가 우승했는지 출력한다. 우승자는 두 명 이상일 수 있다. (여러 명일 경우 쉼표로 구분)
- [ ] 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션 종료.
  - [ ] 자동차 이름을 입력하지 않을 경우
  - [ ] 자동차 이름을 하나만 입력할 경우
  - [ ] 시도 횟수를 입력하지 않을 경우
  - [ ] 시도 횟수가 0이거나 음수일 경우
- [ ] 테스트 케이스 작성

## 프로그래밍 요구사항
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- indent depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 기능이 정상 작동하는지 테스트 코드로 확인한다.
- 값 입력은 `camp.nextstep.edu.missionutils.Console`의 `readLine()` 메소드를 사용한다.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 메소드를 사용한다.

