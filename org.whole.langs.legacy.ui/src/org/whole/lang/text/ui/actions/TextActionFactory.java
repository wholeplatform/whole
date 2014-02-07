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

import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
import org.whole.lang.ui.actions.EnablerPredicateFactory;
import org.whole.lang.ui.editor.ActionFactory;

/** 
 * @author Enrico Persiani
 */
public class TextActionFactory extends ActionFactory {
	private static class SingletonHolder {
		private static final TextActionFactory instance = new TextActionFactory();
	}
	public static TextActionFactory instance() {
		return SingletonHolder.instance;
	}
	private TextActionFactory() {
	}

	public Object[][] textActions() {
		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
		return new Object[][] {
				{ pf.alwaysTrue(), TextEntityDescriptorEnum.Text, SplitOnCaretAction.class },
//				{ pf.sameType(), TextEntityDescriptorEnum.Text, "Newline on caret", NewlineTextualAction.class },
//				{ pf.sameType(), TextEntityDescriptorEnum.Text, "Backspace", BackspaceTextualAction.class },
//				{ pf.sameType(), TextEntityDescriptorEnum.Text, "Delete", DeleteTextualAction.class },

//				{ pf.sameType(), TextEntityDescriptorEnum.Text, "Goto left text", LeftTextualAction.class },
//				{ pf.sameType(), TextEntityDescriptorEnum.Text, "Goto right text", RightTextualAction.class },
//				{ pf.sameType(), TextEntityDescriptorEnum.Text, "Goto up text", UpTextualAction.class },
//				{ pf.sameType(), TextEntityDescriptorEnum.Text, "Goto down text", DownTextualAction.class },
		}; 
	}

//	public void initKeyActions(IWorkbenchPart workbenchPart, ActionRegistry actionRegistry, Map<KeyStroke, SelectionAction> keyActionsMap) {
//		super.initKeyActions(workbenchPart, actionRegistry, keyActionsMap);
//
////TODO either change the modifier or remove the keystroke at all
////		SelectionAction action = (SelectionAction) actionRegistry.getAction(SplitTextualAction.ID);
////		keyActionsMap.put(KeyStroke.getPressed(' ', 32, SWT.MOD1), action);
//
//		SelectionAction action = (SelectionAction) actionRegistry.getAction(NewlineTextualAction.ID);
//		keyActionsMap.put(KeyStroke.getPressed(SWT.CR, 13, SWT.NONE), action);
//		keyActionsMap.put(KeyStroke.getPressed(SWT.LF, 10, SWT.NONE), action);
//
//		action = (SelectionAction) actionRegistry.getAction(BackspaceTextualAction.ID);
//		keyActionsMap.put(KeyStroke.getPressed(SWT.BS, 8, SWT.NONE), action);
//
//		action = (SelectionAction) actionRegistry.getAction(DeleteTextualAction.ID);
//		keyActionsMap.put(KeyStroke.getPressed(SWT.DEL, 127, SWT.NONE), action);
//
//		EnablerPredicateFactory pf = EnablerPredicateFactory.instance;
//
//		KeyStroke stroke = KeyStroke.getPressed(SWT.ARROW_LEFT, SWT.NONE);
//		NavigateTextualAction navigateAction = new LeftTextualAction(workbenchPart, pf.sameType(), TextEntityDescriptorEnum.Text, "Goto left text");
//		navigateAction.setSelectionRangeAction(keyActionsMap.get(stroke));
//		actionRegistry.registerAction(navigateAction);
//		keyActionsMap.put(stroke, navigateAction);
//
//		stroke = KeyStroke.getPressed(SWT.ARROW_RIGHT, SWT.NONE);
//		navigateAction = new RightTextualAction(workbenchPart, pf.sameType(), TextEntityDescriptorEnum.Text, "Goto right text");
//		navigateAction.setSelectionRangeAction(keyActionsMap.get(stroke));
//		actionRegistry.registerAction(navigateAction);
//		keyActionsMap.put(stroke, navigateAction);
//
//		navigateAction = new UpTextualAction(workbenchPart, pf.sameType(), TextEntityDescriptorEnum.Text, "Goto up text");
//		actionRegistry.registerAction(navigateAction);
//		keyActionsMap.put(KeyStroke.getPressed(SWT.ARROW_UP, SWT.NONE), navigateAction);
//
//		navigateAction = new DownTextualAction(workbenchPart, pf.sameType(), TextEntityDescriptorEnum.Text, "Goto down text");
//		actionRegistry.registerAction(navigateAction);
//		keyActionsMap.put(KeyStroke.getPressed(SWT.ARROW_DOWN, SWT.NONE), navigateAction);
//	}
}
