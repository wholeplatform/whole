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
package org.whole.lang.ui.views;

import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.bindings.ITransactionScope;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.commons.reflect.CommonsEntityDescriptorEnum;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.iterators.ConstantIterator;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.misc.factories.MiscEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.OperationCanceledException;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.BindingUtils;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.MissingVariableException;
import org.whole.lang.workflows.factories.WorkflowsEntityFactory;
import org.whole.lang.workflows.model.Variable;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;

/**
 * @author Riccardo Solmi
 */
public class SampleViewer extends AbstractDerivedGraphicalViewer {
	public SampleViewer(Composite parent, WholeEditDomain editDomain, AbstractDerivedGraphicalView view) {
		super(parent, editDomain, view);
	}

	public static class GetContextInfoRunnable extends GetContentsRunnable {
		public IEntity selfModel;

		public GetContextInfoRunnable() {
			super(ContextView.class.getName());
		}

		public void run() {
			super.run();
			selfModel = ((ContextView) view).getSelfModel();

			VariablesView variablesView = (VariablesView) WholeUIPlugin.revealView(VariablesView.class.getName());
			variablesView.setContents(null);
		}
	}

	protected IEntity deriveModel(IEntity model, IEntity firstSelectedEntity, WholeEditDomain editDomain, IStructuredSelection structuredSelection, IProgressMonitor monitor) {
		GetContextInfoRunnable runnable = new GetContextInfoRunnable();
		PlatformUI.getWorkbench().getDisplay().syncExec(runnable);
		IEntity contextModel = runnable.contextModel;
		IEntity selfEntity = runnable.selfModel;
		if (selfEntity == null)
			return null;
		selfEntity = EntityUtils.mapEntity(selfEntity, EntityUtils.clone(EntityUtils.getCompoundRoot(selfEntity)));

		IBindingManager bm = defineBindings(selfEntity, editDomain, structuredSelection, monitor);
		bm.wDefValue("breakpointsDisabled", true);
		Set<String> initialNames = bm.wNames();

		if (contextModel != null)
			BehaviorUtils.evaluate(contextModel, 0, bm);

		IEntity viewEnabled = BehaviorUtils.apply(
				"whole:org.whole.lang.ui.views:SamplePerspectiveSemantics#supportsSampleView",
				firstSelectedEntity, bm);
		if (!viewEnabled.wBooleanValue())
			return null;

		IEntity behaviorModel = EntityUtils.mapEntity(firstSelectedEntity, EntityUtils.clone(model));
		
		IEntity behaviorLabel = BehaviorUtils.apply(
				"whole:org.whole.lang.ui.views:SamplePerspectiveSemantics#SampleViewBehaviorLabel",
				behaviorModel, bm);
		monitor.setTaskName(behaviorLabel.wStringValue());

		behaviorModel = BehaviorUtils.apply(
				"whole:org.whole.lang.ui.views:SamplePerspectiveSemantics#SampleViewBehavior",
				behaviorModel, bm);

		IEntity derivedModel = null;
		try {
			if (bm.wGet("self") != selfEntity)
				bm.wDef("self", selfEntity);
			IEntityIterator<?> iterator = BehaviorUtils.lazyEvaluate(behaviorModel, 0, bm);
			if (bm.wGet("self") != selfEntity)
				bm.wDef("self", selfEntity);
			iterator.reset(selfEntity);

			if (iterator.getClass().equals(ConstantIterator.class)) {
				IEntity result = iterator.next();
				if (result == null || !EntityUtils.isData(result))
					return result;

				Object resultValue = result.wGetValue();
				derivedModel = IVisitor.class.isInstance(resultValue) ?
						BindingManagerFactory.instance.createValue(Matcher.match((IVisitor) resultValue, selfEntity)) : result;
			} else if (iterator.hasNext()) {
				derivedModel = MiscEntityFactory.instance.createMisc(0);
	
				ITransactionScope resettableScope = BindingManagerFactory.instance.createTransactionScope();
				bm.wEnterScope(resettableScope);
				try {
					for (IEntity result : iterator) {
						resettableScope.commit();
						derivedModel.wAdd(GenericEntityFactory.instance.create(
								CommonsEntityDescriptorEnum.SameStageFragment,
								//CommonsEntityFactory.instance.createSameStageFragment(
								EntityUtils.clone(result)));//TODO substitute with a no containment fragment
					}
				} finally {
					resettableScope.rollback();
					bm.wExitScope();
				}
			}
		} catch (MissingVariableException e) {
			addMissingVariables(contextModel, e);
		} catch (OperationCanceledException e) {
			throw e;
		} catch (Exception e) {
			if (e.getCause() instanceof MissingVariableException)
				addMissingVariables(contextModel, (MissingVariableException) e);
		}

		IEntity variablesModel = null;
		if (derivedModel != null) {
			WorkflowsEntityFactory ef = WorkflowsEntityFactory.instance;
			variablesModel = ef.createAssignments(0);
			for (String name : new TreeSet<String>(bm.wLocalNames()))
				if (!initialNames.contains(name))
					variablesModel.wAdd(ef.createAssign(
							ef.createVariable(name),
							EntityUtils.cloneIfParented(BindingUtils.wGet(bm, name)).wGetAdapter(WorkflowsEntityDescriptorEnum.Expression)));
		}
		
		final IEntity contents = variablesModel;
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				VariablesView variablesView = (VariablesView) WholeUIPlugin.revealView(VariablesView.class.getName());
				variablesView.setContents(contents);
			}
		});

		return derivedModel;
	}

	protected void addMissingVariables(IEntity contextModel, MissingVariableException e) {
		String[] varNames = e.getVariableNames();
		WorkflowsEntityFactory ef = WorkflowsEntityFactory.instance;

		for (String varName : varNames) {
			Variable var = ef.createVariable(varName);
			IEntity find = Matcher.find(var, contextModel, false);
			if (find == null)
				contextModel.wAdd(ef.createAssign(
						var, CommonsEntityAdapterFactory.createResolver(WorkflowsEntityDescriptorEnum.Expression)));
		}
	}
}
