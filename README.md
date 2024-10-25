# java-racingcar-precourse

## 🪐구현할 기능 목록

---

- [x] **경주할 자동차 이름 입력받기**
    - [x] 자동차 이름 입력을 요청하는 문구를 출력한다.
    - [x] 자동차 이름을 입력받는다.
        - [x] 빈 문자열, 혹은 null이 아님을 검증한다.
        - [x] 구분자가 쉼표가 사용되었는지를 검증한다.
        - [x] 자동차가 2대 이상임을 검증한다.
        - [x] 자동차 이름이 중복되지 않음을 검증한다.
        - [x] 자동차 이름이 5자 이하인지를 검증한다.

- [x] **시도 횟수 입력받기**
    - [x] 시도 횟수 입력을 요청하는 문구를 출력한다.
    - [x] 시도 횟수를 입력받는다.
        - [x] 빈 문자열, 혹은 null이 아님을 검증한다.
        - [x] 1 이상, 1,000 이하의 숫자 값임을 검증한다.

- [ ] **시도 횟수만큼 경주 결과 출력하기**
    - [x] 실행 결과의 헤더 문구 출력한다.
    - [ ] 각 자동차마다 회차별 결과를 출력한다.
        - [x] 자동차 별로 0~9 중 랜덤으로 숫자 1개를 추출한다.
        - [x] 추출한 숫자가 4 이상일 경우에 1칸 전진한다.
        - [ ] 현재 위치를 반환한다.

- [ ] **최종 우승자 출력하기**
    - [ ] 현재 위치가 가장 큰 자동차를 선정한다.
    - [ ] 최종 우승자 선정 문구를 출력한다.
        - [ ] 만약 최종 우승자가 2명 이상이라면 쉼표로 구분한다.