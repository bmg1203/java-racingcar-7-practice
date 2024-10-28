# java-racingcar-precourse

## 기능 요구 사항

### 1. RequestView

- [X] inputCarsNames: 자동차 이름 입력 메서드
- [X] inputTryCount: 시도 횟수 입력 메서드

### 2. StringUtils

- [X] validateNotEmpty - 입력 받은 문자열이 비어있는지 검증하는 메서드
- [X] toNumber - 문자열을 숫자로 형 변환 메서드

### 3. Car

- [X] 자동차 도메인 작성
    - name: String - 자동차의 이름
    - moveCount: int - 자동차가 움직인 횟수
- [X] 생성자
    - [X] validateName - 자동차의 이름은 5글자 이하 검증 메서드 (5글자 초과시 예외 발생)
- [X] canMove - 자동차가 움직일 수 있는가 판별 후 이동하는 메서드
- [X] move - 자동차가 한 칸 이동하는 메서드
- [X] print - 자동차의 현재 상태를 출력하는 메서드
- [X] isWinner - 자동차가 승리했는지 판별하는 메서드

### 3. CarRepository

> 자동차를 관리하는 저장소
> `Java`의 `Map`을 사용하여 관리 및 저장

- [X] save - 자동차 저장 메서드
- [X] findAll - 자동차를 전체 조회하는 메서드
- [X] existByName - 해당 이름을 가진 데이터 있는지 조회하는 메서드
- [X] existWinner - 우승자가 존재하는지 조회하는 메서드
- [X] findByWinnersByTryCount - 우승한 자동차를 조회하는 메서드

### 4. RacingService

- [X] saveAll - 입력 받은 문자열을 가지고 자동차를 모두 저장하는 메서드
- [X] race - 레이스 진행하는 메서드
- [X] canRacing - 레이스를 진행할 수 있는지 확인하는 메서드
- [X] getWinnerNames - 우승한 사용자의 이름을 가져오는 메서드

### 5. ResponseView

- [X] printRaceResult - 레이스 결과 출력 메서드
- [X] printWinnerNames - 우승한 사용자의 이름 출력 메서드