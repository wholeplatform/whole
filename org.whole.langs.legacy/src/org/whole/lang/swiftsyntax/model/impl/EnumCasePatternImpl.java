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
import org.whole.lang.swiftsyntax.model.EnumCasePattern;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Type;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.TuplePattern;

/**
 *  @generator Whole
 */
public class EnumCasePatternImpl extends AbstractSimpleEntity implements EnumCasePattern {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<EnumCasePattern> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.EnumCasePattern;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.EnumCasePattern_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Type type;

    public Type getType() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.type, type);
    }

    public void setType(Type type) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.type, this.type, this.type = type);
    }
    private Token period;

    public Token getPeriod() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.period, period);
    }

    public void setPeriod(Token period) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.period, this.period, this.period = period);
    }
    private Token caseName;

    public Token getCaseName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.caseName, caseName);
    }

    public void setCaseName(Token caseName) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.caseName, this.caseName, this.caseName = caseName);
    }
    private TuplePattern associatedTuple;

    public TuplePattern getAssociatedTuple() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.associatedTuple, associatedTuple);
    }

    public void setAssociatedTuple(TuplePattern associatedTuple) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.associatedTuple, this.associatedTuple, this.associatedTuple = associatedTuple);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getType().wGetAdaptee(false);
            case 1 :
            return getPeriod().wGetAdaptee(false);
            case 2 :
            return getCaseName().wGetAdaptee(false);
            case 3 :
            return getAssociatedTuple().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setType(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type));
            break;
            case 1 :
            setPeriod(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setCaseName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setAssociatedTuple(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TuplePattern));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
