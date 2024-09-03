package br.com.copque.vo;

import lombok.Getter;

import java.util.regex.Pattern;

public abstract class Document {

    @Getter
    private String value;

    private final Pattern pattern;

    public Document(String value, Pattern pattern) {
        if (value == null || !isValid(value)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.value = format(value);
        this.pattern = pattern;
    }

    protected abstract String format(String cpf);

    private boolean isValid(String cpf) {
        assert pattern != null;
        return pattern.matcher(cpf).matches();
    }

    @Override
    public String toString() {
        return value;
    }

}
