/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.templates;

import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ResourceTemplateFactory<E extends IEntity> extends ModelTemplate implements ITemplateFactory<E> {
	protected String persistenceKitId;
	protected IPersistenceProvider persistenceProvider;
	
	public ResourceTemplateFactory(IPersistenceProvider pp) {
		this(null, pp);
	}
	public ResourceTemplateFactory(String persistenceKitId, IPersistenceProvider persistenceProvider) {
		super((IEntity) null);
		this.persistenceKitId = persistenceKitId;
		this.persistenceProvider = persistenceProvider;
	}

	protected IPersistenceKit getPersistenceKit() {
		return persistenceKitId != null ? ReflectionFactory.getPersistenceKit(persistenceKitId) : ReflectionFactory.getDefaultPersistenceKit();
	}

	public E create() {
		return EntityUtils.clone(share());
	};

	@SuppressWarnings("unchecked")
	public E share() {
		if (model == null)
    		try {
    			model = getPersistenceKit().readModel(persistenceProvider);
			} catch (Exception e) {
				throw new IllegalArgumentException(e);
			}
		return (E) model;
	}
}
