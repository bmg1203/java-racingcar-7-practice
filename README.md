# java-racingcar-precourse

## v1의 가정
1. 다른 외부 요소 없이 자동차만이 자신의 위치를 변경 가능
2. 게임은 CLI 전용 텍스트 게임

### Step1 : 자동차 
1. 자동차는 자신의 위치, 이름 같은 정보를 관리할 수 있음.
   1. 자신의 위치를 변경할 수 있다
   2. 자신의 위치를 외부에 알려줄 수 있다.

### Step2 : 자동차 행동 결정자
1. 자동차에게 멈출지, 전진할지 결정하는 객체
   1. 문제에서 주어진대로 5 / 10 확률로 전진, 정지

### Step3 : 게임
1. 자동차 게임에서 몇 번 시도할지 관리
2. 누가 우승할지 구하고 출력

### Step4 : 사용자 입출력
1. 문자열 입력
2. 시도할 횟수 입력
3. 실행 결과 출력
4. 최종 우승자 출력

## V1의 문제점
step4 까지 구현하지 않았지만 tag v1.0까지의 버전은 다음의 문제가 있다.

### CarGame 객체의 책임이 너무 큼
1. 몇 턴을 진행할지 보관
2. 정해진 턴 개수만큼 각 자동차마다 메시지를 날려 움직임을 시도
3. 자동차를 움직일지 말지도 Decider에게 메시지를 날려 결정후 실제로 움직임. 
4. 자동차의 현재 상태를 출력
5. 승리자를 결정함.

## V1.1의 방향성
### 이 책임들을 다른 여러 객체로 분산을 하려 한다.
#### 특히 출력 같은 경우, 다른 형태로 출력하기 위해서는 반드시 분리가 필요하다 (ex. file, socket)
#### 움직일지 결정을 분리. Game은 Car가 실제로 움직인지 아닌지는 몰라야 함.
#### 결과적으로 Game 객체는 정해진 턴 동안 각 Car 객체에게 메시지를 날리고 승리자를 계산하는 역할만 하도록 하려 한다.

### 이를 위해서는 
#### Car 객체를 랩핑하는 CarUpdater으로 Car가 앞으로 갈지 말지 결정하는 책임을 분리
#### CarUpdater은 여러 Observer에 대한 참조를 가지고 있고, update 시도시 Observer들에게 notify
원하는 출력 Observer들이 이를 구독하여, 환경에 맞게 출력이 되도록 한다.
#### CarGame 객체도 출력을 담당하는 Observer에 대한 참조를 가지고, 이 Observer들에게 승리자 이름을 넘겨 notify 한다

## V1.2의 방향성
### 출력에 대한 책임을 다른 객체로 옮긴 것은 좋았으나 구현 사항에 맞지 않음
전체 참가자 자동차들을 모두 출력하고 개행을 위해서는 지금 같은 방식이면 안됨.
### 유저 입출력에 대한 추상화 필요.
지금은 static method로 모두 공개되어 있음.
### BufferedWriter를 계속 생성하는 대신 재사용하도록 수정이 필요함.
Factory 메소드 대신 Factory객체에서 인스턴스화 하도록 하는게 나아보임