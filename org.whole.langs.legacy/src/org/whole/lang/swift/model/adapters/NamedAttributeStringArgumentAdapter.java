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
package org.whole.lang.swift.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.swift.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;
import org.whole.lang.swift.reflect.SwiftFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class NamedAttributeStringArgumentAdapter extends AbstractEntityAdapter implements NamedAttributeStringArgument {
    private static final long serialVersionUID = 1;

    public NamedAttributeStringArgumentAdapter(IEntity implementor) {
        super(implementor);
    }

    public NamedAttributeStringArgumentAdapter() {
    }

    public void accept(ISwiftVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<NamedAttributeStringArgument> wGetEntityDescriptor() {
        return SwiftEntityDescriptorEnum.NamedAttributeStringArgument;
    }

    public Identifier getNameTok() {
        return wGet(SwiftFeatureDescriptorEnum.nameTok).wGetAdapter(SwiftEntityDescriptorEnum.Identifier);
    }

    public void setNameTok(Identifier nameTok) {
        wSet(SwiftFeatureDescriptorEnum.nameTok, nameTok);
    }

    public AbstractStringOrDeclname getStringOrDeclname() {
        return wGet(SwiftFeatureDescriptorEnum.stringOrDeclname).wGetAdapter(SwiftEntityDescriptorEnum.AbstractStringOrDeclname);
    }

    public void setStringOrDeclname(AbstractStringOrDeclname stringOrDeclname) {
        wSet(SwiftFeatureDescriptorEnum.stringOrDeclname, stringOrDeclname);
    }
}
