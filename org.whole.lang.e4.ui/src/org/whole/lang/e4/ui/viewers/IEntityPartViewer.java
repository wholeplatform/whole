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
package org.whole.lang.e4.ui.viewers;

import java.util.Map;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.e4.ui.actions.E4KeyHandler;
import org.whole.lang.e4.ui.api.IModelInput;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.EntityPartListener;
import org.whole.lang.ui.editparts.IEntityPart;

/**
 * @author Enrico Persiani
 */
public interface IEntityPartViewer extends EditPartViewer {
	public CommandStack getCommandStack();
	public boolean isDirty();

	public IEntity getEntityContents();
	public void setEntityContents(IEntity entity);
	public void setContents(IModelInput modelInput, IEntity defaultContents);

	public Map<IEntity, IEntityPart> getEditPartRegistry();
	public IEntityPart getFocusEntityPart();

	public void selectAndReveal(IEntity entity);
	
	public E4KeyHandler getKeyHandler();
	public void setKeyHandler(E4KeyHandler handler);

	public void addEntityPartListener(EntityPartListener listener);
	public void removeEntityPartListener(EntityPartListener listener);
	public void addPartFocusListener(IPartFocusListener listener);
	public void removePartFocusListener(IPartFocusListener listener);
	public void addModelInputListener(IModelInputListener listener);
	public void removeModelInputListener(IModelInputListener listener);
}
