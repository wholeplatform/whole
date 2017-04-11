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

import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.model.Workspace;

/**
 * @author Riccardo Solmi
 */
public class ReusablesUIInterpreterVisitor extends ReusablesInterpreterVisitor {
	@Override
	public void visit(Workspace entity) {
		IPersistenceKit persistenceKit = evaluatePersistence(entity.getPersistence());

		entity.getContent().accept(this);

		setResultIterator(IteratorFactory.composeIterator(
					IteratorFactory.singleValuedRunnableIterator((IEntity selfEntity, IBindingManager bm, IEntity... arguments) -> {
						if (!BindingManagerFactory.instance.isVoid(selfEntity)) {
							IPersistenceProvider pp = E4Utils.createWorkspaceProvider(bm, selfEntity.wStringValue());
	
							//TODO replace Object[] with IResource impl
							bm.setResult(BindingManagerFactory.instance.createValue(new Object[] {persistenceKit, pp}));
						}
					}).withSourceEntity(entity), getResultIterator()));
	}
}
