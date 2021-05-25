package com.ehsaniara.multidatasource.repository;

import com.ehsaniara.multidatasource.model.User;
import com.ehsaniara.multidatasource.repository.readRepository.UserReadRepository;
import com.ehsaniara.multidatasource.repository.writeRepository.UserWriteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRepository implements UserRepositoryCombo {

    private final UserReadRepository readRepository;
    private final UserWriteRepository writeRepository;

    public UserRepository(UserReadRepository customerReadRepository, UserWriteRepository customerWriteRepository) {
        this.readRepository = customerReadRepository;
        this.writeRepository = customerWriteRepository;
    }

    @Override
    public <S extends User> S save(S s) {
        return writeRepository.save(s);
    }

    @Override
    public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
        return writeRepository.saveAll(iterable);
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return readRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return readRepository.existsById(aLong);
    }

    @Override
    public Iterable<User> findAll() {
        return readRepository.findAll();
    }

    @Override
    public Iterable<User> findAllById(Iterable<Long> iterable) {
        return readRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return readRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        writeRepository.deleteById(aLong);
    }

    @Override
    public void delete(User customer) {
        writeRepository.delete(customer);
    }

    @Override
    public void deleteAll(Iterable<? extends User> iterable) {
        writeRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        writeRepository.deleteAll();
    }
}
