# java-racingcar-precourse

1. 사용자에게 자동차 이름 입력받기 <br>
   (camp.nextstep.edu.missionutils.Console의 readLine()을 활용) <br>
   예) "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분 / 자동차 이름은 5자 이하)" <br>
2. 자동차 이름 배열에 저장하기 (split 사용) <br>
3. 배열 길이 확인 <br>
   _예외처리_
   - 경주할 자동차가 1대 이하일 경우
4. 배열 값 확인 map에 자동차 이름과 전진여부 담기<br>
   _예외처리_
   - 자동차 이름에 중복값이 존재할 시
   - 자동차 이름 5글자 초과할 시
   - 쉼표 사이 공백 또는 빈문자열인 경우
5. 사용자에게 시도할 횟수 입력받기 <br>
   예) "시도할 횟수는 몇 회인가요?" <br>
    _예외처리_
   - 입력값이 0 이하인 경우 
   - 입력값이 숫자가 아닌 경우 <br>    
6. 입력받은 횟수만큼 자동차는 전진 또는 멈출 수 있다. <br>
6-1. <br>
   -- 자동차이름과 실행 횟수를 경주 실행할 클래스에 넘긴다. <br>
   -- "실행결과" 출력 후 실행 횟수 만큼 반복한다.<br>
6-2. <br>
   -- 자동차 이름을 담은 배열의 길이만큼 반복하여 랜덤값 추출<br>
      (전진하는 조건 0-9 사이 무작위 값을 구하기)<br>
      (camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용 <br>
      예) Randoms.pickNumberInRange(0, 9); 하면 0-9 사이의 정수 한 개 반환) <br>
6-3. <br>
   -- 랜덤값이 4이상인 경우 전진 <br>
   -- 4이상이면 value 값 +1 <br>
6-4. <br>
   -- 자동차이름과 현재 상태 출력 <br>
   -- 값의 숫자만큼 "-" 으로 변경 <br>
6-5. <br>
   -- 제일 큰 값 추출
6-6. <br>
   -- 우승자가 여러명인 경우 list에 담기 <br>
    <br>
6의 실행 결과 예시  <br> <br>
   실행 결과 <br>
    pobi : - <br>
    woni : <br>
    jun : -<br>
    
    pobi : --<br>
    woni : -<br>
    jun : --<br>
    
    pobi : ---<br>
    woni : --<br>
    jun : ---<br>
    
    pobi : ----<br>
    woni : ---<br>
    jun : ----<br>
    
    pobi : -----<br>
    woni : ----<br>
    jun : -----<br>
7. 입력받은 횟수 종료 후 우승자 출력 <br>
   -- 우승자는 한 명 이상일 수 있다. <br>
   -- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다. <br>
   예) "최종 우승자 : pobi, jun"  
