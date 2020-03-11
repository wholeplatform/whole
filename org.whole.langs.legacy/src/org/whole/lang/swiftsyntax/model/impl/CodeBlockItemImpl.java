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
import org.whole.lang.swiftsyntax.model.CodeBlockItem;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Syntax;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;

/**
 *  @generator Whole
 */
public class CodeBlockItemImpl extends AbstractSimpleEntity implements CodeBlockItem {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<CodeBlockItem> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.CodeBlockItem;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.CodeBlockItem_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Syntax item;

    public Syntax getItem() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.item, item);
    }

    public void setItem(Syntax item) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.item, this.item, this.item = item);
    }
    private Token semicolon;

    public Token getSemicolon() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.semicolon, semicolon);
    }

    public void setSemicolon(Token semicolon) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.semicolon, this.semicolon, this.semicolon = semicolon);
    }
    private Syntax errorTokens;

    public Syntax getErrorTokens() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.errorTokens, errorTokens);
    }

    public void setErrorTokens(Syntax errorTokens) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.errorTokens, this.errorTokens, this.errorTokens = errorTokens);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getItem().wGetAdaptee(false);
            case 1 :
            return getSemicolon().wGetAdaptee(false);
            case 2 :
            return getErrorTokens().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setItem(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Syntax));
            break;
            case 1 :
            setSemicolon(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setErrorTokens(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Syntax));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
