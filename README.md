# java-racingcar-precourse
<기능 구현 목록>

1. 입력처리
    - 자동차 이름 입력받기 : 콤마(,)로 구분, 5자 이하
    - 시도 횟수 입력받기 : 1이상의 정수
   
2. 각 시도 횟수마다 모든 자동차들에 대해 랜덤값 출력
    - 랜덤값 0~9 사이 
   
3. 랜덤값이 4이상인 경우 해당 자동차 전진
    - 전진한 경우 하이픈(-) 추가
   
4. 우승자 결정
    - 자동차의 위치 비교하여 우승자 결정
    - 우승자가 2명 이상일 수 있음
   
5. 출력처리
    - 차수별 실행 결과 출력
    - 최종 우승자 출력 : 공동 우승자는 쉼표(,)로 구분
   
6. 예외처리 : 다음의 경우 IllegalArgumentException을 발생시킴
   1) 자동차 이름 5자 초과 입력시
      오류 메시지 : "이름은 5자를 초과할 수 없습니다."
   2) 자동차 이름을 영어와 숫자 외에 쓴 경우 
      오류 메시지 : "이름은 영어와 숫자만 입력 가능합니다." 
   3) 자동차 이름 구분자로 쉼표(,)가 아닌 잘못된 구분자 사용한 경우
      오류 메시지 : "구분자로 쉼표(,)를 입력해주세요"
   4) 자동차 이름이나 시도 횟수를 입력하지 않은 경우
      오류 메시지 : "입력값이 존재하지 않습니다."
   5) 자동차를 10대 초과하여 입력한 경우 
      오류 메시지 : "자동차는 10대를 초과할 수 없습니다."
   6) 시도 횟수를 0이나 음수로 입력한 경우 
      오류 메시지 : "시도 횟수는 1회 이상으로 입력해야 합니다."
   
7. 테스트 케이스 작성
   1) 자동차 이름 길이 테스트 : 5자 초과할 경우 IllegalArgumentException 발생하는지 확인
   2) 자동차 이름 구분자 테스트 : 이름이 없거나 쉼표(,)가 아닌 구분자 사용시 예외 발생하는지 확인
   3) 시도 횟수 입력 테스트 : 0이나 음수 입력시 IllegalArgumentException 발생하는지 확인
   4) 자동차 이동 조건 테스트 : 랜덤값이 4미만인 경우 이동하지 않는지 확인
   5) 우승자 출력 테스트 : 두 대 이상 같은 위치일 때 공동 우승자로 나오는지 확인 