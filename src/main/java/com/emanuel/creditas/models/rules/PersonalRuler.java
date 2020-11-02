package com.emanuel.creditas.models.rules;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emanuel.creditas.models.LoanType;
import com.emanuel.creditas.models.NewCustomer;
import com.emanuel.creditas.models.TaxResponse;

@Service
public class PersonalRuler implements Ruler {

	@Override
	public Optional<TaxResponse> isPass(NewCustomer newCustomer) {
		return Optional.of(new TaxResponse(LoanType.PERSONAL, 4));
	}

}
