# java-racingcar-precourse

## ︎⚙️ .gitignore 설정
### "[7기] 프리코스 1주 차 웹 백엔드 피드백" 
* "Git으로 관리할 자원을 고려한다" 내용 중, "IntelliJ IDEA의 .idea 폴더와 Eclipse의 .metadata 폴더" 제외

## 🚀 초간단 자동차 경주 게임을 구현한다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## ︎📝 구현할 기능 목록
### - 경주에 참여하는 자동차 이름을 입력 받기
* 자동차 경주게임에 참여하는 차량의 이름을 입력받는다. 이 때, MVC 구조를 고려한다.
* 사용자에게 전달되는 메시지는 상수를 이용한다.
* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션을 종료한다.
* 자동차 이름의 입력은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 차량의 대수를 저장소에 저장하고, 저장소에 저장된 개수를 체크하는 테스트코드 작성한다.
### - 자동차 레이싱 시도 회수 입력 받기
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 자동차 레이싱 시도 회수 입력값 검증
### - Repository에 여러 자동차 저장
* 저장소를 만들어 경기에 참여하는 차량들을 보관
### - 저장소에 있는 자동차들을 이용해서 레이싱 게임 처리
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.