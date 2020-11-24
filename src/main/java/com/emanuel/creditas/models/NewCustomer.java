package com.emanuel.creditas.models;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Set;


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
        this.setAge(age);
        this.setLocation(location);
        this.setIncome(income);
    }


	public boolean onlyPersonalLoan() {		
		return this.getIncome().compareTo(new BigDecimal("3000")) <= 0 
				&& !this.getLocation().toLowerCase().equals("sp");
	}


	public ModalidadesLoanResponse toPersonalLoan() {
		return new ModalidadesLoanResponse(this, Set.of(new TaxResponse(LoanType.PERSONAL, 4)));
	}

	
	public String getName() {
		return this.name;
	}

	
	public BigDecimal getIncome() {
		return income;
	}


	public void setIncome(BigDecimal income) {
		this.income = income;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


}
