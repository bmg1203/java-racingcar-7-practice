# 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- [x] 클래스
  - [x] 자동차

- [ ] 입력
  - [x] 자동차
    - [x] 자동차 이름은 쉼표(,)를 기준으로 구분
    - [x] 이름은 5자 이하만 가능.
  - [x] 횟수 
    - [x] 숫자만 ok
  - [ ] 에러처리
    - [ ] 잘못된 입력 시 IllegalArgumentException 에러 처리 

- [x] 동작 ( 주어진 횟수 동안 n대의 자동차는 전진 또는 멈추는 기능 )
  - [x] 횟수
    - [x] 내가 정한 횟수를 넘었는 지 판단하는 기능
  - [x] 자동차
    - [x] 무작위 값을 설정하는 기능
    - [x] 값이 4 이상일 때 전진하는 기능
  - [x] 출력
    - [x] 각 자동차의 전진 횟수를 '-'로 변환
    - [x] 'car' : '-' 형식으로 출력

- [x] 결과
  - [x] 우승자 판단
  - [x] 우승자가 1명이면 우승자 이름 출력
  - [x] 우승자가 2명 이상 시 이름을 ,로 구분해서 출력

# 프로그래밍 요구사항
- [x] JDK 21 버전에서 실행 가능해야 한다.
- [x] 프로그램 실행의 시작점은 Application의 main()이다.
- [x] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [ ] 기본적으로 Java Style Guide를 원칙으로 한다.
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
