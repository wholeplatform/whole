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
import org.whole.lang.swift.model.FunctionType;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.TupleTypeElementList;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.ThrowsOrRethrowsKeywordEnum;
import org.whole.lang.swift.model.Type;

/**
 *  @generator Whole
 */
public class FunctionTypeImpl extends AbstractSimpleEntity implements FunctionType {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<FunctionType> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.FunctionType;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.FunctionType_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private TupleTypeElementList arguments;

    public TupleTypeElementList getArguments() {
        return notifyRequested(SwiftFeatureDescriptorEnum.arguments, arguments);
    }

    public void setArguments(TupleTypeElementList arguments) {
        notifyChanged(SwiftFeatureDescriptorEnum.arguments, this.arguments, this.arguments = arguments);
    }
    private ThrowsOrRethrowsKeywordEnum throwsOrRethrowsKeyword;

    public ThrowsOrRethrowsKeywordEnum getThrowsOrRethrowsKeyword() {
        return notifyRequested(SwiftFeatureDescriptorEnum.throwsOrRethrowsKeyword, throwsOrRethrowsKeyword);
    }

    public void setThrowsOrRethrowsKeyword(ThrowsOrRethrowsKeywordEnum throwsOrRethrowsKeyword) {
        notifyChanged(SwiftFeatureDescriptorEnum.throwsOrRethrowsKeyword, this.throwsOrRethrowsKeyword, this.throwsOrRethrowsKeyword = throwsOrRethrowsKeyword);
    }
    private Type returnType;

    public Type getReturnType() {
        return notifyRequested(SwiftFeatureDescriptorEnum.returnType, returnType);
    }

    public void setReturnType(Type returnType) {
        notifyChanged(SwiftFeatureDescriptorEnum.returnType, this.returnType, this.returnType = returnType);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getArguments().wGetAdaptee(false);
            case 1 :
            return getThrowsOrRethrowsKeyword().wGetAdaptee(false);
            case 2 :
            return getReturnType().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setArguments(value.wGetAdapter(SwiftEntityDescriptorEnum.TupleTypeElementList));
            break;
            case 1 :
            setThrowsOrRethrowsKeyword(value.wGetAdapter(SwiftEntityDescriptorEnum.ThrowsOrRethrowsKeywordEnum));
            break;
            case 2 :
            setReturnType(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
