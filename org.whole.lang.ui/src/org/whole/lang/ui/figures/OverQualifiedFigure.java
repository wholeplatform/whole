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

import org.eclipse.draw2d.Label;
import org.whole.lang.ui.layout.OverLayout;

/**
 * @author Riccardo Solmi
 */
public class OverQualifiedFigure extends EntityFigure {
	public OverQualifiedFigure(String qualifier, String name) {
		this(qualifier, LabelFactory.createDeclaration(name));
	}
	public OverQualifiedFigure(String qualifier, Label nameLabel) {
		this(LabelFactory.createModule(qualifier), nameLabel);
	}
	public OverQualifiedFigure(Label qualifierLabel, Label nameLabel) {
		super(new OverLayout());

		add(nameLabel);
		add(qualifierLabel);
	}
}
