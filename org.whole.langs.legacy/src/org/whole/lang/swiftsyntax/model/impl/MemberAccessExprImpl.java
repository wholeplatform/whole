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
import org.whole.lang.swiftsyntax.model.MemberAccessExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Expr;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.model.DeclNameArguments;

/**
 *  @generator Whole
 */
public class MemberAccessExprImpl extends AbstractSimpleEntity implements MemberAccessExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<MemberAccessExpr> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.MemberAccessExpr;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.MemberAccessExpr_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expr base;

    public Expr getBase() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.base, base);
    }

    public void setBase(Expr base) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.base, this.base, this.base = base);
    }
    private Token dot;

    public Token getDot() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.dot, dot);
    }

    public void setDot(Token dot) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.dot, this.dot, this.dot = dot);
    }
    private Token name;

    public Token getName() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.name, name);
    }

    public void setName(Token name) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private DeclNameArguments declNameArguments;

    public DeclNameArguments getDeclNameArguments() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.declNameArguments, declNameArguments);
    }

    public void setDeclNameArguments(DeclNameArguments declNameArguments) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.declNameArguments, this.declNameArguments, this.declNameArguments = declNameArguments);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getBase().wGetAdaptee(false);
            case 1 :
            return getDot().wGetAdaptee(false);
            case 2 :
            return getName().wGetAdaptee(false);
            case 3 :
            return getDeclNameArguments().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setBase(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr));
            break;
            case 1 :
            setDot(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 2 :
            setName(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 3 :
            setDeclNameArguments(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.DeclNameArguments));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
