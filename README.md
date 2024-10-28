# java-racingcar-precourse

### 🎯 요구사항
> 자동차 경주 게임 구현

- [x] 자동차 리스트 저장
    - 자동차 이름은 Console API를 이용해서 한 줄로 입력받음
    - 쉼표(,)를 기준으로 구분 & 이름은 5자 이하만 가능
    - 이름은 한글과 영어만 가능
- [x] 시도 횟수 입력
    - 몇 번의 이동을 할 것인지
    - 주어진 횟수 동안 n대의 자동차는 전진 또는 정지
- [x] 전진 || 정지
    - 전진하는 조건 : 0~9 의 무작위 값을 구한 후, 그 값이 4 이상일 경우
- [x] 차수별 실행결과 출력
    - 각 차수별로 자동차들의 위치를 `-` 를 이용하여 출력
    - `이름 : --` 형식으로 입력
- [x] 우승자 출력
    - 우승자는 한 명 이상
    - 여러명일 땐 쉼표(,)를 이용하여 구분
- 잘못된 값 입력 시 `IllegalArgumentException` 발생 후 종료