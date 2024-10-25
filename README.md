# java-racingcar-precourse

---

## 구현할 기능 목록
- [ ] 경주할 자동차 이름들을 입력받는다.
    - [ ] 자동차 이름은 쉼표를 기준으로 구분한다.
    - [x] 자동차 이름은 5자 이하만 가능하다.
    - [ ] 사용자가 잘못된 값을 입력할 경우
      `IllegalStateException`를 발생시키고 애플리케이션은 종료된다.
        - [x] null 입력
        - [x] ""입력
        - [x] 특수문자, 숫자, 한글 입력
        - [ ] 글자와 숫자 혼합 입력

- [ ] 몇 번의 이동을 할 것인지 입력받는다.
    - [ ] 주어진 횟수 동안 자동차들은 전진 또는 멈출 수 있다.
    - [ ] 전진하는 조건은 0에서 9사이의 무작위 값을 구한 후 그 값이 4 이상일 경우이다.
    - [ ] 사용자가 잘못된 값을 입력할 경우
      `IllegalStateException`를 발생시키고 애플리케이션은 종료된다.
        - [ ] 숫자 외 String 입력
        - [ ] int 범위 외 값 입력
        - [ ] 음수 입력
        - [ ] 빈값("") 입력

- [ ] 각 차수별 실행 결과를 알려준다.
    - [ ] 사용자 이름과 현재 자동차가 몇번 이동했는지 '-' 갯수로 알려준다.

- [ ] 자동차 경주 게임을 발표한 후 누가 우승했는지 알려준다,
    - [ ] 우승자는 한 명 이상일 수 있다.
    - [ ] 우승자가 여러 명일 경우 쉼표(,)로 구분한다.
    
---

- 프로그래밍 요구 사항
  - [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - [ ] 3항 연산자를 쓰지 않는다.
  - [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
  - [ ] Unit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.