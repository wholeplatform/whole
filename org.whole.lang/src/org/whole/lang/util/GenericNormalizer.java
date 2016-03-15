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
package org.whole.lang.util;

import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.visitors.GenericTraversalFactory;
import org.whole.lang.visitors.IVisitor;

public class GenericNormalizer {

	public static void removeResolversFromComposites(final boolean removeEmptyComposites, IEntity entity) {
		IVisitor visitor = GenericTraversalFactory.instance.downUp(
				new GenericIdentityVisitor() {
					public void visit(IEntity entity) {
						beforeRemovingResolvers(entity);
					}
				},
				new GenericIdentityVisitor() {
					public void visit(IEntity entity) {
						if (removeEmptyComposites)
							afterRemovingResolvers(entity);
					}
				}, false
		);
		visitor.visit(entity);
	}

	protected static void beforeRemovingResolvers(IEntity entity) {
		if (EntityUtils.isComposite(entity)) {
			IEntityIterator<IEntity> i = IteratorFactory.childIterator();
			i.reset(entity);
			for (IEntity child : i)
				if (EntityUtils.isResolver(child))
					entity.wRemove(child);
		}
	}

	protected static void afterRemovingResolvers(IEntity entity) {
		if (EntityUtils.isComposite(entity) && entity.wIsEmpty())
			entity.wGetParent().wSet(entity, CommonsEntityAdapterFactory.createResolver(entity.wGetEntityDescriptor()));
	}
}
