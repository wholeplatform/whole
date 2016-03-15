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
package org.whole.lang.grammarbased.ui.figures;

import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.ui.figures.ContentPaneFigure;
import org.whole.lang.ui.layout.Alignment;
import org.whole.lang.ui.layout.RowLayout;
import org.whole.lang.ui.layout.TableRowLayout;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class SimpleEntityFigure extends ContentPaneFigure {
	public SimpleEntityFigure(IEntity configuration) {
		super(new RowLayout());

		FeatureDescriptorEnum fdEnum = configuration.wGetLanguageKit().getFeatureDescriptorEnum();
		IEntity panes = configuration.wGet(fdEnum.valueOf("panes"));

		initContentPanes(EntityUtils.safeIntValue(panes, -1));
		IEntity contents = configuration.wGet(fdEnum.valueOf("contents"));
		GrammarBasedUIUtils.addChildFigure(contents, this, this, true);

		IEntity table = configuration.wGet(fdEnum.valueOf("table"));
		if (EntityUtils.safeBooleanValue(table, false))
			setLayoutManager(new TableRowLayout().withMinorAlignment(Alignment.LEADING));
	}
}
