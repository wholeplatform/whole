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
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 * @author Riccardo Solmi
 */
public interface IEntityFactory extends IEntityRegistryProvider {
	public <E extends IEntity> E shallowClone(EntityDescriptor<E> ed);
	public <E extends IEntity> E shallowClone(EntityDescriptor<E> ed, IEntity... values);
//	public <E extends IEntity> E resolverClone(EntityDescriptor<E> ed, int initialSize);
	public IEntity cloneFeature(EntityDescriptor<?> ed, int index);
	public IEntity cloneFeature(EntityDescriptor<?> ed, FeatureDescriptor fd);
	public boolean matchFeature(EntityDescriptor<?> ed, int index, IEntity value);
	public boolean matchFeature(EntityDescriptor<?> ed, FeatureDescriptor fd, IEntity value);

	public <E extends IEntity> E create(EntityDescriptor<E> ed);
	public <E extends IEntity> E create(EntityDescriptor<E> ed, IEntity value);
	public <E extends IEntity> E create(EntityDescriptor<E> ed, IEntity... values);
	public <E extends IEntity> E create(EntityDescriptor<E> ed, Object value);
	public <E extends IEntity> E create(EntityDescriptor<E> ed, Object... values);
	public <E extends IEntity> E create(EntityDescriptor<E> ed, IBindingManager bindings);

	public <E extends IEntity> IEntityBuilder<E> build(EntityDescriptor<E> ed);
//	public E EntityBuilder<E> buildE(); // for specific simple entities
}
