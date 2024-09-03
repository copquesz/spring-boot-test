package br.com.copque.vo;

import java.util.regex.Pattern;

public class CPF extends Document {

    public CPF(String value) {
        super(value, Pattern.compile("\\d{11}"));
    }

    @Override
    protected String format(String cpf) {
        return cpf.substring(0, 3) + "." +
                cpf.substring(3, 6) + "." +
                cpf.substring(6, 9) + "-" +
                cpf.substring(9, 11);
    }

}
