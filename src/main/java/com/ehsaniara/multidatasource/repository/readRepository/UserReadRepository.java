package com.ehsaniara.multidatasource.repository.readRepository;

import com.ehsaniara.multidatasource.model.Housing;
import com.ehsaniara.multidatasource.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Jay Ehsaniara, Dec 30 2019
 */
public interface UserReadRepository extends CrudRepository<User, Long> {
}
