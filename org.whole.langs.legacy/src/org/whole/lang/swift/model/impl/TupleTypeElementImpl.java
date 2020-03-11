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
import org.whole.lang.swift.model.TupleTypeElement;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.Inout;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.AbstractName;
import org.whole.lang.swift.model.AbstractSecondName;
import org.whole.lang.swift.model.Type;
import org.whole.lang.swift.model.Ellipsis;
import org.whole.lang.swift.model.Expr;

/**
 *  @generator Whole
 */
public class TupleTypeElementImpl extends AbstractSimpleEntity implements TupleTypeElement {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TupleTypeElement> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.TupleTypeElement;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.TupleTypeElement_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Inout inOut;

    public Inout getInOut() {
        return notifyRequested(SwiftFeatureDescriptorEnum.inOut, inOut);
    }

    public void setInOut(Inout inOut) {
        notifyChanged(SwiftFeatureDescriptorEnum.inOut, this.inOut, this.inOut = inOut);
    }
    private AbstractName name;

    public AbstractName getName() {
        return notifyRequested(SwiftFeatureDescriptorEnum.name, name);
    }

    public void setName(AbstractName name) {
        notifyChanged(SwiftFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private AbstractSecondName secondName;

    public AbstractSecondName getSecondName() {
        return notifyRequested(SwiftFeatureDescriptorEnum.secondName, secondName);
    }

    public void setSecondName(AbstractSecondName secondName) {
        notifyChanged(SwiftFeatureDescriptorEnum.secondName, this.secondName, this.secondName = secondName);
    }
    private Type type;

    public Type getType() {
        return notifyRequested(SwiftFeatureDescriptorEnum.type, type);
    }

    public void setType(Type type) {
        notifyChanged(SwiftFeatureDescriptorEnum.type, this.type, this.type = type);
    }
    private Ellipsis ellipsis;

    public Ellipsis getEllipsis() {
        return notifyRequested(SwiftFeatureDescriptorEnum.ellipsis, ellipsis);
    }

    public void setEllipsis(Ellipsis ellipsis) {
        notifyChanged(SwiftFeatureDescriptorEnum.ellipsis, this.ellipsis, this.ellipsis = ellipsis);
    }
    private Expr initializer;

    public Expr getInitializer() {
        return notifyRequested(SwiftFeatureDescriptorEnum.initializer, initializer);
    }

    public void setInitializer(Expr initializer) {
        notifyChanged(SwiftFeatureDescriptorEnum.initializer, this.initializer, this.initializer = initializer);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getInOut().wGetAdaptee(false);
            case 1 :
            return getName().wGetAdaptee(false);
            case 2 :
            return getSecondName().wGetAdaptee(false);
            case 3 :
            return getType().wGetAdaptee(false);
            case 4 :
            return getEllipsis().wGetAdaptee(false);
            case 5 :
            return getInitializer().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setInOut(value.wGetAdapter(SwiftEntityDescriptorEnum.Inout));
            break;
            case 1 :
            setName(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractName));
            break;
            case 2 :
            setSecondName(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractSecondName));
            break;
            case 3 :
            setType(value.wGetAdapter(SwiftEntityDescriptorEnum.Type));
            break;
            case 4 :
            setEllipsis(value.wGetAdapter(SwiftEntityDescriptorEnum.Ellipsis));
            break;
            case 5 :
            setInitializer(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 6;
    }
}
