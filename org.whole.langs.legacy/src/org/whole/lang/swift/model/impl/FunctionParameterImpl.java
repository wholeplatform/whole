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
import org.whole.lang.swift.model.FunctionParameter;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.AttributeList;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.AbstractFirstName;
import org.whole.lang.swift.model.AbstractSecondName;
import org.whole.lang.swift.model.Type;
import org.whole.lang.swift.model.Ellipsis;
import org.whole.lang.swift.model.Expr;

/**
 *  @generator Whole
 */
public class FunctionParameterImpl extends AbstractSimpleEntity implements FunctionParameter {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<FunctionParameter> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.FunctionParameter;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.FunctionParameter_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private AttributeList attributes;

    public AttributeList getAttributes() {
        return notifyRequested(SwiftFeatureDescriptorEnum.attributes, attributes);
    }

    public void setAttributes(AttributeList attributes) {
        notifyChanged(SwiftFeatureDescriptorEnum.attributes, this.attributes, this.attributes = attributes);
    }
    private AbstractFirstName firstName;

    public AbstractFirstName getFirstName() {
        return notifyRequested(SwiftFeatureDescriptorEnum.firstName, firstName);
    }

    public void setFirstName(AbstractFirstName firstName) {
        notifyChanged(SwiftFeatureDescriptorEnum.firstName, this.firstName, this.firstName = firstName);
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
    private Expr defaultArgument;

    public Expr getDefaultArgument() {
        return notifyRequested(SwiftFeatureDescriptorEnum.defaultArgument, defaultArgument);
    }

    public void setDefaultArgument(Expr defaultArgument) {
        notifyChanged(SwiftFeatureDescriptorEnum.defaultArgument, this.defaultArgument, this.defaultArgument = defaultArgument);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getAttributes().wGetAdaptee(false);
            case 1 :
            return getFirstName().wGetAdaptee(false);
            case 2 :
            return getSecondName().wGetAdaptee(false);
            case 3 :
            return getType().wGetAdaptee(false);
            case 4 :
            return getEllipsis().wGetAdaptee(false);
            case 5 :
            return getDefaultArgument().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setAttributes(value.wGetAdapter(SwiftEntityDescriptorEnum.AttributeList));
            break;
            case 1 :
            setFirstName(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractFirstName));
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
            setDefaultArgument(value.wGetAdapter(SwiftEntityDescriptorEnum.Expr));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 6;
    }
}
