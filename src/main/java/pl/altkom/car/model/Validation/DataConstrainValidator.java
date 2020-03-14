package pl.altkom.car.model.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class DataConstrainValidator implements ConstraintValidator<DataValidation, LocalDateTime> {

//    private Route route;
//
//    public DataConstrainValidator(Route route) {
//        this.route = route;
//    }

    @Override
    public void initialize(DataValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDateTime date, ConstraintValidatorContext constraintValidatorContext) {

        boolean result;
        if (date != null) {
            result = date.isBefore(LocalDateTime.of(2020,02,29,12,12));
        } else {
            return true;
        }

        return result;
    }
}
