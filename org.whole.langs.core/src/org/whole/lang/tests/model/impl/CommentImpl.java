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
import org.whole.lang.tests.model.Comment;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.tests.reflect.TestsEntityDescriptorEnum;
import org.whole.lang.tests.visitors.ITestsVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.tests.model.CommentKind;
import org.whole.lang.tests.reflect.TestsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.tests.model.Description;

/**
 *  @generator Whole
 */
public class CommentImpl extends AbstractSimpleEntity implements Comment {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Comment> wGetEntityDescriptor() {
        return TestsEntityDescriptorEnum.Comment;
    }

    public int wGetEntityOrd() {
        return TestsEntityDescriptorEnum.Comment_ord;
    }

    public void accept(ITestsVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private CommentKind kind;

    public CommentKind getKind() {
        return notifyRequested(TestsFeatureDescriptorEnum.kind, kind);
    }

    public void setKind(CommentKind kind) {
        notifyChanged(TestsFeatureDescriptorEnum.kind, this.kind, this.kind = kind);
    }
    private Description description;

    public Description getDescription() {
        return notifyRequested(TestsFeatureDescriptorEnum.description, description);
    }

    public void setDescription(Description description) {
        notifyChanged(TestsFeatureDescriptorEnum.description, this.description, this.description = description);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getKind().wGetAdaptee(false);
            case 1 :
            return getDescription().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setKind(value.wGetAdapter(TestsEntityDescriptorEnum.CommentKind));
            break;
            case 1 :
            setDescription(value.wGetAdapter(TestsEntityDescriptorEnum.Description));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
