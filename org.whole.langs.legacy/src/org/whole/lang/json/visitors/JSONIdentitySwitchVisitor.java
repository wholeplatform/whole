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
package org.whole.lang.json.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.json.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.json.reflect.JSONEntityDescriptorEnum;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.String;

/**
 *  @generator Whole
 */
public abstract class JSONIdentitySwitchVisitor extends AbstractVisitor implements IJSONVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case JSONEntityDescriptorEnum.Object_ord :
            visit((Object) entity);
            break;
            case JSONEntityDescriptorEnum.Pair_ord :
            visit((Pair) entity);
            break;
            case JSONEntityDescriptorEnum.Name_ord :
            visit((Name) entity);
            break;
            case JSONEntityDescriptorEnum.Array_ord :
            visit((Array) entity);
            break;
            case JSONEntityDescriptorEnum.String_ord :
            visit((String) entity);
            break;
            case JSONEntityDescriptorEnum.Decimal_ord :
            visit((Decimal) entity);
            break;
            case JSONEntityDescriptorEnum.Int_ord :
            visit((Int) entity);
            break;
            case JSONEntityDescriptorEnum.Bool_ord :
            visit((Bool) entity);
            break;
            case JSONEntityDescriptorEnum.Null_ord :
            visit((Null) entity);
            break;
        }
    }
}
