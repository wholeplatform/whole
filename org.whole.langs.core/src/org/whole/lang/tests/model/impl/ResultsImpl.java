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
import org.whole.lang.tests.model.Results;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.tests.model.IntLiteral;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class ResultsImpl extends AbstractSimpleEntity implements Results {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Results> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.Results;
    }

    public int wGetEntityOrd() {
        return TestsEntityDescriptorEnum.Results_ord;
    }

    public void accept(ITestsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private IntLiteral successes;

    public IntLiteral getSuccesses() {
        return notifyRequested(TestsFeatureDescriptorEnum.successes, successes);
    }

    public void setSuccesses(IntLiteral successes) {
        notifyChanged(TestsFeatureDescriptorEnum.successes, this.successes, this.successes = successes);
    }
    private IntLiteral failures;

    public IntLiteral getFailures() {
        return notifyRequested(TestsFeatureDescriptorEnum.failures, failures);
    }

    public void setFailures(IntLiteral failures) {
        notifyChanged(TestsFeatureDescriptorEnum.failures, this.failures, this.failures = failures);
    }
    private IntLiteral errors;

    public IntLiteral getErrors() {
        return notifyRequested(TestsFeatureDescriptorEnum.errors, errors);
    }

    public void setErrors(IntLiteral errors) {
        notifyChanged(TestsFeatureDescriptorEnum.errors, this.errors, this.errors = errors);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSuccesses().wGetAdaptee(false);
            case 1 :
            return getFailures().wGetAdaptee(false);
            case 2 :
            return getErrors().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSuccesses(value.wGetAdapter(TestsEntityDescriptorEnum.IntLiteral));
            break;
            case 1 :
            setFailures(value.wGetAdapter(TestsEntityDescriptorEnum.IntLiteral));
            break;
            case 2 :
            setErrors(value.wGetAdapter(TestsEntityDescriptorEnum.IntLiteral));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
