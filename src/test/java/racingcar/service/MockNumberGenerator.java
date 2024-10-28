package racingcar.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MockNumberGenerator implements NumberGenerator {
    private final Queue<Integer> numbers = new LinkedList<>();

    public MockNumberGenerator(Integer ... numbers) {
        this.numbers.addAll(Arrays.asList(numbers));
    }

    public static NumberGenerator createMockNumberGenerator(Integer ... numbers) {
        return new MockNumberGenerator(numbers);
    }

    @Override
    public int generate() {
        validateEmpty();
        return numbers.poll();
    }

    private void validateEmpty(){
        if(numbers.isEmpty()){
            throw new IllegalArgumentException();
        }
    }
}
