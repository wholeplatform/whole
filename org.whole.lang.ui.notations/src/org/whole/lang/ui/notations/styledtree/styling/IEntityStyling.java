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
package org.whole.lang.ui.notations.styledtree.styling;

import org.whole.lang.reflect.EntityKinds;
import org.whole.lang.ui.notations.styledtree.styling.EntityStyling.LayoutStyle;
import org.whole.lang.ui.notations.styledtree.styling.EntityStyling.TypeStyle;

/**
 * @author Riccardo Solmi
 */
public interface IEntityStyling {
	public INotationStyling getNotationStyling();

	//TODO ? move to notation styling
	public TypeStyle getTypeStyle();
	public String getTypeIdentifier();
	public String getTypeLabel();

	public EntityKinds getKind();//TODO ? merge with layoutStyle
	public LayoutStyle getLayoutStyle();

	public boolean embedChild(int index);
	public int getEmbeddedFeaturesSize();
	public IFeatureStyling[] getFeaturesStyling();
}
