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
package org.whole.lang.grammars.ui;

import org.whole.lang.grammars.reflect.GrammarsLanguageKit;
import org.whole.lang.grammars.ui.actions.GrammarsActionFactory;
import org.whole.lang.grammars.ui.actions.GrammarsCommandFactory;
import org.whole.lang.grammars.ui.actions.GrammarsKeyHandler;
import org.whole.lang.grammars.ui.editparts.GrammarsPartFactoryVisitor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.ui.editor.AbstractEditorKit;
import org.whole.lang.ui.editor.IActionFactory;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.keys.IKeyHandler;
import org.whole.lang.ui.requests.ICommandFactory;

/** 
 * @author Riccardo Solmi
 */
public class GrammarsEditorKit extends AbstractEditorKit {
	private static final long serialVersionUID = 1;

	public static final String ID = GrammarsEditorKit.class.getName();

	public String getId() {
		return ID;
	}

	public String getName() {
		return "Grammars";
	}

    public int getDefaultLevel() {
    	return 5;
    }

	public IEditPartFactory getPartFactory() {
		return new GrammarsPartFactoryVisitor();
	}

	public ICommandFactory getCommandFactory() {
		return GrammarsCommandFactory.instance();
	}

	public boolean canApply(ILanguageKit languageKit) {
		return languageKit.getURI().equals(GrammarsLanguageKit.URI) && isStaticAndCurrent(languageKit);
	}

	public IActionFactory getActionFactory() {
		return GrammarsActionFactory.instance();
	}

	@Override
	public IKeyHandler getKeyHandler() {
		return GrammarsKeyHandler.instance();
	}
}