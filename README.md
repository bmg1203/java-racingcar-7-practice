# 🚗 자동차 경주

## 📝 개요
초간단 자동차 경주 게임을 구현합니다.  
주어진 횟수 동안 자동차들이 무작위로 전진하여, 최종 우승자를 결정합니다.

## 🎯 기능 요구 사항
1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
7. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
8. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 📋 기능 목록
1. [ ] **자동차 이름 입력**: 입력 받은 자동차들의 이름을 쉼표로 구분한다. 또한, 이름은 5자 이하만 가능하도록 제한한다.
2. [ ] **이동 횟수 입력**: 사용자가 몇 번의 이동을 할 것인지를 입력받는다.
3. [ ] **자동차 이동 로직**: 무작위 값을 구한 후 값이 4 이상일 경우 자동차가 전진한다.
4. [ ] **경주 결과 출력**: 각 시도마다의 자동차 전진 결과를 출력한다.
5. [ ] **우승자 결정**: 최종 우승자를 결정하고 출력한다. 우승자가 여러 명일 경우 쉼표로 구분하여 출력한다.
6. [ ] **예외 처리**: 잘못된 입력이 있을 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.

## 🛠️ 프로그램 설계
1. 메인 파일에서 경주 프로그램을 실시한다.
2. 입력 메소드를 통해 사용자 입력을 처리한다.
   1. 5자 이상일 경우 `IllegalArgumentException` 발생 후 종료
3. 자동차 별 객체를 하나씩 생성한다.
   1. 랜덤 로직과 이동 거리 누적 기능이 내장되어 있다.
4. 경주를 할 수 있는 경기장을 생성한다.
   1. 자동차 객체를 생성하여 시도 횟수만큼 경주 시킨다.
   2. 한 번의 시도가 끝날 때마다 결과를 출력한다.
5. 이동 거리를 비교하는 메소드를 생성한다.
6. 출력 메소드를 통해 최종 우승자를 출력한다.

## ✅ 테스트 목록
- [ ] 자동차 이름 입력 받은 후, 쉼표로 구분하기
  - [ ] 이름이 5자 이상일 경우
- [ ] 자동차 객체 전진시키기
    - [ ] 시행 횟수만큼 전진시키기
- [ ] 이동 거리 출력하기
- [ ] 이동 거리 비교해서 우승자 출력하기
- [ ] 잘못된 입력일 경우 `IllegalArgumentException` 발생시키기 

## 🚀 프로그램 실행 방법
- `Application` 클래스의 `main()` 메소드를 실행하여 프로그램을 시작한다.

## ⏫ 2주차 개선 사항
- 리팩토링 이후 작성 예정