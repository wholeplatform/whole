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
import org.whole.lang.swiftsyntax.model.CodeBlock;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.CodeBlockItemList;

/**
 *  @generator Whole
 */
public class CodeBlockImpl extends AbstractSimpleEntity implements CodeBlock {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<CodeBlock> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.CodeBlock;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.CodeBlock_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token leftBrace;

    public Token getLeftBrace() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leftBrace, leftBrace);
    }

    public void setLeftBrace(Token leftBrace) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leftBrace, this.leftBrace, this.leftBrace = leftBrace);
    }
    private CodeBlockItemList statements;

    public CodeBlockItemList getStatements() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.statements, statements);
    }

    public void setStatements(CodeBlockItemList statements) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.statements, this.statements, this.statements = statements);
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
            return getLeftBrace().wGetAdaptee(false);
            case 1 :
            return getStatements().wGetAdaptee(false);
            case 2 :
            return getRightBrace().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLeftBrace(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setStatements(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.CodeBlockItemList));
            break;
            case 2 :
            setRightBrace(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
