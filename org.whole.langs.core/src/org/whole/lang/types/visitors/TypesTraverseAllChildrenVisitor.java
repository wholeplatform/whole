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

import org.whole.lang.types.visitors.TypesIdentityUnaryVisitor;
import org.whole.lang.types.visitors.ITypesVisitor;
import org.whole.lang.types.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class TypesTraverseAllChildrenVisitor extends TypesIdentityUnaryVisitor<ITypesVisitor> {

    public TypesTraverseAllChildrenVisitor() {
        wSetVisitor1(this);
    }

    public TypesTraverseAllChildrenVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(TypeSystem entity) {
        entity.getCheckBefore().accept(wGetVisitor1());
        entity.getRules().accept(wGetVisitor1());
    }

    public void visit(TypeRules entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(TypeRule entity) {
        entity.getDomain().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
    }

    public void visit(UnionType entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(FeatureTableType entity) {
        entity.getArguments().accept(wGetVisitor1());
        entity.getCases().accept(wGetVisitor1());
    }

    public void visit(Arguments entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Cases entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Case entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getExpressions().accept(wGetVisitor1());
    }

    public void visit(OrExpressions entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(TypeExpressions entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(Subtype entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
    }

    public void visit(Supertype entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
    }
}
