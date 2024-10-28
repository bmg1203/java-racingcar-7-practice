# java-racingcar-precourse

# 자동차 경주

## 과제 진행 요구 사항

1. 자동차 경주 저장소를 포크하고 클론합니다.
2. 기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리해 추가합니다.
3. Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가합니다.
4. AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성합니다.
5. 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고합니다.

## 기능 요구 사항

- 초간단 자동차 경주 게임을 구현합니다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있습니다.
- 각 자동차에 이름을 부여할 수 있으며, 자동차 이름은 쉼표(,)로 구분하며 5자 이하만 가능합니다.
- 사용자는 몇 번의 이동을 할 것인지 입력할 수 있어야 합니다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후, 무작위 값이 4 이상일 경우입니다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려줍니다.
    - 우승자는 한 명 이상일 수 있습니다.
    - 우승자가 여러 명일 경우 쉼표(,)로 구분합니다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 합니다.

## 입출력 요구 사항

### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```
  pobi,woni,jun
```
- 시도할 횟수
```
  5
```

### 출력

- 차수별 실행 결과
```
pobi : --
woni : ----
jun : ---
```
- 단독 우승자 안내 문구
```
  최종 우승자 : pobi
```
- 공동 우승자 안내 문구
```
  최종 우승자 : pobi, jun
```
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

## 기능
1. **횟수 입력 받기**
    - 플레이할 횟수를 입력합니다.

2. **자동차 이름 입력 받기**
    - 자동차 이름을 쉼표로 구분하여 입력합니다.
    - 이름은 5자 이하만 가능하며, 여러 대의 자동차를 만들 수 있습니다.

3. **자동차 전진**
    - 각 자동차는 0부터 9 사이의 랜덤 숫자를 생성하여, 4 이상의 숫자가 나올 경우 전진합니다.
    - 전진할 때 자동차 이름도 함께 출력됩니다.

4. **랜덤 숫자 생성**
    - 0~9의 랜덤 숫자를 생성합니다.

5. **우승자 선별**
    - 게임 종료 후 가장 많이 전진한 자동차를 우승자로 선별합니다.
    - 여러 명의 우승자가 나올 수 있습니다.