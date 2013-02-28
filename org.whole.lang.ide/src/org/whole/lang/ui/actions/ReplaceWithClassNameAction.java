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

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.internal.ui.dialogs.OpenTypeSelectionDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.whole.gen.util.IDEUtils;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.util.IEntityTransformer;
import org.whole.lang.util.StringUtils;

/**
 * @author Enrico Persiani
 */
public class ReplaceWithClassNameAction extends ReplaceChildAction 
		implements IEntityTransformer {
	
	private static final ImageDescriptor SELECT_CLASS_ICON = WholeUIPlugin.getImageDescriptor("icons/actions/select_class.png");

	private String className;

	public ReplaceWithClassNameAction(EntityDescriptor<?> type,
			String className, String text) {
		super(UIUtils.getActiveEditor(), 
			EnablerPredicateFactory.instance.alwaysTrue(), type, text, null);
		setImageDescriptor(SELECT_CLASS_ICON);
		this.transformer = this;
		this.className = className;
	}

	@Override
	protected boolean calculateEnabled() {
		if (!(getWorkbenchPart() instanceof IEditorPart))
			return false;

		IJavaProject javaProject = IDEUtils.getJavaProject((IEditorPart) 
				getWorkbenchPart());
		if (javaProject == null)
			return false;

		return true;
	}

	@Override
	public void run() {
		Shell shell = getWorkbenchPart().getSite().getShell();

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

		super.run();
	}

	public void transform(IEntity oldEntity, IEntity newEntity) {
		newEntity.wSetValue(className);
	}
}
