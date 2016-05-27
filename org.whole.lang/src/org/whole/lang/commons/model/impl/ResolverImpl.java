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
package org.whole.lang.commons.model.impl;

import java.util.Set;

import org.whole.lang.commons.model.AbstractEntityResolver;
import org.whole.lang.commons.model.Resolver;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.commons.visitors.ICommonsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi
 */
public class ResolverImpl extends AbstractEntityResolver implements Resolver {
	private static final long serialVersionUID = 1L;
	private EntityDescriptor<?> adapterEntityDescriptor;

	public EntityDescriptor<Resolver> wGetEntityDescriptor() {
		return CommonsEntityDescriptorEnum.Resolver;
	}

	public int wGetEntityOrd() {
		return CommonsEntityDescriptorEnum.Resolver_ord;
	}

	protected boolean hasAssignableSet() {
		return adapterEntityDescriptor != null;
	}
	protected Set<EntityDescriptor<?>> calculateAssignableSet() {
		return adapterEntityDescriptor.getLanguageConcreteSubtypes();
	}

	@Override
	public void wSetParent(IEntity parent) {
		super.wSetParent(parent);

		if (EntityUtils.isNull(parent))
			return;

		int index = parent.wIndexOf(this);
		if (index >= 0) {
			adapterEntityDescriptor = parent.wGetEntityDescriptor(index);
			
			//IEntity adapter = parent.wGet(index);
			//adapterEntityDescriptor = adapter.wGetEntityDescriptor();
			updateAssignableSet();
		} // else is derived
	}
	
	public void accept(ICommonsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}
}
