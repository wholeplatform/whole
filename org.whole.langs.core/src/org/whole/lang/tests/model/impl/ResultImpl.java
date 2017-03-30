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
package org.whole.lang.tests.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.tests.model.Result;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.tests.model.Outcome;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.model.StringLiteral;

/**
 *  @generator Whole
 */
public class ResultImpl extends AbstractSimpleEntity implements Result {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Result> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.Result;
    }

    public int wGetEntityOrd() {
        return TestsEntityDescriptorEnum.Result_ord;
    }

    public void accept(ITestsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Outcome outcome;

    public Outcome getOutcome() {
        return notifyRequested(TestsFeatureDescriptorEnum.outcome, outcome);
    }

    public void setOutcome(Outcome outcome) {
        notifyChanged(TestsFeatureDescriptorEnum.outcome, this.outcome, this.outcome = outcome);
    }
    private StringLiteral location;

    public StringLiteral getLocation() {
        return notifyRequested(TestsFeatureDescriptorEnum.location, location);
    }

    public void setLocation(StringLiteral location) {
        notifyChanged(TestsFeatureDescriptorEnum.location, this.location, this.location = location);
    }
    private StringLiteral cause;

    public StringLiteral getCause() {
        return notifyRequested(TestsFeatureDescriptorEnum.cause, cause);
    }

    public void setCause(StringLiteral cause) {
        notifyChanged(TestsFeatureDescriptorEnum.cause, this.cause, this.cause = cause);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getOutcome().wGetAdaptee(false);
            case 1 :
            return getLocation().wGetAdaptee(false);
            case 2 :
            return getCause().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setOutcome(value.wGetAdapter(TestsEntityDescriptorEnum.Outcome));
            break;
            case 1 :
            setLocation(value.wGetAdapter(TestsEntityDescriptorEnum.StringLiteral));
            break;
            case 2 :
            setCause(value.wGetAdapter(TestsEntityDescriptorEnum.StringLiteral));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
