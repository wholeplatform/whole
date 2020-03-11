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
import org.whole.lang.swift.model.ImplementsAttributeArguments;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.SimpleTypeIdentifier;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.AbstractDeclBaseName;
import org.whole.lang.swift.model.DeclNameArgumentList;

/**
 *  @generator Whole
 */
public class ImplementsAttributeArgumentsImpl extends AbstractSimpleEntity implements ImplementsAttributeArguments {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<ImplementsAttributeArguments> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.ImplementsAttributeArguments;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.ImplementsAttributeArguments_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private SimpleTypeIdentifier type;

    public SimpleTypeIdentifier getType() {
        return notifyRequested(SwiftFeatureDescriptorEnum.type, type);
    }

    public void setType(SimpleTypeIdentifier type) {
        notifyChanged(SwiftFeatureDescriptorEnum.type, this.type, this.type = type);
    }
    private AbstractDeclBaseName declBaseName;

    public AbstractDeclBaseName getDeclBaseName() {
        return notifyRequested(SwiftFeatureDescriptorEnum.declBaseName, declBaseName);
    }

    public void setDeclBaseName(AbstractDeclBaseName declBaseName) {
        notifyChanged(SwiftFeatureDescriptorEnum.declBaseName, this.declBaseName, this.declBaseName = declBaseName);
    }
    private DeclNameArgumentList declNameArguments;

    public DeclNameArgumentList getDeclNameArguments() {
        return notifyRequested(SwiftFeatureDescriptorEnum.declNameArguments, declNameArguments);
    }

    public void setDeclNameArguments(DeclNameArgumentList declNameArguments) {
        notifyChanged(SwiftFeatureDescriptorEnum.declNameArguments, this.declNameArguments, this.declNameArguments = declNameArguments);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getType().wGetAdaptee(false);
            case 1 :
            return getDeclBaseName().wGetAdaptee(false);
            case 2 :
            return getDeclNameArguments().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setType(value.wGetAdapter(SwiftEntityDescriptorEnum.SimpleTypeIdentifier));
            break;
            case 1 :
            setDeclBaseName(value.wGetAdapter(SwiftEntityDescriptorEnum.AbstractDeclBaseName));
            break;
            case 2 :
            setDeclNameArguments(value.wGetAdapter(SwiftEntityDescriptorEnum.DeclNameArgumentList));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
