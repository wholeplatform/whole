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
package org.whole.lang.swiftsyntax.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.swiftsyntax.model.impl.SwiftSyntaxImplEntityRegistry;
import org.whole.lang.swiftsyntax.model.impl.SwiftSyntaxStrictImplEntityRegistry;
import org.whole.lang.swiftsyntax.factories.SwiftSyntaxDefaultEntityRegistryConfiguration;
import org.whole.lang.swiftsyntax.model.adapters.SwiftSyntaxAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/**
 *  @generator  Whole
 */
public class SwiftSyntaxLanguageKit extends AbstractLanguageKit {
    public static final String URI = "whole:org.whole.lang.swiftsyntax:SwiftSyntaxModel";

    public String getURI() {
        return URI;
    }

    public String getNamespace() {
        return "org.whole.lang.swiftsyntax";
    }

    public String getName() {
        return "SwiftSyntax";
    }

    public EntityDescriptorEnum getEntityDescriptorEnum() {
        return SwiftSyntaxEntityDescriptorEnum.instance;
    }

    public FeatureDescriptorEnum getFeatureDescriptorEnum() {
        return SwiftSyntaxFeatureDescriptorEnum.instance;
    }

    protected IEntityRegistry createDefaultEntityRegistry() {
        IEntityRegistry er = createImplEntityRegistry();
        new SwiftSyntaxDefaultEntityRegistryConfiguration().apply(er);
        return er;
    }

    protected IEntityRegistry createImplEntityRegistry() {
        return new SwiftSyntaxImplEntityRegistry();
    }

    protected IEntityRegistry createStrictImplEntityRegistry() {
        return new SwiftSyntaxStrictImplEntityRegistry();
    }

    protected IEntityRegistry createAdaptersEntityRegistry() {
        return new SwiftSyntaxAdaptersEntityRegistry();
    }

    public ITemplateManager getTemplateManager() {
        return SwiftSyntaxTemplateManager.instance();
    }
}
