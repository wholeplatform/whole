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
package org.whole.lang.swift.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.swift.model.DictionaryElement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Expr;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class DictionaryElementImpl extends AbstractSimpleEntity implements DictionaryElement {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<DictionaryElement> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.DictionaryElement;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.DictionaryElement_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Expr keyExpression;

    public Expr getKeyExpression() {
        return notifyRequested(SwiftFeatureDescriptorEnum.keyExpression, keyExpression);
    }

    public void setKeyExpression(Expr keyExpression) {
        notifyChanged(SwiftFeatureDescriptorEnum.keyExpression, this.keyExpression, this.keyExpression = keyExpression);
    }
    private Expr valueExpression;

    public Expr getValueExpression() {
        return notifyRequested(SwiftFeatureDescriptorEnum.valueExpression, valueExpression);
    }

    public void setValueExpression(Expr valueExpression) {
        notifyChanged(SwiftFeatureDescriptorEnum.valueExpression, this.valueExpression, this.valueExpression = valueExpression);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getKeyExpression().wGetAdaptee(false);
            case 1 :
            return getValueExpression().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setKeyExpression(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            case 1 :
            setValueExpression(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
