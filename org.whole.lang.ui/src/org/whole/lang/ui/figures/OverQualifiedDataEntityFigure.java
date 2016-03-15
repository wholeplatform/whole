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
package org.whole.lang.ui.figures;

import org.whole.lang.ui.layout.OverLayout;

/**
 * @author Riccardo Solmi
 */
public class OverQualifiedDataEntityFigure extends ContentPaneFigure implements IQualifiedFigure {
	private EntityLabel qualifierLabel;

	public OverQualifiedDataEntityFigure() {
		this(LabelFactory.createModule(), LabelFactory.createDeclaration());
	}
	public OverQualifiedDataEntityFigure(EntityLabel qualifierLabel, EntityLabel nameLabel) {
		super(new OverLayout());
		initContentPanes(1);
		
		add(createContentPane(0, nameLabel));
		add(this.qualifierLabel = qualifierLabel);

		qualifierLabel.setVisible(false);
	}

	public void setQualifierName(String name) {
		if (name != null) {
			qualifierLabel.setVisible(true);
			qualifierLabel.setText(name);
		} else
			qualifierLabel.setVisible(false);
	}

	public EntityLabel getNameLabel() {
		return (EntityLabel) getContentPane(0);
	}
}
