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

import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.commons.model.impl.LazyContainmentRootFragmentImpl;
import org.whole.lang.e4.ui.actions.E4KeyHandler;
import org.whole.lang.e4.ui.api.IModelInput;
import org.whole.lang.e4.ui.draw2d.DelayableUpdateManager;
import org.whole.lang.e4.ui.editparts.RootEditPart;
import org.whole.lang.e4.ui.handler.CopyHandler;
import org.whole.lang.e4.ui.handler.CutHandler;
import org.whole.lang.e4.ui.handler.PasteHandler;
import org.whole.lang.e4.ui.handler.SelectAllHandler;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.ICompoundModel;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.dnd.EditPartTransferDragSourceListener;
import org.whole.lang.ui.dnd.EditPartTransferDropTargetListener;
import org.whole.lang.ui.dnd.FileTransferDropTargetListener;
import org.whole.lang.ui.dnd.TextTransferDragSourceListener;
import org.whole.lang.ui.dnd.TextTransferDropTargetListener;
import org.whole.lang.ui.dnd.XmlBuilderFileTransferDragSourceListener;
import org.whole.lang.ui.editparts.EntityPartListener;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.editparts.WholeEditPartFactory;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.resources.ColorRegistry;
import org.whole.lang.ui.resources.FontRegistry;
import org.whole.lang.ui.resources.IColorRegistry;
import org.whole.lang.ui.resources.IFontRegistry;
import org.whole.lang.ui.resources.IResourceManager;
import org.whole.lang.ui.tools.Tools;

/**
 * @author Enrico Persiani
 */
public class E4GraphicalViewer extends ScrollingGraphicalViewer implements IResourceManager {
	private ModelObserver modelObserver;

	public E4GraphicalViewer(Composite parent) {
		this(parent, new E4EditDomain());
	}
	public E4GraphicalViewer(Composite parent, E4EditDomain domain) {
		createControl2(parent);
		domain.addViewer(this);

		setEditPartFactory(new WholeEditPartFactory());
		setRootEditPart(new RootEditPart());

		addDragSourceListener(new EditPartTransferDragSourceListener(this));
		addDropTargetListener(new EditPartTransferDropTargetListener(this));

		addDragSourceListener(new XmlBuilderFileTransferDragSourceListener(this));
		addDropTargetListener(new FileTransferDropTargetListener(this));

		addDragSourceListener(new TextTransferDragSourceListener(this));
		addDropTargetListener(new TextTransferDropTargetListener(this));

		Tools.PANNING.ensureActive(domain);
	}

	@SuppressWarnings("unchecked")
	public Map<IEntity, IEntityPart> getEditPartRegistry() {
		return super.getEditPartRegistry();
	}

	@SuppressWarnings("unchecked")
	public class E4FigureCanvas extends FigureCanvas {
		public E4FigureCanvas(Composite parent, LightweightSystem lws) {
			super(parent, lws);
		}
		public void cut() {
			IBindingManager bm = E4Utils.createSelectionBindings(getSelectedEditParts(), E4GraphicalViewer.this);
			CutHandler handler = new CutHandler();
			if (handler.canExecute(bm))
				handler.execute(bm);
		}
		public void copy() {
			IBindingManager bm = E4Utils.createSelectionBindings(getSelectedEditParts(), E4GraphicalViewer.this);
			CopyHandler handler = new CopyHandler();
			if (handler.canExecute(bm))
				handler.execute(bm);
		}
		public void paste() {
			IBindingManager bm = E4Utils.createSelectionBindings(getSelectedEditParts(), E4GraphicalViewer.this);
			PasteHandler handler = new PasteHandler();
			if (handler.canExecute(bm))
				handler.execute(bm);
		}
		public void selectAll() {
			IBindingManager bm = E4Utils.createSelectionBindings(getSelectedEditParts(), E4GraphicalViewer.this);
			SelectAllHandler handler = new SelectAllHandler();
			if (handler.canExecute(bm))
				handler.execute(bm);
		}
	}

	public E4KeyHandler getKeyHandler() {
		return (E4KeyHandler) super.getKeyHandler();
	}
	public void setKeyHandler(E4KeyHandler handler) {
		super.setKeyHandler(handler);
	}

	public Control createControl2(Composite parent) {
		setControl(new E4FigureCanvas(parent, getLightweightSystem()));
		hookRootFigure();
		return getControl();
	}

	protected void updateModelObserver(IEntity entity) {
		ICompoundModel model = entity.wGetModel().getCompoundModel();
		if (modelObserver != null && modelObserver.getModel() != model) {
			modelObserver.dispose();
			modelObserver = null;
		}
		if (modelObserver == null)
			modelObserver = new ModelObserver(model, (Map<IEntity, IEntityPart>) getEditPartRegistry());		
	}
	public void dispose() {
		if (modelObserver != null)
			modelObserver.dispose();
	}
	public void addEntityPartListener(EntityPartListener listener) {
		modelObserver.addEntityPartListener(listener);
	}
	public void removeEntityPartListener(EntityPartListener listener) {
		modelObserver.removeEntityPartListener(listener);
	}

	public CommandStack getCommandStack() {
		return getEditDomain().getCommandStack();
	}
	public boolean isDirty() {
		return getCommandStack().isDirty();
	}

	public void setContents(IModelInput modelInput, IEntity defaultContents) {
		IEntity entity = defaultContents;
		try {
			IFilePersistenceProvider pp = new IFilePersistenceProvider(modelInput.getFile());
			entity = modelInput.getPersistenceKit().readModel(pp);
		} catch (Exception e) {
		}
		setContents(entity);
		setInteractive(entity, true, true, true);
		flush();
		ReflectionFactory.getHistoryManager(entity).setHistoryEnabled(true);
		getCommandStack().flush();
	}

	protected RootFragment wrapContents(IEntity entity) {
		return entity instanceof RootFragment ? (RootFragment) entity :
			new LazyContainmentRootFragmentImpl(entity);
	}
	public void setContents(Object contents) {
		IEntity root = (IEntity) contents;
		super.setContents(wrapContents(root));
//TODO test to remove e4 menu rerender workaround
//		select(getEditPartRegistry().get(root));
		updateModelObserver(root);
	}

	public IEntity getEntityContents() {
		RootFragment modelEntity = ((IEntityPart) getContents()).getModelEntity();
		return modelEntity.getRootEntity().wGetAdaptee(false);
	}
	public void setEntityContents(IEntity entity) {
		setContents(entity);
	}

	public void setInteractive(IEntity entity, boolean edit, boolean browse, boolean inherited) {
		Map<?, ?> mapping = getEditPartRegistry();
		GraphicalEditPart entityPart = (GraphicalEditPart) mapping.get(entity);
		if (entityPart != null) {
			IEntityFigure entityFigure = (IEntityFigure) entityPart.getFigure();
			entityFigure.setInteractiveEdit(edit);
			entityFigure.setInteractiveBrowse(browse);
			entityFigure.setInteractiveInherited(inherited);
		}
	}

	private EditPart focusEditPart;
	@Override
	protected void handleFocusGained(FocusEvent fe) {
		if (focusEditPart != null)
			setFocus(focusEditPart);
		focusEditPart = null;
	}
	@Override
	protected void handleFocusLost(FocusEvent fe) {
		focusEditPart = getFocusEditPart();
		focusEditPart = focusEditPart.hasFocus() ? focusEditPart : null;
		setFocus(null);
	}
	@Override
	public void setFocus(EditPart part) {
		super.setFocus(part);
	}

	@Override
	public E4EditDomain getEditDomain() {
		return (E4EditDomain) super.getEditDomain();
	}
	@Override
	protected LightweightSystem createLightweightSystem() {
		LightweightSystem lws = super.createLightweightSystem();
		lws.setUpdateManager(new DelayableUpdateManager(this));
		return lws;
	}

//	private ResourceManager resourceManager;
	@Override
	public ResourceManager getResourceManager() {
//		return resourceManager;
		return super.getResourceManager();
	}
//	@Override
//	protected void hookControl() {
//		super.hookControl();
//
//		if (resourceManager == null)
//			resourceManager = new LocalResourceManager(JFaceResources.getResources());
//	}
//	@Override
//	protected void unhookControl() {
//		super.unhookControl();
//
//		if (resourceManager != null)
//			resourceManager.dispose();
//	}

	@Override
	protected void handleDispose(DisposeEvent e) {
		colorRegistry = null;
		fontRegistry = null;
		super.handleDispose(e);
	}

	private IColorRegistry colorRegistry;
	public IColorRegistry getColorRegistry() {
		if (colorRegistry == null)
			colorRegistry = new ColorRegistry(getResourceManager());
		return colorRegistry;
	}
	private IFontRegistry fontRegistry;
	public IFontRegistry getFontRegistry() {
		if (fontRegistry == null)
			fontRegistry = new FontRegistry(getResourceManager());
		return fontRegistry;
	}

	public void selectAndReveal(IEntity entity) {
		IEntityPart entityPart = getEditPartRegistry().get(entity);

		if (entityPart != null) {
			reveal(entityPart);
			select(entityPart);
		}
	}
}
