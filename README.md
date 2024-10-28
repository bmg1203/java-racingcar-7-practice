## 기능 목록 

### 입력 기능 
  
  >입력에서는 camp.nextstep.edu.missionutils에서 제공하는 Console API의 readLine()을 반드시 활용 해야 한다."

  - 경주할 자동차 이름 입력 ','구분자
    - 요구 예외 상황: 이름이 6자 이상이면 IllegalArgumentException을 발생하고 프로그램을 종료시킨다.
    - 추가 예외 사항:
      - 구분자로 몇개까지 이름을 입력받을 것인지에 대한 제한
        - 최소 2개 이상 및 5개 이하로만 받는다.
    - 고려한 예외 사항
      - ',' 구분자로 입력이 안들어오는 경우 이미 자동차 객체 생성시 이름 규칙을 위배하여 예외가 발생함
      - 중복된 이름은 다른 객체를 구분하지 못할 경우는 발생하지 않음
  - 시도할 횟수 입력 (숫자만)
    - 요구 예외 사항: 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생하고 프로그램을 종료시킨다.
    - 추가 예외 사항 
      - 음수의 시도횟수

### 경주 진행
  >"camp.nextstep.edu.missionutils에서 제공하는 Randoms API의 pickNumberInRange 를 반드시 활용하여 랜덤한 값을 가져와야 한다"

  - 시도 횟수별 각 실행 결과를 보여 준다.
  - 자동차는 0-9사이의 무작위 값에서 4이상일 경우 전진한다

### 우승자 판정
  - 우승자 판단 후 출력
  - 우승자가 2명 이상일 수 있으며 ','로 구분하여 우승자들을 출력한다