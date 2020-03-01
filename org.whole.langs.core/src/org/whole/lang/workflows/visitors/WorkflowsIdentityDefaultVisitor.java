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
public class WorkflowsIdentityDefaultVisitor extends WorkflowsIdentityVisitor {

    public void visit(IWorkflowsEntity entity) {
    }

    public void visit(Workflow entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(FlowObject entity) {
    }

    public void visit(Scope entity) {
        visit((IWorkflowsEntity) entity);
        visit((FlowObject) entity);
    }

    public void visit(FaultHandlers entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(FaultHandler entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(EventHandlers entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(EventHandler entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(Sequence entity) {
        visit((IWorkflowsEntity) entity);
        visit((FlowObject) entity);
    }

    public void visit(Parallel entity) {
        visit((IWorkflowsEntity) entity);
        visit((FlowObject) entity);
    }

    public void visit(FlowObjects entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(ForeachLoop entity) {
        visit((IWorkflowsEntity) entity);
        visit((FlowObject) entity);
    }

    public void visit(WhileLoop entity) {
        visit((IWorkflowsEntity) entity);
        visit((FlowObject) entity);
    }

    public void visit(TestTime entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(PickControl entity) {
        visit((IWorkflowsEntity) entity);
        visit((FlowObject) entity);
    }

    public void visit(SwitchControl entity) {
        visit((IWorkflowsEntity) entity);
        visit((FlowObject) entity);
    }

    public void visit(SwitchType entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(ConditionalCases entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(ConditionalCase entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(DefaultCase entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(Event entity) {
    }

    public void visit(StartEvent entity) {
        visit((Event) entity);
    }

    public void visit(FlowEvent entity) {
        visit((Event) entity);
        visit((FlowObject) entity);
    }

    public void visit(OnCallEvent entity) {
        visit((IWorkflowsEntity) entity);
        visit((StartEvent) entity);
    }

    public void visit(OnMessageEvent entity) {
        visit((IWorkflowsEntity) entity);
        visit((StartEvent) entity);
    }

    public void visit(OnTimerEvent entity) {
        visit((IWorkflowsEntity) entity);
        visit((StartEvent) entity);
    }

    public void visit(FaultEvent entity) {
        visit((IWorkflowsEntity) entity);
        visit((FlowEvent) entity);
    }

    public void visit(ReturnEvent entity) {
        visit((IWorkflowsEntity) entity);
        visit((FlowEvent) entity);
    }

    public void visit(Task entity) {
        visit((IWorkflowsEntity) entity);
        visit((FlowObject) entity);
    }

    public void visit(Breakpoint entity) {
        visit((IWorkflowsEntity) entity);
        visit((FlowObject) entity);
    }

    public void visit(ConditionTest entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(Variables entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(Activity entity) {
        visit((FlowObject) entity);
    }

    public void visit(EmptyActivity entity) {
        visit((IWorkflowsEntity) entity);
        visit((Activity) entity);
    }

    public void visit(AssignActivity entity) {
        visit((IWorkflowsEntity) entity);
        visit((Activity) entity);
    }

    public void visit(CreateModel entity) {
        visit((IWorkflowsEntity) entity);
        visit((Activity) entity);
    }

    public void visit(LoadJavaModel entity) {
        visit((IWorkflowsEntity) entity);
        visit((Activity) entity);
    }

    public void visit(PersistenceActivity entity) {
        visit((Activity) entity);
    }

    public void visit(ResourceKind entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(LoadModel entity) {
        visit((IWorkflowsEntity) entity);
        visit((PersistenceActivity) entity);
    }

    public void visit(SaveModel entity) {
        visit((IWorkflowsEntity) entity);
        visit((PersistenceActivity) entity);
    }

    public void visit(ArtifactsActivity entity) {
        visit((Activity) entity);
    }

    public void visit(DeleteArtifacts entity) {
        visit((IWorkflowsEntity) entity);
        visit((ArtifactsActivity) entity);
    }

    public void visit(SynchronizeArtifactsActivity entity) {
        visit((ArtifactsActivity) entity);
    }

    public void visit(ArtifactsTraversalStrategy entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(ArtifactsSynchronizeStrategy entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(LoadArtifacts entity) {
        visit((IWorkflowsEntity) entity);
        visit((SynchronizeArtifactsActivity) entity);
    }

    public void visit(SaveArtifacts entity) {
        visit((IWorkflowsEntity) entity);
        visit((SynchronizeArtifactsActivity) entity);
    }

    public void visit(GrammarActivity entity) {
        visit((Activity) entity);
    }

    public void visit(Parse entity) {
        visit((IWorkflowsEntity) entity);
        visit((GrammarActivity) entity);
    }

    public void visit(Unparse entity) {
        visit((IWorkflowsEntity) entity);
        visit((GrammarActivity) entity);
    }

    public void visit(InvokeOperation entity) {
        visit((IWorkflowsEntity) entity);
        visit((Activity) entity);
    }

    public void visit(Operation entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(InvokeQuery entity) {
        visit((IWorkflowsEntity) entity);
        visit((Activity) entity);
    }

    public void visit(InvokeJavaInstanceMethod entity) {
        visit((IWorkflowsEntity) entity);
        visit((Activity) entity);
    }

    public void visit(InvokeJavaClassMethod entity) {
        visit((IWorkflowsEntity) entity);
        visit((Activity) entity);
    }

    public void visit(CreateJavaClassInstance entity) {
        visit((IWorkflowsEntity) entity);
        visit((Activity) entity);
    }

    public void visit(Registry entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(Expression entity) {
    }

    public void visit(Literal entity) {
        visit((Expression) entity);
    }

    public void visit(BooleanLiteral entity) {
        visit((IWorkflowsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(IntLiteral entity) {
        visit((IWorkflowsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(StringLiteral entity) {
        visit((IWorkflowsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(ObjectLiteral entity) {
        visit((IWorkflowsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Variable entity) {
        visit((IWorkflowsEntity) entity);
        visit((Expression) entity);
    }

    public void visit(Name entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(Description entity) {
    }

    public void visit(Text entity) {
        visit((IWorkflowsEntity) entity);
        visit((Description) entity);
        visit((Label) entity);
    }

    public void visit(Label entity) {
    }

    public void visit(Declarations entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(Arguments entity) {
    }

    public void visit(Assignments entity) {
        visit((IWorkflowsEntity) entity);
        visit((Arguments) entity);
    }

    public void visit(Assign entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(Expressions entity) {
        visit((IWorkflowsEntity) entity);
        visit((Arguments) entity);
    }

    public void visit(Signature entity) {
        visit((IWorkflowsEntity) entity);
    }

    public void visit(ClassProvider entity) {
    }

    public void visit(ClassPath entity) {
        visit((IWorkflowsEntity) entity);
        visit((ClassProvider) entity);
    }

    public void visit(CurrentJavaProject entity) {
        visit((IWorkflowsEntity) entity);
        visit((ClassProvider) entity);
    }

    public void visit(JavaProject entity) {
        visit((IWorkflowsEntity) entity);
        visit((ClassProvider) entity);
    }
}
