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
package org.whole.lang.text.ui.actions;

import java.net.URL;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.e4.ui.actions.AbstractE4Action;
import org.whole.lang.e4.ui.actions.IUIConstants;
import org.whole.lang.model.IEntity;
import org.whole.lang.ui.commands.ModelTextCommand;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.editparts.ModelObserver;
import org.whole.lang.ui.tools.Tools;
import org.whole.lang.ui.util.AnimableRunnable;
import org.whole.lang.ui.viewers.IEntityPartViewer;
import org.whole.lang.util.BehaviorUtils;
import org.whole.lang.util.DataTypeUtils;

/**
 * @author Enrico Persiani
 */
public abstract class AbstractModelTextAction extends AbstractE4Action {
	public AbstractModelTextAction(IEclipseContext context, String label) {
		super(context, label);
		try {
			setImageDescriptor(ImageDescriptor.createFromURL(new URL(IUIConstants.TEXT_ICON_URI)));
		} catch (Exception e) {
		}
	}

	protected abstract String getEnablementUri();
	protected abstract String getBehaviorUri();

	@Override
	public void update() {
		setEnabled(false);

		ESelectionService selectionService = getContext().get(ESelectionService.class);
		if (selectionService.getSelection() instanceof IBindingManager) {
			IBindingManager bm = (IBindingManager) selectionService.getSelection();
			setEnabled(calculateEnabled(bm));
		}
	}

	protected boolean calculateEnabled(IBindingManager bm) {
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		if (!Tools.TEXTUAL.isActive(viewer) ||
				!(ModelObserver.getObserver(bm.wGet("focusEntity"), viewer.getEditPartRegistry()) instanceof ITextualEntityPart))
			return false;

		try {
			bm.wEnterScope();
			defineCaretBindings(bm);
			IEntity result = BehaviorUtils.apply(getEnablementUri(), bm.wGet("self"), bm);
			return result != null && result.wBooleanValue();
		} finally {
			bm.wExitScope();
		}
	}

	@Override
	public void run() {
		ESelectionService selectionService = getContext().get(ESelectionService.class);
		IBindingManager bm = (IBindingManager) selectionService.getSelection();
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		IEntity text = bm.wGet("focusEntity");

		boolean enableAnimation = AnimableRunnable.enableAnimation(false);
		ModelTextCommand mtc = new ModelTextCommand(text);
		try {
			mtc.setLabel(getText());
			mtc.setViewer(viewer);
			mtc.begin();

			try {
				bm.wEnterScope();
				defineCaretBindings(bm);

				IEntity newText = BehaviorUtils.apply(getBehaviorUri(), bm.wGet("self"), bm);

				mtc.setNewSelectedEntity(newText);
				mtc.setNewPosition(bm.wIntValue("caretPosition"));

			} finally {
				bm.wExitScope();
			}


			mtc.commit();
			if (mtc.canUndo()) {
				CommandStack commandStack = viewer.getEditDomain().getCommandStack();
				commandStack.execute(mtc);
			}
		} catch (RuntimeException e) {
			mtc.rollback();
			throw e;
		} finally {
			AnimableRunnable.enableAnimation(enableAnimation);
		}
	}
	
	protected void defineCaretBindings(IBindingManager bm) {
		IEntity text = bm.wGet("focusEntity");
		String textToSplit = DataTypeUtils.getAsPresentationString(text);
		IEntityPartViewer viewer = (IEntityPartViewer) bm.wGetValue("viewer");
		ITextualEntityPart targetPart = (ITextualEntityPart) ModelObserver.getObserver(text, viewer.getEditPartRegistry());

		int start = targetPart.getSelectionStart();
		int end = targetPart.getSelectionEnd();
		if (start == -1 || end == -1)
			start = end = targetPart.getCaretPosition();

		String leftText = textToSplit.substring(0, start);
		String selectedText = textToSplit.substring(start, end);
		String rightText = textToSplit.substring(end);

		bm.wDefValue("leftText", leftText);
		bm.wDefValue("selectedText", selectedText);
		bm.wDefValue("rightText", rightText);
		bm.wDefValue("caretPositions", targetPart.getCaretPositions());
		bm.wDefValue("caretPosition", targetPart.getCaretPosition());
		bm.wDefValue("caretPositionStart", start);
		bm.wDefValue("caretPositionEnd", end);
	}
}
