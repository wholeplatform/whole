/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.ui.dialogs;

import org.eclipse.swt.widgets.Shell;

/**
 * @author Enrico Persiani
 */
public interface IImportAsModelDialogFactory {
	public IImportAsModelDialog createImportAsModelDialog(Shell shell, String title);
	public IImportAsModelDialog createImportAsModelDialog(Shell shell, String title, boolean enableForceAdding);
	public IImportAsModelDialog createElementListImportAsModelDialog(Shell shell, String title);
	public IImportAsModelDialog createElementListImportAsModelDialog(Shell shell, String title, boolean enableForceAdding);
	public IImportAsModelDialog createImplicitElementImportAsModelDialog(Shell shell, String title);
	public IImportAsModelDialog createImplicitElementImportAsModelDialog(Shell shell, String title, boolean enableForceAdding);
}
