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
package org.whole.lang.types.model.impl;

import org.whole.lang.model.AbstractListCompositeEntity;
import org.whole.lang.types.model.*;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.types.reflect.TypesEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator Whole
 */
public class TypeRulesImpl extends AbstractListCompositeEntity<TypeRule> implements TypeRules {
    private static final long serialVersionUID = 1;

    public void accept(ITypesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }

    public int wGetEntityOrd() {
        return TypesEntityDescriptorEnum.TypeRules_ord;
    }

    public EntityDescriptor<TypeRules> wGetEntityDescriptor() {
        return TypesEntityDescriptorEnum.TypeRules;
    }
}
