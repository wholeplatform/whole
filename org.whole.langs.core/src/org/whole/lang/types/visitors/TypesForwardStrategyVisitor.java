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

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.types.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class TypesForwardStrategyVisitor extends GenericForwardStrategyVisitor<ITypesVisitor> implements ITypesVisitor {

    public TypesForwardStrategyVisitor() {
        this(new TypesIdentityVisitor());
    }

    public TypesForwardStrategyVisitor(ITypesVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((ITypesEntity) entity).accept(this);
    }

    public void visit(TypeSystem entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeRules entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeRule entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AnyType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LegacyType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariableType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EntityType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UnionType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FeatureType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FeatureTableType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Arguments entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Cases entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Case entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OrExpressions entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeExpressions entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Subtype entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Supertype entity) {
        wGetStrategy().visit(entity);
    }
}
