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
import org.whole.lang.swiftsyntax.model.DeclModifier;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class DeclModifierImpl extends AbstractSimpleEntity implements DeclModifier {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<DeclModifier> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.DeclModifier;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.DeclModifier_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token name;

    public Token getName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.name, name);
    }

    public void setName(Token name) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Token detailLeftParen;

    public Token getDetailLeftParen() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.detailLeftParen, detailLeftParen);
    }

    public void setDetailLeftParen(Token detailLeftParen) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.detailLeftParen, this.detailLeftParen, this.detailLeftParen = detailLeftParen);
    }
    private Token detail;

    public Token getDetail() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.detail, detail);
    }

    public void setDetail(Token detail) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.detail, this.detail, this.detail = detail);
    }
    private Token detailRightParen;

    public Token getDetailRightParen() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.detailRightParen, detailRightParen);
    }

    public void setDetailRightParen(Token detailRightParen) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.detailRightParen, this.detailRightParen, this.detailRightParen = detailRightParen);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getDetailLeftParen().wGetAdaptee(false);
            case 2 :
            return getDetail().wGetAdaptee(false);
            case 3 :
            return getDetailRightParen().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setDetailLeftParen(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setDetail(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setDetailRightParen(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
