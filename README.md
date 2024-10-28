# java-racingcar-precourse

# 과제 요구 사항

----

* [x] 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다.
* [ ] 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
* [ ] Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
  * AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
* [x] 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

----

# 기능 요구 사항

----

* [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.

* [x] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

#### 예: "pobi", "3" => (2회 성공시) pobi : --

* [x] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

* [x] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* [x] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 
* [x] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* [x] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

----

## 프로그래밍 요구 사항 1

----

* [x] JDK 21 버전에서 실행 가능해야 한다.
* [x] 프로그램 실행의 시작점은 Application의 main()이다.
* [x] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
* [x] 프로그램 종료 시 System.exit()를 호출하지 않는다.
* [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
* [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다. -> 기본적으로 Java Style Guide를 원칙으로 한다.

----

## 프로그래밍 요구 사항 2

----

* [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다
* [x] 3항 연산자를 쓰지 않는다.
* [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
* [x] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

# 기능 요구 사항에 따른 개발

## 개발 순서

1. Car 클래스 생성
    * 5자리 이상의 이름은 IllegalArgumentException
    * distance 값을 "-"로 변경하는 print문 생성
      * "name : distance(dash)" 형태
    * goStraight 구현 (distance 값 증가)
      (추후 변경사항: goStraight 메서드를 )
2. Application 클래스 구현(게임)
    * 입력값으로 이름과 시행횟수를 받아옴
    * 승자를 판별하는 메서드 구현

## 테스트 케이스

1. Car 클래스 테스트
    * goStraight 구현
    * 
2. 구분자 정의 테스트
    * 기본 구분자 테스트
    * 여러개의 구분자 입력 테스트
3. 예외 발생하는 경우 테스트
    * 커스텀 문자열 사이 특수기호가 아닌 경우 예외 처리
    * 커스텀 문자열 사이, 2글자 이상 오는 경우 예외 처리
    * 커스텀 문자열 사이, 아무 문자도 들어오지 않는 경우 예외 처리
    * 등록되지 않은 구분자 입력시 예외 처리
    * 커스텀 구분자 추가시, 표현식이 이상한 경우


