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
package org.whole.lang.ui.controls;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaElementComparator;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jdt.ui.StandardJavaElementContentProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.SelectionDialog;

/**
 * @author Enrico Persiani
 */
public class ClassBrowseChooser extends AbstractBrowseChooser {
	protected IPackageFragment lastSelectedFragment;

	public ClassBrowseChooser(Composite parent, int style, int buttonWidthHint) {
		super(parent, style, "Package:", buttonWidthHint);
	}

	protected Dialog createDialog() {
		StandardJavaElementContentProvider provider = new StandardJavaElementContentProvider();
		ILabelProvider labelProvider= new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT); 
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), labelProvider, provider);
		dialog.setTitle("Package selection"); 
		dialog.setMessage("Choose a package fragment"); 
		dialog.setComparator(new JavaElementComparator());
		dialog.addFilter(new JavaPackageFragmentFilter());
		dialog.setValidator(new JavaPackageFragmentValidator());
		dialog.setInput(JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()));
		dialog.setHelpAvailable(false);
		return dialog;
	}

	public IPackageFragment getSelectedFragment() {
		return (IPackageFragment) selectedElements[0];
	}

	@Override
	protected String resultToString(Object[] selectedElements) {
		return getSelectedFragment().getElementName();
	}

	@Override
	protected Object[] getResult(Dialog dialog) {
		return ((SelectionDialog) dialog).getResult();
	}
}
