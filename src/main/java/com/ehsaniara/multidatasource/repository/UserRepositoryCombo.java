package com.ehsaniara.multidatasource.repository;

import com.ehsaniara.multidatasource.repository.readRepository.UserReadRepository;
import com.ehsaniara.multidatasource.repository.writeRepository.UserWriteRepository;

public interface UserRepositoryCombo extends UserReadRepository, UserWriteRepository {

}
