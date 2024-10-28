# 자동차 경주

## 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 고려 사항
- 중복으로 이름이 입력되는 경우에는? &rarr; 우승자 구분하는 과정에 영향이 있으므로 예외 처리
- 특수 문자 사용 가능, 빈 문자는 예외 처리
- 입력된 자동차의 수가 1개 이하라면 예외처리
- 몇 번의 이동을 할 것인지에 정수만 입력, 너무 큰 값은 입력되지 않게 예외 처리 &rarr; `0 ~ 100의 정수`
- 정수로 변환할 수 없는 (`null`, ` `) 값도 예외 처리
- 이동한 횟수는 각 객체가 정수형으로 저장 후 출력할 때 따로 연산하는 쪽으로
- 우승자 검출 및 출력 &rarr; 가장 멀리 이동한 자동차
  - 자료구조는 최댓값과 동일한 움직임의 자동차를 `List`에 저장
  - ~~새로운 최댓값이 나오면 `List`를 비우고 최댓값 갱신~~
  - 자동차들이 이동을 할 때마다 이동한 거리들의 최댓값을 계속 갱신해줌
  - 최댓값과 동일한 움직임을 갖는 자동차를 `List`에 저장

## 기능 구현 목록
- 사용자로부터 자동차 이름 입력 받기
  - 쉼표를 기준으로 자동차 구분
- 사용자로부터 몇 번의 이동을 할 것인지 입력 받기
- 이동 횟수만큼 자동차의 움직임 구현
  - 각 자동차의 무작위 값 계산
  - 무작위 값에 따라 자동차 움직임
    - `0 ~ 3`: 멈춤
    - `4 ~ 9`: 전진
  - 모든 자동차의 움직임이 끝났다면 현재 경주 상태를 출력
- 우승자 검출
- 우승자 출력
  - 우승자가 한명일 경우
  - 우승자가 여러명일 경우
## 순서도
![racingCar](https://github.com/user-attachments/assets/0166f2bf-81b5-417f-9fd3-7af5898dc66b)