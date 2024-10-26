# 자동차 경주 게임 기능 요구사항 구현 목록

## 1. Car (자동차) 기능
- [x] 자동차는 이름을 가진다.
- [x] 자동차 이름은 5자 이하만 가능하다.
- [x] 5자 초과된 이름이 들어오면 예외가 발생한다.
- [x] 자동차는 전진 또는 멈출 수 있다.
- [x] 전진하면 위치가 증가한다.
- [x] 현재 위치를 반환할 수 있다.


## 2. RacingGame (경주 게임) 기능
- [x] 자동차들의 경주를 관리한다.
- [x] 사용자 입력한 횟수만큼 실행한다.
- [x] 실행 차수마다 모든 자동차들의 이동을 처리한다.
- [x] 0에서 9 사이의 무작위 값을 구한다.
## 3. Application (입력 및 싱행) 기능 
- [x] 쉼표(,)로 구분된 자동차 이름들을 입력받는다.
- [x] 시도할 횟수를 입력받는다.

## 4. GameResult (게임 결과) 기능
- [x] 자동차들의 이동거리를 비교한다.
- [x] 최대 이동 거리를 구한다.
- [x] 우승자들을 선정한다.

## 5. RacingGameView (화면 출력) 기능
- [x] 각 차수별 실행 결과를 출력한다.
- [x] 자동차의 이동 거리를 "-"로 표시한다.
- [x] 우승자들을 출력한다.

```
게임 진행 기능
- [x] 쉼표(,)로 구분된 자동차 이름들을 입력받는다.
- [x] 시도할 횟수를 입력받는다.
- [x] 0에서 9 사이의 무작위 값을 구한다.
- [x] 무작위 값이 4 이상일 경우에만 전진한다.

결과 판단 기능
- [x] 자동차들의 이동거리를 비교한다.
- [x] 가장 멀리 이동한 자동차들을 찾는다.
출력 기능
- [ ] 각 차수별 실행 결과를 출력한다.
- [ ] 자동차의 이동 거리를 "-"로 표시한다.
- [ ] 우승자들을 출력한다.
````