package racingcar.IO;
import camp.nextstep.edu.missionutils.Console;

public class CarNamesInput {
    public static String[] getCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }

            else if (carName.length() == 0){
                throw new IllegalArgumentException("이름은 한 글자 이상 작성해 주세요.");
            }
        }
        return carNames;
    }
}
