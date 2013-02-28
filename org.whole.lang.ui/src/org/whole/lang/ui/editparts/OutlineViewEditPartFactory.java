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
package org.whole.lang.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.AbstractTreeEditPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySource2;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.operations.IDecorationManager.DecorationKind;
import org.whole.lang.ui.editor.IGEFEditorKit;
import org.whole.lang.ui.editors.WholeOutlinePage;
import org.whole.lang.ui.editpolicies.IHilightable;
import org.whole.lang.ui.editpolicies.WholeComponentEditPolicy;
import org.whole.lang.ui.requests.ICommandFactory;
import org.whole.lang.ui.templates.OutlineUIProvider;
import org.whole.lang.ui.util.UIUtils;
import org.whole.lang.ui.views.WholeGraphicalViewer;
import org.whole.lang.ui.views.properties.tabbed.EntityPropertySource;
import org.whole.lang.util.EntityUtils;


/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class OutlineViewEditPartFactory implements EditPartFactory {
	public EditPart createEditPart(EditPart context, Object entity) {
		IEntity modelEntity = (IEntity) entity;
		if (EntityUtils.isData(modelEntity)) {
			OutlineTreeLeafEditPart outlineTreeLeafEditPart = EntityUtils.isComposite(modelEntity) ?
					new CompositeOutlineTreeLeafEditPart(modelEntity) :
						new OutlineTreeLeafEditPart(modelEntity);
			return outlineTreeLeafEditPart;
		} else {
			OutlineTreeNodeEditPart outlineTreeNodeEditPart = EntityUtils.isComposite(modelEntity) ?
					new CompositeOutlineTreeNodeEditPart(modelEntity) :
						new OutlineTreeNodeEditPart(modelEntity);
			return outlineTreeNodeEditPart;
		}
	}

	protected static abstract class OutlineTreeEditPart extends AbstractTreeEditPart implements IEntityPart {
		public OutlineTreeEditPart(IEntity entity) {
			super(entity);
		}

		public void propertyChange(final PropertyChangeEvent event) {
	    	Display.getDefault().syncExec(new Runnable() {
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
			//TODO implement
		}
		public void deleteDecorations(boolean deep) {
			//TODO implement		
		}

		protected void createEditPolicies() {
	    	installEditPolicy(EditPolicy.COMPONENT_ROLE, new WholeComponentEditPolicy(getCommandFactory()));
		}

		protected ICommandFactory getCommandFactory() {
			return ((IGEFEditorKit)getModelEntity().wGetEditorKit()).getCommandFactory();
		}

		@Override
		@SuppressWarnings("rawtypes")
		public Object getAdapter(Class key) {
			if (key == IPropertySource.class || key == IPropertySource2.class)
				return new EntityPropertySource(getModelEntity());
			return super.getAdapter(key);
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
	}
	public static class OutlineTreeNodeEditPart extends OutlineTreeEditPart {
		public OutlineTreeNodeEditPart(IEntity entity) {
			super(entity);
		}

		protected void propertyChangeUI(PropertyChangeEvent evt) {
			IEditorPart activeEditor = UIUtils.getActiveEditor();
			if (activeEditor != null)  {
				EditPartViewer viewer = (EditPartViewer) activeEditor.getAdapter(GraphicalViewer.class);
				Object value = viewer.getProperty(WholeGraphicalViewer.PROPERTY_DELAY_UPDATES);
				if (value != null ? (Boolean) value : false) {
					getViewer().setProperty(WholeOutlinePage.PROPERTY_DIRTY, true);
					return;
				}
			}
			refresh();
		}

		protected List<IEntity> getModelSpecificChildren() {
			IEntity model = getModelEntity().wGetAdaptee(false);
			int size = model.wSize();
			if (size == 0)
				return Collections.emptyList();

			List<IEntity> featuresToBeShown = new ArrayList<IEntity>(size);
			for (int i=0; i<size; i++) {
				if (!model.wGetEntityDescriptor().getEntityFeatureDescriptor(i).isReference())
					featuresToBeShown.add(model.wGet(i));
			}
			return featuresToBeShown;
		}
	}
	public static class OutlineTreeLeafEditPart extends OutlineTreeEditPart {
		public OutlineTreeLeafEditPart(IEntity entity) {
			super(entity);
		}

		protected void propertyChangeUI(PropertyChangeEvent evt) {
			IEditorPart activeEditor = UIUtils.getActiveEditor();
			if (activeEditor != null)  {
				EditPartViewer viewer = (EditPartViewer) activeEditor.getAdapter(GraphicalViewer.class);
				Object value = viewer.getProperty(WholeGraphicalViewer.PROPERTY_DELAY_UPDATES);
				if (value != null ? (Boolean) value : false) {
					getViewer().setProperty(WholeOutlinePage.PROPERTY_DIRTY, true);
					return;
				}
			}
			refreshVisuals();
		}
	}
	public static class CompositeOutlineTreeNodeEditPart extends OutlineTreeNodeEditPart implements IHilightable {
		public CompositeOutlineTreeNodeEditPart(IEntity entity) {
			super(entity);
		}

		public boolean isModelChildrenReversed() {
			return false;
		}

		public int getHilightPosition() {
			return getModelEntity().wSize();
		}
		public void setHilightPosition(int hilightPosition) { }
	}
	public static class CompositeOutlineTreeLeafEditPart extends OutlineTreeLeafEditPart implements IHilightable {
		public CompositeOutlineTreeLeafEditPart(IEntity entity) {
			super(entity);
		}

		public boolean isModelChildrenReversed() {
			return false;
		}

		public int getHilightPosition() {
			return getModelEntity().wSize();
		}
		public void setHilightPosition(int hilightPosition) { }
	}
}
