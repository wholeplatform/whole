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
package org.whole.lang.patterns.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.patterns.model.VariantSelector;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.patterns.model.Name;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.model.Expression;

/**
 *  @generator Whole
 */
public class VariantSelectorImpl extends AbstractSimpleEntity implements VariantSelector {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<VariantSelector> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.VariantSelector;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.VariantSelector_ord;
    }

    public void accept(IPatternsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name variability;

    public Name getVariability() {
        return notifyRequested(PatternsFeatureDescriptorEnum.variability, variability);
    }

    public void setVariability(Name variability) {
        notifyChanged(PatternsFeatureDescriptorEnum.variability, this.variability, this.variability = variability);
    }
    private Expression variant;

    public Expression getVariant() {
        return notifyRequested(PatternsFeatureDescriptorEnum.variant, variant);
    }

    public void setVariant(Expression variant) {
        notifyChanged(PatternsFeatureDescriptorEnum.variant, this.variant, this.variant = variant);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getVariability().wGetAdaptee(false);
            case 1 :
            return getVariant().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setVariability(value.wGetAdapter(PatternsEntityDescriptorEnum.Name));
            break;
            case 1 :
            setVariant(value.wGetAdapter(PatternsEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
