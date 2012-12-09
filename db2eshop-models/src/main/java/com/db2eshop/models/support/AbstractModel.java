package com.db2eshop.models.support;

import java.io.Serializable;

public abstract class AbstractModel<T extends AbstractModel<T>> implements Serializable {
	private static final long serialVersionUID = 2375311756226868202L;

	protected Class<T> clazz;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		@SuppressWarnings("rawtypes")
		AbstractModel other = (AbstractModel) obj;
		if (clazz == null) {
			if (other.clazz != null) {
				return false;
			}
		} else if (!clazz.equals(other.clazz)) {
			return false;
		}
		return true;
	}

	public abstract Long getId();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		return result;
	}

	public abstract void setId(Long id);

}