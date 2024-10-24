# java-racingcar-precourse

<br>

# 🚀 미션 간단 설명
n대의 자동차가 주어진 횟수 동안 4 이상일 때 전진하는 조건으로 경주를 진행하며, 게임 종료 후 가장 멀리 간 우승자를 출력하는 프로그램을 구현하는 미션입니다. 

<br>

## 🔒 제약사항 (1)
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.

## 🔒 제약사항 (2)
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
  - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
    - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
    - [AssertJ User Guide](https://assertj.github.io/doc/)
    - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
    - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### 💡 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
---
<br>

# 🛠 구현할 기능 목록
- 자동차 경주 시작 함수
- 사용자로부터 입력받는 함수
  - 경주할 자동차 이름을 입력받는 함수
  - 시도할 횟수를 입력받는 함수**
- 입력한 값이 잘못된 값인지 체크하는 함수 (잘못된 값을 입력시 `IllegalArgumentException` 발생)
  - 경주할 자동차 이름 입력시 형식 확인
    - 빈 문자열인지 확인하는 함수
    - 쉼표가 연속인지 확인하는 함수
    - 쉼표가 시작/끝인지 확인하는 함수
    - 쉼표가 아닌 다른 문자로 구분되어 있는지 확인하는 함수**
    - 입력 문자열에 공백이 있는지 확인하는 함수
    - 자동차 이름이 5자 이하인지 확인하는 함수
  - 시도할 횟수 입력시 형식 확인
    - 숫자로 작성 되었는지 확인하는 함수
    - 공백이 있는지 확인하는 함수
- 자동차 경주 진행 함수
  - 0-9에서 무작위 값을 구해 값이 4 이상일 경우 전진하도록 하는 함수
     - 시도 횟수마다 자동차별 랜덤값(0-9)을 부여
     - 랜덤값이 4 이상이면 전진 횟수 +1
  - 자동차별 전진 횟수를 비교하는 함수
     - 시도 회차별 전진 횟수 누적
     - 전진 횟수가 같으면 공동 우승자 처리
     - 가장 많은 전진 횟수를 가진 자동차 우승자 처리
- 시도한 횟수만큼 실행 결과를 출력하는 함수
- 최종 우승자를 출력하는 함수
    - 공동 우승자가 있을 경우 쉼표로 구분

<br>

## 📋 구현 체크
- [ ]  자동차 경주 시작 함수
- [ ]  사용자로부터 입력받는 함수
   - [ ]  경주할 자동차 이름을 입력받는 함수
   - [ ]  시도할 횟수를 입력받는 함수**
- [ ]  입력한 값이 잘못된 값인지 체크하는 함수 (잘못된 값을 입력시 `IllegalArgumentException` 발생)
  - [ ]  경주할 자동차 이름 입력시 형식 확인
     - [ ]  빈 문자열인지 확인하는 함수
     - [ ]  쉼표가 연속인지 확인하는 함수
     - [ ]  쉼표가 시작/끝인지 확인하는 함수
     - [ ]  쉼표가 아닌 다른 문자로 구분되어 있는지 확인하는 함수**
     - [ ]  입력 문자열에 공백이 있는지 확인하는 함수
     - [ ]  자동차 이름이 5자 이하인지 확인하는 함수
  - [ ]  시도할 횟수 입력시 형식 확인
     - [ ]  숫자로 작성 되었는지 확인하는 함수
     - [ ]  공백이 있는지 확인하는 함수
- [ ]  자동차 경주 진행 함수
- [ ]  0-9에서 무작위 값을 구해 값이 4 이상일 경우 전진하도록 하는 함수
   - 시도 횟수마다 자동차별 랜덤값(0-9)을 부여
   - 랜덤값이 4 이상이면 전진 횟수 +1
- [ ]  자동차별 전진 횟수를 비교하는 함수
   - 시도 회차별 전진 횟수 누적
   - 전진 횟수가 같으면 공동 우승자 처리
   - 가장 많은 전진 횟수를 가진 자동차 우승자 처리
- [ ]  시도한 횟수만큼 실행 결과를 출력하는 함수
- [ ]  최종 우승자를 출력하는 함수
   - 공동 우승자가 있을 경우 쉼표로 구분
- [ ] 모든 테스트 케이스가 성공하는지?
- [ ] 자바 코드 컨벤션(Java Style Guide)을 지켰는지?

<hr>

Resources Readme License MIT license Activity Stars 0 stars Watchers 0 watching Forks 0 forks Report repository Releases No releases published Packages No packages published Languages Java 100.0% Footer