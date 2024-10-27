# java-racingcar-precourse

## 구현할 기능 
**1. 경주할 자동차 이름, 시도할 횟수 입력받기**
- 입력 받은 자동차 이름의 경우, 쉼표로 구분하여 map으로 관리하기 (각 자동차의 이름을 key, 전진 횟수를 value로 설정)

**2. 각 시도마다 자동차의 전진 여부 결정**
- 각 시도마다 자동차는 0,9 사이의 무작위 값을 구하고, 해당 값이 4 이상인 경우 전진한 것으로 판단하기 (해당 자동차의 value++)

**3. 자동차의 전진 현황 출력**
- 시도한 횟수마다 자동차의 전진 현황을 출력해줘야 하기 때문에 이를 함수로 구현하기

**4. 자동차 경주 결과 종합하기**
- 모든 시도 횟수가 끝나면 자동차 경주 게임에서 누가 우승했는지 종합해서 보여주기 
- 우승자는 한 명 이상일 수 있고, 그럴 경우 쉼표로 구분하기

**5. 사용자의 잘못된 값에 대한 예외 처리**
- 이용자가 잘못된 값을 입력한 경우, IllegalArgumentException을 발생시키기
- 잘못된 값의 예시 
   - 이름이 5자를 초괴하는 경우
   - 시도 횟수가 0 or 음수인 경우
   - 시도 횟수 혹은 이름에 아무것도 입력하지 않은 경우
   - 시도에 숫자가 아닌 값을 입력한 경우

**6. 테스트 케이스 작성**
1. "song,yang,choi", "0" --> (시도 횟수에 0을 입력) IllegalArgumentException error
2. "", "3" --> (자동차 이름에 빈 값 입력) IllegalArgumentException error
3. "kevin,princ,sawn", "q" --> (시도 횟수가 숫자가 아닌 값 입력) IllegalArgumentException error
4. "nels,kawt,mac", " " --> (시도 횟수에 빈 값 입력) IllegalArgumentException error
5. "efe,fyke", "-2" --> (시도 횟수에 음수 입력) IllegalArgumentException error
6. 여러 기능 테스트들