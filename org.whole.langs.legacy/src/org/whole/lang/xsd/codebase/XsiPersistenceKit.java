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
import org.whole.lang.codebase.IPersistenceProvider;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.templates.ITemplate;
import org.whole.lang.xsd.builders.XmlSpecific2XsiBuilderAdapterOperation;
import org.whole.lang.xsd.templates.XsiModelTemplate;
import org.whole.lang.xsd.util.NamespaceUtils;

/**
 * @author Enrico Persiani
 */
public class XsiPersistenceKit extends AbstractXsiPersistenceKit {
	private static class SingletonHolder {
		private static final XsiPersistenceKit instance = new XsiPersistenceKit();
	}
	public static final XsiPersistenceKit instance() {
		return SingletonHolder.instance;
	}

	private XsiPersistenceKit() {
		super("XSI (XML Schema Instance)", "xml");
	}

	public boolean isGeneric() {
		return true;
	}
	public boolean isLossless() {
		return false;
	}

	@Override
	public IEntity readModel(IPersistenceProvider pp) throws Exception {
		if (!pp.canReopenStream())
			return super.readModel(pp);

		IBindingManager bm = pp.getBindings();
		XsdDeployStrategies.setDeployStrategy(bm, XsdDeployStrategies.MISSING);
		try {
			return super.readModel(pp);
		} catch (Exception e) {
			pp.closeStream();
			XsdDeployStrategies.setDeployStrategy(bm, XsdDeployStrategies.ALL);
			return super.readModel(pp);
		}
	}

	public boolean canApply(ILanguageKit languageKit) {
		String languageURI = languageKit.getURI();
		IMappingStrategy mappingStrategy = MappingStrategyRegistry.instance().getMappingStrategy(languageURI);
		return mappingStrategy != null && !NamespaceUtils.isXsdNamespace(languageURI);
	}

	@Override
	protected IBuilderOperation getBuilderOperation(IBuilderOperation targetOperation, IBindingManager bindingManager) {
		return new XmlSpecific2XsiBuilderAdapterOperation(targetOperation, bindingManager);
	}

	@Override
	protected ITemplate getXsiModelTemplate(IEntity model, String encoding) {
		return new XsiModelTemplate(model, encoding);
	}
}
