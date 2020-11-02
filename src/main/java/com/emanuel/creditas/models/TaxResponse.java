package com.emanuel.creditas.models;

public class TaxResponse {

	private LoanType personalType;
	private int tax;

	public TaxResponse(LoanType personalType, int tax) {
		this.setPersonalType(personalType);
		this.setTax(tax);
	}

	public LoanType getPersonalType() {
		return personalType;
	}

	public void setPersonalType(LoanType personalType) {
		this.personalType = personalType;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

}
