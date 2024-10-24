# java-racingcar-precourse
<br>

## 🛠️ 기능 목록

---
### 입력
  - [X] 경주할 자동차 이름을 입력받는다.<br>
    - 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
      ```
      pobi,woni,jun
      ```

      <br>

  - [X] 시도할 횟수를 입력받는다.
    - 시도할 횟수는 몇 회인가요?
      ```
      5
      ```

<br>

### 경주 진행 과정
  - 경주
    - 무작위 값 생성
      - [ ] 각 자동차 별로 0에서 9까지의 정수 중 한 개의 무작위 값을 구한다.
        - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
      
    <br>
      
    - 자동차 이동
      - [ ] 무작위 값이 4 미만일 경우 자동차는 멈추고, 4 이상일 경우 자동차는 전진한다.
      - [ ] 전진하는 자동차에 '-'를 하나 추가한다.
      
    <br>
      
    - 경주 상태 출력
      - [ ] 현재 차수의 경주 결과를 출력한다.
        - 경주 결과는 누적되어 출력된다.
        ```
        pobi : -
        woni :
        jun : -
        ```
        
    <br>
    
  - 우승자 결정
    - [ ] 각 자동차의 전진 횟수를 비교하여 '-'가 가장 많은 자동차를 찾는다.
    - [ ] 우승자는 한 명 이상일 수 있으며, '-' 수가 같은 경우 공동 우승자로 처리한다.

<br>

### 출력
- [ ] 차수별 실행 결과를 출력한다.
  ```
  pobi : --
  woni : ----
  jun : ---
  ```
  <br>
- [ ] 우승자 안내 문구를 출력한다.
    - [ ] 단독 우승자의 경우
      ```
      최종 우승자 : pobi
      ```
    - [ ] 공동 우승자의 경우
        - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
        ```
        최종 우승자 : pobi, jun
        ```

<br>

### 예외 처리
  - 자동차 이름 입력
    - [ ] 입력된 자동차 이름이 두 개 미만인 경우
    - [ ] 이름이 6자 이상인 경우

    <br>
    
  - 시도할 횟수 입력
    - [ ] 숫자가 아닌 경우
    - [ ] 음수인 경우
    
  <!--자동차 이름이 중복돼도 될지-->

<br>

---
**실행 결과 예시**
```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

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
