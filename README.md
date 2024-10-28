# java-racingcar-precourse

## **[문제 내 입맛대로 내용 재구성]**
과제명 : 초간단 자동차 경주 게임 구현

- 주어진 횟수 동안 n대의 자동차는 전진 || 멈춤
- 자동차에 이름 부여 가능
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력
- 자동차 이름은

[사용자 입력값 for 게임 시작]
- 자동차 이름
  (쉼표 기준  /  이름은 5자이하!)
- 시도할 횟수
  (몇 번 이동할 것인지에 대한 횟수)

[전진 조건]
- if(0~9무작위값 >= 4) then 전진가능!

[우승자에 대하여 : 게임 완료시 우승자 알려줘야함.]
- 1명 이상
- 여려 명일 시, 쉼표(,)로 구분

[예외는?]
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException발생시킨뒤 애플리케이션 종료

## [구현 목록]
- [] : 사용자 입력을 위한 메시지 출력과 동시에 입력을 받기
- [] : 자동차 클래스 생성(name, 현재 위치)
    (랜덤 전진 기능 포함)
- [] : 자동차 수만큼 loop돌리며, 시행 횟수만큼 진행하는 서비스 로직
  (입력에 따라 자동차 생성해서 리스트에 넣고)
  (시행횟수만큼 loop돌리며 랜덤 전진시키기)
- [] : location을 기반으로 우승자 계산기
  (우승자 출력기 까지 포함)

※종료 조건  : 시행 횟수 끝
※우승자 조건: location값이 가장 큰 자동차