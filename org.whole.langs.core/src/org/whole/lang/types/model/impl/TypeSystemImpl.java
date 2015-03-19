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
package org.whole.lang.types.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.types.model.TypeSystem;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.types.model.Operations;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.model.TypeRules;

/**
 *  @generator Whole
 */
public class TypeSystemImpl extends AbstractSimpleEntity implements TypeSystem {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TypeSystem> wGetEntityDescriptor() {
        return TypesEntityDescriptorEnum.TypeSystem;
    }

    public int wGetEntityOrd() {
        return TypesEntityDescriptorEnum.TypeSystem_ord;
    }

    public void accept(ITypesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Operations checkBefore;

    public Operations getCheckBefore() {
        return notifyRequested(TypesFeatureDescriptorEnum.checkBefore, checkBefore);
    }

    public void setCheckBefore(Operations checkBefore) {
        notifyChanged(TypesFeatureDescriptorEnum.checkBefore, this.checkBefore, this.checkBefore = checkBefore);
    }
    private TypeRules rules;

    public TypeRules getRules() {
        return notifyRequested(TypesFeatureDescriptorEnum.rules, rules);
    }

    public void setRules(TypeRules rules) {
        notifyChanged(TypesFeatureDescriptorEnum.rules, this.rules, this.rules = rules);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getCheckBefore().wGetAdaptee(false);
            case 1 :
            return getRules().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setCheckBefore(value.wGetAdapter(TypesEntityDescriptorEnum.Operations));
            break;
            case 1 :
            setRules(value.wGetAdapter(TypesEntityDescriptorEnum.TypeRules));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
