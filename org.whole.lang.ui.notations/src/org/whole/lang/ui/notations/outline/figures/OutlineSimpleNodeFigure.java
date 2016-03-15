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
package org.whole.lang.ui.notations.outline.figures;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.swt.graphics.Image;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.ui.figures.EntityFigure;
import org.whole.lang.ui.figures.IEntityFigure;
import org.whole.lang.ui.layout.ColumnLayout;
import org.whole.lang.ui.layout.IEntityLayout;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class OutlineSimpleNodeFigure extends AbstractOutlineSimpleNodeFigure {
	public OutlineSimpleNodeFigure(boolean startOpened, Image image, FeatureDescriptor... features) {
		this(startOpened, image, null, features);
	}
	public OutlineSimpleNodeFigure(boolean startOpened, Image image, String label, FeatureDescriptor... features) {
		super(startOpened, features.length);

		EntityFigure labelContainer = getLabelFigure();
		if (label == null) {
			labelContainer.addLabel(image);
			labelContainer.add(createContentPane(0));
		} else
			labelContainer.addLabel(label, image);

		IFigure featuresContainer = getFeaturesContainer();
		IEntityLayout layout = new ColumnLayout().withMarginLeft(16);
		featuresContainer.setLayoutManager(layout);
		add(featuresContainer);

		bindFoldingToggle(-1, 0);
		int startingIndex = (label == null ? 1 : 0); // check if content pane for the label feature already created
		for (int i=startingIndex; i<features.length; i++) {
			IEntityFigure featureFigure = new OutlineCompositeNodeFigure(true, null, features[i].getName());
			featuresContainer.add(createNestedContentPanes(i, featureFigure));
			bindFoldingToggle(0, i);
		}
	}

	private IFigure featuresContainer;
	protected IFigure getFeaturesContainer() {
		if (featuresContainer == null)
			featuresContainer = new EntityFigure(new ColumnLayout());
		return featuresContainer;
	}


//	@Override
//	public List<Toggle> getFoldingToggles(IFigure figure) {
//		List<Toggle> result = new ArrayList<Toggle>();
//		if (!getContentPane(0).getChildren().contains(figure))
//			result.add(getFoldingToggle(0));
//		return result;
//	}

	@Override
	protected void toggleVisibility(int paneIndex) {
		getFeaturesContainer().setVisible(!getFeaturesContainer().isVisible());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<IFigure> getContents() {
		return getFeaturesContainer().getChildren();
	}

	@Override
	protected boolean isContentVisible() {
		return getFeaturesContainer().isVisible();
	}
}
