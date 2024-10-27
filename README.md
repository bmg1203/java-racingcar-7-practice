# java-racingcar-precourse
> 초간단 자동차 경주 게임을 구현한다.

## 기능 요구 사항
- 주어진 횟수 동안 `n`대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 `쉼표(,)`를 기준으로 구분하며 이름은 5자 이하만 가능하다. 
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다. 
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 `4` 이상일 경우이다. 
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다. 
- 우승자가 여러 명일 경우 `쉼표(,)`를 이용하여 구분한다. 
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 기능 목록 정리
- 자동차 이름 입력 기능
- 시도 횟수 입력 기능
- 자동차 이름 추출 기능
- 자동차 개수 2개 이상인지 검사 기능
- 자동차 이름 길이 유효성 검사 기능
- 자동차 이름 배열 -> Map<String, Integer> 변환 기능
- 입력한 시도 횟수 유효성 검사 기능
- 난수 값에 따른 전진 여부 검사 기능
- 자동차들의 현재 이동 거리 계산 기능
- 각 회기 실행 과정 출력 기능
- 최종 우승자 계산 기능
- 우승자 결과 출력