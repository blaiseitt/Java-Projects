package pl.dmcs.buarzej.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.buarzej.dao.AppUserRepository;
import pl.dmcs.buarzej.dao.AppUserRoleRepository;
import pl.dmcs.buarzej.domain.AppUser;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    private AppUserRepository appUserRepository;        //mechanizm wstrzykiwania zależności autowired
    private AppUserRoleRepository appUserRoleRepository;

    @Autowired          //zależność wstrzykiwana przez konstruktor
    public AppUserServiceImpl(AppUserRepository appUserRepository, AppUserRoleRepository appUserRoleRepository) {
        //dodajemy repozytroium roli użytkownika
        this.appUserRepository = appUserRepository;
        this.appUserRoleRepository = appUserRoleRepository;
    }

    @Transactional
    public void addAppUser(AppUser appUser) {
        appUser.setPassword(hashPassword(appUser.getPassword()));   //szyfrowanie hasła uzytkownika
        appUserRepository.save(appUser);
        //możliwość przypisania roli do użytkownika którego dodajemy
    }

    @Transactional
    public void editAppUser(AppUser appUser) {
        //appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER"));
        appUser.setPassword(hashPassword(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();    //szyfrowanie działa tak że w żadnym momencie, ani dokumentacji nie ma metod umożliwiającvch odszyfrowania hasła
        return passwordEncoder.encode(password);                                //żeby np. przypomnieć hasło potrzebna była by zewnętrzna biblioteka na podstawie której hasło byłoby odszyfrowane
    }                                                                           //w bazie danych znajdują się tylko hashe. Jak użytkownik się loguje to porównywane są dwa hashe

    @Transactional
    public List<AppUser> listAppUser() {
        return appUserRepository.findAll();
    }

    @Transactional
    public void removeAppUser(long id) {
        appUserRepository.delete(id);
    }

    @Transactional
    public AppUser getAppUser(long id) {
        return appUserRepository.findById(id);
    }

    @Transactional
    public AppUser findByLogin(String login) {
        return appUserRepository.findByLogin(login);
    }

    @Transactional
    public AppUser findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Transactional
    public void addWithFixedRole(AppUser appUser) {
        appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER")); //ustawienie na sztywno roli użytkownika
        appUser.setPassword(hashPassword(appUser.getPassword()));
        appUserRepository.save(appUser);
    }

    @Transactional
    public void confirmUser(AppUser appUser) {
        appUserRepository.save(appUser);
    }

    @Override
    public Page getSpecificPage(Integer pageNumber) {
        return appUserRepository.findAll(new PageRequest(pageNumber, 3));
    }
}
