package org.whole.lang.workflows.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class WorkflowsAdaptersEntityRegistry extends AbstractEntityRegistry {
	public WorkflowsAdaptersEntityRegistry() {
		super(WorkflowsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new WorkflowAdapter());
		put(new FlowObjectAdapter());
		put(new ScopeAdapter());
		put(new FaultHandlersAdapter());
		put(new FaultHandlerAdapter());
		put(new EventHandlersAdapter());
		put(new EventHandlerAdapter());
		put(new SequenceAdapter());
		put(new ParallelAdapter());
		put(new FlowObjectsAdapter());
		put(new ForeachLoopAdapter());
		put(new WhileLoopAdapter());
		put(new TestTimeAdapter());
		put(new PickControlAdapter());
		put(new SwitchControlAdapter());
		put(new SwitchTypeAdapter());
		put(new ConditionalCasesAdapter());
		put(new ConditionalCaseAdapter());
		put(new DefaultCaseAdapter());
		put(new StartEventAdapter());
		put(new FlowEventAdapter());
		put(new OnCallEventAdapter());
		put(new OnMessageEventAdapter());
		put(new OnTimerEventAdapter());
		put(new FaultEventAdapter());
		put(new ReturnEventAdapter());
		put(new TaskAdapter());
		put(new BreakpointAdapter());
		put(new ConditionTestAdapter());
		put(new VariablesAdapter());
		put(new ActivityAdapter());
		put(new EmptyActivityAdapter());
		put(new AssignActivityAdapter());
		put(new CreateEntityAdapter());
		put(new CreateModelAdapter());
		put(new LoadJavaModelAdapter());
		put(new PersistenceActivityAdapter());
		put(new ResourceKindAdapter());
		put(new LoadModelAdapter());
		put(new SaveModelAdapter());
		put(new ArtifactsActivityAdapter());
		put(new DeleteArtifactsAdapter());
		put(new SynchronizeArtifactsActivityAdapter());
		put(new ArtifactsTraversalStrategyAdapter());
		put(new ArtifactsSynchronizeStrategyAdapter());
		put(new LoadArtifactsAdapter());
		put(new SaveArtifactsAdapter());
		put(new GrammarActivityAdapter());
		put(new ParseAdapter());
		put(new UnparseAdapter());
		put(new InvokeOperationAdapter());
		put(new OperationAdapter());
		put(new InvokeQueryAdapter());
		put(new InvokeJavaInstanceMethodAdapter());
		put(new InvokeJavaClassMethodAdapter());
		put(new CreateJavaClassInstanceAdapter());
		put(new RegistryAdapter());
		put(new ExpressionAdapter());
		put(new LiteralAdapter());
		put(new BooleanLiteralAdapter());
		put(new IntLiteralAdapter());
		put(new StringLiteralAdapter());
		put(new ObjectLiteralAdapter());
		put(new VariableAdapter());
		put(new NameAdapter());
		put(new LabelAdapter());
		put(new DescriptionAdapter());
		put(new TextAdapter());
		put(new DeclarationsAdapter());
		put(new ArgumentsAdapter());
		put(new AssignmentsAdapter());
		put(new AssignAdapter());
		put(new ExpressionsAdapter());
		put(new SignatureAdapter());
		put(new DeclarationAdapter());
		put(new ClassProviderAdapter());
		put(new ClassPathAdapter());
		put(new CurrentJavaProjectAdapter());
		put(new JavaProjectAdapter());
		put(new ConditionAdapter());
		put(new ParametersAdapter());
		put(new ResultAdapter());
		put(new MessageAdapter());
		put(new EventAdapter());
		put(new TimerAdapter());
		put(new FaultAdapter());
	}
}
