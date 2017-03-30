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
import org.whole.lang.tests.model.AssertThat;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.tests.model.Expression;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.model.Constraint;

/**
 *  @generator Whole
 */
public class AssertThatImpl extends AbstractSimpleEntity implements AssertThat {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<AssertThat> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.AssertThat;
    }

    public int wGetEntityOrd() {
        return TestsEntityDescriptorEnum.AssertThat_ord;
    }

    public void accept(ITestsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expression subject;

    public Expression getSubject() {
        return notifyRequested(TestsFeatureDescriptorEnum.subject, subject);
    }

    public void setSubject(Expression subject) {
        notifyChanged(TestsFeatureDescriptorEnum.subject, this.subject, this.subject = subject);
    }
    private Constraint constraint;

    public Constraint getConstraint() {
        return notifyRequested(TestsFeatureDescriptorEnum.constraint, constraint);
    }

    public void setConstraint(Constraint constraint) {
        notifyChanged(TestsFeatureDescriptorEnum.constraint, this.constraint, this.constraint = constraint);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSubject().wGetAdaptee(false);
            case 1 :
            return getConstraint().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSubject(value.wGetAdapter(TestsEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setConstraint(value.wGetAdapter(TestsEntityDescriptorEnum.Constraint));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
