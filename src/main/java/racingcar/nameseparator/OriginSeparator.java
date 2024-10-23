package racingcar.nameseparator;

import java.util.Arrays;
import java.util.List;
import racingcar.NameSeparator;

public class OriginSeparator implements NameSeparator {

    @Override
    public List<String> separatingNames(String origin) {
        if (origin.isEmpty()) {
            throw new IllegalArgumentException("입력이 필요합니다.");
        }
        return Arrays.stream(origin.split(",")).toList();
    }
}
