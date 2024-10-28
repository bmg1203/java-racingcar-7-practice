# 요구 사항 정리
### 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. 
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 프로그래밍 요구 사항
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다. 
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다. 
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

<br>

# 기능 명세서
- 자동차 이름 입력 기능
  - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능
  - 쉼표 양 옆의 공백이 있는 경우 제거하고 이름으로 반영
  - 자동차 이름은 최대 5개까지 입력 가능
  - 예외
    - 자동차 이름을 5개 이상 작성한 경우 '자동차 이름은 최대 5개까지 입력 가능합니다'라는 메시지를 출력
    - 이름 부분을 비워넣고 입력한 경우 '이름값이 비어있습니다'라는 메시지를 출력
    - 중복된 이름이 존재하는 경우 '중복된 이름이 존재합니다'라는 메시지를 출력
    - 쉼표가 연속으로 두번 이상 쓰인 경우 '구분자는 연속으로 사용될 수 없습니다'라는 메시지를 출력
    - 쉼표가 입력값의 처음이나 마지막 부분에 있는 경우 '구분자는 입력의 시작이나 끝에 위치할 수 없습니다'라는 메시지를 출력
- 이동 횟수 입력 기능
  - 사용자는 자동차들이 몇 번의 이동을 할지 입력 가능
  - 이동 횟수는 최대 10회까지 입력 가능
  - 예외
    - 10 이상의 숫자를 입력 할 경우 '이동 횟수는 최대 10회까지 입력 가능합니다'라는 메시지를 출력
    - 이름 값 부분을 비워둔 경우 '이름값이 비어있습니다'라는 메시지를 출력
    - 숫자가 아닌 값을 입력 할 경우 '유효한 숫자를 입력해야합니다'라는 메시지를 출력
- 자동차 전진 조건
  - 각 자동차는 무작위 값(0~9) 중 4 이상이 나올 경우 전진
  - camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
- 레이스 진행 기능
  - 입력받은 이동 횟수 동안 레이스를 진행
  - 매 차수마다 각 자동차의 이름과 현재 위치를 출력
- 우승자 판별 및 출력 기능 
  - 레이스가 종료된 후 가장 멀리 이동한 자동차를 우승자로 출력
  - 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력

<br>

# 고민한 점과 새로 배운 점
1. 일급 컬렉션의 개념과 적용
- 고민한 점: Cars, RaceProgress와 같은 리스트 형태의 데이터를 어떻게 일급 컬렉션으로 관리할지 고민했습니다.
- 새로 배운 점: 일급 컬렉션을 사용하면 컬렉션과 관련된 모든 로직을 해당 클래스에 응집할 수 있어 가독성이 높아진다는 것을 알게되었습니다. RoundPositions와 같이 의미 있는 이름을 부여함으로써 데이터의 맥락을 더 잘 전달할 수 있었습니다.

2. 불변성과 List.copyOf
- 새로 배운 점: List.copyOf를 통해 외부에서 컬렉션을 수정하지 못하게 보장할 수 있어, 데이터 무결성을 유지하고 예상치 못한 버그를 방지할 수 있다는 것을 알게되었습니다.

3. 입력 검증과 변환 로직의 분리
- 고민한 점: InputValidator와 InputParser의 역할을 분리하는 것이 필요한지, 또 어떤 로직이 어느 클래스에 있어야 할지에 대해 고민했습니다.
- 새로 배운 점: 검증과 변환의 역할을 명확히 분리하면, 코드의 응집도가 높아지고 역할이 명확해진다는 것을 알게되었습니다. InputValidator는 검증에 집중하고, InputParser는 데이터를 필요한 형태로 변환하도록 분리하면서 각 클래스의 책임이 더욱 명확해졌습니다.

4. 의존성 주입을 통한 테스트와 유지보수성 향상
- 고민한 점: InputView에서 InputValidator와 InputParser를 의존성 주입 방식으로 변경하는 이유와 그 이점에 대해 고민했습니다.
- 새로 배운 점: 의존성 주입을 통해 클래스 간 결합도를 낮추고, 필요할 때 다른 구현체로 교체할 수 있어 테스트가 더 용이해진다는 점을 알게되었습니다.

<br>

# 구성 클래스
- constant
  - AppConstants
  - ErrorMessage
  - CommonMessage
- controller
  - RaceController
- model
  - Car
  - Cars
  - RaceProgress
  - RoundPositions
  - RaceResult
- parser
  - InputParser
- service
  - RaceService
- validator
  - InputValidator
- view
  - InputView
  - OutputView
- Application