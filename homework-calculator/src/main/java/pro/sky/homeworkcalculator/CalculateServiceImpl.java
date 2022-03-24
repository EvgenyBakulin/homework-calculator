package pro.sky.homeworkcalculator;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class CalculateServiceImpl implements CalculateService {
    public String answerWelcome(){
        return "Добро пожаловать в калькулятор!";
    }
    public String sum (String param1, String param2) {
            if (param1==null||param2==null) {
                return "Ошибка!";
            }
            else {
                int sum = Integer.parseInt(param1.trim()) + Integer.parseInt(param2.trim());
                return param1 + "+" + param2 + " = " + Integer.toString(sum);
            }
    }

    public String dif (String param1, String param2) {
            int dif = Integer.parseInt(param1.trim()) - Integer.parseInt(param2.trim());
            return param1 + "-" + param2 + " = " + Integer.toString(dif);
    }
    public String multy (String param1, String param2) {
        int mul = Integer.parseInt(param1.trim())*Integer.parseInt(param2.trim());
        return param1 + "*" + param2 + " = " + Integer.toString(mul);
    }
    public String div (String param1, String param2) {
        if (param2.equals("0")) {
            throw new RuntimeException("Деление на ноль");
        }
        double div = Double.parseDouble(param1.trim())/Integer.parseInt(param2.trim());
        return param1 + "/" + param2 + " = " + Double.toString(div);
    }
}
