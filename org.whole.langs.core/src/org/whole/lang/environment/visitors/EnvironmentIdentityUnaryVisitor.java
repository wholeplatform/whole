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
package org.whole.lang.environment.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.environment.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.environment.model.Void;

/**
 *  @generator Whole
 */
public class EnvironmentIdentityUnaryVisitor<V extends IVisitor>  extends AbstractUnaryVisitor<V> implements IEnvironmentVisitor {

    public EnvironmentIdentityUnaryVisitor() {
        super(null);
    }

    public EnvironmentIdentityUnaryVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        ((IEnvironmentEntity) entity).accept(this);
    }

    public void visit(BooleanData entity) {
    }

    public void visit(ByteData entity) {
    }

    public void visit(CharData entity) {
    }

    public void visit(DoubleData entity) {
    }

    public void visit(FloatData entity) {
    }

    public void visit(IntData entity) {
    }

    public void visit(LongData entity) {
    }

    public void visit(ShortData entity) {
    }

    public void visit(StringData entity) {
    }

    public void visit(DateData entity) {
    }

    public void visit(ObjectData entity) {
    }

    public void visit(Tuple entity) {
    }

    public void visit(ContainmentTuple entity) {
    }

    public void visit(Void entity) {
    }

    public void visit(ContextViewModel entity) {
    }

    public void visit(SampleViewModel entity) {
    }

    public void visit(DebugViewModel entity) {
    }

    public void visit(Jobs entity) {
    }

    public void visit(Job entity) {
    }

    public void visit(ExecutionStack entity) {
    }

    public void visit(ExecutionFrame entity) {
    }

    public void visit(VariablesViewModel entity) {
    }

    public void visit(Environments entity) {
    }

    public void visit(Environment entity) {
    }

    public void visit(ScopedBindings entity) {
    }

    public void visit(Bindings entity) {
    }

    public void visit(Binding entity) {
    }

    public void visit(Scope entity) {
    }

    public void visit(Id entity) {
    }

    public void visit(Names entity) {
    }

    public void visit(Name entity) {
    }

    public void visit(Index entity) {
    }

    public void visit(Value entity) {
    }

    public void visit(EnvironmentManager entity) {
    }

    public void visit(BindingManager entity) {
    }

    public void visit(BindingScope entity) {
    }
}
