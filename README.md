# java-racingcar-precourse


# 구현할 기능 목록


## 🗂️ Model

### Car (자동차)
- [x] 자동차 정보 제공
    - [x] 자동차의 이름을 설정 및 반환한다.
    - [x] 자동차의 현재 위치를 설정 및 반환한다.
- [ ] 자동차 이동 로직
    - [ ] 주어진 조건에 따라 자동차의 전진 여부를 결정한다.

### Cars (경주에 참여하는 모든 자동차)
- [ ] 자동차 이름 검증
    - [ ] 입력된 자동차 이름이 0개일 경우, 예외를 발생시킨다.
    - [ ] 중복된 자동차 이름이 있을 경우, 예외를 발생시킨다.
- [ ] 자동차 경주 진행
    - [ ] 경주가 진행될 때 모든 자동차를 전진시킨다.
- [ ] 우승자 결정
    - [ ] 경주 우승자 또는 공동 우승자를 결정하고, 우승자의 이름을 반환한다.

### Name (이름)
- [x] 이름 관리
    - [x] 초기 이름을 설정한다.
    - [x] 현재 이름을 반환한다.
- [x] 이름 유효성 검증
    - [x] 이름이 빈 문자열일 경우, 예외를 발생시킨다.
    - [x] 이름이 5자를 초과할 경우, 예외를 발생시킨다.

### Position (위치)
- [x] 위치 관리
    - [x] 초기 위치를 설정한다.
    - [x] 현재 위치를 반환한다.
    - [x] 자동차가 전진할 때마다 위치를 업데이트한다.

### TryCount (실행 횟수)
- [ ] 실행 횟수 검증
    - [ ] 실행 횟수가 1 이상이 아니거나 유효한 정수가 아닐 경우, 예외를 발생시킨다.
    - [ ] 실행 횟수가 설정된 범위를 벗어날 경우, 예외를 발생시킨다.

### Winners (우승자)
- [ ] 우승자 결정
    - [ ] 가장 멀리 이동한 자동차를 우승자로 결정한다.
    - [ ] 여러 명의 공동 우승자가 있을 경우, 모든 우승자의 이름을 반환한다.


## 👀 View

### InputView (입력 뷰)
- [x] 사용자 입력 처리
    - [x] 경주할 자동차 이름들을 입력받는다.
    - [x] 경주 실행 횟수를 입력받는다.

### OutputView (출력 뷰)
- [x] 경주 진행 상태 출력
    - [x] 각 경주 턴마다 자동차의 현재 위치를 출력한다.
- [x] 최종 결과 출력
    - [x] 최종 우승자를 출력한다.


## 🕹️ Controller

### RaceManager (경주 매니저)
- [x] 경주 관리
    - [x] 입력받은 자동차 이름과 실행 횟수를 바탕으로 경주를 진행한다.
    - [x] 경주가 종료되면 우승자를 결정하고 결과를 출력하도록 한다.


## ⚠️ Exception

### InvalidInputException (예외 처리)
- [x] 예외 처리
    - [x] 잘못된 입력(자동차 이름, 실행 횟수 등)에 대한 예외를 모아서 처리하고 적절한 오류 메시지를 제공한다.


## 💬 Message

### ErrorMessages (오류 메시지)
- [x] 모든 자동차 이름 관련 오류 메시지
    - [x] 입력된 이름이 없을 때 오류 메시지를 제공한다.
    - [x] 중복된 이름이 있을 때 오류 메시지를 제공한다.
- [x] 자동차 이름 관련 오류 메시지
    - [x] 이름이 빈 문자열일 때 오류 메시지를 제공한다.
    - [x] 이름이 5자를 초과할 때 오류 메시지를 제공한다.
- [x] 실행 횟수 관련 오류 메시지
    - [x] 유효하지 않은 실행 횟수에 대해 오류 메시지를 제공한다.

### InfoMessages (정보 메시지)
- [x] 입력 안내 메시지
    - [x] 경주할 자동차 이름을 입력하라는 메시지를 제공한다.
    - [x] 실행 횟수를 입력하라는 메시지를 제공한다.
- [x] 출력 안내 메시지
    - [x] 경주 결과를 출력하기 전에 안내 메시지를 제공한다.
    - [x] 최종 우승자를 출력하기 위한 안내 메시지를 제공한다.
