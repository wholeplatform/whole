/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.reusables.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.reusables.model.Reuse;
import org.whole.lang.e4.ui.jobs.InterpretModelRunnable;
import org.whole.lang.e4.ui.jobs.RunnableJob;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.EntityUtils;
import org.whole.lang.reusables.ui.figures.ReuseFigure;

/**
 *  @generator Whole
 */
public class ReusePart extends AbstractContentPanePart {

    protected IFigure createFigure() {
        return new ReuseFigure();
    }

    protected List<IEntity> getModelSpecificChildren() {
        Reuse entity = getModelEntity();
//FIXME
//        if (EntityUtils.isResolver(entity.getAdapted())) {
//        	InterpretModelRunnable runnable = new InterpretModelRunnable(
//        			getViewer().getContext(), getViewer().getContextBindings(), "Derive reusable");
//        	if (runnable.getBindings().wIsSet("self"))
//        		runnable.getBindings().wSet("self", entity);
//        	else {
//        		runnable.getBindings().wDef("self", entity);
//        		runnable.getBindings().wDefValue("viewer", getViewer());
//        	}
//        	
//    		final RunnableJob job = new RunnableJob("Executing Reuse operation...", runnable);
//    		job.setUser(false);
//    		job.setPriority(Job.INTERACTIVE);
//    		job.schedule();
//        }

        List<IEntity> children = new ArrayList<IEntity>(5);
        children.add(entity.getSource());
        children.add(entity.getOriginal());
        children.add(entity.getAdapter());
        children.add(entity.getAdapted());
        children.add(entity.getAdaptedRevision());
        return children;
    }
}
