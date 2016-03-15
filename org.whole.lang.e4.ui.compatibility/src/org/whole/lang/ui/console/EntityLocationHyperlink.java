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
package org.whole.lang.ui.console;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IHyperlink;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.e4.ui.E4CompatibilityPlugin;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.input.IModelInput;
import org.whole.lang.ui.viewers.IEntityPartViewer;
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
			IEclipseContext context = (IEclipseContext) PlatformUI.getWorkbench().getService(IEclipseContext.class);
			EPartService partService = context.get(EPartService.class);
			Collection<MPart> parts = partService.getParts();
			for (MPart part : parts) {
				IEclipseContext partContext = part.getContext();
				if (partContext == null)
					continue;
				IModelInput modelInput = partContext.get(IModelInput.class);
				if (modelInput != null && ((IFilePersistenceProvider) modelInput.getPersistenceProvider()).getStore().equals(file)) {
					partService.activate(part, true);
					IEntityPartViewer viewer = partContext.get(IEntityPartViewer.class);
					IEntity entityContents = viewer.getEntityContents();
					final IEntity entity = EntityUtils.getEntity(entityContents, location);
					viewer.selectAndReveal(entity);
				}
			}
		} catch (Exception e) {
			E4CompatibilityPlugin.log(e);
		}
	}

	public void linkEntered() {
	}

	public void linkExited() {
	}
}