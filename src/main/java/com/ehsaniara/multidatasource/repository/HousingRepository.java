package com.ehsaniara.multidatasource.repository;

import com.ehsaniara.multidatasource.model.Housing;
import com.ehsaniara.multidatasource.repository.readRepository.HousingReadRepository;
import com.ehsaniara.multidatasource.repository.writeRepository.HousingWriteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HousingRepository implements HousingRepositoryCombo {

    private final HousingReadRepository readRepository;
    private final HousingWriteRepository writeRepository;

    public HousingRepository(HousingReadRepository customerReadRepository, HousingWriteRepository customerWriteRepository) {
        this.readRepository = customerReadRepository;
        this.writeRepository = customerWriteRepository;
    }

    @Override
    public <S extends Housing> S save(S s) {
        return writeRepository.save(s);
    }

    @Override
    public <S extends Housing> Iterable<S> saveAll(Iterable<S> iterable) {
        return writeRepository.saveAll(iterable);
    }

    @Override
    public Optional<Housing> findById(Long aLong) {
        return readRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return readRepository.existsById(aLong);
    }

    @Override
    public Iterable<Housing> findAll() {
        return readRepository.findAll();
    }

    @Override
    public Iterable<Housing> findAllById(Iterable<Long> iterable) {
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
    public void delete(Housing customer) {
        writeRepository.delete(customer);
    }

    @Override
    public void deleteAll(Iterable<? extends Housing> iterable) {
        writeRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        writeRepository.deleteAll();
    }
}
