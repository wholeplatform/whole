package org.whole.lang.workflows.visitors;

import org.whole.lang.workflows.visitors.WorkflowsIdentityUnaryVisitor;
import org.whole.lang.workflows.visitors.IWorkflowsVisitor;
import org.whole.lang.workflows.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class WorkflowsTraverseAllChildrenVisitor extends
		WorkflowsIdentityUnaryVisitor<IWorkflowsVisitor> {
	public WorkflowsTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public WorkflowsTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(Workflow entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getDescription().accept(wGetVisitor1());
		entity.getDeclarations().accept(wGetVisitor1());
		entity.getStartEvent().accept(wGetVisitor1());
		entity.getFlowObject().accept(wGetVisitor1());
		entity.getEndEvent().accept(wGetVisitor1());
	}

	public void visit(FlowObject entity) {
		entity.getLabel().accept(wGetVisitor1());
	}

	public void visit(Scope entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getDeclarations().accept(wGetVisitor1());
		entity.getFlowObject().accept(wGetVisitor1());
		entity.getCompensationHandler().accept(wGetVisitor1());
		entity.getEventHandlers().accept(wGetVisitor1());
		entity.getFaultHandlers().accept(wGetVisitor1());
	}

	public void visit(FaultHandlers entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(FaultHandler entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getLabel().accept(wGetVisitor1());
		entity.getFaultName().accept(wGetVisitor1());
		entity.getFaultVariable().accept(wGetVisitor1());
		entity.getFlowObject().accept(wGetVisitor1());
	}

	public void visit(EventHandlers entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(EventHandler entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getLabel().accept(wGetVisitor1());
		entity.getTriggerEvent().accept(wGetVisitor1());
		entity.getFlowObject().accept(wGetVisitor1());
	}

	public void visit(Sequence entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getFlowObjects().accept(wGetVisitor1());
	}

	public void visit(Parallel entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getFlowObjects().accept(wGetVisitor1());
	}

	public void visit(FlowObjects entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ForeachLoop entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getCompositeVariable().accept(wGetVisitor1());
		entity.getElementVariable().accept(wGetVisitor1());
		entity.getIndexVariable().accept(wGetVisitor1());
		entity.getFlowObject().accept(wGetVisitor1());
	}

	public void visit(WhileLoop entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getTestTime().accept(wGetVisitor1());
		entity.getCondition().accept(wGetVisitor1());
		entity.getFlowObject().accept(wGetVisitor1());
	}

	public void visit(PickControl entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getEventHandlers().accept(wGetVisitor1());
	}

	public void visit(SwitchControl entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getSwitchType().accept(wGetVisitor1());
		entity.getConditionalCases().accept(wGetVisitor1());
		entity.getDefaultCase().accept(wGetVisitor1());
	}

	public void visit(ConditionalCases entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(ConditionalCase entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getCondition().accept(wGetVisitor1());
		entity.getFlowObject().accept(wGetVisitor1());
	}

	public void visit(DefaultCase entity) {
		entity.getFlowObject().accept(wGetVisitor1());
	}

	public void visit(StartEvent entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getLabel().accept(wGetVisitor1());
	}

	public void visit(FlowEvent entity) {
		entity.getLabel().accept(wGetVisitor1());
	}

	public void visit(OnCallEvent entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getLabel().accept(wGetVisitor1());
		entity.getParameters().accept(wGetVisitor1());
	}

	public void visit(OnMessageEvent entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getLabel().accept(wGetVisitor1());
		entity.getMessage().accept(wGetVisitor1());
	}

	public void visit(OnTimerEvent entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getLabel().accept(wGetVisitor1());
		entity.getTimer().accept(wGetVisitor1());
	}

	public void visit(FaultEvent entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getFault().accept(wGetVisitor1());
	}

	public void visit(ReturnEvent entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getResult().accept(wGetVisitor1());
	}

	public void visit(Task entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getDescription().accept(wGetVisitor1());
		entity.getAssignments().accept(wGetVisitor1());
		entity.getFactory().accept(wGetVisitor1());
	}

	public void visit(Breakpoint entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getDisabled().accept(wGetVisitor1());
		entity.getHitCount().accept(wGetVisitor1());
		entity.getCondition().accept(wGetVisitor1());
		entity.getConditionTest().accept(wGetVisitor1());
		entity.getShowVariables().accept(wGetVisitor1());
	}

	public void visit(Variables entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Activity entity) {
		entity.getLabel().accept(wGetVisitor1());
	}

	public void visit(EmptyActivity entity) {
		entity.getLabel().accept(wGetVisitor1());
	}

	public void visit(AssignActivity entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getAssignments().accept(wGetVisitor1());
	}

	public void visit(CreateEntity entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getRegistry().accept(wGetVisitor1());
		entity.getEntityName().accept(wGetVisitor1());
		entity.getArguments().accept(wGetVisitor1());
	}

	public void visit(CreateModel entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getTemplate().accept(wGetVisitor1());
		entity.getBindings().accept(wGetVisitor1());
	}

	public void visit(LoadJavaModel entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getClassName().accept(wGetVisitor1());
		entity.getClassProvider().accept(wGetVisitor1());
	}

	public void visit(PersistenceActivity entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getPersistence().accept(wGetVisitor1());
		entity.getResourceKind().accept(wGetVisitor1());
		entity.getResource().accept(wGetVisitor1());
		entity.getBindings().accept(wGetVisitor1());
	}

	public void visit(LoadModel entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getPersistence().accept(wGetVisitor1());
		entity.getResourceKind().accept(wGetVisitor1());
		entity.getResource().accept(wGetVisitor1());
		entity.getBindings().accept(wGetVisitor1());
	}

	public void visit(SaveModel entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getPersistence().accept(wGetVisitor1());
		entity.getResourceKind().accept(wGetVisitor1());
		entity.getResource().accept(wGetVisitor1());
		entity.getBindings().accept(wGetVisitor1());
	}

	public void visit(ArtifactsActivity entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getRootResourceKind().accept(wGetVisitor1());
		entity.getRootResource().accept(wGetVisitor1());
	}

	public void visit(DeleteArtifacts entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getRootResourceKind().accept(wGetVisitor1());
		entity.getRootResource().accept(wGetVisitor1());
	}

	public void visit(SynchronizeArtifactsActivity entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getRootResourceKind().accept(wGetVisitor1());
		entity.getRootResource().accept(wGetVisitor1());
		entity.getTraversalStrategy().accept(wGetVisitor1());
		entity.getSynchronizeStrategy().accept(wGetVisitor1());
		entity.getDefaultPersistence().accept(wGetVisitor1());
	}

	public void visit(LoadArtifacts entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getRootResourceKind().accept(wGetVisitor1());
		entity.getRootResource().accept(wGetVisitor1());
		entity.getTraversalStrategy().accept(wGetVisitor1());
		entity.getSynchronizeStrategy().accept(wGetVisitor1());
		entity.getDefaultPersistence().accept(wGetVisitor1());
	}

	public void visit(SaveArtifacts entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getRootResourceKind().accept(wGetVisitor1());
		entity.getRootResource().accept(wGetVisitor1());
		entity.getTraversalStrategy().accept(wGetVisitor1());
		entity.getSynchronizeStrategy().accept(wGetVisitor1());
		entity.getDefaultPersistence().accept(wGetVisitor1());
	}

	public void visit(GrammarActivity entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getText().accept(wGetVisitor1());
		entity.getGrammar().accept(wGetVisitor1());
		entity.getNt().accept(wGetVisitor1());
	}

	public void visit(Parse entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getText().accept(wGetVisitor1());
		entity.getGrammar().accept(wGetVisitor1());
		entity.getNt().accept(wGetVisitor1());
	}

	public void visit(Unparse entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getText().accept(wGetVisitor1());
		entity.getGrammar().accept(wGetVisitor1());
		entity.getNt().accept(wGetVisitor1());
	}

	public void visit(InvokeOperation entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getModel().accept(wGetVisitor1());
		entity.getOperation().accept(wGetVisitor1());
		entity.getBindings().accept(wGetVisitor1());
	}

	public void visit(InvokeQuery entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getQueryName().accept(wGetVisitor1());
		entity.getArguments().accept(wGetVisitor1());
	}

	public void visit(InvokeJavaInstanceMethod entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getResult().accept(wGetVisitor1());
		entity.getObject().accept(wGetVisitor1());
		entity.getTypeArguments().accept(wGetVisitor1());
		entity.getClassName().accept(wGetVisitor1());
		entity.getMethod().accept(wGetVisitor1());
		entity.getArguments().accept(wGetVisitor1());
	}

	public void visit(InvokeJavaClassMethod entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getResult().accept(wGetVisitor1());
		entity.getTypeArguments().accept(wGetVisitor1());
		entity.getClassName().accept(wGetVisitor1());
		entity.getMethod().accept(wGetVisitor1());
		entity.getArguments().accept(wGetVisitor1());
	}

	public void visit(CreateJavaClassInstance entity) {
		entity.getLabel().accept(wGetVisitor1());
		entity.getResult().accept(wGetVisitor1());
		entity.getTypeArguments().accept(wGetVisitor1());
		entity.getClassName().accept(wGetVisitor1());
		entity.getConstructor().accept(wGetVisitor1());
		entity.getArguments().accept(wGetVisitor1());
	}

	public void visit(Declarations entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Assignments entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(Assign entity) {
		entity.getName().accept(wGetVisitor1());
		entity.getExpression().accept(wGetVisitor1());
	}

	public void visit(Expressions entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}
}
