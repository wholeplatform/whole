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
package org.whole.lang.java.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.java.model.LambdaExpression;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.LambdaParameters;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.ExpressionOrStatement;

/**
 *  @generator Whole
 */
public class LambdaExpressionImpl extends AbstractSimpleEntity implements LambdaExpression {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<LambdaExpression> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.LambdaExpression;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.LambdaExpression_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private LambdaParameters parameters;

    public LambdaParameters getParameters() {
        return notifyRequested(JavaFeatureDescriptorEnum.parameters, parameters);
    }

    public void setParameters(LambdaParameters parameters) {
        notifyChanged(JavaFeatureDescriptorEnum.parameters, this.parameters, this.parameters = parameters);
    }
    private ExpressionOrStatement body;

    public ExpressionOrStatement getBody() {
        return notifyRequested(JavaFeatureDescriptorEnum.body, body);
    }

    public void setBody(ExpressionOrStatement body) {
        notifyChanged(JavaFeatureDescriptorEnum.body, this.body, this.body = body);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getParameters().wGetAdaptee(false);
            case 1 :
            return getBody().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setParameters(value.wGetAdapter(JavaEntityDescriptorEnum.LambdaParameters));
            break;
            case 1 :
            setBody(value.wGetAdapter(JavaEntityDescriptorEnum.ExpressionOrStatement));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
