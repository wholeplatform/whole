/**
 * Copyright 2004-2013 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.text.ui.actions;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.iterators.MatcherIterator;
import org.whole.lang.matchers.GenericMatcherFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
import org.whole.lang.ui.actions.IEnablerPredicate;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.util.CaretUpdater;
import org.whole.lang.ui.util.CaretUtils;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/** 
 * @author Enrico Persiani
 */
public class UpTextualAction extends NavigateTextualAction {
	public static final String ID = UpTextualAction.class.getName();

	public UpTextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntity prototype, String text) {
		super(part, enablerPredicate, prototype, text);
	}
	public UpTextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, EntityDescriptor<?> type, String text) {
		super(part, enablerPredicate, type, text);
	}

	@Override
	protected void init() {
		super.init();
		setId(ID);
	}

	@Override
	protected boolean calculateNavigateEnabled(ITextualEntityPart targetPart) {
		return true;
	}

	@Override
	public void runNavigate() {
		ITextualEntityPart part = getSelectedTextualEntityPart();
		IEntity text = part.getModelTextEntity();

		// try to find a suitable part by location
		GraphicalViewer viewer = getGraphicalViewer();
		Rectangle caretBounds = CaretUtils.getAbsoluteCaretBounds(viewer);
		Point targetLocation = caretBounds.getTopLeft().translate(0, -caretBounds.height);
		ITextualEntityPart targetPart = findTextualEntityPartAt(viewer, targetLocation, part);

		if (targetPart != null)
			CaretUpdater.sheduleSyncUpdate(viewer, targetPart.getModelTextEntity(), targetLocation, true);
		else {
			IEntity row = text.wGetParent();
			if (EntityUtils.isNull(row))
				return;

			IEntity document = row.wGetParent();
			if (EntityUtils.isNull(document))
				return;

			int prevRowIndex = document.wIndexOf(row)-1;
			if (prevRowIndex < 0)
				return;

			IEntity prevRow = document.wGet(prevRowIndex);
			MatcherIterator<IEntity> iterator = IteratorFactory.childReverseMatcherIterator();
			iterator.withPattern(GenericMatcherFactory.instance.hasTypeMatcher(TextEntityDescriptorEnum.Text));
			iterator.reset(prevRow);
			if (!iterator.hasNext())
				return;

			IEntity targetText = iterator.next();
			int newPosition = DataTypeUtils.getAsPresentationString(targetText).length();
			CaretUpdater.sheduleSyncUpdate(viewer, targetText, newPosition, true);
		} 
	}
}
