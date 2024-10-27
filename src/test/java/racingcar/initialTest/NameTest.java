package racingcar.initialTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"!", "@", "#", "$", "%", "^", "&", "*", "(", ")"})
    void 올바른_이름_형식아님_에러_테스트(String name) {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Name(name));
        System.out.println(exception.getMessage());
    }

    @Test
    void 이름이_5글자_넘으면_에러_테스트() {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Name("abcdef"));
        System.out.println(exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "    ", "           "})
    void 이름은_빈칸일수_없습니다_테스트(String name) {

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Name(name));
        System.out.println(exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"name1,name2,", "name1,,name2", ",name1,name2"})
    void 인풋_빈칸__테스트(String name) {

        String[] split = name.split(",", -1);
        int cnt = 0;
        for (String s : split) {

            if (s == null || s.isBlank()) {
                IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                        () -> new Name(s));
                System.out.println("cnt 일때= " + cnt);
                System.out.println("exception = " + exception.getMessage());
            } else {
                Name name1 = new Name(s);
            }
            cnt++;

        }


    }


}


class Name {

    private String name;

    public Name(String name) {
        this.name = name;
        validateName();
    }

    private void validateName() {
        validateNameIsEmpty();
        validateNameFormat();
        validateNameLength();
    }

    private void validateNameFormat() {
        if (!name.matches("^[a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException("올바른 이름 형식이 아닙니다.");
        }
    }

    private void validateNameIsEmpty() {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈칸 일 수 없습니다.");
        }
    }

    private void validateNameLength() {
        if (name.length() > 5) {
            throw new IllegalArgumentException("Error: 이름은 5글자 이하입니다");
        }


    }


}
