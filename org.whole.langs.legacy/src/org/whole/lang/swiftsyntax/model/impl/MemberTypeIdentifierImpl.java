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
package org.whole.lang.swiftsyntax.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swiftsyntax.model.MemberTypeIdentifier;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Type;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.GenericArgumentClause;

/**
 *  @generator Whole
 */
public class MemberTypeIdentifierImpl extends AbstractSimpleEntity implements MemberTypeIdentifier {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<MemberTypeIdentifier> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Type baseType;

    public Type getBaseType() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.baseType, baseType);
    }

    public void setBaseType(Type baseType) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.baseType, this.baseType, this.baseType = baseType);
    }
    private Token period;

    public Token getPeriod() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.period, period);
    }

    public void setPeriod(Token period) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.period, this.period, this.period = period);
    }
    private Token name;

    public Token getName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.name, name);
    }

    public void setName(Token name) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private GenericArgumentClause genericArgumentClause;

    public GenericArgumentClause getGenericArgumentClause() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.genericArgumentClause, genericArgumentClause);
    }

    public void setGenericArgumentClause(GenericArgumentClause genericArgumentClause) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.genericArgumentClause, this.genericArgumentClause, this.genericArgumentClause = genericArgumentClause);
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
            setBaseType(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type));
            break;
            case 1 :
            setPeriod(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setGenericArgumentClause(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
