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
package org.whole.lang.debug;

import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.whole.gen.util.IDEUtils;
import org.whole.gen.util.JDTUtils;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.ArtifactsGeneratorOperation;
import org.whole.lang.operations.IOperationProgressMonitor;
import org.whole.lang.operations.InterpreterOperation;
import org.whole.lang.operations.JavaCompilerOperation;
import org.whole.lang.operations.NormalizerOperation;
import org.whole.lang.operations.OperationProgressMonitorAdapter;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.operations.ValidatorOperation;
import org.whole.lang.operations.WorkspaceDecorationManager;


/**
 * @author Enrico Persiani
 */
public class OperationLauncherRegistry {
	public static final OperationLauncherRegistry instance = new OperationLauncherRegistry();
	private Map<String, IOperationLauncher> operationLauncherMap;

	protected OperationLauncherRegistry() {
		operationLauncherMap = new HashMap<String, IOperationLauncher>();
		operationLauncherMap.put(ValidatorOperation.ID, new AbstractOperationLauncher("Validate") {
			public void launch(IEntity model, IBindingManager bindings, InputStream is,	OutputStream os, IOperationProgressMonitor monitor) {
				IFile file = (IFile) bindings.wGetValue("file");
				IProgressMonitor progressMonitor = monitor.getAdapter(IProgressMonitor.class);
				WorkspaceDecorationManager decorationManager = new WorkspaceDecorationManager(file, progressMonitor);
				ValidatorOperation.validate(model, bindings, decorationManager);
			}
		});
		operationLauncherMap.put(NormalizerOperation.ID, new AbstractOperationLauncher("Normalize") {
			public void launch(IEntity model, IBindingManager bindings, InputStream is,	OutputStream os, IOperationProgressMonitor monitor) {
				NormalizerOperation.normalize(model, bindings);
				//TODO persist normalized model ?
			}
		});
		operationLauncherMap.put(PrettyPrinterOperation.ID, new AbstractOperationLauncher("Pretty Print") {
			public void launch(IEntity model, IBindingManager bindings, InputStream is,	OutputStream os, IOperationProgressMonitor monitor) {
				PrettyPrinterOperation.prettyPrint(model, os);
			}
		});
		operationLauncherMap.put(InterpreterOperation.ID, new AbstractOperationLauncher("Interpret") {
			public void launch(IEntity model, IBindingManager bindings, InputStream is,	OutputStream os, IOperationProgressMonitor monitor) {
				InterpreterOperation.interpret(model, bindings, is, os);
			}
		});
		operationLauncherMap.put(ArtifactsGeneratorOperation.ID, new AbstractOperationLauncher("Generate Artifacts") {
			public void launch(IEntity model, IBindingManager bindings, InputStream is,	OutputStream os, IOperationProgressMonitor monitor) {
				ArtifactsGeneratorOperation.generate(model, bindings);
			}
		});
		operationLauncherMap.put(JavaCompilerOperation.ID, new AbstractOperationLauncher("Generate Java Artifacts") {
			public void launch(final IEntity model, final IBindingManager bindings, InputStream is,	OutputStream os, IOperationProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
				if (model.wGetLanguageKit().hasVisitor(JavaCompilerOperation.ID)) {
					final IPackageFragmentRoot packageFragmentRoot;
					if (bindings.wIsSet("sourceLocationName")) {
						packageFragmentRoot = JDTUtils.getPackageFragmentRoot(
								bindings.wStringValue("sourceLocationName"));	
					} else
						packageFragmentRoot = IDEUtils.getPackageFragmentRoot(new Shell());

					WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
						protected void execute(IProgressMonitor progressMonitor) {
							progressMonitor.beginTask("Generating...", 100);
							final IOperationProgressMonitor operationProgressMonitor = new OperationProgressMonitorAdapter(progressMonitor);
							bindings.wDefValue("progressMonitor", operationProgressMonitor);

							operationProgressMonitor.beginTask("models", 10, IOperationProgressMonitor.TOTAL_WORK);
							final List<CompilationUnit> cuList = JavaCompilerOperation.compile(model, bindings);
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
					operation.run(monitor.getAdapter(IProgressMonitor.class));
				}
			}
		});
	}

	public IOperationLauncher getOperationLauncher(String operationId) {
		return operationLauncherMap.get(operationId);
	}

	public String getOperationLauncherDescription(String operationId) {
		return operationLauncherMap.get(operationId).getDescription();
	}

	public String[] getOperationIds() {
		List<String> operationIdList = new ArrayList<String>(operationLauncherMap.keySet());
		return operationIdList.toArray(new String[operationIdList.size()]);
	}
}
