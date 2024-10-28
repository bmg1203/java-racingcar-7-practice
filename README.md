## **초간단 자동차 경주 게임을 구현한다.**

## *문제 분석*
1. 경주할 자동차 이름 (입력)
- 쉼표를 이용하여 구분 (n대 = 쉼표를 이용해 구분된 자동차 수) [ok]
- 이름은 5자 이하만 가능 (잘못된 이름일 경우, "잘못된 이름입니다" 오류 출력)

2. 시도할 횟수 (입력)
- 몇 번 이동할 것인지에 대한 입력. [ok]

3. 이동
- 시도 횟수 동안 반복 (차량 수만큼 반복)
  - 0~9 사이 무작위 값 구하기 [ok]
  - 해당 값이 4이상일 경우 전진 / 아닐 경우 제자리 [ok]
- 이때, 출력은 각 차량 입력 순서대로 [ok]
  - 전진할 경우, -추가, 멈춰있을경우 아무것도 X (이후 해당 과정이 이루어질 때는 쌓아서 만들기) [ok]

4. 우승자 구하기 [ok]
- 각자 이름에 쌓인 - 개수 구하기 [ok]
- 각자 이름별로 - 개수 비교 [ok]
- 경주 게임이 끝난 후, 누가 우승했는지 출력 (print) [ok]
- 우승자는 한 명 이상이 가능. (전진 횟수 같은 경우 여러명 가능) [ok]
- 우승자가 여러명일 경우 "쉼표 이용한 구분" [ok]


## *입출력 요구 사항*
- *입력*
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
- 시도할 횟수
5

- *출력*
- 차수별 실행 결과
pobi : --
woni : ----
jun : ---
- 단독 우승자 안내 문구
최종 우승자 : pobi

- 공동 우승자 안내 문구
최종 우승자 : pobi, jun

``` 실행 결과 예시
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

최종 우승자 : pobi, jun" ```
