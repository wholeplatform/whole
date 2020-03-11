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
package org.whole.lang.swift.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swift.model.MemberAccessExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Expr;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.DotEnum;
import org.whole.lang.swift.model.Identifier;
import org.whole.lang.swift.model.DeclNameArgumentList;

/**
 *  @generator Whole
 */
public class MemberAccessExprImpl extends AbstractSimpleEntity implements MemberAccessExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<MemberAccessExpr> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.MemberAccessExpr;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.MemberAccessExpr_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expr base;

    public Expr getBase() {
        return notifyRequested(SwiftFeatureDescriptorEnum.base, base);
    }

    public void setBase(Expr base) {
        notifyChanged(SwiftFeatureDescriptorEnum.base, this.base, this.base = base);
    }
    private DotEnum dot;

    public DotEnum getDot() {
        return notifyRequested(SwiftFeatureDescriptorEnum.dot, dot);
    }

    public void setDot(DotEnum dot) {
        notifyChanged(SwiftFeatureDescriptorEnum.dot, this.dot, this.dot = dot);
    }
    private Identifier name;

    public Identifier getName() {
        return notifyRequested(SwiftFeatureDescriptorEnum.name, name);
    }

    public void setName(Identifier name) {
        notifyChanged(SwiftFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private DeclNameArgumentList declNameArguments;

    public DeclNameArgumentList getDeclNameArguments() {
        return notifyRequested(SwiftFeatureDescriptorEnum.declNameArguments, declNameArguments);
    }

    public void setDeclNameArguments(DeclNameArgumentList declNameArguments) {
        notifyChanged(SwiftFeatureDescriptorEnum.declNameArguments, this.declNameArguments, this.declNameArguments = declNameArguments);
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
            setBase(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            case 1 :
            setDot(value.wGetAdapter(SwiftEntityDescriptorEnum.DotEnum));
            break;
            case 2 :
            setName(value.wGetAdapter(SwiftEntityDescriptorEnum.Identifier));
            break;
            case 3 :
            setDeclNameArguments(value.wGetAdapter(SwiftEntityDescriptorEnum.DeclNameArgumentList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
