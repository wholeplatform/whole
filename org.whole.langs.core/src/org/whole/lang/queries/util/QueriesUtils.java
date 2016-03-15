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
package org.whole.lang.queries.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.comparators.BusinessIdentityComparator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.Path;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.DataTypeUtils;
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

	public static IEntity sort(IEntity entity) {
		if (entity.wGetEntityDescriptor().getCompositeKind().isOrdered()) {
			List<IEntity> entityList = (List<IEntity>) entity;
			IEntity[] array = entityList.toArray(new IEntity[entity.wSize()]);
			entityList.clear();
			Arrays.sort(array, new Comparator<IEntity>() {
				public int compare(IEntity e1, IEntity e2) {
					IEntity e1Adaptee = e1.wGetAdaptee(false);
					IEntity e2Adaptee = e2.wGetAdaptee(false);
					EntityDescriptor<?> e1Ed = e1Adaptee.wGetEntityDescriptor();
					EntityDescriptor<?> e2Ed = e2Adaptee.wGetEntityDescriptor();
					if (e1Ed != e2Ed)
						return 0;
					switch (e1Ed.getEntityKind()) {
					case DATA:
						return DataTypeUtils.compare(e1Adaptee, e2Adaptee);
					default:
					case COMPOSITE:
						return 0;
					case SIMPLE:
						boolean idBased = false;
						List<FeatureDescriptor> entityFeatureDescriptors = e1Ed.getEntityFeatureDescriptors();
						for (FeatureDescriptor fd : entityFeatureDescriptors) {
							if (fd.isId()) {
								idBased = true;
								int result = compare(e1Adaptee.wGet(fd), e2Adaptee.wGet(fd));
								if (result != 0)
									return result;
							}
						}
						if (idBased)
							return 0;
						for (FeatureDescriptor fd : entityFeatureDescriptors) {
							int result = compare(e1Adaptee.wGet(fd), e2Adaptee.wGet(fd));
							if (result != 0)
								return result;
						}
						return 0;
					}
				}
			});
			for (IEntity child : array)
				entity.wAdd(child);
			return entity;
		} else
			return entity;
		
	}
}
