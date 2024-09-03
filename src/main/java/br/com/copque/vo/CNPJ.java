package br.com.copque.vo;

import java.util.regex.Pattern;

public class CNPJ extends Document {

    public CNPJ(String value) {
        super(value, Pattern.compile("\\d{14}"));
    }

    @Override
    protected String format(String cnpj) {
        return cnpj.substring(0, 2) + "." +
                cnpj.substring(2, 5) + "." +
                cnpj.substring(5, 8) + "/" +
                cnpj.substring(8, 12) + "-" +
                cnpj.substring(12, 14);
    }
}
