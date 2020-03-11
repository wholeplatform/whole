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
import org.whole.lang.swift.model.DeclModifier;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.swift.model.NameValue;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.model.Identifier;

/**
 *  @generator Whole
 */
public class DeclModifierImpl extends AbstractSimpleEntity implements DeclModifier {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<DeclModifier> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.DeclModifier;
    }

    public int wGetEntityOrd() {
        return SwiftEntityDescriptorEnum.DeclModifier_ord;
    }

    public void accept(ISwiftVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private NameValue name;

    public NameValue getName() {
        return notifyRequested(SwiftFeatureDescriptorEnum.name, name);
    }

    public void setName(NameValue name) {
        notifyChanged(SwiftFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private Identifier detail;

    public Identifier getDetail() {
        return notifyRequested(SwiftFeatureDescriptorEnum.detail, detail);
    }

    public void setDetail(Identifier detail) {
        notifyChanged(SwiftFeatureDescriptorEnum.detail, this.detail, this.detail = detail);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getDetail().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(SwiftEntityDescriptorEnum.NameValue));
            break;
            case 1 :
            setDetail(value.wGetAdapter(SwiftEntityDescriptorEnum.Identifier));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
