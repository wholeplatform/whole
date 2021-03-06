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
import org.whole.lang.java.model.Initializer;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.java.model.Javadoc;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.ExtendedModifiers;
import org.whole.lang.java.model.Block;

/**
 *  @generator Whole
 */
public class InitializerImpl extends AbstractSimpleEntity implements Initializer {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Initializer> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.Initializer;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.Initializer_ord;
    }

    public void accept(IJavaVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Javadoc javadoc;

    public Javadoc getJavadoc() {
        return notifyRequested(JavaFeatureDescriptorEnum.javadoc, javadoc);
    }

    public void setJavadoc(Javadoc javadoc) {
        notifyChanged(JavaFeatureDescriptorEnum.javadoc, this.javadoc, this.javadoc = javadoc);
    }
    private ExtendedModifiers modifiers;

    public ExtendedModifiers getModifiers() {
        return notifyRequested(JavaFeatureDescriptorEnum.modifiers, modifiers);
    }

    public void setModifiers(ExtendedModifiers modifiers) {
        notifyChanged(JavaFeatureDescriptorEnum.modifiers, this.modifiers, this.modifiers = modifiers);
    }
    private Block body;

    public Block getBody() {
        return notifyRequested(JavaFeatureDescriptorEnum.body, body);
    }

    public void setBody(Block body) {
        notifyChanged(JavaFeatureDescriptorEnum.body, this.body, this.body = body);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getJavadoc().wGetAdaptee(false);
            case 1 :
            return getModifiers().wGetAdaptee(false);
            case 2 :
            return getBody().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setJavadoc(value.wGetAdapter(JavaEntityDescriptorEnum.Javadoc));
            break;
            case 1 :
            setModifiers(value.wGetAdapter(JavaEntityDescriptorEnum.ExtendedModifiers));
            break;
            case 2 :
            setBody(value.wGetAdapter(JavaEntityDescriptorEnum.Block));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
