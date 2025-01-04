package pl.dmcs.buarzej.service;

import pl.dmcs.buarzej.domain.AppUserRole;

import java.util.List;

public interface AppUserRoleService {
    void addAppUserRole(AppUserRole appUserRole);

    List<AppUserRole> listAppUserRole();

    AppUserRole getAppUserRole(long id);
}
