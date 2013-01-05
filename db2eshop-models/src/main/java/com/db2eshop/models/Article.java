package com.db2eshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.db2eshop.models.support.AbstractModel;

@Entity
/**
 * <p>Article class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * @version $Id: $Id
 */
public class Article extends AbstractModel<Article> {
	private static final long serialVersionUID = -3958701112789778500L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@Column
	private int count;

	@Column
	private String description;

	@Column
	private ArticleType articleType;

	/**
	 * <p>
	 * Constructor for Article.
	 * </p>
	 */
	public Article() {
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
