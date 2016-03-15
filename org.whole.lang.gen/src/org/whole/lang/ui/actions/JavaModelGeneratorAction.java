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
package org.whole.lang.ui.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.whole.gen.util.JDTUtils;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.JavaCompilerOperation;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.operations.OperationProgressMonitorAdapter;

public class JavaModelGeneratorAction {

	public static void generate(IProgressMonitor monitor, final IEntity program,
			IBindingManager bm) throws InterruptedException, CoreException {
		
		IPackageFragmentRoot packageFragmentRoot = JDTUtils.getPackageFragmentRoot(bm.wStringValue("sourceLocationName"));	

		IEclipseContext context = (IEclipseContext) bm.wGetValue("eclipseContext");
		IWorkspace workspace = context.get(IWorkspace.class);
		IWorkspaceRunnable operation = new IWorkspaceRunnable() {
			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				monitor.beginTask("Generating...", 100);
				final IOperationProgressMonitor operationProgressMonitor = new OperationProgressMonitorAdapter(monitor);
				bm.wDefValue("progressMonitor", operationProgressMonitor);

				operationProgressMonitor.beginTask("models", 10, IOperationProgressMonitor.TOTAL_WORK);
				final List<CompilationUnit> cuList = JavaCompilerOperation.compile(program, bm);
				operationProgressMonitor.endTask();
				
				operationProgressMonitor.beginTask("classes", 90, cuList.size());					
				if (packageFragmentRoot != null && !cuList.isEmpty()) {
					Iterator<CompilationUnit> i = new ArrayList<CompilationUnit>(cuList).iterator();
					while (i.hasNext()) {
						try {
							CompilationUnit cu = i.next();
							operationProgressMonitor.beginTask(JDTUtils.getTypeName(cu), 1);
							JDTUtils.save(cu, packageFragmentRoot, null);
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
		workspace.run(operation, workspace.getRoot(), IResource.NONE, monitor);
	}
}
