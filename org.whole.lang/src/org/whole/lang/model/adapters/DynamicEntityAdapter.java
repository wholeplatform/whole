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
package org.whole.lang.model.adapters;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class DynamicEntityAdapter extends AbstractEntityAdapter {
	private static final long serialVersionUID = 1;

	public DynamicEntityAdapter() {}
	public DynamicEntityAdapter(EntityDescriptor<?> ed) {
		wSetEntityDescriptor(ed);
	}

    private EntityDescriptor<?> entityDescriptor;
	public EntityDescriptor<?> wGetEntityDescriptor() {
		return entityDescriptor;
	}
	public void wSetEntityDescriptor(EntityDescriptor<?> entityDescriptor) {
		this.entityDescriptor = entityDescriptor;
	}

    @SuppressWarnings("unchecked")
	public <E extends IEntity> E wGetAdapter(EntityDescriptor<E> ed) {
    	if (ed.isLanguageSupertypeOf(wGetEntityDescriptor()) && ed.getEntityType().isAssignableFrom(getClass()))
    		return (E) this;
    	else
    		return wGetAdaptee(false).wGetAdapter(ed);
    }
}
