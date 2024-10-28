# 자동차 경주 🏎️

## 구현할 기능 목록 📋

- 입력 클래스
    - 사용자 입력 메서드
    - 입력 처리 메서드
- 자동차클래스
    - 이름, 이동거리
- 출력 클래스
    - 이동거리 출력 메서드
    - 우승자 출력 메서드
- 우승자 클래스
    - 우승자 확인 메서드
    - 우승자 리스트 생성 메서드
    - 우승자 문자열 생성 메서드
- 예외 처리 메서드

## 예외 처리 목록 ✅

- 자동차 이름
    - 5글자 이상
    - 공백
    - 숫자
    - 특수문자
    - 이스케이프 시퀀스
    - 중복
    - 싱글플레이

- 이동 횟수(n > 0 && n < 2147483648)
    - INT를 초과하는 값
    - 수식
    - 음수
    - 0
    - 문자

### 라이브러리 🦾

- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
- Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
- 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
  사용 예시

```angular2html
0에서 9까지의 정수 중 한 개의 정수 반환
Randoms.pickNumberInRange(0, 9);
```
