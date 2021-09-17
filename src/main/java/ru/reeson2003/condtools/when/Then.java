package ru.reeson2003.condtools.when;

import java.util.Optional;
import java.util.function.Supplier;

public final class Then<T>
        implements Supplier<Optional<T>> {

    private final Supplier<T> ifTrue;

    private final boolean condition;

    public Then(Supplier<T> ifTrue, boolean condition) {
        this.ifTrue = ifTrue;
        this.condition = condition;
    }

    public Otherwise<T> otherwise(Supplier<T> ifFalse) {
        return new Otherwise<>(ifTrue, ifFalse, condition);
    }

    @Override
    public Optional<T> get() {
        if (condition) {
            return Optional.ofNullable(ifTrue.get());
        } else {
            return Optional.empty();
        }
    }

}
