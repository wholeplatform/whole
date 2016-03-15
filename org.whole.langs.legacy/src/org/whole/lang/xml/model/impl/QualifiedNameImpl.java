/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.xml.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xml.model.QualifiedName;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.xml.model.NameSpace;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.model.Name;

/**
 *  @generator Whole
 */
public class QualifiedNameImpl extends AbstractSimpleEntity implements QualifiedName {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<QualifiedName> wGetEntityDescriptor() {
        return XmlEntityDescriptorEnum.QualifiedName;
    }

    public int wGetEntityOrd() {
        return XmlEntityDescriptorEnum.QualifiedName_ord;
    }

    public void accept(IXmlVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }

    public int wHashCode() {
        return getNameSpace().wHashCode() + 29 * getName().wHashCode();
    }

    public boolean wEquals(IEntity entity) {
        if (this == entity)
            return true;
        if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
            return false;
        try {
            return getNameSpace().wEquals(entity.wGet(XmlFeatureDescriptorEnum.nameSpace)) && getName().wEquals(entity.wGet(XmlFeatureDescriptorEnum.name));
        } catch (Exception e) {
            return false;
        }
    }

    protected void toString(StringBuffer buffer) {
        buffer.append("nameSpace=");
        buffer.append(nameSpace);
        buffer.append("name=");
        buffer.append(name);
    }
    private NameSpace nameSpace;

    public NameSpace getNameSpace() {
        return notifyRequested(XmlFeatureDescriptorEnum.nameSpace, nameSpace);
    }

    public void setNameSpace(NameSpace nameSpace) {
        notifyChanged(XmlFeatureDescriptorEnum.nameSpace, this.nameSpace, this.nameSpace = nameSpace);
    }
    private Name name;

    public Name getName() {
        return notifyRequested(XmlFeatureDescriptorEnum.name, name);
    }

    public void setName(Name name) {
        notifyChanged(XmlFeatureDescriptorEnum.name, this.name, this.name = name);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getNameSpace().wGetAdaptee(false);
            case 1 :
            return getName().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setNameSpace(value.wGetAdapter(XmlEntityDescriptorEnum.NameSpace));
            break;
            case 1 :
            setName(value.wGetAdapter(XmlEntityDescriptorEnum.Name));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
