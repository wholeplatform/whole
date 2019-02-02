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
package org.whole.lang.json.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.json.model.*;
import org.whole.lang.json.model.Object;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class ObjectAdapter extends AbstractListEntityAdapter<Pair> implements Object {
    private static final long serialVersionUID = 1;

    public ObjectAdapter(IEntity implementor) {
        super(implementor);
    }

    public ObjectAdapter() {
    }

    public void accept(IJSONVisitor visitor) {
        if (visitor.visitAdapter(this))
            visitor.visit(this);
    }

    public EntityDescriptor<Object> wGetEntityDescriptor() {
        return JSONEntityDescriptorEnum.Object;
    }
}
