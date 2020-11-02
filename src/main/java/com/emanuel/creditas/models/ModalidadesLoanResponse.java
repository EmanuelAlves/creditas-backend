package com.emanuel.creditas.models;

import java.util.Set;

public class ModalidadesLoanResponse {

	private Set<TaxResponse> list;
	private Object name;

	public ModalidadesLoanResponse(NewCustomer newCustomer, Set<TaxResponse> list) {
		this.setList(list);
		
		this.setName(newCustomer.getName());
	}

	public Set<TaxResponse> getList() {
		return list;
	}

	public void setList(Set<TaxResponse> list) {
		this.list = list;
	}

	public Object getName() {
		return name;
	}

	public void setName(Object name) {
		this.name = name;
	}

}
