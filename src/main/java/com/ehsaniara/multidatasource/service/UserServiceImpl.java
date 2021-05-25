package com.ehsaniara.multidatasource.service;

import com.ehsaniara.multidatasource.model.User;
import com.ehsaniara.multidatasource.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Jay Ehsaniara, Dec 30 2019
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository customerRepository;

    public UserServiceImpl(UserRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<User> getUser(Long id) {
        return customerRepository.findById(id);
    }

    public User createUser(User User) {

//        Assert.notNull(User, "Invalid User");
//        Assert.isNull(User.getId(), "User id should be null");
//        Assert.notNull(User.getCode(), "Invalid User code");

        return customerRepository.save(User);
    }

    public User updateUser(User customer) {

        Assert.notNull(customer, "Invalid customer");
        Assert.notNull(customer.getId(), "Invalid customer id");

        return customerRepository.save(customer);
    }

    @Override
    public List<User> findAll() {
        List<User> UserList = new ArrayList<>();
        Iterable<User> UserIterable = customerRepository.findAll();
        UserIterable.forEach(UserList::add);
        return UserList;
    }
}
