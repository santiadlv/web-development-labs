package mx.tec.web.lab.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Valid Size Constraint Interface
 * @author Santiago Alcerreca
 * @version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Constraint(validatedBy = SizeValidator.class)
public @interface ValidSize {
	/**
	 * Default ValidSize interface message
	 * @return default message
	 */
	String message() default "Invalid size";
	
	/**
	 * Default ValidSize interface groups
	 * @return default groups
	 */
	Class<?>[] groups() default {};

	/**
	 * Default ValidSize interface payload
	 * @return default payload
	 */
	Class<? extends Payload>[] payload() default {};
}
