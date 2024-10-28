# 내가 생각한 추가 요구사항

- 자동차 이름
    - 총 100개의 자동차 이름만 입력 가능합니다.
    - 구분자로 빈칸없이 입력해야 합니다.
    - 1~5자 까지 가능합니다.
    - 중복 가능합니다.
    - 설정을 통해 추가할 수 있습니다 (기본: 한글,영어,숫자만 가능)
    - 한글의 자음, 모음도 사용 가능합니다.
- 시도할 횟수
    - 10000 이하로만 입력 가능합니다.
    - 당연하지만 숫자만 가능합니다.

# 기능 목록

### **입력받는 기능**

- **자동차 이름 입력받기:**
    - 사용자로부터 경주에 참여할 자동차들의 이름을 입력받습니다.
    - 입력 요청 시 안내 메시지를 출력하여 사용자로부터 올바른 입력을 유도합니다.
    - 입력된 값이 빈 공백이 아닌지 검증합니다.
- **시도 횟수 입력받기:**
    - 사용자로부터 자동차 경주를 진행할 시도 횟수를 입력받습니다.
    - 입력된 값이 빈 공백이 아닌지 및 숫자인지 검증합니다.

### **입력된 문자열을 파싱하는 기능**

- **자동차 이름 파싱:**
    - 입력받은 자동차 이름 문자열을 쉼표(`,`)를 기준으로 분리하여 개별 자동차 이름으로 파싱합니다.
    - 각 자동차 이름이 5자 이하인지 검증하여 유효한 이름만 처리합니다.

### **자동차 생성 기능**

- **자동차 객체 생성:**
    - 파싱된 자동차 이름을 기반으로 각 자동차에 해당하는 객체를 생성합니다.
    - 생성된 자동차 객체는 이름과 초기 위치(0)를 갖습니다.

### **이동 판단 및 실행 기능**

- **자동차 전진 여부 판단:**
    - 각 시도마다 자동차가 전진할지 멈출지를 결정합니다.
    - 0에서 9 사이의 랜덤한 숫자를 생성하고, 숫자가 4 이상일 경우 자동차는 전진합니다.
- **자동차 위치 업데이트:**
    - 전진이 결정된 자동차의 위치 값을 1 증가시킵니다.

### **경주 진행 상황 출력 기능**

- **현재 상태 출력:**
    - 각 시도 후 모든 자동차의 현재 위치를 출력합니다.
    - 자동차의 이름과 이동한 거리를 화면에 표시하며, 이동 거리는 ``로 표현됩니다.

### **우승자 결정 및 발표 기능**

- **우승자 결정:**
    - 모든 시도가 종료된 후 가장 멀리 이동한 자동차(들)을 우승자로 결정합니다.
    - 동일한 거리를 이동한 자동차가 여러 대일 경우 공동 우승자로 처리합니다.
- **우승자 발표:**
    - 우승자의 이름을 화면에 출력하여 사용자에게 안내합니다.
    - 우승자가 여러 명일 경우 쉼표로 구분하여 모두 출력합니다.

### **예외 처리 기능**

- **입력값 검증 및 예외 처리:**
    - 사용자 입력 값이 유효한지 검증하고, 잘못된 경우 `IllegalArgumentException`을 발생시켜 애플리케이션을 종료합니다.
        - 입력이 빈 공백이거나 null인 경우
        - 자동차 이름이 5자를 초과하는 경우
        - 시도 횟수가 숫자가 아닌 경우
    - 에러 발생 시 적절한 에러 메시지를 출력하여 사용자에게 안내합니다.

### **랜덤 값 생성 기능**

- **랜덤 숫자 생성:**
    - 자동차의 전진 여부를 결정하기 위해 0에서 9 사이의 랜덤한 숫자를 생성합니다.
    - 랜덤 숫자 생성은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용합니다.

### **게임 실행 흐름 관리 기능**

- **게임 흐름 제어:**
    - 전체 게임의 진행을 제어하는 서비스 클래스를 통해 게임을 시작하고 종료합니다.
    - 입력받기 → 파싱 및 검증 → 자동차 생성 → 경주 진행 → 결과 출력의 순서로 게임이 진행됩니다.

### **메시지 출력 기능**

- **안내 메시지 출력:**
    - 게임 진행 중 사용자에게 필요한 정보를 제공하기 위해 다양한 메시지를 출력합니다.
        - 예: 입력 요청 메시지, 진행 상황, 최종 우승자 발표 등
    - 메시지는 별도의 열거형(`Enum`)으로 관리하여 일관성을 유지합니다.

---

# 코드의 특징

### **객체지향적 설계와 SOLID 원칙 준수**

- **단일 책임 원칙(SRP):**
    - 각 클래스와 메서드는 하나의 책임만을 가지도록 설계되었습니다.
    - 예를 들어, 입력을 받는 클래스, 파싱하는 클래스, 게임을 진행하는 클래스 등이 분리되어 있습니다.
- **개방-폐쇄 원칙(OCP):**
    - 기능 확장이 용이하도록 인터페이스와 추상화를 활용하였습니다.
    - 새로운 기능 추가 시 기존 코드를 수정하지 않고도 확장할 수 있습니다.
- **의존성 역전 원칙(DIP):**
    - 상위 모듈이 하위 모듈에 의존하지 않고, 인터페이스에 의존하도록 설계되었습니다.
    - 이를 통해 클래스 간의 결합도를 낮추고, 유연성과 테스트 용이성을 높였습니다.

### **인터페이스 분리와 의존성 주입**

- **인터페이스 분리:**
    - 입력, 출력, 랜덤 숫자 생성 등에서 인터페이스를 도입하여 구현체를 분리하였습니다.
    - 각 기능을 인터페이스로 추상화하여 유연한 코드 구조를 갖습니다.
- **의존성 주입(DI):**
    - 생성자를 통해 필요한 의존성을 주입받아 클래스 간 결합도를 낮추고, 모킹(Mock)을 통한 테스트가 용이합니다.
    - 예를 들어, `MoveGenerator`나 `Printer` 등을 주입받아 사용합니다.

### **테스트 가능성 향상**

- **모듈화된 코드 구조:**
    - 기능별로 클래스와 메서드를 분리하여 단위 테스트가 용이합니다.
    - 각 클래스는 자신의 책임에만 집중하여 테스트 범위가 명확합니다.
- **Mocking을 통한 테스트:**
    - 인터페이스를 활용하여 의존성을 모킹할 수 있어, 외부 요소에 영향을 받지 않는 테스트가 가능합니다.
    - **물론 Mockito는 외부 라이브러리이기 때문에 사용하지 않습니다…**
    - 랜덤 요소나 입출력 부분을 모킹하여 다양한 시나리오를 검증할 수 있습니다.

### **확장성과 유지보수성 고려**

- **유연한 구조:**
    - 새로운 입력 방식이나 출력 형식을 추가할 때 기존 코드를 수정하지 않고도 확장이 가능합니다.
    - 예를 들어, 파일 입력이나 GUI 출력을 추가할 때 인터페이스 구현체만 추가하면 됩니다.
- **일관된 코딩 스타일:**
    - 코드 컨벤션을 준수하고 명확한 네이밍을 사용하여 가독성을 높였습니다.
    - 패키지 구조를 기능별로 분리하여 관리가 용이합니다.

### **예외 처리와 사용자 경험 개선**

- **명확한 예외 처리:**
    - 사용자 입력에 대한 철저한 검증과 예외 처리를 통해 예상치 못한 오류를 방지합니다.
    - 예외 발생 시 명확한 에러 메시지를 제공하여 사용자 경험을 향상시킵니다.
- **일관된 메시지 관리:**
    - 출력되는 메시지를 열거형(`Enum`)으로 관리하여 변경이나 다국어 지원 시 용이합니다.

### **리팩토링을 통한 코드 개선**

- **중복 코드 제거:**
    - 공통되는 기능이나 검증 로직을 별도의 메서드나 클래스에 분리하여 재사용성을 높였습니다.
- **불변성 유지:**
    - 가능한 한 객체의 불변성을 유지하여 예측 가능한 코드를 작성하였습니다.
    - 예를 들어, `Car` 클래스의 `name` 필드는 불변으로 처리됩니다.
