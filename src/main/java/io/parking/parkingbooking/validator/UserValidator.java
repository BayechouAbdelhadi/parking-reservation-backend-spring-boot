package io.parking.parkingbooking.validator;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import io.parking.parkingbooking.domain.User;
import io.parking.parkingbooking.dto.UserRegistrationDto;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

    	UserRegistrationDto user = (UserRegistrationDto) object;

        if(user.getPassword().length() <6){
            errors.rejectValue("password","Length", "يجب أن تتكون كلمة المرور من 6 أحرف على الأقل");
        }

        if(!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("confirmPassword","Match", "يجب ان تتطابق كلمات المرور");

        }

        //confirmPassword



    }
}
