/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.swift.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.parsers.IDataTypeParser;
import org.whole.lang.swift.model.impl.SwiftImplEntityRegistry;
import org.whole.lang.swift.model.impl.SwiftStrictImplEntityRegistry;
import org.whole.lang.swift.parsers.SwiftDataTypeParser;
import org.whole.lang.swift.model.adapters.SwiftAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/**
 *  @generator  Whole
 */
public class SwiftLanguageKit extends AbstractLanguageKit {
    public static final String URI = "whole:org.whole.lang.swift:SwiftModel";

    public String getURI() {
        return URI;
    }

    public String getNamespace() {
        return "org.whole.lang.swift";
    }

    public String getName() {
        return "Swift";
    }

    public EntityDescriptorEnum getEntityDescriptorEnum() {
        return SwiftEntityDescriptorEnum.instance;
    }

    public FeatureDescriptorEnum getFeatureDescriptorEnum() {
        return SwiftFeatureDescriptorEnum.instance;
    }

    protected IEntityRegistry createImplEntityRegistry() {
        return new SwiftImplEntityRegistry();
    }

    protected IEntityRegistry createStrictImplEntityRegistry() {
        return new SwiftStrictImplEntityRegistry();
    }

    protected IEntityRegistry createAdaptersEntityRegistry() {
        return new SwiftAdaptersEntityRegistry();
    }

    @Override
    protected IDataTypeParser getDataTypePersistenceParser() {
        return SwiftDataTypeParser.instance();
    }

    @Override
    protected IDataTypeParser getDataTypePresentationParser() {
        return SwiftDataTypeParser.instance();
    }

    public ITemplateManager getTemplateManager() {
        return SwiftTemplateManager.instance();
    }
}
