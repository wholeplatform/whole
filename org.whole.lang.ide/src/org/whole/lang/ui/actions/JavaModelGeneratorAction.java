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
package org.whole.lang.ui.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.whole.gen.util.IDEUtils;
import org.whole.gen.util.JDTUtils;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.JavaCompilerOperation;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.operations.OperationProgressMonitorAdapter;

public class JavaModelGeneratorAction {

	public static void generate(IProgressMonitor monitor, final IEntity program,
			final IBindingManager params) throws InvocationTargetException,
			InterruptedException {
		final IPackageFragmentRoot packageFragmentRoot;
		if (params.wIsSet("sourceLocationName"))
			//TODO ? create if doesn't exists
			packageFragmentRoot = JDTUtils.getPackageFragmentRoot(params.wStringValue("sourceLocationName"));	
		else
			packageFragmentRoot = IDEUtils.getPackageFragmentRoot(new Shell());

		WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
			protected void execute(IProgressMonitor progressMonitor) {
				progressMonitor.beginTask("Generating...", 100);
				final IOperationProgressMonitor operationProgressMonitor = new OperationProgressMonitorAdapter(progressMonitor);
				params.wDefValue("progressMonitor", operationProgressMonitor);

				operationProgressMonitor.beginTask("models", 10, IOperationProgressMonitor.TOTAL_WORK);
				final List<CompilationUnit> cuList = JavaCompilerOperation.compile(program, params);
				operationProgressMonitor.endTask();

				operationProgressMonitor.beginTask("classes", 90, cuList.size());					
				if (packageFragmentRoot != null && !cuList.isEmpty()) {
					Iterator<CompilationUnit> i = new ArrayList<CompilationUnit>(cuList).iterator();
					while (i.hasNext()) {
						try {
							CompilationUnit cu = i.next();
							operationProgressMonitor.beginTask(IDEUtils.getTypeName(cu), 1);
							IDEUtils.save(cu, packageFragmentRoot, null);
							operationProgressMonitor.endTask();
						} catch (JavaModelException e) {
							throw new RuntimeException(e);
						}
						if (operationProgressMonitor.isCanceled())
							throw new OperationCanceledException();
					}
				}
				operationProgressMonitor.endTask();
			}
		};
		operation.run(monitor);
	}
}
