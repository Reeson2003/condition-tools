package ru.reeson2003.condtools.when;

import java.util.function.Supplier;

public final class Otherwise<T>
        implements Supplier<T> {

    private final Supplier<T> ifTrue;

    private final Supplier<T> ifFalse;

    private final boolean condition;

    public Otherwise(Supplier<T> ifTrue, Supplier<T> ifFalse, boolean condition) {
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
        this.condition = condition;
    }

    @Override
    public T get() {
        if (condition) {
            return ifTrue.get();
        } else {
            return ifFalse.get();
        }
    }

}
