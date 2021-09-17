package ru.reeson2003.condtools.when;

import java.util.function.Supplier;

public final class When {

    private final boolean condition;

    public When(boolean condition) {this.condition = condition;}

    public <T> Then<T> then(Supplier<T> ifTrue) {
        return new Then<>(ifTrue, condition);
    }

}
