# java-racingcar-precourse

# 구현 주제 
- 초간단 자동차 경주 게임
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있으며, 최종 우승자를 판단하는 게임

# 기능 요구 사항
1. 사용자 입력 기능
    (1) 경주할 자동차 이름 입력 기능 
        - 실행시 문구: 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
        - 자동차 이름은 쉼표(,)를 기준으로 구분
        - 자동차 이름은 5자 이하만 가능
        - 실행시 다음 문구가 출력됨: 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    (2) 시도할 횟수 입력 기능
        - 몇 번의 이동을 할 것인지 사용자가 입력 가능
        - 경주할 자동차 이름 입력 받은 후 다음 문구가 출력됨: 시도할 횟수는 몇 회인가요?
        - 추가 예외 처리: 시도할 횟수는 숫자만 입력 가능
   (3) 입력 기능 예외 처리 
    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료 시킴

2. 전진 및 멈춤 기능
   - 자동차 n대 만큼 0에서 9 사이에서 무작위 값을 구하는 기능
   - 무작위 값이 4 이상일 경우 전진, 3 이하일 경우 멈춤에 대한 구분 기능
   - 해당 차수의 자동차마다 전진과 멈춤 결과 저장 기능 
   - 시도할 횟수 만큼 반복해서 전진과 멈춤 기능 실행

3. 차수별 실행 결과 출력 기능
   - 자동차 이름을 같이 출력하며, ':' 구분자 뒤에 전진 결과 출력
   - 전진시 '-'를 이용하여 표시
   - 출력 예시
    ```
    pobi : --
    woni : ----
    jun : ---
    ```

4. 최종 우승자 계산 기능 및 출력
   - 모든 회차가 끝난 후 가장 멀리 이동한 자동차를 최종 우승자로 판단하는 기능
   - 우승자가 여러명일 경우 쉼표(,)를 이용하여 구분
   - 최종 우승자 결과 문구 출력: 최종 우승자 : {우승자 목록} 


