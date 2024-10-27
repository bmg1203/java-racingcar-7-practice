# java-racingcar-precourse

### 기능 목록
1. 입력
   1. [x] 자동차 이름 입력
      - 설명 : 사용자로부터 자동차 이름 입력받음
      - 세부사항 
        - 입력 형식 : 쉼표(,) 로 구분된 문자열
        - 각 자동차 이름은 1자 이상, 최대 5자 이하
        - 예시 : pobi,woni,jun
      - 예외 처리 
        - 자동차 이름이 쉼표로 구분되어있지 않은 경우
        - 빈 이름을 포함한 경우
        - 자동차 이름이 5자를 초과하는 경우
   2. [x] 이동 횟수 입력
      - 설명 : 사용자로부터 자동차 이동 횟수 입력받음
      - 세부 사항 
        - 입력 형식 : 정수 N 회로 제한
      - 예외 처리
        - 입력값이 정수가 아닌 경우
        - 입력값이 음수인 경우
2. 경주 진행
   1. 경주
      - 설명 : 지정된 이동 횟수 동안 경주를 진행함
      - 세부사항
        - 각 이동마다 모든 자동차에 대해 무작위 난수에 따른 이동
        - 전진한 자동차의 이름과 이동 거리 출력
   2. 우승자 결정
      - 설명 : 경주가 끝난 후 최종 우승자를 결정함
      - 세부사항
        - 가장 멀리 간 자동차의 이름을 수집
        - 여러 명이 동일한 최대 거리를 갔을 경우 모두 우승자
        - 최종 우승자 출력
3. 자동차 랜덤 이동
   1. 무작위 정수 생성
      - 설명 : 이동 여부를 결정하기 위해 0~9 사이 무작위 정수 생성
      - 세부사항
        - (camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()) 사용
        - 생성된 값이 4 이상일 경우 자동차는 전진

4. 출력
   1. 전진한 자동차 출력
      - 설명 : 각 이동 시, 전진한 자동차의 이름과 이동 거리 출력
      - 예시 </br> pobi: - </br>
        woni: -- </br>
        jun: -
    2. 최종 우승자 출력
       - 설명 : 경주가 끝난 후, 최종 우승자의 이름 출력
       - 세부사항
         - 우승자가 여러 명일 경우, 입력받은 순서대로 쉼표로 구분하여 출력
         - 예시 : 최종 우승자: pobi, woni
5. [x] 사용자 인터페이스
   1. 입력 안내
      - 자동차 이름 입력
        - 예시 : 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
      - 이동 횟수 입력
        - 예시 : 시도할 횟수는 몇 회인가요?
   2. 오류 안내
    - 이름 입력 오류
      - 예시 : 이름은 쉼표로 구분되어야 하며, 1~5자 사이여야 합니다.
    - 이동 횟수 입력 오류
      - 예시 : 이동 횟수는 자연수이며, 21억 이하여야 합니다.

### 테스트 목록
-[x] 정상 입력 케이스
  - 예시 : pobi,woni,jun
  - 기대 : 정상 진행
-[x] 이름 길이 초과 케이스
  - 예시 : pobi,woooooooni,jun
  - 기대 : IllegalArgumentException 발생 및 오류 메시지 출력.
-[x] 빈 이름 포함 케이스
  - 예시 : pobi,,jun
  - 기대 : IllegalArgumentException 발생 및 오류 메시지 출력.
-[x] 잘못된 구분자 케이스
  - 예시 : pobi;woni,jun
  - 기대 : IllegalArgumentException 발생 및 오류 메시지 출력.
-[x] 이동 횟수 오류 케이스
  - 예시 : -3
  - 기대 : IllegalArgumentException 발생 및 오류 메시지 출력.


### 기능 요구 사항
1. 주어진 횟수 동안 N대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
7. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentationException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항
**입력** 
- (경주할 자동차 이름(이름은 쉼표 기준으로 구분))
    : pobi,woni,jun

- 시도할 횟수
    : 5


**출력**
- 차수별 실행 결과
    : pobi : -- </br>
    woni : ---- </br>
jun : ---

- 단독 우승자 안내 문구
  : 최종 우승자 : pobi

- 공동 우승자 안내 문구
    : 최종 우승자 : pobi, jun


### 프로그래밍 요구사항
- indent depth < 3 (함수 분리)
- 3항 연산자는 쓰지 않는다
- 함수가 한가지 일만 하도록 작게 만든다
- JUnit5와 AssertJ를 이용하여 기능 목록 사항을 테스트한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- 입력값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.