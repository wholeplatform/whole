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
import org.whole.lang.swiftsyntax.model.AccessorBlock;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.AccessorList;

/**
 *  @generator Whole
 */
public class AccessorBlockImpl extends AbstractSimpleEntity implements AccessorBlock {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<AccessorBlock> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.AccessorBlock;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.AccessorBlock_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token leftBrace;

    public Token getLeftBrace() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leftBrace, leftBrace);
    }

    public void setLeftBrace(Token leftBrace) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leftBrace, this.leftBrace, this.leftBrace = leftBrace);
    }
    private AccessorList accessors;

    public AccessorList getAccessors() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.accessors, accessors);
    }

    public void setAccessors(AccessorList accessors) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.accessors, this.accessors, this.accessors = accessors);
    }
    private Token rightBrace;

    public Token getRightBrace() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.rightBrace, rightBrace);
    }

    public void setRightBrace(Token rightBrace) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.rightBrace, this.rightBrace, this.rightBrace = rightBrace);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLeftBrace().wGetAdaptee(false);
            case 1 :
            return getAccessors().wGetAdaptee(false);
            case 2 :
            return getRightBrace().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLeftBrace(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setAccessors(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.AccessorList));
            break;
            case 2 :
            setRightBrace(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
