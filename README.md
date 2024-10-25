# java-racingcar-precourse

# 🏎️ 구현할 기능 목록

- [x] 입력을 담당하는 객체
    - 자동차 이름 입력
        - null 혹은 빈 문자열이 입력되는 경우 -> 예외
    - 시도 횟수 입력
        - null 혹은 빈 문자열이 입력되는 경우 -> 예외
- [x] 출력을 담당하는 객체
    - 시도 별 실행 결과 출력
    - 최종 우승자 문구 출력
- [x] 입출력과 도에민 사이의 흐름을 담당하는 객체
    - 입력받은 값을 도메인에게 위임한다.
    - 도메인에게 받은 결과를 출력에게 위임한다.
    - 전체적인 프로그램의 흐름을 담당한다.
- [x] 자동차 객체
    - 자동차 이름과 위치 객체를 가진다.
    - 이름과 위치에게 일을 시킨다.
- [x] 자동차 리스트를 가지는 객체
    - 자동차들을 돌며 현재 상황들을 전달받아 반환한다.
    - 자동차들을 돌며 모든 자동차에게 움직이라고 요청한다.
    - 최대 위치의 자동차들을 반환한다.
    - 생성된 자동차가 2대 이상이 아닌 경우 -> 예외
    - 중복된 이름의 자동차가 있는 경우 -> 예외
- [x] 자동차 이름 객체
    - 이름을 가진다.
    - 입력된 이름이 5자 초과인 경우 -> 예외
- [x] 위치 객체
    - 움직임을 컨트롤 한다.
    - 랜덤한 숫자에 따라 4 이상인 경우 전진, 4 미만인 경우 대기
- [x] 랜덤 숫자 생성 객체
    - 0 - 9 사이의 무작위값 생성
- [x] 자동차 경주 게임 객체
    - 경주를 진행한다.
    - 현재 결과와 우승자를 찾아 반환한다.
- [x] 시도 횟수 객체
    - integer 범위를 넘는 경우 -> 예외
    - 양수 범위를 넘는 경우 -> 예외
