package racingcar.app.front.preprocessor.lap;

public class LapCountPreprocessor {

    private LapCountPreprocessor() {
    }

    public static String replaceAllUnNecessaryChar(final String source) {
        String cleanedWhiteSpaceSource = source.replaceAll("\\s", "");
        return cleanedWhiteSpaceSource.replaceAll("(^0+)", "");
    }
}
