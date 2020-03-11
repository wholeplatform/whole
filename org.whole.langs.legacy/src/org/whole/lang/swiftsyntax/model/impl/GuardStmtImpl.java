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
import org.whole.lang.swiftsyntax.model.GuardStmt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.ConditionElementList;
import org.whole.lang.swiftsyntax.model.CodeBlock;

/**
 *  @generator Whole
 */
public class GuardStmtImpl extends AbstractSimpleEntity implements GuardStmt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<GuardStmt> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.GuardStmt;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.GuardStmt_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token guardKeyword;

    public Token getGuardKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.guardKeyword, guardKeyword);
    }

    public void setGuardKeyword(Token guardKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.guardKeyword, this.guardKeyword, this.guardKeyword = guardKeyword);
    }
    private ConditionElementList conditions;

    public ConditionElementList getConditions() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.conditions, conditions);
    }

    public void setConditions(ConditionElementList conditions) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.conditions, this.conditions, this.conditions = conditions);
    }
    private Token elseKeyword;

    public Token getElseKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.elseKeyword, elseKeyword);
    }

    public void setElseKeyword(Token elseKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.elseKeyword, this.elseKeyword, this.elseKeyword = elseKeyword);
    }
    private CodeBlock body;

    public CodeBlock getBody() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.body, body);
    }

    public void setBody(CodeBlock body) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.body, this.body, this.body = body);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getGuardKeyword().wGetAdaptee(false);
            case 1 :
            return getConditions().wGetAdaptee(false);
            case 2 :
            return getElseKeyword().wGetAdaptee(false);
            case 3 :
            return getBody().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setGuardKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setConditions(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ConditionElementList));
            break;
            case 2 :
            setElseKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setBody(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlock));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
