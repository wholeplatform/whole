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
import org.whole.lang.java.model.TypeParameter;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.SimpleName;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.Types;
import org.whole.lang.java.model.Annotations;

/**
 *  @generator Whole
 */
public class TypeParameterImpl extends AbstractSimpleEntity implements TypeParameter {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<TypeParameter> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.TypeParameter;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.TypeParameter_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private SimpleName name;

    public SimpleName getName() {
        return notifyRequested(JavaFeatureDescriptorEnum.name, name);
    }

    public void setName(SimpleName name) {
        notifyChanged(JavaFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Types typeBounds;

    public Types getTypeBounds() {
        return notifyRequested(JavaFeatureDescriptorEnum.typeBounds, typeBounds);
    }

    public void setTypeBounds(Types typeBounds) {
        notifyChanged(JavaFeatureDescriptorEnum.typeBounds, this.typeBounds, this.typeBounds = typeBounds);
    }
    private Annotations annotations;

    public Annotations getAnnotations() {
        return notifyRequested(JavaFeatureDescriptorEnum.annotations, annotations);
    }

    public void setAnnotations(Annotations annotations) {
        notifyChanged(JavaFeatureDescriptorEnum.annotations, this.annotations, this.annotations = annotations);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getTypeBounds().wGetAdaptee(false);
            case 2 :
            return getAnnotations().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(JavaEntityDescriptorEnum.SimpleName));
            break;
            case 1 :
            setTypeBounds(value.wGetAdapter(JavaEntityDescriptorEnum.Types));
            break;
            case 2 :
            setAnnotations(value.wGetAdapter(JavaEntityDescriptorEnum.Annotations));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
