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
package org.whole.lang.swift.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swift.model.MemberTypeIdentifier;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Type;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.PeriodEnum;
import org.whole.lang.swift.model.AbstractName;
import org.whole.lang.swift.model.GenericArgumentList;

/**
 *  @generator Whole
 */
public class MemberTypeIdentifierImpl extends AbstractSimpleEntity implements MemberTypeIdentifier {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<MemberTypeIdentifier> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.MemberTypeIdentifier;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.MemberTypeIdentifier_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Type baseType;

    public Type getBaseType() {
        return notifyRequested(SwiftFeatureDescriptorEnum.baseType, baseType);
    }

    public void setBaseType(Type baseType) {
        notifyChanged(SwiftFeatureDescriptorEnum.baseType, this.baseType, this.baseType = baseType);
    }
    private PeriodEnum period;

    public PeriodEnum getPeriod() {
        return notifyRequested(SwiftFeatureDescriptorEnum.period, period);
    }

    public void setPeriod(PeriodEnum period) {
        notifyChanged(SwiftFeatureDescriptorEnum.period, this.period, this.period = period);
    }
    private AbstractName name;

    public AbstractName getName() {
        return notifyRequested(SwiftFeatureDescriptorEnum.name, name);
    }

    public void setName(AbstractName name) {
        notifyChanged(SwiftFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private GenericArgumentList genericArgumentClause;

    public GenericArgumentList getGenericArgumentClause() {
        return notifyRequested(SwiftFeatureDescriptorEnum.genericArgumentClause, genericArgumentClause);
    }

    public void setGenericArgumentClause(GenericArgumentList genericArgumentClause) {
        notifyChanged(SwiftFeatureDescriptorEnum.genericArgumentClause, this.genericArgumentClause, this.genericArgumentClause = genericArgumentClause);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getBaseType().wGetAdaptee(false);
            case 1 :
            return getPeriod().wGetAdaptee(false);
            case 2 :
            return getName().wGetAdaptee(false);
            case 3 :
            return getGenericArgumentClause().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setBaseType(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            case 1 :
            setPeriod(value.wGetAdapter(SwiftEntityDescriptorEnum.PeriodEnum));
            break;
            case 2 :
            setName(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractName));
            break;
            case 3 :
            setGenericArgumentClause(value.wGetAdapter(SwiftEntityDescriptorEnum.GenericArgumentList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
