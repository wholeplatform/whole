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
package org.whole.langs.core.op;

import org.whole.lang.operations.DynamicCompilerOperation;
import org.whole.lang.operations.IOperation;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.reflect.AbstractDeployer;
import org.whole.lang.reflect.IDeployer;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.IVisitorFactory;
import org.whole.lang.workflows.reflect.WorkflowsLanguageKit;
import org.whole.lang.workflows.visitors.WorkflowsDynamicCompilerVisitor;
import org.whole.lang.workflows.visitors.WorkflowsInterpreterVisitor;

/**
 * @author Enrico Persiani
 */
public class WorkflowsInterpreterDeployer extends AbstractDeployer {
	public int getDeployLevel() {
		return IDeployer.LEVEL_LANGUAGE_EXTENSION-2;
		//FIXME workaround for XSDRegistry.initialize() dependency in LegacyOperationsDeployer and PersistenceLibraryDeployer
	}

	public void deploy(ReflectionFactory platform) {
		platform.addOperationFactory(WorkflowsLanguageKit.URI, InterpreterOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new WorkflowsInterpreterVisitor();
				else
					return null;
			}
		});
		platform.addOperationFactory(WorkflowsLanguageKit.URI, DynamicCompilerOperation.ID,
				new IVisitorFactory() {
			public IVisitor create(IOperation operation, int stage) {
				if (stage == 0)
					return new WorkflowsDynamicCompilerVisitor();
				else
					return null;
			}
		});
	}
}
