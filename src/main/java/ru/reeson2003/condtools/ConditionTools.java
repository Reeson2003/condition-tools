package ru.reeson2003.condtools;

import ru.reeson2003.condtools.incase.Then;
import ru.reeson2003.condtools.when.When;

import java.util.List;

public final class ConditionTools {

    private ConditionTools() {}

    public static When when(boolean condition) {
        return new When(condition);
    }

    public static <T, S> Then<T, S> inCase(T check) {
        return new Then<>(check, List.of());
    }

}
