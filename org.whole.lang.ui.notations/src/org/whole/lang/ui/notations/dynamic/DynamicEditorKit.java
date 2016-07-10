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
package org.whole.lang.ui.notations.dynamic;

import java.util.function.Function;

import org.whole.lang.reflect.AbstractLanguageExtensionDeployer;
import org.whole.lang.reflect.IDeployer;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.editor.AbstractEditorKit;
import org.whole.lang.ui.notations.dynamic.editparts.DynamicPartFactory;

/**
 * @author Riccardo Solmi
 */
public class DynamicEditorKit extends AbstractEditorKit {
	private static final long serialVersionUID = 1L;
	private final String name;
	private int defaultLevel = 5;

	public IDeployer getDeployer() {
		return new AbstractLanguageExtensionDeployer() {
			public void deploy(ReflectionFactory platform) {
				platform.addEditorKit(DynamicEditorKit.this);
			}
			public void undeploy(ReflectionFactory platform) {
				platform.removeEditorKit(getId());
			}
		};
	}

	public DynamicEditorKit(String name, int defaultLevel) {
		this.name = name;
		this.defaultLevel = defaultLevel;
	}

	public String getId() {
		return getClass().getName()+"#"+name;
	}

	public String getName() {
		return name;
	}
	public int getDefaultLevel() {
		return defaultLevel;
	}

	protected DynamicPartFactory partFactory;
	public DynamicPartFactory getPartFactory() {
		if (partFactory == null)
			partFactory = new DynamicPartFactory(isGeneric());
		return partFactory;
	}

	public static Function<ILanguageKit, Boolean> APPLY_ALL = (ILanguageKit) -> true;
	public static Function<ILanguageKit, Boolean> applyLanguage(String languageUri) {
		return (ILanguageKit languageKit) -> languageKit.getURI().equals(languageUri);
	}

	private Function<ILanguageKit, Boolean> canApply = APPLY_ALL;
	public void setCanApply(Function<ILanguageKit, Boolean> canApply) {
		this.canApply = canApply;
	}
	public boolean canApply(ILanguageKit languageKit) {
		return canApply.apply(languageKit);
	}
	
	public boolean isGeneric() {
		return canApply == APPLY_ALL;
	}
}
