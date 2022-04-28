package pro.sky.homeworkcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {
    CalculateService out = new CalculateServiceImpl();

    @Test
    public void isRightWelcome(){
        assertEquals(out.answerWelcome(), "Добро пожаловать в калькулятор!");
    }
    @Test
    public void isRightResultFromSum() {
        String result = "3" + "+" + "2" + " = " + Integer.toString(Integer.parseInt("3".trim()) + Integer.parseInt("2".trim()));
        String result1 = "0" + "+" + "5" + " = " + Integer.toString(Integer.parseInt("0".trim()) + Integer.parseInt("5".trim()));
        assertEquals(out.sum("3","2"), result);
        assertEquals(out.sum("0","5"), result1);
    }

    @Test
    public void isRightResultFromDif() {
        String result = "3" + "-" + "2" + " = " + Integer.toString(Integer.parseInt("3".trim()) - Integer.parseInt("2".trim()));
        String result1 = "1" + "-" + "3" + " = " + Integer.toString(Integer.parseInt("1".trim()) - Integer.parseInt("3".trim()));
        assertEquals(out.dif("3","2"), result);
        assertEquals(out.dif("1","3"), result1);
    }

    @Test
    public void isRightResultFromMulty() {
        String result = "3" + "*" + "2" + " = " + Integer.toString(Integer.parseInt("3".trim()) * Integer.parseInt("2".trim()));
        String result1 = "4" + "*" + "3" + " = " + Integer.toString(Integer.parseInt("4".trim()) * Integer.parseInt("3".trim()));
        assertEquals(out.multy("3","2"), result);
        assertEquals(out.multy("4","3"), result1);
    }

    @Test
    public void isRightResultFromDiv() {
        String result = "3" + "/" + "2" + " = " + Double.toString(Double.parseDouble("3".trim()) / Integer.parseInt("2".trim()));
        String result1 = "-4" + "/" + "2" + " = " + Double.toString(Double.parseDouble("-4".trim()) / Integer.parseInt("2".trim()));
        assertEquals(out.div("3","2"), result);
        assertEquals(out.div("-4","2"), result1);

    }
    @Test
    public void shouldThrowDivToZeroExeption(){
        Assertions.assertThrows(DivToZeroExeption.class,()->out.div("3","0"));
    }
}
