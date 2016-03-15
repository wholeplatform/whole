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
package org.whole.lang.math.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.math.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ApproximatelyEqualAdapter extends AbstractEntityAdapter implements ApproximatelyEqual {
    private static final long serialVersionUID = 1;

    public ApproximatelyEqualAdapter(IEntity implementor) {
        super(implementor);
    }

    public ApproximatelyEqualAdapter() {
    }

    public void accept(IMathVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<ApproximatelyEqual> wGetEntityDescriptor() {
        return MathEntityDescriptorEnum.ApproximatelyEqual;
    }

    public Expression getExp1() {
        return wGet(MathFeatureDescriptorEnum.exp1).wGetAdapter(MathEntityDescriptorEnum.Expression);
    }

    public void setExp1(Expression exp1) {
        wSet(MathFeatureDescriptorEnum.exp1, exp1);
    }

    public Expression getExp2() {
        return wGet(MathFeatureDescriptorEnum.exp2).wGetAdapter(MathEntityDescriptorEnum.Expression);
    }

    public void setExp2(Expression exp2) {
        wSet(MathFeatureDescriptorEnum.exp2, exp2);
    }
}
