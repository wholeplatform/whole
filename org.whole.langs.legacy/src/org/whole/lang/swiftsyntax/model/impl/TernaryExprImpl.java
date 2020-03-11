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
import org.whole.lang.swiftsyntax.model.TernaryExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Expr;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;

/**
 *  @generator Whole
 */
public class TernaryExprImpl extends AbstractSimpleEntity implements TernaryExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TernaryExpr> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.TernaryExpr;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.TernaryExpr_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expr conditionExpression;

    public Expr getConditionExpression() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.conditionExpression, conditionExpression);
    }

    public void setConditionExpression(Expr conditionExpression) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.conditionExpression, this.conditionExpression, this.conditionExpression = conditionExpression);
    }
    private Token questionMark;

    public Token getQuestionMark() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.questionMark, questionMark);
    }

    public void setQuestionMark(Token questionMark) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.questionMark, this.questionMark, this.questionMark = questionMark);
    }
    private Expr firstChoice;

    public Expr getFirstChoice() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.firstChoice, firstChoice);
    }

    public void setFirstChoice(Expr firstChoice) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.firstChoice, this.firstChoice, this.firstChoice = firstChoice);
    }
    private Token colonMark;

    public Token getColonMark() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.colonMark, colonMark);
    }

    public void setColonMark(Token colonMark) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.colonMark, this.colonMark, this.colonMark = colonMark);
    }
    private Expr secondChoice;

    public Expr getSecondChoice() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.secondChoice, secondChoice);
    }

    public void setSecondChoice(Expr secondChoice) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.secondChoice, this.secondChoice, this.secondChoice = secondChoice);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getConditionExpression().wGetAdaptee(false);
            case 1 :
            return getQuestionMark().wGetAdaptee(false);
            case 2 :
            return getFirstChoice().wGetAdaptee(false);
            case 3 :
            return getColonMark().wGetAdaptee(false);
            case 4 :
            return getSecondChoice().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setConditionExpression(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr));
            break;
            case 1 :
            setQuestionMark(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setFirstChoice(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr));
            break;
            case 3 :
            setColonMark(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 4 :
            setSecondChoice(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
