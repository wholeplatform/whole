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
package org.whole.lang.ui.editor;

import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.IDeployer;
import org.whole.lang.reflect.IEditorKit;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.editparts.IEditPartFactory;

/**
 * @author Riccardo Solmi
 */
public class DynamicEditorKit extends AbstractEditorKit {
	private static final long serialVersionUID = 1L;
	private final String ID;
	private final String name;

	public static IDeployer getDeployer(final IEditorKit editorKit) {
		return new AbstractLanguageExtensionDeployer() {
			public void deploy(ReflectionFactory platform) {
				platform.addEditorKit(editorKit);
			}
			public void undeploy(ReflectionFactory platform) {
				platform.removeEditorKit(editorKit.getId());
			}
		};
	}

	public DynamicEditorKit(String name) {
		this(calculateId(name), name);
	}
	public DynamicEditorKit(String ID, String name) {
		this.ID = ID;
		this.name = name;
	}

	public static String calculateId(String name) {
		return DynamicEditorKit.class.getName()+"#"+name;
	}

	public String getId() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public IEditPartFactory getPartFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean canApply(ILanguageKit languageKit) {
		return true; //FIXME
	}
}
