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

/**
 *  @generator Whole
 */
public class TypesForwardStagedVisitor extends TypesIdentityVisitor {

    public void visit(TypeSystem entity) {
        stagedVisit(entity);
    }

    public void visit(TypeRules entity) {
        stagedVisit(entity);
    }

    public void visit(TypeRule entity) {
        stagedVisit(entity);
    }

    public void visit(AnyType entity) {
        stagedVisit(entity);
    }

    public void visit(LegacyType entity) {
        stagedVisit(entity);
    }

    public void visit(VariableType entity) {
        stagedVisit(entity);
    }

    public void visit(EntityType entity) {
        stagedVisit(entity);
    }

    public void visit(UnionType entity) {
        stagedVisit(entity);
    }

    public void visit(FeatureType entity) {
        stagedVisit(entity);
    }

    public void visit(FeatureTableType entity) {
        stagedVisit(entity);
    }

    public void visit(Arguments entity) {
        stagedVisit(entity);
    }

    public void visit(Cases entity) {
        stagedVisit(entity);
    }

    public void visit(Case entity) {
        stagedVisit(entity);
    }

    public void visit(OrExpressions entity) {
        stagedVisit(entity);
    }

    public void visit(TypeExpressions entity) {
        stagedVisit(entity);
    }

    public void visit(Subtype entity) {
        stagedVisit(entity);
    }

    public void visit(Supertype entity) {
        stagedVisit(entity);
    }
}
