/**
 * Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.reusables.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.reusables.model.File;
import org.whole.lang.reusables.ui.figures.FileFigure;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.EntityUtils;


/**
 * @author Riccardo Solmi
 */
public class FilePart extends AbstractContentPanePart {
    protected IFigure createFigure() {
    	return new FileFigure(event -> {
        	try {
	        	File entity = getModelEntity();
	        	//FIXME call toResource
//	        	BehaviorUtils.apply();
//	        	Resource resource = entity.getResource();
//	        	if (Matcher.matchImpl(ReusablesEntityDescriptorEnum.Workspace, resource)) {
//	    			Content content = ((Workspace) resource).getContent();
//	    			if (Matcher.matchImpl(ReusablesEntityDescriptorEnum.PathName, resource)) {
//	    	        	IWorkspace workspace = ResourcesPlugin.getWorkspace();
//						IFile file = workspace.getRoot().getFile(Path.fromPortableString(content.wStringValue()));
//		            	E4Utils.openEditor(getViewer().getContext(), file, ReflectionFactory.getDefaultPersistenceKit());
//	    			}
//	        	}
        	} catch (Exception e) {
        	}
        });
    }
	@Override
	public FileFigure getFigure() {
		return (FileFigure) super.getFigure();
	}

    protected List<IEntity> getModelSpecificChildren() {
    	File entity = getModelEntity();
        List<IEntity> children = new ArrayList<IEntity>(3);
        children.add(entity.getPath());
        children.add(entity.getPersistence());
        children.add(entity.getContent());
        return children;
    }

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		refreshVisuals();
		super.propertyChangeUI(evt);
	}

	@Override
	protected void refreshVisuals() {
		File entity = getModelEntity();
		getFigure().showPersistence(!EntityUtils.isResolver(entity.getPersistence()));
	}
}
