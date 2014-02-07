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

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gef.commands.CommandStack;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.IUIConstants;
import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.model.IEntity;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
import org.whole.lang.ui.commands.ModelTransactionCommand;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.util.AnimableRunnable;
import org.whole.lang.ui.util.CaretUpdater;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.DataTypeUtils;
import org.whole.lang.util.EntityUtils;

/**
 * @author Enrico Persiani
 */
public class SplitOnCaretAction extends AbstractTextAction {
	public SplitOnCaretAction(IEclipseContext context) {
		super(context, IUIConstants.SPLIT_ON_CARET_LABEL);
	}

	@Override
	protected boolean calculateEnabled(IBindingManager bm) {
		IEntity primarySelectedEntity = bm.wGet("focusEntity");
		IEntity parent = primarySelectedEntity.wGetParent();
		return !EntityUtils.isNull(parent) &&
				EntityUtils.isData(primarySelectedEntity) &&
				EntityUtils.isAddable(parent, TextEntityDescriptorEnum.IText);
	}

	@Override
	public void run() {
		ESelectionService selectionService = getContext().get(ESelectionService.class);
		IBindingManager bm = (IBindingManager) selectionService.getSelection();
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		IEntity text = bm.wGet("focusEntity");
		IEntity row = text.wGetParent();
		ITextualEntityPart targetPart = (ITextualEntityPart) viewer.getEditPartRegistry().get(text);

		boolean enableAnimation = AnimableRunnable.enableAnimation(false);
		ModelTransactionCommand mtc = new ModelTransactionCommand(text);
		try {
			mtc.setLabel("split on caret");
			mtc.begin();


			String textToSplit = DataTypeUtils.getAsPresentationString(text);
			int splitPosition = targetPart.getCaretPosition();
			String left = textToSplit.substring(0, splitPosition);
			String right = textToSplit.substring(splitPosition);

			IEntity newText = GenericEntityFactory.instance.create(text.wGetEntityDescriptor(), right);
			DataTypeUtils.setFromPresentationString(text, left);
			row.wAdd(row.wIndexOf(text)+1, newText);
			
			mtc.commit();
			if (mtc.canUndo()) {
				CommandStack commandStack = viewer.getEditDomain().getCommandStack();
				commandStack.execute(mtc);
				CaretUpdater.createCU(viewer, newText, 0).sheduleAsyncUpdate();
			}
		} catch (RuntimeException e) {
			mtc.rollback();
			throw e;
		} finally {
			AnimableRunnable.enableAnimation(enableAnimation);
		}
	}
}
