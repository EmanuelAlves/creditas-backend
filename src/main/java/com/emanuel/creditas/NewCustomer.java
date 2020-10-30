package com.emanuel.creditas;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;


public class NewCustomer {

    @NotBlank
    private String name;
    @NotBlank
    @CPF
    private String cpf;
    @Positive
    private int age;
    @NotBlank
    private String location;
    @Positive
    @NotNull
    private BigDecimal income;


    public NewCustomer(@NotBlank String name, @NotBlank @CPF String cpf, @Positive int age, @NotBlank String location, @Positive @NotNull BigDecimal income) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
        this.location = location;
        this.income = income;
    }
}
