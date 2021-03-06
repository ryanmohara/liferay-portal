/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.vulcan.wiring.osgi.model;

/**
 * Represents the relation between a thing and a collection.
 *
 * @author Alejandro Hernández
 */
public class RelatedCollection<T, S> {

	public RelatedCollection(String key, Class<S> modelClass) {
		_key = key;
		_modelClass = modelClass;
	}

	/**
	 * Returns the key of the relation.
	 *
	 * @return key of the relation.
	 */
	public String getKey() {
		return _key;
	}

	/**
	 * Returns the class of the collection's related models.
	 *
	 * @return class of the collection's related models.
	 */
	public Class<S> getModelClass() {
		return _modelClass;
	}

	private final String _key;
	private final Class<S> _modelClass;

}