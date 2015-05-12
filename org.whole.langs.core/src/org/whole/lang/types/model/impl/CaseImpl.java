/**
 *  Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.types.model.Case;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.types.model.BasicType;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.model.Expressions;

/**
 *  @generator Whole
 */
public class CaseImpl extends AbstractSimpleEntity implements Case {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Case> wGetEntityDescriptor() {
        return TypesEntityDescriptorEnum.Case;
    }

    public int wGetEntityOrd() {
        return TypesEntityDescriptorEnum.Case_ord;
    }

    public void accept(ITypesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private BasicType type;

    public BasicType getType() {
        return notifyRequested(TypesFeatureDescriptorEnum.type, type);
    }

    public void setType(BasicType type) {
        notifyChanged(TypesFeatureDescriptorEnum.type, this.type, this.type = type);
    }
    private Expressions expressions;

    public Expressions getExpressions() {
        return notifyRequested(TypesFeatureDescriptorEnum.expressions, expressions);
    }

    public void setExpressions(Expressions expressions) {
        notifyChanged(TypesFeatureDescriptorEnum.expressions, this.expressions, this.expressions = expressions);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getType().wGetAdaptee(false);
            case 1 :
            return getExpressions().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setType(value.wGetAdapter(TypesEntityDescriptorEnum.BasicType));
            break;
            case 1 :
            setExpressions(value.wGetAdapter(TypesEntityDescriptorEnum.Expressions));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
