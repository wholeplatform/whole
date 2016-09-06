/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.reusables.ui;

import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reusables.reflect.ReusablesLanguageKit;
import org.whole.lang.reusables.ui.actions.ReusablesActionFactory;
import org.whole.lang.reusables.ui.editparts.ReusablesPartFactoryVisitor;
import org.whole.lang.ui.editor.AbstractEditorKit;
import org.whole.lang.ui.editor.IActionFactory;
import org.whole.lang.ui.editparts.IEditPartFactory;

/**
 *  @generator Whole
 */
public class ReusablesEditorKit extends AbstractEditorKit {
    private static final long serialVersionUID = 1;
    public static final String ID = ReusablesEditorKit.class.getName();

    public String getId() {
        return ID;
    }

    public String getName() {
        return "Reusables";
    }

    public int getDefaultLevel() {
        return 10;
    }

    public IEditPartFactory getPartFactory() {
        return new ReusablesPartFactoryVisitor();
    }

    public boolean canApply(ILanguageKit languageKit) {
        return languageKit.getURI().equals(ReusablesLanguageKit.URI) && isStaticAndCurrent(languageKit);
    }

	public IActionFactory getActionFactory() {
		return ReusablesActionFactory.instance();
	}
}
