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

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class WorkflowsIdentityVisitor extends AbstractVisitor implements IWorkflowsVisitor {

    public void visit(IEntity entity) {
        ((IWorkflowsEntity) entity).accept(this);
    }

    public void visit(Workflow entity) {
    }

    public void visit(Scope entity) {
    }

    public void visit(FaultHandlers entity) {
    }

    public void visit(FaultHandler entity) {
    }

    public void visit(EventHandlers entity) {
    }

    public void visit(EventHandler entity) {
    }

    public void visit(Sequence entity) {
    }

    public void visit(Parallel entity) {
    }

    public void visit(FlowObjects entity) {
    }

    public void visit(ForeachLoop entity) {
    }

    public void visit(WhileLoop entity) {
    }

    public void visit(TestTime entity) {
    }

    public void visit(PickControl entity) {
    }

    public void visit(SwitchControl entity) {
    }

    public void visit(SwitchType entity) {
    }

    public void visit(ConditionalCases entity) {
    }

    public void visit(ConditionalCase entity) {
    }

    public void visit(DefaultCase entity) {
    }

    public void visit(OnCallEvent entity) {
    }

    public void visit(OnMessageEvent entity) {
    }

    public void visit(OnTimerEvent entity) {
    }

    public void visit(FaultEvent entity) {
    }

    public void visit(ReturnEvent entity) {
    }

    public void visit(Task entity) {
    }

    public void visit(Breakpoint entity) {
    }

    public void visit(ConditionTest entity) {
    }

    public void visit(Variables entity) {
    }

    public void visit(EmptyActivity entity) {
    }

    public void visit(AssignActivity entity) {
    }

    public void visit(CreateModel entity) {
    }

    public void visit(LoadJavaModel entity) {
    }

    public void visit(ResourceKind entity) {
    }

    public void visit(LoadModel entity) {
    }

    public void visit(SaveModel entity) {
    }

    public void visit(DeleteArtifacts entity) {
    }

    public void visit(ArtifactsTraversalStrategy entity) {
    }

    public void visit(ArtifactsSynchronizeStrategy entity) {
    }

    public void visit(LoadArtifacts entity) {
    }

    public void visit(SaveArtifacts entity) {
    }

    public void visit(Parse entity) {
    }

    public void visit(Unparse entity) {
    }

    public void visit(InvokeOperation entity) {
    }

    public void visit(Operation entity) {
    }

    public void visit(InvokeQuery entity) {
    }

    public void visit(InvokeJavaInstanceMethod entity) {
    }

    public void visit(InvokeJavaClassMethod entity) {
    }

    public void visit(CreateJavaClassInstance entity) {
    }

    public void visit(Registry entity) {
    }

    public void visit(BooleanLiteral entity) {
    }

    public void visit(IntLiteral entity) {
    }

    public void visit(StringLiteral entity) {
    }

    public void visit(ObjectLiteral entity) {
    }

    public void visit(Variable entity) {
    }

    public void visit(Name entity) {
    }

    public void visit(Text entity) {
    }

    public void visit(Declarations entity) {
    }

    public void visit(Assignments entity) {
    }

    public void visit(Assign entity) {
    }

    public void visit(Expressions entity) {
    }

    public void visit(Signature entity) {
    }

    public void visit(ClassPath entity) {
    }

    public void visit(CurrentJavaProject entity) {
    }

    public void visit(JavaProject entity) {
    }
}
