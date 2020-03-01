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

import org.whole.lang.workflows.visitors.WorkflowsIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.workflows.model.*;

/**
 *  @generator Whole
 */
public class WorkflowsTraverseAllSwitchVisitor extends WorkflowsIdentityUnaryVisitor<IVisitor> {

    public WorkflowsTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Workflow entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getDeclarations());
        wGetVisitor1().visit(entity.getStartEvent());
        wGetVisitor1().visit(entity.getFlowObject());
        wGetVisitor1().visit(entity.getEndEvent());
    }

    public void visit(FlowObject entity) {
        wGetVisitor1().visit(entity.getLabel());
    }

    public void visit(Scope entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getDeclarations());
        wGetVisitor1().visit(entity.getFlowObject());
        wGetVisitor1().visit(entity.getCompensationHandler());
        wGetVisitor1().visit(entity.getEventHandlers());
        wGetVisitor1().visit(entity.getFaultHandlers());
    }

    public void visit(FaultHandlers entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(FaultHandler entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getFaultName());
        wGetVisitor1().visit(entity.getFaultVariable());
        wGetVisitor1().visit(entity.getFlowObject());
    }

    public void visit(EventHandlers entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(EventHandler entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getTriggerEvent());
        wGetVisitor1().visit(entity.getFlowObject());
    }

    public void visit(Sequence entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getFlowObjects());
    }

    public void visit(Parallel entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getFlowObjects());
    }

    public void visit(FlowObjects entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ForeachLoop entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getCompositeVariable());
        wGetVisitor1().visit(entity.getElementVariable());
        wGetVisitor1().visit(entity.getIndexVariable());
        wGetVisitor1().visit(entity.getFlowObject());
    }

    public void visit(WhileLoop entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getTestTime());
        wGetVisitor1().visit(entity.getCondition());
        wGetVisitor1().visit(entity.getFlowObject());
    }

    public void visit(PickControl entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getEventHandlers());
    }

    public void visit(SwitchControl entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getSwitchType());
        wGetVisitor1().visit(entity.getConditionalCases());
        wGetVisitor1().visit(entity.getDefaultCase());
    }

    public void visit(ConditionalCases entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ConditionalCase entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getCondition());
        wGetVisitor1().visit(entity.getFlowObject());
    }

    public void visit(DefaultCase entity) {
        wGetVisitor1().visit(entity.getFlowObject());
    }

    public void visit(StartEvent entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getLabel());
    }

    public void visit(FlowEvent entity) {
        wGetVisitor1().visit(entity.getLabel());
    }

    public void visit(OnCallEvent entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getParameters());
    }

    public void visit(OnMessageEvent entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getMessage());
    }

    public void visit(OnTimerEvent entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getTimer());
    }

    public void visit(FaultEvent entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getFault());
    }

    public void visit(ReturnEvent entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getResult());
    }

    public void visit(Task entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getDescription());
        wGetVisitor1().visit(entity.getAssignments());
        wGetVisitor1().visit(entity.getFactory());
    }

    public void visit(Breakpoint entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getDisabled());
        wGetVisitor1().visit(entity.getHitCount());
        wGetVisitor1().visit(entity.getCondition());
        wGetVisitor1().visit(entity.getConditionTest());
        wGetVisitor1().visit(entity.getShowVariables());
    }

    public void visit(Variables entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Activity entity) {
        wGetVisitor1().visit(entity.getLabel());
    }

    public void visit(EmptyActivity entity) {
        wGetVisitor1().visit(entity.getLabel());
    }

    public void visit(AssignActivity entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getAssignments());
    }

    public void visit(CreateModel entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getTemplate());
        wGetVisitor1().visit(entity.getBindings());
    }

    public void visit(LoadJavaModel entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getClassName());
        wGetVisitor1().visit(entity.getClassProvider());
    }

    public void visit(PersistenceActivity entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getPersistence());
        wGetVisitor1().visit(entity.getResourceKind());
        wGetVisitor1().visit(entity.getResource());
        wGetVisitor1().visit(entity.getBindings());
    }

    public void visit(LoadModel entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getPersistence());
        wGetVisitor1().visit(entity.getResourceKind());
        wGetVisitor1().visit(entity.getResource());
        wGetVisitor1().visit(entity.getBindings());
    }

    public void visit(SaveModel entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getPersistence());
        wGetVisitor1().visit(entity.getResourceKind());
        wGetVisitor1().visit(entity.getResource());
        wGetVisitor1().visit(entity.getBindings());
    }

    public void visit(ArtifactsActivity entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getRootResourceKind());
        wGetVisitor1().visit(entity.getRootResource());
    }

    public void visit(DeleteArtifacts entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getRootResourceKind());
        wGetVisitor1().visit(entity.getRootResource());
    }

    public void visit(SynchronizeArtifactsActivity entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getRootResourceKind());
        wGetVisitor1().visit(entity.getRootResource());
        wGetVisitor1().visit(entity.getTraversalStrategy());
        wGetVisitor1().visit(entity.getSynchronizeStrategy());
        wGetVisitor1().visit(entity.getDefaultPersistence());
    }

    public void visit(LoadArtifacts entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getRootResourceKind());
        wGetVisitor1().visit(entity.getRootResource());
        wGetVisitor1().visit(entity.getTraversalStrategy());
        wGetVisitor1().visit(entity.getSynchronizeStrategy());
        wGetVisitor1().visit(entity.getDefaultPersistence());
    }

    public void visit(SaveArtifacts entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getRootResourceKind());
        wGetVisitor1().visit(entity.getRootResource());
        wGetVisitor1().visit(entity.getTraversalStrategy());
        wGetVisitor1().visit(entity.getSynchronizeStrategy());
        wGetVisitor1().visit(entity.getDefaultPersistence());
    }

    public void visit(GrammarActivity entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getText());
        wGetVisitor1().visit(entity.getGrammar());
        wGetVisitor1().visit(entity.getNt());
    }

    public void visit(Parse entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getText());
        wGetVisitor1().visit(entity.getGrammar());
        wGetVisitor1().visit(entity.getNt());
    }

    public void visit(Unparse entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getText());
        wGetVisitor1().visit(entity.getGrammar());
        wGetVisitor1().visit(entity.getNt());
    }

    public void visit(InvokeOperation entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getModel());
        wGetVisitor1().visit(entity.getOperation());
        wGetVisitor1().visit(entity.getBindings());
    }

    public void visit(InvokeQuery entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getQueryName());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(InvokeJavaInstanceMethod entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getResult());
        wGetVisitor1().visit(entity.getObject());
        wGetVisitor1().visit(entity.getTypeArguments());
        wGetVisitor1().visit(entity.getClassName());
        wGetVisitor1().visit(entity.getMethod());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(InvokeJavaClassMethod entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getResult());
        wGetVisitor1().visit(entity.getTypeArguments());
        wGetVisitor1().visit(entity.getClassName());
        wGetVisitor1().visit(entity.getMethod());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(CreateJavaClassInstance entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getResult());
        wGetVisitor1().visit(entity.getTypeArguments());
        wGetVisitor1().visit(entity.getClassName());
        wGetVisitor1().visit(entity.getConstructor());
        wGetVisitor1().visit(entity.getArguments());
    }

    public void visit(Declarations entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Assignments entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(Assign entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(Expressions entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }
}
