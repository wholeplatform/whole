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
package org.whole.lang.json.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.reflect.JSONFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class JSONModelContext extends EntityContext {

    public JSONModelContext(IEntity root) {
        super(root);
    }

    public JSONModelContext getName() {
        return (JSONModelContext) wGet(JSONFeatureDescriptorEnum.name);
    }

    public void setName(JSONModelContext name) {
        wSet(JSONFeatureDescriptorEnum.name, name);
    }

    public JSONModelContext getValue() {
        return (JSONModelContext) wGet(JSONFeatureDescriptorEnum.value);
    }

    public void setValue(JSONModelContext value) {
        wSet(JSONFeatureDescriptorEnum.value, value);
    }
}
