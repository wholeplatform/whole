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
package org.whole.lang.ui.actions;


import java.lang.reflect.Method;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class ModelCopyEntityPathAction extends AbstractClipboardAction {
	private Method createRootPathMethod = null;

	public ModelCopyEntityPathAction(IWorkbenchPart part) {
		super(part);

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_COPY_DISABLED));
		setId("copy entity path");
		setText("Copy Entity Path");

		try {
			Class<?> queryUtilsClass = Class.forName("org.whole.lang.queries.util.QueriesUtils", true, ReflectionFactory.getPlatformClassLoader());
			createRootPathMethod = queryUtilsClass.getMethod("createRootPath", new Class[] {IEntity.class});
		} catch (Exception e) {
		}
	}

	@Override
	protected boolean calculateEnabled() {
		return super.calculateEnabled() &&
			ReflectionFactory.hasLanguageKit("http://lang.whole.org/Queries", false, null) &&
				getSelectedObjects().size() == 1;
	}

	public void run() {
		IEntity entity = getSelectedEntityParts().get(0).getModelEntity();

		GraphicalViewer viewer = getViewer();

		IEntity path = null;
		try {
			path = (IEntity) createRootPathMethod.invoke(null, entity);
		} catch (Exception e) {
		}

		String location = EntityUtils.getLocation(entity);
		if (path != null)
			Clipboard.instance().setEntityContents(path);
		else
			Clipboard.instance().setTextContents(location);

		// force selection state change for clipboard actions enablement calculation
		viewer.setSelection(viewer.getSelection());
	}
}
