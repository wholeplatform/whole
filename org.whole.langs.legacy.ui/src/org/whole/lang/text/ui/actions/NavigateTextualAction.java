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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.matchers.Matcher;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
import org.whole.lang.ui.actions.IEnablerPredicate;
import org.whole.lang.ui.actions.TextualAction;
import org.whole.lang.ui.editparts.ITextualEntityPart;

/** 
 * @author Enrico Persiani
 */
public class NavigateTextualAction extends TextualAction {
	public static final String ID = NavigateTextualAction.class.getName();
	private SelectionAction selectionRangeAction;

	public NavigateTextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntity prototype, String text) {
		super(part, enablerPredicate, prototype, text);
	}
	public NavigateTextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, EntityDescriptor<?> type, String text) {
		super(part, enablerPredicate, type, text);
	}

	public SelectionAction getSelectionRangeAction() {
		return selectionRangeAction;
	}
	public void setSelectionRangeAction(SelectionAction selectionRangeAction) {
		this.selectionRangeAction = selectionRangeAction;
	}

	protected static final EditPartViewer.Conditional textConditional = new EditPartViewer.Conditional() {
		public boolean evaluate(EditPart editPart) {
			if (!(editPart instanceof ITextualEntityPart))
				return false;
			ITextualEntityPart part = (ITextualEntityPart) editPart;
			IEntity entity = part.getModelTextEntity();
			return Matcher.matchImpl(TextEntityDescriptorEnum.Text, entity);
		}
	};

	protected ITextualEntityPart findTextualEntityPartAt(GraphicalViewer viewer, Point targetLocation, EditPart... exclusions) {
		Set<EditPart> exclusionSet = new HashSet<EditPart>();
		for (EditPart exclusion : exclusions)
			exclusionSet.add(exclusion);
		exclusionSet.add(viewer.getContents());

		EditPart editPart = viewer.findObjectAtExcluding(targetLocation, exclusionSet, textConditional);
		return exclusionSet.contains(editPart) ? null : (ITextualEntityPart) editPart;
	}

	protected boolean calculateEnabled(ITextualEntityPart targetPart) {
		if (getSelectionRangeAction() != null && targetPart.hasSelectionRange()) {
			getSelectionRangeAction().update();
			return getSelectionRangeAction().isEnabled();
		} else
			return calculateNavigateEnabled(targetPart);
	}
	protected boolean calculateNavigateEnabled(ITextualEntityPart targetPart) {
		return super.calculateEnabled(targetPart);
	}

	@Override
	public void run() {
		if (getSelectionRangeAction() != null && getSelectedTextualEntityPart().hasSelectionRange())
			getSelectionRangeAction().run();
		else
			runNavigate();
	}
	protected void runNavigate() {
		super.run();
	}
}
