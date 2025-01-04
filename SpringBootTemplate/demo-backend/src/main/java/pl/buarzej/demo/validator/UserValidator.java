package pl.buarzej.demo.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.buarzej.demo.model.domain.User;
import pl.buarzej.demo.service.UserService;

@Component
public class UserValidator implements Validator {

    EmailValidator emailValidator = EmailValidator.getInstance();
    private UserService userService;

    @Autowired
    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        ValidationUtils.rejectIfEmpty(errors, "email", "NotEmpty");

        //TODO this one should work properly but it looks bad, think about diffrent method in userService
        User userInDatabase = null;
        try {
            userInDatabase = userService.findByLogin(user.getLogin());
        } catch (Exception ignored) {

        }
        if (userInDatabase != null) {
            errors.rejectValue("login", "User with such login already exists");
        }

        if (errors.getErrorCount() == 0) {
            if (StringUtils.hasText(user.getEmail()) && !emailValidator.isValid(user.getEmail())) {
                errors.rejectValue("email", "Invalid email!");
            }
        }
    }
}
