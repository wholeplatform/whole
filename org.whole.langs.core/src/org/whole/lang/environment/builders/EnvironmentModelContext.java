/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.environment.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.reflect.EnvironmentFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class EnvironmentModelContext extends EntityContext {

    public EnvironmentModelContext(IEntity root) {
        super(root);
    }

    public EnvironmentModelContext getName() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.name);
    }

    public void setName(EnvironmentModelContext name) {
        wSet(EnvironmentFeatureDescriptorEnum.name, name);
    }

    public EnvironmentModelContext getValue() {
        return (EnvironmentModelContext) wGet(EnvironmentFeatureDescriptorEnum.value);
    }

    public void setValue(EnvironmentModelContext value) {
        wSet(EnvironmentFeatureDescriptorEnum.value, value);
    }
}
