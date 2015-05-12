/**
 *  Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
import org.whole.lang.xml.model.PublicId;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.xml.model.PubidLiteral;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.model.SystemLiteral;

/**
 *  @generator Whole
 */
public class PublicIdImpl extends AbstractSimpleEntity implements PublicId {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<PublicId> wGetEntityDescriptor() {
        return XmlEntityDescriptorEnum.PublicId;
    }

    public int wGetEntityOrd() {
        return XmlEntityDescriptorEnum.PublicId_ord;
    }

    public void accept(IXmlVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private PubidLiteral pubidLiteral;

    public PubidLiteral getPubidLiteral() {
        return notifyRequested(XmlFeatureDescriptorEnum.pubidLiteral, pubidLiteral);
    }

    public void setPubidLiteral(PubidLiteral pubidLiteral) {
        notifyChanged(XmlFeatureDescriptorEnum.pubidLiteral, this.pubidLiteral, this.pubidLiteral = pubidLiteral);
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
            return getPubidLiteral().wGetAdaptee(false);
            case 1 :
            return getSystemLiteral().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setPubidLiteral(value.wGetAdapter(XmlEntityDescriptorEnum.PubidLiteral));
            break;
            case 1 :
            setSystemLiteral(value.wGetAdapter(XmlEntityDescriptorEnum.SystemLiteral));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
