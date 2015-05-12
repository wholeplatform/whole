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
import org.whole.lang.xml.model.Document;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.xml.model.Prolog;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.model.Element;

/**
 *  @generator Whole
 */
public class DocumentImpl extends AbstractSimpleEntity implements Document {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Document> wGetEntityDescriptor() {
        return XmlEntityDescriptorEnum.Document;
    }

    public int wGetEntityOrd() {
        return XmlEntityDescriptorEnum.Document_ord;
    }

    public void accept(IXmlVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private Prolog prolog;

    public Prolog getProlog() {
        return notifyRequested(XmlFeatureDescriptorEnum.prolog, prolog);
    }

    public void setProlog(Prolog prolog) {
        notifyChanged(XmlFeatureDescriptorEnum.prolog, this.prolog, this.prolog = prolog);
    }
    private Element element;

    public Element getElement() {
        return notifyRequested(XmlFeatureDescriptorEnum.element, element);
    }

    public void setElement(Element element) {
        notifyChanged(XmlFeatureDescriptorEnum.element, this.element, this.element = element);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getProlog().wGetAdaptee(false);
            case 1 :
            return getElement().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setProlog(value.wGetAdapter(XmlEntityDescriptorEnum.Prolog));
            break;
            case 1 :
            setElement(value.wGetAdapter(XmlEntityDescriptorEnum.Element));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 2;
    }
}
