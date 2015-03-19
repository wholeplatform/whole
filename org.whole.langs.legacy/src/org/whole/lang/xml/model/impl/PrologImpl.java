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
package org.whole.lang.xml.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.xml.model.Prolog;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.xml.model.XMLDecl;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.model.DocTypeDecl;
import org.whole.lang.xml.model.Misc;

/**
 *  @generator Whole
 */
public class PrologImpl extends AbstractSimpleEntity implements Prolog {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Prolog> wGetEntityDescriptor() {
        return XmlEntityDescriptorEnum.Prolog;
    }

    public int wGetEntityOrd() {
        return XmlEntityDescriptorEnum.Prolog_ord;
    }

    public void accept(IXmlVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private XMLDecl xmlDecl;

    public XMLDecl getXmlDecl() {
        return notifyRequested(XmlFeatureDescriptorEnum.xmlDecl, xmlDecl);
    }

    public void setXmlDecl(XMLDecl xmlDecl) {
        notifyChanged(XmlFeatureDescriptorEnum.xmlDecl, this.xmlDecl, this.xmlDecl = xmlDecl);
    }
    private DocTypeDecl docTypeDecl;

    public DocTypeDecl getDocTypeDecl() {
        return notifyRequested(XmlFeatureDescriptorEnum.docTypeDecl, docTypeDecl);
    }

    public void setDocTypeDecl(DocTypeDecl docTypeDecl) {
        notifyChanged(XmlFeatureDescriptorEnum.docTypeDecl, this.docTypeDecl, this.docTypeDecl = docTypeDecl);
    }
    private Misc misc;

    public Misc getMisc() {
        return notifyRequested(XmlFeatureDescriptorEnum.misc, misc);
    }

    public void setMisc(Misc misc) {
        notifyChanged(XmlFeatureDescriptorEnum.misc, this.misc, this.misc = misc);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getXmlDecl().wGetAdaptee(false);
            case 1 :
            return getDocTypeDecl().wGetAdaptee(false);
            case 2 :
            return getMisc().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setXmlDecl(value.wGetAdapter(XmlEntityDescriptorEnum.XMLDecl));
            break;
            case 1 :
            setDocTypeDecl(value.wGetAdapter(XmlEntityDescriptorEnum.DocTypeDecl));
            break;
            case 2 :
            setMisc(value.wGetAdapter(XmlEntityDescriptorEnum.Misc));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
