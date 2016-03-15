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
public class PointwiseEqualsAdapter extends AbstractEntityAdapter implements PointwiseEquals {
    private static final long serialVersionUID = 1;

    public PointwiseEqualsAdapter(IEntity implementor) {
        super(implementor);
    }

    public PointwiseEqualsAdapter() {
    }

    public void accept(IQueriesVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<PointwiseEquals> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.PointwiseEquals;
    }

    public PathExpression getPexp1() {
        return wGet(QueriesFeatureDescriptorEnum.pexp1).wGetAdapter(QueriesEntityDescriptorEnum.PathExpression);
    }

    public void setPexp1(PathExpression pexp1) {
        wSet(QueriesFeatureDescriptorEnum.pexp1, pexp1);
    }

    public PathExpression getPexp2() {
        return wGet(QueriesFeatureDescriptorEnum.pexp2).wGetAdapter(QueriesEntityDescriptorEnum.PathExpression);
    }

    public void setPexp2(PathExpression pexp2) {
        wSet(QueriesFeatureDescriptorEnum.pexp2, pexp2);
    }
}
