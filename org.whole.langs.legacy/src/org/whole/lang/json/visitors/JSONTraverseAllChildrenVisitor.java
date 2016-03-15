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

import org.whole.lang.json.visitors.JSONIdentityUnaryVisitor;
import org.whole.lang.json.visitors.IJSONVisitor;
import org.whole.lang.json.model.*;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.json.model.Object;

/**
 *  @generator Whole
 */
public class JSONTraverseAllChildrenVisitor extends JSONIdentityUnaryVisitor<IJSONVisitor> {

    public JSONTraverseAllChildrenVisitor() {
        wSetVisitor1(this);
    }

    public JSONTraverseAllChildrenVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Object entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Pair entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
    }

    public void visit(Array entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }
}
