/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.queries.util;

import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.Path;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class QueriesUtils {
	public static Path createRootPath(IEntity entity) {
		QueriesEntityFactory qef = QueriesEntityFactory.instance;
		Path path = qef.createPath(0);
		IEntity parent = null;
		IEntityIterator<IEntity> iterator = IteratorFactory.ancestorOrSelfReverseIterator();
		iterator.reset(entity);
		
		if (CommonsEntityDescriptorEnum.RootFragment.equals(iterator.lookahead().wGetEntityDescriptor()))
			iterator.next();
		for (IEntity child : iterator) {
			if (parent != null)
				path.wAdd(EntityUtils.isSimple(parent) ?
						qef.createFeatureStep(CommonsDataTypePersistenceParser.unparseFeatureDescriptor(parent.wGetFeatureDescriptor(child))) :
							qef.createFilter(qef.createChildStep(), qef.createIndexTest(
									qef.createIntLiteral(parent.wIndexOf(child)))));
			parent = child;
		}
		return path;
	}
}
