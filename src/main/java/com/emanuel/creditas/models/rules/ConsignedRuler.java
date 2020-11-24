package com.emanuel.creditas.models.rules;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emanuel.creditas.models.LoanType;
import com.emanuel.creditas.models.NewCustomer;
import com.emanuel.creditas.models.TaxResponse;

@Service
public class ConsignedRuler implements Ruler {

	@Override
	public Optional<TaxResponse> isPass(NewCustomer newCustomer) {
		System.out.println("Aqui" + newCustomer.getIncome());
		if(newCustomer.getIncome().compareTo(new BigDecimal("5000")) >= 0 ) {
			System.out.println("Aqui" + newCustomer.getIncome());
			return Optional.of(new TaxResponse(LoanType.CONSIGNADO, 2));
		}
				
		return  Optional.ofNullable(null);
	}

}
