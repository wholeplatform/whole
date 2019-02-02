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
import org.whole.lang.tests.model.Throws;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.tests.model.ThrowableType;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class ThrowsImpl extends AbstractSimpleEntity implements Throws {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Throws> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.Throws;
    }

    public int wGetEntityOrd() {
        return TestsEntityDescriptorEnum.Throws_ord;
    }

    public void accept(ITestsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private ThrowableType throwableType;

    public ThrowableType getThrowableType() {
        return notifyRequested(TestsFeatureDescriptorEnum.throwableType, throwableType);
    }

    public void setThrowableType(ThrowableType throwableType) {
        notifyChanged(TestsFeatureDescriptorEnum.throwableType, this.throwableType, this.throwableType = throwableType);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getThrowableType().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setThrowableType(value.wGetAdapter(TestsEntityDescriptorEnum.ThrowableType));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
