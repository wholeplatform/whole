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
import org.whole.lang.java.model.ForStatement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.Expressions;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.Expression;
import org.whole.lang.java.model.Statement;

/**
 *  @generator Whole
 */
public class ForStatementImpl extends AbstractSimpleEntity implements ForStatement {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ForStatement> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.ForStatement;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.ForStatement_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expressions initializers;

    public Expressions getInitializers() {
        return notifyRequested(JavaFeatureDescriptorEnum.initializers, initializers);
    }

    public void setInitializers(Expressions initializers) {
        notifyChanged(JavaFeatureDescriptorEnum.initializers, this.initializers, this.initializers = initializers);
    }
    private Expression expression;

    public Expression getExpression() {
        return notifyRequested(JavaFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(Expression expression) {
        notifyChanged(JavaFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }
    private Expressions updaters;

    public Expressions getUpdaters() {
        return notifyRequested(JavaFeatureDescriptorEnum.updaters, updaters);
    }

    public void setUpdaters(Expressions updaters) {
        notifyChanged(JavaFeatureDescriptorEnum.updaters, this.updaters, this.updaters = updaters);
    }
    private Statement body;

    public Statement getBody() {
        return notifyRequested(JavaFeatureDescriptorEnum.body, body);
    }

    public void setBody(Statement body) {
        notifyChanged(JavaFeatureDescriptorEnum.body, this.body, this.body = body);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getInitializers().wGetAdaptee(false);
            case 1 :
            return getExpression().wGetAdaptee(false);
            case 2 :
            return getUpdaters().wGetAdaptee(false);
            case 3 :
            return getBody().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setInitializers(value.wGetAdapter(JavaEntityDescriptorEnum.Expressions));
            break;
            case 1 :
            setExpression(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
            break;
            case 2 :
            setUpdaters(value.wGetAdapter(JavaEntityDescriptorEnum.Expressions));
            break;
            case 3 :
            setBody(value.wGetAdapter(JavaEntityDescriptorEnum.Statement));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
