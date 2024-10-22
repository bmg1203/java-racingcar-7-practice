<p>
    <img src="https://github.com/user-attachments/assets/c811c2be-923e-4134-a7d4-56bd12198910" alt="우아한테크코스" width="300px">
</p>

# 기능 목록

1. 사용자 입력 1 (자동차 이릅)
    - 자동차 이름을 입력 받는다.
    - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
    - 선 출력 사항 : (경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분))
2. 사용자 입력 2 (시도 횟수)
    - 시도 횟수를 입력 받는다. (몇 번의 이동을 할 것인지)
    - 선 출력 사항 : (시도할 횟수는 몇 회인가요?)
3. 자동차 객체 생성
   - 이름과 전진 횟수를 가진 자동차 Class를 만든다.
   - 사용자 입력으로 받은 자동차 수만큼 자동차 객체를 생성한다.
4. 실행 결과 출력
   - 선 출력 사항 : (실행 결과)
   - 모든 자동차들의 전진 정도를 각 시도 마다 출력해야 한다.
   - 출력 예시 : (sabin : ---)
   - 각 자동차가 시도마다 0~9까지의 랜덤 수를 뽑아 4이상이면 전진한다.
5. 자동차 경주 완료 후 결과 출력
   - 가장 멀리 전진한 자동차의 이름을 출력한다.
   - 우승자는 한명 이상일 수 있으며, 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

# 예외 사항
`사용자가 잘못된 값을 입력할 경우
IllegalArgumentException을 발생시킨 후
애플리케이션은 종료되어야 한다.`
1. 자동차 이름 사용자 입력 중 자동차 이름이 5자를 초과할 경우
2. 시도 횟수 입력 중 정수가 아닐 경우