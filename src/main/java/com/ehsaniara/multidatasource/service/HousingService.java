package com.ehsaniara.multidatasource.service;

import com.ehsaniara.multidatasource.model.Housing;

import java.util.List;
import java.util.Optional;

/**
 * @author Jay Ehsaniara, Dec 30 2019
 */
public interface HousingService {

    Optional<Housing> getHousing(Long id);

    Housing createHousing(Housing customer);

    Housing updateHousing(Housing customer);

    List<Housing> findAll();
}
