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

import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.actions.IEnablerPredicate;
import org.whole.lang.ui.actions.TextualAction;
import org.whole.lang.ui.commands.ModelTextCommand;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/** 
 * @author Enrico Persiani
 */
public class DeleteTextualAction extends TextualAction {
	public static final String ID = DeleteTextualAction.class.getName();

	public DeleteTextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntity prototype, String text) {
		super(part, enablerPredicate, prototype, text);
	}
	public DeleteTextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, EntityDescriptor<?> type, String text) {
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
		if (!EntityUtils.isComposite(parent) || targetPart.getCaretPosition() != targetPart.getCaretPositions())
			return false;

		// check if last entity in model traversal
		IEntityIterator<IEntity> iterator = IteratorFactory.ancestorIterator();
		iterator.reset(parent);
		while (iterator.hasNext()) {
			IEntity ancestor = iterator.next();
			if (ancestor.wIndexOf(parent) != ancestor.wSize()-1)
				return true;
			else
				parent = ancestor;
		}
		return false;
	}

	@Override
	protected void doRun(ITextualEntityPart targetPart, ModelTextCommand command) {
		IEntity text = targetPart.getModelTextEntity();
		EntityDescriptor<?> textED = text.wGetEntityDescriptor();
		IEntity row = targetPart.getParentModelEntity();
		int entityIndex = row.wIndexOf(text);

		command.setLabel("Delete");
		command.setNewSelectedEntity(text);
		command.setNewPosition(targetPart.getCaretPositions());

		// check if last child in row
		if (entityIndex == row.wSize()-1) {
			IEntity document = row.wGetParent();
			int nextRowIndex = document.wIndexOf(row)+1;
			IEntity nextRow = document.wGet(nextRowIndex);

			// check if next row can be merged with this row
			if (EntityUtils.isComposite(nextRow) && !nextRow.wIsEmpty() &&
					row.wGetEntityDescriptor(0).isPlatformSupertypeOf(
							nextRow.wGetEntityDescriptor(0))) {

				int nextRowFirstIndex = 0;
				IEntity nextRowFirstChild = nextRow.wGet(nextRowFirstIndex);
				if (nextRowFirstChild.wGetEntityDescriptor().equals(textED)) {
					// merge with first child of next row
					DataTypeUtils.setFromPresentationString(text,
							DataTypeUtils.getAsPresentationString(text) +
							DataTypeUtils.getAsPresentationString(nextRowFirstChild));

					nextRowFirstIndex++;
				}
				// move remaining next row children to this row
				IEntityIterator<IEntity> iterator = IteratorFactory.childIterator(nextRowFirstIndex);
				iterator.reset(nextRow);
				for (IEntity child : iterator) {
					iterator.remove();
					row.wAdd(child);
				}
			}
			// remove next row
			document.wRemove(nextRow);

		} else {
			IEntity rowNextChild = row.wGet(entityIndex+1);
			if (rowNextChild.wGetEntityDescriptor().equals(textED)) {
				// merge with next child of this row
				DataTypeUtils.setFromPresentationString(text, 
						DataTypeUtils.getAsPresentationString(text) +
						DataTypeUtils.getAsPresentationString(rowNextChild));
			}
			// remove next child of this row
			row.wRemove(rowNextChild);
		}
	}
}
