package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.util.ValidUtil.*;

class ValidUtilTest {
    @Test
    public void 이동_횟수는_정수여야_한다_정수가_아닌_경우(){
        String moveCount = "hi";
        assertThat(isNumeric(moveCount)).isEqualTo(false);
    }

    @Test
    public void 이동_횟수는_빈_값이_아니여야한다_빈_값인_경우(){
        String moveCount = "";
        assertThat(isEmpty(moveCount)).isEqualTo(true);
    }

    @Test
    public void 이동_횟수는_1_이상이어야_한다_음수인_경우(){
        String moveCount = "-1";
        assertThat(isPositive(moveCount)).isEqualTo(false);
    }
}