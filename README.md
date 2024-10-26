# 📅 2주 차 프리코스 일정 (2024-10-22 ~ 2024-10-28)

### 매주 진행할 미션은 화요일 오후 3시부터 확인할 수 있으며, 다음 주 월요일까지 구현을 완료하여 제출해야 한다. 제출은 일요일 오후 3시부터 가능하다.

---

## 1. 피드백 확인 (2024-10-22 ~ 2024-10-23)

- [x] **1주 차 공통 피드백 확인** (화)
- [x] **피드백을 확인한 후, 1주 차 코드 재검토** (수)

## 2. README 작성 (2024-10-24 ~ 2024-10-25)

- [x] **요구사항 분석** (목)
- [x] **기능 구현 목록 작성** (금)

## 3. 기능 구현 (2024-10-26 ~ 2024-10-27)

- [ ] **개발 진행** (토 ~ 일)

## 4. 리팩토링 (2024-10-27)

- [ ] **리팩토링 작업 진행** (일)

## 5. 제출 준비 (2024-10-28 ~ 2024-10-29)

- [ ] **디버깅** (일)
- [ ] **최종 점검 및 제출** (일 ~ 월)

---

# 🚀 기능 구현 목록

## 입력 기능

- [x] 사용자로부터 쉼표(,)로 구분된 자동차 이름을 입력받는다.
  - [x] 예외: 자동차 이름이 5자를 초과하면 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료한다.
- [x] 사용자로부터 시도할 횟수를 입력받는다.
  - [x] 예외: 시도할 횟수가 음수이거나 숫자가 아닌 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료한다.

## 자동차 기능

- [ ] 자동차는 `이름`과 `위치` 속성을 가진다.
- [ ] 자동차는 시도할 횟수 동안 0에서 9까지의 무작위 값을 생성하여 이동 여부를 결정한다.
  - 무작위 값이 4 이상이면 전진, 4 미만이면 멈춘다.

## 우승자 판별 기능

- [ ] 자동차 경주 게임을 완료한 후 각 자동차의 최종 이동 거리를 비교하여 우승자를 판별한다.
  - 우승자는 한 명 이상일 수 있다.
  - 우승자가 여러 명일 경우, 공동 우승자로 처리하여 쉼표(,)로 구분한다.

## 출력 기능

- [ ] 매 차수마다 각 자동차의 이름과 전진 상태를 출력한다.
- [ ] 게임 종료 후 최종 우승자를 안내한다.
  - 단독 우승자 예시:`최종 우승자 : pobi`
  - 공동 우승자 예시:`최종 우승자 : pobi, jun`

---

# 💻 실행 결과 예시
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