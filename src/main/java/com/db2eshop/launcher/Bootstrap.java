package com.db2eshop.launcher;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db2eshop.model.Article;
import com.db2eshop.model.ArticleType;
import com.db2eshop.model.Customer;
import com.db2eshop.model.Employee;
import com.db2eshop.model.Import;
import com.db2eshop.model.Sale;
import com.db2eshop.model.Shipping;
import com.db2eshop.model.Supplier;
import com.db2eshop.persistence.ArticleDao;
import com.db2eshop.persistence.ArticleTypeDao;
import com.db2eshop.persistence.CustomerDao;
import com.db2eshop.persistence.EmployeeDao;
import com.db2eshop.persistence.ImportDao;
import com.db2eshop.persistence.SaleDao;
import com.db2eshop.persistence.ShippingDao;
import com.db2eshop.persistence.SupplierDao;
import com.db2eshop.util.common.Cities;
import com.db2eshop.util.common.Dates;
import com.db2eshop.util.common.DeliveryService;
import com.db2eshop.util.common.LoremIpsum;
import com.db2eshop.util.common.Persons;
import com.db2eshop.util.common.Products;
import com.db2eshop.util.common.Streets;

/**
 * <p>
 * Bootstrap class.
 * </p>
 * 
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
@Component
public class Bootstrap implements InitializingBean {
	protected Logger log = Logger.getLogger(getClass());

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

	/** {@inheritDoc} */
	@Override
	public void afterPropertiesSet() throws Exception {
		initializeDataSet();
	}

	private void initializeDataSet() {
		initializeArticleTypes();
		initializeArticles();
		initializeCustomers();
		initializeSuppliers();
		initializeEmployees();
		initializeShippings();
		initializeImports();
		initializeSales();
	}

	private void initializeArticleTypes() {
		ArticleType a = new ArticleType();
		a.setName("Food");
		articleTypeDao.save(a);

		ArticleType c = new ArticleType();
		c.setName("Dring");
		articleTypeDao.save(c);

		ArticleType b = new ArticleType();
		b.setName("Goodie");
		articleTypeDao.save(b);
	}

	private void initializeArticles() {
		int size = articleTypeDao.findAll().size();

		if (size > 0) {
			for (int i = 0; i < 20; i++) {
				Article article = new Article();
				article.setName(Products.product());
				String desc = LoremIpsum.phrase();
				article.setDescription((desc.length() > 255 ? desc.substring(0, 253) + "." : desc));
				article.setArticleType(articleTypeDao.findById(Long.parseLong((LoremIpsum.random.nextInt(size - 1) + 1) + "")));
				try {
					articleDao.save(article);
				} catch (Throwable throwable) {
					log.warn(throwable.getMessage());
				}
			}
		}
	}

	private void initializeCustomers() {
		List<Customer> customers = new LinkedList<Customer>();
		for (int i = 0; i < 30; i++) {
			Customer customer = new Customer();
			customer.setBirthday(Dates.date());
			customer.setCity(Cities.city());
			customer.setSurName(Persons.surName());
			customer.setPreName(Persons.preName());
			customer.setStreet(Streets.streetFull());
			customer.setTelephone(Cities.zipCode() + " " + Cities.zipCode());
			customer.setZipCode(Cities.zipCode());

			try {
				customers.add(customer);
			} catch (Throwable throwable) {
				log.warn(throwable.getMessage());
			}
		}
		customerDao.saveAll(customers);
	}

	private void initializeSuppliers() {
		for (int i = 0; i < 20; i++) {
			Supplier supplier = new Supplier();
			supplier.setName(DeliveryService.name());
			supplier.setTelephone(Cities.zipCode() + " " + Cities.zipCode());
			supplier.setZipCode(Cities.zipCode());
			supplier.setCity(Cities.city());
			try {
				supplierDao.save(supplier);
			} catch (Throwable throwable) {
				log.warn(throwable.getMessage());
			}
		}
	}

	private void initializeEmployees() {

		for (int i = 0; i < 20; i++) {
			Employee employee = new Employee();
			employee.setPreName(Persons.preName());
			employee.setSurName(Persons.surName());
			try {
				employeeDao.save(employee);
			} catch (Throwable throwable) {
				log.warn(throwable.getMessage());
			}
		}
	}

	private void initializeShippings() {
		for (int i = 0; i < 35; i++) {
			Shipping shipping = new Shipping();
			shipping.setName(DeliveryService.name());
			shipping.setTelephone(Cities.zipCode() + " " + Cities.zipCode());
			shipping.setZipCode(Cities.zipCode());
			shipping.setCity(Cities.city());
			try {
				shippingDao.save(shipping);
			} catch (Throwable throwable) {
				log.warn(throwable.getMessage());
			}
		}
	}
	
	private void initializeImports() {
		
		List<Article> articles = articleDao.findAll();
		List<Employee> employees = employeeDao.findAll();
		List<Supplier> suppliers = supplierDao.findAll();
		
		for(int i = 0 ; i < 50 ; i ++){
			Article article = articles.get(LoremIpsum.random.nextInt(articles.size()-1)+1);
			Employee employee = employees.get(LoremIpsum.random.nextInt(employees.size()-1)+1);
			Supplier supplier = suppliers.get(LoremIpsum.random.nextInt(suppliers.size()-1)+1);
			
			Import currentImport = new Import(); 
			currentImport.setArticle(article);
			currentImport.setCount(LoremIpsum.random.nextInt(10)+1);
			currentImport.setDate(Dates.date());
			currentImport.setEmployee(employee);
			currentImport.setSupplier(supplier);
			
			try{
				importDao.save(currentImport);
			} catch (Throwable throwable) {
				log.warn(throwable.getMessage());
			}
		}
	}
	
	private void initializeSales() {
		List<Article> articles = articleDao.findAll();
		List<Customer> customers = customerDao.findAll();
		List<Shipping> shippings = shippingDao.findAll();
		
		for(int i = 0 ; i < 50 ; i ++){
			Article article = articles.get(LoremIpsum.random.nextInt(articles.size()-1)+1);
			Customer customer = customers.get(LoremIpsum.random.nextInt(customers.size()-1)+1);
			Shipping shipping = shippings.get(LoremIpsum.random.nextInt(shippings.size()-1)+1);
			
			Sale sale = new Sale();
			sale.setArticle(article);
			sale.setCount(LoremIpsum.random.nextInt(10)+1);
			sale.setDate(Dates.date());
			sale.setCustomer(customer);
			sale.setShipping(shipping);
			
			try{
				saleDao.save(sale);
			} catch (Throwable throwable) {
				log.warn(throwable.getMessage());
			}
		}
	}

}
