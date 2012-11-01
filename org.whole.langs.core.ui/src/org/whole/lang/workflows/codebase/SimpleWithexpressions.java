package org.whole.lang.workflows.codebase;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.workflows.builders.IWorkflowsBuilder;
import org.whole.lang.workflows.model.Workflow;
import org.whole.lang.workflows.reflect.WorkflowsLanguageKit;

/**
 * @generator Whole
 */
public class SimpleWithexpressions extends AbstractTemplateFactory<Workflow> {
	public void apply(IBuilderOperation op) {
		IWorkflowsBuilder b0 = (IWorkflowsBuilder) op
				.wGetBuilder(WorkflowsLanguageKit.URI);
		b0.Workflow_();
//		b0.Name("Workflow");
//		b0.Description("Workflow");
//		b0.Sequence_();
//		b0.Activities_(4);
//		b0.Task_();
//		b0.Description("first task");
//		b0._Task();
//		b0.WorkflowBaseFragment_();
//		IImpBuilder b1 = (IImpBuilder) op.wGetBuilder(ImpLanguageKit.URI);
//		b1.VariableDeclaration_();
//		b1.PrimitiveType("int");
//		b1.Name("x");
//		b1.IntLiteral(0);
//		b1._VariableDeclaration();
//		b0._WorkflowBaseFragment();
//		b0.Parallel_();
//		b0.Activities_(2);
//		b0.Sequence_();
//		b0.Activities_(2);
//		b0.Task_();
//		b0.Description("one task");
//		b0._Task();
//		b0.Task_();
//		b0.Description("another task");
//		b0._Task();
//		b0._Activities();
//		b0._Sequence();
//		b0.WhileControl_();
//		b0.WorkflowBaseFragment_();
//		b1.LessThan_();
//		b1.NameExpression("x");
//		b1.IntLiteral(5);
//		b1._LessThan();
//		b0._WorkflowBaseFragment();
//		b0.Sequence_();
//		b0.Activities_(2);
//		b0.Task_();
//		b0.Description("repeated task");
//		b0._Task();
//		b0.WorkflowBaseFragment_();
//		b1.AssignmentExpression_();
//		b1.Name("x");
//		b1.Addition_();
//		b1.NameExpression("x");
//		b1.IntLiteral(1);
//		b1._Addition();
//		b1._AssignmentExpression();
//		b0._WorkflowBaseFragment();
//		b0._Activities();
//		b0._Sequence();
//		b0._WhileControl();
//		b0._Activities();
//		b0._Parallel();
//		b0.Task_();
//		b0.Description("last task");
//		b0._Task();
//		b0._Activities();
//		b0._Sequence();
		b0._Workflow();
	}
}