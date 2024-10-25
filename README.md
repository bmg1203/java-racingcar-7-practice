# java-racingcar-precourse
    #기능 구현
    1. view: Application의 main()에서 상황마다 보여주는 출력 화면 모음
        (1) 처음 실행 시 화면에 "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 출력
        (2) 자동차의 횟수를 입력받는 "시도할 횟수는 몇 회인가요?" 출력
        (3) 실행 결과를 요구사항 형식에 맞게 출력
        (4) 우승자 안내문구 출력
        (5) 공동 우승자 안내 문구 출력
        (6) 사용자의 입력 오류시 보여주는 에러메세지 [IllegalArgumentException] 출력 후 종료
    2. controller: 사용자의 입력 타입에 따른 기능 수행
        (1) serivce(1)에서 유효성 판단
        (1-1) 입력이 옳음: controller(2) 실행
        (1-2) 입력이 옳지 않음: view(6) 실행
        (2) 각각 model(1)의 객체를 생성 후 호출
        (3) 각 객체들의 service(2)의 결과를 model(1)에 저장
        (4) view(3)을 출력
        (5) 반복횟수가 끝나면 service(3)에서 정보를 추출 
        (6) view(4)/view(5)를 통해 화면 출력
    3. model: 저장할 데이터들의 모음
        (1) 경주할 자동차 정보 모델
    4. service: 데이터를 요구사항에 맞게 처리하는 기능 모음
        (1) 사용자의 입력값이 유효한 값인지 판단하는 기능
        (2) 무작위 값 출력후 전진 여부 판단하는 기능
        (3) 우승자 추출
    5. Application: 사용자가 화면에 입력/출력을 담당하는 부분
       (1) view(1)을 호출
       (2) 사용자에게 자동차 목록 입력받아 저장
       (3) view(2)을 호출
       (4) 사용자에게 시도 횟수를 입력받아 저장
       (5) controller(1)에 Application(2), Applicaion(4) 전달
    
