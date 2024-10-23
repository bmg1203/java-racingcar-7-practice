# 자동차 경주

## 🔥 구현할 기능 목록

---

### 입력
- [ ] 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
    ```
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,woni,jun
    ```
- [ ] 시도할 횟수
    ```
    시도할 횟수는 몇 회인가요?
    5
    ```

### 출력
- [ ] 차수별 실행 결과
    - ```-```기호로 현재 전진 상황 표시
      ```
      실행결과
      pobi : --
      woni : ----
      jun : ---
      ```
- [ ] 우승자 출력
  - 예시  
    ```
    최종 우승자 : pobi
    최종 우승자 : pobi, jun
    ```

---

### 자동차
- [ ] 쉼표를 기준으로 구분하여 자동차 이름 저장
- [ ] 현재 전진한 값 저장
- [ ] 전진하는 기능

### 컴퓨터
- [ ] 시도할 횟수 저장
- [ ] 0~9 랜덤 값 추출하는 기능
- [ ] 전진 여부를 판단하는 기능

### 우승자
- [ ] 한 명 혹은 여러 명의 우승자 이름 저장

---
### 🚫 예외 처리
- ```IllegalArgumentException```

##### 자동차 입력
- [ ] 입력값이 공백일 경우
- [ ] 이름이 5자를 초과할 경우
- [ ] ```,```를 제외한 특수기호가 입력된 경우

##### 시도 횟수 입력
- [ ] 문자가 입력될 경우

---
### 라이브러리
```Java
// 예시
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

String value = Console.readLine();

int random = Randoms.pickNumberInRange(0, 9);
```