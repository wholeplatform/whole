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
import org.whole.lang.java.model.BreakStatement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.model.SimpleName;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class BreakStatementImpl extends AbstractSimpleEntity implements BreakStatement {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<BreakStatement> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.BreakStatement;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.BreakStatement_ord;
    }

    public void accept(IJavaVisitor visitor) {
        visitor.visit(this);
    }
    private SimpleName label;

    public SimpleName getLabel() {
        return notifyRequested(JavaFeatureDescriptorEnum.label, label);
    }

    public void setLabel(SimpleName label) {
        notifyChanged(JavaFeatureDescriptorEnum.label, this.label, this.label = label);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getLabel().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setLabel(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
