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
package org.whole.lang.tests.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.tests.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class ResultAdapter extends AbstractEntityAdapter implements Result {
    private static final long serialVersionUID = 1;

    public ResultAdapter(IEntity implementor) {
        super(implementor);
    }

    public ResultAdapter() {
    }

    public void accept(ITestsVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Result> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.Result;
    }

    public Outcome getOutcome() {
        return wGet(TestsFeatureDescriptorEnum.outcome).wGetAdapter(TestsEntityDescriptorEnum.Outcome);
    }

    public void setOutcome(Outcome outcome) {
        wSet(TestsFeatureDescriptorEnum.outcome, outcome);
    }

    public StringLiteral getLocation() {
        return wGet(TestsFeatureDescriptorEnum.location).wGetAdapter(TestsEntityDescriptorEnum.StringLiteral);
    }

    public void setLocation(StringLiteral location) {
        wSet(TestsFeatureDescriptorEnum.location, location);
    }

    public StringLiteral getCause() {
        return wGet(TestsFeatureDescriptorEnum.cause).wGetAdapter(TestsEntityDescriptorEnum.StringLiteral);
    }

    public void setCause(StringLiteral cause) {
        wSet(TestsFeatureDescriptorEnum.cause, cause);
    }
}
