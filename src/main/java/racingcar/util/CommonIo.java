package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class CommonIo {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public String receiveInput() {
        return Console.readLine();
    }

    public int convertStringToInt(String message) {
        return Integer.parseInt(message);
    }
}
