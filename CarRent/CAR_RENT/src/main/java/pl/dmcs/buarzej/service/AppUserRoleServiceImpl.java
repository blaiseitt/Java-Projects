package pl.dmcs.buarzej.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.buarzej.dao.AppUserRoleRepository;
import pl.dmcs.buarzej.domain.AppUserRole;

import java.util.List;

@Service("appUserRoleService")
public class AppUserRoleServiceImpl implements AppUserRoleService {
    //klasa implementująca serwis
    private AppUserRoleRepository appUserRoleRepository;

    //wstrzyknięcie repozytorium odpowiedzialnego za pobieranie użytkowniika z bazy danych
    @Autowired
    public AppUserRoleServiceImpl(AppUserRoleRepository appUserRoleRepository) {
        this.appUserRoleRepository = appUserRoleRepository;
    }

    //dodawanie
    @Transactional
    public void addAppUserRole(AppUserRole appUserRole) {
        appUserRoleRepository.save(appUserRole);
    }

    //pobieranie pełnej listy
    @Transactional
    public List<AppUserRole> listAppUserRole() {
        return appUserRoleRepository.findAll();
    }

    //pobieranie jednego elementu na podstawie id
    @Transactional
    public AppUserRole getAppUserRole(long id) {
        return appUserRoleRepository.getOne(id);
    }
}