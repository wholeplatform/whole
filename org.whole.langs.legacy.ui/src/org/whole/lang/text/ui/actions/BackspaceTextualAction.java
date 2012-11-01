/**
 * Copyright 2004-2012 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
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
public class BackspaceTextualAction extends TextualAction {
	public static final String ID = BackspaceTextualAction.class.getName();

	public BackspaceTextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntity prototype, String text) {
		super(part, enablerPredicate, prototype, text);
	}
	public BackspaceTextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, EntityDescriptor<?> type, String text) {
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
		if (!EntityUtils.isComposite(parent) || targetPart.getCaretPosition() != 0)
			return false;
		
		// check if not first entity in model traversal
		IEntityIterator<IEntity> iterator = IteratorFactory.ancestorIterator();
		iterator.reset(parent);
		while (iterator.hasNext()) {
			IEntity ancestor = iterator.next();
			if (ancestor.wIndexOf(parent) != 0)
				return true;
			else
				parent = ancestor;
		}
		return false;
	}

	@Override
	protected void doRun(ITextualEntityPart targetPart, ModelTextCommand command) {
		IEntity text = targetPart.getModelTextEntity();

		command.setLabel("Backspace");
		command.setNewSelectedEntity(text);
		command.setNewPosition(0);

		EntityDescriptor<?> textED = text.wGetEntityDescriptor();
		IEntity row = targetPart.getParentModelEntity();
		int entityIndex = row.wIndexOf(text);
		EditPartViewer viewer = targetPart.getViewer();

		// check if first child in row
		if (entityIndex == 0) {
			IEntity document = row.wGetParent();
			int rowIndex = document.wIndexOf(row);
			IEntity prevRow = document.wGet(rowIndex-1);

			// check if previous row can be merged with this row
			if (EntityUtils.isComposite(prevRow) && !prevRow.wIsEmpty() && 
					row.wGetEntityDescriptor(0).isPlatformSupertypeOf(
							prevRow.wGetEntityDescriptor(0))) {

				int prevRowLastIndex = prevRow.wSize()-1;
				IEntity prevRowLastChild = prevRow.wGet(prevRowLastIndex);
				if (prevRowLastChild.wGetEntityDescriptor().equals(textED)) {
					// merge with last child of previous row
					String toMerge = DataTypeUtils.getAsPresentationString(prevRowLastChild);
					int newPosition = toMerge.length();
					CaretUpdater.createCU(viewer, text, newPosition).sheduleAsyncUpdate();
					DataTypeUtils.setFromPresentationString(text, 
							toMerge + DataTypeUtils.getAsPresentationString(text));

					prevRowLastIndex--;

					command.setNewPosition(newPosition);
				}
				// move remaining previous row children to this row
				IEntityIterator<IEntity> iterator = IteratorFactory.childReverseIterator(prevRowLastIndex);
				iterator.reset(prevRow);
				for (IEntity child : iterator) {
					iterator.remove();
					row.wAdd(0, child);
				}
			}
			// delete previous row
			document.wRemove(prevRow);

		} else {
			IEntity rowPrevChild = row.wGet(entityIndex-1);
			if (rowPrevChild.wGetEntityDescriptor().equals(textED)) {
				// merge with previous child of this row
				String toMerge = DataTypeUtils.getAsPresentationString(rowPrevChild);
				int newPosition = toMerge.length();
				CaretUpdater.createCU(viewer, text, newPosition).sheduleAsyncUpdate();
				DataTypeUtils.setFromPresentationString(text, toMerge + DataTypeUtils.getAsPresentationString(text));

				command.setNewPosition(newPosition);
			}
			// remove previous child of this row
			row.wRemove(rowPrevChild);
		}
	}
}
