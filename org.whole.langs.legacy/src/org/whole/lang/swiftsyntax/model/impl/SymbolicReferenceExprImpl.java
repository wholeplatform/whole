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
import org.whole.lang.swiftsyntax.model.SymbolicReferenceExpr;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.GenericArgumentClause;

/**
 *  @generator Whole
 */
public class SymbolicReferenceExprImpl extends AbstractSimpleEntity implements SymbolicReferenceExpr {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SymbolicReferenceExpr> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.SymbolicReferenceExpr;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.SymbolicReferenceExpr_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token identifier;

    public Token getIdentifier() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.identifier, identifier);
    }

    public void setIdentifier(Token identifier) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.identifier, this.identifier, this.identifier = identifier);
    }
    private GenericArgumentClause genericArgumentClause;

    public GenericArgumentClause getGenericArgumentClause() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.genericArgumentClause, genericArgumentClause);
    }

    public void setGenericArgumentClause(GenericArgumentClause genericArgumentClause) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.genericArgumentClause, this.genericArgumentClause, this.genericArgumentClause = genericArgumentClause);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getIdentifier().wGetAdaptee(false);
            case 1 :
            return getGenericArgumentClause().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setIdentifier(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setGenericArgumentClause(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
