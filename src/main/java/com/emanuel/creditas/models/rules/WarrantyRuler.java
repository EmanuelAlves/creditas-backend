package com.emanuel.creditas.models.rules;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emanuel.creditas.models.LoanType;
import com.emanuel.creditas.models.NewCustomer;
import com.emanuel.creditas.models.TaxResponse;

@Service
public class WarrantyRuler implements Ruler {

	@Override
	public Optional<TaxResponse> isPass(NewCustomer newCustomer) {
				
		if(newCustomer.getIncome().compareTo(new BigDecimal("3000")) <= 0 
				&& newCustomer.getLocation().toLowerCase().equals("sp")
				&& newCustomer.getAge() < 30) {
			return Optional.of(new TaxResponse(LoanType.WARRANTY, 3));
		}
		
		if(newCustomer.getIncome().compareTo(new BigDecimal("3000")) > 0 
				&& newCustomer.getIncome().compareTo(new BigDecimal("5000")) < 0
				&& newCustomer.getLocation().toLowerCase().equals("sp")) {
			return Optional.of(new TaxResponse(LoanType.WARRANTY, 3));
		}
		
		if(newCustomer.getIncome().compareTo(new BigDecimal("5000")) >= 0 ) {
			return Optional.of(new TaxResponse(LoanType.WARRANTY, 3));
		}
		
		
		return Optional.ofNullable(null);
	}

}
