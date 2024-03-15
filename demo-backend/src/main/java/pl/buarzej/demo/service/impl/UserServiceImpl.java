package pl.buarzej.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.buarzej.demo.dao.UserRepository;
import pl.buarzej.demo.dao.UserRoleRepository;
import pl.buarzej.demo.model.domain.User;
import pl.buarzej.demo.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public static final String ROLE_FOR_USER = "ROLE_USER";

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserRoleRepository userRoleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void addUserWithFixedRole(User user) {
        user.getUserRole().add(userRoleRepository.findByRole(ROLE_FOR_USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void editUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Transactional
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Transactional
    public User getUser(long id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not found for id: " + id));
    }

    @Transactional
    public User findByLogin(String username) throws Exception {
        return userRepository.findByLogin(username)
                .orElseThrow(() -> new Exception("User not found for name: " + username));
    }
}
