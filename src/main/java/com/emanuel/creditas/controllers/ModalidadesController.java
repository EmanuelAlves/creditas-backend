package com.emanuel.creditas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emanuel.creditas.models.LoanAnalyzer;
import com.emanuel.creditas.models.ModalidadesLoanResponse;
import com.emanuel.creditas.models.NewCustomer;
import com.emanuel.creditas.models.TaxResponse;

import java.util.Set;

import javax.validation.Valid;

@RestController
public class ModalidadesController {
	
	@Autowired
	private LoanAnalyzer loanAnalyzer;

    @PostMapping(value = "/api/modalidades")
    public ModalidadesLoanResponse search(@RequestBody @Valid NewCustomer request){

    	Set<TaxResponse> analyze = loanAnalyzer.analyze(request);
    	return new ModalidadesLoanResponse(request, analyze);
    }

}