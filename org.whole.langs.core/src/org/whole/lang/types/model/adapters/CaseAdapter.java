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
public class CaseAdapter extends AbstractEntityAdapter implements Case {
    private static final long serialVersionUID = 1;

    public CaseAdapter(IEntity implementor) {
        super(implementor);
    }

    public CaseAdapter() {
    }

    public void accept(ITypesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Case> wGetEntityDescriptor() {
        return TypesEntityDescriptorEnum.Case;
    }

    public BasicType getType() {
        return wGet(TypesFeatureDescriptorEnum.type).wGetAdapter(TypesEntityDescriptorEnum.BasicType);
    }

    public void setType(BasicType type) {
        wSet(TypesFeatureDescriptorEnum.type, type);
    }

    public Expressions getExpressions() {
        return wGet(TypesFeatureDescriptorEnum.expressions).wGetAdapter(TypesEntityDescriptorEnum.Expressions);
    }

    public void setExpressions(Expressions expressions) {
        wSet(TypesFeatureDescriptorEnum.expressions, expressions);
    }
}
