package com.ehsaniara.multidatasource.service;

import com.ehsaniara.multidatasource.model.Housing;
import com.ehsaniara.multidatasource.repository.HousingRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Jay Ehsaniara, Dec 30 2019
 */
@Service
public class HousingServiceImpl implements HousingService {

    private final HousingRepository customerRepository;

    public HousingServiceImpl(HousingRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Housing> getHousing(Long id) {
        return customerRepository.findById(id);
    }

    public Housing createHousing(Housing housing) {

//        Assert.notNull(housing, "Invalid housing");
//        Assert.isNull(housing.getId(), "housing id should be null");
//        Assert.notNull(housing.getCode(), "Invalid housing code");

        return customerRepository.save(housing);
    }

    public Housing updateHousing(Housing customer) {

        Assert.notNull(customer, "Invalid customer");
        Assert.notNull(customer.getId(), "Invalid customer id");

        return customerRepository.save(customer);
    }

    @Override
    public List<Housing> findAll() {
        List<Housing> housingList = new ArrayList<>();
        Iterable<Housing> housingIterable = customerRepository.findAll();
        housingIterable.forEach(housingList::add);
        return housingList;
    }
}
