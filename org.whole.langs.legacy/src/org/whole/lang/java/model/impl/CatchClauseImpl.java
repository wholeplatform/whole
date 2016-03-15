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
package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.CatchClause;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.SingleVariableDeclaration;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.Block;

/**
 *  @generator Whole
 */
public class CatchClauseImpl extends AbstractSimpleEntity implements CatchClause {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<CatchClause> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.CatchClause;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.CatchClause_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private SingleVariableDeclaration exception;

    public SingleVariableDeclaration getException() {
        return notifyRequested(JavaFeatureDescriptorEnum.exception, exception);
    }

    public void setException(SingleVariableDeclaration exception) {
        notifyChanged(JavaFeatureDescriptorEnum.exception, this.exception, this.exception = exception);
    }
    private Block body;

    public Block getBody() {
        return notifyRequested(JavaFeatureDescriptorEnum.body, body);
    }

    public void setBody(Block body) {
        notifyChanged(JavaFeatureDescriptorEnum.body, this.body, this.body = body);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getException().wGetAdaptee(false);
            case 1 :
            return getBody().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setException(value.wGetAdapter(JavaEntityDescriptorEnum.SingleVariableDeclaration));
            break;
            case 1 :
            setBody(value.wGetAdapter(JavaEntityDescriptorEnum.Block));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
