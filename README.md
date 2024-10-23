# java-racingcar-precourse
우아한테크코스 7기 프리코스 2주차 미션 **자동차 경주**

- 진행 기간: 24.10.22(화) 15:00 ~ 24.10.28(월) 23:59
  - 제출 가능 시간: 24.10.27(일) 15:00 ~ 24.10.28(월) 23:59

## 문제 파악하기
- 핵심 기능: `비교하기`
  - 구체적으로 작성: `자동차 거리를 비교하기`
    - 하위 핵심 기능1: `자동차를 달리게 하기(거리 관련)`
    - 하위 핵심 기능2: `우승자를 판별하기(비교하기)`

## 구현할 기능 목록
### 자동차 달리기
- [x] 자동차 추가 하기
  - [x] `pobi, pobi`처럼 중복 이름이 있는 경우 `IllegalArgumentException`
- [x] 자동차 거리 전진
  - [x] 모든 자동차가 1번 이동 및 결과 반환
  - [x] `0,1,2,3` : 이동하지 않음 / `4,5,6,7,8,9`: 전진

### 우승자 판별하기
- [x] 자동차 거리를 비교해서 가장 멀리간 자동차들을 구하기

### 입출력
- [ ] 사용자에게 입력받기
  - [ ] 자동차 이름을 입력받기
    - [ ] `pobi, woni, jun`처럼 ` `이 있는 경우와 `pobi,woni,jun`처럼 공백이 없는 경우 정상 작동
    - [x] `,,`같은 입력 `IllegalArgumentException`
      - [x] `a,,b,c`나 `,,,`
    - [x] `,pobi,woni`, `pobi,woni,` 처럼 끝에 `,`가 있는 경우 `IllegalArgumentException`
  - [ ] 시도 횟수를 입력받기
    - [x] 숫자가 아닌 경우 `IllegalArgumentException`
    - [x] 음수를 입력한 경우 `IllegalArgumentException`

### 프로그램 연결하기
- [ ] 입출력과 핵심로직(자동차 달리기, 우승자 판별하기)을 조합해 완성된 프로그램 로직 구현