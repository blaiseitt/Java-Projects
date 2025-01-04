package pl.buarzej.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.buarzej.demo.model.domain.UserRole;
import pl.buarzej.demo.service.UserRoleService;

import java.util.HashSet;
import java.util.Set;

public class UserRoleConverter implements Converter<String, Set<UserRole>> {

    private UserRoleService userRoleService;

    @Autowired
    public UserRoleConverter(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public Set<UserRole> convert(String source) {
        Set<UserRole> userRoles = new HashSet<UserRole>(0);
        userRoles.add(userRoleService.getUserRole(Integer.parseInt(source)));
        return userRoles;
    }
}
