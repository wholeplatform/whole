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
package org.whole.lang.ui.dialogs;

import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Enrico Persiani
 */
public interface IImportAsModelDialog {
	public IImportAsModelDialogFactory getFactory();

	public Object[] getSelection();
	public void setSelection(Object[] selection);
	
	public IPersistenceKit getPersistenceKit();
	public void setPersistenceKit(IPersistenceKit persistenceKit);

	public EntityDescriptor<?> getStage();
	public void setStage(EntityDescriptor<?> stage);

	public boolean isEnableForceAdding();
	public void setEnableForceAdding(boolean enableForceAdding);

	public boolean isForceAdding();
	public void setForceAdding(boolean adding);

	public String getTitle();
	public void setTitle(String title);

	public String getMessage();
	public void setMessage(String message);

	public boolean show();
	public boolean isConfirmed();
	public boolean validate();
}
