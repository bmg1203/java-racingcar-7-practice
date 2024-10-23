# java-racingcar-precourse
> 자동차 경주 게임을 구현하는 프로젝트 

## 입력 요구 사항
- [ ] 경주할 자동차 이름을 입력합니다.
  - [x] 경주할 자동차 이름은 쉼표를 기준으로 구분합니다. 
  - [x] 쉼표가 두 개 이상 연속으로 입력됐다면 예외를 발생합니다. 
  - [x] 자동차 이름은 5자 이하만 가능합니다.
    - [x] 쉼표 이외의 다른 문자는 자동차의 이름으로 인식한다.
    - [x] 이름 길이의 기준점 5를 상수화 합니다.
- [ ] 경주할 횟수를 입력합니다.
  - [x] 경주할 횟수는 1이상의 숫자만 입력 가능합니다.
  - [x] 경주할 횟수의 최소 조건과 최대 조건을 상수화 합니다.
- [ ] 입력 주위의 공백을 제거 합니다. 
- [ ] 입력의 끝에 쉼표가 들어올 경우 예외를 발생합니다.
- [x] 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킵니다.

## 출력 요구 사항
- [ ] 실행 결과를 출력합니다. 
  - [ ] 매 턴마다 실행 결과를 출력합니다.
  - [ ] 형식은 "[자동차 이름] : [전진한 거리]"
  - [ ] 이름이 입력된 순서대로 출력합니다.
- [ ] 최종 우승자를 출력합니다.
  - [ ] 우승자는 한 명 이상일 수 있습니다.
  - [ ] 우승자가 여러 명일 경우 쉼표(,)로 구분하여 출력합니다.
  - [ ] 이름이 입력된 순서대로 우승자를 출력합니다.
- [ ] 전진한 자동차는 -를 이용하여 표시합니다.

## 기능 요구 사항
- [x] 0에서 9사이의 무작위 값을 구한 후 값이 4 이상이면 전진합니다.
  - [x] 기준점 0, 9, 4를 상수화 합니다.
- [ ] 무작위 값은 의존성 역전을 이용해 구현합니다. 
- [x] 검증된 입력 값을 파싱하여 자동차 객체를 생성합니다.
  - [x] 자동차 객체는 이름과 위치를 가지고 있습니다. 
  - [x] 자동차 객체의 이름은 식별자 역할을 합니다.
- [x] 경기에 참여하는 자동차를 관리합니다.
  - [x] 자동차는 순서를 보장하기 위해 List로 관리합니다. 
- [ ] 매 실행 마다, 경기에 참여하는 자동차들에 랜덤 값을 부여합니다.

## 피드백 반영 사항 
- [ ] 도메인 계층에 DTO를 사용하지 않습니다.
- [ ] String 라이브러리 (String.join) 등을 이용합니다.
- [ ] Scope를 포함하여 커밋 메시지를 작성합니다.

## 목표
- [ ] TDD로 구현하기 
- [ ] 동작하는 코드를 작성한 뒤 리팩토링을 진행하기
