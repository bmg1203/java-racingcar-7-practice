# java-racingcar-precourse

## 초간단 자동차 경주 게임을 구현

### 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 전진은 단 한칸으로 제한한다.

### 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 이름은 1자 이상 5자 이하만 가능하다.
- 입력이 비어있어서는 안되며, 자동차 이름이 공백으로만 구성되어서는 안된다.
- 이름 앞, 뒤 공백은 무시되며, 이름 내부 공백은 허용된다.
- 중복된 이름을 허용하지 않는다.
- 구분자로 사용되는 `','`를 제외한 모든 문자를 사용할 수 있다.

### 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 0보다 큰 아라비아 숫자만 허용된다.

### 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 전진 상태는 `-`을 통해 시각적으로 표시된다.

### 자동차 경주 게임을 진행한다.
- 형식은 다음과 같다.
```
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
```

### 우승자를 출력한다.
- 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

### 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## MVC 모델 기반 기능 구분

### 뷰
- 유저와 직접 소통하는 클라스
- **InputView.java** : 자동차 이름과 이동 횟수를 입력받는다.
- **OutputView.java** : 게임의 경과와 승리자를 출력한다.

### 컨트롤러
- 앱의 흐름을 주관
- 뷰와 모델을 연결
- **RacingGame.java** : 게임의 흐름을 주관

### 모델
- 자동차와 경주를 추상화한 클라스
- **Car.java** : 단일 자동차를 추상화
- **Cars.java** : 경주에 참여하는 자동차 컬렉션을 추상화# java-racingcar-precourse

## 초간단 자동차 경주 게임을 구현

### 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 전진은 단 한칸으로 제한한다.

### 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 이름은 1자 이상 5자 이하만 가능하다.
- 입력이 비어있어서는 안되며, 자동차 이름이 공백으로만 구성되어서는 안된다.
- 이름 앞, 뒤 공백은 무시되며, 이름 내부 공백은 허용된다.
- 중복된 이름을 허용하지 않는다.
- 구분자로 사용되는 `','`를 제외한 모든 문자를 사용할 수 있다.

### 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 0보다 큰 아라비아 숫자만 허용된다.

### 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 전진 상태는 `-`을 통해 시각적으로 표시된다.

### 자동차 경주 게임을 진행한다.
- 형식은 다음과 같다.
```
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
```

### 우승자를 출력한다.
- 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

### 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## MVC 모델 기반 기능 구분

### 뷰
- 유저와 직접 소통하는 클라스
- **InputView.java** : 자동차 이름과 이동 횟수를 입력받는다.
- **OutputView.java** : 게임의 경과와 승리자를 출력한다.

### 컨트롤러
- 앱의 흐름을 주관
- 뷰와 모델을 연결
- **GameFlow.java** : 게임의 흐름을 주관

### 모델
- 자동차와 경주를 추상화한 클라스
- **Car.java** : 단일 자동차를 추상화
- **Cars.java** : 경주에 참여하는 자동차 컬렉션을 추상화
- **CarMoveDeterminator** : 자동차의 이동 여부를 결정
- **MoveStrategy** : 테스트시 무작위성을 통제할 수 있도록 함