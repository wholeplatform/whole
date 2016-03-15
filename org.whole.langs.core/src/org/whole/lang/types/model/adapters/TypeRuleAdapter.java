/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.types.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.types.reflect.TypesFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class TypeRuleAdapter extends AbstractEntityAdapter implements TypeRule {
    private static final long serialVersionUID = 1;

    public TypeRuleAdapter(IEntity implementor) {
        super(implementor);
    }

    public TypeRuleAdapter() {
    }

    public void accept(ITypesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<TypeRule> wGetEntityDescriptor() {
        return TypesEntityDescriptorEnum.TypeRule;
    }

    public DomainType getDomain() {
        return wGet(TypesFeatureDescriptorEnum.domain).wGetAdapter(TypesEntityDescriptorEnum.DomainType);
    }

    public void setDomain(DomainType domain) {
        wSet(TypesFeatureDescriptorEnum.domain, domain);
    }

    public Type getType() {
        return wGet(TypesFeatureDescriptorEnum.type).wGetAdapter(TypesEntityDescriptorEnum.Type);
    }

    public void setType(Type type) {
        wSet(TypesFeatureDescriptorEnum.type, type);
    }
}
