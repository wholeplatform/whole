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
package org.whole.lang.e4.ui.viewers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LightweightEditDomain;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Widget;
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.commons.model.RootFragment;
import org.whole.lang.commons.model.impl.LazyContainmentRootFragmentImpl;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.ICompoundModel;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.editparts.EntityPartListener;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.IPartFocusListener;
import org.whole.lang.ui.editparts.ITreeEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.editparts.OutlineViewEditPartFactory;
import org.whole.lang.ui.input.IModelInput;
import org.whole.lang.ui.input.IModelInputListener;
import org.whole.lang.ui.keys.AbstractKeyHandler;
import org.whole.lang.ui.viewers.EntityEditDomain;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;
import org.whole.langs.core.CoreMetaModelsDeployer;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("unchecked")
public class E4TreeViewer extends TreeViewer implements IEntityPartViewer {
	@Inject IEclipseContext context;
	@Inject @Named("parent") Composite parent;
	@Inject @Optional EntityEditDomain domain;

	private ModelObserver modelObserver;
	private List<IPartFocusListener> partFocusListeners;
	private List<IModelInputListener> modelInputListeners;
	private Set<String> referencedResources;

	public E4TreeViewer() {
		setEditPartFactory(new OutlineViewEditPartFactory());
	}

	@PostConstruct
	public void initialize() {
		if (domain == null)
			domain = new EntityEditDomain();

		partFocusListeners = new ArrayList<IPartFocusListener>();
		modelInputListeners = new ArrayList<IModelInputListener>();
		referencedResources = new HashSet<String>();

		createControl(parent);
		domain.addViewer(this);
	}

	@Override
	public Control createControl(Composite parent) {
		Tree tree = (Tree) super.createControl(parent);
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent event) {
				Point point = new Point(event.x, event.y);
			    EditPart editPart = findObjectAt(point);
			    if (editPart != null) {
			    	LocationRequest request = new LocationRequest(RequestConstants.REQ_DIRECT_EDIT);
			    	request.setLocation(point);
					editPart.performRequest(request);
			    }
			}
		});
		return tree;
	}

	@Override
	protected void refreshDropTargetAdapter() {
		if (getControl() == null)
			return;
		if (getDelegatingDropAdapter().isEmpty())
			setDropTarget(null);
		else {
			if (getDropTarget() == null)
				setDropTarget(new DropTarget(getControl(), DND.DROP_MOVE
						| DND.DROP_COPY | DND.DROP_LINK));
			
			//FIXME workaround for Eclipse bug
			if (getDropTarget().getControl() == null)
				return;
			getDropTarget().setTransfer(
					getDelegatingDropAdapter().getTransfers());
		}
	}

	@Override
	public void deselect(EditPart editpart) {
		//FIXME workaround for Eclipse bug
		Widget widget = ((ITreeEntityPart) editpart).getWidget();
		if (widget != null && !widget.isDisposed())
			super.deselect(editpart);
	}
	
	@Override
	public void setSelection(ISelection newSelection, boolean propagate) {
		// the underlying TreeViewer keeps an unordered selection
		// at least, we have to preserve the old child ordering
		List<IEntityPart> previousParts = new ArrayList<>(((IStructuredSelection) getSelection()).toList());
		List<IEntityPart> newParts = new ArrayList<>(((IStructuredSelection) newSelection).toList());
		previousParts.retainAll(newParts);
		newParts.removeAll(previousParts);
		List<IEntityPart> orderedParts = new LinkedList<>(newParts);
		orderedParts.addAll(previousParts);
		super.setSelection(new StructuredSelection(orderedParts), propagate);
	}

	@Override
	public void setEditDomain(LightweightEditDomain editdomain) {
		if (getControl() != null)
			super.setEditDomain(editdomain);
	}

	// Begin Block Shared With E4GraphicalViewer
	public IEclipseContext getContext() {
		return context;
	}
	
	public IBindingManager getContextBindings() {
		Object selection = getContext().get(ESelectionService.class).getSelection();
		if (selection instanceof IBindingManager)
			return (IBindingManager) selection;
		else {
			IBindingManager bm = BindingManagerFactory.instance.createBindingManager();
			E4Utils.defineResourceBindings(bm, modelInput);
			return bm;
		}
	}

	public Set<String> getReferencedResources() {
		return referencedResources;
	}
	protected boolean executable = true;
	public boolean isOperationExecutable() {
		return executable;
	}
	public void setOperationExecutable(boolean executable) {
		this.executable = executable;
	}

	public CommandStack getCommandStack() {
		return getEditDomain().getCommandStack();
	}
	public boolean isDirty() {
		return getCommandStack().isDirty();
	}

	@Override
	public EntityEditDomain getEditDomain() {
		return (EntityEditDomain) super.getEditDomain();
	}
	public LightweightEditDomain linkEditDomain(IEntityPartViewer viewer) {
		EntityEditDomain editDomain = getEditDomain();
		if (editDomain != null)
			editDomain.removeViewer(this);

		editDomain = viewer.getEditDomain();
		editDomain.addViewer(this);
		return editDomain;
	}

	public IEntity getEntityContents() {
		RootFragment modelEntity = ((IEntityPart) getContents()).getModelEntity();
		return modelEntity.getRootEntity().wGetAdaptee(false);
	}
	public void setEntityContents(IEntity entity) {
		setContents(entity);
		flush();
		ReflectionFactory.getHistoryManager(entity).setHistoryEnabled(true);
		getCommandStack().flush();
	}

	protected IModelInput modelInput = null;
	public void setContents(IModelInput modelInput, IEntity defaultContents) {
		if (modelInput != null) {
			IModelInput oldModelInput = this.modelInput;
			this.modelInput = modelInput;
			try {
				setEntityContents(this.modelInput.readModel());
				fireModelInputChanged(oldModelInput, this.modelInput);
			} catch (Exception e) {
				String errorMessage = String.format("Unable to open \"%s\" using \"%s\" persistence kit",
						modelInput.getName(), modelInput.getPersistenceKit().getDescription());
				setEntityContents(E4Utils.createErrorStatusContents(errorMessage, e.getLocalizedMessage()));
			}
		} else
			setEntityContents(defaultContents);
	}
	public void reloadContents() {
		setContents(modelInput, null);
	}
	protected RootFragment wrapContents(IEntity entity) {
		return entity instanceof RootFragment ? (RootFragment) entity :
			new LazyContainmentRootFragmentImpl(entity);
	}
	public void setContents(Object contents) {
		IEntity root = (IEntity) contents;
		//FIXME workaround since selection is not properly reset
		if (getContents() != null)
			setSelection(StructuredSelection.EMPTY);
		super.setContents(wrapContents(root));
		updateModelObserver(root);
	}
	public boolean hasContents() {
		return !CoreMetaModelsDeployer.STATUS_URI.equals(getEntityContents().wGetLanguageKit().getURI());
	}

	@SuppressWarnings("unchecked")
	public Map<IEntity, IEntityPart> getEditPartRegistry() {
		return super.getEditPartRegistry();
	}
	public IEntityPart getFocusEntityPart() {
		return (IEntityPart) getFocusEditPart();
	}

	public AbstractKeyHandler getKeyHandler() {
		return (AbstractKeyHandler) super.getKeyHandler();
	}
	public void setKeyHandler(AbstractKeyHandler handler) {
		super.setKeyHandler(handler);
	}

	public void select(IEntity entity) {
		select(entity, true);
	}
	public void select(IEntity entity, boolean propagate) {
		IEntityPart entityPart = ModelObserver.getObserver(entity, getEditPartRegistry());
		if (entityPart != null)
			select(entityPart, propagate);
	}
	@Override
	public void select(List<? extends IEntity> entities) {
		select(entities, true);
	}
	@Override
	public void select(List<? extends IEntity> entities, boolean propagate) {
		List<IEntityPart> entityParts = new ArrayList<>();
		for (int i = entities.size()-1; i >= 0; i--) {
			IEntityPart entityPart = ModelObserver.getObserver(entities.get(i), getEditPartRegistry());
			if (entityPart != null)
				entityParts.add(entityPart);
		}
		setSelection(new StructuredSelection(entityParts), propagate);
	}
	public void reveal(IEntity entity) {
		IEntityPart entityPart = ModelObserver.getObserver(entity, getEditPartRegistry());
			reveal(entityPart);
	}
	public void selectAndReveal(IEntity entity) {
		selectAndReveal(entity, true);
	}
	public void selectAndReveal(List<? extends IEntity> entities) {
		selectAndReveal(entities, true);
	}

	protected void updateModelObserver(IEntity entity) {
		ICompoundModel model = entity.wGetModel().getCompoundModel();
		if (modelObserver != null && modelObserver.getModel() != model) {
			modelObserver.dispose();
			modelObserver = null;
		}
		if (modelObserver == null)
			modelObserver = new ModelObserver(model, this);		
	}
	public void addEntityPartListener(EntityPartListener listener) {
		modelObserver.addEntityPartListener(listener);
	}
	public void removeEntityPartListener(EntityPartListener listener) {
		modelObserver.removeEntityPartListener(listener);
	}

	public void dispose() {
		if (modelObserver != null)
			modelObserver.dispose();
	}

	protected void firePartFocusChanged(IEntityPart oldPart, IEntityPart newPart) {
		for (IPartFocusListener listener : partFocusListeners)
			listener.focusChanged(oldPart, newPart);
	}
	public void addPartFocusListener(IPartFocusListener listener) {
		partFocusListeners.add(listener);
	}
	public void removePartFocusListener(IPartFocusListener listener) {
		partFocusListeners.remove(listener);
	}

	protected void fireModelInputChanged(IModelInput oldModelInput, IModelInput newModelInput) {
		for (IModelInputListener listener : modelInputListeners)
			listener.modelInputChanged(oldModelInput, newModelInput);
	}
	public void addModelInputListener(IModelInputListener listener) {
		modelInputListeners.add(listener);
	}
	public void removeModelInputListener(IModelInputListener listener) {
		modelInputListeners.remove(listener);
	}

	public void rebuildNotation() {
		RootFragment rootFragment = (RootFragment) getContents().getModel();
		//FIXME should be rebuildNotation(rootFragment)
		rebuildNotation(rootFragment.getRootEntity().wGetAdaptee(true));
	}

	// End Block Shared With E4GraphicalViewer

	public void selectAndReveal(IEntity entity, boolean propagate) {
		IEntityPart entityPart = ModelObserver.getObserver(entity, getEditPartRegistry());

		if (entityPart != null) {
			reveal(entityPart);
			select(entityPart, propagate);
		}
	}
	public void selectAndReveal(List<? extends IEntity> entities, boolean propagate) {
		if (!entities.isEmpty())
			reveal(entities.get(entities.size()-1));
		select(entities, propagate);
	}

	public void rebuildNotation(IEntity entity) {
		IEntityPart entityPart = ModelObserver.getObserver(entity, getEditPartRegistry());
		if (entityPart == null) {
			if (EntityUtils.isAncestorOrSelf(entity, getEntityContents()))
				entityPart = ModelObserver.getObserver(getEntityContents(), getEditPartRegistry());
			else
				return;
		}

		entityPart.rebuild();
	}
	
	public void refreshNotation() {
		// do nothing
	}
	public void refreshNotation(IEntity entity) {
		// do nothing
	}
	
	public void setInteractive(IEntity entity, boolean edit, boolean browse, boolean inherited) {
		throw new UnsupportedOperationException();
	}
}
