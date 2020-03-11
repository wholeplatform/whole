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
import org.whole.lang.swiftsyntax.model.OptionalType;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Type;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;

/**
 *  @generator Whole
 */
public class OptionalTypeImpl extends AbstractSimpleEntity implements OptionalType {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<OptionalType> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.OptionalType;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.OptionalType_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Type wrappedType;

    public Type getWrappedType() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.wrappedType, wrappedType);
    }

    public void setWrappedType(Type wrappedType) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.wrappedType, this.wrappedType, this.wrappedType = wrappedType);
    }
    private Token questionMark;

    public Token getQuestionMark() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.questionMark, questionMark);
    }

    public void setQuestionMark(Token questionMark) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.questionMark, this.questionMark, this.questionMark = questionMark);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getWrappedType().wGetAdaptee(false);
            case 1 :
            return getQuestionMark().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setWrappedType(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type));
            break;
            case 1 :
            setQuestionMark(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
