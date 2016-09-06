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
package org.whole.lang.pojo.ui;

import org.whole.lang.pojo.reflect.PojoLanguageKit;
import org.whole.lang.pojo.ui.editparts.PojoTextualPartFactoryVisitor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.ui.editor.AbstractEditorKit;
import org.whole.lang.ui.editparts.IEditPartFactory;

/** 
 * @author Riccardo Solmi
 */
public class PojoTextualEditorKit extends AbstractEditorKit {
	private static final long serialVersionUID = 1L;
	public static final String ID = "org.whole.lang.pojo.ui.PojoTextualEditorKit";

	public String getId() {
		return ID;
	}

    public int getDefaultLevel() {
    	return 5;
    }

	public String getName() {
		return "PojoTextual";
	}

	public IEditPartFactory getPartFactory() {
		return new PojoTextualPartFactoryVisitor();
	}

	public boolean canApply(ILanguageKit languageKit) {
		return languageKit.getURI().equals(PojoLanguageKit.URI) && isStaticAndCurrent(languageKit);
	}
}