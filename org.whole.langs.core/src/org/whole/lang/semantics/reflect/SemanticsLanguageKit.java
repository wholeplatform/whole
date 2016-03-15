/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.semantics.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.semantics.factories.SemanticsDefaultEntityRegistryConfiguration;
import org.whole.lang.semantics.model.adapters.SemanticsAdaptersEntityRegistry;
import org.whole.lang.semantics.model.impl.SemanticsImplEntityRegistry;
import org.whole.lang.semantics.model.impl.SemanticsStrictImplEntityRegistry;
import org.whole.lang.semantics.parsers.SemanticsDataTypePersistenceParser;
import org.whole.lang.templates.ITemplateManager;

/** 
 * @generator Whole
 */
public class SemanticsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Semantics";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.semantics";
	}

	public String getName() {
		return "Semantics";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return SemanticsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return SemanticsFeatureDescriptorEnum.instance;
	}

	protected IEntityRegistry createDefaultEntityRegistry() {
		IEntityRegistry er = createImplEntityRegistry();
		new SemanticsDefaultEntityRegistryConfiguration().apply(er);
		return er;
	}
	protected IEntityRegistry createImplEntityRegistry() {
		return new SemanticsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new SemanticsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new SemanticsAdaptersEntityRegistry();
	}

	@Override
	protected IDataTypeParser getDataTypePersistenceParser() {
		return SemanticsDataTypePersistenceParser.instance();
	}
	@Override
	protected IDataTypeParser getDataTypePresentationParser() {
		return SemanticsDataTypePersistenceParser.instance();
	}

	public ITemplateManager getTemplateManager() {
		return SemanticsTemplateManager.instance();
	}
}
