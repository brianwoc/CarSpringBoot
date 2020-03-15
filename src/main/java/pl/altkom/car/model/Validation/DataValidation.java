package pl.altkom.car.model.Validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DataConstrainValidator.class)
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataValidation {

    public String message() default  "Data końcowa musi być pożniejsza niż początkowa";

    // define default groups
    public Class<?>[] groups() default {};

    // define default payloads
    public Class<? extends Payload>[] payload() default {};
}
