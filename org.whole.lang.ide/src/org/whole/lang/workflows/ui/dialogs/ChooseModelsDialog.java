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
package org.whole.lang.workflows.ui.dialogs;

import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createSameStageFragment;
import static org.whole.lang.commons.factories.CommonsEntityAdapterFactory.createStageUpFragment;
import static org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum.PathExpression;
import static org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum.Expression;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.e4.ui.E4CompatibilityPlugin;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.factories.QueriesEntityFactory;
import org.whole.lang.queries.model.Tuple;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.dialogs.OpenAsModelDialog;
import org.whole.lang.workflows.factories.WorkflowsEntityFactory;
import org.whole.lang.workflows.model.Assign;
import org.whole.lang.workflows.model.Assignments;
import org.whole.lang.workflows.model.Expression;
import org.whole.lang.workflows.model.Variable;

/**
 * @author Enrico Persiani
 */
public class ChooseModelsDialog extends OpenAsModelDialog {
	protected Assignments assignments;

	@Inject
	public ChooseModelsDialog(@Named(IServiceConstants.ACTIVE_SHELL) Shell shell,
			@Named("dialogTitle") String title,
			@Named("dialogMessage") String message,
			@Named("dialogAssignments") Assignments assignments) {
		super(shell, ReflectionFactory.getDefaultPersistenceKit(), title, message);
		setShellStyle(SWT.DIALOG_TRIM);
		setValidator(createPersistenceValidator());
		this.assignments = assignments;
	}

	protected ISelectionStatusValidator createPersistenceValidator() {
		return new ISelectionStatusValidator() {
			public IStatus validate(Object[] selection) {
				for (Object item : selection) {
					if (!(item instanceof IFile))
						return new Status(IStatus.ERROR, E4CompatibilityPlugin.PLUGIN_ID, IStatus.ERROR,
								"Only files allowed", null);
					try {
						getPersistenceKit().readModel(new IFilePersistenceProvider((IFile) item));
					} catch (Exception e) {
						return createWrongPersistenceStatus();
					}
				}
				return Status.OK_STATUS;
			}
		};
	}

	@Override
	public int open() {
		int status = super.open();
		if (status == Dialog.OK) {
			WorkflowsEntityFactory wef = WorkflowsEntityFactory.instance;

			Tuple tuple = QueriesEntityFactory.instance.createTuple(0);
			for (Object element : getResult())
				try {
					IEntity model = getPersistenceKit().readModel(new IFilePersistenceProvider((IFile) element));
					tuple.wAdd(createStageUpFragment(PathExpression, model));
				} catch (Exception e) {
				}

			Variable variable = wef.createVariable("selectedModels");
			Expression fragment = createSameStageFragment(Expression, tuple);
			Assign assign = wef.createAssign(variable, fragment);
			assignments.wAdd(assign);
		}
		return status;
	}
}
