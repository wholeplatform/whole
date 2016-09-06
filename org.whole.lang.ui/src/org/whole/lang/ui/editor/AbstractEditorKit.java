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
package org.whole.lang.ui.editor;

import java.io.Serializable;

import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.ui.keys.DefaultKeyHandler;
import org.whole.lang.ui.keys.IKeyHandler;
import org.whole.lang.ui.requests.CommandFactory;
import org.whole.lang.ui.requests.ICommandFactory;
import org.whole.lang.ui.templates.DefaultUITemplate;
import org.whole.lang.ui.templates.IUITemplate;


/**
 * @author Riccardo Solmi
 */
@SuppressWarnings("serial")
public abstract class AbstractEditorKit implements IGEFEditorKit, Serializable {

	public int compareTo(IEditorKit editorKit) {
		int result = getName().compareTo(editorKit.getName());
		if (result == 0)
			result = getId().compareTo(editorKit.getId());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IEditorKit))
			return false;
		IEditorKit other = (IEditorKit) obj;
		return getName().equals(other.getName()) && getId().equals(other.getId());
	}

    public int getDefaultLevel() {
    	return 0;
    }

    public IUITemplate getUITemplate(ILanguageKit languageKit) {
    	return new DefaultUITemplate(languageKit);
    }

    public IKeyHandler getKeyHandler() {
		return DefaultKeyHandler.instance();
	}

	public ICommandFactory getCommandFactory() {
		return CommandFactory.instance();
	}

	public IActionFactory getActionFactory() {
		return ActionFactory.instance();
	}

	public boolean isGeneric() {
		return false;
	}

	protected boolean isStaticAndCurrent(ILanguageKit languageKit) {
		if (languageKit.isDynamic() || !languageKit.isCurrent())
			return false;

    	try {
    		Class<?> lkClass = Class.forName(languageKit.getClass().getName(), true, getClass().getClassLoader());
    		if (lkClass != languageKit.getClass()) 
        		return false;
    	} catch (ClassNotFoundException e) {
 		}

		return true;
	}
}
