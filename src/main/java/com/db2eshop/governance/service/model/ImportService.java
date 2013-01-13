package com.db2eshop.governance.service.model;

import org.springframework.transaction.annotation.Transactional;

import com.db2eshop.governance.service.model.api.CrudService;
import com.db2eshop.model.Import;

/**
 * <p>ImportService interface.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Transactional
public interface ImportService extends CrudService<Import>{

}
