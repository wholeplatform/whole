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
import org.whole.lang.xml.model.Element;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.xml.reflect.XmlEntityDescriptorEnum;
import org.whole.lang.xml.visitors.IXmlVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.xml.model.IName;
import org.whole.lang.xml.reflect.XmlFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.xml.model.Attributes;
import org.whole.lang.xml.model.IContent;

/**
 *  @generator Whole
 */
public class ElementImpl extends AbstractSimpleEntity implements Element {
    private static final long serialVersionUID = 1;

    public EntityDescriptor<Element> wGetEntityDescriptor() {
        return XmlEntityDescriptorEnum.Element;
    }

    public int wGetEntityOrd() {
        return XmlEntityDescriptorEnum.Element_ord;
    }

    public void accept(IXmlVisitor visitor) {
        try {
            visitor.visit(this);
        } catch (Exception e) {
            throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
        }
    }
    private IName tag;

    public IName getTag() {
        return notifyRequested(XmlFeatureDescriptorEnum.tag, tag);
    }

    public void setTag(IName tag) {
        notifyChanged(XmlFeatureDescriptorEnum.tag, this.tag, this.tag = tag);
    }
    private Attributes attributes;

    public Attributes getAttributes() {
        return notifyRequested(XmlFeatureDescriptorEnum.attributes, attributes);
    }

    public void setAttributes(Attributes attributes) {
        notifyChanged(XmlFeatureDescriptorEnum.attributes, this.attributes, this.attributes = attributes);
    }
    private IContent content;

    public IContent getContent() {
        return notifyRequested(XmlFeatureDescriptorEnum.content, content);
    }

    public void setContent(IContent content) {
        notifyChanged(XmlFeatureDescriptorEnum.content, this.content, this.content = content);
    }

    public IEntity wGet(int index) {
        switch (index) {
            case 0 :
            return getTag().wGetAdaptee(false);
            case 1 :
            return getAttributes().wGetAdaptee(false);
            case 2 :
            return getContent().wGetAdaptee(false);
            default :
            throw new IllegalArgumentException();
        }
    }

    public void wSet(int index, IEntity value) {
        switch (index) {
            case 0 :
            setTag(value.wGetAdapter(XmlEntityDescriptorEnum.IName));
            break;
            case 1 :
            setAttributes(value.wGetAdapter(XmlEntityDescriptorEnum.Attributes));
            break;
            case 2 :
            setContent(value.wGetAdapter(XmlEntityDescriptorEnum.IContent));
            break;
            default :
            throw new IllegalArgumentException();
        }
    }

    public int wSize() {
        return 3;
    }
}
