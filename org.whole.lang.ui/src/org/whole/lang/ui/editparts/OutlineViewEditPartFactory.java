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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.operations.IDecorationManager.DecorationKind;
import org.whole.lang.ui.editor.IGEFEditorKit;
import org.whole.lang.ui.editors.TreeDirectEditManager;
import org.whole.lang.ui.editpolicies.IHilightable;
import org.whole.lang.ui.editpolicies.TreeDirectEditPolicy;
import org.whole.lang.ui.editpolicies.WholeComponentEditPolicy;
import org.whole.lang.ui.requests.ICommandFactory;
import org.whole.lang.ui.templates.OutlineUIProvider;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class OutlineViewEditPartFactory implements EditPartFactory {
	public EditPart createEditPart(EditPart context, Object modelEntity) {
		IEntity entity = (IEntity) modelEntity;

		switch (entity.wGetEntityKind()) {
		case DATA:
			return new OutlineTreeLeafEditPart(entity);
		case COMPOSITE:
			return new CompositeOutlineTreeNodeEditPart(entity);
		case SIMPLE:
			return new OutlineTreeNodeEditPart(entity);
		}

		throw new IllegalArgumentException("unsupported entity kind");
	}

	protected static abstract class OutlineTreeEditPart extends AbstractTreeEditPart implements ITreeEntityPart {
		public OutlineTreeEditPart(IEntity entity) {
			super(entity);
		}

		public void propertyChange(final PropertyChangeEvent event) {
	    	getViewer().getControl().getDisplay().syncExec(new Runnable() {
	    		public void run() {
	    			propertyChangeUI(event);
	    		}
	    	});
	    }
		protected abstract void propertyChangeUI(PropertyChangeEvent evt);

		@SuppressWarnings("unchecked")
		public <T extends IEntity> T getModelEntity() {
			return (T) filterAdapter((IEntity) getModel());
		}
		
		protected String getText() {
			return OutlineUIProvider.instance().getText(getModelEntity());
		}
		protected Image getImage() {
			return OutlineUIProvider.instance().getImage(getModelEntity());
		}

		public IEntity getParentModelEntity() {
			IEntity parentEntity = getModelEntity().wGetParent();
			//TODO workaround for parent bug after save
			if (!EntityUtils.isNull(parentEntity))
				return parentEntity;
			
			Object parent = getParent().getModel();
			return parent instanceof IEntity ? (IEntity)parent : NullEntity.instance;
		}

		@Override
		protected List<IEntity> getModelChildren() {
			return filterAdapters(getModelSpecificChildren());
		}
		//may return children with adapters
		//i.e. uses specific getters APIs to get children
		protected List<IEntity> getModelSpecificChildren() {
			return Collections.emptyList();
		}
		protected List<IEntity> filterAdapters(List<IEntity> children) {
			for (int i=0; i<children.size(); i++) {
				IEntity child = children.get(i);
				if (child.wIsAdapter())
					children.set(i, child.wGetAdaptee(false));
			}
			return children;
		}
		protected IEntity filterAdapter(IEntity entity) {
			return entity.wIsAdapter() ? entity.wGetAdaptee(false) : entity;
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

		public void addDecoration(DecorationKind kind, String tooltip) {
		}
		public void deleteDecorations(boolean deep) {
		}

		@Override
		public void performRequest(Request request) {
			if (request.getType() == RequestConstants.REQ_DIRECT_EDIT || request.getType() == RequestConstants.REQ_OPEN)
				performDirectEdit((LocationRequest) request);
			else
				super.performRequest(request);
		}

		protected void performDirectEdit(LocationRequest request) {
		}

		protected void createEditPolicies() {
	    	installEditPolicy(EditPolicy.COMPONENT_ROLE, new WholeComponentEditPolicy(getCommandFactory()));
		}

		protected ICommandFactory getCommandFactory() {
			return ((IGEFEditorKit)getModelEntity().wGetEditorKit()).getCommandFactory();
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
			throw new UnsupportedOperationException("The editpart is not orientable");
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

	public static class OutlineTreeNodeEditPart extends OutlineTreeEditPart {

		public OutlineTreeNodeEditPart(IEntity entity) {
			super(entity);
		}

		protected void propertyChangeUI(PropertyChangeEvent evt) {
			refresh();
		}

		protected List<IEntity> getModelSpecificChildren() {
			IEntity model = getModelEntity().wGetAdaptee(false);
			int size = model.wSize();
			if (size == 0)
				return Collections.emptyList();

			List<IEntity> featuresToBeShown = new ArrayList<IEntity>(size);
			for (int i=0; i<size; i++) {
				if (!model.wGetEntityDescriptor().getEntityFeatureDescriptor(i).isReference()) {
					IEntity child = model.wGet(i);
					if (!child.wGetLanguageKit().getURI().equals("whole:org.whole.lang.status:Status"))
						featuresToBeShown.add(child);
				}
			}
			return featuresToBeShown;
		}
	}
	public static class OutlineTreeLeafEditPart extends OutlineTreeEditPart {
		protected TreeDirectEditPolicy directEditPolicy;
		private TreeDirectEditManager manager;

		public OutlineTreeLeafEditPart(IEntity entity) {
			super(entity);
		}

		protected void propertyChangeUI(PropertyChangeEvent evt) {
			refreshVisuals();
		}

		protected void performDirectEdit(LocationRequest request) {
			if (directEditPolicy != null)
				showDirectEdit();
		}

		protected void showDirectEdit() {
			if (manager == null)
				manager = new TreeDirectEditManager(this);
		    
		    manager.show();
		}

		@Override
		protected void createEditPolicies() {
			super.createEditPolicies();
			installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
					directEditPolicy = new TreeDirectEditPolicy());
		}
	}
	public static class CompositeOutlineTreeNodeEditPart extends OutlineTreeNodeEditPart implements IHilightable {
		public CompositeOutlineTreeNodeEditPart(IEntity entity) {
			super(entity);
		}

		public int getHilightPosition() {
			return getModelEntity().wSize();
		}
		public void setHilightPosition(int hilightPosition) {
		}
	}
}
