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
import org.whole.lang.swiftsyntax.model.PoundAssertStmt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Expr;

/**
 *  @generator Whole
 */
public class PoundAssertStmtImpl extends AbstractSimpleEntity implements PoundAssertStmt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PoundAssertStmt> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.PoundAssertStmt;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.PoundAssertStmt_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token poundAssert;

    public Token getPoundAssert() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.poundAssert, poundAssert);
    }

    public void setPoundAssert(Token poundAssert) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.poundAssert, this.poundAssert, this.poundAssert = poundAssert);
    }
    private Token leftParen;

    public Token getLeftParen() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leftParen, leftParen);
    }

    public void setLeftParen(Token leftParen) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leftParen, this.leftParen, this.leftParen = leftParen);
    }
    private Expr condition;

    public Expr getCondition() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.condition, condition);
    }

    public void setCondition(Expr condition) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.condition, this.condition, this.condition = condition);
    }
    private Token comma;

    public Token getComma() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.comma, comma);
    }

    public void setComma(Token comma) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.comma, this.comma, this.comma = comma);
    }
    private Token message;

    public Token getMessage() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.message, message);
    }

    public void setMessage(Token message) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.message, this.message, this.message = message);
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
            return getPoundAssert().wGetAdaptee(false);
            case 1 :
            return getLeftParen().wGetAdaptee(false);
            case 2 :
            return getCondition().wGetAdaptee(false);
            case 3 :
            return getComma().wGetAdaptee(false);
            case 4 :
            return getMessage().wGetAdaptee(false);
            case 5 :
            return getRightParen().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setPoundAssert(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setLeftParen(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setCondition(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr));
            break;
            case 3 :
            setComma(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setMessage(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 5 :
            setRightParen(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 6;
    }
}
