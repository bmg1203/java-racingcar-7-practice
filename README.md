# 자동차 경주 🚗

## 기능 구현 목록 ⚙️

### 자동차 분리 기능
- [x] 사용자 입력 ',' 반점 기호 기준 분리
- [x] `예외 사항` : 자동차 이름은 5자 이하이다.
- [x] `예외 사항` : 자동차 이름은 공백일 수 없다.
- [x] `예외 사항` : 자동차 이름은 중복이 불가능하다.

### 무작위 값 추출 기능
- [x] 우아한 테크 코스 라이브러리 제공 `pickNumberInRange()` 활용
- `ex) Randoms.pickNumberInRange(0, 9);`

### 자동차 전진 기능
- [x] 무작위 값이 4 이상일 경우 전진

### 주어진 횟수 동안 실행 기능
- [x] 횟수만큼 경기 반복
    - [x] 자동차 마다 `자동차 전진 기능` 실행
    - [x] 차수 마다 출력의 `차수별 실행 결과` 실행

### 우승자 판별 기능
- [ ] n대의 차량 중 우승자 선별
- [ ] 우승자가 한 명 이상 가능성도 존재

### 자동차 상태 출력 제공 기능
- [ ] 자동차마다 회차별 출력문에 알맞는 문자열 제공 

### 입력
- [x] 경주할 자동차 이름 `ex) pobi,woni,jun`
- [x] 시도할 횟수 `ex) 5`
- [x] `예외 사항` : 최소 차량 수는 1대 이상이다. (공백 및 ',' 단일 입력 금지)
- [x] `예외 사항` : 게임 최대 횟수는 1 이상, 1,000,000 이하이다.

### 출력
- [x] 경주할 자동차 이름 안내 문구 `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
- [x] 시도할 횟수 안내 문구 `시도할 횟수는 몇 회인가요?`
- [x] 차수별 실행 결과
```
    ex)
    pobi : --
    woni : ----
    jun : ---
```
- [ ] 단독 우승자 안내 문구 `ex) 최종 우승자 : pobi`
- [ ] 공동 우승자 안내 문구 (,) 구분 `ex) 최종 우승자 : pobi, jun`

### 최종 입력, 출력
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```