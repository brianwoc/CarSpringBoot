package pl.altkom.car.model.Validation;

import pl.altkom.car.model.Route;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class DataConstrainValidator implements ConstraintValidator<DataValidation, Route > {


    @Override
    public void initialize(DataValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(Route route, ConstraintValidatorContext constraintValidatorContext) {
return route.getEndTime().isAfter(route.getStartTime());
    }
}
