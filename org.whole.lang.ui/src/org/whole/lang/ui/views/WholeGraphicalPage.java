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
package org.whole.lang.ui.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.part.Page;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.codebase.IPersistenceKit;
import org.whole.lang.commons.model.Fragment;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.dialogs.SaveAsModelDialog;
import org.whole.lang.ui.editors.NullEditorPart;
import org.whole.lang.ui.util.ResourceUtils;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class WholeGraphicalPage extends Page {
	public static final String PAGE_ACTIONS = "PageActionsGroup";

	private final WholeGraphicalView view;
	private final WholeGraphicalViewer viewer;
	private Control control;

	public WholeGraphicalPage(WholeGraphicalViewer viewer, final WholeGraphicalView view) {
		this.viewer = viewer;
		this.view = view;
		control = viewer.getControl();
	}

	@Override
	public void init(IPageSite pageSite) {
		super.init(pageSite);
		IActionBars actionBars = pageSite.getActionBars();

		// setup global actions
		ActionRegistry registry = viewer.getActionRegistry();
		List<String> actionIds = new ArrayList<String>();
		for (String actionId  : createGlobalActions(actionIds, registry))
			actionBars.setGlobalActionHandler(actionId, registry.getAction(actionId));

		// create contributions
		createContributions(actionBars);
		actionBars.updateActionBars();
	}

	protected void createContributions(IActionBars actionBars) {
	}

	protected List<String> createGlobalActions(List<String> actions, ActionRegistry registry) {
		actions.add(ActionFactory.CUT.getId());
		actions.add(ActionFactory.COPY.getId());
		actions.add(ActionFactory.PASTE.getId());
		actions.add(ActionFactory.DELETE.getId());
		actions.add(ActionFactory.FIND.getId());
		return actions;
	}

	public void createControl(Composite parent) {
	}

	public Control getControl() {
		return control;
	}

	public void setFocus() {
	}
	
	public void dispose() {
		viewer.dispose();
		super.dispose();
	}

	public WholeGraphicalViewer getViewer() {
		return viewer;
	}

	protected WholeGraphicalView getView() {
		return view;
	}

	protected Action createSaveAsAction(final String namePrefix, final String nameSuffix) {
		Action saveAsAction = new Action("Save as", Action.AS_PUSH_BUTTON) {
			public void run() {
				final Fragment rootFragment = (Fragment) getViewer().getContents().getModel();
				ILanguageKit languageKit = rootFragment.wGetRoot().wGetLanguageKit();
				IPersistenceKit persistenceKit = ReflectionFactory.getDefaultPersistenceKit();

				SaveAsModelDialog dialog = new SaveAsModelDialog(
						getSite().getWorkbenchWindow().getShell(),
						languageKit, persistenceKit);

				IEditorPart editorPart = getViewer().getEditDomain().getEditorPart();
				if (editorPart != null && !(editorPart instanceof NullEditorPart)) {
					IFile editorFile = ResourceUtils.getFile(editorPart.getEditorInput());
					if (editorFile != null) {
						String name =
							namePrefix + StringUtils.stripFileExtension(editorFile.getName()) + nameSuffix +
							"." + persistenceKit.getFileExtension();
						IFile newFile = null;
						IContainer fileContainer = editorFile.getParent();
						if (fileContainer instanceof IFolder)
							newFile = ((IFolder) fileContainer).getFile(name);
						else if (fileContainer instanceof IProject)
							newFile = ((IProject) fileContainer).getFile(name);
						dialog.setOriginalFile(newFile);
					}
				} else
					dialog.setOriginalName(namePrefix + nameSuffix);

				if (dialog.open() != Window.OK)
					return;

				IPath path = dialog.getResult();
				path.toString();
				final IPersistenceKit selectedPersistenceKit = dialog.getPersistenceKit();
				final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);

				try {
					selectedPersistenceKit.writeModel(rootFragment.wGetRoot(), new IFilePersistenceProvider(file));
				}
				catch (Exception e) {
					throw new IllegalArgumentException(e);
				}
			}
		};
		saveAsAction.setImageDescriptor(WholeUIPlugin.getImageDescriptor("icons/actions/save_as.gif"));
		return saveAsAction;
	}

	protected Action createClearAction() {
		Action clearAction = new Action("Clear", Action.AS_PUSH_BUTTON) {
			public void run() {
				getView().setContents(null);
			}
		};
		clearAction.setImageDescriptor(WholeUIPlugin.getImageDescriptor("icons/actions/clear_view.gif"));
		return clearAction;
	}
}
