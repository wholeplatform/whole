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

import org.whole.lang.environment.visitors.EnvironmentIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.environment.model.*;

/**
 *  @generator Whole
 */
public class EnvironmentTraverseAllSwitchVisitor extends EnvironmentIdentityUnaryVisitor<IVisitor> {

    public EnvironmentTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Tuple entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ContainmentTuple entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ContextViewModel entity) {
        wGetVisitor1().visit(entity.getEnvironments());
        wGetVisitor1().visit(entity.getBindings());
    }

    public void visit(SampleViewModel entity) {
        wGetVisitor1().visit(entity.getBehavior());
        wGetVisitor1().visit(entity.getResult());
    }

    public void visit(DebugViewModel entity) {
        wGetVisitor1().visit(entity.getFocusJob());
        wGetVisitor1().visit(entity.getJobs());
    }

    public void visit(Jobs entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Job entity) {
        wGetVisitor1().visit(entity.getFocusFrame());
        wGetVisitor1().visit(entity.getExecutionStack());
    }

    public void visit(ExecutionStack entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ExecutionFrame entity) {
        wGetVisitor1().visit(entity.getSourceFragment());
        wGetVisitor1().visit(entity.getSourceEntity());
    }

    public void visit(VariablesViewModel entity) {
        wGetVisitor1().visit(entity.getEnvironmentManager());
        wGetVisitor1().visit(entity.getEnvironments());
    }

    public void visit(Environments entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Environment entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getFilter());
        wGetVisitor1().visit(entity.getBindingManager());
        wGetVisitor1().visit(entity.getBindings());
    }

    public void visit(ScopedBindings entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Bindings entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Binding entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(Scope entity) {
        wGetVisitor1().visit(entity.getScope());
        wGetVisitor1().visit(entity.getSourceEntity());
    }

    public void visit(Names entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }
}
