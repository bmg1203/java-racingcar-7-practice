# java-racingcar-precourse

![Static Badge](https://img.shields.io/badge/precourse-week2-green)
![Static Badge](https://img.shields.io/badge/test_passed-12%2F12-blue)

---

### 미션 소개 및 다짐

우아한테크코스의 2주차 프리코스 미션으로 `자동차 경주`를 구현합니다.
2주차 프리코스의 학습목표인 Test와 메서드 분리에 초점을 맞추어 진행할 예정입니다.

이전 미션에서 아쉬웠던 예외 처리에 대해서도 신경써서 구현할 예정입니다. 예외 또한 객체가 가져야할 책임이기 때문에
적절한 위치에서 예외가 발생할 수 있도록 `입력에 대한 검증`과 `비즈니스 로직에 대한 검증`을 구분하여
코드를 작성할 예정입니다.

### 기능 요구 사항

- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [ ] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

# 기능 구현

## 자동차

- [x] 이름을 가진다.
    - [x] 이름은 5자 이하이다.
- [x] 위치 값을 가진다.
- [x] 4이상의 값이 주어지면 전진한다.

## 입력

- [x] 사용자로부터 몇 번 이동할 것인지 입력받는다.
- [x] 경주할 자동차의 이름을 입력받는다.

## 출력

- [ ] 우승자를 출력한다.
- [ ] 전진하는 모든 자동차를 이름과 위치를 함께 출력한다.
- [x] 경주할 자동차 이름 요청을 출력한다.
- [ ] 시도 횟수 입력 요청을 출력한다.

## 고려 사항

- 경주 라운드 수는 숫자만 입력해야한다.
- 경주에 참여할 자동차의 이름은 쉼표로 구분되어야한다.
- 자동차의 이름은 공백이나 구분자(,)로 시작할 수 없다.

# TDD

- 테스트의 메서드 이름은 [Unit Test Naming Conventions](https://dzone.com/articles/7-popular-unit-test-naming)
  를 참고하여 간단하게 기능을 명시하는 'Feature to be tested' 방법으로 한다.
- 이번 미션에서 TDD를 구현하는 방법은 다음과 같다.

```markdown
1. 구현하고자 하는 기능을 정한다.
2. 실패하는 테스트를 작성한다.
3. 객체의 메서드를 적절히 구현한다.
4. 테스트를 실행하여 결과를 확인한다.
5. 구현 도중 더욱 구체적인 요구사항이나 예외사항은 README에 적고 구현완료한 기능과 함께 커밋한다.
```