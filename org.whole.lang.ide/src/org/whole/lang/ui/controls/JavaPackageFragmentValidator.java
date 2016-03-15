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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

/**
 * @author Enrico Persiani
 */
public class JavaPackageFragmentValidator implements ISelectionStatusValidator {
	public IStatus validate(Object[] selection) {
		if(selection.length == 1 && selection[0] instanceof IPackageFragment)
			return new Status(IStatus.OK, PlatformUI.PLUGIN_ID,
	                IStatus.OK, ((IPackageFragment)selection[0]).getElementName(), null);
		else
			return new Status(IStatus.ERROR, PlatformUI.PLUGIN_ID,
	                IStatus.ERROR, "You must select a package fragment", null);
	}
}