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
package org.whole.lang.ui.console;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IHyperlink;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.part.FileEditorInput;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.WholeUIPlugin;
import org.whole.lang.ui.editors.WholeGraphicalEditor;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class EntityLocationHyperlink implements IHyperlink {
	private final IFile file;
	private final String location;

	public EntityLocationHyperlink(IFile file, String location) {
		this.file = file;
		this.location = location;
	}

	public void linkActivated() {
		try {
			IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IEditorPart openEditor = activePage.openEditor(new FileEditorInput(file), EditorsUI.DEFAULT_TEXT_EDITOR_ID, true);
			if (openEditor instanceof WholeGraphicalEditor) {
				WholeGraphicalEditor wholeGraphicalEditor = (WholeGraphicalEditor) openEditor;
				final IEntity entity = EntityUtils.getEntity(wholeGraphicalEditor.getRootEntity(), location);
				wholeGraphicalEditor.selectAndReveal(entity);					
			}
		} catch (PartInitException e) {
			WholeUIPlugin.log(e);
		}
	}

	public void linkEntered() {
	}

	public void linkExited() {
	}
}