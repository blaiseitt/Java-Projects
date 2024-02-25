package pl.buarzej.demo.service;

import pl.buarzej.demo.model.domain.UserRole;

import java.util.List;

public interface UserRoleService {

    void addUserRole(UserRole userRole);

    List<UserRole> listAppUserRole();

    UserRole getUserRole(long id);
}
