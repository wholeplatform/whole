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
package org.whole.lang.java.ui.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.whole.lang.java.model.DocElements;
import org.whole.lang.java.model.TagElement;
import org.whole.lang.java.model.TagName;
import org.whole.lang.java.ui.figures.TagElementFigure;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.editparts.AbstractContentPanePart;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class TagElementPart extends AbstractContentPanePart {
	protected IFigure createFigure() {
		return new TagElementFigure();
	}

	protected List<IEntity> getModelSpecificChildren() {
		TagElement tagElement = getModelEntity();
		TagName tagName = tagElement.getTagName();
		DocElements fragments = tagElement.getFragments();
		refreshVisible(tagElement, tagName);
		List<IEntity> list = new ArrayList<IEntity>(2);
		list.add(tagName);
		list.add(fragments);
		return list;
	}

	private void refreshVisible(TagElement tagElement, TagName tagName) {
		((TagElementFigure) getFigure()).showInline(Matcher.findAncestor(tagElement.wGetEntityDescriptor(), tagElement) != null);
		((TagElementFigure) getFigure()).showTagName(!EntityUtils.isResolver(tagName));
	}
}
