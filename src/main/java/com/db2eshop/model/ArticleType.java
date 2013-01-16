package com.db2eshop.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.db2eshop.annotations.bindings.UIBind;
import com.db2eshop.annotations.bindings.UIHide;
import com.db2eshop.gui.component.io.IdForm;
import com.db2eshop.gui.component.io.TextForm;
import com.db2eshop.model.support.AbstractModel;

@Entity
/**
 * <p>ArticleType class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class ArticleType extends AbstractModel<ArticleType> implements Serializable {
	private static final long serialVersionUID = 2387929026098277701L;

	@UIBind(IdForm.class)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@NotNull
	@NotEmpty
	@Length(max=255)
	@UIBind(TextForm.class)
	@Column(unique = true)
	private String name;

	@UIHide
	@OneToMany(mappedBy = "articleType", fetch = FetchType.LAZY)
	private List<Article> articles = new LinkedList<Article>();

	/**
	 * <p>
	 * Constructor for ArticleType.
	 * </p>
	 */
	public ArticleType() {
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
	 * <p>Getter for the field <code>articles</code>.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Article> getArticles() {
		return articles;
	}

	/**
	 * <p>Setter for the field <code>articles</code>.</p>
	 *
	 * @param articles a {@link java.util.List} object.
	 */
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		ArticleType other = (ArticleType) obj;
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
		return id + " " + name;
	}
}
