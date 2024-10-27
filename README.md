# java-racingcar-precourse

###  기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 구현 전 기능 목록
1. 입력 처리
   1. 자동차 이름 입력 받기
   2. 이동 횟수 입력 받기
2. 유효성 검사
    1. 자동차 이름
       - 에러 처리
         - 빈 문자열 (입력: "")
         - 공백이 포함된 이름인 경우 (입력: "po bi")
         - 쉼표만 입력된 경우 (입력: ",,,,")
         - 다른 구분자가 사용된 경우 (입력: "pobi;woni;jun")
     1. 이동 횟수
        - 빈 문자열인지 확인 (입력: "")
3. Racing 로직 시작 전
   1. 자동차 이름
      - 쉼표를 기준으로 문자열 나눠서 자동차들 초기화
      - 이름이 5자 초과인 경우 (입력: "abcdef")
   2. 이동 횟수
      - 숫자인지
      - 양수인지
      - 너무 큰 숫자인지 확인
4. Racing 로직
   1. 랜덤 숫자 생성(0 ~9) 후, 4 이상일 경우 전진
   2. 사용자에게 입력 받은 횟수만큼 i 반복
5. 출력
   1. 단독 우승자일 경우
      - 출력 : "최종 우승자 : [자동차 이름]"
   2. 공동 우승자일 경우
      - 출력 : "최종 우승자 : [자동차 이름], [자동차 이름]"