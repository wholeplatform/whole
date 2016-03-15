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
package org.whole.lang.xsi.ui;

import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.ui.editor.AbstractEditorKit;
import org.whole.lang.ui.editor.IActionFactory;
import org.whole.lang.ui.editparts.IEditPartFactory;
import org.whole.lang.ui.templates.IUITemplate;
import org.whole.lang.xsd.codebase.IMappingStrategy;
import org.whole.lang.xsd.codebase.MappingStrategyRegistry;
import org.whole.lang.xsd.util.NamespaceUtils;
import org.whole.lang.xsi.ui.actions.XsiActionFactory;
import org.whole.lang.xsi.ui.editparts.XsiOutlinePartFactory;

/**
 * @author Enrico Persiani
 */
public class XsiOutlineEditorKit extends AbstractEditorKit {
	private static final long serialVersionUID = 1L;
	public static final String ID = XsiOutlineEditorKit.class.getName();

	public String getId() {
		return ID;
	}

    public int getDefaultLevel() {
    	return 15;
    }

	public String getName() {
		return "XSI outline";
	}

	public IEditPartFactory getPartFactory() {
		return new XsiOutlinePartFactory();
	}

	public IUITemplate getUITemplate(ILanguageKit languageKit) {
		return super.getUITemplate(languageKit);
	}

	public boolean canApply(ILanguageKit languageKit) {
		String languageURI = languageKit.getURI();
		IMappingStrategy mappingStrategy = MappingStrategyRegistry.instance().getMappingStrategy(languageURI);
		return mappingStrategy != null && !NamespaceUtils.isXsdNamespace(languageURI);
	}

	public IActionFactory getActionFactory() {
		return XsiActionFactory.instance();
	}
}
