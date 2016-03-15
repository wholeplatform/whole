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
package org.whole.lang.model.impl;

import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.model.AbstractCharDataEntity;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.visitors.IVisitor;

/** 
 * @author Riccardo Solmi
 */
public class CharDataEntityImpl extends AbstractCharDataEntity {
	private static final long serialVersionUID = 1;

	public CharDataEntityImpl() {}
	public CharDataEntityImpl(EntityDescriptor<?> ed) {
		wSetEntityDescriptor(ed);
	}

	public void accept(IVisitor visitor) {
		visitor.visit(this); //FIXME
	}

    @SuppressWarnings("unchecked")
	public <T extends IEntity> T wGetAdapter(EntityDescriptor<T> targetEd) {
    	EntityDescriptor<?> ed = wGetEntityDescriptor();
    	if (targetEd.isLanguageSupertypeOf(ed)) {
			if (targetEd.getEntityType().isAssignableFrom(getClass()))
				return (T) this;
			else if (targetEd.getEntityType().isAssignableFrom(ed.getEntityType()))
	    		return (T) CommonsEntityAdapterFactory.create(ed, this);
			else
				return (T) CommonsEntityAdapterFactory.create(
						targetEd.getEntityDescriptorEnum().valueOf(ed.getName()), this);
	    }
		return CommonsEntityAdapterFactory.create(targetEd, this);
    }

    private EntityDescriptor<?> entityDescriptor;
	public EntityDescriptor<?> wGetEntityDescriptor() {
		return entityDescriptor;
	}
	public void wSetEntityDescriptor(EntityDescriptor<?> entityDescriptor) {
		this.entityDescriptor = entityDescriptor;
	}
}