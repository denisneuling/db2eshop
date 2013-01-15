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
import com.db2eshop.gui.component.io.IdInput;
import com.db2eshop.gui.component.io.TextInput;
import com.db2eshop.model.support.AbstractModel;

@Entity
/**
 * <p>Employee class.</p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public class Employee extends AbstractModel<Employee> implements Serializable {
	private static final long serialVersionUID = 4080090521960388810L;

	@UIBind(IdInput.class)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@NotNull
	@NotEmpty
	@Length(max=255)
	@UIBind(TextInput.class)
	@Column(nullable = false)
	private String surName;

	@NotNull
	@NotEmpty
	@Length(max=255)
	@UIBind(TextInput.class)
	@Column(nullable = false)
	private String preName;

	@UIHide
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<Import> imports = new LinkedList<Import>();

	/**
	 * <p>
	 * Constructor for Employee.
	 * </p>
	 */
	public Employee() {
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
	 * <p>Getter for the field <code>surName</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * <p>Setter for the field <code>surName</code>.</p>
	 *
	 * @param surName a {@link java.lang.String} object.
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}

	/**
	 * <p>Getter for the field <code>preName</code>.</p>
	 *
	 * @return a {@link java.lang.String} object.
	 */
	public String getPreName() {
		return preName;
	}

	/**
	 * <p>Setter for the field <code>preName</code>.</p>
	 *
	 * @param preName a {@link java.lang.String} object.
	 */
	public void setPreName(String preName) {
		this.preName = preName;
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

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((preName == null) ? 0 : preName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
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
		Employee other = (Employee) obj;
		if (preName == null) {
			if (other.preName != null)
				return false;
		} else if (!preName.equals(other.preName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		return true;
	}

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return id + " " + preName + " " + surName;
	}

}
