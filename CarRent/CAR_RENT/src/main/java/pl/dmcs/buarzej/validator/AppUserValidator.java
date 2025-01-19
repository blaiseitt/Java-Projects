package pl.dmcs.buarzej.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.dmcs.buarzej.domain.AppUser;

public class AppUserValidator implements Validator {

    EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public boolean supports(Class clazz) {
        return AppUser.class.isAssignableFrom(clazz);
    }

    //przeciążenie metody validate
    @Override
    public void validate(Object arg0, Errors errors) {  //2 argumenty. 1 obiekt który ma zostać sprawdzony, 2 lista błędów jaka ma być wygenerowana
        //sprawdzenie czy pola nie są puste czy użytkownik nie wysłał pustych pól
        ValidationUtils.rejectIfEmpty(errors, "firstName", "error.field.required");
        //3 argumenty. 1 lista błędów do której dodajemy błąd, 2. nazwa pola do sprawdzenia. 3. kod błędu wysyłany do użytkownika
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "telephone", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.field.required");

        if (errors.getErrorCount() == 0) {//sprawdzanie poprawności emaila tylko i wyłącznie gdy żadne pole nie jest puste
            if (StringUtils.hasText(((AppUser) arg0).getEmail()) && emailValidator.isValid(((AppUser) arg0).getEmail()) == false) {
                errors.rejectValue("email", "error.email.invalid");
            }
        }
    }
}
