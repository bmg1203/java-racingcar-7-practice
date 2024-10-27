package racingcar.initialTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TryNumberTest {

    @Test
    void TryNumber는_숫자만_입력가능합니다() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TryNumber("a"));

        System.out.println(exception.getMessage());
    }

    @Test
    void TryNumber는_Integer범위만_입력가능합니다() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TryNumber("214736484611"));

        System.out.println(exception.getMessage());
    }


}

class TryNumber {

    private int tryNumber;

    public TryNumber(String tryNumber) {
        int convertedToInteger = convertToInteger(tryNumber);
        this.tryNumber = convertedToInteger;
    }


    private static int convertToInteger(String tryNumber) {
        try {
            return Integer.parseInt(tryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    public int getTryNumber() {
        return tryNumber;
    }


}
