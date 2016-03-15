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
package org.whole.lang.actions.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.actions.model.LanguageActionFactory;
import org.whole.lang.actions.ui.figures.LanguageActionFactoryFigure;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;

/**
 * @author Riccardo Solmi
 */
public class LanguageActionFactoryPart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new LanguageActionFactoryFigure();
	}

	protected List<IEntity> getModelSpecificChildren() {
		LanguageActionFactory entity = getModelEntity();
		List<IEntity> list = new ArrayList<IEntity>(7);
		list.add(entity.getUri());
		list.add(entity.getNamespace());
		list.add(entity.getName());
		list.add(entity.getVersion());
		list.add(entity.getTargetLanguage());
		list.add(entity.getToolbarActions());
		list.add(entity.getContextMenuActions());
		return list;
	}
}
