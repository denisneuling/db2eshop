package com.db2eshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.db2eshop.model.support.AbstractModel;

@Entity
/**
 * <p>Article class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Article extends AbstractModel<Article> implements Serializable{
	private static final long serialVersionUID = -3958701112789778500L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique=true)
	private String name;

	@Column
	private Integer count;

	@Column(columnDefinition="TEXT")
	private String description;

	@ManyToOne
	private ArticleType articleType;

	/**
	 * <p>
	 * Constructor for Article.
	 * </p>
	 */
	public Article() {
	}

	/** {@inheritDoc} */
	@Override
	public Long getId() {
		return id;
	}

	/** {@inheritDoc} */
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * <p>Getter for the field <code>name</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * <p>Setter for the field <code>name</code>.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * <p>Getter for the field <code>count</code>.</p>
	 *
	 * @return a int.
	 */
	public int getCount() {
		return count;
	}

	/**
	 * <p>Setter for the field <code>count</code>.</p>
	 *
	 * @param count a int.
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * <p>Getter for the field <code>description</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <p>Setter for the field <code>description</code>.</p>
	 *
	 * @param description a {@link java.lang.String} object.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * <p>Getter for the field <code>articleType</code>.</p>
	 *
	 * @return a {@link com.db2eshop.model.ArticleType} object.
	 */
	public ArticleType getArticleType() {
		return articleType;
	}

	/**
	 * <p>Setter for the field <code>articleType</code>.</p>
	 *
	 * @param articleType a {@link com.db2eshop.model.ArticleType} object.
	 */
	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((articleType == null) ? 0 : articleType.hashCode());
		result = prime * result + count;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (articleType == null) {
			if (other.articleType != null)
				return false;
		} else if (!articleType.equals(other.articleType))
			return false;
		if (count != other.count)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", count=" + count + ", description=" + description + "]";
	}
}
