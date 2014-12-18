/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.java.model.SwitchStatement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.model.Expression;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.Statements;

/**
 *  @generator Whole
 */
public class SwitchStatementImpl extends AbstractSimpleEntity implements SwitchStatement {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SwitchStatement> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.SwitchStatement;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.SwitchStatement_ord;
    }

    public void accept(IJavaVisitor visitor) {
        visitor.visit(this);
    }
    private Expression expression;

    public Expression getExpression() {
        return notifyRequested(JavaFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(Expression expression) {
        notifyChanged(JavaFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }
    private Statements statements;

    public Statements getStatements() {
        return notifyRequested(JavaFeatureDescriptorEnum.statements, statements);
    }

    public void setStatements(Statements statements) {
        notifyChanged(JavaFeatureDescriptorEnum.statements, this.statements, this.statements = statements);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getExpression().wGetAdaptee(false);
            case 1 :
            return getStatements().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setExpression(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
            break;
            case 1 :
            setStatements(value.wGetAdapter(JavaEntityDescriptorEnum.Statements));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
