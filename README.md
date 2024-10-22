# java-racingcar-precourse

## 2주차 요구 사항 정리
- 참가자를 입력받고 자동차 경주 게임을 시행한다.

  1. 기본 입출력 요구사항
     - 쉼표로 구분하여 사용자에게 자동차 이름을(5자 이하로) 입력받고 시도 횟수를 입력받는다.
     - 게임마다 전진하는 조건은 0~9 사이의 무작위 추출을 통해 4이상일 경우에 가능하다.
     - 종료 후 우승자를 출력하는 데 반드시 1명은 아니다. 이 역시 쉼표로 구분한다.
     - 잘못된 값은 IllegalArgumentException으로 종료시킨다.
  
  2. 고려해야할 검증 사항
     - 이름이 5글자를 초과하거나 쉼표 외에 구분자가 작성되면 예외를 터뜨린다.
     - 양 끝에 쉼표가 작성되면 예외를 터뜨린다.
     - 공백의 경우에는 무시하고 올바른 입력으로 간주한다. 단 이름의 공백은 허락하지 않는다.
     - 특수문자는 허락하지 않으나 숫자는 사용 가능하다.
     - 사용자가 시도할 횟수 입력은 Integer 최대 값까지만 입력받고 음수, 소수, 문자, 공백 등 다른 입력은 모두 예외를 터뜨린다.
     - 그 외 잘못된 입력은 모두 예외처리한다.
      ```
        " ronaldo, messi: neymar -> Exception "
        " ,john, amy, andy, -> Exception "
        " jo hn, am$y, an dy -> Exception "
        "  john1, amy2, benz  -> 정상 입력 "
      ```
     
     - Randoms.pickNumberInRange(0, 9);를 이용하여 랜덤 숫자를 추출한다.
     - n번의 경주 중 전진한 횟수를 각 자동차에 대한 전진 카운트를 멤버변수로 선언해 저장한다.
     - 각 횟수마다 전진한 자동차는 "-"로 표시해 출력하고 n번 만큼 반복한다.
     - 우승자가 여러명일 경우 반복문으로 이름을 출력한다.
