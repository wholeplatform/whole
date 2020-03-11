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
import org.whole.lang.swiftsyntax.model.GenericParameterClause;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.GenericParameterList;

/**
 *  @generator Whole
 */
public class GenericParameterClauseImpl extends AbstractSimpleEntity implements GenericParameterClause {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<GenericParameterClause> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.GenericParameterClause;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.GenericParameterClause_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token leftAngleBracket;

    public Token getLeftAngleBracket() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leftAngleBracket, leftAngleBracket);
    }

    public void setLeftAngleBracket(Token leftAngleBracket) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leftAngleBracket, this.leftAngleBracket, this.leftAngleBracket = leftAngleBracket);
    }
    private GenericParameterList genericParameterList;

    public GenericParameterList getGenericParameterList() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.genericParameterList, genericParameterList);
    }

    public void setGenericParameterList(GenericParameterList genericParameterList) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.genericParameterList, this.genericParameterList, this.genericParameterList = genericParameterList);
    }
    private Token rightAngleBracket;

    public Token getRightAngleBracket() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.rightAngleBracket, rightAngleBracket);
    }

    public void setRightAngleBracket(Token rightAngleBracket) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.rightAngleBracket, this.rightAngleBracket, this.rightAngleBracket = rightAngleBracket);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLeftAngleBracket().wGetAdaptee(false);
            case 1 :
            return getGenericParameterList().wGetAdaptee(false);
            case 2 :
            return getRightAngleBracket().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLeftAngleBracket(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setGenericParameterList(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericParameterList));
            break;
            case 2 :
            setRightAngleBracket(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
