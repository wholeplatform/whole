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
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;
import org.whole.lang.json.model.Object;
import org.whole.lang.json.model.String;

/**
 *  @generator Whole
 */
public class JSONFailureVisitor extends JSONIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(Object entity) {
        throw new VisitException();
    }

    public void visit(Pair entity) {
        throw new VisitException();
    }

    public void visit(Name entity) {
        throw new VisitException();
    }

    public void visit(Array entity) {
        throw new VisitException();
    }

    public void visit(String entity) {
        throw new VisitException();
    }

    public void visit(Decimal entity) {
        throw new VisitException();
    }

    public void visit(Int entity) {
        throw new VisitException();
    }

    public void visit(Bool entity) {
        throw new VisitException();
    }

    public void visit(Null entity) {
        throw new VisitException();
    }
}
