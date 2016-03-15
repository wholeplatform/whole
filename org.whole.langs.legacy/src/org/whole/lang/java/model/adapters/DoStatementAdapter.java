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
package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class DoStatementAdapter extends AbstractEntityAdapter implements DoStatement {
    private static final long serialVersionUID = 1;

    public DoStatementAdapter(IEntity implementor) {
        super(implementor);
    }

    public DoStatementAdapter() {
    }

    public void accept(IJavaVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<DoStatement> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.DoStatement;
    }

    public Expression getExpression() {
        return wGet(JavaFeatureDescriptorEnum.expression).wGetAdapter(JavaEntityDescriptorEnum.Expression);
    }

    public void setExpression(Expression expression) {
        wSet(JavaFeatureDescriptorEnum.expression, expression);
    }

    public Statement getBody() {
        return wGet(JavaFeatureDescriptorEnum.body).wGetAdapter(JavaEntityDescriptorEnum.Statement);
    }

    public void setBody(Statement body) {
        wSet(JavaFeatureDescriptorEnum.body, body);
    }
}
