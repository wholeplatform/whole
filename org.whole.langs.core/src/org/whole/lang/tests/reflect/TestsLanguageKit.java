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
package org.whole.lang.tests.reflect;

import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.templates.ITemplateManager;
import org.whole.lang.tests.factories.TestsDefaultEntityRegistryConfiguration;
import org.whole.lang.tests.model.adapters.TestsAdaptersEntityRegistry;
import org.whole.lang.tests.model.impl.TestsImplEntityRegistry;
import org.whole.lang.tests.model.impl.TestsStrictImplEntityRegistry;
import org.whole.lang.tests.parsers.TestsDataTypePresentationParser;

/**
 *  @generator Whole
 */
public class TestsLanguageKit extends AbstractLanguageKit {
    public static final String URI = "http://lang.whole.org/Tests";

    public String getURI() {
        return URI;
    }

    public String getNamespace() {
        return "org.whole.lang.tests";
    }

    public String getName() {
        return "Tests";
    }

    public EntityDescriptorEnum getEntityDescriptorEnum() {
        return TestsEntityDescriptorEnum.instance;
    }

    public FeatureDescriptorEnum getFeatureDescriptorEnum() {
        return TestsFeatureDescriptorEnum.instance;
    }

	@Override
	protected IDataTypeParser getDataTypePresentationParser() {
		return TestsDataTypePresentationParser.instance();
	}

	@Override
	protected IEntityRegistry createDefaultEntityRegistry() {
    	IEntityRegistry er = createImplEntityRegistry();
    	new TestsDefaultEntityRegistryConfiguration().apply(er);
    	return er;
	}

    protected IEntityRegistry createImplEntityRegistry() {
        return new TestsImplEntityRegistry();
    }

    protected IEntityRegistry createStrictImplEntityRegistry() {
        return new TestsStrictImplEntityRegistry();
    }

    protected IEntityRegistry createAdaptersEntityRegistry() {
        return new TestsAdaptersEntityRegistry();
    }

    public ITemplateManager getTemplateManager() {
        return TestsTemplateManager.instance();
    }
}
