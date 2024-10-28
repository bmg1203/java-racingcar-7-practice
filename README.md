# 자동차 경주

# 1. 요구 사항 분석
## 1.1. 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시킨 후 애플리케이션은 종료되어야 한다. 

## 1.2. 입출력 요구 사항
### 1.2.1. 입력
- 쉼표(,)를 기준으로 경주할 자동차 이름을 입력
- 시도할 횟수를 입력
- 예시
    ```text
    pobi,woni,jun
    5
    ```
### 1.2.2. 출력
- 회차별 실행 결과
- 우승자 안내 문구
- 예시
    ```text
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

# 2. 요구 사항 정의서
## 2.1. Input View
- 사용자에게 자동차 이름을 입력 받는다
  - 쉼표를 기준으로 한다
- 게임 실행 횟수를 입력 받는다

## 2.2. Output View
- 회차별로 실행 결과를 출력한다
  - 자동차 이름과 자동차의 위치를 출력한다
  - 자동차의 위치는 대시(-)로 표시한다
- 우승자를 출력한다
  - 우승자의 이름을 출력한다
  - 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력한다

## 2.3. 레이싱 게임
- 게임을 실행할 횟수를 설정한다
- 게임에 참가할 자동차 명단이 있다
- 게임을 실행한다
    - 세팅된 횟수만큼 게임 한다
    - 0이상 9이하의 랜덤값을 구한다
    - 값이 4 이상이면 차를 한 칸 전진 시킨다
- 우승자를 구한다
  - 최소 한 명의 우승자가 나온다
  
## 2.4. 게임 기록
- 회차별 게임 결과를 기록한다
  - 회차, 자동차 이름, 자동차 위치를 기록한다

## 2.5. 자동차
- 이름을 가질 수 있음
  - 이름은 5자 이하여야 한다
- 앞으로 갈 수 있음
  - 조건이 4 이상인 경우만 전진한다
- 현재 위치를 알 수 있음
  - 초기의 현재 위치는 0이다
  
# 3. 프로그래밍 요구 사항
- JDK 21 버전
- build.gradle 파일 변경 금지
- 제공된 라이브러리 이외의 외부 라이브러리 사용 금지
- indent 의 depth 는 2까지만 허용
- 3항 연산자를 쓰지 말 것
- SRP 원칙을 지킬 것
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인