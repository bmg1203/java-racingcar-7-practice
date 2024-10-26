#  🏎 Racing Car 🏎 

---

## 구현해야 할 클래스 및 기능 목록


- **```Game```: 게임 로직을 메인으로 담당하는 클래스**
  - [x] 레이싱을 시작
  - [x] 정해진 횟수 만큼 라운드 진행
  - [ ] 우승자 결정 후 발표


- **```Car```: 개별 자동차 클래스**
  - [x] 자동차의 이름과 위치를 저장
  - [x] 내부 로직 결과에 따라 자동차 전진
  - [x] 현재의 상황을 가시화해서 리턴


- **```Cars```:  개별 자동차를 멤버 변수로 갖는 클래스**
  - [x] 정보를 받아 자동차 객체를 생성하여 리스트에 저장
  - [x] 한 라운드씩 경기 진행
  - [x] 한 라운드 끝났을 때 상황 리턴
  - [ ] 승자 결정
  

- **```MovementDecider```: 전진 여부를 결정하는 클래스**
  - [x] 0에서 9사이에서 무작위 값을 구한 후, 결과에 따라 전진 여부를 결정


- **```Parser```: 사용자가 입력한 문자열의 처리를 담당하는 클래스**
  - [x]  경주할 자동차를 입력한 문자열에서 자동차 이름 추출


- **```InputValidator``` : 사용자 입력값에 대한 유효성 검증 담당 클래스**
  - [ ] 자동차 이름 입력을 요구사항에 맞춰서 입력했는 지 검증
    - [ ] 자동차 이름의 길이가 5글자 초과일 경우
    - [ ] 자동차 이름 사이에 화이트스페이스, 개행이 붙어있는 경우
    - [ ] 동일한 이름이 두 번 이상 입력되어 있는 경우

  - [ ] 시도할 횟수 입력을 요구사항에 맞춰서 입력했는 지 검증
    - [ ] 숫자가 아닌 값을 입력한 경우
    - [ ] 숫자를 입력했지만 정수가 아닌 경우


- **```ErrorMessage```: 에러 메세지 Enum 클래스**


- **```InputView```: 입력 기능 담당 클래스**
  - [x] 사용자에게 입력 안내 문구 출력 
  - [x] 사용자에게 자동차 이름과 시도할 횟수를 입력받음.


- **```OutputView``` : 결과 출력 담당 클래스**
  - [x] 각 라운드에 대한 실행 결과 출력
  - [x] 우승자 안내문구 출력


- **```Notice``` : 출력할 메세지 Enum 클래스**






---

