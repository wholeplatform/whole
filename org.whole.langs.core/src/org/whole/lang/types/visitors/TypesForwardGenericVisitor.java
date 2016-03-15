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

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class TypesForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements ITypesVisitor {

    public TypesForwardGenericVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TypeSystem entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TypeRules entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TypeRule entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AnyType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LegacyType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VariableType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EntityType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(UnionType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FeatureType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FeatureTableType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Arguments entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Cases entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Case entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OrExpressions entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TypeExpressions entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Subtype entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Supertype entity) {
        wGetVisitor1().visit(entity);
    }
}
