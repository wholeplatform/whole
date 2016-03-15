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

import java.util.List;

import org.whole.lang.frames.model.SelectionPoint;
import org.whole.lang.frames.model.Variants;
import org.whole.lang.frames.model.VariationPoint;
import org.whole.lang.frames.reflect.FramesEntityDescriptorEnum;
import org.whole.lang.frames.ui.figures.VariantsTableFigure;
import org.whole.lang.frames.util.FramesUtils;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.TablePart;
import org.whole.lang.ui.figures.TableFigure;

/**
 * @author Riccardo Solmi
 */
public class VariantsTablePart extends TablePart {
	protected TableFigure createFigure() {
		return new VariantsTableFigure();
    }
	@Override
	public VariantsTableFigure getFigure() {
		return (VariantsTableFigure) super.getFigure();
	}

	@Override
	protected List<IEntity> getModelChildren() {
		Variants variants = getModelEntity();
//		IEntity selectionPoint = variants.wGetParent();
		
		int variantIndex = -1;
		for (int i=0, size=variants.size(); i<size; i++)
			if (FramesUtils.getActiveVariationPoint((VariationPoint) variants.wGet(i)) != null) {
				variantIndex = i;
				break;
			}

//		IEntity variant = null;
//		if (Matcher.matchImpl(FramesEntityDescriptorEnum.SelectionPoint, selectionPoint))
//			variant = FramesUtils.getActiveVariationPoint((SelectionPoint) selectionPoint);
//		int variantIndex = variant == null ? -1 : variants.wIndexOf(variant.wGetParent());
		getFigure().showActive(variantIndex);

		return super.getModelChildren();
	}
}
