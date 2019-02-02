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
package org.whole.lang.queries.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.queries.model.Subtraction;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.reflect.QueriesEntityDescriptorEnum;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.queries.model.Expression;
import org.whole.lang.queries.reflect.QueriesFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SubtractionImpl extends AbstractSimpleEntity implements Subtraction {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Subtraction> wGetEntityDescriptor() {
        return QueriesEntityDescriptorEnum.Subtraction;
    }

    public int wGetEntityOrd() {
        return QueriesEntityDescriptorEnum.Subtraction_ord;
    }

    public void accept(IQueriesVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression exp1;

    public Expression getExp1() {
        return notifyRequested(QueriesFeatureDescriptorEnum.exp1, exp1);
    }

    public void setExp1(Expression exp1) {
        notifyChanged(QueriesFeatureDescriptorEnum.exp1, this.exp1, this.exp1 = exp1);
    }
    private Expression exp2;

    public Expression getExp2() {
        return notifyRequested(QueriesFeatureDescriptorEnum.exp2, exp2);
    }

    public void setExp2(Expression exp2) {
        notifyChanged(QueriesFeatureDescriptorEnum.exp2, this.exp2, this.exp2 = exp2);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getExp1().wGetAdaptee(false);
            case 1 :
            return getExp2().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setExp1(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setExp2(value.wGetAdapter(QueriesEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
