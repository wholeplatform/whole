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
package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.tests.model.IsAssignableTo;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.tests.model.Name;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class IsAssignableToImpl extends AbstractSimpleEntity implements IsAssignableTo {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<IsAssignableTo> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.IsAssignableTo;
    }

    public int wGetEntityOrd() {
        return TestsEntityDescriptorEnum.IsAssignableTo_ord;
    }

    public void accept(ITestsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name descriptorName;

    public Name getDescriptorName() {
        return notifyRequested(TestsFeatureDescriptorEnum.descriptorName, descriptorName);
    }

    public void setDescriptorName(Name descriptorName) {
        notifyChanged(TestsFeatureDescriptorEnum.descriptorName, this.descriptorName, this.descriptorName = descriptorName);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getDescriptorName().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setDescriptorName(value.wGetAdapter(TestsEntityDescriptorEnum.Name));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
