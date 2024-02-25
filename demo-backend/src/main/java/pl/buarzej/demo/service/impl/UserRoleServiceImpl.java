package pl.buarzej.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.buarzej.demo.dao.UserRoleRepository;
import pl.buarzej.demo.model.domain.UserRole;
import pl.buarzej.demo.service.UserRoleService;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional
    public void addUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Transactional
    public List<UserRole> listAppUserRole() {
        return userRoleRepository.findAll();
    }

    @Transactional
    public UserRole getUserRole(long id) {
        return userRoleRepository.getById(id);
    }
}
