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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.parts.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.whole.lang.e4.ui.actions.E4KeyHandler;
import org.whole.lang.e4.ui.api.IModelInput;
import org.whole.lang.model.ICompoundModel;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.reflect.QueriesTemplateManager;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.status.codebase.ErrorStatusTemplate;
import org.whole.lang.ui.editparts.EntityPartListener;
import org.whole.lang.ui.editparts.IEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.editparts.OutlineViewEditPartFactory;
import org.whole.langs.core.CoreMetaModelsDeployer;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("unchecked")
public class E4TreeViewer extends TreeViewer implements IEntityPartViewer {
	private ModelObserver modelObserver;
	private List<IPartFocusListener> partFocusListeners;
	private List<IModelInputListener> modelInputListeners;

	public E4TreeViewer(Composite parent) {
		this(parent, new E4EditDomain());
	}
	public E4TreeViewer(Composite parent, E4EditDomain domain) {
		partFocusListeners = new ArrayList<IPartFocusListener>();
		modelInputListeners = new ArrayList<IModelInputListener>();

		createControl(parent);
		domain.addViewer(this);

		setEditPartFactory(new OutlineViewEditPartFactory());
	}

	public CommandStack getCommandStack() {
		return getEditDomain().getCommandStack();
	}
	public boolean isDirty() {
		return getCommandStack().isDirty();
	}
	
	public IEntity getEntityContents() {
		return ((IEntityPart) getContents()).getModelEntity().wGetAdaptee(false);
	}
	public void setEntityContents(IEntity entity) {
		setContents(entity);
	}

	protected IModelInput modelInput = null;
	public void setContents(IModelInput modelInput, IEntity defaultContents) {
		if (modelInput != null) {
			try {
				IModelInput oldModelInput = this.modelInput;
				setEntityContents(modelInput.readModel());
				fireModelInputChanged(oldModelInput, this.modelInput = modelInput);
			} catch (Exception e) {
				ILanguageKit languageKit = ReflectionFactory.getLanguageKit(CoreMetaModelsDeployer.STATUS_URI, false, null);
				FeatureDescriptorEnum fdEnum = languageKit.getFeatureDescriptorEnum();
				IEntity statusModel = new ErrorStatusTemplate().create();
				String errorMessage = String.format("Unable to open \"%s\" using \"%s\" persistence kit",
						modelInput.getFile().getName(), modelInput.getPersistenceKit().getDescription());
				statusModel.wGet(fdEnum.valueOf("error")).wSetValue(errorMessage);
				statusModel.wGet(fdEnum.valueOf("cause")).wSetValue(e.getLocalizedMessage());
				setEntityContents(statusModel);
			}
		} else
			setEntityContents(QueriesTemplateManager.instance().create("FileArtifact generator"));//defaultContents);
	}

	public Map<IEntity, IEntityPart> getEditPartRegistry() {
		return super.getEditPartRegistry();
	}
	public IEntityPart getFocusEntityPart() {
		return (IEntityPart) getFocusEditPart();
	}

	public E4KeyHandler getKeyHandler() {
		return (E4KeyHandler) super.getKeyHandler();
	}
	public void setKeyHandler(E4KeyHandler handler) {
		super.setKeyHandler(handler);
	}
	

	public void selectAndReveal(IEntity entity) {
		IEntityPart entityPart = getEditPartRegistry().get(entity);

		if (entityPart != null) {
			reveal(entityPart);
			select(entityPart);
		}
	}

	public void setContents(Object contents) {
		IEntity root = (IEntity) contents;
		super.setContents(root);
		updateModelObserver(root);
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
}
