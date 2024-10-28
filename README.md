# 자동차 경주

---

## 기능 목록 정리
- [ ]  **입력 및 출력 처리:** 사용자 입력을 받고 결과를 출력하는 기능을 구현한다.
    - **InputHandler:** 사용자로부터 입력을 받기 위한 클래스를 구현한다.
    - **OutputHandler:** 경주 결과와 우승자를 출력하기 위한 클래스를 구현한다.
- [ ]  **자동차 이름 입력 처리:** 사용자로부터 자동차의 이름을 입력받고, 유효성을 검사한다.
    - **유효성 검사:** 자동차 이름은 쉼표(`,`)로 구분되며, 각 이름은 5자 이하이어야 한다.
    - **예외 처리:** 잘못된 형식의 이름 입력 시 `IllegalArgumentException`을 발생시킨다.
- [ ]  **이동 횟수 입력 처리:** 사용자가 몇 번의 이동을 할 것인지 입력받고, 유효성을 검사한다.
    - **유효성 검사:** 이동 횟수는 양의 정수여야 한다.
    - **예외 처리:** 잘못된 값 입력 시 `IllegalArgumentException`을 발생시킨다.
- [ ]  **자동차 클래스 구현:** 각 자동차를 나타내는 클래스를 구현한다.
    - **이동 메서드:** 0에서 9 사이의 랜덤 값을 생성하고, 값이 4 이상일 경우 이동 거리를 증가시킨다.
    - **상태 출력:** 자동차의 이름과 이동 거리를 문자열 형식으로 반환하는 `toString()` 메서드를 구현한다.
- [ ]  **경주 클래스 구현:** 자동차 경주를 관리하는 클래스를 구현한다.
    - **경주 시작:** 자동차 목록과 이동 횟수를 입력받아 경주를 시작하는 `startRace()` 메서드를 구현한다.
    - **결과 출력:** 각 라운드의 결과를 출력하는 메서드를 구현한다.
- [ ]  **우승자 결정 기능:** 경주가 끝난 후 우승자를 결정하고 출력한다.
    - **우승자 판단:** 가장 먼 거리를 이동한 자동차를 찾고, 여러 명일 경우 쉼표(,)로 구분하여 출력한다.
- [ ]  **예외 처리:** 잘못된 사용자 입력 시 애플리케이션이 종료되도록 예외 처리를 구현한다.
    - **예외 메시지 출력:** 발생한 예외에 대한 메시지를 사용자에게 출력한다.
