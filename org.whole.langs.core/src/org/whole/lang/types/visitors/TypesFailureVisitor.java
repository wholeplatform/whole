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
package org.whole.lang.types.visitors;

import org.whole.lang.types.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator Whole
 */
public class TypesFailureVisitor extends TypesIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(TypeSystem entity) {
        throw new VisitException();
    }

    public void visit(TypeRules entity) {
        throw new VisitException();
    }

    public void visit(TypeRule entity) {
        throw new VisitException();
    }

    public void visit(AnyType entity) {
        throw new VisitException();
    }

    public void visit(LegacyType entity) {
        throw new VisitException();
    }

    public void visit(VariableType entity) {
        throw new VisitException();
    }

    public void visit(EntityType entity) {
        throw new VisitException();
    }

    public void visit(UnionType entity) {
        throw new VisitException();
    }

    public void visit(FeatureType entity) {
        throw new VisitException();
    }

    public void visit(FeatureTableType entity) {
        throw new VisitException();
    }

    public void visit(Arguments entity) {
        throw new VisitException();
    }

    public void visit(Cases entity) {
        throw new VisitException();
    }

    public void visit(Case entity) {
        throw new VisitException();
    }

    public void visit(OrExpressions entity) {
        throw new VisitException();
    }

    public void visit(TypeExpressions entity) {
        throw new VisitException();
    }

    public void visit(Subtype entity) {
        throw new VisitException();
    }

    public void visit(Supertype entity) {
        throw new VisitException();
    }
}
