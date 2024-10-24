자동차 경주 게임
-구현할 기능 목록
1. 자동차 이름 입력 및 검증

 쉼표(,)를 기준으로 구분된 자동차 이름들을 입력받는다.
 각 자동차 이름이 5자 이하인지 검증한다.
 이름이 공백이거나 빈 문자열인지 검증한다.
 이름에 대한 유효성 검증 실패 시 IllegalArgumentException 발생

2. 시도 횟수 입력 및 검증

 게임 시도 횟수를 입력받는다.
 입력값이 숫자인지 검증한다.
 입력값이 양수인지 검증한다.
 횟수 입력값 검증 실패 시 IllegalArgumentException 발생

3. 자동차 이동 처리

 0에서 9 사이의 무작위 값을 생성한다.
 무작위 값이 4 이상일 경우 자동차를 전진시킨다.
 무작위 값이 4 미만일 경우 자동차를 정지시킨다.

4. 실행 결과 출력

 각 라운드마다 모든 자동차의 상태를 출력한다.
 자동차 이름과 현재 위치를 함께 출력한다.
 이동 거리를 "-" 문자로 표현한다.

5. 우승자 판정 및 출력

 가장 멀리 이동한 거리를 계산한다.
 가장 멀리 이동한 거리와 동일한 거리를 이동한 자동차들을 찾는다.
 우승자가 한 명인 경우 이름을 출력한다.
 우승자가 여러 명인 경우 쉼표(,)로 구분하여 이름을 출력한다.
