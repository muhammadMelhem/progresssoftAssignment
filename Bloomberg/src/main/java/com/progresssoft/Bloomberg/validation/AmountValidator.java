package com.progresssoft.Bloomberg.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class AmountValidator implements ConstraintValidator<CheckAmount, Double> {

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {

		try {
			double myDouble = value;
			myDouble -= (int) myDouble;

			return myDouble != (double) 0.00;

		} catch (NumberFormatException e) {
			return false;
		}
	}
}
