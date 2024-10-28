# java-calculator-precourse

## 기능 요구 사항

### 1. 입력 처리

- **기능**: 사용자로부터 **경주할 자동차 이름**을 입력받는다.(이름은 쉼표(,) 기준으로 구분)
    - **입력 형식**:
  ```
  이름1,이름2,이름3
  ```
- **기능**: 사용자로부터 **시도할 횟수**을 입력받는다.
    - **입력 형식**:
  ```
  5
  ```  

### 2. 주요 로직 구현

- **기능**: 자동차 경주를 진행한다.
    - **알고리즘**:
        1. `시도할 횟수` 마다 아래를 반복
        2. 각 자동차에 대해 해당 로직을 적용한다
        3. `pickNumberInRange()`값이 4이상 인지 판단
            - 4이상이라면 1회 전진

### 3. 출력 처리

- **기능**: 차수별 실행 결과 출력
    - **조건**:차수마다 출력
    - **형식**:
      ```
      //이동 횟수는 '-'의 개수로 표현
      입력한이름1 : --
      입력한이름2 : --
      //마지막 한 줄 공백
      ```
- **기능**: 최종 우승자 출력
    - **조건**:마지막 차수 출력을 마친 후 출력
    - **형식**:
      ```
      최종 우승자 : 입력한이름1
      ```

### 4. 예외 처리

- **기능**: 잘못된 입력 처리
    - **처리방식**: `IllegalArgumentException`발생 후 프로그램 종료

### 5. 테스트

- **기능**: 테스트 케이스 작성
    - **정상 케이스**: ("pobi,woni", "1") => "최종 우승자 : pobi"
    - 예외
        - 플레이어 이름 입력시:
            - **케이스 1**: ("pobi,javaji", "1") => `IllegalArgumentException`, 5자 이하 만 가능
            - **케이스 2**: (",") => `IllegalArgumentException`, 이름 없이 쉼표만 입력
            - **케이스 3**: ("") => `IllegalArgumentException`, 입력값 없음
            - **케이스 4**: ("") => `IllegalArgumentException`, 입력값 없는 공백
            - **케이스 5**: ("pobi,","1") => `IllegalArgumentException`, 입력값 없는 공백
        - 플레이어 이름 입력시:
            - **케이스 1**: ("pobi,migi"," ") => `IllegalArgumentException`, 5자 이하 만 가능
            - **케이스 2**: ("pobi,migi","") => `IllegalArgumentException`, 이름 없이 쉼표만 입력
            - **케이스 3**: ("pobi,migi","fds") => `IllegalArgumentException`, 입력값 없음
            - **케이스 4**: ("pobi,migi","-1") => `IllegalArgumentException`, 입력값 없는 공백