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
package org.whole.lang.swiftsyntax.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.swiftsyntax.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class MemberTypeIdentifierAdapter extends AbstractEntityAdapter implements MemberTypeIdentifier {
    private static final long serialVersionUID = 1;

    public MemberTypeIdentifierAdapter(IEntity implementor) {
        super(implementor);
    }

    public MemberTypeIdentifierAdapter() {
    }

    public void accept(ISwiftSyntaxVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<MemberTypeIdentifier> wGetEntityDescriptor() {
        return SwiftSyntaxEntityDescriptorEnum.MemberTypeIdentifier;
    }

    public Type getBaseType() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.baseType).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Type);
    }

    public void setBaseType(Type baseType) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.baseType, baseType);
    }

    public Token getPeriod() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.period).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setPeriod(Token period) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.period, period);
    }

    public Token getName() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.name).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.Token);
    }

    public void setName(Token name) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.name, name);
    }

    public GenericArgumentClause getGenericArgumentClause() {
        return wGet(SwiftSyntaxFeatureDescriptorEnum.genericArgumentClause).wGetAdapter(SwiftSyntaxEntityDescriptorEnum.GenericArgumentClause);
    }

    public void setGenericArgumentClause(GenericArgumentClause genericArgumentClause) {
        wSet(SwiftSyntaxFeatureDescriptorEnum.genericArgumentClause, genericArgumentClause);
    }
}
