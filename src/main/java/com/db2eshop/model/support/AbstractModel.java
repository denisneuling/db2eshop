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
package com.db2eshop.model.support;

import java.io.Serializable;

/**
 * <p>
 * Abstract AbstractModel class.
 * </p>
 *
 * @author Denis Neuling (denisneuling@gmail.com)
 * 
 */
public abstract class AbstractModel<T extends AbstractModel<T>> implements Serializable {
	private static final long serialVersionUID = 2375311756226868202L;

	protected Class<T> clazz;

	/** {@inheritDoc} */
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

	/**
	 * <p>
	 * getId.
	 * </p>
	 *
	 * @return a {@link java.lang.Long} object.
	 */
	public abstract Long getId();

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		return result;
	}

	/**
	 * <p>
	 * setId.
	 * </p>
	 *
	 * @param id
	 *            a {@link java.lang.Long} object.
	 */
	public abstract void setId(Long id);

	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "Entity [clazz=" + clazz + ", id="+getId()+"]";
	}
	
	

}
