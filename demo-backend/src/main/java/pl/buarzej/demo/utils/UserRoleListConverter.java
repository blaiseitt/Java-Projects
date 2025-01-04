package pl.buarzej.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.buarzej.demo.model.domain.UserRole;
import pl.buarzej.demo.service.UserRoleService;

import java.util.HashSet;
import java.util.Set;

public class UserRoleListConverter implements Converter<String[], Set<UserRole>> {

    private UserRoleService userRoleService;

    @Autowired
    public UserRoleListConverter(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @Override
    public Set<UserRole> convert(String[] source) {

        Set<UserRole> userRoles = new HashSet<UserRole>(0);

        for (int i = 0; i < source.length; i++) {
            userRoles.add(userRoleService.getUserRole(Integer.parseInt(source[i])));
        }
        return userRoles;
    }
}
