/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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

import org.eclipse.jface.bindings.keys.IKeyLookup;
import org.eclipse.jface.bindings.keys.KeyLookupFactory;
import org.eclipse.jface.bindings.keys.KeySequence;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;
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
		IKeyLookup keyLookup = KeyLookupFactory.getDefault();

		int ctrlKey = keyLookup.getCtrl();
		int spaceKey = keyLookup.formalKeyLookup(IKeyLookup.SPACE_NAME);
		KeyStroke ctrlSpaceKeyStroke = KeyStroke.getInstance(ctrlKey, spaceKey);
		KeySequence ctrltSpaceKeySequence = KeySequence.getInstance(ctrlSpaceKeyStroke);

		int returnKey = keyLookup.formalKeyLookup(IKeyLookup.RETURN_NAME);
		KeyStroke returnKeyStroke = KeyStroke.getInstance(returnKey);
		KeySequence returnKeySequence = KeySequence.getInstance(returnKeyStroke);

		int backspaceKey = keyLookup.formalKeyLookup(IKeyLookup.BACKSPACE_NAME);
		KeyStroke backspaceKeyStroke = KeyStroke.getInstance(backspaceKey);
		KeySequence backspaceKeySequence = KeySequence.getInstance(backspaceKeyStroke);

		int deleteKey = keyLookup.formalKeyLookup(IKeyLookup.DELETE_NAME);
		KeyStroke deleteKeyStroke = KeyStroke.getInstance(deleteKey);
		KeySequence deleteKeySequence = KeySequence.getInstance(deleteKeyStroke);

		return new Object[][] {
				{ ctrltSpaceKeySequence, TextEntityDescriptorEnum.Text, SplitOnCaretAction.class },
				{ returnKeySequence, TextEntityDescriptorEnum.Text, NewlineAction.class },
				{ backspaceKeySequence, TextEntityDescriptorEnum.Text, BackspaceAction.class },
				{ deleteKeySequence, TextEntityDescriptorEnum.Text, DeleteAction.class },

//				{ leftKeySequence, TextEntityDescriptorEnum.Text, LeftTextualAction.class },
//				{ rightKeySequence, TextEntityDescriptorEnum.Text, RightTextualAction.class },
//				{ upKeySequence, TextEntityDescriptorEnum.Text, UpTextualAction.class },
//				{ downKeySequence, TextEntityDescriptorEnum.Text, DownTextualAction.class },
		}; 
	}
}
