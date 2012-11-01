package org.whole.lang.workflows.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.workflows.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class WorkflowsEntityFactory extends GenericEntityFactory {
	public static final WorkflowsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static WorkflowsEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new WorkflowsEntityFactory(provider);
	}

	protected WorkflowsEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Workflow createWorkflow() {
		return create(WorkflowsEntityDescriptorEnum.Workflow);
	}

	public Workflow createWorkflow(Name name, Description description,
			Declarations declarations, StartEvent startEvent,
			FlowObject flowObject, FlowEvent endEvent) {
		return create(WorkflowsEntityDescriptorEnum.Workflow, name,
				description, declarations, startEvent, flowObject, endEvent);
	}

	public IEntityBuilder<Workflow> buildWorkflow() {
		return new EntityBuilder<Workflow>(
				create(WorkflowsEntityDescriptorEnum.Workflow));
	}

	public Scope createScope() {
		return create(WorkflowsEntityDescriptorEnum.Scope);
	}

	public Scope createScope(Label label, Declarations declarations,
			FlowObject flowObject, FlowObject compensationHandler,
			EventHandlers eventHandlers, FaultHandlers faultHandlers) {
		return create(WorkflowsEntityDescriptorEnum.Scope, label, declarations,
				flowObject, compensationHandler, eventHandlers, faultHandlers);
	}

	public IEntityBuilder<Scope> buildScope() {
		return new EntityBuilder<Scope>(
				create(WorkflowsEntityDescriptorEnum.Scope));
	}

	public FaultHandlers createFaultHandlers() {
		return create(WorkflowsEntityDescriptorEnum.FaultHandlers);
	}

	public FaultHandlers createFaultHandlers(FaultHandler... entities) {
		return create(WorkflowsEntityDescriptorEnum.FaultHandlers,
				(IEntity[]) entities);
	}

	public FaultHandlers createFaultHandlers(int initialSize) {
		return clone(WorkflowsEntityDescriptorEnum.FaultHandlers, initialSize);
	}

	public FaultHandler createFaultHandler() {
		return create(WorkflowsEntityDescriptorEnum.FaultHandler);
	}

	public FaultHandler createFaultHandler(Name name, Label label,
			Fault faultName, Variable faultVariable, FlowObject flowObject) {
		return create(WorkflowsEntityDescriptorEnum.FaultHandler, name, label,
				faultName, faultVariable, flowObject);
	}

	public IEntityBuilder<FaultHandler> buildFaultHandler() {
		return new EntityBuilder<FaultHandler>(
				create(WorkflowsEntityDescriptorEnum.FaultHandler));
	}

	public EventHandlers createEventHandlers() {
		return create(WorkflowsEntityDescriptorEnum.EventHandlers);
	}

	public EventHandlers createEventHandlers(EventHandler... entities) {
		return create(WorkflowsEntityDescriptorEnum.EventHandlers,
				(IEntity[]) entities);
	}

	public EventHandlers createEventHandlers(int initialSize) {
		return clone(WorkflowsEntityDescriptorEnum.EventHandlers, initialSize);
	}

	public EventHandler createEventHandler() {
		return create(WorkflowsEntityDescriptorEnum.EventHandler);
	}

	public EventHandler createEventHandler(Name name, Label label,
			StartEvent triggerEvent, FlowObject flowObject) {
		return create(WorkflowsEntityDescriptorEnum.EventHandler, name, label,
				triggerEvent, flowObject);
	}

	public IEntityBuilder<EventHandler> buildEventHandler() {
		return new EntityBuilder<EventHandler>(
				create(WorkflowsEntityDescriptorEnum.EventHandler));
	}

	public Sequence createSequence() {
		return create(WorkflowsEntityDescriptorEnum.Sequence);
	}

	public Sequence createSequence(Label label, FlowObjects flowObjects) {
		return create(WorkflowsEntityDescriptorEnum.Sequence, label,
				flowObjects);
	}

	public IEntityBuilder<Sequence> buildSequence() {
		return new EntityBuilder<Sequence>(
				create(WorkflowsEntityDescriptorEnum.Sequence));
	}

	public Parallel createParallel() {
		return create(WorkflowsEntityDescriptorEnum.Parallel);
	}

	public Parallel createParallel(Label label, FlowObjects flowObjects) {
		return create(WorkflowsEntityDescriptorEnum.Parallel, label,
				flowObjects);
	}

	public IEntityBuilder<Parallel> buildParallel() {
		return new EntityBuilder<Parallel>(
				create(WorkflowsEntityDescriptorEnum.Parallel));
	}

	public FlowObjects createFlowObjects() {
		return create(WorkflowsEntityDescriptorEnum.FlowObjects);
	}

	public FlowObjects createFlowObjects(FlowObject... entities) {
		return create(WorkflowsEntityDescriptorEnum.FlowObjects,
				(IEntity[]) entities);
	}

	public FlowObjects createFlowObjects(int initialSize) {
		return clone(WorkflowsEntityDescriptorEnum.FlowObjects, initialSize);
	}

	public ForeachLoop createForeachLoop() {
		return create(WorkflowsEntityDescriptorEnum.ForeachLoop);
	}

	public ForeachLoop createForeachLoop(Label label,
			Variable compositeVariable, Variable elementVariable,
			Variable indexVariable, FlowObject flowObject) {
		return create(WorkflowsEntityDescriptorEnum.ForeachLoop, label,
				compositeVariable, elementVariable, indexVariable, flowObject);
	}

	public IEntityBuilder<ForeachLoop> buildForeachLoop() {
		return new EntityBuilder<ForeachLoop>(
				create(WorkflowsEntityDescriptorEnum.ForeachLoop));
	}

	public WhileLoop createWhileLoop() {
		return create(WorkflowsEntityDescriptorEnum.WhileLoop);
	}

	public WhileLoop createWhileLoop(Label label, TestTime testTime,
			Condition condition, FlowObject flowObject) {
		return create(WorkflowsEntityDescriptorEnum.WhileLoop, label, testTime,
				condition, flowObject);
	}

	public IEntityBuilder<WhileLoop> buildWhileLoop() {
		return new EntityBuilder<WhileLoop>(
				create(WorkflowsEntityDescriptorEnum.WhileLoop));
	}

	public TestTime createTestTime() {
		return create(WorkflowsEntityDescriptorEnum.TestTime);
	}

	public TestTime createTestTime(TestTimeEnum.Value value) {
		return create(WorkflowsEntityDescriptorEnum.TestTime, value);
	}

	public PickControl createPickControl() {
		return create(WorkflowsEntityDescriptorEnum.PickControl);
	}

	public PickControl createPickControl(Label label,
			EventHandlers eventHandlers) {
		return create(WorkflowsEntityDescriptorEnum.PickControl, label,
				eventHandlers);
	}

	public IEntityBuilder<PickControl> buildPickControl() {
		return new EntityBuilder<PickControl>(
				create(WorkflowsEntityDescriptorEnum.PickControl));
	}

	public SwitchControl createSwitchControl() {
		return create(WorkflowsEntityDescriptorEnum.SwitchControl);
	}

	public SwitchControl createSwitchControl(Label label,
			SwitchType switchType, ConditionalCases conditionalCases,
			DefaultCase defaultCase) {
		return create(WorkflowsEntityDescriptorEnum.SwitchControl, label,
				switchType, conditionalCases, defaultCase);
	}

	public IEntityBuilder<SwitchControl> buildSwitchControl() {
		return new EntityBuilder<SwitchControl>(
				create(WorkflowsEntityDescriptorEnum.SwitchControl));
	}

	public SwitchType createSwitchType() {
		return create(WorkflowsEntityDescriptorEnum.SwitchType);
	}

	public SwitchType createSwitchType(SwitchTypeEnum.Value value) {
		return create(WorkflowsEntityDescriptorEnum.SwitchType, value);
	}

	public ConditionalCases createConditionalCases() {
		return create(WorkflowsEntityDescriptorEnum.ConditionalCases);
	}

	public ConditionalCases createConditionalCases(ConditionalCase... entities) {
		return create(WorkflowsEntityDescriptorEnum.ConditionalCases,
				(IEntity[]) entities);
	}

	public ConditionalCases createConditionalCases(int initialSize) {
		return clone(WorkflowsEntityDescriptorEnum.ConditionalCases,
				initialSize);
	}

	public ConditionalCase createConditionalCase() {
		return create(WorkflowsEntityDescriptorEnum.ConditionalCase);
	}

	public ConditionalCase createConditionalCase(Label label,
			Condition condition, FlowObject flowObject) {
		return create(WorkflowsEntityDescriptorEnum.ConditionalCase, label,
				condition, flowObject);
	}

	public IEntityBuilder<ConditionalCase> buildConditionalCase() {
		return new EntityBuilder<ConditionalCase>(
				create(WorkflowsEntityDescriptorEnum.ConditionalCase));
	}

	public DefaultCase createDefaultCase() {
		return create(WorkflowsEntityDescriptorEnum.DefaultCase);
	}

	public DefaultCase createDefaultCase(FlowObject flowObject) {
		return create(WorkflowsEntityDescriptorEnum.DefaultCase, flowObject);
	}

	public OnCallEvent createOnCallEvent() {
		return create(WorkflowsEntityDescriptorEnum.OnCallEvent);
	}

	public OnCallEvent createOnCallEvent(Name name, Label label,
			Parameters parameters) {
		return create(WorkflowsEntityDescriptorEnum.OnCallEvent, name, label,
				parameters);
	}

	public IEntityBuilder<OnCallEvent> buildOnCallEvent() {
		return new EntityBuilder<OnCallEvent>(
				create(WorkflowsEntityDescriptorEnum.OnCallEvent));
	}

	public OnMessageEvent createOnMessageEvent() {
		return create(WorkflowsEntityDescriptorEnum.OnMessageEvent);
	}

	public OnMessageEvent createOnMessageEvent(Name name, Label label,
			Message message) {
		return create(WorkflowsEntityDescriptorEnum.OnMessageEvent, name,
				label, message);
	}

	public IEntityBuilder<OnMessageEvent> buildOnMessageEvent() {
		return new EntityBuilder<OnMessageEvent>(
				create(WorkflowsEntityDescriptorEnum.OnMessageEvent));
	}

	public OnTimerEvent createOnTimerEvent() {
		return create(WorkflowsEntityDescriptorEnum.OnTimerEvent);
	}

	public OnTimerEvent createOnTimerEvent(Name name, Label label, Timer timer) {
		return create(WorkflowsEntityDescriptorEnum.OnTimerEvent, name, label,
				timer);
	}

	public IEntityBuilder<OnTimerEvent> buildOnTimerEvent() {
		return new EntityBuilder<OnTimerEvent>(
				create(WorkflowsEntityDescriptorEnum.OnTimerEvent));
	}

	public FaultEvent createFaultEvent() {
		return create(WorkflowsEntityDescriptorEnum.FaultEvent);
	}

	public FaultEvent createFaultEvent(Label label, Fault fault) {
		return create(WorkflowsEntityDescriptorEnum.FaultEvent, label, fault);
	}

	public IEntityBuilder<FaultEvent> buildFaultEvent() {
		return new EntityBuilder<FaultEvent>(
				create(WorkflowsEntityDescriptorEnum.FaultEvent));
	}

	public ReturnEvent createReturnEvent() {
		return create(WorkflowsEntityDescriptorEnum.ReturnEvent);
	}

	public ReturnEvent createReturnEvent(Label label, Result result) {
		return create(WorkflowsEntityDescriptorEnum.ReturnEvent, label, result);
	}

	public IEntityBuilder<ReturnEvent> buildReturnEvent() {
		return new EntityBuilder<ReturnEvent>(
				create(WorkflowsEntityDescriptorEnum.ReturnEvent));
	}

	public Task createTask() {
		return create(WorkflowsEntityDescriptorEnum.Task);
	}

	public Task createTask(Label label, Description description,
			Assignments assignments, Variable factory) {
		return create(WorkflowsEntityDescriptorEnum.Task, label, description,
				assignments, factory);
	}

	public IEntityBuilder<Task> buildTask() {
		return new EntityBuilder<Task>(
				create(WorkflowsEntityDescriptorEnum.Task));
	}

	public Breakpoint createBreakpoint() {
		return create(WorkflowsEntityDescriptorEnum.Breakpoint);
	}

	public Breakpoint createBreakpoint(Label label, BooleanLiteral disabled,
			IntLiteral hitCount, Condition condition,
			ConditionTest conditionTest, Variables showVariables) {
		return create(WorkflowsEntityDescriptorEnum.Breakpoint, label,
				disabled, hitCount, condition, conditionTest, showVariables);
	}

	public IEntityBuilder<Breakpoint> buildBreakpoint() {
		return new EntityBuilder<Breakpoint>(
				create(WorkflowsEntityDescriptorEnum.Breakpoint));
	}

	public ConditionTest createConditionTest() {
		return create(WorkflowsEntityDescriptorEnum.ConditionTest);
	}

	public ConditionTest createConditionTest(ConditionTestEnum.Value value) {
		return create(WorkflowsEntityDescriptorEnum.ConditionTest, value);
	}

	public Variables createVariables() {
		return create(WorkflowsEntityDescriptorEnum.Variables);
	}

	public Variables createVariables(Variable... entities) {
		return create(WorkflowsEntityDescriptorEnum.Variables,
				(IEntity[]) entities);
	}

	public Variables createVariables(int initialSize) {
		return clone(WorkflowsEntityDescriptorEnum.Variables, initialSize);
	}

	public EmptyActivity createEmptyActivity() {
		return create(WorkflowsEntityDescriptorEnum.EmptyActivity);
	}

	public EmptyActivity createEmptyActivity(Label label) {
		return create(WorkflowsEntityDescriptorEnum.EmptyActivity, label);
	}

	public AssignActivity createAssignActivity() {
		return create(WorkflowsEntityDescriptorEnum.AssignActivity);
	}

	public AssignActivity createAssignActivity(Label label,
			Assignments assignments) {
		return create(WorkflowsEntityDescriptorEnum.AssignActivity, label,
				assignments);
	}

	public IEntityBuilder<AssignActivity> buildAssignActivity() {
		return new EntityBuilder<AssignActivity>(
				create(WorkflowsEntityDescriptorEnum.AssignActivity));
	}

	public CreateEntity createCreateEntity() {
		return create(WorkflowsEntityDescriptorEnum.CreateEntity);
	}

	public CreateEntity createCreateEntity(Label label, Variable model,
			Registry registry, Expression entityName, Arguments arguments) {
		return create(WorkflowsEntityDescriptorEnum.CreateEntity, label, model,
				registry, entityName, arguments);
	}

	public IEntityBuilder<CreateEntity> buildCreateEntity() {
		return new EntityBuilder<CreateEntity>(
				create(WorkflowsEntityDescriptorEnum.CreateEntity));
	}

	public CreateModel createCreateModel() {
		return create(WorkflowsEntityDescriptorEnum.CreateModel);
	}

	public CreateModel createCreateModel(Label label, Variable model,
			Variable template, Assignments bindings) {
		return create(WorkflowsEntityDescriptorEnum.CreateModel, label, model,
				template, bindings);
	}

	public IEntityBuilder<CreateModel> buildCreateModel() {
		return new EntityBuilder<CreateModel>(
				create(WorkflowsEntityDescriptorEnum.CreateModel));
	}

	public LoadJavaModel createLoadJavaModel() {
		return create(WorkflowsEntityDescriptorEnum.LoadJavaModel);
	}

	public LoadJavaModel createLoadJavaModel(Label label, Variable model,
			Expression className, ClassProvider classProvider) {
		return create(WorkflowsEntityDescriptorEnum.LoadJavaModel, label,
				model, className, classProvider);
	}

	public IEntityBuilder<LoadJavaModel> buildLoadJavaModel() {
		return new EntityBuilder<LoadJavaModel>(
				create(WorkflowsEntityDescriptorEnum.LoadJavaModel));
	}

	public ResourceKind createResourceKind() {
		return create(WorkflowsEntityDescriptorEnum.ResourceKind);
	}

	public ResourceKind createResourceKind(ResourceKindEnum.Value value) {
		return create(WorkflowsEntityDescriptorEnum.ResourceKind, value);
	}

	public LoadModel createLoadModel() {
		return create(WorkflowsEntityDescriptorEnum.LoadModel);
	}

	public LoadModel createLoadModel(Label label, Variable model,
			Expression persistence, ResourceKind resourceKind,
			Expression resource, Assignments bindings) {
		return create(WorkflowsEntityDescriptorEnum.LoadModel, label, model,
				persistence, resourceKind, resource, bindings);
	}

	public IEntityBuilder<LoadModel> buildLoadModel() {
		return new EntityBuilder<LoadModel>(
				create(WorkflowsEntityDescriptorEnum.LoadModel));
	}

	public SaveModel createSaveModel() {
		return create(WorkflowsEntityDescriptorEnum.SaveModel);
	}

	public SaveModel createSaveModel(Label label, Variable model,
			Expression persistence, ResourceKind resourceKind,
			Expression resource, Assignments bindings) {
		return create(WorkflowsEntityDescriptorEnum.SaveModel, label, model,
				persistence, resourceKind, resource, bindings);
	}

	public IEntityBuilder<SaveModel> buildSaveModel() {
		return new EntityBuilder<SaveModel>(
				create(WorkflowsEntityDescriptorEnum.SaveModel));
	}

	public DeleteArtifacts createDeleteArtifacts() {
		return create(WorkflowsEntityDescriptorEnum.DeleteArtifacts);
	}

	public DeleteArtifacts createDeleteArtifacts(Label label, Variable model,
			ResourceKind rootResourceKind, Expression rootResource) {
		return create(WorkflowsEntityDescriptorEnum.DeleteArtifacts, label,
				model, rootResourceKind, rootResource);
	}

	public IEntityBuilder<DeleteArtifacts> buildDeleteArtifacts() {
		return new EntityBuilder<DeleteArtifacts>(
				create(WorkflowsEntityDescriptorEnum.DeleteArtifacts));
	}

	public ArtifactsTraversalStrategy createArtifactsTraversalStrategy() {
		return create(WorkflowsEntityDescriptorEnum.ArtifactsTraversalStrategy);
	}

	public ArtifactsTraversalStrategy createArtifactsTraversalStrategy(
			ArtifactsTraversalStrategyEnum.Value value) {
		return create(WorkflowsEntityDescriptorEnum.ArtifactsTraversalStrategy,
				value);
	}

	public ArtifactsSynchronizeStrategy createArtifactsSynchronizeStrategy() {
		return create(WorkflowsEntityDescriptorEnum.ArtifactsSynchronizeStrategy);
	}

	public ArtifactsSynchronizeStrategy createArtifactsSynchronizeStrategy(
			ArtifactsSynchronizeStrategyEnum.Value value) {
		return create(
				WorkflowsEntityDescriptorEnum.ArtifactsSynchronizeStrategy,
				value);
	}

	public LoadArtifacts createLoadArtifacts() {
		return create(WorkflowsEntityDescriptorEnum.LoadArtifacts);
	}

	public LoadArtifacts createLoadArtifacts(Label label, Variable model,
			ResourceKind rootResourceKind, Expression rootResource,
			ArtifactsTraversalStrategy traversalStrategy,
			ArtifactsSynchronizeStrategy synchronizeStrategy,
			Expression defaultPersistence) {
		return create(WorkflowsEntityDescriptorEnum.LoadArtifacts, label,
				model, rootResourceKind, rootResource, traversalStrategy,
				synchronizeStrategy, defaultPersistence);
	}

	public IEntityBuilder<LoadArtifacts> buildLoadArtifacts() {
		return new EntityBuilder<LoadArtifacts>(
				create(WorkflowsEntityDescriptorEnum.LoadArtifacts));
	}

	public SaveArtifacts createSaveArtifacts() {
		return create(WorkflowsEntityDescriptorEnum.SaveArtifacts);
	}

	public SaveArtifacts createSaveArtifacts(Label label, Variable model,
			ResourceKind rootResourceKind, Expression rootResource,
			ArtifactsTraversalStrategy traversalStrategy,
			ArtifactsSynchronizeStrategy synchronizeStrategy,
			Expression defaultPersistence) {
		return create(WorkflowsEntityDescriptorEnum.SaveArtifacts, label,
				model, rootResourceKind, rootResource, traversalStrategy,
				synchronizeStrategy, defaultPersistence);
	}

	public IEntityBuilder<SaveArtifacts> buildSaveArtifacts() {
		return new EntityBuilder<SaveArtifacts>(
				create(WorkflowsEntityDescriptorEnum.SaveArtifacts));
	}

	public Parse createParse() {
		return create(WorkflowsEntityDescriptorEnum.Parse);
	}

	public Parse createParse(Label label, Variable model, Expression text,
			Expression grammar, Expression nt) {
		return create(WorkflowsEntityDescriptorEnum.Parse, label, model, text,
				grammar, nt);
	}

	public IEntityBuilder<Parse> buildParse() {
		return new EntityBuilder<Parse>(
				create(WorkflowsEntityDescriptorEnum.Parse));
	}

	public Unparse createUnparse() {
		return create(WorkflowsEntityDescriptorEnum.Unparse);
	}

	public Unparse createUnparse(Label label, Variable model, Expression text,
			Expression grammar, Expression nt) {
		return create(WorkflowsEntityDescriptorEnum.Unparse, label, model,
				text, grammar, nt);
	}

	public IEntityBuilder<Unparse> buildUnparse() {
		return new EntityBuilder<Unparse>(
				create(WorkflowsEntityDescriptorEnum.Unparse));
	}

	public InvokeOperation createInvokeOperation() {
		return create(WorkflowsEntityDescriptorEnum.InvokeOperation);
	}

	public InvokeOperation createInvokeOperation(Label label, Variable model,
			Operation operation, Assignments bindings) {
		return create(WorkflowsEntityDescriptorEnum.InvokeOperation, label,
				model, operation, bindings);
	}

	public IEntityBuilder<InvokeOperation> buildInvokeOperation() {
		return new EntityBuilder<InvokeOperation>(
				create(WorkflowsEntityDescriptorEnum.InvokeOperation));
	}

	public Operation createOperation() {
		return create(WorkflowsEntityDescriptorEnum.Operation);
	}

	public Operation createOperation(OperationEnum.Value value) {
		return create(WorkflowsEntityDescriptorEnum.Operation, value);
	}

	public InvokeQuery createInvokeQuery() {
		return create(WorkflowsEntityDescriptorEnum.InvokeQuery);
	}

	public InvokeQuery createInvokeQuery(Label label, Variable queryName,
			Arguments arguments) {
		return create(WorkflowsEntityDescriptorEnum.InvokeQuery, label,
				queryName, arguments);
	}

	public IEntityBuilder<InvokeQuery> buildInvokeQuery() {
		return new EntityBuilder<InvokeQuery>(
				create(WorkflowsEntityDescriptorEnum.InvokeQuery));
	}

	public InvokeJavaInstanceMethod createInvokeJavaInstanceMethod() {
		return create(WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod);
	}

	public InvokeJavaInstanceMethod createInvokeJavaInstanceMethod(Label label,
			Variable result, Variable object, Expressions typeArguments,
			Expression className, Expression method, Expressions arguments) {
		return create(WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod,
				label, result, object, typeArguments, className, method,
				arguments);
	}

	public IEntityBuilder<InvokeJavaInstanceMethod> buildInvokeJavaInstanceMethod() {
		return new EntityBuilder<InvokeJavaInstanceMethod>(
				create(WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod));
	}

	public InvokeJavaClassMethod createInvokeJavaClassMethod() {
		return create(WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod);
	}

	public InvokeJavaClassMethod createInvokeJavaClassMethod(Label label,
			Variable result, Expressions typeArguments, Expression className,
			Expression method, Expressions arguments) {
		return create(WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod,
				label, result, typeArguments, className, method, arguments);
	}

	public IEntityBuilder<InvokeJavaClassMethod> buildInvokeJavaClassMethod() {
		return new EntityBuilder<InvokeJavaClassMethod>(
				create(WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod));
	}

	public CreateJavaClassInstance createCreateJavaClassInstance() {
		return create(WorkflowsEntityDescriptorEnum.CreateJavaClassInstance);
	}

	public CreateJavaClassInstance createCreateJavaClassInstance(Label label,
			Variable result, Expressions typeArguments, Expression className,
			Expression constructor, Expressions arguments) {
		return create(WorkflowsEntityDescriptorEnum.CreateJavaClassInstance,
				label, result, typeArguments, className, constructor, arguments);
	}

	public IEntityBuilder<CreateJavaClassInstance> buildCreateJavaClassInstance() {
		return new EntityBuilder<CreateJavaClassInstance>(
				create(WorkflowsEntityDescriptorEnum.CreateJavaClassInstance));
	}

	public Registry createRegistry() {
		return create(WorkflowsEntityDescriptorEnum.Registry);
	}

	public Registry createRegistry(RegistryEnum.Value value) {
		return create(WorkflowsEntityDescriptorEnum.Registry, value);
	}

	public BooleanLiteral createBooleanLiteral() {
		return create(WorkflowsEntityDescriptorEnum.BooleanLiteral);
	}

	public BooleanLiteral createBooleanLiteral(boolean value) {
		return create(WorkflowsEntityDescriptorEnum.BooleanLiteral, value);
	}

	public IntLiteral createIntLiteral() {
		return create(WorkflowsEntityDescriptorEnum.IntLiteral);
	}

	public IntLiteral createIntLiteral(int value) {
		return create(WorkflowsEntityDescriptorEnum.IntLiteral, value);
	}

	public StringLiteral createStringLiteral() {
		return create(WorkflowsEntityDescriptorEnum.StringLiteral);
	}

	public StringLiteral createStringLiteral(String value) {
		return create(WorkflowsEntityDescriptorEnum.StringLiteral, value);
	}

	public ObjectLiteral createObjectLiteral() {
		return create(WorkflowsEntityDescriptorEnum.ObjectLiteral);
	}

	public ObjectLiteral createObjectLiteral(java.lang.Object value) {
		return create(WorkflowsEntityDescriptorEnum.ObjectLiteral, value);
	}

	public Variable createVariable() {
		return create(WorkflowsEntityDescriptorEnum.Variable);
	}

	public Variable createVariable(String value) {
		return create(WorkflowsEntityDescriptorEnum.Variable, value);
	}

	public Name createName() {
		return create(WorkflowsEntityDescriptorEnum.Name);
	}

	public Name createName(String value) {
		return create(WorkflowsEntityDescriptorEnum.Name, value);
	}

	public Text createText() {
		return create(WorkflowsEntityDescriptorEnum.Text);
	}

	public Text createText(String value) {
		return create(WorkflowsEntityDescriptorEnum.Text, value);
	}

	public Declarations createDeclarations() {
		return create(WorkflowsEntityDescriptorEnum.Declarations);
	}

	public Declarations createDeclarations(Declaration... entities) {
		return create(WorkflowsEntityDescriptorEnum.Declarations,
				(IEntity[]) entities);
	}

	public Declarations createDeclarations(int initialSize) {
		return clone(WorkflowsEntityDescriptorEnum.Declarations, initialSize);
	}

	public Assignments createAssignments() {
		return create(WorkflowsEntityDescriptorEnum.Assignments);
	}

	public Assignments createAssignments(Assign... entities) {
		return create(WorkflowsEntityDescriptorEnum.Assignments,
				(IEntity[]) entities);
	}

	public Assignments createAssignments(int initialSize) {
		return clone(WorkflowsEntityDescriptorEnum.Assignments, initialSize);
	}

	public Assign createAssign() {
		return create(WorkflowsEntityDescriptorEnum.Assign);
	}

	public Assign createAssign(Variable name, Expression expression) {
		return create(WorkflowsEntityDescriptorEnum.Assign, name, expression);
	}

	public IEntityBuilder<Assign> buildAssign() {
		return new EntityBuilder<Assign>(
				create(WorkflowsEntityDescriptorEnum.Assign));
	}

	public Expressions createExpressions() {
		return create(WorkflowsEntityDescriptorEnum.Expressions);
	}

	public Expressions createExpressions(Expression... entities) {
		return create(WorkflowsEntityDescriptorEnum.Expressions,
				(IEntity[]) entities);
	}

	public Expressions createExpressions(int initialSize) {
		return clone(WorkflowsEntityDescriptorEnum.Expressions, initialSize);
	}

	public Signature createSignature() {
		return create(WorkflowsEntityDescriptorEnum.Signature);
	}

	public Signature createSignature(String value) {
		return create(WorkflowsEntityDescriptorEnum.Signature, value);
	}

	public ClassPath createClassPath() {
		return create(WorkflowsEntityDescriptorEnum.ClassPath);
	}

	public CurrentJavaProject createCurrentJavaProject() {
		return create(WorkflowsEntityDescriptorEnum.CurrentJavaProject);
	}

	public JavaProject createJavaProject() {
		return create(WorkflowsEntityDescriptorEnum.JavaProject);
	}

	public JavaProject createJavaProject(String value) {
		return create(WorkflowsEntityDescriptorEnum.JavaProject, value);
	}
}
