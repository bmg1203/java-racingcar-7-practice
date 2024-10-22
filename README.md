# java-racingcar-precourse

#### 기능 개발 계획

### 1. 도메인 모델 개발
- [x] Car 클래스 구현
  - [x] 이름 저장
  - [x] 전진 기능 구현 (0-9 값 중 4이상일 때)
  - [x] 현재 위치 상태 관리
- [x] CarList 클래스 구현
  - [x] 여러 자동차 관리
  - [x] 우승자 판단 로직

### 2. 입력 기능 구현
- [ ] 자동차 이름 입력 처리
  - [ ] 쉼표(,)를 기준으로 이름 분리
  - [ ] 이름 유효성 검증
    - [ ] 빈 문자열 체크
    - [ ] 이름 길이 5자 초과 체크
- [ ] 시도 횟수 입력 처리
  - [ ] 양의 정수만 입력
  - [ ] 숫자 유효성 검증

### 3. 게임 진행 기능 구현
- [ ] 게임 라운드 진행
  - [ ] 각 차량 별 전진 처리
  - [ ] 각 라운드 직후 상태 출력 요청
- [ ] 게임 결과 처리
  - [ ] 우승자 처리

### 4. 출력 기능 구현
- [ ] 라운드별 진행 상황 출력
  - [ ] 각 자동차별 이름과 위치 출력
  - [ ] 진행 상황 시각화(이름 : - 로 표현)
- [ ] 최종 우승자 출력
  - [ ] 단독 우승자 출력 포맷
  - [ ] 공동 우승자 출력 포맷(쉼표 구분)

### 5. 예외 처리
- [ ] 입력값 예외 처리
  - 자동차 이름 관련 예외
  - 시도 횟수 관련 예외
  - IllegalArgumentException 처리

### 6. 테스트 코드 작성
- [ ] 도메인 모델 테스트
  - [x] Car 클래스 단위 테스트
  - [ ] CarList 클래스 단위 테스트
- [ ] 입력 처리 테스트
- [ ] 게임 진행 테스트