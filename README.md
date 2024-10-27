# java-racingcar-precourse


# 이번 프로젝트에서 얻고자 하는 점

먼저, 과제에 올라온 학습 목표를 확인해보겠습니다.
 

- 학습 목표
  - 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
  - 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
  - 1주 차 공통 피드백을 최대한 반영한다.
  - indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 3항 연산자를 쓰지 않는다.
  - JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

  
- 나만의 학습 목표 
  - 1주차 때 아쉬웠던 점이 설계이다. 따라서 확실하게 설계를 하고 들어가는 것이 나의 첫 번째 목표이다.
  - 단일 역할을 수행하는 작은 메서드로 분리함과 더불어, 클래스도 최대한 하나의 책임을 갖도록 한다.
  - 테스트를 구현하기 전에 작성하는 테스트 주도 개발(TDD) 방식을 배워보고 적용한다.

# 구현할 기능 목록


- 자동차 이름 입력받기
  - 자동차의 이름은 1자 이상, 5자 이하여야 한다.
  - 자동차의 이름은 쉼표로 구분된다.
- 라운드 횟수 입력 받기
  - 자동차가 총 몇 번 이동할 것인지 입력한다.
  - 이는 INT형만 가능하며 이외에는 예외처리한다.
- 전진 또는 정지
  - 전진의 조건은 랜덤수(0~9)에서 4 이상일 때 자동차는 전진한다.
  - 한 번 진행될 때 마다 진행 사항을 출력한다.
    - 출력은 이름도 함께 출력한다.
- 레이싱 결과 출력
  - 우승자를 찾는다. 이는 가장 전진을 많이 한 자동차이다.
  - 우승자는 1명 이상이다. 2명 이상일 경우, 쉼표로 이를 구분한다.
