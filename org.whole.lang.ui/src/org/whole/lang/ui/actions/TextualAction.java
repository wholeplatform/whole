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
package org.whole.lang.ui.actions;

import java.util.List;

import org.eclipse.ui.IWorkbenchPart;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.ui.commands.ModelTextCommand;
import org.whole.lang.ui.editparts.ITextualEntityPart;
import org.whole.lang.ui.tools.Tools;
import org.whole.lang.util.UniqueIdGenerator;

/**
 * @author Enrico Persiani, Riccardo Solmi
 */
public class TextualAction extends AbstractLazySelectionAction {
	private static UniqueIdGenerator uidGen = UniqueIdGenerator.newUniqueIdGenerator("text");

	public TextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, IEntity prototype, String text) {
		super(part, enablerPredicate, prototype);
		setText(text);
	}
	public TextualAction(IWorkbenchPart part, IEnablerPredicate enablerPredicate, EntityDescriptor<?> type, String text) {
		super(part, enablerPredicate, type);
		setText(text);
	}

	protected void init() {
		setImageDescriptor(TEXT_ICON);
		setId(uidGen.next());
	}

	protected boolean calculateEnabled(ITextualEntityPart targetPart) {
		return false;
	}
	protected boolean calculateEnabled() {
		ITextualEntityPart part = getSelectedTextualEntityPart();
		return part != null && Tools.TEXTUAL.isActive(getGraphicalViewer()) &&
				enablerPredicate.evaluate(part, contextMenuRequest) && calculateEnabled(part);
	}

	protected ITextualEntityPart getSelectedTextualEntityPart() {
		List<?> selectedObjects = getSelectedObjects();
		return  selectedObjects.size() == 1 && selectedObjects.get(0) instanceof ITextualEntityPart ?
			(ITextualEntityPart) selectedObjects.get(0) : null;
	}
	protected void doRun(ITextualEntityPart targetPart, ModelTextCommand command) {
		// do nothing
	}

	public void run() {
		ITextualEntityPart part = getSelectedTextualEntityPart();
		ModelTextCommand command = new ModelTextCommand();
		command.setLabel("Typing");
		command.setViewer(getGraphicalViewer());
		command.setModel(part.getModelTextEntity());
		command.begin();
		try {
			doRun(part, command);
			command.commit();
			execute(command);
		} catch (Exception e) {
			command.rollback();
		}
	}
}
