# 기능 구현

- [x] ReadMe 작성하기

- [ ] 기본 코드 구현
  - [ ] 코드 분리 이전 기본적으로 구현해보기
- [ ] 테스트 코드 구현
  - [ ] 예외 사항 코드 테스트 구현하기
- [ ] 코드 분리 하기
  - [ ] 코드 컨벤션 및 기능적으로 코드 분리하기
- [ ] 리팩토링

# 자동차 경주

## 과제 진행 요구 사항

- 미션은 [자동차 경주](https://github.com/woowacourse-precourse/java-racingcar-7) 저장소를 포크하고 클론하는 것으로 시작한다.

- **기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리**해 추가한다.

- Git의 커밋 단위는 앞 단계에서

   

  ```
  README.md
  ```

  에 정리한 기능 목록 단위로 추가한다.

  - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.

- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

#### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```autohotkey
pobi,woni,jun
```

- 시도할 횟수

```undefined
5
```

#### 출력

- 차수별 실행 결과

```ada
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```ada
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```ada
최종 우승자 : pobi, jun
```

#### 실행 결과 예시

```ada
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



# 중간 회고

- 지원서에 작성한 목표를 얼마나 달성하고 있다고 생각하나요? 그 이유는 무엇인가요?
  - 백엔드를 배우기 위한 자바 공부를 진행하면서 잊었던 부분을 미션을 통해 조금씩 복기하고 이를 활용하고 있으며, 특히 TDD를 해본적이 없는 제 기준에는 이번 미션을 통해 Junit에 대한 활용도를 많이 배우고 있다고 생각합니다.
  - 이 두 가지를 통해 한 30퍼 정도는 달성하고 있다고 생각합니다.
- 지원서에 작성한 목표를 변경해야 한다고 생각하시나요? 그렇다면 그 이유와 어떤 목표로 변경하고 싶으신가요?
  - 여전히 백엔드 공부를 목표로 생각하고 있기 때문에 변경하지 않는다고 생각합니다.
- 프리코스를 진행하면서 눈에 띄는 변화나 깨달은 점이 있나요?
  - 미션을 진행하면서 다른 사람의 코드를 보며 배울점이 많았습니다. 테스트를 짤 때 예외 사항들이나, 다른 조건들을 알게 되는 경우들입니다.
  - 특히 이번 프리코스를 진행하면서 테스트 코드에 대한 것들을 신경쓰게 되었으며, 같은 코드를 구현해도 얼마나 코드 분리와 책임감을 분리하면서 코드를 짜는 것들을 신경쓰게 되었습니다.
