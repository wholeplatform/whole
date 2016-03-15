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
package org.whole.lang.commons.reflect;

import java.util.Set;

import org.whole.lang.commons.model.AbstractEntityResolver;
import org.whole.lang.commons.model.Resolver;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ResolverFacade extends AbstractEntityResolver implements Resolver {
	private static final long serialVersionUID = 1L;

	private EntityDescriptor<?> entityDescriptor;
	public EntityDescriptor<?> wGetEntityDescriptor() {
		return entityDescriptor != null ?
				entityDescriptor : CommonsEntityDescriptorEnum.Resolver;
	}
	public void wSetEntityDescriptor(EntityDescriptor<?> entityDescriptor) {
		this.entityDescriptor = entityDescriptor;
	}

	public void accept(ICommonsVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void wSetParent(IEntity parent) {
		super.wSetParent(parent);

		entityDescriptor = null;

		if (EntityUtils.isNull(parent))
			return;

		int index = parent.wIndexOf(this);
		if (index >= 0) {
			entityDescriptor = new ResolverEntityDescriptor(
					parent.wGetEntityDescriptor(index), this);
			updateAssignableSet();
		}
	}

	@Override
	public Set<EntityDescriptor<?>> getAssignableSet() {
		// TODO Auto-generated method stub
		return super.getAssignableSet();
	}

	@Override
	protected Set<EntityDescriptor<?>> calculateAssignableSet() {
		// TODO Auto-generated method stub
		return super.calculateAssignableSet();
	}
}
