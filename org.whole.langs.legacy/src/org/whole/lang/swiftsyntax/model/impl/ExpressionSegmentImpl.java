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
import org.whole.lang.swiftsyntax.model.ExpressionSegment;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.FunctionCallArgumentList;

/**
 *  @generator Whole
 */
public class ExpressionSegmentImpl extends AbstractSimpleEntity implements ExpressionSegment {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ExpressionSegment> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.ExpressionSegment;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.ExpressionSegment_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token backslash;

    public Token getBackslash() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.backslash, backslash);
    }

    public void setBackslash(Token backslash) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.backslash, this.backslash, this.backslash = backslash);
    }
    private Token delimiter;

    public Token getDelimiter() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.delimiter, delimiter);
    }

    public void setDelimiter(Token delimiter) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.delimiter, this.delimiter, this.delimiter = delimiter);
    }
    private Token leftParen;

    public Token getLeftParen() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leftParen, leftParen);
    }

    public void setLeftParen(Token leftParen) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leftParen, this.leftParen, this.leftParen = leftParen);
    }
    private FunctionCallArgumentList expressions;

    public FunctionCallArgumentList getExpressions() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.expressions, expressions);
    }

    public void setExpressions(FunctionCallArgumentList expressions) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.expressions, this.expressions, this.expressions = expressions);
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
            return getBackslash().wGetAdaptee(false);
            case 1 :
            return getDelimiter().wGetAdaptee(false);
            case 2 :
            return getLeftParen().wGetAdaptee(false);
            case 3 :
            return getExpressions().wGetAdaptee(false);
            case 4 :
            return getRightParen().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setBackslash(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setDelimiter(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setLeftParen(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setExpressions(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.FunctionCallArgumentList));
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
