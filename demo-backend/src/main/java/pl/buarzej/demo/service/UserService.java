package pl.buarzej.demo.service;

import pl.buarzej.demo.model.domain.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    void editUser(User user);

    List<User> listUser();

    User getUser(long id) throws Exception;

    User findByName(String username) throws Exception;

}
