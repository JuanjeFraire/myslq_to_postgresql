package com.ehsaniara.multidatasource.service;

import com.ehsaniara.multidatasource.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @author Jay Ehsaniara, Dec 30 2019
 */
public interface UserService {

    Optional<User> getUser(Long id);

    User createUser(User customer);

    User updateUser(User customer);

    List<User> findAll();
}
