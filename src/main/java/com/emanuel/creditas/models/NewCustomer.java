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
        this.age = age;
        this.location = location;
        this.income = income;
    }


	public boolean onlyPersonalLoan() {		
		return this.income.compareTo(new BigDecimal("3000")) <= 0 
				&& !this.location.toLowerCase().equals("sp");
	}


	public ModalidadesLoanResponse toPersonalLoan() {
		return new ModalidadesLoanResponse(this, Set.of(new TaxResponse(LoanType.PERSONAL, 4)));
	}


	public String getName() {
		return this.name;
	}


	public boolean garantiaLoan() {
		return this.income.compareTo(new BigDecimal("3000")) <= 0 
				&& this.location.toLowerCase().equals("sp")
				&& this.age < 30;
	}
	
	
	public boolean garantia2Loan() {
		return this.income.compareTo(new BigDecimal("3000")) > 0 
				&& this.income.compareTo(new BigDecimal("5000")) <= 0
				&& this.location.toLowerCase().equals("sp");
	}
	

	public ModalidadesLoanResponse toPersonalLoanAndGarantia() {
		return new ModalidadesLoanResponse(this, Set.of(new TaxResponse(LoanType.PERSONAL, 4), 
				new TaxResponse(LoanType.GARANTIA, 3)));
	}


	public boolean consignadoLoan() {
		return this.income.compareTo(new BigDecimal("5000")) >= 0
				&& this.location.toLowerCase().equals("sp")
				&& this.age < 30;
	}

	
	public ModalidadesLoanResponse toPersonalAndConsignado() {
		return new ModalidadesLoanResponse(this, Set.of(new TaxResponse(LoanType.PERSONAL, 4), 
				new TaxResponse(LoanType.GARANTIA, 3), new TaxResponse(LoanType.CONSIGNADO, 2)));
	}


}
