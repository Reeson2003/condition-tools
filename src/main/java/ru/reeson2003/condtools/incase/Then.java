package ru.reeson2003.condtools.incase;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Then<T, S>
        implements Supplier<Optional<S>> {

    private final T check;

    private final List<Map.Entry<Predicate<T>, Function<T, S>>> conditions;

    public Then(T check, List<Map.Entry<Predicate<T>, Function<T, S>>> conditions) {
        this.check = check;
        this.conditions = conditions;
    }

    public When<T, S> when(Predicate<T> predicate) {
        return new When<>(check, predicate, conditions);
    }

    public Otherwise<T, S> otherwise(Function<T, S> ifDefault) {
        return new Otherwise<>(ifDefault, check, conditions);
    }

    @Override
    public Optional<S> get() {
        for (Map.Entry<Predicate<T>, Function<T, S>> condition : conditions) {
            if (condition.getKey().test(check)) {
                return Optional.ofNullable(condition.getValue().apply(check));
            }
        }
        return Optional.empty();
    }

}
