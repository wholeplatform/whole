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
package org.whole.lang.xml.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.xml.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class XMLDeclAdapter extends AbstractEntityAdapter implements XMLDecl {
    private static final long serialVersionUID = 1;

    public XMLDeclAdapter(IEntity implementor) {
        super(implementor);
    }

    public XMLDeclAdapter() {
    }

    public void accept(IXmlVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<XMLDecl> wGetEntityDescriptor() {
        return XmlEntityDescriptorEnum.XMLDecl;
    }

    public Version getVersion() {
        return wGet(XmlFeatureDescriptorEnum.version).wGetAdapter(XmlEntityDescriptorEnum.Version);
    }

    public void setVersion(Version version) {
        wSet(XmlFeatureDescriptorEnum.version, version);
    }

    public Encoding getEncoding() {
        return wGet(XmlFeatureDescriptorEnum.encoding).wGetAdapter(XmlEntityDescriptorEnum.Encoding);
    }

    public void setEncoding(Encoding encoding) {
        wSet(XmlFeatureDescriptorEnum.encoding, encoding);
    }

    public Standalone getStandalone() {
        return wGet(XmlFeatureDescriptorEnum.standalone).wGetAdapter(XmlEntityDescriptorEnum.Standalone);
    }

    public void setStandalone(Standalone standalone) {
        wSet(XmlFeatureDescriptorEnum.standalone, standalone);
    }
}
