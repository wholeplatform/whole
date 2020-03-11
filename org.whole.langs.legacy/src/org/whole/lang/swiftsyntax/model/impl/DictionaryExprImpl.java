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
import org.whole.lang.swiftsyntax.model.DictionaryExpr;
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
public class DictionaryExprImpl extends AbstractSimpleEntity implements DictionaryExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<DictionaryExpr> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.DictionaryExpr;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.DictionaryExpr_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token leftSquare;

    public Token getLeftSquare() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.leftSquare, leftSquare);
    }

    public void setLeftSquare(Token leftSquare) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.leftSquare, this.leftSquare, this.leftSquare = leftSquare);
    }
    private Syntax content;

    public Syntax getContent() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.content, content);
    }

    public void setContent(Syntax content) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.content, this.content, this.content = content);
    }
    private Token rightSquare;

    public Token getRightSquare() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.rightSquare, rightSquare);
    }

    public void setRightSquare(Token rightSquare) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.rightSquare, this.rightSquare, this.rightSquare = rightSquare);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLeftSquare().wGetAdaptee(false);
            case 1 :
            return getContent().wGetAdaptee(false);
            case 2 :
            return getRightSquare().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLeftSquare(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setContent(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Syntax));
            break;
            case 2 :
            setRightSquare(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
