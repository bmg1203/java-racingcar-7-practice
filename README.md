# java-racingcar-precourse

---

## 2주차 미션 - 자동차 경주
### 기능 요약 : 자동차 경주를 진행하고 우승자를 선출한다
### 커스텀 기능 요구사항
- 자동차 이름에는 알파벳과 숫자만 입력 가능하다
- 자동차 이름의 중복은 허용하지 않는다
- 게임의 이동 횟수는 최소 1회, 최대 100회이다
### 기능 목록
- [x] 자동차 이름을 입력 받아 자동차를 생성한다
  

- [x] 이동 횟수를 입력 받는다
   

- [x] 각 이동마다 자동차들은 무작위의 값을 뽑는다
  

- [x] 무작위 값이 특정 값 이상이면 해당 자동차는 전진한다
  

- [x] 각 이동이 끝나고 자동차 별 이동 결과를 출력한다
  

- [x] 모든 이동이 끝나면 가장 많이 전진한 자동차를 우승자로 뽑는다
  - 공동 우승자도 가능하다
  

- [x] 우승자를 안내한다
  - 공동 우승자일 경우 구분하여 안내한다
  
  
- [x] 자동차가 한대도 없을 경우 예외를 발생한다
  

- 잘못된 자동차 이름을 입력할 경우 예외를 발생한다
  - [x] 아무 입력을 안한 경우
  - [x] 이름이 6자 이상인 경우
  - [x] 이름이 1자 이하인 경우
  - [x] 알파벳, 숫자 외 다른 문자를 입력한 경우
  - [x] 이름이 중복될 경우
  

- 잘못된 이동 횟수를 입력할 경우 예외를 발생한다
  - [x] 이동 횟수가 1 이상, 100 이하가 아닐 경우
  - [x] 정수를 입력하지 않을 경우