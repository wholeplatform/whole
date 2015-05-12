/**
 *  Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.patterns.model.VariantSelectionPoint;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.patterns.visitors.IPatternsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.patterns.model.Name;
import org.whole.lang.patterns.reflect.PatternsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.patterns.model.Variants;

/**
 *  @generator Whole
 */
public class VariantSelectionPointImpl extends AbstractSimpleEntity implements VariantSelectionPoint {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<VariantSelectionPoint> wGetEntityDescriptor() {
        return PatternsEntityDescriptorEnum.VariantSelectionPoint;
    }

    public int wGetEntityOrd() {
        return PatternsEntityDescriptorEnum.VariantSelectionPoint_ord;
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
    private Variants variants;

    public Variants getVariants() {
        return notifyRequested(PatternsFeatureDescriptorEnum.variants, variants);
    }

    public void setVariants(Variants variants) {
        notifyChanged(PatternsFeatureDescriptorEnum.variants, this.variants, this.variants = variants);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getVariability().wGetAdaptee(false);
            case 1 :
            return getVariants().wGetAdaptee(false);
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
            setVariants(value.wGetAdapter(PatternsEntityDescriptorEnum.Variants));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
