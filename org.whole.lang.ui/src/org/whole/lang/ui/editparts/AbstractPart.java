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
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.Toggle;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.ExposeHelper;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gef.tools.SelectEditPartTracker;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.accessibility.AccessibleEvent;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.model.IEntity;
import org.whole.lang.model.NullEntity;
import org.whole.lang.operations.IDecorationManager.DecorationKind;
import org.whole.lang.ui.WholeImages;
import org.whole.lang.ui.editor.IGEFEditorKit;
import org.whole.lang.ui.editpolicies.IHilightable;
import org.whole.lang.ui.editpolicies.WholeComponentEditPolicy;
import org.whole.lang.ui.editpolicies.WholeContainerEditPolicy;
import org.whole.lang.ui.editpolicies.WholeDragEditPartsTracker;
import org.whole.lang.ui.editpolicies.WholeLayoutEditPolicy;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.EntityToggle;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.figures.IFoldableFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.requests.ICommandFactory;
import org.whole.lang.ui.tools.Tools;
import org.whole.lang.ui.util.AnimableRunnable;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;


/**
 * @author Riccardo Solmi
 */
public abstract class AbstractPart extends AbstractGraphicalEditPart implements IGraphicalEntityPart {
	private AccessibleEditPart acc;

	public AbstractPart() {
		this(true);
	}
	public AbstractPart(boolean isDraggable) {
		setDraggable(isDraggable);
	}

	protected static final int FLAG_DRAGGABLE = new Integer(AbstractEditPart.MAX_FLAG << 1).intValue();
	protected static final int FLAG_REVERSED = new Integer(AbstractEditPart.MAX_FLAG << 2).intValue();
	protected static final int FLAG_DETAILED = new Integer(AbstractEditPart.MAX_FLAG << 3).intValue();
	protected static final int FLAG_FORCE_SELECTABLE = new Integer(AbstractEditPart.MAX_FLAG << 4).intValue();
	protected static final int MAX_FLAG = FLAG_FORCE_SELECTABLE;


	public void activate(){
		if (!isActive())
			super.activate();
	}

	public void deactivate(){
	    if (isActive())
	        super.deactivate();
	}

	@Override
	public void setFocus(boolean value) {
		if (hasFocus() == value)
			return;
		setFlag(FLAG_FOCUS, value);
		fireSelectionChanged();
	}

	@Override
	public boolean isSelectable() {
		if (!super.isSelectable())
			return false;
		if (getFlag(FLAG_FORCE_SELECTABLE))
			return true;

		IEntityFigure entityFigure = (IEntityFigure) getFigure();
		return entityFigure.isInteractiveInherited() ?
				getParent().isSelectable() : entityFigure.isInteractiveEdit();
	}

	protected boolean isDraggable() {
		return getFlag(FLAG_DRAGGABLE);
	}
	protected void setDraggable(boolean value) {
		setFlag(FLAG_DRAGGABLE, value);
	}

	public boolean isReversable() {
		return false;
	}
	public boolean isModelChildrenReversed() {
		return false;
	}
	public boolean isReversed() {
		return getFlag(FLAG_REVERSED);
	}
	public void setReversed(boolean value) {
		if (!isReversable())
			throw new UnsupportedOperationException("The editpart is not reversable");

		setFlag(FLAG_REVERSED, value);
	}

	protected ICommandFactory getCommandFactory() {
		return ((IGEFEditorKit)getModelEntity().wGetEditorKit()).getCommandFactory();
	}

	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new WholeContainerEditPolicy(getCommandFactory()));
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new WholeComponentEditPolicy(getCommandFactory()));
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new WholeLayoutEditPolicy(getCommandFactory()));
//		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new WholeHilightEditPolicy());
	}
	public DragTracker getDragTracker(Request request) {
		return isDraggable() ? new WholeDragEditPartsTracker(this) : new SelectEditPartTracker(this);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key == ExposeHelper.class || key == ExtendedExposeHelper.class)
			return new WholeExtendedExposeHelper(this);
		if (key == IHilightable.class)
			return null;
		return super.getAdapter(key);
	}

	public IFigure getFigure() {
		if (figure == null) {
			super.getFigure();
			if (figure instanceof IFoldableFigure) {
				ActionListener toggleListener = null;
				for (Iterator<Toggle> iter = ((IFoldableFigure) figure).getFoldingToggles().iterator(); iter.hasNext();) {
					EntityToggle toggleFigure = (EntityToggle) iter.next();
					if (toggleListener == null)
						toggleListener = createToggleListener();
					toggleFigure.addActionListener(toggleListener);
				};
			}
		}
		return figure;
	}
	protected ActionListener createToggleListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				EditPartViewer viewer = getViewer();
				IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
				for (Iterator<?> i = selection.iterator(); i.hasNext();) {
					EditPart selectedPart = (EditPart) i.next();
					if (isDescendant(selectedPart))
						viewer.deselect(selectedPart);
				}
				if (isDescendant(viewer.getFocusEditPart()))
					viewer.setFocus(null);
			}
		};
	}
	protected boolean isDescendant(EditPart part) {
		if (part == this)
			return false;

		while (part != null) {
			part = part.getParent();
			if (part == this)
				return true;
		}

		return false;
	}

	public void addDecoration(DecorationKind kind, String tooltip) {
		IFigure decorations = getFigure().getToolTip();
		if (decorations == null || !(decorations instanceof DecorationFigure))
			getFigure().setToolTip(decorations = new DecorationFigure());
		
		decorations.add(new EntityLabel(tooltip, getDecorationImage(kind)));
	}
	public void deleteDecorations(boolean deep) {
		IFigure decorations = getFigure().getToolTip();
		if (decorations != null && decorations instanceof DecorationFigure)
			getFigure().setToolTip(null);

		if (deep) {
			@SuppressWarnings("rawtypes")
			List c = getChildren();
			for (int i=0, size=c.size(); i<size; i++) {
				Object child = c.get(i);
				if (child instanceof IEntityPart)
					((IEntityPart) child).deleteDecorations(deep);
			}

		}			
	}
	public static class DecorationFigure extends EntityFigure {
		public DecorationFigure() {
			super(new ColumnLayout().withSpacing(1));
			setBorder(new MarginBorder(2));
		}
	}
	protected Image getDecorationImage(DecorationKind kind) {
		switch (kind) {
		case ERROR:
			return WholeImages.ERROR_OVR16;
		case ERROR_ASSIST:
			return WholeImages.ASSIST_ERROR_OVR16;
		case WARNING:
			return WholeImages.WARNING_OVR16;
		case WARNING_ASSIST:
			return WholeImages.ASSIST_WARNING_OVR16;
		case ASSIST:
			return WholeImages.ASSIST_OVR16;
		default:
			return WholeImages.HELP_OVR16;
		}
	}

	protected IEntity getPresentationEntity() {
		return getModelEntity(); //FIXME getAspect
	}
	@SuppressWarnings("unchecked")
	public <T extends IEntity> T getModelEntity() {
		return (T) filterAdapter((IEntity) getModel());
	}
	public IEntity getParentModelEntity() {
		IEntity modelEntity = getModelEntity();
		IEntity parentModelEntity = modelEntity.wGetParent();
		if (!EntityUtils.isNull(parentModelEntity))
			return parentModelEntity;
		else
			return getParentPartModelEntity();
	}
	public IEntity getParentPartModelEntity() {
		Object parent = getParent().getModel();
		return parent instanceof IEntity ? (IEntity) parent : NullEntity.instance;
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
	
	/**
	 * Handles changes in properties of this. It is 
	 * activated through the PropertyChangeListener.
	 * It updates children, source and target connections,
	 * and the visuals of this based on the property
	 * changed.
	 *
	 * @param evt  Event which details the property change.
	 */
	public final void propertyChange(final PropertyChangeEvent evt) {
		int millis = EntityUtils.isData((IEntity) evt.getSource()) ? AnimableRunnable.NO_ANIMATION : AnimableRunnable.DEFAULT_DELAY;

		AnimableRunnable runnable = new AnimableRunnable(millis) {
			public void doRun() {
				propertyChangeUI(evt);
			}
		};
		if (isSyncPropertyChange())
			runnable.syncExec();
		else
			runnable.asyncExec();
	}
	protected void propertyChangeUI(PropertyChangeEvent evt) {
//		if (getModel() != evt.getSource()) //getModel() vs getModelEntity() ?
//			return; //change occurred in a descendant
//
//		IEntity newValue = (IEntity) evt.getNewValue();
//		if (newValue != null) {
//			List<IEntity> children = getModelChildren();
//			for (int i=0,size=children.size(); i<size; i++)
//				if (children.get(i) == newValue) {
//					addChild(createChild(newValue), i++);
//
//					if (evt.getOldValue() != null)
//						removeChild((EditPart) getChildren().get(i));
//					return;
//				}
//		} else if (evt.getOldValue() != null)
//			for (int i=0,size=getChildren().size(); i<size; i++) {
//				EditPart part = (EditPart) getChildren().get(i);
//				if (part.getModel() == evt.getOldValue()) {
//					removeChild(part);
//					return;
//				}
//			}
		try {
			refreshChildren();
		} catch (NullPointerException|IndexOutOfBoundsException e) {
			//FIXME rewrite a more fine grained children refresh logic
		}
	}
	private static boolean syncPropertyChange;
	public static boolean isSyncPropertyChange() {
		return syncPropertyChange;
	}
	public static void setSyncPropertyChange(boolean value) {
		syncPropertyChange = value;
	}

	protected AccessibleEditPart createAccessible() {
		return new AccessibleGraphicalEditPart(){
			public void getName(AccessibleEvent e) {
				e.result = getModel().toString();
			}
		};
	}
	protected AccessibleEditPart getAccessibleEditPart() {
		if (acc == null)
			acc = createAccessible();
		return acc;
	}

	public void performRequest(Request request) {
		if (request.getType() == RequestConstants.REQ_DIRECT_EDIT || request.getType() == RequestConstants.REQ_OPEN)
			performDirectEdit((LocationRequest) request);
		else
			super.performRequest(request);
	}

	protected void performDirectEdit(LocationRequest request) {
		Tools.PANNING.ensureActive(getViewer());
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

	public boolean isDetailed() {
		return getFlag(FLAG_DETAILED);
	}
	public void setDetailed(boolean value) {
		setFlag(FLAG_DETAILED, value);

		EditPart parent = getParent();
		if (parent instanceof IEntityPart)
			((IEntityPart) parent).setDetailed(value, this);
	}
	public void setDetailed(boolean value, IEntityPart childPart) {
		setFlag(FLAG_DETAILED, value);
	}

	@Override
	public void setSelected(int value) {
		int oldValue = getSelected();
		if (oldValue == value)
			return;

		setFlag(FLAG_FORCE_SELECTABLE, true);
		super.setSelected(value);
		setFlag(FLAG_FORCE_SELECTABLE, false);

		if (value == EditPart.SELECTED_NONE && isDetailed())
			setDetailed(false);
		else if (value == EditPart.SELECTED_PRIMARY && !isDetailed())
			setDetailed(true);
	}
	
	@Override
	public IEntityPartViewer getViewer() {
		return (IEntityPartViewer) super.getViewer();
	}
}
