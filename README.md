# java-racingcar-precourse

## 기능 목록
- 입력값 받기
  - 자동차 이름
  - 시도할 횟수
- 자동차 객체 생성을 위한 Car 클래스 생성
  - 이름과 이동횟수 포함
- 생성된 자동차 객체를 List에 담기
- 전진 및 멈춤 기능
  - 시도 횟수 만큼 반복하는 반복문 포함
- 차수별 실행 결과 출력
- 최종 우승자 출력

## 예외 처리해야할 경우 목록
- 자동차의 이름이 5글자 초과일 경우
- 경주할 자동차의 이름을 입력할 때 null 또는 공백을 입력할경우
- 시도 횟수가 양의 정수가 아닐 경우
- 자동차의 이름이 중복될 경우

## 필수 기능 요구 사항 외 고려해 본 점
- 자동차의 이름에 공백이 있을 경우 없애기
    - 예시  
  공백 포함 입력
    ```java
        pobi,   woni,   jun
    ```
  공백 없애기
    ```java
        pobi,woni,jun
    ```

- 시도 횟수인 n은 1 이상이어야 함
- 우승자가 여러명일 경우 출력 순서
  - 입력순과 이름순 중 입력순으로 함
- 자동차의 이름은 중복이 불가함