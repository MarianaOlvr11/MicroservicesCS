package com.mari.operations;


import com.mari.exceptions.UnsuportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class Basics {

    private Validation val = new Validation();


    public Double sum(Double n1, Double n2)  {
        return n1 + n2;
    }

    public Double sub(Double n1, Double n2)  {
        return n1 - n2;
    }

    public Double mult(Double n1, Double n2)  {
        return n1 * n2;
    }

    public Double div(Double n1, Double n2)  {
        return n1/n2;
    }

    public Double med(Double n1, Double n2)  {
        return (n1 + n2)/2;
    }

    public Double sqrt(Double n1)  {
        return Math.sqrt(n1);
    }



}
