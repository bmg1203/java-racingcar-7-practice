# java-racingcar-precourse

## 기능 목록 - v1

> ### 1️⃣사용자 입력 처리
> &emsp; **문자열 입력 및 구분자 처리**
> - [x] 문자열 입력 (`camp.nextstep.edu.missionutils.Console`의 `readLine()` 활용)
> - [x] 입력받은 이름을 쉼표(,)를 기준으로 분할
> - [x] 사용자로부터 레이스 진행 횟수 입력 받기
> - [x] 이름의 유효성 검증
> - [x] 횟수의 유효성 검증

> ### 2️⃣게임 로직 처리
> &emsp; **자동차 전진 및 멈춤 로직**
> - [ ] 각 자동차에 대하여 무작위 값(0-9) 생성 (`camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 활용)
> - [ ] 생성된 값이 4 이상인 자동차만 전진
> - [ ] 결과 출력

> ### 3️⃣결과 및 우승자 판정
> &emsp; **게임 종료 후 결과 출력**
> - [ ] 모든 라운드가 끝난 후 각 자동차의 최종 위치를 출력
> - [ ] 가장 멀리 간 자동차(들)를 우승자로 판정
> - [ ] 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력