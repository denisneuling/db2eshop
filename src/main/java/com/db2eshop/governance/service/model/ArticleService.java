package com.db2eshop.governance.service.model;

import org.springframework.transaction.annotation.Transactional;

import com.db2eshop.governance.service.model.api.CrudService;
import com.db2eshop.model.Article;

/**
 * <p>ArticleService interface.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Transactional
public interface ArticleService extends CrudService<Article>{

}
