package racingcar.config;

import racingcar.filter.FilterChain;
import racingcar.filter.impl.filter.CarNameCharacterFilter;
import racingcar.filter.impl.filter.CarNameLengthFilter;
import racingcar.filter.impl.filter.RoundInputPositiveIntegerFilter;
import racingcar.filter.impl.filter.RoundInputTypeFilter;
import racingcar.filter.impl.filterchain.CarNameFilterChain;
import racingcar.filter.impl.filterchain.RoundFilterChain;

public class FilterConfig {
    private static final FilterConfig INSTANCE = new FilterConfig();

    private final FilterChain carNameFilterChain = new CarNameFilterChain();
    private final FilterChain roundFilterChain = new RoundFilterChain();

    private FilterConfig() {
        carNameFilterChain.addFilter(new CarNameCharacterFilter());
        carNameFilterChain.addFilter(new CarNameLengthFilter());
        roundFilterChain.addFilter(new RoundInputTypeFilter());
        roundFilterChain.addFilter(new RoundInputPositiveIntegerFilter());
    }

    public static FilterConfig getInstance() {
        return INSTANCE;
    }

    public FilterChain getCarNameFilterChain() {
        return carNameFilterChain;
    }

    public FilterChain getRoundFilterChain() {
        return roundFilterChain;
    }
}
