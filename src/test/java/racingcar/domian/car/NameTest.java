package racingcar.domian.car;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {


    @ParameterizedTest
    @CsvSource({"12345,12345", "asd,asd", "a,a", "가나다,가나다", "ㄱㄴㄷ,ㄱㄴㄷ"})
    void 이름_만들기_정상작동_테스트(String name, String expectedName) {
        Name name1 = Name.createName(name);
        Assertions.assertEquals(expectedName, name1.getName());

    }


    @ParameterizedTest
    @ValueSource(strings = {"  ", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "{", "}", "[", "]", "|"})
    void 이름_만들기_오류_테스트(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Name.createName(name));

    }


    @ParameterizedTest
    @ValueSource(strings = {"  ", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "{", "}", "[", "]", "|"})
    void 이름_만들기_중복_테스트(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Name.createName(name));


    }


}