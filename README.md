# java-racingcar-precourse

## 구현할 기능 목록

### 1. 입력
####    -> 경주할 자동차 이름 (쉼표 기준 구분) 
###### ------------- 입력값이 6자 이상 일 경우, illegalArgumentException 발생 시키고 종료
###### ------------- 입력값이 없을 경우, illegalArgumentException 발생 시키고 종료
####    -> 경주를 진행할 횟수 
###### ------------- 입력값이 0 이하일 경우, illegalArgumentException 발생 시키고 종료
###### ------------- 입력값이 문자열일 경우, illegalArgumentException 발생 시키고 종료


### 2. 출력
#### -> 매 차수 마다 현재 자동차의 위치를 " - " 으로 출력
###### ------------- map을 활용하여 key값 (자동차 명), value 값 (전진횟수) 를 함께 관리

#### -> 진행할 횟수 종료 후 우승자 안내 문구 출력 "최종 우승자 : xxx"
###### ------------- 만약 우승자가 단독 한명일 경우 "최종 우승자 : xxx"
###### ------------- 만약 우승자가 두명 이상일 경우 "최종 우승자: xxx , yyy" -> 쉼표로 구분


### 3. 중간과정
#### -> 주어진 횟수 동안 n대의 자동차는 전진 또는 멈춤을 반복
#### -> 전진은 4이상 9이하 무작위 값중 하나
##### ------------- 무작위 값이 0이상 3이하라면 전진하지 않음