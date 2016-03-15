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
import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class DynamicImplEntityRegistry extends AbstractEntityRegistry {
	public DynamicImplEntityRegistry(EntityDescriptorEnum edEnum) {
		super(edEnum);
	}

	protected void createPrototypes() {
		for (EntityDescriptor<?> ed : getEntityDescriptorEnum())
			if (!ed.isAbstract()) {
				IEntity entity = createEntity(ed);
				if (!ed.getEntityType().isAssignableFrom(entity.getClass()))
					put(CommonsEntityAdapterFactory.create(ed, entity));
				else
					put(entity);
			}
	}
	protected IEntity createEntity(EntityDescriptor<?> ed) {
		switch (ed.getEntityKind()) {
		case SIMPLE:
			return createSimpleEntity(ed);
		case DATA:
			return createDataEntity(ed);
		case COMPOSITE:
			return createCompositeEntity(ed);
		}
		throw new IllegalArgumentException();
	}

	protected IEntity createSimpleEntity(EntityDescriptor<?> ed) {
		return new SimpleEntityImpl(ed);
	}

	protected IEntity createCompositeEntity(EntityDescriptor<?> ed) {
		return new ListCompositeEntityImpl<IEntity>(ed);
	}

	protected IEntity createDataEntity(EntityDescriptor<?> ed) {
		switch (ed.getDataKind()) {
		case BOOLEAN:
			return new BooleanDataEntityImpl(ed);
		case BYTE:
			return new ByteDataEntityImpl(ed);
		case CHAR:
			return new CharDataEntityImpl(ed);
		case DOUBLE:
			return new DoubleDataEntityImpl(ed);
		case FLOAT:
			return new FloatDataEntityImpl(ed);
		case INT:
			return new IntDataEntityImpl(ed);
		case LONG:
			return new LongDataEntityImpl(ed);
		case SHORT:
			return new ShortDataEntityImpl(ed);
		case STRING:
			return new StringDataEntityImpl(ed);
		case DATE:
			return new DateDataEntityImpl(ed);
		case ENUM_VALUE:
			return new EnumValueDataEntityImpl(ed);
		case OBJECT:
			return new ObjectDataEntityImpl(ed);
		}
		throw new IllegalArgumentException();
	}
}
