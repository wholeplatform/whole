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
package org.whole.lang.commons.reflect;

import org.whole.lang.commons.factories.CommonsDefaultEntityRegistryConfiguration;
import org.whole.lang.commons.model.adapters.CommonsAdaptersEntityRegistry;
import org.whole.lang.commons.model.impl.CommonsImplEntityRegistry;
import org.whole.lang.commons.model.impl.CommonsStrictImplEntityRegistry;
import org.whole.lang.commons.parsers.CommonsDataTypePersistenceParser;
import org.whole.lang.commons.parsers.CommonsDataTypePresentationParser;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;

/**
 * @author Riccardo Solmi
 */
public class CommonsLanguageKit extends AbstractLanguageKit {
	public static final String URI = "http://lang.whole.org/Commons";

	public String getURI() {
		return URI;
	}

	public String getNamespace() {
		return "org.whole.lang.commons";
	}

	public String getName() {
		return "Commons";
	}

	public EntityDescriptorEnum getEntityDescriptorEnum() {
		return CommonsEntityDescriptorEnum.instance;
	}

	public FeatureDescriptorEnum getFeatureDescriptorEnum() {
		return CommonsFeatureDescriptorEnum.instance;
	}

    protected IEntityRegistry createStrictEntityRegistry() {
    	IEntityRegistry er = createStrictImplEntityRegistry();
    	new CommonsDefaultEntityRegistryConfiguration().apply(er);
    	return er;
    }
    protected IEntityRegistry createDefaultEntityRegistry() {
    	IEntityRegistry er = createImplEntityRegistry();
    	new CommonsDefaultEntityRegistryConfiguration().apply(er);
    	return er;
    }

    @Override
    protected IEntityRegistry createResolverEntityRegistry() {
    	return createDefaultEntityRegistry();
    }

	protected IEntityRegistry createImplEntityRegistry() {
		return new CommonsImplEntityRegistry();
	}

	protected IEntityRegistry createStrictImplEntityRegistry() {
		return new CommonsStrictImplEntityRegistry();
	}

	protected IEntityRegistry createAdaptersEntityRegistry() {
		return new CommonsAdaptersEntityRegistry();
	}

	@Override
	protected IDataTypeParser getDataTypePersistenceParser() {
		return CommonsDataTypePersistenceParser.instance();
	}
	@Override
	protected IDataTypeParser getDataTypePresentationParser() {
		return CommonsDataTypePresentationParser.instance();
	}

	public ITemplateManager getTemplateManager() {
		return CommonsTemplateManager.instance();
	}
}
