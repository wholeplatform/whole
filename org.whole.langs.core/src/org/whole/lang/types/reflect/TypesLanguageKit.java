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
package org.whole.lang.types.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.types.model.impl.TypesImplEntityRegistry;
import org.whole.lang.types.model.impl.TypesStrictImplEntityRegistry;
import org.whole.lang.types.model.adapters.TypesAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/**
 *  @generator Whole
 */
public class TypesLanguageKit extends AbstractLanguageKit {
    public static final String URI = "whole:org.whole.lang.types:TypesModel";

    public String getURI() {
        return URI;
    }

    public String getNamespace() {
        return "org.whole.lang.types";
    }

    public String getName() {
        return "Types";
    }

    public EntityDescriptorEnum getEntityDescriptorEnum() {
        return TypesEntityDescriptorEnum.instance;
    }

    public FeatureDescriptorEnum getFeatureDescriptorEnum() {
        return TypesFeatureDescriptorEnum.instance;
    }

    protected IEntityRegistry createImplEntityRegistry() {
        return new TypesImplEntityRegistry();
    }

    protected IEntityRegistry createStrictImplEntityRegistry() {
        return new TypesStrictImplEntityRegistry();
    }

    protected IEntityRegistry createAdaptersEntityRegistry() {
        return new TypesAdaptersEntityRegistry();
    }

    public ITemplateManager getTemplateManager() {
        return TypesTemplateManager.instance();
    }
}
