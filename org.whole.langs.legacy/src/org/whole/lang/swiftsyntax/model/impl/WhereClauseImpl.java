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
import org.whole.lang.swiftsyntax.model.WhereClause;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.Expr;

/**
 *  @generator Whole
 */
public class WhereClauseImpl extends AbstractSimpleEntity implements WhereClause {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<WhereClause> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.WhereClause;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.WhereClause_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token whereKeyword;

    public Token getWhereKeyword() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.whereKeyword, whereKeyword);
    }

    public void setWhereKeyword(Token whereKeyword) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.whereKeyword, this.whereKeyword, this.whereKeyword = whereKeyword);
    }
    private Expr guardResult;

    public Expr getGuardResult() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.guardResult, guardResult);
    }

    public void setGuardResult(Expr guardResult) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.guardResult, this.guardResult, this.guardResult = guardResult);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getWhereKeyword().wGetAdaptee(false);
            case 1 :
            return getGuardResult().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setWhereKeyword(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setGuardResult(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Expr));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
