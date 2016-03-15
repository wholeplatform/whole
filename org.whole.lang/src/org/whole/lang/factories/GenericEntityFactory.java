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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.InternalIEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class GenericEntityFactory implements IEntityFactory {
	protected IEntityRegistryProvider entityRegistryProvider;
	
	public static final IEntityFactory instance = instance(RegistryConfigurations.DEFAULT);
	public static IEntityFactory instance(IEntityRegistryProvider provider) {
		return new GenericEntityFactory(provider);
	}
	protected GenericEntityFactory(IEntityRegistryProvider entityRegistryProvider) {
		this.entityRegistryProvider = entityRegistryProvider;
	}

	public final IEntityRegistry getEntityRegistry(EntityDescriptor<?> ed) {
		return entityRegistryProvider.getEntityRegistry(ed);
	}
	protected final <E extends IEntity> E get(EntityDescriptor<E> ed) {
		return getEntityRegistry(ed).get(ed);
	}

	protected <E extends IEntity> E clone(E prototype) {
		return EntityUtils.clone(prototype);
	}

//TODO rename resolverClone
	public <E extends IEntity> E clone(EntityDescriptor<E> ed, int initialSize) {
		if (!EntityUtils.isComposite(ed))
			throw new IllegalArgumentException("Expecting a composite entity");

		IEntity[] values = new IEntity[initialSize];
		for (int i=0; i<initialSize; i++)
			values[i] = CommonsEntityAdapterFactory.createResolver(ed.getEntityDescriptor(i));			
		return create(ed, values);
	}
	@SuppressWarnings("unchecked")
	public <E extends IEntity> E shallowClone(EntityDescriptor<E> ed) {
		return (E) ((InternalIEntity) get(ed)).wShallowClone();
	}
	public <E extends IEntity> E shallowClone(EntityDescriptor<E> ed, IEntity... args) {
		E entity = shallowClone(ed);
		for (int i = 0; i < args.length; i++)
			entity.wSet(i, args[i]);
		return entity;
	}
	public IEntity cloneFeature(EntityDescriptor<?> ed, int index) {
		IEntity prototype = get(ed);
		if (index < prototype.wSize())
			return clone(prototype.wGet(index));
		if (EntityUtils.isComposite(prototype) && prototype.wSize() == 1)
			return clone(prototype.wGet(0));
		return CommonsEntityAdapterFactory.createResolver(ed.getEntityDescriptor(0));		
	}
	public IEntity cloneFeature(EntityDescriptor<?> ed, FeatureDescriptor fd) {
		return clone(get(ed).wGet(fd));
	}
	public boolean matchFeature(EntityDescriptor<?> ed, int index, IEntity value) {
		return Matcher.match(value, get(ed).wGet(index));
	}
	public boolean matchFeature(EntityDescriptor<?> ed, FeatureDescriptor fd, IEntity value) {
		return Matcher.match(value, get(ed).wGet(fd));
	}

	public <E extends IEntity> E create(EntityDescriptor<E> ed) {
		return clone(get(ed));
	}
	public <E extends IEntity> E create(EntityDescriptor<E> ed, Object value) {
		E entity = shallowClone(ed);
		if (EntityUtils.isData(entity))
			entity.wSetValue(value);
		else if (EntityUtils.isData(ed.getEntityDescriptor(0)))
			entity.wSet(0, create(ed.getEntityDescriptor(0), value));
		else
			throw new IllegalArgumentException("Expecting a data entity");

		return entity;
	}
	public <E extends IEntity> E create(EntityDescriptor<E> ed, Object... values) {
		IEntity[] args = new IEntity[values.length];
		for (int i=0; i<values.length; i++)
			if (ed.getEntityDescriptor(i).getEntityKind().isData())
				args[i] = create(ed.getEntityDescriptor(i), values[i]);
			else if (values[i] instanceof IEntity)
				args[i] = (IEntity) values[i];
			else
				throw new IllegalArgumentException();
		return create(ed, args);
	}
	public <E extends IEntity> E create(EntityDescriptor<E> ed, IEntity value) {
		return create(ed, new IEntity[] { value });
	}
	public <E extends IEntity> E create(EntityDescriptor<E> ed, IEntity... values) {
		E entity = values.length == ed.getEntityFeatureDescriptors().size() ? shallowClone(ed) : create(ed);
		if (ed.getEntityKind().isComposite()) {
			int length = values.length;
			if (!ed.getCompositeKind().isOrdered())
				length = 0; // unordered composites forward wSet by index to wAdd
			for (int i=entity.wSize()-1; i>=length; i--)
				entity.wRemove(i);
		}
		for (int i = 0; i < values.length; i++)
			entity.wSet(i, values[i]); //FIXME check return value on AbstractUListEntity when implemented
		return entity;
	}
	public <E extends IEntity> E create(EntityDescriptor<E> ed, IBindingManager bindings) {
		E result = create(ed);
		if (!EntityUtils.isSimple(result))
			throw new IllegalArgumentException("Expecting a simple entity");

		for (int i = 0; i < result.wSize(); i++) {
			IEntity value = bindings.wGet(ed.getEntityFeatureDescriptor(i).getName());
			if (value != null)
				result.wSet(i, value);
		}
		return result;
	}

	public <E extends IEntity> IEntityBuilder<E> build(EntityDescriptor<E> ed) {
		if (!EntityUtils.isSimple(ed))
			throw new IllegalArgumentException("Expecting a simple entity");

		return new EntityBuilder<E>(create(ed));
	}
}
