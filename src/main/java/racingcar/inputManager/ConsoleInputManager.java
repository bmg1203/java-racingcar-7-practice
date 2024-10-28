package racingcar.inputManager;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class ConsoleInputManager implements InputManager {
    @Override
    public void whatIsYourName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public String getName() {
        return Console.readLine();
    }

    @Override
    public List<String> splitName(String readName) {
        List<String> nameList = new ArrayList<>();
        String[] classifiedName = readName.split(",");

        for (String name : classifiedName) {
            validateName(name);
            nameList.add(name);
        }

        return nameList;
    }

    private void validateName(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException("입력 서식에 맞춰 주세요.");
        }
    }

    @Override
    public void HowManyAttempt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public int getNumberOfAttempt() {
        return Integer.parseInt(Console.readLine());
    }
}
