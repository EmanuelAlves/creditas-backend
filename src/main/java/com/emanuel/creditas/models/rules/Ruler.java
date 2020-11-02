package com.emanuel.creditas.models.rules;

import java.util.Optional;

import com.emanuel.creditas.models.NewCustomer;
import com.emanuel.creditas.models.TaxResponse;

public interface Ruler {

	public Optional<TaxResponse> isPass(NewCustomer newCustomer);

}
