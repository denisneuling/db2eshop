package com.db2eshop.governance.service.model;

import org.springframework.transaction.annotation.Transactional;

import com.db2eshop.governance.service.model.api.CrudService;
import com.db2eshop.model.Supplier;

@Transactional
public interface SupplierService extends CrudService<Supplier>{

}