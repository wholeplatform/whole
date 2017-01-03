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
package org.whole.lang.e4.ui.compatibility;

import static org.whole.lang.e4.ui.actions.IE4UIConstants.*;

import java.util.EventObject;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.tools.compat.parts.DIEditorPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CommandStackListener;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPersistableEditor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.e4.ui.actions.RedoAction;
import org.whole.lang.e4.ui.actions.UndoAction;
import org.whole.lang.e4.ui.input.ModelInput;
import org.whole.lang.e4.ui.parts.E4GraphicalPart;
import org.whole.lang.e4.ui.util.E4Utils;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.dialogs.IImportAsModelDialogFactory;
import org.whole.lang.ui.dialogs.ImportAsModelDialogFactory;
import org.whole.lang.ui.input.IModelInput;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.util.StringUtils;
import org.whole.langs.core.CoreMetaModelsDeployer;

/**
 * @author Enrico Persiani
 */
@SuppressWarnings("restriction")
public class EditorPart extends DIEditorPart<E4GraphicalPart> implements IPersistableEditor, IGotoMarker {
	protected CommandStackListener listener;
	protected UndoAction undoAction;
	protected RedoAction redoAction;
	protected ResourceChangeListener resourceListener;

	public EditorPart() {
		super(E4GraphicalPart.class, CUT | COPY | PASTE);
	}

	@Override
	public void createPartControl(Composite parent) {
		IImportAsModelDialogFactory factory = ContextInjectionFactory.make(ImportAsModelDialogFactory.class, getContext());
		getContext().set(IImportAsModelDialogFactory.class, factory);

		super.createPartControl(parent);

		getContext().get(MPart.class).setElementId("org.eclipse.e4.ui.compatibility.editor");

		setPartName(getEditorInput().getName());

		final IEntityPartViewer viewer = getComponent().getViewer();
		viewer.getCommandStack().addCommandStackListener(listener = new CommandStackListener() {
			public void commandStackChanged(EventObject event) {
				setDirtyState(viewer.isDirty());
			}
		});

		undoAction = new UndoAction(getContext(), UNDO_LABEL);
		undoAction.update();

		redoAction = new RedoAction(getContext(), REDO_LABEL);
		redoAction.update();

		if (getEditorInput() instanceof IFileEditorInput) {
			IWorkspace workspace = ((IFileEditorInput) getEditorInput()).getFile().getWorkspace();
			workspace.addResourceChangeListener(resourceListener = new ResourceChangeListener());
		}
	}

	@Override
	public void setFocus() {
		IActionBars actionBars = getEditorSite().getActionBars();
		actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), undoAction);
		actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), redoAction);
		super.setFocus();
	}

	public void gotoMarker(IMarker marker) {
		try {
			//FIXME MarkerUtils.MARKER_TYPE
			if (!marker.isSubtypeOf("org.whole.lang.ui.wholemarker"))
				return;
		} catch (CoreException e) {
			return;
		}
		String locationPath = marker.getAttribute("uri", "/");
		IEntity entity = EntityUtils.getEntity(getComponent().getViewer().getEntityContents(), locationPath);
		if (entity != null)
			getComponent().getViewer().selectAndReveal(entity);
	}

	@Override
	public boolean isSaveAsAllowed() {
		return !CoreMetaModelsDeployer.STATUS_URI.equals(
				getComponent().getViewer().getEntityContents().wGetLanguageKit().getURI());
	}

	@Override
	public void doSaveAs() {
		IEntity entityContents = getComponent().getViewer().getEntityContents();
		Set<IPersistenceKit> persistenceKits = new HashSet<IPersistenceKit>();
		for (IPersistenceKit persistenceKit : ReflectionFactory.getPersistenceKits())
			if (persistenceKit.canApply(entityContents))
				persistenceKits.add(persistenceKit);

		SaveAsModelDialog dialog = new SaveAsModelDialog(
				getSite().getWorkbenchWindow().getShell(), getContext(), persistenceKits);

		if (dialog.open() == Dialog.CANCEL)
			return;

		IPersistenceKit persistenceKit = dialog.getPersistenceKit();
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(dialog.getResult());

		try {
			// perform save to new file
			IFilePersistenceProvider pp = new IFilePersistenceProvider(file);
			persistenceKit.writeModel(entityContents, pp);

			// update default editor in package explorer
			IDE.setDefaultEditor(file, ReflectionFactory.getEditorIdFromPersistenceKit(persistenceKit));

			// update model input
			getContext().set(IModelInput.class, new ModelInput(getContext(), pp, persistenceKit.getId()));

			// update editor input
			setInputWithNotify(new FileEditorInput(file));

			// update editor's tab label
			setPartName(file.getName());

			// reset entity contents command stack and dirty state
			getComponent().getViewer().setEntityContents(entityContents);
		} catch (Exception e) {
			E4Utils.reportError(getContext(), "Write Model errors", StringUtils.errorMessage(e), e);
		}
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public  <T> T getAdapter(Class<T> adapter) {
		if (adapter == GraphicalViewer.class)
			return (T) getComponent().getViewer();
		else if (adapter == ZoomManager.class)
			return (T) getComponent().getViewer().getProperty(ZoomManager.class.toString());
		else if (adapter == CommandStack.class)
			return (T) getComponent().getViewer().getCommandStack();
		else
			return super.getAdapter(adapter);
	}

	@Override
	public void dispose() {
		if (listener != null)
			getComponent().getViewer().getCommandStack().removeCommandStackListener(listener);
		if (undoAction != null)
			undoAction.dispose();
		if (redoAction != null)
			redoAction.dispose();
		if (resourceListener != null) {
			IWorkspace workspace = ((IFileEditorInput) getEditorInput()).getFile().getWorkspace();
			workspace.removeResourceChangeListener(resourceListener);
		}
		super.dispose();
	}

	@Override
	public void saveState(IMemento memento) {
		getComponent().saveState();
	}

	@Override
	public void restoreState(IMemento memento) {
	}

	public class ResourceChangeListener implements IResourceChangeListener {
		public void resourceChanged(IResourceChangeEvent event) {
			if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
				IFile file = ((IFileEditorInput) getEditorInput()).getFile();
				IResourceDelta member = event.getDelta().findMember(file.getFullPath());
				if (member == null || member.getKind() != IResourceDelta.REMOVED)
					return;

				if ((member.getFlags() & IResourceDelta.MOVED_TO) != 0) {
					IFile destination = file.getWorkspace().getRoot().getFile(member.getMovedToPath());
					setInput(new FileEditorInput(destination));

					getEditorSite().getShell().getDisplay().asyncExec(new Runnable() {
						public void run() {
							setPartName(getEditorInput().getName());
						}
					});
				} else if (member.getFlags() == 0) {
					getEditorSite().getShell().getDisplay().asyncExec(new Runnable() {
						public void run() {
							IWorkbenchWindow window = getEditorSite().getWorkbenchWindow();
							IWorkbenchPage page = window.getActivePage();	
							page.activate(EditorPart.this);
							page.closeEditor(EditorPart.this, false);
						}
					});
				}
			}
		}
	}
}
