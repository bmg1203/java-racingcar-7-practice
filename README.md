# java-racingcar-precourse

## 프로그래밍 요구 사항 2
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.  
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.  
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.  
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.  
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.  
  - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.  

## 라이브러리
camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 구현 기능 목록
- [x] 자동차 이름 입력
- [x] 시도 횟수 입력
- [x] 매 턴 실행 결과 출력
- [x] 우승자 출력
- [x] 참가 차량 그룹 생성
- [x] 참가 차량 그룹 전진
- [x] 차량 전진
- [x] 우승자 선정


## 구현 클래스(계층 ver)  
RacingController
- InputView
- OutputView
- RacingService
  - CarCollectionFactory
    - Processor
      - SimpleDelimiterProcessor
    - CarCollection
    - AbstractCarFactory
      - RandomCarFactory
        - Car
          - Engine
            - RandomEngine

생각
1. Engine만 갈아끼면 RandomCar로 바꿀 필요가 없다!

고민
1. CarCollection이 우승자를 알아야 하는가?
   알아야 한다. CarCollection은 일급 컬렉션이다. 자기가 지닌 데이터에 대한 책임을 진다.
2. CarCollection이 들고있는 실행 결과를 어떻게 출력할 것인가?
   OutputView를 CarCollection에 주입하는 것은 좋지 않다. CarCollection은 출력에 대한 책임을 지지 않는다.
  그럼 어떻게 해야할까? 
3. OuptutView가 CarCollection을 알아야 하는가?
4. Engine의 accelrate()가 boolean을 반환하는 것이 좋은가?
  안 좋은 것 같다. Engine이 boolean을 반환하면 Car는 자신의 상태변화를 조건문으로 제어해야 한다.
  ```java
    public class Car {
        public void move() {
            if (engine.accelerate()) {
                position++;
            }
        }
    }
  ```
  이렇게 되면 Car.move()를 테스트하기 어렵게된다.(Mock Engine을 주입받으면 되긴한다.)
  애초에 생각을 다시 해보면, 차가 move()를 호출했는데 