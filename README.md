# java-racingcar-precourse

초간단 자동차 경주 게임을 구현한다.

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  * 횟수 입력 받음 (횟수동안 반복)
  * 자동차는 전진 or 멈춤 2가지 액션
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
  * 각 자동차는 이름이 있음.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
  * 쉼표 기준으로 split
  * 각 이름은 5자 이하
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
  * 무작위 random 추출
  * random 값이 4이상, 전진
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
  * 우승자 1명 이상일 수 있음
* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

<br></br>

### 입출력 요구 사항

* 입력
  * 경주할 자동차 이름(쉼표 기준으로 구분)
    * 예시) pobi,woni,jun
  * 시도할 횟수
    * int
* 출력
  * 차수별 실행결과
    * - 로 전진 표시
  * 단독 우승자 안내 문구
    * 예시) 최종 우승자 : pobi
  * 공동 우승자 안내 문구
    * 최종 우승자 : pobi, jun

<br></br>

### 프로그래밍 요구사항

* indent depth 2까지 허용
* 3항 연산자 쓰지 x
* 함수 또는 메서드가 한 가지 일만 하도록 최대한 작게

### 라이브러리 

* camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용
  * Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
  * 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용

<br></br>

--------------------------------

<br></br>

## 기능 목록

1. [X] 사용자 입력 받기
  - [X] 자동차 이름 입력
  - [X] 시도 횟수 입력
2. [X] 자동차 이름 추출
  - [X] 쉼표로 구분된 자동차 이름을 분리
3. [] 입력값 검증
  - 자동차 이름 검증
    - [X] 5자 이하
    - [X] 공백이나 특수문자 없는지 (알파벳만 가능)
    - [X] 중복된 이름 없는지 확인
  - 시도 횟수 검증
    - [X] 1이상의 정수인지 확인
4. [X] 0에서 9 사이 무작위 값 생성
5. 레이스 진행
  - [X] 입력된 시도 횟수만큼 레이스 반복
  - [X] 각 자동차에 대해 무작위 값 생성
  - [X] 무작위 값이 4이상이면 전진, 아니면 멈춤
6. 진행 상황 출력
  - [] 각 시도마다 자동차 이름과 전진 홧수 출력
7. 우승자 선발 기능
  - [] 레이스 종료후 전진 횟수 가장 많은 자동차 선발
  - [] 여러 우승자 있을 경우 공동 우승자 처리
8. 출력
  - [] 최종 우승자 출력
9. 예외 처리
