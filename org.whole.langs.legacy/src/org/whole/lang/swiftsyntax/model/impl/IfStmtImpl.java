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
import org.whole.lang.swiftsyntax.model.IfStmt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.ConditionElementList;
import org.whole.lang.swiftsyntax.model.CodeBlock;
import org.whole.lang.swiftsyntax.model.Syntax;

/**
 *  @generator Whole
 */
public class IfStmtImpl extends AbstractSimpleEntity implements IfStmt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<IfStmt> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.IfStmt;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.IfStmt_ord;
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
    private Token ifKeyword;

    public Token getIfKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.ifKeyword, ifKeyword);
    }

    public void setIfKeyword(Token ifKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.ifKeyword, this.ifKeyword, this.ifKeyword = ifKeyword);
    }
    private ConditionElementList conditions;

    public ConditionElementList getConditions() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.conditions, conditions);
    }

    public void setConditions(ConditionElementList conditions) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.conditions, this.conditions, this.conditions = conditions);
    }
    private CodeBlock body;

    public CodeBlock getBody() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.body, body);
    }

    public void setBody(CodeBlock body) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.body, this.body, this.body = body);
    }
    private Token elseKeyword;

    public Token getElseKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.elseKeyword, elseKeyword);
    }

    public void setElseKeyword(Token elseKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.elseKeyword, this.elseKeyword, this.elseKeyword = elseKeyword);
    }
    private Syntax elseBody;

    public Syntax getElseBody() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.elseBody, elseBody);
    }

    public void setElseBody(Syntax elseBody) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.elseBody, this.elseBody, this.elseBody = elseBody);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabelName().wGetAdaptee(false);
            case 1 :
            return getLabelColon().wGetAdaptee(false);
            case 2 :
            return getIfKeyword().wGetAdaptee(false);
            case 3 :
            return getConditions().wGetAdaptee(false);
            case 4 :
            return getBody().wGetAdaptee(false);
            case 5 :
            return getElseKeyword().wGetAdaptee(false);
            case 6 :
            return getElseBody().wGetAdaptee(false);
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
            setIfKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setConditions(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.ConditionElementList));
            break;
            case 4 :
            setBody(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlock));
            break;
            case 5 :
            setElseKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 6 :
            setElseBody(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Syntax));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 7;
    }
}
