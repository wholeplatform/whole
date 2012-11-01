package org.whole.lang.workflows.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.workflows.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class WorkflowsForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements IWorkflowsVisitor {
	public WorkflowsForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Workflow entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Scope entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FaultHandlers entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FaultHandler entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EventHandlers entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EventHandler entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Sequence entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Parallel entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FlowObjects entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ForeachLoop entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(WhileLoop entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TestTime entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PickControl entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SwitchControl entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SwitchType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ConditionalCases entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ConditionalCase entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DefaultCase entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(OnCallEvent entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(OnMessageEvent entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(OnTimerEvent entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FaultEvent entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ReturnEvent entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Task entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Breakpoint entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ConditionTest entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Variables entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EmptyActivity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AssignActivity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CreateEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CreateModel entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LoadJavaModel entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ResourceKind entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LoadModel entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SaveModel entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DeleteArtifacts entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ArtifactsTraversalStrategy entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ArtifactsSynchronizeStrategy entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LoadArtifacts entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SaveArtifacts entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Parse entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Unparse entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InvokeOperation entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Operation entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InvokeQuery entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InvokeJavaInstanceMethod entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InvokeJavaClassMethod entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CreateJavaClassInstance entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Registry entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BooleanLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IntLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StringLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ObjectLiteral entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Variable entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Name entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Text entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Declarations entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Assignments entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Assign entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Expressions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Signature entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ClassPath entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(CurrentJavaProject entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(JavaProject entity) {
		wGetVisitor1().visit(entity);
	}
}
