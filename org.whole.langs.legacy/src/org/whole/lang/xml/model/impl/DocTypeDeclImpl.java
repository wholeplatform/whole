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
import org.whole.lang.xml.model.DocTypeDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.xml.model.IName;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.model.IExternalId;

/**
 *  @generator Whole
 */
public class DocTypeDeclImpl extends AbstractSimpleEntity implements DocTypeDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<DocTypeDecl> wGetEntityDescriptor() {
        return XmlEntityDescriptorEnum.DocTypeDecl;
    }

    public int wGetEntityOrd() {
        return XmlEntityDescriptorEnum.DocTypeDecl_ord;
    }

    public void accept(IXmlVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private IName name;

    public IName getName() {
        return notifyRequested(XmlFeatureDescriptorEnum.name, name);
    }

    public void setName(IName name) {
        notifyChanged(XmlFeatureDescriptorEnum.name, this.name, this.name = name);
    }
    private IExternalId externalId;

    public IExternalId getExternalId() {
        return notifyRequested(XmlFeatureDescriptorEnum.externalId, externalId);
    }

    public void setExternalId(IExternalId externalId) {
        notifyChanged(XmlFeatureDescriptorEnum.externalId, this.externalId, this.externalId = externalId);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getName().wGetAdaptee(false);
            case 1 :
            return getExternalId().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setName(value.wGetAdapter(XmlEntityDescriptorEnum.IName));
            break;
            case 1 :
            setExternalId(value.wGetAdapter(XmlEntityDescriptorEnum.IExternalId));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
