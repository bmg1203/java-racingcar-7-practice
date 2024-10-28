# java-racingcar-precourse
## 자동차 경주
### 구현할 기능 목록
- [x]  지정된 입출력 형식에 맞게 입출력 구현
    - [x]  자동차 이름, 시도 횟수 입력받기
    - [x]  각 자동차마다 이름과 함께 실행 결과 출력
    - [x]  우승자 출력 후 프로그램 종료
- [x]  자동차 전진
    - [x]  각 자동차마다 Randoms API 사용해 전진 여부 판단 후 전진
    - [x]  이동 횟수만큼 경주 실행
    - [x]  전진 횟수로 우승자 판별
- [x]  예외 처리: 잘못된 값 입력 시 IllegalArgumentException
    - [x] , 이외의 구분자 입력
    - [x] 6자 이상의 이름 입력
    - [x] 이동 횟수에 음수 입력
    - [x]  이동 횟수에 문자 입력
- [ ]  기능 정상 작동 확인을 위한 테스트 코드 작성
   - [x]  정상적인 이동 횟수 입력
   - [x]  정상적인 이름 목록 입력
   - [ ]  우승자가 1명인 경우 출력
   - [ ]  우승자가 여러 명인 경우 출력
   - [ ]  모두가 우승자인 경우 출력
   - [ ]  예외 처리의 경우
      - [ ]  , 이외의 구분자 입력
      - [ ]  6자 이상의 이름 입력
      - [ ]  이동 횟수에 음수 입력
      - [ ]  이동 횟수에 문자 입력
- [ ]  리팩터링 → 표시해둔 함수 쪼갤 것들 쪼개기

### 체크할 것
- [ ]  indent 3 이내
- [ ]  코드 포매팅
- [ ]  내부 API 사용한 간단 구현