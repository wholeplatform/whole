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
package org.whole.lang.xsd.builders.utils;

import java.util.Stack;

import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class MappingContextStack extends Stack<MappingContext> {
	private static final long serialVersionUID = 1L;
	
	private final EntityDescriptor<?> rootType;

	public MappingContextStack() {
		this(CommonsEntityDescriptorEnum.RootFragment);
	}
	public MappingContextStack(EntityDescriptor<?> rootType) {
		this.rootType = rootType;
	}

	@Override
	public MappingContext push(MappingContext mappingContext) {
		if (!isEmpty())
			peek().updateLastChildIndex(mappingContext.fd);
		return super.push(mappingContext);
	}
	public boolean isStructural() {
		return !isEmpty() && peek().structural && !peek().mixed;
	}

	public boolean isMixedStructural() {
		return !isEmpty() && peek().structural && peek().mixed;
	}

	public boolean isFragment() {
		return !isEmpty() && EntityUtils.isFragment(peek().ed);
	}

	public EntityDescriptor<?> peekContextType() {
		return isEmpty() ? rootType :  peek().ed;
	}
}
