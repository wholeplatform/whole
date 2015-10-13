/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.queries.ui.figures;

import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.figures.EntityLabel;
import org.whole.lang.ui.figures.IQualifiedFigure;
import org.whole.lang.ui.figures.LabelFactory;
import org.whole.lang.ui.layout.OverLayout;

/**
 * @author Riccardo Solmi
 */
public class FeatureStepFigure extends ContentPaneFigure implements IQualifiedFigure {
	private EntityLabel languageLabel;

	public FeatureStepFigure() {
		super(new OverLayout());
		initContentPanes(1);
		
		add(createContentPane(0, LabelFactory.createContent()));
		add(languageLabel = LabelFactory.createModule());

		languageLabel.setVisible(false);
	}

	public void setQualifierName(String name) {
		if (name != null) {
			languageLabel.setVisible(true);
			languageLabel.setText(name);
		} else
			languageLabel.setVisible(false);
	}
	public EntityLabel getNameLabel() {
		return (EntityLabel) getContentPane(0);
	}
}
