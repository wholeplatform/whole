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
package org.whole.lang.xml.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xml.model.XMLDecl;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.xml.model.Version;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.model.Encoding;
import org.whole.lang.xml.model.Standalone;

/**
 *  @generator Whole
 */
public class XMLDeclImpl extends AbstractSimpleEntity implements XMLDecl {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<XMLDecl> wGetEntityDescriptor() {
        return XmlEntityDescriptorEnum.XMLDecl;
    }

    public int wGetEntityOrd() {
        return XmlEntityDescriptorEnum.XMLDecl_ord;
    }

    public void accept(IXmlVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Version version;

    public Version getVersion() {
        return notifyRequested(XmlFeatureDescriptorEnum.version, version);
    }

    public void setVersion(Version version) {
        notifyChanged(XmlFeatureDescriptorEnum.version, this.version, this.version = version);
    }
    private Encoding encoding;

    public Encoding getEncoding() {
        return notifyRequested(XmlFeatureDescriptorEnum.encoding, encoding);
    }

    public void setEncoding(Encoding encoding) {
        notifyChanged(XmlFeatureDescriptorEnum.encoding, this.encoding, this.encoding = encoding);
    }
    private Standalone standalone;

    public Standalone getStandalone() {
        return notifyRequested(XmlFeatureDescriptorEnum.standalone, standalone);
    }

    public void setStandalone(Standalone standalone) {
        notifyChanged(XmlFeatureDescriptorEnum.standalone, this.standalone, this.standalone = standalone);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getVersion().wGetAdaptee(false);
            case 1 :
            return getEncoding().wGetAdaptee(false);
            case 2 :
            return getStandalone().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setVersion(value.wGetAdapter(XmlEntityDescriptorEnum.Version));
            break;
            case 1 :
            setEncoding(value.wGetAdapter(XmlEntityDescriptorEnum.Encoding));
            break;
            case 2 :
            setStandalone(value.wGetAdapter(XmlEntityDescriptorEnum.Standalone));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
