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
package org.whole.lang.types.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class TypesIdentityUnaryVisitor<V extends IVisitor>  extends AbstractUnaryVisitor<V> implements ITypesVisitor {

    public TypesIdentityUnaryVisitor() {
        super(null);
    }

    public TypesIdentityUnaryVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        ((ITypesEntity) entity).accept(this);
    }

    public void visit(TypeSystem entity) {
    }

    public void visit(TypeRules entity) {
    }

    public void visit(TypeRule entity) {
    }

    public void visit(AnyType entity) {
    }

    public void visit(LegacyType entity) {
    }

    public void visit(VariableType entity) {
    }

    public void visit(EntityType entity) {
    }

    public void visit(UnionType entity) {
    }

    public void visit(FeatureType entity) {
    }

    public void visit(FeatureTableType entity) {
    }

    public void visit(Arguments entity) {
    }

    public void visit(Cases entity) {
    }

    public void visit(Case entity) {
    }

    public void visit(OrExpressions entity) {
    }

    public void visit(TypeExpressions entity) {
    }

    public void visit(Subtype entity) {
    }

    public void visit(Supertype entity) {
    }
}
