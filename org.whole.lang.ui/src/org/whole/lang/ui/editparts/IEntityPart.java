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
package org.whole.lang.ui.editparts;


import java.beans.PropertyChangeListener;

import org.eclipse.gef.EditPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.IDecorationManager.DecorationKind;
import org.whole.lang.ui.viewers.IEntityPartViewer;

/**
 * @author Riccardo Solmi
 */
public interface IEntityPart extends EditPart, PropertyChangeListener {
	public <T extends IEntity> T getModelEntity();
	public IEntity getParentModelEntity();

	public void rebuild();
	public void rebuildChild(EditPart child);

	public boolean isReversable();
	public boolean isModelChildrenReversed();
	public boolean isReversed();
	public void setReversed(boolean value);
	public boolean isDetailed();
	public void setDetailed(boolean value);
	public void setDetailed(boolean value, IEntityPart childPart);

	public void addDecoration(DecorationKind kind, String tooltip);
	public void deleteDecorations(boolean deep);
	
	public IEntityPartViewer getViewer();
}
