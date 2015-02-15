/**
 *  Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.environment.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.environment.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.model.Void;

/**
 *  @generator Whole
 */
public class EnvironmentForwardStrategyVisitor extends GenericForwardStrategyVisitor<IEnvironmentVisitor> implements IEnvironmentVisitor {

    public EnvironmentForwardStrategyVisitor() {
        this(new EnvironmentIdentityVisitor());
    }

    public EnvironmentForwardStrategyVisitor(IEnvironmentVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IEnvironmentEntity) entity).accept(this);
    }

    public void visit(BooleanData entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ByteData entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CharData entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DoubleData entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FloatData entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IntData entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LongData entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ShortData entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StringData entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DateData entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjectData entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Tuple entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ContainmentTuple entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Void entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Bindings entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Binding entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Name entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Value entity) {
        wGetStrategy().visit(entity);
    }
}
