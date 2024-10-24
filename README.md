# java-racingcar-precourse

# 기능 목록
## 1. 게임 설정
- [x] 사용자가 자동차 이름을 입력할 수 있는 기능
    - 이름은 쉼표(,)로 구분하며, 각 이름은 5자 이하만 허용
    - 이름이 조건에 맞지 않으면 예외 처리 (`IllegalArgumentException` 발생 후 프로그램 종료)
- [x] 사용자가 이동 횟수를 입력할 수 있는 기능
    - 잘못된 입력에 대한 예외 처리 (`IllegalArgumentException` 발생 후 프로그램 종료)

## 2. 자동차 전진 조건
- [x] 각 자동차의 전진 조건을 무작위 값(0~9)으로 결정하는 기능
    - 무작위 값이 4 이상일 경우 자동차가 전진

## 3. 게임 진행
- [x] 주어진 횟수 동안 각 자동차가 전진 또는 멈추는 기능
    - 자동차 이름과 현재 상태(위치)를 출력
    - 각 이동 시마다 전진 여부를 결정하고 결과를 출력

## 4. 우승자 판정
- [x] 게임 종료 후 우승자를 판정하는 기능
    - 가장 멀리 전진한 자동차가 우승자
    - 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력

## 5. 예외 처리
- [x] 잘못된 입력에 대한 예외 처리
    - 자동차 이름이 5자를 초과하거나 빈 문자열인 경우
    - 이동 횟수가 음수거나 숫자가 아닌 경우
    - 예외 발생 시 `IllegalArgumentException`을 발생시키고 애플리케이션 종료
