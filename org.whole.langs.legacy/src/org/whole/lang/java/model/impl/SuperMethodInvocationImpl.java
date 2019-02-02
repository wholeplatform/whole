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
import org.whole.lang.java.model.SuperMethodInvocation;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.Name;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.Types;
import org.whole.lang.java.model.SimpleName;
import org.whole.lang.java.model.Arguments;

/**
 *  @generator Whole
 */
public class SuperMethodInvocationImpl extends AbstractSimpleEntity implements SuperMethodInvocation {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SuperMethodInvocation> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.SuperMethodInvocation;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.SuperMethodInvocation_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Name qualifier;

    public Name getQualifier() {
        return notifyRequested(JavaFeatureDescriptorEnum.qualifier, qualifier);
    }

    public void setQualifier(Name qualifier) {
        notifyChanged(JavaFeatureDescriptorEnum.qualifier, this.qualifier, this.qualifier = qualifier);
    }
    private Types typeArguments;

    public Types getTypeArguments() {
        return notifyRequested(JavaFeatureDescriptorEnum.typeArguments, typeArguments);
    }

    public void setTypeArguments(Types typeArguments) {
        notifyChanged(JavaFeatureDescriptorEnum.typeArguments, this.typeArguments, this.typeArguments = typeArguments);
    }
    private SimpleName name;

    public SimpleName getName() {
        return notifyRequested(JavaFeatureDescriptorEnum.name, name);
    }

    public void setName(SimpleName name) {
        notifyChanged(JavaFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Arguments arguments;

    public Arguments getArguments() {
        return notifyRequested(JavaFeatureDescriptorEnum.arguments, arguments);
    }

    public void setArguments(Arguments arguments) {
        notifyChanged(JavaFeatureDescriptorEnum.arguments, this.arguments, this.arguments = arguments);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getQualifier().wGetAdaptee(false);
            case 1 :
            return getTypeArguments().wGetAdaptee(false);
            case 2 :
            return getName().wGetAdaptee(false);
            case 3 :
            return getArguments().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setQualifier(value.wGetAdapter(JavaEntityDescriptorEnum.Name));
            break;
            case 1 :
            setTypeArguments(value.wGetAdapter(JavaEntityDescriptorEnum.Types));
            break;
            case 2 :
            setName(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
            break;
            case 3 :
            setArguments(value.wGetAdapter(JavaEntityDescriptorEnum.Arguments));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 4;
    }
}
