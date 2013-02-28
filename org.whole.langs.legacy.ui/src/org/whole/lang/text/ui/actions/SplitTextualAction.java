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
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.text.factories.TextEntityFactory;
import org.whole.lang.text.model.Text;
import org.whole.lang.ui.actions.IEnablerPredicate;
import org.whole.lang.ui.actions.TextualAction;
import org.whole.lang.ui.commands.ModelTextCommand;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.util.CaretUpdater;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/** 
 * @author Enrico Persiani
 */
public class SplitTextualAction extends TextualAction {
	public static final String ID = SplitTextualAction.class.getName();

	public SplitTextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntity prototype, String text) {
		super(part, enablerPredicate, prototype, text);
	}
	public SplitTextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, EntityDescriptor<?> type, String text) {
		super(part, enablerPredicate, type, text);
	}

	@Override
	protected void init() {
		super.init();
		setId(ID);
	}

	@Override
	protected boolean calculateEnabled(ITextualEntityPart targetPart) {
		IEntity parent = targetPart.getParentModelEntity();
		return !EntityUtils.isNull(parent) &&
				EntityUtils.isComposite(parent);
	}

	@Override
	protected void doRun(ITextualEntityPart targetPart, ModelTextCommand command) {
		IEntity text = targetPart.getModelTextEntity();
		IEntity row = targetPart.getParentModelEntity();
		EditPartViewer viewer = targetPart.getViewer();

		command.setLabel("Split");
		command.setNewPosition(0);

		// split text entity
		int splitPosition = targetPart.getCaretPosition();
		String toSplit = DataTypeUtils.getAsPresentationString(text);
		String left = toSplit.substring(0, splitPosition);
		String right = toSplit.substring(splitPosition);
		DataTypeUtils.setFromPresentationString(text, left);
		Text newText = TextEntityFactory.instance.createText(right);

		// append right text to this row
		CaretUpdater.createCU(viewer, newText, 0).sheduleAsyncUpdate();
		int rowNextChildIndex = row.wIndexOf(text)+1;
		row.wAdd(rowNextChildIndex, newText);

		command.setNewSelectedEntity(newText);
	}
}
