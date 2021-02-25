package pl.dmcs.buarzej.service;

import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.dmcs.buarzej.domain.AppUser;

import java.util.List;

public interface AppUserService {

    //@Secured({"ROLE_ADMIN", "ROLE_MANAGER", "isAnonymous()"})
    void addAppUser(AppUser user); //zabezpieczone dla administratora

    /*@PreAuthorize("hasRole('ROLE_ADMIN') OR (#appUser.login == principal.username)")*/
    //sprawdzamy login obecnie zalogowanego użytkownika i sprawdzamy jakie ma on uprawnienia
    void editAppUser(AppUser user);                         //do prepostauthorized można zaprzegnąć spring expression language
    //pre authorized wykonywana przed
    //post praktycznie nie wykorzystywana, dopiero po wykonaniu metody sprawdzane jest czy użytkownik miał prawo do tego

    List<AppUser> listAppUser();

    @Secured({"ROLE_ADMIN", "ROLE_MANAGER"})
        //sprawdzanie pojedyńczej roli
    void removeAppUser(long id);

    AppUser getAppUser(long id);

    AppUser findByLogin(String login);

    AppUser findByEmail(String email);

    void addWithFixedRole(AppUser user);

    void confirmUser(AppUser appUser);

    Page getSpecificPage(Integer pageNumber);
}
