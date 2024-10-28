package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {
    /*
    * 자동차 이름 입력 기능(readLine()) - 0
    * - 자동차 이름은 쉼표(,)를 기준으로 구분 - 0
    * - 이름은 5자 이하만 가능
    * 게임 진행 회차수 입력 기능(readLine()) - 0
    * - String -> int로 변환 - 0
    * 무작위 0-9 사이 숫자 생성(pickNumberInRange()) - 0
    * 자동차 클래스 생성
    * - 자동차 전진 조건 추가(무작위 값이 4 이상일 경우 전진)
    *  - 게임 회차별 현재 자동차들 위치 출력 기능
    * 자동차 클래스 관리 클래스 생성
    * - 우승 자동차 결정 기능
    * - 우승 자동차 출력 기능
    * - 우승자가 여러 명일 경우, 쉼표(,)를 이용하여 구분한다.
    * 잘못된 값이 입력될 경우 IllegalArgumentException을 발생시키고 에플리케이션을 종료한다.
    */
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();

        List<String> carNames = splitCarNames(inputCarNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputGameCount = Console.readLine();
        int gameCount = convertStrToInt(inputGameCount);

        Cars cars = new Cars(carNames);

        Game game = new Game(cars, gameCount);
        game.playGame();
    }

    public static List<String> splitCarNames(String inputCarNames){
        return List.of(inputCarNames.split(","));
    }

    public static int convertStrToInt(String inputGameCount){
        return Integer.parseInt(inputGameCount);
    }

    public static int RandomIntCreate(){
        return Randoms.pickNumberInRange(0, 9);
    }
}
