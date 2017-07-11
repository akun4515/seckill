package cn.dface;

import jdk.jfr.events.ThrowablesEvent;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by akun on 2017/7/11.
 */
public class CsvBeanValidator<T> implements Validator<T>,InitializingBean {

    private javax.validation.Validator validator;
    @Override
    public void afterPropertiesSet() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }

    @Override
    public void validate(T value) throws ValidationException {
        Set<ConstraintViolation<T>> constraintViolationSet = validator.validate(value);
        if(constraintViolationSet.size() > 0){
            StringBuilder message = new StringBuilder();
            for (ConstraintViolation<T> tConstraintViolation : constraintViolationSet) {
                message.append(tConstraintViolation.getMessage()+"\n");
            }
            throw new ValidationException(message.toString());
        }
    }
}
