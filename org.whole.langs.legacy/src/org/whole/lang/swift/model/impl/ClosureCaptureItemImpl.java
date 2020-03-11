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
import org.whole.lang.swift.model.ClosureCaptureItem;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.CaptureSpecifierEnum;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.Identifier;
import org.whole.lang.swift.model.Expr;

/**
 *  @generator Whole
 */
public class ClosureCaptureItemImpl extends AbstractSimpleEntity implements ClosureCaptureItem {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ClosureCaptureItem> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.ClosureCaptureItem;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.ClosureCaptureItem_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private CaptureSpecifierEnum specifier;

    public CaptureSpecifierEnum getSpecifier() {
        return notifyRequested(SwiftFeatureDescriptorEnum.specifier, specifier);
    }

    public void setSpecifier(CaptureSpecifierEnum specifier) {
        notifyChanged(SwiftFeatureDescriptorEnum.specifier, this.specifier, this.specifier = specifier);
    }
    private Identifier name;

    public Identifier getName() {
        return notifyRequested(SwiftFeatureDescriptorEnum.name, name);
    }

    public void setName(Identifier name) {
        notifyChanged(SwiftFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Expr expression;

    public Expr getExpression() {
        return notifyRequested(SwiftFeatureDescriptorEnum.expression, expression);
    }

    public void setExpression(Expr expression) {
        notifyChanged(SwiftFeatureDescriptorEnum.expression, this.expression, this.expression = expression);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSpecifier().wGetAdaptee(false);
            case 1 :
            return getName().wGetAdaptee(false);
            case 2 :
            return getExpression().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSpecifier(value.wGetAdapter(SwiftEntityDescriptorEnum.CaptureSpecifierEnum));
            break;
            case 1 :
            setName(value.wGetAdapter(SwiftEntityDescriptorEnum.Identifier));
            break;
            case 2 :
            setExpression(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
