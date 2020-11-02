package com.emanuel.creditas.models;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuel.creditas.models.rules.Ruler;

@Service
public class LoanAnalyzer {
	
	@Autowired
	private Set<Ruler> rulers;
	
	public Set<TaxResponse> analyze(final NewCustomer newCustomer) {
		return rulers
			.stream()
			.map(rule -> rule.isPass(newCustomer))
			.filter(Optional:: isPresent)
			.map(Optional :: get)
			.collect(Collectors.toSet());
	}

}
