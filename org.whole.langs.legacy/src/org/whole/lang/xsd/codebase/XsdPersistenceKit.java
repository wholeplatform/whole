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
package org.whole.lang.xsd.codebase;

import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.templates.ITemplate;
import org.whole.lang.xsd.builders.XmlSpecific2XsdBuilderAdapterOperation;
import org.whole.lang.xsd.templates.XsdModelTemplate;
import org.whole.lang.xsd.util.NamespaceUtils;

/**
 * @author Enrico Persiani
 */
public class XsdPersistenceKit extends AbstractXsiPersistenceKit {
	private static class SingletonHolder {
		private static final XsdPersistenceKit instance = new XsdPersistenceKit();
	}
	public static final XsdPersistenceKit instance() {
		return SingletonHolder.instance;
	}

	private XsdPersistenceKit() {
		super("XSD (XML Schema Definition)", "xsd");
	}

	public boolean canApply(ILanguageKit languageKit) {
		return NamespaceUtils.isXsdNamespace(languageKit.getURI());
	}

	@Override
	protected IBuilderOperation getBuilderOperation(IBuilderOperation targetOperation, IBindingManager bindingManager) {
		return new XmlSpecific2XsdBuilderAdapterOperation(targetOperation, bindingManager);
	}

	@Override
	protected ITemplate getXsiModelTemplate(IEntity model, String encoding) {
		return new XsdModelTemplate(model, encoding);
	}
}
