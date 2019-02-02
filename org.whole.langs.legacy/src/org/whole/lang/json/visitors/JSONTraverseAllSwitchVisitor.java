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
package org.whole.lang.json.visitors;

import org.whole.lang.json.visitors.JSONIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.json.model.*;
import org.whole.lang.json.model.Object;

/**
 *  @generator Whole
 */
public class JSONTraverseAllSwitchVisitor extends JSONIdentityUnaryVisitor<IVisitor> {

    public JSONTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Object entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Pair entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(Array entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }
}
