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
package org.whole.lang.steppers.reflect;

import org.whole.lang.reflect.AbstractLanguageKit;
import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.factories.IEntityRegistry;
import org.whole.lang.steppers.model.impl.SteppersImplEntityRegistry;
import org.whole.lang.steppers.model.impl.SteppersStrictImplEntityRegistry;
import org.whole.lang.steppers.model.adapters.SteppersAdaptersEntityRegistry;
import org.whole.lang.templates.ITemplateManager;

/**
 *  @generator Whole
 */
public class SteppersLanguageKit extends AbstractLanguageKit {
    public static final String URI = "whole:org.whole.lang.steppers:SteppersModel";

    public String getURI() {
        return URI;
    }

    public String getNamespace() {
        return "org.whole.lang.steppers";
    }

    public String getName() {
        return "Steppers";
    }

    public EntityDescriptorEnum getEntityDescriptorEnum() {
        return SteppersEntityDescriptorEnum.instance;
    }

    public FeatureDescriptorEnum getFeatureDescriptorEnum() {
        return SteppersFeatureDescriptorEnum.instance;
    }

    protected IEntityRegistry createImplEntityRegistry() {
        return new SteppersImplEntityRegistry();
    }

    protected IEntityRegistry createStrictImplEntityRegistry() {
        return new SteppersStrictImplEntityRegistry();
    }

    protected IEntityRegistry createAdaptersEntityRegistry() {
        return new SteppersAdaptersEntityRegistry();
    }

    public ITemplateManager getTemplateManager() {
        return SteppersTemplateManager.instance();
    }
}
