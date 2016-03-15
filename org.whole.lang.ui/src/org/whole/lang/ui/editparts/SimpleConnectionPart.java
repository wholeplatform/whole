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

import java.beans.PropertyChangeEvent;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.swt.widgets.Display;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.operations.IDecorationManager.DecorationKind;
import org.whole.lang.ui.editor.IGEFEditorKit;
import org.whole.lang.ui.editpolicies.WholeConnectionEditPolicy;
import org.whole.lang.ui.requests.ICommandFactory;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class SimpleConnectionPart extends AbstractConnectionEditPart implements IConnectionEntityPart {

	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ConnectionEndpointEditPolicy());
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new WholeConnectionEditPolicy(getCommandFactory()));
	}

	@SuppressWarnings("unchecked")
	public IEntity getModelEntity() {
		return (IEntity) getModel();
	}

	public IEntity getParentModelEntity() {
		IEntity parentEntity = getModelEntity().wGetParent();

		if (!EntityUtils.isNull(parentEntity))
			return parentEntity;
		
		Object parent = getParent().getModel();
		return parent instanceof IEntity ? (IEntity)parent : NullEntity.instance;
	}

	public void rebuild() {
		EditPart parent = getParent();
		if (parent instanceof IEntityPart)
			((IEntityPart) parent).rebuildChild(this);
	}
	public void rebuildChild(EditPart child) {
		removeChild(child);
		refresh();
	}

	protected ICommandFactory getCommandFactory() {
		return ((IGEFEditorKit)getModelEntity().wGetEditorKit()).getCommandFactory();
	}

	public void addDecoration(DecorationKind kind, String tooltip) {
		//TODO implement
	}
	public void deleteDecorations(boolean deep) {
		//TODO implement		
	}

    public final void propertyChange(final PropertyChangeEvent evt){
    	Display.getDefault().asyncExec(new Runnable() {
    		public void run() {
    			propertyChangeUI(evt);
    		}
    	});
    }
	protected void propertyChangeUI(PropertyChangeEvent evt) {
			refreshChildren();
	}

	public boolean isReversable() {
		return false;
	}
	public boolean isModelChildrenReversed() {
		return false;
	}
	public final boolean isReversed() {
		return false;
	}
	public void setReversed(boolean value) {
		throw new UnsupportedOperationException("The editpart is not reversable");
	}

	public boolean isDetailed() {
		return false;
	}
	public void setDetailed(boolean value) {
	}
	public void setDetailed(boolean value, IEntityPart childPart) {
	}
	
	@Override
	public IEntityPartViewer getViewer() {
		return (IEntityPartViewer) super.getViewer();
	}
}
