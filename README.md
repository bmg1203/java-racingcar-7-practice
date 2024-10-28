<div align="center">

<h1>java-racingcar-precourse</h1>

<br />

</div>

<br />

## 학습 목표
```markdown
📝 간단한 자동차 경주 게임을 구현하여 Java 객체 지향 프로그래밍, 클래스 설계, 메서드 분리, 랜덤 요소 제어 등을 학습하고, Git 및 GitHub 활용에 익숙해진다.
📝 테스트 코드 작성과 리팩토링을 통해 코드 품질과 유지보수성을 높이는 경험을 한다.
```

<br />

# 목차

### [0. 요구사항 분석](#요구사항-분석)

### [1. 구현](#구현)

### [2. 테스트](#테스트)

### [3. 실수 회고](#실수-회고)

<br />

# 요구사항 분석

## 과제 진행 요구사항
1. 미션은 자동차 경주 저장소를 포크하고 클론하는 것으로 시작
2. 기능 구현 전 README.md에 구현할 기능 목록을 작성하고 커밋 단위를 설정
3. AngularJS Git Commit Message Conventions을 참고하여 커밋 메시지를 작성
4. JDK 21 환경에서 실행되도록 구현하고, 프로그램의 시작점은 `Application`의 `main()` 메서드로 설정

## 기능 요구사항
> 초간단 자동차 경주 게임을 구현
- 사용자가 입력한 자동차 이름과 경주 횟수에 따라 자동차 경주를 진행하고, 최종 우승자를 출력
- n대의 자동차는 자동차는 주어진 횟수 동안 전진하거나 멈출 수 있다. 전진 조건은 0~9 사이의 랜덤 숫자가 4 이상일 때 전진한다.
- 자동차 이름은 쉼표로 구분되며 5자 이하의 이름만 가능
- 모든 라운드의 결과를 출력하며, 게임 종료 후 우승자(또는 공동 우승자)를 출력
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분
- 잘못된 입력값이 들어오면 `IllegalArgumentException` 예외를 발생시키고 프로그램 종료

## 프로그래밍 요구사항
- `indent` depth는 2까지 허용하며, depth가 3을 넘지 않도록 한다. (ex. while문 안에 if문이 있으면 들여쓰기는 2)
- 프로그램 종료 시 System.exit()를 호출하지 않는다.
- 3항 연산자는 사용하지 않고, 함수는 한 가지 작업만 수행하도록 분리하여 작성한다.
- 외부 라이브러리 추가 없이, `camp.nextstep.edu.missionutils`의 `Randoms` 및 `Console` API만을 사용한다.
- JUnit 5와 AssertJ를 이용하여 기능 목록을 테스트하며, 테스트 코드가 정상 동작하는지 확인한다.

<br />

# 구현

## 구현해야 할 기능 목록

- **입출력 처리**
    - [x] 사용자로부터 자동차 이름과 경주 횟수를 입력을 받는 기능
    - [x] 자동차 이름이 5자 이하여야 하며, 쉼표로 구분하는 기능
    - [x] 각 라운드마다 전진한 자동차의 이름과 위치를 출력하는 기능
    - [x] 최종 라운드가 끝난 후 가장 많이 전진한 자동차(들)를 출력하는 기능
    - [x] 경주 횟수는 숫자로 입력받아야 하며, 잘못된 값이 들어오면 예외를 발생하는 기능

<br />

- **자동차 이동 클래스**
    - [x] `Randoms.pickNumberInRange(0, 9)`를 통해 랜덤 값을 가져오는 기능
    - [x] 사용자가 입력한 경주 횟수만큼 라운드를 반복하며 각 자동차의 위치를 업데이트하는 기능
    - [x] 랜덤 숫자 중 4 이상일 경우 전진하는 기능

<br />

# 테스트
- **테스트 코드**
```java
@Test
void 기능_테스트() {
    assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
    );
}

@Test
void 예외_테스트() {
    assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
    );
}

@Test
void 빈_자동차_이름_예외_테스트() {
    assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,,jun", "1"))
                    .isInstanceOf(IllegalArgumentException.class)
    );
}

@Test
void 경주_횟수_숫자_아님_예외_테스트() {
    assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,woni", "five"))
                    .isInstanceOf(IllegalArgumentException.class)
    );
}

@Test
void 경주_횟수_0일_때_테스트() {
    assertSimpleTest(() -> {
        run("pobi,woni", "0");
        assertThat(output()).contains("최종 우승자 : pobi, woni");
    });
}

@Test
void 공동_우승자_발생_테스트() {
    assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni,jun", "3");
                assertThat(output()).contains("최종 우승자 : pobi, woni");
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
    );
}
```


> 아래의 출력 결과처럼 테스트가 잘 됐음을 알 수 있다.

<img src="https://github.com/user-attachments/assets/afa23828-2b1b-4200-992b-271fd70546b0" width="700;" alt="">

<br />

# 실수 회고

> 과제 수행 중 발생한 실수와 해결 방법에 대한 기록

- **실수 코드**
```java
public List<String> findWinners() {
    // 최대값(위치) 찾기
    int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0); // 자동차 리스트가 비어있는 경우 0 반환
    // 최대값에 도달한 자동차 필터링
    return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
}
```

- **개선된 코드**
```java
public List<Car> findWinners() {
    // 최대값(위치) 찾기
    int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0); // 자동차 리스트가 비어있는 경우 0 반환

    // 최대값에 도달한 자동차 필터링
    return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
}
```

- **문제점**
    - 반환 타입 불일치:
      - `findWinners()` 메서드는 우승자들을 담은 `List<Car>` 타입을 반환해야 하는데, 실수 코드에서는 `List<String>` 타입을 반환하도록 구현되어 있었다.
    - 기능 불일치:
      - 반환된 `List<String>`에서는 각 자동차의 이름만 제공되므로, `Car` 객체 전체 정보가 필요한 다른 로직에서 제약이 발생했다.

- **해결 방법**
    - 타입 수정:
      - 개선된 코드에서는 `findWinners()` 메서드의 반환 타입을 `List<Car>`로 수정하여, `Car` 객체 전체가 반환되도록 했다.
    - 최대 위치 값을 가진 자동차 필터링:
      - 자동차 객체의 위치를 기준으로 최대 위치 값과 일치하는 자동차들을 필터링하여 `List<Car>` 타입으로 반환했다.

<br />