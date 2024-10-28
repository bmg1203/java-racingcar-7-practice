# java-racingcar-precourse

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

주어진 횟수 동안 `n`대의 자동차는 전진 또는 멈출 수 있다.

각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.

자동차 이름은 쉼표(`,`)를 기준으로 구분하며 이름은 5자 이하만 가능하다.

사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.

전진하는 조건은 `0`에서 `9` 사이에서 무작위 값을 구한 후 무작위 값이 `4` 이상일 경우이다.

자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

우승자가 여러 명일 경우 쉼표(`,`)를 이용하여 구분한다.

사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 실행 결과 예시

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

---
### 프로그래밍 요구 사항

indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.

예를 들어 `while`문 안에 `if`문이 있으면 들여쓰기는 2이다.

힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.

3항 연산자를 쓰지 않는다.

함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.

`JUnit 5`와 `AssertJ`를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.

---

### 라이브러리

`camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.

`Random` 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.

사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

---
### 커밋 메시지 규칙

`<type>(<scope>): <subject>`

`<type>`: 커밋의 종류

```
    - feat: 새로운 기능
    - fix: 버그 수정
    - docs: 문서 변경
    - style: 코드 형식 수정 (공백, 세미콜론 등)
    - refactor: 리팩토링 (기능 변경 없음)
    - test: 테스트 추가 또는 수정
    - chore: 기타 작업 (빌드, 도구 설정 등)
```

`<scope>`: 변경이 발생한 파일이나 기능의 범위

`<subject>`: 간결한 설명을 현재 시제로 작성, 첫 글자는 소문자로 시작하고, 끝에 점을 찍지 않는다.

---

## 기능 구현 목록

_Bottom-up implementation_

0. [x] I/O 테스트 및 라이브러리 메소드 체크
1. [x] n회, 수행 레이싱 참가 차량 1개에 대해서 구현 
2. [x] 1회, 수행 레이싱 참가 차량 k개에 대해서 구현
3. [ ] 관심사 분리
4. [ ] n회, 수행 레이싱 참가 차량 k개에 대해서 구현
5. [ ] 테스트 코드 작성 
6. [ ] 유지 보수 및 최적화 
