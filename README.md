# 자동차 경주

## :computer: 프로그램 소개

자동차의 이름과 실행 횟수를 입력받아 실행 횟수만큼 무작위로 전진시켜 가장 많이 전진한 자동차 이름을 출력하는 프로그램

## :pushpin: 기능 목록

:star: 핵심 기능 : 무작위 값을 생성하여 4 이상이면 자동차 전진시키기

* 자동차 이름 입력받기 - `InputView#readCarName`
    * 쉼표가 없는 경우(이름을 한 명만 입력한 경우) 예외 발생 후 종료 - `Applicaiton#isSeperatorPresent`
    * 입력 마지막에 쉼표가 있는 경우 예외 발생 후 종료 - `Application#isLastCharacterComma`
* 입력받은 이름을 쉼표(,)를 기준으로 분리하기 - `Application#seperateCarNames`
    * 이름이 5자 이하가 아닌 경우 예외 발생 후 종료 - `Application#isCarNameFiveCharsOrLess`
    * 중복된 이름이 있는 경우 예외 발생 후 종료 - `Application#isCarNameDuplicate`
* 실행 횟수 입력받기 - `InputView#readGameCount`
    * 실행 횟수가 숫자가 아닌 경우 예외 발생 후 종료 - `Application#isGameCountNumber`
    * 실행 횟수가 0보다 작거나 같은 경우 예외 발생 후 종료 - `Application#isGameCountOneOrMore`
* 0부터 9 사이의 무작위 값 구하기 - `Application#makeRandomNumber`
* 무작위 값이 4 이상이면 전진하기 - `Application#moveOrStop`
* 입력받은 횟수만큼 실행 결과 출력하기 - `OutputView#printExecutionResult`
* 우승자 출력하기 - `OutputView#printWinner`
    * 우승자가 2명 이상인 경우 쉼표로 구분하여 출력하기