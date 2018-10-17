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

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.executables.IExecutable;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.model.Workspace;

/**
 * @author Riccardo Solmi
 */
public class ReusablesUIDynamicCompilerVisitor extends ReusablesDynamicCompilerVisitor {
	@Override
	public void visit(Workspace entity) {
		entity.getPersistence().accept(this);
		IExecutable<?> persistenceIterator = getExecutableResult();
		
		entity.getContent().accept(this);
		IExecutable<IEntity> contentIterator = getExecutableResult();

		setExecutableResult(iteratorFactory().createCompose(
				iteratorFactory().createSingleValuedRunnable(new ResourcePersistenceRunnable() {
					protected IPersistenceProvider getPersistenceProvider(String path, IBindingManager bm) {
						return E4Utils.createWorkspaceProvider(bm, path);
					}
				}, new int[] { 0 }, persistenceIterator).withSourceEntity(entity), contentIterator));
	}
}
