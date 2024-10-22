# java-racingcar-precourse

## 구현 기능 목록 작성

- 자동차 객체 구현 (이름 부여, 전진 횟수 적립)
- 자동차 이름을 입력 받기
- 이름을 쉼표를 기준으로 구분하여 객체 생성 (각 5자 이하로 제한)
- 몇 번의 이동을 할 것인지 사용자에게 입력 받기
- 전진하는 조건 생성 (0~9 무작위 값 중 4 이상)
- 게임 진행 로직 구현 (모든 자동차들이 입력받은 횟수만큼 이동시도를 통한 전진횟수 적립)
- 게임 종료 후 적립된 전진 횟수를 비교하여 우승자 확인
- 우승자 출력 (여러 명일 경우 쉼표로 구분)
- 예외처리 (사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 발생 후 종료)