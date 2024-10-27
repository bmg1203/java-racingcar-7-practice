package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] showCarListInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
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

    private void validateLastComma(String[] inputCarNames) {

    }

    public String showTryNumberInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public void startProcessView() {
        System.out.println();
        System.out.println("실행결과");
    }
}
