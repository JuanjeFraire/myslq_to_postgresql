package com.ehsaniara.multidatasource.repository.writeRepository;

import com.ehsaniara.multidatasource.model.Housing;
import com.ehsaniara.multidatasource.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Jay Ehsaniara, Dec 30 2019
 */
public interface UserWriteRepository extends CrudRepository<User, Long> {
}
