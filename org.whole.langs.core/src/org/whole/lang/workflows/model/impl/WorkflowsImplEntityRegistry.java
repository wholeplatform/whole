package org.whole.lang.workflows.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class WorkflowsImplEntityRegistry extends AbstractEntityRegistry {
	public WorkflowsImplEntityRegistry() {
		super(WorkflowsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new WorkflowImpl());
		put(new ScopeImpl());
		put(new FaultHandlersImpl());
		put(new FaultHandlerImpl());
		put(new EventHandlersImpl());
		put(new EventHandlerImpl());
		put(new SequenceImpl());
		put(new ParallelImpl());
		put(new FlowObjectsImpl());
		put(new ForeachLoopImpl());
		put(new WhileLoopImpl());
		put(new TestTimeImpl());
		put(new PickControlImpl());
		put(new SwitchControlImpl());
		put(new SwitchTypeImpl());
		put(new ConditionalCasesImpl());
		put(new ConditionalCaseImpl());
		put(new DefaultCaseImpl());
		put(new OnCallEventImpl());
		put(new OnMessageEventImpl());
		put(new OnTimerEventImpl());
		put(new FaultEventImpl());
		put(new ReturnEventImpl());
		put(new TaskImpl());
		put(new BreakpointImpl());
		put(new ConditionTestImpl());
		put(new VariablesImpl());
		put(new EmptyActivityImpl());
		put(new AssignActivityImpl());
		put(new CreateEntityImpl());
		put(new CreateModelImpl());
		put(new LoadJavaModelImpl());
		put(new ResourceKindImpl());
		put(new LoadModelImpl());
		put(new SaveModelImpl());
		put(new DeleteArtifactsImpl());
		put(new ArtifactsTraversalStrategyImpl());
		put(new ArtifactsSynchronizeStrategyImpl());
		put(new LoadArtifactsImpl());
		put(new SaveArtifactsImpl());
		put(new ParseImpl());
		put(new UnparseImpl());
		put(new InvokeOperationImpl());
		put(new OperationImpl());
		put(new InvokeQueryImpl());
		put(new InvokeJavaInstanceMethodImpl());
		put(new InvokeJavaClassMethodImpl());
		put(new CreateJavaClassInstanceImpl());
		put(new RegistryImpl());
		put(new BooleanLiteralImpl());
		put(new IntLiteralImpl());
		put(new StringLiteralImpl());
		put(new ObjectLiteralImpl());
		put(new VariableImpl());
		put(new NameImpl());
		put(new TextImpl());
		put(new DeclarationsImpl());
		put(new AssignmentsImpl());
		put(new AssignImpl());
		put(new ExpressionsImpl());
		put(new SignatureImpl());
		put(new ClassPathImpl());
		put(new CurrentJavaProjectImpl());
		put(new JavaProjectImpl());
	}
}
