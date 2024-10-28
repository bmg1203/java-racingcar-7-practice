package splitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNameSplitterImpl implements CarNameSplitter {
    @Override
    public List<String> splitCarNames(String input) {
        return new ArrayList<String>(Arrays.asList(input.split(",")));
    }
}