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

import org.whole.lang.model.AbstractCollectionCompositeEntity;
import org.whole.lang.tests.model.*;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

/**
 *  @generator Whole
 */
public class SequenceImpl extends AbstractCollectionCompositeEntity<Expression> implements Sequence {
    private static final long serialVersionUID = 1;

    public void accept(ITestsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }

    public int wGetEntityOrd() {
        return TestsEntityDescriptorEnum.Sequence_ord;
    }

    public EntityDescriptor<Sequence> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.Sequence;
    }
}
