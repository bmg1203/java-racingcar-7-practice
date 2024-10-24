<p align="center">
  <img src="https://github.com/YeonjiIsGonji/java-calculator-7/blob/YeonjiIsGonji/%E1%84%8B%E1%85%AE%E1%84%90%E1%85%A6%E1%84%8F%E1%85%A9%20%E1%84%85%E1%85%A9%E1%84%80%E1%85%A9.png?raw=true">
</p>

# 자동차 경주

## 프로그래밍 요구 사항
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

## 기능 목록
**1. 입력 기능**
- 사용자가 콘솔창에 입력한 경주할 자동차들의 이름을 입력 받는다.
- 사용자가 콘솔창에 입력한 시도할 횟수를 입력 받는다.

**2. 유효성 검사 기능**
- 입력된 경주할 자동차들의 이름이 유효한지 확인한다.
  - 유효한 입력인 경우
    - 자동차의 이름은 5자 이하여야 한다.
    - 자동차의 이름은 쉼표(,)를 기준으로 구분한다.
    - 자동차의 이름은 사용자의 주관이므로 그 이름에 숫자나 그 외 문자가 포함되어도 적절한 이름이라고 판단한다. 
  - 그 외의 경우 IllegalArgumentException 를 발생한다.
    - ',,' 와 같이 자동차 이름이 입력되지 않은 경우
    - 쉼표(,)가 아닌 다른 구분자를 사용한 경우
    - null 값이 입력된 경우
    - 이름이 중복 입력된 경우
    - 쉼표(,)로 끝나는 경우
- 시도할 횟수가 유효한지 확인한다.
  - 유효한 입력의 경우
    - 1 이상의 양의 정수가 들어온다.
  - 그 외의 경우 IllegalArgumentException 를 발생한다.
    - 0이 입력된 경우
    - 소수가 입력된 경우
    - 음수가 입력된 경우
    - null 값이 입력된 경우

**3. 경주 기능**
- 경기는 사용자가 입력한 횟수만큼 반복한다.
- 1 경기 당 모든 자동차가 참여하며, 각 자동차별로 이동을 체크한다.
  - 컴퓨터에서 무작위 값 randomNumber 를 추출한다.
  - randomNumber >= 4이면 전진(- 추가)
  - randomNumber < 4이면 stop
- 모든 자동차의 이동이 체크되면, 자동차의 이름과 결과를 출력한다.

**4. 우승자 확인 기능**
- 자동차별 이동 횟수를 센다.
- 가장 많은 이동을 한 자동차가 우승자이다.
- 가장 많은 이동 횟수를 한 자동차가 여러 대이면, 공동 우승이다.

**5. 출력 기능**
- 우승자를 출력한다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 이름을 구분하고 출력한다.
