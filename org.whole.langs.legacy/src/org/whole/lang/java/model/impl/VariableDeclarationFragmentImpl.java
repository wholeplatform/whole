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
import org.whole.lang.java.model.VariableDeclarationFragment;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.java.model.SimpleName;
import org.whole.lang.java.reflect.JavaFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.model.ExtraDimensions;
import org.whole.lang.java.model.Expression;

/**
 *  @generator Whole
 */
public class VariableDeclarationFragmentImpl extends AbstractSimpleEntity implements VariableDeclarationFragment {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<VariableDeclarationFragment> wGetEntityDescriptor() {
        return JavaEntityDescriptorEnum.VariableDeclarationFragment;
    }

    public int wGetEntityOrd() {
        return JavaEntityDescriptorEnum.VariableDeclarationFragment_ord;
    }

    public void accept(IJavaVisitor visitor) {
        visitor.visit(this);
    }
    private SimpleName name;

    public SimpleName getName() {
        return notifyRequested(JavaFeatureDescriptorEnum.name, name);
    }

    public void setName(SimpleName name) {
        notifyChanged(JavaFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private ExtraDimensions extraDimensions;

    public ExtraDimensions getExtraDimensions() {
        return notifyRequested(JavaFeatureDescriptorEnum.extraDimensions, extraDimensions);
    }

    public void setExtraDimensions(ExtraDimensions extraDimensions) {
        notifyChanged(JavaFeatureDescriptorEnum.extraDimensions, this.extraDimensions, this.extraDimensions = extraDimensions);
    }
    private Expression initializer;

    public Expression getInitializer() {
        return notifyRequested(JavaFeatureDescriptorEnum.initializer, initializer);
    }

    public void setInitializer(Expression initializer) {
        notifyChanged(JavaFeatureDescriptorEnum.initializer, this.initializer, this.initializer = initializer);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getExtraDimensions().wGetAdaptee(false);
            case 2 :
            return getInitializer().wGetAdaptee(false);
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
            setExtraDimensions(value.wGetAdapter(JavaEntityDescriptorEnum.ExtraDimensions));
            break;
            case 2 :
            setInitializer(value.wGetAdapter(JavaEntityDescriptorEnum.Expression));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
