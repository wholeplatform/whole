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
import org.whole.lang.swiftsyntax.model.SwitchStmt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Expr;
import org.whole.lang.swiftsyntax.model.SwitchCaseList;

/**
 *  @generator Whole
 */
public class SwitchStmtImpl extends AbstractSimpleEntity implements SwitchStmt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SwitchStmt> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.SwitchStmt;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.SwitchStmt_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token labelName;

    public Token getLabelName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.labelName, labelName);
    }

    public void setLabelName(Token labelName) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.labelName, this.labelName, this.labelName = labelName);
    }
    private Token labelColon;

    public Token getLabelColon() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.labelColon, labelColon);
    }

    public void setLabelColon(Token labelColon) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.labelColon, this.labelColon, this.labelColon = labelColon);
    }
    private Token switchKeyword;

    public Token getSwitchKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.switchKeyword, switchKeyword);
    }

    public void setSwitchKeyword(Token switchKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.switchKeyword, this.switchKeyword, this.switchKeyword = switchKeyword);
    }
    private Expr expression;

    public Expr getExpression() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(Expr expression) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }
    private Token leftBrace;

    public Token getLeftBrace() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leftBrace, leftBrace);
    }

    public void setLeftBrace(Token leftBrace) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leftBrace, this.leftBrace, this.leftBrace = leftBrace);
    }
    private SwitchCaseList cases;

    public SwitchCaseList getCases() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.cases, cases);
    }

    public void setCases(SwitchCaseList cases) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.cases, this.cases, this.cases = cases);
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
            return getLabelName().wGetAdaptee(false);
            case 1 :
            return getLabelColon().wGetAdaptee(false);
            case 2 :
            return getSwitchKeyword().wGetAdaptee(false);
            case 3 :
            return getExpression().wGetAdaptee(false);
            case 4 :
            return getLeftBrace().wGetAdaptee(false);
            case 5 :
            return getCases().wGetAdaptee(false);
            case 6 :
            return getRightBrace().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLabelName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setLabelColon(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setSwitchKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setExpression(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr));
            break;
            case 4 :
            setLeftBrace(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 5 :
            setCases(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.SwitchCaseList));
            break;
            case 6 :
            setRightBrace(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 7;
    }
}
