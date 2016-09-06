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
package org.whole.lang.sql.ui;

import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.sql.reflect.SQLLanguageKit;
import org.whole.lang.sql.ui.actions.SQLActionFactory;
import org.whole.lang.sql.ui.editparts.SQLTextualPartFactoryVisitor;
import org.whole.lang.ui.editor.AbstractEditorKit;
import org.whole.lang.ui.editor.IActionFactory;
import org.whole.lang.ui.editparts.IEditPartFactory;

/** 
 * @author Riccardo Solmi
 */
public class SQLTextualEditorKit extends AbstractEditorKit {
	private static final long serialVersionUID = 1L;
	public static final String ID = SQLTextualEditorKit.class.getName();

	public String getId() {
		return ID;
	}

	public String getName() {
		return "SQL textual";
	}

	public IEditPartFactory getPartFactory() {
		return new SQLTextualPartFactoryVisitor();
	}
	
	public IActionFactory getActionFactory() {
		return SQLActionFactory.instance();
	}

	public boolean canApply(ILanguageKit languageKit) {
		return languageKit.getURI().equals(SQLLanguageKit.URI) && isStaticAndCurrent(languageKit);
	}
}
