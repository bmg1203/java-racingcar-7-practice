# 자동차 경주 게임

## 구현 기능 목록

### 1. 도메인 (domain)
- ✅ **Car 클래스**
    - 자동차 이름 저장
    - 자동차 위치 관리
    - 자동차 이동 기능

### 2. 서비스 (service)
- ✅ **RaceService 클래스**
    - 경주 진행 로직
    - 자동차 이동 조건 확인 (랜덤 값 기반)
    - 우승자 결정 로직

### 3. 컨트롤러 (controller)
- ✅ **RaceController 클래스**
    - 전체 게임 흐름 제어
    - 사용자 입력 처리
    - 경주 결과 출력 요청

### 4. 뷰 (view)
- ✅ **InputView 클래스**
    - 자동차 이름 입력 받기 (쉼표로 구분)
    - 시도 횟수 입력 받기
- ✅ **OutputView 클래스**
    - 각 차수별 경주 결과 출력
    - 최종 우승자 발표

### 5. 유틸리티 (util)
- ✅ **InputValidator 클래스**
    - 자동차 이름 유효성 검사 (1자 이상 5자 이하)
    - 시도 횟수 유효성 검사 (양의 정수)

### 6. 메인 애플리케이션
- ✅ **Application 클래스**
    - 프로그램 시작점 (main 메소드)
    - 필요한 객체 생성 및 의존성 주입

### 7. 예외 처리
- ✅ 잘못된 입력에 대한 예외 처리
- ✅ 예외 발생 시 적절한 에러 메시지 출력

### 8. 테스트
- ✅ 각 클래스에 대한 단위 테스트 작성
- ✅ 통합 테스트 작성