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
package org.whole.lang.environment.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.environment.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.reflect.EnvironmentEntityDescriptorEnum;
import org.whole.lang.environment.model.Void;

/**
 *  @generator Whole
 */
public abstract class EnvironmentIdentitySwitchVisitor extends AbstractVisitor implements IEnvironmentVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case EnvironmentEntityDescriptorEnum.BooleanData_ord :
            visit((BooleanData) entity);
            break;
            case EnvironmentEntityDescriptorEnum.ByteData_ord :
            visit((ByteData) entity);
            break;
            case EnvironmentEntityDescriptorEnum.CharData_ord :
            visit((CharData) entity);
            break;
            case EnvironmentEntityDescriptorEnum.DoubleData_ord :
            visit((DoubleData) entity);
            break;
            case EnvironmentEntityDescriptorEnum.FloatData_ord :
            visit((FloatData) entity);
            break;
            case EnvironmentEntityDescriptorEnum.IntData_ord :
            visit((IntData) entity);
            break;
            case EnvironmentEntityDescriptorEnum.LongData_ord :
            visit((LongData) entity);
            break;
            case EnvironmentEntityDescriptorEnum.ShortData_ord :
            visit((ShortData) entity);
            break;
            case EnvironmentEntityDescriptorEnum.StringData_ord :
            visit((StringData) entity);
            break;
            case EnvironmentEntityDescriptorEnum.DateData_ord :
            visit((DateData) entity);
            break;
            case EnvironmentEntityDescriptorEnum.ObjectData_ord :
            visit((ObjectData) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Tuple_ord :
            visit((Tuple) entity);
            break;
            case EnvironmentEntityDescriptorEnum.ContainmentTuple_ord :
            visit((ContainmentTuple) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Void_ord :
            visit((Void) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Bindings_ord :
            visit((Bindings) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Binding_ord :
            visit((Binding) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Name_ord :
            visit((Name) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Value_ord :
            visit((Value) entity);
            break;
        }
    }
}
