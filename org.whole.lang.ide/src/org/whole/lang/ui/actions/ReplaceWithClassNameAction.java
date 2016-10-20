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

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.internal.ui.dialogs.OpenTypeSelectionDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.AbstractE4Action;
import org.whole.lang.e4.ui.handler.HandlersBehavior;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class ReplaceWithClassNameAction extends AbstractE4Action {
	
	private static final ImageDescriptor SELECT_CLASS_ICON = UIUtils.getImageDescriptor("icons/actions/select_class.png");

	protected EntityDescriptor<?> ed;
	protected String className;

	public ReplaceWithClassNameAction(IEclipseContext context, EntityDescriptor<?> ed, String className, String text) {
		super(context, text, SELECT_CLASS_ICON);
		this.ed = ed;
		this.className = className;
		setText(text);
	}

	@Override
	public void update() {
		ESelectionService selectionService = getContext().get(ESelectionService.class);
		if (selectionService.getSelection() instanceof IBindingManager) {
			IBindingManager bm = (IBindingManager) selectionService.getSelection();
			IJavaProject javaProject = (IJavaProject) bm.wGetValue("javaProject");
			setEnabled(javaProject != null && 
					HandlersBehavior.isValidFocusEntityPart(bm));
		} else
			setEnabled(false);
	}

	@Override
	public void run() {
		Shell shell = (Shell) getContext().get(IServiceConstants.ACTIVE_SHELL);

		FilteredItemsSelectionDialog dialog = new OpenTypeSelectionDialog(shell,
				true, PlatformUI.getWorkbench().getProgressService(), null,
				IJavaSearchConstants.TYPE);
		dialog.setTitle("Select a class"); 
		dialog.setMessage("Choose a class or a compilation unit"); 
		dialog.setInitialPattern(StringUtils.toSimpleName(className));
		if (dialog.open() != IDialogConstants.OK_ID)
			return;

		IType primaryType = (IType) dialog.getResult()[0];
		if (primaryType == null)
			return;

		className = primaryType.getFullyQualifiedName();

		ESelectionService selectionService = getContext().get(ESelectionService.class);
		IBindingManager bm = (IBindingManager) selectionService.getSelection();
		IEntity focusEntity = bm.wGet("focusEntity");
		IEntity replacement = GenericEntityFactory.instance.create(ed, className);

		ModelTransactionCommand mtc = new ModelTransactionCommand(focusEntity);
		try {
			mtc.setLabel("replace with class name");
			mtc.begin();
			focusEntity.wGetParent().wSet(focusEntity, replacement);
			mtc.commit();
			if (mtc.canUndo()) {
				IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
				CommandStack commandStack = viewer.getEditDomain().getCommandStack();
				commandStack.execute(mtc);
			}
		} catch (RuntimeException e) {
			mtc.rollbackIfNeeded();
			throw e;
		}
	}

	public void transform(IEntity oldEntity, IEntity newEntity) {
		newEntity.wSetValue(className);
	}
}
