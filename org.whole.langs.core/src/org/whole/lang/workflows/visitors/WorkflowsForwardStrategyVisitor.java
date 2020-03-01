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

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class WorkflowsForwardStrategyVisitor extends GenericForwardStrategyVisitor<IWorkflowsVisitor> implements IWorkflowsVisitor {

    public WorkflowsForwardStrategyVisitor() {
        this(new WorkflowsIdentityVisitor());
    }

    public WorkflowsForwardStrategyVisitor(IWorkflowsVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((IWorkflowsEntity) entity).accept(this);
    }

    public void visit(Workflow entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Scope entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FaultHandlers entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FaultHandler entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EventHandlers entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EventHandler entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Sequence entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Parallel entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FlowObjects entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ForeachLoop entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(WhileLoop entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TestTime entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PickControl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchControl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConditionalCases entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConditionalCase entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DefaultCase entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OnCallEvent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OnMessageEvent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OnTimerEvent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FaultEvent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ReturnEvent entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Task entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Breakpoint entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConditionTest entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Variables entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EmptyActivity entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AssignActivity entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CreateModel entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LoadJavaModel entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ResourceKind entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LoadModel entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SaveModel entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeleteArtifacts entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArtifactsTraversalStrategy entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArtifactsSynchronizeStrategy entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LoadArtifacts entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SaveArtifacts entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Parse entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Unparse entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InvokeOperation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Operation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InvokeQuery entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InvokeJavaInstanceMethod entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InvokeJavaClassMethod entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CreateJavaClassInstance entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Registry entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BooleanLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IntLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StringLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjectLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Variable entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Name entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Text entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Declarations entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Assignments entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Assign entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Expressions entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Signature entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClassPath entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CurrentJavaProject entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(JavaProject entity) {
        wGetStrategy().visit(entity);
    }
}
