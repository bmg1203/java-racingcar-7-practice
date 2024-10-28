package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NAME_CONSTANT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_CONSTANT = "시도할 횟수는 몇 회인가요?";
    private static final String PROCESS_CONSTANT = "실행 결과";


    public String[] showCarListInput() {
        System.out.println(INPUT_NAME_CONSTANT);
        String inputCarNames = camp.nextstep.edu.missionutils.Console.readLine();

        String[] carNames = inputCarNames.split(",", -1);
        return deleteBlank(carNames);

    }

    private String[] deleteBlank(String[] carNames) {
        String[] deleteBlankCarNames = new String[carNames.length];
        for (int i = 0; i < deleteBlankCarNames.length; i++) {
            deleteBlankCarNames[i] = carNames[i].replace(" ", "");
        }
        return deleteBlankCarNames;

    }


    public String showTryNumberInput() {
        System.out.println(INPUT_NUMBER_CONSTANT);
        return Console.readLine();
    }

    public void startProcessView() {
        System.out.println();
        System.out.println(PROCESS_CONSTANT);
    }
}
