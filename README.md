## 구현할 기능 목록
### InputHandler
- [x] 사용자로부터 자동차명을 입력받는다.
  - 자동차명은 쉼표(,)를 기준으로 구분되어야 한다.
- [ ] 사용자로부터 시도 횟수를 입력받는다.
### InputValidator
- [x] 자동차명을 올바른 형식으로 입력했는지 검증한다.
    - 자동차명은 5자 이하여야 한다.
    - 자동차명은 `null`이거나 `""`, `" "`일 수 없다.
    - 자동차명에 공백을 허용하지만, 자동차 이름 맨 앞이나 맨 뒤에 붙은 공백은 없는 걸로 간주한다.
- [ ] 시도 횟수를 올바른 형식으로 입력했는지 검증한다.
    - 시도 횟수는 1 이상의 정수여야 한다.
### Game
- [ ] 게임을 시작한다.
- [ ] 입력받은 자동차 이름을 기반으로 자동차를 생성한다.
- [ ] 각 라운드를 진행한다.
- [ ] 우승자를 결정한다.
### Car
- [ ] 무작위로 뽑은 값이 4 이상이면 전진한다.
- [ ] 자동차의 이름과 현재 위치를 반환한다.
    - 자동차의 이름과 현재 위치는 `pobi : --` 형식으로 반환한다.
### RandomUtil
- [ ] 0에서 9 사이에서 무작위 값을 뽑는다.
### GameView
- [ ] 자동차명을 입력하라는 메세지를 출력한다.
    - `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
- [ ] 시도 횟수를 입력하라는 메세지를 출력한다.
    - `시도할 횟수는 몇 회인가요?`
- [ ] 차수별 실행 결과를 출력한다.
- [ ] 우승자를 출력한다.
    - 단독 우승자인 경우 `최종 우승자 : pobi` 형식으로 출력한다.
    - 공동 우승자인 경우 ` ,`로 이어붙여 `최종 우승자 : pobi, jun` 형식으로 출력한다.










