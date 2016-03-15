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
public class EnvironmentIdentityDefaultVisitor extends EnvironmentIdentityVisitor {

    public void visit(IEnvironmentEntity entity) {
    }

    public void visit(Data entity) {
    }

    public void visit(BooleanData entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(ByteData entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(CharData entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(DoubleData entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(FloatData entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(IntData entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(LongData entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(ShortData entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(StringData entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(DateData entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(ObjectData entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(Tuple entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(ContainmentTuple entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(Void entity) {
        visit((IEnvironmentEntity) entity);
        visit((Data) entity);
    }

    public void visit(ContextViewModel entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(SampleViewModel entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(DebugViewModel entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(Jobs entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(Job entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(ExecutionStack entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(ExecutionFrame entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(VariablesViewModel entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(Environments entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(Environment entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(BindingsModel entity) {
    }

    public void visit(ScopedBindings entity) {
        visit((IEnvironmentEntity) entity);
        visit((BindingsModel) entity);
    }

    public void visit(Bindings entity) {
        visit((IEnvironmentEntity) entity);
        visit((BindingsModel) entity);
    }

    public void visit(BindingOrScope entity) {
    }

    public void visit(Binding entity) {
        visit((IEnvironmentEntity) entity);
        visit((BindingOrScope) entity);
    }

    public void visit(Scope entity) {
        visit((IEnvironmentEntity) entity);
        visit((BindingOrScope) entity);
    }

    public void visit(Id entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(Names entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(Name entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(Index entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(Value entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(EnvironmentManager entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(BindingManager entity) {
        visit((IEnvironmentEntity) entity);
    }

    public void visit(BindingScope entity) {
        visit((IEnvironmentEntity) entity);
    }
}
