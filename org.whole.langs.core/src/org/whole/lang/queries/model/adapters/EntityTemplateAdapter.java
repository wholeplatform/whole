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
package org.whole.lang.queries.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class EntityTemplateAdapter extends AbstractEntityAdapter implements EntityTemplate {
    private static final long serialVersionUID = 1;

    public EntityTemplateAdapter(IEntity implementor) {
        super(implementor);
    }

    public EntityTemplateAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<EntityTemplate> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.EntityTemplate;
    }

    public EntityType getName() {
        return wGet(QueriesFeatureDescriptorEnum.name).wGetAdapter(QueriesEntityDescriptorEnum.EntityType);
    }

    public void setName(EntityType name) {
        wSet(QueriesFeatureDescriptorEnum.name, name);
    }

    public Constraints getConstraints() {
        return wGet(QueriesFeatureDescriptorEnum.constraints).wGetAdapter(QueriesEntityDescriptorEnum.Constraints);
    }

    public void setConstraints(Constraints constraints) {
        wSet(QueriesFeatureDescriptorEnum.constraints, constraints);
    }
}
