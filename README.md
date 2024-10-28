# java-racingcar-precourse

## 문제 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

#### 실행 결과 예시

    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,woni,jun
    시도할 횟수는 몇 회인가요?
    5

    실행 결과
    pobi : -
    woni : 
    jun : -

    pobi : --
    woni : -
    jun : --

    pobi : ---
    woni : --
    jun : ---

    pobi : ----
    woni : ---
    jun : ----

    pobi : -----
    woni : ----
    jun : -----

    최종 우승자 : pobi, jun

## 구현 기능 목록

### 1. 기능

- [x] "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
- [x] 경주할 자동차 이름 입력(5자 이하)
- [x] "시도할 횟수는 몇 회인가요?"
- [x] 시도할 횟수 입력
- [x] 잘못된 값 입력시 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료
- [x] 주어진 횟수 동안 자동차 이동
    - [x] 각 회차마다 이동 거리 무작위 값(0 - 9) 구하기
        - [x] 무작위 값이 4 이상일 경우 전진
        - [x] 4 미만일 경우 멈춤
    - [x] 회차별 실행 결과 출력
- [x] 경주 완료 후 우승자 출력
    - [x] 여러명일 경우 쉽표(,)로 구분

### 2. 세부 조건

- [x] 시도할 횟수는 정수 범위
- [x] 자동차 이름 입력값에 공백 있으면 에러 발생
- [x] 한번에 1만큼 전진
- [ ] 자동차 대수 범위

### 3. 프로그래밍

- [x] JDK 21 버전에서 실행 가능해야 한다.
- [x] 프로그램 실행의 시작점은 Application의 main()이다.
- [x] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - [x] 기본적으로 Java Style Guide를 원칙으로 한다.

- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.  
  예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.  
  힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- [x] 3항 연산자를 쓰지 않는다.
- [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [x] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

#### 라이브러리

- [x] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - [x] Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 클래스 역할

### - car

#### Car

#### CarFactory

#### Cars

#### Position

### - io

#### InputHandler

#### InputParser

#### InputValidator

#### Output

### - race

#### Race

#### RaceController

#### RandomNumber

#### Rule

#### ExceptionMessages

#### InputMessages

## 클래스 다이어그램

![classdiagram_1](https://github.com/user-attachments/assets/27f59a77-91b8-456f-bdb8-87ff5ef247d8)
