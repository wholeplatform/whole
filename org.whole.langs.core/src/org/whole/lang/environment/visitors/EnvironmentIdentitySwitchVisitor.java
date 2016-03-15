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
            case EnvironmentEntityDescriptorEnum.ContextViewModel_ord :
            visit((ContextViewModel) entity);
            break;
            case EnvironmentEntityDescriptorEnum.SampleViewModel_ord :
            visit((SampleViewModel) entity);
            break;
            case EnvironmentEntityDescriptorEnum.DebugViewModel_ord :
            visit((DebugViewModel) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Jobs_ord :
            visit((Jobs) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Job_ord :
            visit((Job) entity);
            break;
            case EnvironmentEntityDescriptorEnum.ExecutionStack_ord :
            visit((ExecutionStack) entity);
            break;
            case EnvironmentEntityDescriptorEnum.ExecutionFrame_ord :
            visit((ExecutionFrame) entity);
            break;
            case EnvironmentEntityDescriptorEnum.VariablesViewModel_ord :
            visit((VariablesViewModel) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Environments_ord :
            visit((Environments) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Environment_ord :
            visit((Environment) entity);
            break;
            case EnvironmentEntityDescriptorEnum.ScopedBindings_ord :
            visit((ScopedBindings) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Bindings_ord :
            visit((Bindings) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Binding_ord :
            visit((Binding) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Scope_ord :
            visit((Scope) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Id_ord :
            visit((Id) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Names_ord :
            visit((Names) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Name_ord :
            visit((Name) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Index_ord :
            visit((Index) entity);
            break;
            case EnvironmentEntityDescriptorEnum.Value_ord :
            visit((Value) entity);
            break;
            case EnvironmentEntityDescriptorEnum.EnvironmentManager_ord :
            visit((EnvironmentManager) entity);
            break;
            case EnvironmentEntityDescriptorEnum.BindingManager_ord :
            visit((BindingManager) entity);
            break;
            case EnvironmentEntityDescriptorEnum.BindingScope_ord :
            visit((BindingScope) entity);
            break;
        }
    }
}
