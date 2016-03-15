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
package org.whole.lang.xsd.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;

/**
 * @author Enrico Persiani
 */
public class MappingStack {
	private Stack<MappingElement> stack;

	private MappingStack() {
	}
	public MappingStack(String context, boolean isComposite) {
		stack = new Stack<MappingElement>();
		stack.push(new MappingElement(context, isComposite));
	}

	public MappingStack cloneAndPush(String context, boolean isComposite) {
		MappingStack mappingStack = clone();
		mappingStack.stack.push(new MappingElement(context, isComposite));
		return mappingStack;
	}
	
	public String peekContext() {
		return stack.peek().getContext();
	}
	public boolean peekCompositeState() {
		return stack.peek().isComposite();
	}

	public IEntityIterator<?> tailIterator() {
		Iterator<MappingElement> iterator = stack.iterator();
		iterator.next();

		if (!iterator.hasNext())
			return IteratorFactory.emptyIterator();
		
		List<IEntity> contexts = new ArrayList<IEntity>();
		while (iterator.hasNext())
			contexts.add(BindingManagerFactory.instance.createValue(iterator.next()));
		return IteratorFactory.entityCollectionIterator(contexts);
	}

	@SuppressWarnings("unchecked")
	protected MappingStack clone()  {
		MappingStack mappingStack = new MappingStack();
		mappingStack.stack = (Stack<MappingElement>) stack.clone();
		return mappingStack;
	}

	public static class MappingElement {
		private final String context;
		private final boolean composite;

		private MappingElement(String context, boolean composite) {
			this.context = context;
			this.composite = composite;
		}

		public String getContext() {
			return context;
		}
		public boolean isComposite() {
			return composite;
		}
	}
}
