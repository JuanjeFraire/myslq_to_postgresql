package com.ehsaniara.multidatasource.repository.readRepository;

import com.ehsaniara.multidatasource.model.Housing;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Jay Ehsaniara, Dec 30 2019
 */
public interface HousingReadRepository extends CrudRepository<Housing, Long> {
}
