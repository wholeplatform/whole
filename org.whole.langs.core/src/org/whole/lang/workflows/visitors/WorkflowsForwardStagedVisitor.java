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

/**
 *  @generator Whole
 */
public class WorkflowsForwardStagedVisitor extends WorkflowsIdentityVisitor {

    public void visit(Workflow entity) {
        stagedVisit(entity);
    }

    public void visit(Scope entity) {
        stagedVisit(entity);
    }

    public void visit(FaultHandlers entity) {
        stagedVisit(entity);
    }

    public void visit(FaultHandler entity) {
        stagedVisit(entity);
    }

    public void visit(EventHandlers entity) {
        stagedVisit(entity);
    }

    public void visit(EventHandler entity) {
        stagedVisit(entity);
    }

    public void visit(Sequence entity) {
        stagedVisit(entity);
    }

    public void visit(Parallel entity) {
        stagedVisit(entity);
    }

    public void visit(FlowObjects entity) {
        stagedVisit(entity);
    }

    public void visit(ForeachLoop entity) {
        stagedVisit(entity);
    }

    public void visit(WhileLoop entity) {
        stagedVisit(entity);
    }

    public void visit(TestTime entity) {
        stagedVisit(entity);
    }

    public void visit(PickControl entity) {
        stagedVisit(entity);
    }

    public void visit(SwitchControl entity) {
        stagedVisit(entity);
    }

    public void visit(SwitchType entity) {
        stagedVisit(entity);
    }

    public void visit(ConditionalCases entity) {
        stagedVisit(entity);
    }

    public void visit(ConditionalCase entity) {
        stagedVisit(entity);
    }

    public void visit(DefaultCase entity) {
        stagedVisit(entity);
    }

    public void visit(OnCallEvent entity) {
        stagedVisit(entity);
    }

    public void visit(OnMessageEvent entity) {
        stagedVisit(entity);
    }

    public void visit(OnTimerEvent entity) {
        stagedVisit(entity);
    }

    public void visit(FaultEvent entity) {
        stagedVisit(entity);
    }

    public void visit(ReturnEvent entity) {
        stagedVisit(entity);
    }

    public void visit(Task entity) {
        stagedVisit(entity);
    }

    public void visit(Breakpoint entity) {
        stagedVisit(entity);
    }

    public void visit(ConditionTest entity) {
        stagedVisit(entity);
    }

    public void visit(Variables entity) {
        stagedVisit(entity);
    }

    public void visit(EmptyActivity entity) {
        stagedVisit(entity);
    }

    public void visit(AssignActivity entity) {
        stagedVisit(entity);
    }

    public void visit(CreateModel entity) {
        stagedVisit(entity);
    }

    public void visit(LoadJavaModel entity) {
        stagedVisit(entity);
    }

    public void visit(ResourceKind entity) {
        stagedVisit(entity);
    }

    public void visit(LoadModel entity) {
        stagedVisit(entity);
    }

    public void visit(SaveModel entity) {
        stagedVisit(entity);
    }

    public void visit(DeleteArtifacts entity) {
        stagedVisit(entity);
    }

    public void visit(ArtifactsTraversalStrategy entity) {
        stagedVisit(entity);
    }

    public void visit(ArtifactsSynchronizeStrategy entity) {
        stagedVisit(entity);
    }

    public void visit(LoadArtifacts entity) {
        stagedVisit(entity);
    }

    public void visit(SaveArtifacts entity) {
        stagedVisit(entity);
    }

    public void visit(Parse entity) {
        stagedVisit(entity);
    }

    public void visit(Unparse entity) {
        stagedVisit(entity);
    }

    public void visit(InvokeOperation entity) {
        stagedVisit(entity);
    }

    public void visit(Operation entity) {
        stagedVisit(entity);
    }

    public void visit(InvokeQuery entity) {
        stagedVisit(entity);
    }

    public void visit(InvokeJavaInstanceMethod entity) {
        stagedVisit(entity);
    }

    public void visit(InvokeJavaClassMethod entity) {
        stagedVisit(entity);
    }

    public void visit(CreateJavaClassInstance entity) {
        stagedVisit(entity);
    }

    public void visit(Registry entity) {
        stagedVisit(entity);
    }

    public void visit(BooleanLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(IntLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(StringLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(ObjectLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(Variable entity) {
        stagedVisit(entity);
    }

    public void visit(Name entity) {
        stagedVisit(entity);
    }

    public void visit(Text entity) {
        stagedVisit(entity);
    }

    public void visit(Declarations entity) {
        stagedVisit(entity);
    }

    public void visit(Assignments entity) {
        stagedVisit(entity);
    }

    public void visit(Assign entity) {
        stagedVisit(entity);
    }

    public void visit(Expressions entity) {
        stagedVisit(entity);
    }

    public void visit(Signature entity) {
        stagedVisit(entity);
    }

    public void visit(ClassPath entity) {
        stagedVisit(entity);
    }

    public void visit(CurrentJavaProject entity) {
        stagedVisit(entity);
    }

    public void visit(JavaProject entity) {
        stagedVisit(entity);
    }
}
