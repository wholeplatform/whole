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
package org.whole.lang.math.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.math.model.Stream;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.math.reflect.MathEntityDescriptorEnum;
import org.whole.lang.math.visitors.IMathVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.math.model.Constructor;
import org.whole.lang.math.reflect.MathFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class StreamImpl extends AbstractSimpleEntity implements Stream {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Stream> wGetEntityDescriptor() {
        return MathEntityDescriptorEnum.Stream;
    }

    public int wGetEntityOrd() {
        return MathEntityDescriptorEnum.Stream_ord;
    }

    public void accept(IMathVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Constructor elements;

    public Constructor getElements() {
        return notifyRequested(MathFeatureDescriptorEnum.elements, elements);
    }

    public void setElements(Constructor elements) {
        notifyChanged(MathFeatureDescriptorEnum.elements, this.elements, this.elements = elements);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getElements().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setElements(value.wGetAdapter(MathEntityDescriptorEnum.Constructor));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
