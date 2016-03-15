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
package org.whole.lang.rdb.codebase;

import static org.whole.lang.operations.PrettyPrinterOperation.toPrettyPrintString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.matchers.GenericMatcher;
import org.whole.lang.matchers.MatchException;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.ITraversalFilter;
import org.whole.lang.visitors.TraverseAllFilter;
import org.whole.lang.visitors.VisitException;

/**
 * @author Enrico Persiani
 */
public class OrderedMatcher extends GenericMatcher {
	protected Map<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap;

	public OrderedMatcher() {
		this(Collections.<EntityDescriptor<?>, Comparator<IEntity>>emptyMap());
	}

	public OrderedMatcher(Map<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap) {
		this(comparatorsMap, BindingManagerFactory.instance.createBindingManager());
	}

	public OrderedMatcher(Map<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap, IBindingManager bindings) {
		this(comparatorsMap, bindings, TraverseAllFilter.instance);
	}

	public OrderedMatcher(Map<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap, IBindingManager bindings, ITraversalFilter traversalFilter) {
		super(bindings, traversalFilter);
		this.comparatorsMap = new HashMap<EntityDescriptor<?>, Comparator<IEntity>>();
		this.comparatorsMap.putAll(comparatorsMap);
	}

	public void addComparator(EntityDescriptor<?> compositeED, Comparator<IEntity> comparator) {
		comparatorsMap.put(compositeED, comparator);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void matchCompositeEntity(IEntity pattern, IEntity model) {
		Comparator<IEntity> comparator = comparatorsMap.get(pattern.wGetEntityDescriptor());
		if (comparator != null) {
			if ((!pattern.wGetEntityDescriptor().equals(model.wGetEntityDescriptor())
					&& !EntityUtils.isResolver(model) //TODO workaround for resolvers
					) || (pattern.wSize() != model.wSize() && !(pattern.wIsEmpty() && model.wIsEmpty())) )
				throw new MatchException(pattern, model, bindings);
	
			List<IEntity> patternList = new ArrayList<IEntity>(pattern.wFeatures());
			Collections.sort(patternList, comparator);

			List<IEntity> modelList = new ArrayList<IEntity>(model.wFeatures());
			Collections.sort(modelList, comparator);

			for (int i=0; i<pattern.wSize(); i++) {
				IEntity patternChild = patternList.get(i);
				IEntity modelChild = modelList.get(i);
				if (traversalFilter.include(model, model.wIndexOf(modelChild)))
					patternChild.wAccept(this, modelChild);
			}
		} else
			super.matchCompositeEntity(pattern, model);
	}

	public static class SimpleFeatureComparator implements Comparator<IEntity> {
		private FeatureDescriptor fd;
		public SimpleFeatureComparator(FeatureDescriptor fd) {
			this.fd = fd;
		}
		public int compare(IEntity e1, IEntity e2) {
			IEntity child1 = e1.wGet(fd);
			IEntity child2 = e2.wGet(fd);
			String s1 = EntityUtils.isData(child1) ? DataTypeUtils.getAsPersistenceString(child1) : toPrettyPrintString(child1);
			String s2 = EntityUtils.isData(child2) ? DataTypeUtils.getAsPersistenceString(child2) : toPrettyPrintString(child2);
			return s1.compareTo(s2);
		}
	}

	public static boolean match(IEntity pattern, IEntity model, Map<EntityDescriptor<?>, Comparator<IEntity>> comparatorsMap) {
		try {
			pattern.wAccept(new OrderedMatcher(comparatorsMap), model);
			return true;
		} catch (MatchException e) {
			return false;
		} catch (VisitException e) {
			return false;
		}
	}
}
