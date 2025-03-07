package com.mari.operations;

public class Validation {

    public Validation() {
    }

    public Double convertToDouble(String strNum) {
        if(strNum == null){
            return 0D;
        }
        String number = strNum.replaceAll(",", "."); // toda virgula que receber na string será trocada por ponto
        if(isNumeric(number))return Double.parseDouble(number);

        return 0D;


    }

    public boolean isNumeric(String strNum) {
        if(strNum == null) return false;
        String number = strNum.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+"); // verifica se é positivo ou negativo, de 0 a 9, com numeros fracinários

    }
}
