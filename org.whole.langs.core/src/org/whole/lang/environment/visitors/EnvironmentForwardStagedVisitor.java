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
import org.whole.lang.environment.model.Void;

/**
 *  @generator Whole
 */
public class EnvironmentForwardStagedVisitor extends EnvironmentIdentityVisitor {

    public void visit(BooleanData entity) {
        stagedVisit(entity);
    }

    public void visit(ByteData entity) {
        stagedVisit(entity);
    }

    public void visit(CharData entity) {
        stagedVisit(entity);
    }

    public void visit(DoubleData entity) {
        stagedVisit(entity);
    }

    public void visit(FloatData entity) {
        stagedVisit(entity);
    }

    public void visit(IntData entity) {
        stagedVisit(entity);
    }

    public void visit(LongData entity) {
        stagedVisit(entity);
    }

    public void visit(ShortData entity) {
        stagedVisit(entity);
    }

    public void visit(StringData entity) {
        stagedVisit(entity);
    }

    public void visit(DateData entity) {
        stagedVisit(entity);
    }

    public void visit(ObjectData entity) {
        stagedVisit(entity);
    }

    public void visit(Tuple entity) {
        stagedVisit(entity);
    }

    public void visit(ContainmentTuple entity) {
        stagedVisit(entity);
    }

    public void visit(Void entity) {
        stagedVisit(entity);
    }

    public void visit(ContextViewModel entity) {
        stagedVisit(entity);
    }

    public void visit(SampleViewModel entity) {
        stagedVisit(entity);
    }

    public void visit(DebugViewModel entity) {
        stagedVisit(entity);
    }

    public void visit(Jobs entity) {
        stagedVisit(entity);
    }

    public void visit(Job entity) {
        stagedVisit(entity);
    }

    public void visit(ExecutionStack entity) {
        stagedVisit(entity);
    }

    public void visit(ExecutionFrame entity) {
        stagedVisit(entity);
    }

    public void visit(VariablesViewModel entity) {
        stagedVisit(entity);
    }

    public void visit(Environments entity) {
        stagedVisit(entity);
    }

    public void visit(Environment entity) {
        stagedVisit(entity);
    }

    public void visit(ScopedBindings entity) {
        stagedVisit(entity);
    }

    public void visit(Bindings entity) {
        stagedVisit(entity);
    }

    public void visit(Binding entity) {
        stagedVisit(entity);
    }

    public void visit(Scope entity) {
        stagedVisit(entity);
    }

    public void visit(Id entity) {
        stagedVisit(entity);
    }

    public void visit(Names entity) {
        stagedVisit(entity);
    }

    public void visit(Name entity) {
        stagedVisit(entity);
    }

    public void visit(Index entity) {
        stagedVisit(entity);
    }

    public void visit(Value entity) {
        stagedVisit(entity);
    }

    public void visit(EnvironmentManager entity) {
        stagedVisit(entity);
    }

    public void visit(BindingManager entity) {
        stagedVisit(entity);
    }

    public void visit(BindingScope entity) {
        stagedVisit(entity);
    }
}
