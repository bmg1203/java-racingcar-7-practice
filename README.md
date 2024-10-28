# java-racingcar-precourse

# README.md

# 프로그램 이름

---

- 자동차 경주 게임
   


# 프로그램 설명

---

- 입력된 횟수동안 n대의 자동차가 경주 하는 게임이다.
   

# 프로그램 필수 기능

---

1. n개의 자동차들의 이름을 분리하는 기능
2. 입력받은 시도 횟수 만큼 전진 또는 멈출 수 있는 기능
    - **전진 조건** :  0 ~  9 사이의 무작위 값을 구한 후 무작위 값이 4 이상일 경우
3. 전진 조건에 따라 자동차들이 경주하는 기능
4. 차수 별 경주 결과 출력 기능
5. 자동차 경주 게임 완료 후 우승자를 출력하는 기능
    - **출력 조건** : 우승자가 여러명일 경우 “,”를 통해 구분

   

# 기능 목록

---

- **CarNameDelimiter**
    - 입력받은 자동차 이름들을 “,” 기준으로 분리
    - 분리 된 자동차 이름 검증
- **RaceCars**
    - 경주 진행 담당
    - 입력받은 시도 횟수만큼 경주를 진행
    - 전진 조건에 따라 자동차가 전진
- **Random**
    - 랜덤 숫자를 생성
    - 전진조건과 랜덤 숫자를 비교
   
# 입력 예시

---

- 첫 번째 입력 예시
    1. one, two, three
    2. 5
- 두 번째 입력 예시
    1. 하나, 둘, 셋
    2. 5
   
# 출력 예시

---

>경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)

입력

>시도할 회수는 몇회인가요?"

입력

one :
two : -
three : -

. . .

one : ----
two : ---
three : ----

> 최종 우승자 : one, three
   
# 예외 목록

---

- [ ]  자동차 이름 입력이 공백인 경우
- [ ]  시도 횟수 입력이 공배인 경우
- [ ]  자동차 이름 입력에 “ , , pobi” 와 같이 구분자 사이에 빈 문자열이 존재하는 경우
- [ ]  자동차 이름 입력에 “, , , “ 와 같이 구분자만 존재하는 경우
- [ ]  자동차 이름 입력에 “ , ” 이외의 다른 문자가 존재하는 경우