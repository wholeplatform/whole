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

import org.eclipse.gef.EditPartViewer;
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
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/** 
 * @author Enrico Persiani
 */
public class LeftTextualAction extends NavigateTextualAction {
	public static final String ID = LeftTextualAction.class.getName();

	public LeftTextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntity prototype, String text) {
		super(part, enablerPredicate, prototype, text);
	}
	public LeftTextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, EntityDescriptor<?> type, String text) {
		super(part, enablerPredicate, type, text);
	}

	@Override
	protected void init() {
		super.init();
		setId(ID);
	}
	
	@Override
	protected boolean calculateNavigateEnabled(ITextualEntityPart targetPart) {
		return targetPart.getCaretPosition() == 0;
	}

	public void runNavigate() {
		ITextualEntityPart targetPart = getSelectedTextualEntityPart();

		IEntity text = targetPart.getModelTextEntity();
		IEntity root = EntityUtils.getCompoundRoot(text);

		// get previous text element and update caret
		MatcherIterator<IEntity> iterator = IteratorFactory.descendantOrSelfReverseMatcherIterator();
		iterator.withPattern(GenericMatcherFactory.instance.hasTypeMatcher(TextEntityDescriptorEnum.Text));
		iterator.reset(root);
		iterator.skipToSame(text);
		iterator.next();
		if (!iterator.hasNext())
			return;

		IEntity prevText = iterator.next();
		int newPosition = DataTypeUtils.getAsPresentationString(prevText).length();
		EditPartViewer viewer = targetPart.getViewer();
		CaretUpdater.sheduleSyncUpdate(viewer, prevText, newPosition, true);
	}
}
