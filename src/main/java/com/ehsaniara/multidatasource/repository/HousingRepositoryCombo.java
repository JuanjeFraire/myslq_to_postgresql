package com.ehsaniara.multidatasource.repository;

import com.ehsaniara.multidatasource.repository.readRepository.HousingReadRepository;
import com.ehsaniara.multidatasource.repository.writeRepository.HousingWriteRepository;

public interface HousingRepositoryCombo extends HousingReadRepository, HousingWriteRepository {

}
