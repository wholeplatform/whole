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
public class QualifiedNameAdapter extends AbstractEntityAdapter implements QualifiedName {
    private static final long serialVersionUID = 1;

    public QualifiedNameAdapter(IEntity implementor) {
        super(implementor);
    }

    public QualifiedNameAdapter() {
    }

    public void accept(IXmlVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<QualifiedName> wGetEntityDescriptor() {
        return XmlEntityDescriptorEnum.QualifiedName;
    }

    public NameSpace getNameSpace() {
        return wGet(XmlFeatureDescriptorEnum.nameSpace).wGetAdapter(XmlEntityDescriptorEnum.NameSpace);
    }

    public void setNameSpace(NameSpace nameSpace) {
        wSet(XmlFeatureDescriptorEnum.nameSpace, nameSpace);
    }

    public Name getName() {
        return wGet(XmlFeatureDescriptorEnum.name).wGetAdapter(XmlEntityDescriptorEnum.Name);
    }

    public void setName(Name name) {
        wSet(XmlFeatureDescriptorEnum.name, name);
    }
}
