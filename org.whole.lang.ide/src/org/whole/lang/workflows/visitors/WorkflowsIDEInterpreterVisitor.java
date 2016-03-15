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
package org.whole.lang.workflows.visitors;

import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.ClassPath_ord;
import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.CurrentJavaProject_ord;
import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.JavaProject_ord;

import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.whole.gen.util.JDTUtils;
import org.whole.lang.artifacts.util.WorkspaceResourceOperations;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.java.codebase.JavaSourceTemplateFactory;
import org.whole.lang.java.model.CompilationUnit;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.templates.ITemplateFactory;
import org.whole.lang.ui.actions.JavaModelGeneratorAction;
import org.whole.lang.ui.util.SuspensionKind;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.VisitException;
import org.whole.lang.workflows.model.Assignments;
import org.whole.lang.workflows.model.Breakpoint;
import org.whole.lang.workflows.model.ClassProvider;
import org.whole.lang.workflows.model.Condition;
import org.whole.lang.workflows.model.LoadJavaModel;
import org.whole.lang.workflows.model.ResourceKind;
import org.whole.lang.workflows.model.ResourceKindEnum;
import org.whole.lang.workflows.model.Task;
import org.whole.lang.workflows.model.Variable;
import org.whole.lang.workflows.model.Variables;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.ui.dialogs.AssignmentsDialogFactory;
import org.whole.lang.workflows.ui.dialogs.ConfirmationDialogFactory;
import org.whole.lang.workflows.ui.dialogs.ITaskDialogFactory;
import org.whole.lang.workflows.ui.dialogs.TaskDialogHelper;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class WorkflowsIDEInterpreterVisitor extends WorkflowsInterpreterVisitor {
	@Override
	public void visit(Task entity) {
		entity.getLabel().accept(this);
		String title = PrettyPrinterOperation.toPrettyPrintString(getResult());
		entity.getDescription().accept(this);
		String description = PrettyPrinterOperation.toPrettyPrintString(getResult());

		Assignments assignments = EntityUtils.clone(entity.getAssignments());

		Variable factoryVariable = entity.getFactory();
		ITaskDialogFactory factory;
		if (EntityUtils.isNotResolver(factoryVariable)) {
			factoryVariable.accept(this);
			factory = (ITaskDialogFactory) getResultValue();
		} else if (EntityUtils.isNotResolver(assignments)) {
			factory = AssignmentsDialogFactory.instance();
		} else
			factory = ConfirmationDialogFactory.instance();

		if (EntityUtils.isNotResolver(assignments)) {
			stagedVisit(assignments, 1);
			assignments = (Assignments) getResult();
		}

		if (!TaskDialogHelper.showTaskDialog(factory, title, description, assignments, getBindings()))
			throw new OperationCanceledException(new VisitException("task not completed: "+description));

		assignments.accept(this);
	}

	@Override
	public void visit(Breakpoint entity) {
		setResult(null);
		IBindingManager debugEnv = getBindings();

		if (entity.getDisabled().wBooleanValue() ||
				(debugEnv.wIsSet("debug#reportModeEnabled") && !debugEnv.wBooleanValue("debug#reportModeEnabled")) ||
				(debugEnv.wIsSet("debug#debugModeEnabled") && !debugEnv.wBooleanValue("debug#debugModeEnabled")) ||
				(debugEnv.wIsSet("debug#breakpointsEnabled") && !debugEnv.wBooleanValue("debug#breakpointsEnabled")))
			return;

		Condition condition = entity.getCondition();
		if (!EntityUtils.isResolver(condition)) {
			if (!BehaviorUtils.evaluatePredicate(condition, 0, debugEnv))
				return;
		}

		Set<String> includeNames = new TreeSet<String>();
		Variables variables = entity.getShowVariables();
		if (Matcher.matchImpl(WorkflowsEntityDescriptorEnum.Variables, variables)) {
			for (Variable variable : variables)
				includeNames.add(variable.getValue());
		}
		E4Utils.suspendOperation(SuspensionKind.BREAK, null, entity, debugEnv, includeNames);
	}

	@Override
	protected IPersistenceProvider getWorkspaceProvider(IBindingManager bm, String resourceString, boolean isInput) {
		return E4Utils.createWorkspaceProvider(bm, resourceString, isInput);
	}

	@Override
	protected IBindingManager createArtifactsBindings(String resource, ResourceKind resourceKind) {
		if (!ResourceKindEnum.WORKSPACE.equals(resourceKind.getValue()))
			return super.createArtifactsBindings(resource, resourceKind);

		try {
			IBindingManager bindings = BindingManagerFactory.instance.createBindingManager();
			IResource rootResource = ResourcesPlugin.getWorkspace().getRoot().findMember(resource);
			if (rootResource == null)
				throw new IllegalArgumentException("root resource does not exist");

			bindings.wDefValue("artifactsOperations", new WorkspaceResourceOperations());
			bindings.wDefValue("rootResource", rootResource);

			IContainer container = rootResource.getParent();
			if (container != null) {
				int type = container.getType();
				switch (type) {
				case IResource.PROJECT:
					bindings.wDefValue("project", container);
					break;
				case IResource.FOLDER:
					bindings.wDefValue("folder", container);
					break;
				default:
					break;
				}
			}
			return bindings;
		} catch (Exception e) {
			throw new IllegalArgumentException("Cannot find the specified resource", e);
		}
	}

	@Override
	protected ITemplateFactory<CompilationUnit> getJavaTemplateFactory(LoadJavaModel entity) {

		ClassProvider classProvider = entity.getClassProvider();
		EntityDescriptor<?> ed = classProvider.wGetEntityDescriptor();

		IJavaProject javaProject;
		switch (ed.getOrdinal()) {

		case ClassPath_ord:
			return super.getJavaTemplateFactory(entity);

		case CurrentJavaProject_ord:
			javaProject = (IJavaProject) getBindings().wGetValue("javaProject");
			break;
			
		case JavaProject_ord:
			javaProject = JDTUtils.getJavaProject(classProvider.wStringValue());
			break;

		default:
			throw new IllegalArgumentException("invalid ClassProvider");
		}

		entity.getClassName().accept(this);
		String className = getResultString();

		return new JavaSourceTemplateFactory(className, javaProject);
	}

	@Override
	protected void performJavaCompilerOperation(IEntity model) {
		try {
			IProgressMonitor progressMonitor = getOperation()
					.getProgressMonitor().getAdapter(IProgressMonitor.class);
			JavaModelGeneratorAction.generate(progressMonitor, model, getBindings());
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}
}
