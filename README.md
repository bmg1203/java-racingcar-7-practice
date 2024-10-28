# java-racingcar-precourse

## 구현해야 할 기능 목록

- ### 게임 초기화 및 시작
    - [ ] 자동차 이름과 시도 횟수를 입력받고 유효성 검증
    - [ ] 입력된 데이터를 바탕으로 게임 초기화
    - [ ] 레이스 시작 후 각 라운드 실행
  

- ### 자동차 객체 생성
    - [x] 자동차 객체 생성 및 초기화
    - [x] 자동차 리스트 생성
  

- ### 자동차 이동 전략 설정
    - [x] MoveStrategy 인터페이스 구현
    - [x] 무작위 이동 전략 (RandomMoveStrategy) 구현
    - [x] 테스트용 이동 전략 (AlwaysMoveStrategy) 구현


- ### 레이스 진행
    - [ ] 각 라운드에서 자동차 이동 로직 실행
    - [ ] 각 라운드 결과 저장
  

- ### 우승자 결정 및 출력
    - [ ] 경주 종료 후 우승자 결정 로직 구현
    - [ ] 우승자 이름 출력
  

- ### 입출력 처리
    - [ ] 사용자로부터 자동차 이름과 시도 횟수 입력받기 (InputView)
    - [ ] 레이스 결과와 우승자 출력 (OutputView)
  

- ### 유효성 검증
    - [ ] 자동차 이름 유효성 검증 (공백, 길이, 중복 검사)
    - [ ] 시도 횟수 유효성 검증 (정수 및 양수 확인)

---
### 주요 설계 패턴 및 구성 요소

### 1. MVC 패턴

본 프로젝트는 MVC 패턴을 따릅니다. 

Controller, Model, View + Service 로 구성되어 있으며, 각 계층은 다음과 같은 역할을 합니다:

	• Controller: 사용자의 입력을 받고, Service를 호출하여 비즈니스 로직을 처리한 결과를 View에 전달한다.
	• Model: 자동차의 이동조건과 경주 진행에 대한 상태를 관리한다.
	• View: 사용자와의 상호작용을 처리하며, 입력과 출력을 관리한다.
    • Service: 경주 관련 주요 로직을 담당한다.


### 2. 전략 패턴 (Strategy Pattern)

전략 패턴을 적용하여 자동차의 전진 여부를 결정하는 로직을 유연하게 변경할 수 있도록 설계했습니다.

	• MoveStrategy: 인터페이스 자동차의 전진 조건을 정의
	• RandomMoveStrategy: 무작위 전진 조건을 적용한 전략
	• AlwaysMoveStrategy: 테스트용 전략으로 항상 전진하는 전략

### 4. 팩토리 메서드 패턴 (Factory Method Pattern)

자동차 객체의 생성은 팩토리 메서드 패턴을 사용하여 캡슐화했습니다.

