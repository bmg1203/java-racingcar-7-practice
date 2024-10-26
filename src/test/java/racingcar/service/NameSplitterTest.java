package racingcar.service;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameSplitterTest {

    private NameSplitter nameSplitter;

    @BeforeEach
    void setUp() {
        nameSplitter = new NameSplitter();
    }

    @Test
    void 쉼표로_구분된_이름을_리스트로_분리한다() {
        // given
        String input = "철수,영희,짱구";

        // when
        List<String> result = nameSplitter.splitNames(input);

        // then
        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly("철수", "영희", "짱구");
            softly.assertThat(result)
                    .hasSize(3);
        });
    }

    @Test
    void 이름_앞뒤의_공백을_제거하고_분리한다() {
        // given
        String input = "맹구 , 유리  ,  훈이";

        // when
        List<String> result = nameSplitter.splitNames(input);

        // then
        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly("맹구", "유리", "훈이");
            softly.assertThat(result)
                    .doesNotContain(" 맹구", "유리 ", " 훈이 ");
        });
    }

    @Test
    void 빈_문자열을_입력하면_빈_리스트를_반환한다() {
        // given
        String input = "";

        // when
        List<String> result = nameSplitter.splitNames(input);

        // then
        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEmpty();
            softly.assertThat(result)
                    .hasSize(0);
        });
    }

    @Test
    void 쉼표만_있는_경우_빈_문자열_항목을_제외한_리스트를_반환한다() {
        // given
        String input = ",,";

        // when
        List<String> result = nameSplitter.splitNames(input);

        // then
        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEmpty();
            softly.assertThat(result)
                    .hasSize(0);
            softly.assertThat(result)
                    .doesNotContain("");
        });
    }

    @Test
    void 단일_이름을_입력하면_하나의_요소를_가진_리스트를_반환한다() {
        // given
        String input = "둘리";

        // when
        List<String> result = nameSplitter.splitNames(input);

        // then
        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly("둘리");
            softly.assertThat(result)
                    .hasSize(1);
            softly.assertThat(result.getFirst())
                    .isEqualTo("둘리");
        });
    }
}