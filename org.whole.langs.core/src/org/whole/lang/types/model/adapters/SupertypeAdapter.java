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
package org.whole.lang.types.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class SupertypeAdapter extends AbstractEntityAdapter implements Supertype {
    private static final long serialVersionUID = 1;

    public SupertypeAdapter(IEntity implementor) {
        super(implementor);
    }

    public SupertypeAdapter() {
    }

    public void accept(ITypesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Supertype> wGetEntityDescriptor() {
        return TypesEntityDescriptorEnum.Supertype;
    }

    public VariableType getName() {
        return wGet(TypesFeatureDescriptorEnum.name).wGetAdapter(TypesEntityDescriptorEnum.VariableType);
    }

    public void setName(VariableType name) {
        wSet(TypesFeatureDescriptorEnum.name, name);
    }

    public VariableType getType() {
        return wGet(TypesFeatureDescriptorEnum.type).wGetAdapter(TypesEntityDescriptorEnum.VariableType);
    }

    public void setType(VariableType type) {
        wSet(TypesFeatureDescriptorEnum.type, type);
    }
}
