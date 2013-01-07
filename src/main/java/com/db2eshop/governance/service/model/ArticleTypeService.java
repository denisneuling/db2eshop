package com.db2eshop.governance.service.model;

import org.springframework.transaction.annotation.Transactional;

import com.db2eshop.governance.service.model.api.CrudService;
import com.db2eshop.model.ArticleType;

@Transactional
public interface ArticleTypeService extends CrudService<ArticleType>{

}
