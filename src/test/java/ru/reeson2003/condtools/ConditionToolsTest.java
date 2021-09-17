package ru.reeson2003.condtools;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConditionToolsTest {

    public static Stream<Arguments> when() {
        return Stream.of(Arguments.of(true, "A"), Arguments.of(false, "B"));
    }

    public static Stream<Arguments> inCase() {
        return Stream.of(Arguments.of("012345", "Long"),
                         Arguments.of("0", "Short"),
                         Arguments.of("", "Empty"));
    }

    @MethodSource
    @ParameterizedTest
    void when(boolean condition, String expect) {
        var result = ConditionTools.when(condition)
                                   .then(() -> "A")
                                   .otherwise(() -> "B")
                                   .get();
        assertThat(result).isEqualTo(expect);
    }

    @MethodSource
    @ParameterizedTest
    void inCase(String check, String expect) {
        var result = ConditionTools.inCase(check)
                                   .when(s -> s.length() > 5).then(s -> "Long")
                                   .when(s -> s.length() > 0).then(s -> "Short")
                                   .otherwise(s -> "Empty")
                                   .get();
        assertThat(result).isEqualTo(expect);
    }

}