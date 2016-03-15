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
package org.whole.lang.factories;

import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.model.PrototypeFragmentModel;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.util.CompositeUtils;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractEntityRegistry implements IEntityRegistry {
	private EntityDescriptorEnum entityDescriptorEnum;
	protected IEntity[] registry;

	protected AbstractEntityRegistry(EntityDescriptorEnum entityDescriptorEnum) {
		setEntityDescriptorEnum(entityDescriptorEnum);
		ensureCapacity(entityDescriptorEnum.size());
		createPrototypes();
	}

	protected abstract void createPrototypes();

	public IEntityRegistry getEntityRegistry(EntityDescriptor<?> ed) {
		return this;
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return entityDescriptorEnum;
	}
	public void setEntityDescriptorEnum(EntityDescriptorEnum entityDescriptorEnum) {
		this.entityDescriptorEnum = entityDescriptorEnum;
	}

	protected void ensureCapacity(int size) {
		registry = new IEntity[size];
	}

	public void put(IEntity prototype) {
		int index = prototype.wGetEntityDescriptor().getOrdinal();
		registry = CompositeUtils.grow(registry, index+1, null);
		registry[index] = prototype;
	}

	@SuppressWarnings("unchecked")
	public <E extends IEntity> E get(EntityDescriptor<E> ed) {
		E prototype = null;
		if (ed.getOrdinal() < registry.length)
			prototype = (E) registry[ed.getOrdinal()];
		if (prototype == null)
			prototype = CommonsEntityAdapterFactory.createResolver(ed);

		return prototype;
	}

	public void finalizeRegistryConfiguration() {
		for (int i=0, length=registry.length; i<length; i++)
			if (registry[i] != null)
				((InternalIEntity) registry[i]).wSetModel(PrototypeFragmentModel.instance);
	}
}
