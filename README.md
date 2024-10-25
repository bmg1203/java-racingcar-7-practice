###  최종 목표: 다른 사람들에게 코드 의사 전달이 '잘' 되게 과제 만들기

---

# 1. 의미 전달이 되는 단일 책임 함수 작성하기
## 행동 강령
### 1. 메서드 길이 제한 
- 한 메서드 최대 30줄
- 길어지면 작은 메서드로 분리
### 2. 메서드 인자 제한
- 매개변수 3개 이하로 제한
- 더 필요하다면 DTO나 객체로 묶기
### 3. 명확한 메서드 네이밍
- 형식: 동사 + 형용사 + 명사 , 동사 + 명사
- 예시:
  - calculateTotalPrice()정
  - validateUserInput()
  - provideCarName()
### 4. 깊은 중첩 피하기
- indent depth 2까지만 허용
- Early Return 패턴 사용
```java
// Early Return 예시
public void processUser(User user) {
    if (!user.isValid()) {
        return;
    }
    // 메인 로직
}
```
### 5. 조건문 단순화
```java
// 3항 연산자 대신
public String getXxx(boolean isValid) {
    if (isValid) {
        return "Valid";
    }
    return "Invalid";
}
```


---

# 2. 의미 전달 되는 테스트 코드 작성
- 하나의 테스트는 하나의 시나리오만 검증
- 모든 테스트는 독립적으로 실행 가능해야 함(다른 테스트에 영향X)

## 행동 강령
- 테스트 메서드당 assert는 하나만 사용
- 연관된 여러 검증이 필요하면 별도 검증 메서드로 분리

## 테스트 네이밍 규칙
- 형식: [테스트대상_시나리오_결과]
- 예시:
  - 주문생성_재고없음_예외발생()
  - 결제처리_잔액부족_결제실패()


# 3. 의미 전달 되는 커밋 메세지 작성
```
- 타입 규칙 - 
feat: 새로운 기능 추가 밍
fix: 버그 수정
refactor: 코드 리팩토링 (기능변경 없음)
style: 코드 포맷팅, 세미콜론 누락 등 스타일 변경
test: 테스트 코드 추가/수정
docs: 문서 수정
chore: 빌드 관련 파일 수정
```
## 행동 강령

### 제목 작성 규칙

### 1. 기능 추가시
```java
// 패턴: feat: [기능명] [동작] 기능 추가
feat: 포인트 적립 계산 기능 추가
feat: 회원 등급 자동 승급 기능 추가
feat: 이메일 인증 발송 기능 추가
```
### 2. 버그 수정시
```java
// 패턴: fix: [문제상황] [해결방안] 수정
fix: 장바구니 상품 중복 추가 방지 로직 수정
fix: 주문 취소시 재고 미반영 문제 수정
fix: 회원 포인트 소수점 절사 오류 수정
```
### 3. 리팩토링시
```
// 패턴: refactor: [대상] [개선사항] 분리/개선
refactor: 주문 처리 로직 단일 책임 원칙에 따라 분리
refactor: 상품 조회 메서드 성능 개선
refactor: 결제 처리 중복 코드 제거
```
### 본문 작성 규칙
```java
feat: 회원 등급별 할인율 계산 기능 추가

- BRONZE: 5% 할인
- SILVER: 10% 할인
- GOLD: 15% 할인
- VIP: 20% 할인

할인율은 주문금액에 따라 추가 조정될 수 있음
```
- 제목과 본문 사이 한 줄 비움
- 어떻게 보다는 무엇과 왜를 설명

---

# 4. 의미 전달이 잘 되게  객체타입으로 의미 표현하기
- 도메인의 속성들의 타입을 명확하게 객체 타입으로 표현하기
- 예외 메세지를 객체 타입으로 표현하기

---


# 프리코스 2주차 도입하기 
초간단 자동차 경주 게임을 구현한다.


# 입출력 요구사항
## 입력 
경주할 자동차 이름을 쉼표(,)로 구분하여 여러개 받는다.
게임 시도할 횟수를 정수 1~20까지만 입력 받을 수 있다.
 - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

## 출력 
- 차수별로 실행 결과를 "{이름} : {이동횟수}" 형식으로 사용자 수 만큼 출력한다.  
  - 이동횟수는 "-" 갯수이고, 문자를 붙여서 출력해야한다.
  - 이동횟수가 없을 경우 ""으로 처리한다.
```java
// 차수별 실행 결과
pobi : --
woni : ----
jun : 
```
 - 최종 우승자를 마지막에 출력하고, 게임을 종료한다.
```java
최종 우승자 : pobi, jun
```
# 기능 요구사항
##  자동차 경주 애플리케이션
- 게임 횟수가 주어지고 이 횟수만큼 자동차가 행동을 한다.
- 자동차는 n대 존재한다.
  - (0 < n <6)
- 자동차가 전진한다.
- 자동차가 멈춘다.
- 자동차는 이름이 있다.
- 전진한 자동차 이름, 전진한 횟수를 함께 출력한다.  
- 사용자는 총 이동 횟수를 입력한다.
- 자동차 전진 조건은 도출된 무작위 값이 4 이상인 경우다
  - (0~9 사이로 무작위 값을 구한다.)
- 자동차 경주 게임을 완료된 후, 우승자를 출력한다.성
  - (우승자는 한 명 이상일 수 있다.)
  - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

---
## 관심사별로 기능 묶기

---
### 자동차

- [x] 이동할 횟수를 받아 앞으로 전진한다.
  - 이동횟수1미만_예외발생
  - 이동횟수100초과_예외발생
  - 이동횟수1포함100포함사이_예외발생안함
  - 이동횟수1포함100포함사이_위치증가
  
- [x] 현재 위치를 제공한다.
  - 이동한후_현위치반환함
  - 초기생성_움직인거리0반환
  
- [x] 현재 위치에 머무른다.
  - 움직이고나서_호출시_이전위치유지
  - 생성되고_호출시_이전위치유지
---

### (개발중) 플레이어
- [x] 스스로를 생성한다.
  - [x] 이름을 받아 자신을 생성한다.
  - [x] 1부터10자사이_생성성공
  - [x] 이름이10자초과_예외발생
  - [x] 이름이1자미만_예외발생

- [x] 본인 이름을 제공한다.
  - [x] 본인이름요청시_이름반환

- [x] 플레이어가 자동차를 생성한다.

- [x] 게임넘버제너레이터로부터 숫자를 뽑는다.
  - [x] 메서드요청시_정상작동
  - [x] 메서드요청시_이동가능숫뽑을수있음
  - [x] 메서드요청시_이동불가숫자뽑을수있음
  
- 자동차를 움직인다.
  - 게임에서 정해준 이동거리만큼 이동한다.
- 자동차의 움직인 거리를 제공한다.

---
### (수정중)자동차 경주 게임 
-  [x] 게임 횟수, 자동차들을 받아 자신을 생성한다.
  - 게임횟수그리고자동차들입력받으면_생성한다
  - 자동차최대5대초과시_예외처리
  - 자동차최소2대미만시_예외처리
  - 게임횟수100번초과시_예외처리
  - 게임횟수1번미만시_예외처리
-  게임을 시작한다.
-  자동차 마다 무작위 값을 뽑아 행동을 결정한다.
-  게임 횟수만큼 반복한다.
-  중복 허용한 우승 자동차를 선정한다. 
   - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.


### (수정중)입력자
- 입력자는 총 이동 횟수를 입력한다
- 입력자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.




---

## 실행 결과 예시
```java
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