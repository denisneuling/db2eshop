/*
 * Copyright 2012 Denis Neuling, Dennis Wieding, Mateusz Wozniak
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
public class DatasetBootstrap implements InitializingBean {
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
		if (System.getProperty("datagen") != null) {
			initializeDataSet();
		}
	}

	private void initializeDataSet() {
		log.warn("============================== Initializing Dataset ====================================");
//		initializeArticleTypes();
//		initializeArticles();
//		initializeCustomers();
//		initializeSuppliers();
//		initializeEmployees();
//		initializeShippings();
//		initializeImports();
		initializeSales();
		log.warn("=========================== Initializing Dataset done ==================================");
	}

	private void initializeArticleTypes() {
		ArticleType a = new ArticleType();
		a.setName("Food");
		try {
			articleTypeDao.save(a);
		} catch (Throwable throwable) {
			log.warn(throwable.getMessage());
		}

		ArticleType c = new ArticleType();
		c.setName("Drink");
		try {
			articleTypeDao.save(c);
		} catch (Throwable throwable) {
			log.warn(throwable.getMessage());
		}

		ArticleType b = new ArticleType();
		b.setName("Goodie");
		try {
			articleTypeDao.save(b);
		} catch (Throwable throwable) {
			log.warn(throwable.getMessage());
		}
	}

	private void initializeArticles() {
		int size = articleTypeDao.findAll().size();

		if (size > 0) {
			for (int i = 0; i < 50; i++) {
				Article article = new Article();
				article.setName(Products.product());
				double price = LoremIpsum.random.nextDouble();
				if (price < 0) {
					price *= -1;
				}
				try {
					price *= 10;
					price = (double) Math.round(price * 100) / 100;
					article.setRetailPrice(price);
					article.setPurchasePrice((double) Math.round((double) (price + 2D) * 100) / 100);
					String desc = LoremIpsum.phrase();
					article.setDescription((desc.length() > 255 ? desc.substring(0, 253) + "." : desc));
					article.setArticleType(articleTypeDao.findById(Long.parseLong((LoremIpsum.random.nextInt(size - 1) + 1) + "")));
					articleDao.save(article);
				} catch (Throwable throwable) {
					log.warn(throwable.getMessage());
				}
			}
		}
	}

	private void initializeCustomers() {
		List<Customer> customers = new LinkedList<Customer>();
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setBirthday(Dates.date());
			customer.setCity(Cities.city());
			customer.setSurName(Persons.surName());
			customer.setPreName(Persons.preName());
			customer.setStreet(Streets.streetFull());
			customer.setTelephone(Cities.zipCode() + " " + Cities.zipCode());
			customer.setZipCode(new Long(Cities.zipCode()));

			try {
				customers.add(customer);
			} catch (Throwable throwable) {
				log.warn(throwable.getMessage());
			}
		}
		customerDao.saveAll(customers);
	}

	private void initializeSuppliers() {
		for (int i = 0; i < 10; i++) {
			Supplier supplier = new Supplier();
			supplier.setName(DeliveryService.name());
			supplier.setTelephone(Cities.zipCode() + " " + Cities.zipCode());
			supplier.setZipCode(new Long(Cities.zipCode()));
			supplier.setCity(Cities.city());
			try {
				supplierDao.save(supplier);
			} catch (Throwable throwable) {
				log.warn(throwable.getMessage());
			}
		}
	}

	private void initializeEmployees() {

		for (int i = 0; i < 10; i++) {
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
		for (int i = 0; i < 10; i++) {
			Shipping shipping = new Shipping();
			shipping.setName(DeliveryService.name());
			shipping.setTelephone(Cities.zipCode() + " " + Cities.zipCode());
			shipping.setZipCode(new Long(Cities.zipCode()));
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

		for (int i = 0; i < 30; i++) {
			try {
				Article article = articles.get(LoremIpsum.random.nextInt(articles.size() - 1) + 1);
				Employee employee = employees.get(LoremIpsum.random.nextInt(employees.size() - 1) + 1);
				Supplier supplier = suppliers.get(LoremIpsum.random.nextInt(suppliers.size() - 1) + 1);

				Import currentImport = new Import();
				currentImport.setArticle(article);
				currentImport.setCount(new Long(LoremIpsum.random.nextInt(10) + 20));
				currentImport.setDate(Dates.date());
				currentImport.setEmployee(employee);
				currentImport.setSupplier(supplier);

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

		for (int i = 0; i < 30; i++) {

			try {
				Article article = articles.get(LoremIpsum.random.nextInt(articles.size() - 1) + 1);
				Customer customer = customers.get(LoremIpsum.random.nextInt(customers.size() - 1) + 1);
				Shipping shipping = shippings.get(LoremIpsum.random.nextInt(shippings.size() - 1) + 1);

				Sale sale = new Sale();
				sale.setArticle(article);
				sale.setCount(new Long(LoremIpsum.random.nextInt(10) + 1));
				sale.setDate(Dates.date());
				sale.setCustomer(customer);
				sale.setShipping(shipping);
				saleDao.save(sale);
			} catch (Throwable throwable) {
				log.warn(throwable.getMessage());
			}
		}
	}

}
