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
import org.whole.lang.swiftsyntax.model.DoStmt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.CodeBlock;
import org.whole.lang.swiftsyntax.model.CatchClauseList;

/**
 *  @generator Whole
 */
public class DoStmtImpl extends AbstractSimpleEntity implements DoStmt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<DoStmt> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.DoStmt;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.DoStmt_ord;
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
    private Token doKeyword;

    public Token getDoKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.doKeyword, doKeyword);
    }

    public void setDoKeyword(Token doKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.doKeyword, this.doKeyword, this.doKeyword = doKeyword);
    }
    private CodeBlock body;

    public CodeBlock getBody() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.body, body);
    }

    public void setBody(CodeBlock body) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.body, this.body, this.body = body);
    }
    private CatchClauseList catchClauses;

    public CatchClauseList getCatchClauses() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.catchClauses, catchClauses);
    }

    public void setCatchClauses(CatchClauseList catchClauses) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.catchClauses, this.catchClauses, this.catchClauses = catchClauses);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabelName().wGetAdaptee(false);
            case 1 :
            return getLabelColon().wGetAdaptee(false);
            case 2 :
            return getDoKeyword().wGetAdaptee(false);
            case 3 :
            return getBody().wGetAdaptee(false);
            case 4 :
            return getCatchClauses().wGetAdaptee(false);
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
            setDoKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setBody(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlock));
            break;
            case 4 :
            setCatchClauses(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CatchClauseList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 5;
    }
}
