## 레이싱카 우승자 출력 프로그램
<br>

## 소개🚀
- - -
이 프로그램은 참가 차량를 입력 받고 총 진행 라운드를 입력받습니다.<br>
이후 각 라운드 별 차량은 0~9 사이의 랜덤한 값을 받고 그 값이 4 이상이면 전진하고
4 미만이면 정지합니다. <br>
매 라운드가 진행된 후 차량의 현재 이동 거리를 출력해줍니다. 모든 라운드가 종료된 후
가장 많이 전진한 차량을 우승자로 선정하고 출력합니다.

<br>

## 디렉토리 구조📁
- - -
```
C:.
│  tree.txt
│  
├─main
│  └─java
│      ├─controller
│      │      RacingCarController.java
│      │      
│      ├─exception
│      │      ErrorCode.java
│      │      
│      ├─model
│      │      RacingCar.java //참가하는 자동차 클래스
│      │      RacingGame.java //레이싱 게임 객체
│      │      RacingGameService.java //레이싱 게임 방식(인터페이스)
│      │      RandomRacingGameService.java // 랜덤 레이스 게임 방식(구현체)
│      │      RandomUtil.java
│      │      
│      ├─parser
│      │      RacingCarParser.java //차량 이름 parser
│      │      RacingRoundParser.java //레이싱 라운드 parser
│      │      
│      ├─racingcar
│      │      Application.java
│      │      
│      ├─validator
│      │      Validator.java
│      │      
│      └─view
│              RacingCarView.java //출력, 입력
│              
└─test
    └─java
        └─racingcar
                ApplicationTest.java
                RacingCarResultUtil.java //예측 결과 메시지 작성 util
```

<br>

## 기능 구현 목록🖥️
- - -
## controller
진행 로직 
1. 자동차 목록을 입력받는다 
2. 진행 횟수를 입력받는다
3. 경주 게임 객체를 만든다
4. 게임을 시작한다.
5. 우승자를 출력한다.

## model
### 경주 서비스(경기 진행 방식)
- 레이스를 진행하는 메소드(runRace)

### 경주 게임 객체
필드
- List<경주 자동차 객체>
- 경기 진행 방식(경주 서비스)

메소드
- 경기 진행 방식에 맞게 게임을 시작하는 메소드

### 경주하는 자동차 객체
필드
- Car 객체
- 총 전진 횟수

메소드
- 총 전진 횟수 증가

## view
### Input, Output
- 경주할 자동차 이름 받기
- 시도 횟수 받기
- 실행 결과 텍스트
- 1회차 진행 과정 출력
  - 한 차랑의 진행 과정 출력
- 최종 우승자 출력


## 예외
- 경주할 자동차 이름 입력 받을 때 발생 예외
  - 양식이 맞지 않을 때
  - 같은 이름의 자동차가 있을 때
    - 대문자, 소문자 구분 안할 예정
  - 이름이 5글자를 넘어갈 때
  - 이름이 빈칸일 때
- 총 진행 횟수를 입력 받을 때
  - 숫자가 아니면 예외 발생
  - 음수일 때 예외 발생