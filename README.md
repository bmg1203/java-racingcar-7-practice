# java-racingcar-precourse

### 🖥️ 프로그램 진행 흐름

1. 자동차 경주 게임을 시작하고 플레이어에게 경주할 자동차 이름을 입력받는다.
    ``` 
    "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    ```
2. 입력 받은 자동차 이름에 대한 예외 처리를 진행한다.
    - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하여야 한다.
3. 플레이어는 시도할 횟수를 입력한다.
    ``` 
    "시도할 횟수는 몇 회인가요?"
    ```
4. 시도 횟수에 대한 예외 처리를 진행한다.
    - 시도 횟수는 자연수여야 한다.
5. 각 자동차별로 0에서 9 사이의 무작위 값을 구한다.
6. 무작위 값으로 전진 여부를 결정해서 차를 이동시키고 이동 결과를 출력한다.
    ``` 
    pobi : -
    woni :
    jun : -
    ```
7. 시도 횟수만큼 반복한다.
8. 이동이 모두 종료되면 최종 우승자를 출력한다.
    - 단독 우승자인 경우
      ```
      최종 우승자 : pobi
      ```
    - 공동 우승자인 경우(쉼표(,)를 이용하여 구분한다.)
      ```
      최종 우승자 : pobi, jun
      ```

### 🚨예외처리 사항 정리

```
플레이어가 입력한 경주할 자동차 이름과 시도할 횟수에 대한 예외처리를 진행해야 한다. 
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.
```

- 경주할 자동차에 대한 예외사항
    - 문자열을 입력하지 않은 경우
    - 자동차기 한 대만 존재하는 경우(pobi)
    - 자동차와 쉼표 사이에 공백이 존재하는 경우(pobi, jun)
    - 쉼표와 쉼표 사이에 자동차 이름을 입력하지 않은 경우(pobi,,jun)
    - 자동차 이름의 길이가 5자 이하가 아닐 경우(pobiii,jun)
    - 자동차 이름이 중복된 경우(jun,jun)
- 게임 시도 횟수에 대한 예외사항
    - 입력하지 않은 경우
    - 수가 아닐 경우(ㄱ,세번,삼,오,five)
    - 음수나 0일 경우(-1, 0, -3)

---

### 💻 구현 목록 정리

#### Domain

- [CarName]
    - 자동차의 이름들을 처리한다.
    - [x] 자동차 이름에 대한 유효성을 검증한다.
        - [x] 자동차와 쉼표 사이에 공백이 존재하는 경우
        - [x] 쉼표와 쉼표 사이에 자동차 이름을 입력하지 않은 경우
        - [x] 자동차 이름의 길이가 5자 이하가 아닌 경우
- [Car]
    - 각 자동차의 정보가 담겨있다.
    - [ ] 자동차의 이름을 저장한다.
    - [ ] 랜덤으로 얻은 정수에 대한 결과를 저장한다.
    - [ ] 정수를 바탕으로 이동할 수 있는지 여부를 결정한다.
    - [ ] 이동한 결과를 저장한다.
- [Cars]
    - 자동차들의 정보가 담겨있다.
    - [ ] 자동차들의 이동을 관리한다.
    - [ ] 자동차가 한 대만 존재하는 경우 예외처리를 진행한다.
    - [ ] 자동차 이름이 중복되는 경우 예외처리를 진행한다.
- [AttemptNumber]
    - 시도할 횟수를 저장한다.
    - [ ] 시도 횟수에 대한 유효성을 검증한다.
        - [ ] 수가 아닌 경우
        - [ ] 음수인 경우
        - [ ] 0인 경우
- [Winners]
    - [ ] 승리한 자동차를 찾아서 관리한다.

#### View

- [InputView]
    - [x] 자동차 이름을 입력받는다.
      ``` 
      "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
      ```
    - [x] 시도할 횟수를 입력받는다.
      ``` 
      "시도할 횟수는 몇 회인가요?"
      ```
    - [x] 문자열을 입력하지 않았는지 확인한다.

- [OutputView]
    - [ ] 각 시도 횟수별로 결과를 출력한다.
      ```
      실행 결과 
      pobi : -
      woni :
      jun : -
      ```
    - [ ] 최종 우승자를 출력한다.
      ``` 
      최종 우승자 : pobi, jun
      ```

#### Controller

- [Game]
    - [ ] 시도 횟수에 도달했는지 확인한다.
    - [ ] 시도 횟수만큼 게임을 반복한다.