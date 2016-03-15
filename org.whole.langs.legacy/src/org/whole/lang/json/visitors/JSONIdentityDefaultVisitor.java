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

import org.whole.lang.json.model.*;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.String;

/**
 *  @generator Whole
 */
public class JSONIdentityDefaultVisitor extends JSONIdentityVisitor {

    public void visit(IJSONEntity entity) {
    }

    public void visit(Value entity) {
    }

    public void visit(Object entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }

    public void visit(Pair entity) {
        visit((IJSONEntity) entity);
    }

    public void visit(Name entity) {
        visit((IJSONEntity) entity);
    }

    public void visit(Array entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }

    public void visit(String entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }

    public void visit(Decimal entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }

    public void visit(Int entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }

    public void visit(Bool entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }

    public void visit(Null entity) {
        visit((IJSONEntity) entity);
        visit((Value) entity);
    }
}
