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
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public abstract class WorkflowsIdentitySwitchVisitor extends AbstractVisitor implements IWorkflowsVisitor {

    public void visit(IEntity entity) {
        switch (entity.wGetEntityOrd()) {
            case WorkflowsEntityDescriptorEnum.Workflow_ord :
            visit((Workflow) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Scope_ord :
            visit((Scope) entity);
            break;
            case WorkflowsEntityDescriptorEnum.FaultHandlers_ord :
            visit((FaultHandlers) entity);
            break;
            case WorkflowsEntityDescriptorEnum.FaultHandler_ord :
            visit((FaultHandler) entity);
            break;
            case WorkflowsEntityDescriptorEnum.EventHandlers_ord :
            visit((EventHandlers) entity);
            break;
            case WorkflowsEntityDescriptorEnum.EventHandler_ord :
            visit((EventHandler) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Sequence_ord :
            visit((Sequence) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Parallel_ord :
            visit((Parallel) entity);
            break;
            case WorkflowsEntityDescriptorEnum.FlowObjects_ord :
            visit((FlowObjects) entity);
            break;
            case WorkflowsEntityDescriptorEnum.ForeachLoop_ord :
            visit((ForeachLoop) entity);
            break;
            case WorkflowsEntityDescriptorEnum.WhileLoop_ord :
            visit((WhileLoop) entity);
            break;
            case WorkflowsEntityDescriptorEnum.TestTime_ord :
            visit((TestTime) entity);
            break;
            case WorkflowsEntityDescriptorEnum.PickControl_ord :
            visit((PickControl) entity);
            break;
            case WorkflowsEntityDescriptorEnum.SwitchControl_ord :
            visit((SwitchControl) entity);
            break;
            case WorkflowsEntityDescriptorEnum.SwitchType_ord :
            visit((SwitchType) entity);
            break;
            case WorkflowsEntityDescriptorEnum.ConditionalCases_ord :
            visit((ConditionalCases) entity);
            break;
            case WorkflowsEntityDescriptorEnum.ConditionalCase_ord :
            visit((ConditionalCase) entity);
            break;
            case WorkflowsEntityDescriptorEnum.DefaultCase_ord :
            visit((DefaultCase) entity);
            break;
            case WorkflowsEntityDescriptorEnum.OnCallEvent_ord :
            visit((OnCallEvent) entity);
            break;
            case WorkflowsEntityDescriptorEnum.OnMessageEvent_ord :
            visit((OnMessageEvent) entity);
            break;
            case WorkflowsEntityDescriptorEnum.OnTimerEvent_ord :
            visit((OnTimerEvent) entity);
            break;
            case WorkflowsEntityDescriptorEnum.FaultEvent_ord :
            visit((FaultEvent) entity);
            break;
            case WorkflowsEntityDescriptorEnum.ReturnEvent_ord :
            visit((ReturnEvent) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Task_ord :
            visit((Task) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Breakpoint_ord :
            visit((Breakpoint) entity);
            break;
            case WorkflowsEntityDescriptorEnum.ConditionTest_ord :
            visit((ConditionTest) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Variables_ord :
            visit((Variables) entity);
            break;
            case WorkflowsEntityDescriptorEnum.EmptyActivity_ord :
            visit((EmptyActivity) entity);
            break;
            case WorkflowsEntityDescriptorEnum.AssignActivity_ord :
            visit((AssignActivity) entity);
            break;
            case WorkflowsEntityDescriptorEnum.CreateModel_ord :
            visit((CreateModel) entity);
            break;
            case WorkflowsEntityDescriptorEnum.LoadJavaModel_ord :
            visit((LoadJavaModel) entity);
            break;
            case WorkflowsEntityDescriptorEnum.ResourceKind_ord :
            visit((ResourceKind) entity);
            break;
            case WorkflowsEntityDescriptorEnum.LoadModel_ord :
            visit((LoadModel) entity);
            break;
            case WorkflowsEntityDescriptorEnum.SaveModel_ord :
            visit((SaveModel) entity);
            break;
            case WorkflowsEntityDescriptorEnum.DeleteArtifacts_ord :
            visit((DeleteArtifacts) entity);
            break;
            case WorkflowsEntityDescriptorEnum.ArtifactsTraversalStrategy_ord :
            visit((ArtifactsTraversalStrategy) entity);
            break;
            case WorkflowsEntityDescriptorEnum.ArtifactsSynchronizeStrategy_ord :
            visit((ArtifactsSynchronizeStrategy) entity);
            break;
            case WorkflowsEntityDescriptorEnum.LoadArtifacts_ord :
            visit((LoadArtifacts) entity);
            break;
            case WorkflowsEntityDescriptorEnum.SaveArtifacts_ord :
            visit((SaveArtifacts) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Parse_ord :
            visit((Parse) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Unparse_ord :
            visit((Unparse) entity);
            break;
            case WorkflowsEntityDescriptorEnum.InvokeOperation_ord :
            visit((InvokeOperation) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Operation_ord :
            visit((Operation) entity);
            break;
            case WorkflowsEntityDescriptorEnum.InvokeQuery_ord :
            visit((InvokeQuery) entity);
            break;
            case WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod_ord :
            visit((InvokeJavaInstanceMethod) entity);
            break;
            case WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod_ord :
            visit((InvokeJavaClassMethod) entity);
            break;
            case WorkflowsEntityDescriptorEnum.CreateJavaClassInstance_ord :
            visit((CreateJavaClassInstance) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Registry_ord :
            visit((Registry) entity);
            break;
            case WorkflowsEntityDescriptorEnum.BooleanLiteral_ord :
            visit((BooleanLiteral) entity);
            break;
            case WorkflowsEntityDescriptorEnum.IntLiteral_ord :
            visit((IntLiteral) entity);
            break;
            case WorkflowsEntityDescriptorEnum.StringLiteral_ord :
            visit((StringLiteral) entity);
            break;
            case WorkflowsEntityDescriptorEnum.ObjectLiteral_ord :
            visit((ObjectLiteral) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Variable_ord :
            visit((Variable) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Name_ord :
            visit((Name) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Text_ord :
            visit((Text) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Declarations_ord :
            visit((Declarations) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Assignments_ord :
            visit((Assignments) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Assign_ord :
            visit((Assign) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Expressions_ord :
            visit((Expressions) entity);
            break;
            case WorkflowsEntityDescriptorEnum.Signature_ord :
            visit((Signature) entity);
            break;
            case WorkflowsEntityDescriptorEnum.ClassPath_ord :
            visit((ClassPath) entity);
            break;
            case WorkflowsEntityDescriptorEnum.CurrentJavaProject_ord :
            visit((CurrentJavaProject) entity);
            break;
            case WorkflowsEntityDescriptorEnum.JavaProject_ord :
            visit((JavaProject) entity);
            break;
        }
    }
}
