/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.changes.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.changes.model.RevisionFrame;
import org.whole.lang.changes.reflect.ChangesFeatureDescriptorEnum;
import org.whole.lang.changes.ui.figures.RevisionFrameFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.util.EntityUtils;

/**
 *  @author  Riccardo Solmi
 */
public class RevisionFramePart extends AbstractComparePart {
	protected List<CompareMapper> leftMappers = new ArrayList<CompareMapper>();
	protected List<CompareMapper> rightMappers = new ArrayList<CompareMapper>();

    protected IFigure createFigure() {
        return new RevisionFrameFigure(leftMappers, rightMappers);
    }
    @Override
    public RevisionFrameFigure getFigure() {
    	return (RevisionFrameFigure) super.getFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        RevisionFrame entity = getModelEntity();
        List<IEntity> children = new ArrayList<IEntity>(6);
        children.add(entity.getLeftRevisions());
        children.add(entity.getLeftContent());
        children.add(entity.getBaseRevisions());
        children.add(entity.getBaseContent());
        children.add(entity.getRightRevisions());
        children.add(entity.getRightContent());
        return children;
    }

	protected void propertyChangeUI(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(ChangesFeatureDescriptorEnum.leftContent.getName()) ||
				evt.getPropertyName().equals(ChangesFeatureDescriptorEnum.rightContent.getName()))
			refreshVisuals();
		super.propertyChangeUI(evt);
	}

	@Override
	protected void refreshVisuals() {
		RevisionFrame entity = getModelEntity();
		getFigure().showLeftReview(!EntityUtils.isResolver(entity.getLeftContent()));
		getFigure().showRightReview(!EntityUtils.isResolver(entity.getRightContent()));
	}

    @Override
    public void refreshChildren() {
    	super.refreshChildren();

    	RevisionFrame entity = getModelEntity();
    	leftMappers.clear();
    	if (!EntityUtils.isResolver(entity.getLeftContent()))
    		entity.getLeftRevisions().forEach(revision -> {
    			if (revision.wIsAdapter())
    				return;
    			CompareMapper mapper = new CompareMapper();
    			mapper.rebuildRevisionMap(revision);
    			leftMappers.add(mapper);
    		});
    	rightMappers.clear();
        if (!EntityUtils.isResolver(entity.getRightContent()))
    		entity.getRightRevisions().forEach(revision -> {
    			if (revision.wIsAdapter())
    				return;
    			CompareMapper mapper = new CompareMapper();
    			mapper.rebuildRevisionMap(revision);
    			rightMappers.add(mapper);
    		});
    }
}
