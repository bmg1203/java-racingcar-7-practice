# 기능 목록
- **경주할 자동차 이름 입력받기**
  - **자동차의 위치를 파악하기 위해 HashMap으로 <자동차 이름, 초기 위치(0)>로 생성**
    - 경주할 자동차 이름을 입력하세요
    - 이름은 쉼표(,) 기준으로 구분
    - 각 이름이 5자 이하인지 확인하고 아닐경우 **IllegalArgumentException** 발생시킨 후 애플리케이션 종료


- **몇 번의 이동을 할 지 사용자에게 입력받기**
  - 시도할 횟수는 몇 회인가요?
  - 10번 이하로 가정하고 입력받기


- **실행 결과 반환하기**
  1. 각 자동차별 0~9사이 무작위 값 구하기
  2. 값이 4이상인 자동차를 체크하기
  3. 실행 결과를 출력하기
  - 1~3번을 입력한 시도 횟수만큼 반복
  - 우승자를 출력하기
    - 우승자가 여러 명일 경우 쉼표를 이용하여 구분하기