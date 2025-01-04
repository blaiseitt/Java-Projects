package pl.dmcs.buarzej.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.buarzej.domain.AppUser;
import pl.dmcs.buarzej.service.*;
import pl.dmcs.buarzej.validator.AppUserValidator;

import javax.validation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class AppUserController {

    private AppUserValidator appUserValidator = new AppUserValidator();

    private AppUserService appUserService;
    private AppUserRoleService appUserRoleService;
    private ReCaptchaService reCaptchaService;
    private EmailService emailService;

    @Autowired
    public AppUserController(AppUserService appUserService, AppUserRoleService appUserRoleService, ReCaptchaService reCaptchaService, EmailService emailService, TokenService tokenService) {
        this.appUserService = appUserService;
        this.appUserRoleService = appUserRoleService;
        this.reCaptchaService = reCaptchaService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "/appUsers")
    public String showAppUsers(Model model, HttpServletRequest request) {

        int appUserId = ServletRequestUtils.getIntParameter(request, "appUserId", -1);

        if (appUserId > 0) {
            AppUser appUser = appUserService.getAppUser(appUserId);
            appUser.setPassword("");
            model.addAttribute("appUser", appUser);
        } else
            model.addAttribute("appUser", new AppUser());

        model.addAttribute("appUserList", appUserService.listAppUser());
        model.addAttribute("appUserRoleList", appUserRoleService.listAppUserRole());

        return "appUser";
    }

    @RequestMapping(value = "/addAppUser", method = RequestMethod.POST)
    public String addAppUser(@Valid @ModelAttribute("appUser") AppUser appUser, BindingResult result, Model model, HttpServletRequest request, Principal principal) {
        //bindingresult obiekt służący do przekazywania informacji między kontrolerem a widokiem informacji dotyczących problemów z "bindowaniem"

        System.out.println("First Name: " + appUser.getFirstName() +
                " Last Name: " + appUser.getLastName() + " Tel.: " +
                appUser.getTelephone() + " Email: " + appUser.getEmail());

        appUserValidator.validate(appUser, result); //jako obiekt przekazujemy użytkownika(na podstawie tego co po stronie widoku
        //lista błędów przekazywana do obiektu result
        if (result.getErrorCount() == 0 && reCaptchaService.verify(request.getParameter("g-recaptcha-response"))) { //jeśli lista błędów pusta i captcha porobiona
            if (appUser.getId() == 0) {//nowy użytkownik ---> dodanie użytkownika
                if (principal == null)
                    appUserService.addWithFixedRole(appUser);
                else
                    appUserService.addAppUser(appUser);
            } else                            //nie nowy użytkownik ---> edycja użytkownika
                appUserService.editAppUser(appUser);

            return "redirect:/appUsers.html";    //przekierowanie do widoku głównego
        }

        model.addAttribute("appUserList", appUserService.listAppUser());
        return "appUser";   //powrót do widoku zawierającego błędy zawarte w obiekcie bindinresult
    }

    @RequestMapping("/delete/{appUserId}")
    public String deleteUser(@PathVariable("appUserId") Long appUserId) {
        appUserService.removeAppUser(appUserId);
        return "appUser";/*"redirect:/appUsers.html";*/
    }

    @RequestMapping(value = "/pagedUsers", method = RequestMethod.GET)
    public String showPagedUsers(Model model){
        model.addAttribute("numberOfPages", appUserService.getSpecificPage(0).getTotalPages());
        model.addAttribute("appUserList", appUserService.getSpecificPage(0).getContent());
        return "pagedUsers";
    }

    @RequestMapping(value = "/pagedUsers/{pageNumber}")
    public String showCertainPage(@PathVariable Integer pageNumber, Model model){
        model.addAttribute("numberOfPages", appUserService.getSpecificPage(0).getTotalPages());
        model.addAttribute("appUserList", appUserService.getSpecificPage(pageNumber).getContent());
        return "pagedUsers";
    }
}
