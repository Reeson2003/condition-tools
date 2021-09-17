package ru.reeson2003.condtools.incase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public final class When<T, S> {

    private final T check;

    private final Predicate<T> predicate;

    private final List<Map.Entry<Predicate<T>, Function<T, S>>> conditions;

    public When(T check, Predicate<T> predicate, List<Map.Entry<Predicate<T>, Function<T, S>>> conditions) {
        this.check = check;
        this.predicate = predicate;
        this.conditions = conditions;
    }

    public Then<T, S> then(Function<T, S> function) {
        var entries = new ArrayList<>(conditions);
        entries.add(Map.entry(predicate, function));
        return new Then<>(check, entries);
    }

}
