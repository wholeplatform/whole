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
package org.whole.lang.reusables.visitors;

import java.io.FileNotFoundException;

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.model.Resource;
import org.whole.lang.reusables.reflect.ReusablesEntityDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractReusablesSemanticsVisitor extends ReusablesIdentityDefaultVisitor {
	protected IEntityIterator<?> readResource(Resource resource) {
		resource.accept(this);
		return Matcher.match(ReusablesEntityDescriptorEnum.Model, resource) ?
						IteratorFactory.constantComposeIterator(resource.wGetParent(), getResultIterator()) :
							IteratorFactory.composeIterator(
									IteratorFactory.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
										if (!BindingManagerFactory.instance.isVoid(selfEntity))
											bm.setResult(readModel(selfEntity));
									}).withSourceEntity(resource), getResultIterator());
	}

	public static IEntity readModel(IEntity resource) {
		Object[] pkpp = (Object[]) resource.wGetValue();
		IPersistenceKit pk = (IPersistenceKit) pkpp[0];
		IPersistenceProvider pp = (IPersistenceProvider) pkpp[1];

		try {
			return pk.readModel(pp);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(
					"Resource not found with the " + pk.getId() + " persistence at " + e.getMessage(), e);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Failed to load the resource with the given persistence: " + pk.getId(), e);
		}
	}

	protected IEntityIterator<?> saveResource(Resource resource) {
		//TODO add multiple save
		//FIXME path expression save

		resource.accept(this);
		return
//		return Matcher.isAssignableAsIsFrom(
//				QueriesEntityDescriptorEnum.Expression, resource.wGetAdaptee(false)) ?
//						IteratorFactory.constantComposeIterator(resource.wGetParent(), getResultIterator()) :
//							IteratorFactory.composeIterator(
									IteratorFactory.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
										if (!BindingManagerFactory.instance.isVoid(selfEntity)) {
											writeModel(selfEntity, arguments[0]);
											bm.setResult(selfEntity);
										}
									}, getResultIterator()).withSourceEntity(resource);
//									);
	}

	public static void writeModel(IEntity model, IEntity resource) {
		Object[] pkpp = (Object[]) resource.wGetValue();
		IPersistenceKit pk = (IPersistenceKit) pkpp[0];
		IPersistenceProvider pp = (IPersistenceProvider) pkpp[1];

		try {
			pk.writeModel(model, pp);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Failed to write the resource with the given persistence: " + pp + ", " + pk.getId(), e);
		}
	}
}
