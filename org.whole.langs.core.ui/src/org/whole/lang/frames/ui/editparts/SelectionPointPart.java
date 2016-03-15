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
package org.whole.lang.frames.ui.editparts;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Toggle;
import org.whole.lang.frames.model.ConditionPoint;
import org.whole.lang.frames.model.SelectionPoint;
import org.whole.lang.frames.model.Variants;
import org.whole.lang.frames.model.VariationPoint;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.ui.figures.SelectionPointFigure;
import org.whole.lang.frames.util.FramesUtils;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;

/**
 * @author Riccardo Solmi
 */
public class SelectionPointPart extends AbstractContentPanePart {
	protected boolean showVariability;

	protected IFigure createFigure() {
		return new SelectionPointFigure(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				boolean showVariabilityNew = !((Toggle) event.getSource()).isSelected();
				if (showVariability != showVariabilityNew) {
					showVariability = showVariabilityNew;
					refresh();
				}
			}
		});
	}
	@Override
	public SelectionPointFigure getFigure() {
		return (SelectionPointFigure) super.getFigure();
	}

	@Override
	protected void propertyChangeUI(PropertyChangeEvent evt) {
		super.propertyChangeUI(evt);
		
		if (evt.getPropertyName().equals("selector"))
			refreshVisuals();
	}

	@Override
	protected void refreshVisuals() {
		SelectionPoint entity = getModelEntity();
		IEntity selector = entity.getSelector();
		if (Matcher.matchImpl(FramesEntityDescriptorEnum.FeatureName, selector))
			getFigure().setToolTip(new Label(selector.wStringValue()));//FIXME multiple annotations			
//		addDecoration(kind, tooltip);
	}

	protected List<IEntity> getModelSpecificChildren() {
		SelectionPoint entity = getModelEntity();
		
		IEntity selection = showVariability ? null : FramesUtils.getActiveVariationPoint(entity);
		getFigure().showActive(selection != null);
		
		Variants variants = entity.getVariants();
		IEntity variant = null;
		for (int i=0, size=variants.size(); i<size; i++)
			if ((variant = FramesUtils.getActiveVariationPoint((VariationPoint) variants.wGet(i))) != null) {
				if (variant instanceof ConditionPoint)
					variant = ((ConditionPoint) variant).getContent();
				break;
			}

		List<IEntity> children = new ArrayList<IEntity>(2);
		children.add(entity.getSelector());
		children.add(showVariability || variant == null ? entity.getVariants() : variant);
		return children;
	}
}
