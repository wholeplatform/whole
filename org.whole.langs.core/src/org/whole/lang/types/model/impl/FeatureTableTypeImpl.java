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
package org.whole.lang.types.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.types.model.FeatureTableType;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.types.model.Arguments;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.model.Cases;

/**
 *  @generator Whole
 */
public class FeatureTableTypeImpl extends AbstractSimpleEntity implements FeatureTableType {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<FeatureTableType> wGetEntityDescriptor() {
        return TypesEntityDescriptorEnum.FeatureTableType;
    }

    public int wGetEntityOrd() {
        return TypesEntityDescriptorEnum.FeatureTableType_ord;
    }

    public void accept(ITypesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Arguments arguments;

    public Arguments getArguments() {
        return notifyRequested(TypesFeatureDescriptorEnum.arguments, arguments);
    }

    public void setArguments(Arguments arguments) {
        notifyChanged(TypesFeatureDescriptorEnum.arguments, this.arguments, this.arguments = arguments);
    }
    private Cases cases;

    public Cases getCases() {
        return notifyRequested(TypesFeatureDescriptorEnum.cases, cases);
    }

    public void setCases(Cases cases) {
        notifyChanged(TypesFeatureDescriptorEnum.cases, this.cases, this.cases = cases);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getArguments().wGetAdaptee(false);
            case 1 :
            return getCases().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setArguments(value.wGetAdapter(TypesEntityDescriptorEnum.Arguments));
            break;
            case 1 :
            setCases(value.wGetAdapter(TypesEntityDescriptorEnum.Cases));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
