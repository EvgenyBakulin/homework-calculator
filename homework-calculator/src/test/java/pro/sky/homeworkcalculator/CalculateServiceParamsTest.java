package pro.sky.homeworkcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculateServiceParamsTest {
    CalculateService out = new CalculateServiceImpl();

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldCorrectWorkSum(String param1, String param2, String answer) {
        Assertions.assertEquals(out.sum(null, null), "Ошибка!");
        Assertions.assertEquals(out.sum("4", null), "Ошибка!");
        Assertions.assertEquals(out.sum(null, "3"), "Ошибка!");
        Assertions.assertEquals(out.sum("4", "3"), "4" + "+" + "3" + " = " + Integer.toString(Integer.parseInt("4".trim()) + Integer.parseInt("3".trim())));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldCorrectWorkDif(String param1, String param2, String answer) {
        Assertions.assertEquals(out.dif(null, null), "Ошибка!");
        Assertions.assertEquals(out.dif("4", null), "Ошибка!");
        Assertions.assertEquals(out.dif(null, "3"), "Ошибка!");
        Assertions.assertEquals(out.dif("4", "3"), "4" + "-" + "3" + " = " + Integer.toString(Integer.parseInt("4".trim()) - Integer.parseInt("3".trim())));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldCorrectWorkMulty(String param1, String param2, String answer) {
        Assertions.assertEquals(out.multy(null, null), "Ошибка!");
        Assertions.assertEquals(out.multy("4", null), "Ошибка!");
        Assertions.assertEquals(out.multy(null, "3"), "Ошибка!");
        Assertions.assertEquals(out.multy("4", "3"), "4" + "*" + "3" + " = " + Integer.toString(Integer.parseInt("4".trim()) * Integer.parseInt("3".trim())));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    public void shouldCorrectWorkDiv(String param1, String param2, String answer) {
        Assertions.assertEquals(out.div(null, null), "Ошибка!");
        Assertions.assertEquals(out.div("4", null), "Ошибка!");
        Assertions.assertEquals(out.div(null, "3"), "Ошибка!");
        Assertions.assertEquals(out.div("4", "3"), "4" + "/" + "3" + " = " + Double.toString(Double.parseDouble("4".trim()) / Integer.parseInt("3".trim())));
    }

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(Arguments.of(null, null, "Ошибка!"),
                Arguments.of("4", null, "Ошибка!"),
                Arguments.of(null, "3", "Ошибка!"),
                Arguments.of("4", "3", "4" + "+" + "3" + " = " + Integer.toString(Integer.parseInt("4".trim()) + Integer.parseInt("3".trim()))),
                Arguments.of("4", "3", "4" + "-" + "3" + " = " + Integer.toString(Integer.parseInt("4".trim()) - Integer.parseInt("3".trim()))),
                Arguments.of("4", "3", "4" + "*" + "3" + " = " + Integer.toString(Integer.parseInt("4".trim()) * Integer.parseInt("3".trim()))),
                Arguments.of("4", "3", "4" + "/" + "3" + " = " + Double.toString(Double.parseDouble("4".trim()) / Integer.parseInt("3".trim())))
        );
    }
}
