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
import org.whole.lang.swiftsyntax.model.DeferStmt;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.CodeBlock;

/**
 *  @generator Whole
 */
public class DeferStmtImpl extends AbstractSimpleEntity implements DeferStmt {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<DeferStmt> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.DeferStmt;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.DeferStmt_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token deferKeyword;

    public Token getDeferKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.deferKeyword, deferKeyword);
    }

    public void setDeferKeyword(Token deferKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.deferKeyword, this.deferKeyword, this.deferKeyword = deferKeyword);
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
            return getDeferKeyword().wGetAdaptee(false);
            case 1 :
            return getBody().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setDeferKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setBody(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlock));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
