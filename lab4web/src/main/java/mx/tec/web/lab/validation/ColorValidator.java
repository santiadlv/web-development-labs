package mx.tec.web.lab.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Color Constraint Validator Class
 * @author Santiago Alcerreca
 * @version 1.0
 */
public class ColorValidator implements ConstraintValidator<ValidColor, String> {
	private final List<String> validColors = Arrays.asList("Black", "Dark Stonewash", "Light Blue", "Dark Blue", "Gray");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return validColors.contains(value);
	}
}
