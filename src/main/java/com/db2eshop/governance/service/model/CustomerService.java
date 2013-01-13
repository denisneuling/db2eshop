package com.db2eshop.governance.service.model;

import org.springframework.transaction.annotation.Transactional;

import com.db2eshop.governance.service.model.api.CrudService;
import com.db2eshop.model.Customer;

@Transactional
/**
 * <p>CustomerService interface.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public interface CustomerService extends CrudService<Customer>{

}
