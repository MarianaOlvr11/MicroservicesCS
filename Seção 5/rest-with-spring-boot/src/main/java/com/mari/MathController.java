package com.mari;


import com.mari.exceptions.UnsuportedMathOperationException;
import com.mari.operations.Basics;
import com.mari.operations.Validation;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController // retorna um objeto com resposta http
public class MathController {

    Basics math = new Basics();
    Validation val = new Validation();

    @RequestMapping(value = "/sum/{number1}/{number2}", method = RequestMethod.GET)
    public Double sum(@PathVariable (value = "number1") String number1, @PathVariable (value = "number2") String number2) throws Exception {

        if(!val.isNumeric(number1) || !val.isNumeric(number2)){
            throw new UnsuportedMathOperationException("Please set a numerical value");
        }
        return math.sum(val.convertToDouble(number1), val.convertToDouble(number2));
    }

    @RequestMapping(value = "/sub/{number1}/{number2}", method = RequestMethod.GET)
    public Double sub(@PathVariable (value = "number1") String number1, @PathVariable (value = "number2") String number2) throws Exception {

        if(!val.isNumeric(number1) || !val.isNumeric(number2)){
            throw new UnsuportedMathOperationException("Please set a numerical value");
        }

        return math.sub(val.convertToDouble(number1), val.convertToDouble(number2));
    }

    @RequestMapping(value="/mult/{number1}/{number2}", method = RequestMethod.GET)
    public Double mult(@PathVariable(value = "number1") String number1,  @PathVariable(value = "number2") String number2) throws Exception{

        if(!val.isNumeric(number1) || !val.isNumeric(number2)){
            throw new UnsuportedMathOperationException("Please set a numerical value");
        }

        return math.mult(val.convertToDouble(number1), val.convertToDouble(number2) );

    }

    @RequestMapping(value="/div/{number1}/{number2}", method = RequestMethod.GET)
    public Double div(@PathVariable(value="number1") String number1, @PathVariable(value="number2") String number2) throws Exception{


        if(!val.isNumeric(number1) || !val.isNumeric(number2)){
            throw new UnsuportedMathOperationException("Please set a numerical value");
        }


        return math.div(val.convertToDouble(number1),val.convertToDouble(number2));
    }

    @RequestMapping(value="/med/{number1}/{number2}", method = RequestMethod.GET)
    public Double media(@PathVariable(value="number1") String number1, @PathVariable(value="number2") String number2) throws Exception{

        if(!val.isNumeric(number1) || !val.isNumeric(number2)){
            throw new UnsuportedMathOperationException("Please set a numerical value");
        }

        return math.med(val.convertToDouble(number1), val.convertToDouble(number2));
    }

    @RequestMapping(value="/sqrt/{number}", method = RequestMethod.GET)
    public Double sqrt(@PathVariable(value="number") String number) throws Exception{

        if(!val.isNumeric(number)){
            throw new UnsuportedMathOperationException("Please set a numerical value");
        }

        return math.sqrt(val.convertToDouble(number));
    }

    




}
