# java-racingcar-precourse

 프로세스
1. 입력 기능 
2. 입력 데이터 쉼표 기준으로 분리
3. 각 자동차 별 랜덤하게 나아간 거리 할당, 출력
4. 가장 멀리간 자동차와 각 시행마다 이동한 거리 출력

# 기능 요구사항
1. 입력기능
    1. 문자열 데이터 입력(경주할 자동차 이름)
    2. 시도할 횟수 입력
2. 사용자가 입력한 자동차 이름 분리
    1. 쉼표 기준 분리
    2. 잘못된 값 입력시 IllegalArgumentException 발생
        1. 데이터 입력이 없는 경우
        2. 6명 이상 참여자가 있는 경우
        3. 이름 길이가 5글자 이상인 경우
3. 자동차 별 랜덤하게 나아간 거리 할당
    1. Randoms 객체를 사용하여 한번 시도할때 마다  0~9값을 랜덤하게 구함
    2. 구한 값이 4 이상인 경우 한칸 이동후 이동한 거리 갱신
    3. 각 시행마다 이동한 총 거리 로그 기록
4. 결과 출력
    1. 한번 전진을 시도할때마다 자동차별 총 전진한 거리 출력
    2. 최종 우승자를 출력
    3. 최대 거리가 같은 자동차 모두 출력
    

# 기능 목록

1. Application.java
    1. void Input()
     - 출전하는 자동차 이름과 시행할 횟수 입력받음
    2. void Output()
     - 총 이동 거리와 최종 우승자 출력
    3. main() 
     - 프로그램 실행
2. ParseInput 클래스
    - 입력받은 자동차 출전 목록(문자열 데이터)를 분할 후 저장
3. IllegalArgumentException
    - 토큰 분리시 이용하는 예외 처리 클래스 
4. CompetitionProgress 클래스
    - 자동차 경기를 진행후 결과를 저장
5. Car 클래스
    - 자동차 경기 내용을 저장하는 자료 구조