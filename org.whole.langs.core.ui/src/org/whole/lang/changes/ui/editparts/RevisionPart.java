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
import org.whole.lang.bindings.BindingManagerFactory;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.changes.model.Revision;
import org.whole.lang.changes.ui.figures.RevisionFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.EntityUtils;

/**
 *  @author  Riccardo Solmi
 */
public class RevisionPart extends AbstractContentPanePart {

    protected IFigure createFigure() {
        return new RevisionFigure();
    }
    @Override
    public RevisionFigure getFigure() {
    	return (RevisionFigure) super.getFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        Revision entity = getModelEntity();
        List<IEntity> children = new ArrayList<IEntity>(1);
        children.add(entity.getRevisor());
        return children;
    }

    @Override
    protected void propertyChangeUI(PropertyChangeEvent evt) {
		refreshVisuals();
		super.propertyChangeUI(evt);
    }

    @Override
    protected void refreshVisuals() {
    	int index = 0, additions = 0, deletions = 0;

    	Revision entity = getModelEntity();
    	if (EntityUtils.hasParent(entity))
    		index = entity.wGetParent().wIndexOf(entity);

    	try {
	    	IBindingManager bm = BindingManagerFactory.instance.createArguments();
			IEntity result = BehaviorUtils.apply(
					"whole:org.whole.lang.changes:RevisionsLibrarySemantics#revisionSummary", entity, bm);
			additions = result.wGet(0).wIntValue();
			deletions = result.wGet(1).wIntValue();
    	} catch (Exception e) {
    	}

        getFigure().updateData(index, additions, deletions);
    }
}
