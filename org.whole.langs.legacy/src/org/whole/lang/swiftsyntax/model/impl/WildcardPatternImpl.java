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
import org.whole.lang.swiftsyntax.model.WildcardPattern;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swiftsyntax.model.Token;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.model.TypeAnnotation;

/**
 *  @generator Whole
 */
public class WildcardPatternImpl extends AbstractSimpleEntity implements WildcardPattern {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<WildcardPattern> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.WildcardPattern;
    }

    public int wGetEntityOrd() {
        return SwiftSyntaxEntityDescriptorEnum.WildcardPattern_ord;
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Token wildcard;

    public Token getWildcard() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.wildcard, wildcard);
    }

    public void setWildcard(Token wildcard) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.wildcard, this.wildcard, this.wildcard = wildcard);
    }
    private TypeAnnotation typeAnnotation;

    public TypeAnnotation getTypeAnnotation() {
        return notifyRequested(SwiftSyntaxFeatureDescriptorEnum.typeAnnotation, typeAnnotation);
    }

    public void setTypeAnnotation(TypeAnnotation typeAnnotation) {
        notifyChanged(SwiftSyntaxFeatureDescriptorEnum.typeAnnotation, this.typeAnnotation, this.typeAnnotation = typeAnnotation);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getWildcard().wGetAdaptee(false);
            case 1 :
            return getTypeAnnotation().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setWildcard(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token));
            break;
            case 1 :
            setTypeAnnotation(value.wGetAdapter(SwiftSyntaxEntityDescriptorEnum.TypeAnnotation));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
