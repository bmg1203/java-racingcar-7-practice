# java-racingcar-precourse

## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 주의 사항 ( 1주차 피드백 반영 )
1. 배열 대신 컬렉션 사용
2. 풀리퀘스트 이후 close 하지 않기
3. indent depth < 3
4. 3항 연사자 사용금지
5. 메서드는 한가지 일만 하도록 구현

## 📜 구현할 기능 목록

### 1. 입력
- [X]경주할 자동차 이름 입력받기
  - [X] 이름이 5글자 이하인지 판단하기
  - [X] 이름을 (,) 기준으로 구분하기
  - [x] 이름을 컬랙션에 저장하기
- [] 시도할 횟수 입력받기

### 2. 자동차 이동
- [] 시도할 횟수 만큼 pickNumberInRange() 호출하기
- [] 4이상의 숫자가 나오는 경우 전진하기
- [] 전진하는 경우 이동거리 업데이트하기
  - [] 이동거리 최대값 기록하기

### 3. 우승자 선정하기
- [] n대의 자동차들의 이동거리가 최대값과 일치하는지 비교하기
- [] 최대값과 일치하는 자동차를 컬랙션에 저장하기

### 4. 출력
- [] 자동차 입력받는 문장 출력하기
  - [] 문장 : 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
- [] 시도 횟수 입력받는 문장 출력하기
  - [] 문장 : 시도할 횟수는 몇 회인가요?
- [] 실행결과 출력하기
  - [] 입력받은 순서대로 출력하기
  - [] "자동차 이름 : 이동(-)" 형식으로 출력하기
- [] 최종결과 출력하기
  - [] 입력받은 순서대로 출력하기
  - [] "최종 우승자 : 자동차 이름" 형식으로 출력하기

### 5. 예외처리
- [] 사용자가 잘못된 값을 입력하는 경우 IllegalArgumentException 발생
  - [] 자동차 이름 입력시 6글자 이상일 경우
  - [] 자동차 이름이 공백인 경우
  - [] 횟수 입력 시 숫자가 아닌 경우
  - [] 예외 발생 후 애플리케이션 종료

### 6. 테스트 코드
- [] 각 단위 테스트 구현
- [] 통합 테스트 구현
- [] 예외 테스트 구현

## ⚙️ 아키텍처
DDD(도메인 주도 설계) structure

사용 이유 : MVC 패턴과의 비교

### 레이어
- Presentation layer : user interface로 사용
- Application layer : 비즈니스 로직으로 사용 (service)
- Domain layer : 실질적인 도메인에 대한 정보 및 도메인 로직 (model)
- Infrastructure layer : 외부 통신 대신 저장소로 사용
