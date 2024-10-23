## 🚗 자동차 경주 - 기능 명세서
***
### **입력**
- [ ] 경주할 자동차 이름을 입력받는다.
  - [ ] "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"를 콘솔에 출력한다.
  - [ ] 불필요한 공백을 제거한다.
- [ ] 시도할 횟수를 입력받는다.
  - [ ] "시도할 횟수는 몇 회인가요?"를 콘솔에 출력한다.


### **로직**
1. 자동차 이름 문자열 분리
   - [ ] 입력받은 자동차 이름 문자열을 쉼표(,) 기준으로 분리한다.
     - [ ] 입력받은 문자열의 앞뒤 공백을 제거한다.
   - [ ] 분리한 자동차 이름을 저장한다.

2. 자동차 이동
   - [ ] 입력받은 게임 횟수만큼 반복한다.
     - [ ] 각 자동차에 대한 무작위 값(0~9)을 구한다.
     - [ ] 무작위 값이 4 이상이라면 자동차는 1 전진한다.

3. 우승자 계산
   - [ ] 가장 많이 전진한 자동차를 우승자로 계산한다.

### **출력**
- [ ] 회차마다, 각 자동차의 전진한 수를 '-'로 표시한다.
- [ ] 게임이 끝나면, 우승자 안내 문구를 출력한다.
  - [ ] 공동 우승자가 있을 경우 쉼표(,)로 구분하여 표시한다.

### **예외 처리**
- [ ] 자동차 이름에 아무 값도 입력하지 않으면(ex."") "자동차 이름은 공백이 될 수 없습니다." 메시지와 함께 IllegalArgumentException가 발생한다.
- [ ] 게임 횟수에 음수, 0, 문자열, 공백을 입력할 시 "양수를 입력해 주세요." 메시지와 함께 IllegalArgumentException가 발생한다.
- [ ] 자동차 이름에 공백이 들어가면 "자동차 이름은 공백이 될 수 없습니다." 메시지와 함께 IllegalArgumentException가 발생한다.
- [ ] 자동차 이름이 5자를 초과하면 "자동차 이름은 5자 이하로 입력해 주세요." 메시지와 함께 IllegalArgumentException가 발생한다.

### **테스트**
- #### 입력
  - 올바른 경우
  - [ ] 올바르게 입력됐을 시 테스트
  - 잘못된 경우
  - [ ] 자동차 이름에 공백 입력
  - [ ] 자동차 이름에 공백이 들어간 경우
  - [ ] 자동차 이름에 불필요한 공백 포함
  - [ ] 횟수에 음수 입력
  - [ ] 횟수에 문자열 입력
  - [ ] 횟수에 0 입력
  - [ ] 횟수에 공백 입력

- #### 로직
1. 자동차 이름 문자열 분리
   - [ ]  불필요한 공백 포함 시 제거되는지 테스트
2. 자동차 이동
   - [ ] 무작위 값이 4 이상일 때 자동차가 전진하는지 테스트
   - [ ] 무작위 값이 4 미만일 때 전진하지 않는지 테스트
3. 우승자 계산
   - [ ] 가장 많이 전진한 자동차가 우승자인지 테스트
   - [ ] 공동 우승자가 있을 때 테스트
