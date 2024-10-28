# java-racingcar-precourse

## 구현할 기능 목록
### ✅️ 자동차 이름을 입력받는 기능 
  - 각각의 자동차 이름은 쉼표를 기준으로 분리했을 때 5자 이하여야 한다.
  - 입력값에 포함된 공백은 제거한다. (입출력 요구사항의 예제 참고)
  - 위 조건이 지켜지지 않을 경우 IllegalArgumentException 

### ✅ 시도할 횟수를 다음 줄에서 입력받는다.
  - 숫자가 아닐 경우 IllegalArgumentException을 발생시킨다.

### ✅ 자동차가 움직일 칸을 계산하고 위치정보를 업데이트 하는 기능 
- pickNumberInRange 메소드를 이용하여 결과를 확인한 후 자동차의 위치정보를 업데이트 한다. 

### ✅ 자동차 위치정보를 출력하는 기능
- 각 자동차의 위치 정보에 맞게 (-)를 출력해준다. 

### ✅ 최종 우승자 출력 기능
- 점수가 가장 높은 자동차를 찾아 이름을 출력해준다. 

## 자동차 클래스 구조
### ✅ 요구사항에는 없으나, 변경 가능성을 최소화하고 확장엔 용이하게 하기 위해 Vehicle 인터페이스를 만들었습니다.
- Vehicle 인터페이스에는 move 메소드가 정의되어 있습니다. 
- Vehicle 인터페이스를 구현하는 Car 클래스
  - 필드 : name, location
  - 메소드 : move(overriding), printLocation
