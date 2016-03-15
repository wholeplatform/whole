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

import org.whole.lang.environment.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;
import org.whole.lang.environment.model.Void;

/**
 *  @generator Whole
 */
public class EnvironmentFailureVisitor extends EnvironmentIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(BooleanData entity) {
        throw new VisitException();
    }

    public void visit(ByteData entity) {
        throw new VisitException();
    }

    public void visit(CharData entity) {
        throw new VisitException();
    }

    public void visit(DoubleData entity) {
        throw new VisitException();
    }

    public void visit(FloatData entity) {
        throw new VisitException();
    }

    public void visit(IntData entity) {
        throw new VisitException();
    }

    public void visit(LongData entity) {
        throw new VisitException();
    }

    public void visit(ShortData entity) {
        throw new VisitException();
    }

    public void visit(StringData entity) {
        throw new VisitException();
    }

    public void visit(DateData entity) {
        throw new VisitException();
    }

    public void visit(ObjectData entity) {
        throw new VisitException();
    }

    public void visit(Tuple entity) {
        throw new VisitException();
    }

    public void visit(ContainmentTuple entity) {
        throw new VisitException();
    }

    public void visit(Void entity) {
        throw new VisitException();
    }

    public void visit(ContextViewModel entity) {
        throw new VisitException();
    }

    public void visit(SampleViewModel entity) {
        throw new VisitException();
    }

    public void visit(DebugViewModel entity) {
        throw new VisitException();
    }

    public void visit(Jobs entity) {
        throw new VisitException();
    }

    public void visit(Job entity) {
        throw new VisitException();
    }

    public void visit(ExecutionStack entity) {
        throw new VisitException();
    }

    public void visit(ExecutionFrame entity) {
        throw new VisitException();
    }

    public void visit(VariablesViewModel entity) {
        throw new VisitException();
    }

    public void visit(Environments entity) {
        throw new VisitException();
    }

    public void visit(Environment entity) {
        throw new VisitException();
    }

    public void visit(ScopedBindings entity) {
        throw new VisitException();
    }

    public void visit(Bindings entity) {
        throw new VisitException();
    }

    public void visit(Binding entity) {
        throw new VisitException();
    }

    public void visit(Scope entity) {
        throw new VisitException();
    }

    public void visit(Id entity) {
        throw new VisitException();
    }

    public void visit(Names entity) {
        throw new VisitException();
    }

    public void visit(Name entity) {
        throw new VisitException();
    }

    public void visit(Index entity) {
        throw new VisitException();
    }

    public void visit(Value entity) {
        throw new VisitException();
    }

    public void visit(EnvironmentManager entity) {
        throw new VisitException();
    }

    public void visit(BindingManager entity) {
        throw new VisitException();
    }

    public void visit(BindingScope entity) {
        throw new VisitException();
    }
}
