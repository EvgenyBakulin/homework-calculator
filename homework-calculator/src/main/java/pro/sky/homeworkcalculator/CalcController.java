package pro.sky.homeworkcalculator;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalcController {
    public final CalculateService calculateService;

    public CalcController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping
    public String answerWelcome() {
        return calculateService.answerWelcome();
    }

    @GetMapping("/plus")
        public String answerSum (@RequestParam(value = "num1",required = false) String param1, @RequestParam(value = "num2",required = false) String param2) {
         return calculateService.sum(param1, param2);
    }


    @GetMapping("/minus")
    public String answerDif(@RequestParam(name = "num1",required = false) String param1, @RequestParam(name = "num2",required = false) String param2) {
        if (null==param1 || null==param2) {
            return "Ошибка!";
        } else {
            return calculateService.dif(param1, param2);
        }
    }

    @GetMapping("/multiply")
    public String answerMult(@RequestParam(name = "num1",required = false) String param1, @RequestParam(name = "num2",required = false) String param2) {
        if (null==param1 || null==param2) {
            return "Ошибка!";
        } else {
            return calculateService.multy(param1, param2);
        }
    }

    @GetMapping("/divide")
    public String answerDiv(@RequestParam(value = "num1",required = false) String param1, @RequestParam(value = "num2",required = false) String param2) {
        if (param1 == null || param2 == null) {
            return "Ошибка!";
        } else {
            return calculateService.div(param1, param2);
        }
    }
}

