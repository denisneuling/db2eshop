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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.db2eshop.annotations.bindings.UIBind;
import com.db2eshop.annotations.bindings.UIEmbedded;
import com.db2eshop.annotations.bindings.UIHide;
import com.db2eshop.gui.component.io.DoubleInput;
import com.db2eshop.gui.component.io.IdInput;
import com.db2eshop.gui.component.io.TextArea;
import com.db2eshop.gui.component.io.TextInput;
import com.db2eshop.model.support.AbstractModel;

@Entity
/**
 * <p>Article class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Article extends AbstractModel<Article> implements Serializable {
	private static final long serialVersionUID = -3958701112789778500L;

	@UIBind(IdInput.class)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@NotNull
	@NotEmpty
	@Length(max=255)
	@UIBind(TextInput.class)
	@Column(unique = true)
	private String name;

	@NotNull
	@NotEmpty
	@UIBind(TextArea.class)
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@NotNull
	@Min(0)
	@UIBind(DoubleInput.class)
	@Column(nullable = false)
	private Double retailPrice = 0D;
	
	@NotNull
	@Min(0)
	@UIBind(DoubleInput.class)
	@Column(nullable = false)
	private Double purchasePrice = 0D;

	@UIEmbedded
	@ManyToOne
	private ArticleType articleType;

	@UIHide
	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
	private List<Sale> sales = new LinkedList<Sale>();

	@UIHide
	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
	private List<Import> imports = new LinkedList<Import>();

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

	/**
	 * <p>Getter for the field <code>sales</code>.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Sale> getSales() {
		return sales;
	}

	/**
	 * <p>Setter for the field <code>sales</code>.</p>
	 *
	 * @param sales a {@link java.util.List} object.
	 */
	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	/**
	 * <p>Getter for the field <code>imports</code>.</p>
	 *
	 * @return a {@link java.util.List} object.
	 */
	public List<Import> getImports() {
		return imports;
	}

	/**
	 * <p>Setter for the field <code>imports</code>.</p>
	 *
	 * @param imports a {@link java.util.List} object.
	 */
	public void setImports(List<Import> imports) {
		this.imports = imports;
	}
	
	/**
	 * <p>Getter for the field <code>retailPrice</code>.</p>
	 *
	 * @return a {@link java.lang.Double} object.
	 */
	public Double getRetailPrice() {
		return retailPrice;
	}

	/**
	 * <p>Setter for the field <code>retailPrice</code>.</p>
	 *
	 * @param retailPrice a {@link java.lang.Double} object.
	 */
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	/**
	 * <p>Getter for the field <code>purchasePrice</code>.</p>
	 *
	 * @return a {@link java.lang.Double} object.
	 */
	public Double getPurchasePrice() {
		return purchasePrice;
	}

	/**
	 * <p>Setter for the field <code>purchasePrice</code>.</p>
	 *
	 * @param purchasePrice a {@link java.lang.Double} object.
	 */
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((articleType == null) ? 0 : articleType.hashCode());
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
		return id + " " + name;
	}
}
