package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class View {
    private final GameController gameController;
    private Model model;

    public void input() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String line = Console.readLine();
        String[] carNames = line.split(",");

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());

        RequestDto requestDto = new RequestDto(carNames, tryCount);
    }

    public void output(){


    }

    public View(){
        this.gameController = DependencyInjectionConfig.gameController();
    }

}
