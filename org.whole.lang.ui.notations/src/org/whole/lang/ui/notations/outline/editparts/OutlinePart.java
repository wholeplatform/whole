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
package org.whole.lang.ui.notations.outline.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.ui.notations.outline.figures.OutlineCompositeNodeFigure;
import org.whole.lang.ui.notations.outline.figures.OutlineLeafFigure;
import org.whole.lang.ui.notations.outline.figures.OutlineSimpleNodeFigure;
import org.whole.lang.ui.templates.IOutlineUIProvider;
import org.whole.lang.ui.templates.OutlineKinds;
import org.whole.lang.ui.templates.OutlinePartDataProvider;

/**
 * @author Riccardo Solmi
 */
public class OutlinePart extends AbstractContentPanePart {
	private IOutlineUIProvider provider;

	public OutlinePart(IOutlineUIProvider provider) {
		this.provider = provider;
	}
	public OutlinePart(OutlineKinds kind, boolean startOpened, String text, Image image, FeatureDescriptor... features) {
		this(new OutlinePartDataProvider(kind, startOpened, text, image, features));
	}

    protected IFigure createFigure() {
    	IEntity e = getModelEntity();
    	switch (provider.getTemplateKind(e)) {
    	case LEAF:
    		return new OutlineLeafFigure(provider.getImage(e));
    	case COMPOSITE_NODE:
    		return new OutlineCompositeNodeFigure(provider.startOpened(e), provider.getImage(e), provider.getText(e));
    	default:
    	case SIMPLE_NODE:
    		return new OutlineSimpleNodeFigure(provider.startOpened(e), provider.getImage(e), provider.getText(e), provider.getFeatures(e));
    	}
    }

	protected List<IEntity> getModelSpecificChildren() {
    	IEntity e = getModelEntity();
		FeatureDescriptor[] fd = provider.getFeatures(e);
		List<IEntity> list = new ArrayList<IEntity>(fd.length);
		for (int i=0; i<fd.length; i++)
			list.add(e.wGet(fd[i]));
		return list;
	}
}
