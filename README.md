
# 📑 java-racingcar-precourse 자동차 경주
> 초간단 자동차 경주 게임을 구현한다.

<br>
<br>

## 구현할 기능 목록

- [v] 입력
    - [v] 경주할 자동차 n대의 이름을 입력받는다.
        - [v] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하가 되도록 한다.
        - [v] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료시킨다.
    - [v] 사용자가 몇 번을 이동할 것인지를 입력받는다.
        - [v] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료시킨다.
    

<br>

- [v] 자동차 객체를 생성한다.
    - [v] 자동차의 이름을 입력에 맞게 초기화하고 이동거리는 0으로 초기화 한다.
    - [v] 자동차가 전진하는 경우 이동거리를 1 증가한다.
        - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

    
- [v] 자동차 경주 게임의 진행 과정을 생성한다.
    - [v] n대의 자동차 객체를 생성해 입력받은 이름에 맞게 초기화한다.
    - [v] `0~9` 사이의 무작위 값을 반환하는 함수를 구현한다.
    - [v] 무작위 값이 4 이상이면 자동차를 전진시킨다.
    - [v] 우승자를 전부 찾아서 반환한다.
        - 우승자는 한 명 이상일 수 있다.
        - 전진횟수가 가장 많은 사람이 우승자이고, 동점이 있다면 공동 우승자로 처리한다.

<br>

- [v] 출력
    - [v] 입력하기 전 문구를 출력한다.
    - [v] 실행 결과와 최종 우승자를 출력한다.
        - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

<br>

- [v] 통합 컨트롤러 클래스를 만들어 모든 함수를 조립한다.

<br>
<br>

## 실행 결과 예시
``` 
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
```


<br>
<br>


## 프로그래밍 요구 사항
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 Application의 main()이다.
- build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 Java Style Guide를 원칙으로 한다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

