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
public class TypeSystemAdapter extends AbstractEntityAdapter implements TypeSystem {
    private static final long serialVersionUID = 1;

    public TypeSystemAdapter(IEntity implementor) {
        super(implementor);
    }

    public TypeSystemAdapter() {
    }

    public void accept(ITypesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<TypeSystem> wGetEntityDescriptor() {
        return TypesEntityDescriptorEnum.TypeSystem;
    }

    public Operations getCheckBefore() {
        return wGet(TypesFeatureDescriptorEnum.checkBefore).wGetAdapter(TypesEntityDescriptorEnum.Operations);
    }

    public void setCheckBefore(Operations checkBefore) {
        wSet(TypesFeatureDescriptorEnum.checkBefore, checkBefore);
    }

    public TypeRules getRules() {
        return wGet(TypesFeatureDescriptorEnum.rules).wGetAdapter(TypesEntityDescriptorEnum.TypeRules);
    }

    public void setRules(TypeRules rules) {
        wSet(TypesFeatureDescriptorEnum.rules, rules);
    }
}
