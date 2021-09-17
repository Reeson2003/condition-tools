package ru.reeson2003.condtools.incase;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Otherwise<T, S>
        implements Supplier<S> {

    private final T check;

    private final List<Map.Entry<Predicate<T>, Function<T, S>>> conditions;

    private final Function<T, S> ifDefault;

    public Otherwise(Function<T, S> ifDefault,
                     T check,
                     List<Map.Entry<Predicate<T>, Function<T, S>>> conditions) {
        this.ifDefault = ifDefault;
        this.check = check;
        this.conditions = conditions;
    }

    @Override
    public S get() {
        for (Map.Entry<Predicate<T>, Function<T, S>> condition : conditions) {
            if (condition.getKey().test(check)) {
                return condition.getValue().apply(check);
            }
        }
        return ifDefault.apply(check);
    }

}
