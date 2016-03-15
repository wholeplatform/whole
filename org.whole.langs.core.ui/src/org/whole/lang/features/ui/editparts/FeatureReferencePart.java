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
package org.whole.lang.features.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.IFigure;
import org.whole.lang.features.ui.figures.FeatureReferenceFigure;
import org.whole.lang.frames.model.Feature;
import org.whole.lang.frames.model.FeatureReference;
import org.whole.lang.frames.model.Frame;
import org.whole.lang.frames.model.SolitaryFeatureName;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.visitors.GenericIdentityVisitor;
import org.whole.lang.visitors.VisitException;

/**
 * @author Riccardo Solmi
 */
public class FeatureReferencePart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new FeatureReferenceFigure(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				FeatureReference entity = getModelEntity();
				final SolitaryFeatureName referenceName = entity.getName();

				Frame frame = Matcher.findAncestor(FramesEntityDescriptorEnum.Frame, entity);
				if (frame != null) {
					IEntity targetFeature = Matcher.findChild(
							new GenericIdentityVisitor() {
								public void visit(IEntity entity) {
									if (!Matcher.matchImpl(FramesEntityDescriptorEnum.Feature, entity))
										throw new VisitException();

									Feature f = (Feature) entity;
									if (!Matcher.match(referenceName, f.getName()))
										throw new VisitException();
								}
							}, frame.getVariability());

					if (targetFeature != null)
						getViewer().selectAndReveal(targetFeature);
				}
			}
		});
	}

	protected List<IEntity> getModelSpecificChildren() {
		FeatureReference entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(1);
		list.add(entity.getName());
		return list;
	}
}
