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
package org.whole.lang.ui.viewers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.LightweightEditDomain;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.EntityPartListener;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IPartFocusListener;
import org.whole.lang.ui.input.IModelInput;
import org.whole.lang.ui.input.IModelInputListener;
import org.whole.lang.ui.keys.AbstractKeyHandler;

/**
 * @author Enrico Persiani
 */
public interface IEntityPartViewer extends EditPartViewer {
	public CommandStack getCommandStack();
	public boolean isDirty();

	public EntityEditDomain getEditDomain();
	public LightweightEditDomain linkEditDomain(IEntityPartViewer viewer);

	public IEntity getEntityContents();
	public void setEntityContents(IEntity entity);
	public void setContents(IModelInput modelInput, IEntity defaultContents);
	public void reloadContents();
	public boolean hasContents();

	public IEclipseContext getContext();
	public IBindingManager getContextBindings();

	public Map<IEntity, IEntityPart> getEditPartRegistry();
	public IEntityPart getFocusEntityPart();

	public void refreshNotation();
	public void refreshNotation(IEntity entity);
	public void rebuildNotation();
	public void rebuildNotation(IEntity entity);

	public void reveal(IEntity entity);
	public void select(IEntity entity);
	public void select(IEntity entity, boolean propagate);
	public void select(List<? extends IEntity> entity);
	public void select(List<? extends IEntity> entities, boolean propagate);
	public void selectAndReveal(IEntity entity);
	public void selectAndReveal(IEntity entity, boolean propagate);
	public void selectAndReveal(List<? extends IEntity> entity);
	public void selectAndReveal(List<? extends IEntity> entity, boolean propagate);
	public void setInteractive(IEntity entity, boolean edit, boolean browse, boolean inherited);

	public AbstractKeyHandler getKeyHandler();
	public void setKeyHandler(AbstractKeyHandler handler);

	public void addEntityPartListener(EntityPartListener listener);
	public void removeEntityPartListener(EntityPartListener listener);
	public void addPartFocusListener(IPartFocusListener listener);
	public void removePartFocusListener(IPartFocusListener listener);
	public void addModelInputListener(IModelInputListener listener);
	public void removeModelInputListener(IModelInputListener listener);

	public Set<String> getReferencedResources();
	public boolean isOperationExecutable();
	public void setOperationExecutable(boolean executable);
}
