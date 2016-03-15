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
import org.whole.lang.xml.model.SystemId;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.xml.model.SystemLiteral;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SystemIdImpl extends AbstractSimpleEntity implements SystemId {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<SystemId> wGetEntityDescriptor() {
        return XmlEntityDescriptorEnum.SystemId;
    }

    public int wGetEntityOrd() {
        return XmlEntityDescriptorEnum.SystemId_ord;
    }

    public void accept(IXmlVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private SystemLiteral systemLiteral;

    public SystemLiteral getSystemLiteral() {
        return notifyRequested(XmlFeatureDescriptorEnum.systemLiteral, systemLiteral);
    }

    public void setSystemLiteral(SystemLiteral systemLiteral) {
        notifyChanged(XmlFeatureDescriptorEnum.systemLiteral, this.systemLiteral, this.systemLiteral = systemLiteral);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getSystemLiteral().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setSystemLiteral(value.wGetAdapter(XmlEntityDescriptorEnum.SystemLiteral));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 1;
    }
}
