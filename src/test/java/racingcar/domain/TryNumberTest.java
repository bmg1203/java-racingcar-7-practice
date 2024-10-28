package racingcar.domian;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TryNumberTest {

    @Test
    void createTryNumber_정상_테스트() {
        TryNumber tryNumber = TryNumber.createTryNumber("2147483647");
        Assertions.assertEquals(2147483647, tryNumber.getTryNumber());
    }

    @Test
    void createTryNumber_에러_범위_테스트_0_부터_2147483647_까지만_가능() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TryNumber.createTryNumber("2147483648"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> TryNumber.createTryNumber("0"));
    }


    @Test
    void createTryNumber_에러_파싱_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> TryNumber.createTryNumber("가나다"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> TryNumber.createTryNumber("ㄱㄴㄷ"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> TryNumber.createTryNumber("asd"));
    }


}