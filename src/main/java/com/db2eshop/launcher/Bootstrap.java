package com.db2eshop.launcher;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.db2eshop.model.Article;
import com.db2eshop.model.ArticleType;
import com.db2eshop.model.Customer;
import com.db2eshop.persistence.ArticleDao;
import com.db2eshop.persistence.ArticleTypeDao;
import com.db2eshop.persistence.CustomerDao;
import com.db2eshop.util.LoremIpsum;

@Component
public class Bootstrap implements ApplicationListener<ApplicationEvent> {

	@Autowired
	private ArticleTypeDao articleTypeDao;

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private CustomerDao customerDao;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ContextRefreshedEvent) {
			initializeDataSet();
		}
	}

	private void initializeDataSet() {
		 initializeArticleTypes();
		 initializeArticles();
		 initializeCustomers();
	}

	public void initializeArticleTypes() {
		List<ArticleType> articleTypes = new LinkedList<ArticleType>();
		for (int i = 0; i < 15; i++) {
			ArticleType articleType = new ArticleType();
			articleType.setName(LoremIpsum.phrase(LoremIpsum.random.nextInt(3) + 1));
			articleTypes.add(articleType);
		}
		articleTypeDao.saveAll(articleTypes);
	}

	public void initializeArticles() {
		int size = articleTypeDao.findAll().size();

		if (size > 0) {
			List<Article> articles = new LinkedList<Article>();
			for (int i = 0; i < 100; i++) {
				Article article = new Article();
				article.setCount(LoremIpsum.random.nextInt(5000));
				article.setName(LoremIpsum.secureRandomString());
				String desc = LoremIpsum.phrase();
				article.setDescription((desc.length() > 255 ? desc.substring(0, 253) + "." : desc));
				article.setArticleType(articleTypeDao.findById(Long.parseLong((LoremIpsum.random.nextInt(size - 1) + 1) + "")));
				articles.add(article);
			}
			articleDao.saveAll(articles);
		}
	}

	public void initializeCustomers() {
		List<Customer> customers = new LinkedList<Customer>();
		for (int i = 0; i < 200; i++) {
			Customer customer = new Customer();
			customer.setBirthday(LoremIpsum.word());
			customer.setCity(LoremIpsum.word());
			customer.setCount(LoremIpsum.random.nextInt(100));
			customer.setName(LoremIpsum.word());
			customer.setPreName(LoremIpsum.word());
			customer.setStreet(LoremIpsum.word());
			customer.setTelephone(LoremIpsum.word());
			customer.setZipCode(LoremIpsum.word());

			customers.add(customer);
		}
		customerDao.saveAll(customers);
	}

}
