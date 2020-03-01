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
package org.whole.lang.workflows.visitors;

import org.whole.lang.workflows.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator Whole
 */
public class WorkflowsFailureVisitor extends WorkflowsIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(Workflow entity) {
        throw new VisitException();
    }

    public void visit(Scope entity) {
        throw new VisitException();
    }

    public void visit(FaultHandlers entity) {
        throw new VisitException();
    }

    public void visit(FaultHandler entity) {
        throw new VisitException();
    }

    public void visit(EventHandlers entity) {
        throw new VisitException();
    }

    public void visit(EventHandler entity) {
        throw new VisitException();
    }

    public void visit(Sequence entity) {
        throw new VisitException();
    }

    public void visit(Parallel entity) {
        throw new VisitException();
    }

    public void visit(FlowObjects entity) {
        throw new VisitException();
    }

    public void visit(ForeachLoop entity) {
        throw new VisitException();
    }

    public void visit(WhileLoop entity) {
        throw new VisitException();
    }

    public void visit(TestTime entity) {
        throw new VisitException();
    }

    public void visit(PickControl entity) {
        throw new VisitException();
    }

    public void visit(SwitchControl entity) {
        throw new VisitException();
    }

    public void visit(SwitchType entity) {
        throw new VisitException();
    }

    public void visit(ConditionalCases entity) {
        throw new VisitException();
    }

    public void visit(ConditionalCase entity) {
        throw new VisitException();
    }

    public void visit(DefaultCase entity) {
        throw new VisitException();
    }

    public void visit(OnCallEvent entity) {
        throw new VisitException();
    }

    public void visit(OnMessageEvent entity) {
        throw new VisitException();
    }

    public void visit(OnTimerEvent entity) {
        throw new VisitException();
    }

    public void visit(FaultEvent entity) {
        throw new VisitException();
    }

    public void visit(ReturnEvent entity) {
        throw new VisitException();
    }

    public void visit(Task entity) {
        throw new VisitException();
    }

    public void visit(Breakpoint entity) {
        throw new VisitException();
    }

    public void visit(ConditionTest entity) {
        throw new VisitException();
    }

    public void visit(Variables entity) {
        throw new VisitException();
    }

    public void visit(EmptyActivity entity) {
        throw new VisitException();
    }

    public void visit(AssignActivity entity) {
        throw new VisitException();
    }

    public void visit(CreateModel entity) {
        throw new VisitException();
    }

    public void visit(LoadJavaModel entity) {
        throw new VisitException();
    }

    public void visit(ResourceKind entity) {
        throw new VisitException();
    }

    public void visit(LoadModel entity) {
        throw new VisitException();
    }

    public void visit(SaveModel entity) {
        throw new VisitException();
    }

    public void visit(DeleteArtifacts entity) {
        throw new VisitException();
    }

    public void visit(ArtifactsTraversalStrategy entity) {
        throw new VisitException();
    }

    public void visit(ArtifactsSynchronizeStrategy entity) {
        throw new VisitException();
    }

    public void visit(LoadArtifacts entity) {
        throw new VisitException();
    }

    public void visit(SaveArtifacts entity) {
        throw new VisitException();
    }

    public void visit(Parse entity) {
        throw new VisitException();
    }

    public void visit(Unparse entity) {
        throw new VisitException();
    }

    public void visit(InvokeOperation entity) {
        throw new VisitException();
    }

    public void visit(Operation entity) {
        throw new VisitException();
    }

    public void visit(InvokeQuery entity) {
        throw new VisitException();
    }

    public void visit(InvokeJavaInstanceMethod entity) {
        throw new VisitException();
    }

    public void visit(InvokeJavaClassMethod entity) {
        throw new VisitException();
    }

    public void visit(CreateJavaClassInstance entity) {
        throw new VisitException();
    }

    public void visit(Registry entity) {
        throw new VisitException();
    }

    public void visit(BooleanLiteral entity) {
        throw new VisitException();
    }

    public void visit(IntLiteral entity) {
        throw new VisitException();
    }

    public void visit(StringLiteral entity) {
        throw new VisitException();
    }

    public void visit(ObjectLiteral entity) {
        throw new VisitException();
    }

    public void visit(Variable entity) {
        throw new VisitException();
    }

    public void visit(Name entity) {
        throw new VisitException();
    }

    public void visit(Text entity) {
        throw new VisitException();
    }

    public void visit(Declarations entity) {
        throw new VisitException();
    }

    public void visit(Assignments entity) {
        throw new VisitException();
    }

    public void visit(Assign entity) {
        throw new VisitException();
    }

    public void visit(Expressions entity) {
        throw new VisitException();
    }

    public void visit(Signature entity) {
        throw new VisitException();
    }

    public void visit(ClassPath entity) {
        throw new VisitException();
    }

    public void visit(CurrentJavaProject entity) {
        throw new VisitException();
    }

    public void visit(JavaProject entity) {
        throw new VisitException();
    }
}
