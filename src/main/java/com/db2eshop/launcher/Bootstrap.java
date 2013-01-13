package com.db2eshop.launcher;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.model.Article;
import com.db2eshop.model.ArticleType;
import com.db2eshop.model.Customer;
import com.db2eshop.model.Shipping;
import com.db2eshop.persistence.ArticleDao;
import com.db2eshop.persistence.ArticleTypeDao;
import com.db2eshop.persistence.CustomerDao;
import com.db2eshop.persistence.EmployeeDao;
import com.db2eshop.persistence.ImportDao;
import com.db2eshop.persistence.SaleDao;
import com.db2eshop.persistence.ShippingDao;
import com.db2eshop.persistence.SupplierDao;
import com.db2eshop.util.LoremIpsum;

@Component
/**
 * <p>Bootstrap class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class Bootstrap implements InitializingBean{

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private ArticleTypeDao articleTypeDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private ImportDao importDao;

	@Autowired
	private SaleDao saleDao;

	@Autowired
	private ShippingDao shippingDao;

	@Autowired
	private SupplierDao supplierDao;

	@Override

	public void afterPropertiesSet() throws Exception {
		initializeDataSet();
	}

	private void initializeDataSet() {
		 initializeArticleTypes();
		 initializeArticles();
		 initializeCustomers();
//		 initializeShippings();
//		 initializeSales();
//		 initializeEmployees();
//		 initializeSuppliers();
//		 initializeImports();
	}

	/**
	 * <p>
	 * initializeArticleTypes.
	 * </p>
	 */
	public void initializeArticleTypes() {
		List<ArticleType> articleTypes = new LinkedList<ArticleType>();
		for (int i = 0; i < 15; i++) {
			ArticleType articleType = new ArticleType();
			articleType.setName(LoremIpsum.secureRandomString());
			articleTypes.add(articleType);
		}
		articleTypeDao.saveAll(articleTypes);
	}

	/**
	 * <p>
	 * initializeArticles.
	 * </p>
	 */
	public void initializeArticles() {
		int size = articleTypeDao.findAll().size();

		if (size > 0) {
			List<Article> articles = new LinkedList<Article>();
			for (int i = 0; i < 20; i++) {
				Article article = new Article();
				article.setName(LoremIpsum.secureRandomString());
				String desc = LoremIpsum.phrase();
				article.setDescription((desc.length() > 255 ? desc.substring(0, 253) + "." : desc));
				article.setArticleType(articleTypeDao.findById(Long.parseLong((LoremIpsum.random.nextInt(size - 1) + 1) + "")));
				articles.add(article);
			}
			articleDao.saveAll(articles);
		}
	}

	/**
	 * <p>
	 * initializeCustomers.
	 * </p>
	 */
	public void initializeCustomers() {
		List<Customer> customers = new LinkedList<Customer>();
		for (int i = 0; i < 30; i++) {
			Customer customer = new Customer();
			customer.setBirthday(new Date());
			customer.setCity(LoremIpsum.word());
			customer.setSurName(LoremIpsum.word());
			customer.setPreName(LoremIpsum.word());
			customer.setStreet(LoremIpsum.word());
			customer.setTelephone(LoremIpsum.word());
			customer.setZipCode(LoremIpsum.word());

			customers.add(customer);
		}
		customerDao.saveAll(customers);
	}

	private void initializeShippings() {
		List<Shipping> shippings = new LinkedList<Shipping>();
		for (int i = 0; i < 35; i++) {
			Shipping shipping = new Shipping();
			shipping.setName(LoremIpsum.secureRandomString());
			shipping.setTelephone(LoremIpsum.word());
			shipping.setZipCode(LoremIpsum.word());
			shippings.add(shipping);
		}
		shippingDao.saveAll(shippings);
	}
	
	private void initializeSuppliers() {
	}


	private void initializeSales() {
	}

	private void initializeImports() {
	}

	private void initializeEmployees() {
	}
}
