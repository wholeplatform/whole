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
import org.whole.lang.swiftsyntax.model.Attribute;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Syntax;

/**
 *  @generator Whole
 */
public class AttributeImpl extends AbstractSimpleEntity implements Attribute {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Attribute> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.Attribute;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.Attribute_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token atSignToken;

    public Token getAtSignToken() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.atSignToken, atSignToken);
    }

    public void setAtSignToken(Token atSignToken) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.atSignToken, this.atSignToken, this.atSignToken = atSignToken);
    }
    private Token attributeName;

    public Token getAttributeName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.attributeName, attributeName);
    }

    public void setAttributeName(Token attributeName) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.attributeName, this.attributeName, this.attributeName = attributeName);
    }
    private Token leftParen;

    public Token getLeftParen() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leftParen, leftParen);
    }

    public void setLeftParen(Token leftParen) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leftParen, this.leftParen, this.leftParen = leftParen);
    }
    private Syntax argument;

    public Syntax getArgument() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.argument, argument);
    }

    public void setArgument(Syntax argument) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.argument, this.argument, this.argument = argument);
    }
    private Token rightParen;

    public Token getRightParen() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.rightParen, rightParen);
    }

    public void setRightParen(Token rightParen) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.rightParen, this.rightParen, this.rightParen = rightParen);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAtSignToken().wGetAdaptee(false);
            case 1 :
            return getAttributeName().wGetAdaptee(false);
            case 2 :
            return getLeftParen().wGetAdaptee(false);
            case 3 :
            return getArgument().wGetAdaptee(false);
            case 4 :
            return getRightParen().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setAtSignToken(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setAttributeName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setLeftParen(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setArgument(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Syntax));
            break;
            case 4 :
            setRightParen(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
