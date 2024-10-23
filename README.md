# java-racingcar-precourse

1. 자동차 이름 입력받기 [ ]
   - 콘솔에 자동차 이름을 입력하라는 메세지를 출력한다. [ ]
     형식: "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
   - 자동차 이름을 입력받는다. 이때 복수의 자동차 이름은 쉼표로 구분된다. [ ]
   - 예외처리 [ ]
      1. 글자수 5자를 초과할 시 에러를 발생시킨다. [ ]
      2. 공백 입력 시 에러를 발생시킨다. [ ]
2. 경주 횟수 입력받기 [ ]
   - 콘솔에 경주 횟수를 입력하라는 메세지를 출력한다. [ ]  
     - "시도할 횟수는 몇 회인가요?"
   - 예외처리 [ ]
     1. 양수가 아닌 숫자/문자 입력 시 에러를 발생시킨다. [ ]
     2. 공백 입력 시 에러를 발생시킨다. [ ]
3. 경주하기 [ ]
   - 1회차 마다 자동차별로 0-9 의 무작위 값을 구하여 4이상이면 전진(멈춤)한다. [ ]
   - 각 회차에 대한 결과를 출력한다. [ ]
     형식:
       자동차1 : --
       자동차2 : -
4. 최종 우승자 출력하기 [ ]
   - 자동차 중 가장 먼거리를 이동한 자동차를 구한다.
   - 자동차의 이름(들)을 출력한다.
     형식: 최종 우승자 : 자동차1, 자동차2