package org.whole.lang.workflows.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.workflows.model.TestTimeEnum;
import org.whole.lang.workflows.model.SwitchTypeEnum;
import org.whole.lang.workflows.model.ConditionTestEnum;
import org.whole.lang.workflows.model.ResourceKindEnum;
import org.whole.lang.workflows.model.ArtifactsTraversalStrategyEnum;
import org.whole.lang.workflows.model.ArtifactsSynchronizeStrategyEnum;
import org.whole.lang.workflows.model.OperationEnum;
import org.whole.lang.workflows.model.RegistryEnum;

/** 
 * @generator Whole
 */
public class WorkflowsSpecificBuilderAdapter extends GenericBuilderContext
		implements IWorkflowsBuilder {
	public WorkflowsSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public WorkflowsSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void expression() {
		wFeature(WorkflowsFeatureDescriptorEnum.expression);
	}

	public void constructor() {
		wFeature(WorkflowsFeatureDescriptorEnum.constructor);
	}

	public void method() {
		wFeature(WorkflowsFeatureDescriptorEnum.method);
	}

	public void typeArguments() {
		wFeature(WorkflowsFeatureDescriptorEnum.typeArguments);
	}

	public void object() {
		wFeature(WorkflowsFeatureDescriptorEnum.object);
	}

	public void queryName() {
		wFeature(WorkflowsFeatureDescriptorEnum.queryName);
	}

	public void operation() {
		wFeature(WorkflowsFeatureDescriptorEnum.operation);
	}

	public void nt() {
		wFeature(WorkflowsFeatureDescriptorEnum.nt);
	}

	public void grammar() {
		wFeature(WorkflowsFeatureDescriptorEnum.grammar);
	}

	public void text() {
		wFeature(WorkflowsFeatureDescriptorEnum.text);
	}

	public void defaultPersistence() {
		wFeature(WorkflowsFeatureDescriptorEnum.defaultPersistence);
	}

	public void synchronizeStrategy() {
		wFeature(WorkflowsFeatureDescriptorEnum.synchronizeStrategy);
	}

	public void traversalStrategy() {
		wFeature(WorkflowsFeatureDescriptorEnum.traversalStrategy);
	}

	public void rootResource() {
		wFeature(WorkflowsFeatureDescriptorEnum.rootResource);
	}

	public void rootResourceKind() {
		wFeature(WorkflowsFeatureDescriptorEnum.rootResourceKind);
	}

	public void resource() {
		wFeature(WorkflowsFeatureDescriptorEnum.resource);
	}

	public void resourceKind() {
		wFeature(WorkflowsFeatureDescriptorEnum.resourceKind);
	}

	public void persistence() {
		wFeature(WorkflowsFeatureDescriptorEnum.persistence);
	}

	public void classProvider() {
		wFeature(WorkflowsFeatureDescriptorEnum.classProvider);
	}

	public void className() {
		wFeature(WorkflowsFeatureDescriptorEnum.className);
	}

	public void bindings() {
		wFeature(WorkflowsFeatureDescriptorEnum.bindings);
	}

	public void template() {
		wFeature(WorkflowsFeatureDescriptorEnum.template);
	}

	public void arguments() {
		wFeature(WorkflowsFeatureDescriptorEnum.arguments);
	}

	public void entityName() {
		wFeature(WorkflowsFeatureDescriptorEnum.entityName);
	}

	public void registry() {
		wFeature(WorkflowsFeatureDescriptorEnum.registry);
	}

	public void model() {
		wFeature(WorkflowsFeatureDescriptorEnum.model);
	}

	public void showVariables() {
		wFeature(WorkflowsFeatureDescriptorEnum.showVariables);
	}

	public void conditionTest() {
		wFeature(WorkflowsFeatureDescriptorEnum.conditionTest);
	}

	public void hitCount() {
		wFeature(WorkflowsFeatureDescriptorEnum.hitCount);
	}

	public void disabled() {
		wFeature(WorkflowsFeatureDescriptorEnum.disabled);
	}

	public void factory() {
		wFeature(WorkflowsFeatureDescriptorEnum.factory);
	}

	public void assignments() {
		wFeature(WorkflowsFeatureDescriptorEnum.assignments);
	}

	public void result() {
		wFeature(WorkflowsFeatureDescriptorEnum.result);
	}

	public void fault() {
		wFeature(WorkflowsFeatureDescriptorEnum.fault);
	}

	public void timer() {
		wFeature(WorkflowsFeatureDescriptorEnum.timer);
	}

	public void message() {
		wFeature(WorkflowsFeatureDescriptorEnum.message);
	}

	public void parameters() {
		wFeature(WorkflowsFeatureDescriptorEnum.parameters);
	}

	public void defaultCase() {
		wFeature(WorkflowsFeatureDescriptorEnum.defaultCase);
	}

	public void conditionalCases() {
		wFeature(WorkflowsFeatureDescriptorEnum.conditionalCases);
	}

	public void switchType() {
		wFeature(WorkflowsFeatureDescriptorEnum.switchType);
	}

	public void condition() {
		wFeature(WorkflowsFeatureDescriptorEnum.condition);
	}

	public void testTime() {
		wFeature(WorkflowsFeatureDescriptorEnum.testTime);
	}

	public void indexVariable() {
		wFeature(WorkflowsFeatureDescriptorEnum.indexVariable);
	}

	public void elementVariable() {
		wFeature(WorkflowsFeatureDescriptorEnum.elementVariable);
	}

	public void compositeVariable() {
		wFeature(WorkflowsFeatureDescriptorEnum.compositeVariable);
	}

	public void flowObjects() {
		wFeature(WorkflowsFeatureDescriptorEnum.flowObjects);
	}

	public void triggerEvent() {
		wFeature(WorkflowsFeatureDescriptorEnum.triggerEvent);
	}

	public void faultVariable() {
		wFeature(WorkflowsFeatureDescriptorEnum.faultVariable);
	}

	public void faultName() {
		wFeature(WorkflowsFeatureDescriptorEnum.faultName);
	}

	public void faultHandlers() {
		wFeature(WorkflowsFeatureDescriptorEnum.faultHandlers);
	}

	public void eventHandlers() {
		wFeature(WorkflowsFeatureDescriptorEnum.eventHandlers);
	}

	public void compensationHandler() {
		wFeature(WorkflowsFeatureDescriptorEnum.compensationHandler);
	}

	public void label() {
		wFeature(WorkflowsFeatureDescriptorEnum.label);
	}

	public void endEvent() {
		wFeature(WorkflowsFeatureDescriptorEnum.endEvent);
	}

	public void flowObject() {
		wFeature(WorkflowsFeatureDescriptorEnum.flowObject);
	}

	public void startEvent() {
		wFeature(WorkflowsFeatureDescriptorEnum.startEvent);
	}

	public void declarations() {
		wFeature(WorkflowsFeatureDescriptorEnum.declarations);
	}

	public void description() {
		wFeature(WorkflowsFeatureDescriptorEnum.description);
	}

	public void name() {
		wFeature(WorkflowsFeatureDescriptorEnum.name);
	}

	public void visit() {
	}

	public void Workflow() {
		wEntity(WorkflowsEntityDescriptorEnum.Workflow);
	}

	public void Workflow_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Workflow);
	}

	public void _Workflow() {
		_wEntity(WorkflowsEntityDescriptorEnum.Workflow);
	}

	public void Scope() {
		wEntity(WorkflowsEntityDescriptorEnum.Scope);
	}

	public void Scope_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Scope);
	}

	public void _Scope() {
		_wEntity(WorkflowsEntityDescriptorEnum.Scope);
	}

	public void FaultHandlers() {
		wEntity(WorkflowsEntityDescriptorEnum.FaultHandlers);
	}

	public void FaultHandlers_() {
		wEntity_(WorkflowsEntityDescriptorEnum.FaultHandlers);
	}

	public void FaultHandlers_(int initialCapacity) {
		wEntity_(WorkflowsEntityDescriptorEnum.FaultHandlers, initialCapacity);
	}

	public void _FaultHandlers() {
		_wEntity(WorkflowsEntityDescriptorEnum.FaultHandlers);
	}

	public void FaultHandler() {
		wEntity(WorkflowsEntityDescriptorEnum.FaultHandler);
	}

	public void FaultHandler_() {
		wEntity_(WorkflowsEntityDescriptorEnum.FaultHandler);
	}

	public void _FaultHandler() {
		_wEntity(WorkflowsEntityDescriptorEnum.FaultHandler);
	}

	public void EventHandlers() {
		wEntity(WorkflowsEntityDescriptorEnum.EventHandlers);
	}

	public void EventHandlers_() {
		wEntity_(WorkflowsEntityDescriptorEnum.EventHandlers);
	}

	public void EventHandlers_(int initialCapacity) {
		wEntity_(WorkflowsEntityDescriptorEnum.EventHandlers, initialCapacity);
	}

	public void _EventHandlers() {
		_wEntity(WorkflowsEntityDescriptorEnum.EventHandlers);
	}

	public void EventHandler() {
		wEntity(WorkflowsEntityDescriptorEnum.EventHandler);
	}

	public void EventHandler_() {
		wEntity_(WorkflowsEntityDescriptorEnum.EventHandler);
	}

	public void _EventHandler() {
		_wEntity(WorkflowsEntityDescriptorEnum.EventHandler);
	}

	public void Sequence() {
		wEntity(WorkflowsEntityDescriptorEnum.Sequence);
	}

	public void Sequence_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Sequence);
	}

	public void _Sequence() {
		_wEntity(WorkflowsEntityDescriptorEnum.Sequence);
	}

	public void Parallel() {
		wEntity(WorkflowsEntityDescriptorEnum.Parallel);
	}

	public void Parallel_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Parallel);
	}

	public void _Parallel() {
		_wEntity(WorkflowsEntityDescriptorEnum.Parallel);
	}

	public void FlowObjects() {
		wEntity(WorkflowsEntityDescriptorEnum.FlowObjects);
	}

	public void FlowObjects_() {
		wEntity_(WorkflowsEntityDescriptorEnum.FlowObjects);
	}

	public void FlowObjects_(int initialCapacity) {
		wEntity_(WorkflowsEntityDescriptorEnum.FlowObjects, initialCapacity);
	}

	public void _FlowObjects() {
		_wEntity(WorkflowsEntityDescriptorEnum.FlowObjects);
	}

	public void ForeachLoop() {
		wEntity(WorkflowsEntityDescriptorEnum.ForeachLoop);
	}

	public void ForeachLoop_() {
		wEntity_(WorkflowsEntityDescriptorEnum.ForeachLoop);
	}

	public void _ForeachLoop() {
		_wEntity(WorkflowsEntityDescriptorEnum.ForeachLoop);
	}

	public void WhileLoop() {
		wEntity(WorkflowsEntityDescriptorEnum.WhileLoop);
	}

	public void WhileLoop_() {
		wEntity_(WorkflowsEntityDescriptorEnum.WhileLoop);
	}

	public void _WhileLoop() {
		_wEntity(WorkflowsEntityDescriptorEnum.WhileLoop);
	}

	public void TestTime() {
		wEntity(WorkflowsEntityDescriptorEnum.TestTime);
	}

	public void TestTime(TestTimeEnum.Value value) {
		wEntity(WorkflowsEntityDescriptorEnum.TestTime, value);
	}

	public void TestTime(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.TestTime, value);
	}

	public void PickControl() {
		wEntity(WorkflowsEntityDescriptorEnum.PickControl);
	}

	public void PickControl_() {
		wEntity_(WorkflowsEntityDescriptorEnum.PickControl);
	}

	public void _PickControl() {
		_wEntity(WorkflowsEntityDescriptorEnum.PickControl);
	}

	public void SwitchControl() {
		wEntity(WorkflowsEntityDescriptorEnum.SwitchControl);
	}

	public void SwitchControl_() {
		wEntity_(WorkflowsEntityDescriptorEnum.SwitchControl);
	}

	public void _SwitchControl() {
		_wEntity(WorkflowsEntityDescriptorEnum.SwitchControl);
	}

	public void SwitchType() {
		wEntity(WorkflowsEntityDescriptorEnum.SwitchType);
	}

	public void SwitchType(SwitchTypeEnum.Value value) {
		wEntity(WorkflowsEntityDescriptorEnum.SwitchType, value);
	}

	public void SwitchType(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.SwitchType, value);
	}

	public void ConditionalCases() {
		wEntity(WorkflowsEntityDescriptorEnum.ConditionalCases);
	}

	public void ConditionalCases_() {
		wEntity_(WorkflowsEntityDescriptorEnum.ConditionalCases);
	}

	public void ConditionalCases_(int initialCapacity) {
		wEntity_(WorkflowsEntityDescriptorEnum.ConditionalCases,
				initialCapacity);
	}

	public void _ConditionalCases() {
		_wEntity(WorkflowsEntityDescriptorEnum.ConditionalCases);
	}

	public void ConditionalCase() {
		wEntity(WorkflowsEntityDescriptorEnum.ConditionalCase);
	}

	public void ConditionalCase_() {
		wEntity_(WorkflowsEntityDescriptorEnum.ConditionalCase);
	}

	public void _ConditionalCase() {
		_wEntity(WorkflowsEntityDescriptorEnum.ConditionalCase);
	}

	public void DefaultCase() {
		wEntity(WorkflowsEntityDescriptorEnum.DefaultCase);
	}

	public void DefaultCase_() {
		wEntity_(WorkflowsEntityDescriptorEnum.DefaultCase);
	}

	public void _DefaultCase() {
		_wEntity(WorkflowsEntityDescriptorEnum.DefaultCase);
	}

	public void OnCallEvent() {
		wEntity(WorkflowsEntityDescriptorEnum.OnCallEvent);
	}

	public void OnCallEvent_() {
		wEntity_(WorkflowsEntityDescriptorEnum.OnCallEvent);
	}

	public void _OnCallEvent() {
		_wEntity(WorkflowsEntityDescriptorEnum.OnCallEvent);
	}

	public void OnMessageEvent() {
		wEntity(WorkflowsEntityDescriptorEnum.OnMessageEvent);
	}

	public void OnMessageEvent_() {
		wEntity_(WorkflowsEntityDescriptorEnum.OnMessageEvent);
	}

	public void _OnMessageEvent() {
		_wEntity(WorkflowsEntityDescriptorEnum.OnMessageEvent);
	}

	public void OnTimerEvent() {
		wEntity(WorkflowsEntityDescriptorEnum.OnTimerEvent);
	}

	public void OnTimerEvent_() {
		wEntity_(WorkflowsEntityDescriptorEnum.OnTimerEvent);
	}

	public void _OnTimerEvent() {
		_wEntity(WorkflowsEntityDescriptorEnum.OnTimerEvent);
	}

	public void FaultEvent() {
		wEntity(WorkflowsEntityDescriptorEnum.FaultEvent);
	}

	public void FaultEvent_() {
		wEntity_(WorkflowsEntityDescriptorEnum.FaultEvent);
	}

	public void _FaultEvent() {
		_wEntity(WorkflowsEntityDescriptorEnum.FaultEvent);
	}

	public void ReturnEvent() {
		wEntity(WorkflowsEntityDescriptorEnum.ReturnEvent);
	}

	public void ReturnEvent_() {
		wEntity_(WorkflowsEntityDescriptorEnum.ReturnEvent);
	}

	public void _ReturnEvent() {
		_wEntity(WorkflowsEntityDescriptorEnum.ReturnEvent);
	}

	public void Task() {
		wEntity(WorkflowsEntityDescriptorEnum.Task);
	}

	public void Task_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Task);
	}

	public void _Task() {
		_wEntity(WorkflowsEntityDescriptorEnum.Task);
	}

	public void Breakpoint() {
		wEntity(WorkflowsEntityDescriptorEnum.Breakpoint);
	}

	public void Breakpoint_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Breakpoint);
	}

	public void _Breakpoint() {
		_wEntity(WorkflowsEntityDescriptorEnum.Breakpoint);
	}

	public void ConditionTest() {
		wEntity(WorkflowsEntityDescriptorEnum.ConditionTest);
	}

	public void ConditionTest(ConditionTestEnum.Value value) {
		wEntity(WorkflowsEntityDescriptorEnum.ConditionTest, value);
	}

	public void ConditionTest(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.ConditionTest, value);
	}

	public void Variables() {
		wEntity(WorkflowsEntityDescriptorEnum.Variables);
	}

	public void Variables_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Variables);
	}

	public void Variables_(int initialCapacity) {
		wEntity_(WorkflowsEntityDescriptorEnum.Variables, initialCapacity);
	}

	public void _Variables() {
		_wEntity(WorkflowsEntityDescriptorEnum.Variables);
	}

	public void EmptyActivity() {
		wEntity(WorkflowsEntityDescriptorEnum.EmptyActivity);
	}

	public void EmptyActivity_() {
		wEntity_(WorkflowsEntityDescriptorEnum.EmptyActivity);
	}

	public void _EmptyActivity() {
		_wEntity(WorkflowsEntityDescriptorEnum.EmptyActivity);
	}

	public void AssignActivity() {
		wEntity(WorkflowsEntityDescriptorEnum.AssignActivity);
	}

	public void AssignActivity_() {
		wEntity_(WorkflowsEntityDescriptorEnum.AssignActivity);
	}

	public void _AssignActivity() {
		_wEntity(WorkflowsEntityDescriptorEnum.AssignActivity);
	}

	public void CreateEntity() {
		wEntity(WorkflowsEntityDescriptorEnum.CreateEntity);
	}

	public void CreateEntity_() {
		wEntity_(WorkflowsEntityDescriptorEnum.CreateEntity);
	}

	public void _CreateEntity() {
		_wEntity(WorkflowsEntityDescriptorEnum.CreateEntity);
	}

	public void CreateModel() {
		wEntity(WorkflowsEntityDescriptorEnum.CreateModel);
	}

	public void CreateModel_() {
		wEntity_(WorkflowsEntityDescriptorEnum.CreateModel);
	}

	public void _CreateModel() {
		_wEntity(WorkflowsEntityDescriptorEnum.CreateModel);
	}

	public void LoadJavaModel() {
		wEntity(WorkflowsEntityDescriptorEnum.LoadJavaModel);
	}

	public void LoadJavaModel_() {
		wEntity_(WorkflowsEntityDescriptorEnum.LoadJavaModel);
	}

	public void _LoadJavaModel() {
		_wEntity(WorkflowsEntityDescriptorEnum.LoadJavaModel);
	}

	public void ResourceKind() {
		wEntity(WorkflowsEntityDescriptorEnum.ResourceKind);
	}

	public void ResourceKind(ResourceKindEnum.Value value) {
		wEntity(WorkflowsEntityDescriptorEnum.ResourceKind, value);
	}

	public void ResourceKind(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.ResourceKind, value);
	}

	public void LoadModel() {
		wEntity(WorkflowsEntityDescriptorEnum.LoadModel);
	}

	public void LoadModel_() {
		wEntity_(WorkflowsEntityDescriptorEnum.LoadModel);
	}

	public void _LoadModel() {
		_wEntity(WorkflowsEntityDescriptorEnum.LoadModel);
	}

	public void SaveModel() {
		wEntity(WorkflowsEntityDescriptorEnum.SaveModel);
	}

	public void SaveModel_() {
		wEntity_(WorkflowsEntityDescriptorEnum.SaveModel);
	}

	public void _SaveModel() {
		_wEntity(WorkflowsEntityDescriptorEnum.SaveModel);
	}

	public void DeleteArtifacts() {
		wEntity(WorkflowsEntityDescriptorEnum.DeleteArtifacts);
	}

	public void DeleteArtifacts_() {
		wEntity_(WorkflowsEntityDescriptorEnum.DeleteArtifacts);
	}

	public void _DeleteArtifacts() {
		_wEntity(WorkflowsEntityDescriptorEnum.DeleteArtifacts);
	}

	public void ArtifactsTraversalStrategy() {
		wEntity(WorkflowsEntityDescriptorEnum.ArtifactsTraversalStrategy);
	}

	public void ArtifactsTraversalStrategy(
			ArtifactsTraversalStrategyEnum.Value value) {
		wEntity(WorkflowsEntityDescriptorEnum.ArtifactsTraversalStrategy, value);
	}

	public void ArtifactsTraversalStrategy(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.ArtifactsTraversalStrategy, value);
	}

	public void ArtifactsSynchronizeStrategy() {
		wEntity(WorkflowsEntityDescriptorEnum.ArtifactsSynchronizeStrategy);
	}

	public void ArtifactsSynchronizeStrategy(
			ArtifactsSynchronizeStrategyEnum.Value value) {
		wEntity(WorkflowsEntityDescriptorEnum.ArtifactsSynchronizeStrategy,
				value);
	}

	public void ArtifactsSynchronizeStrategy(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.ArtifactsSynchronizeStrategy,
				value);
	}

	public void LoadArtifacts() {
		wEntity(WorkflowsEntityDescriptorEnum.LoadArtifacts);
	}

	public void LoadArtifacts_() {
		wEntity_(WorkflowsEntityDescriptorEnum.LoadArtifacts);
	}

	public void _LoadArtifacts() {
		_wEntity(WorkflowsEntityDescriptorEnum.LoadArtifacts);
	}

	public void SaveArtifacts() {
		wEntity(WorkflowsEntityDescriptorEnum.SaveArtifacts);
	}

	public void SaveArtifacts_() {
		wEntity_(WorkflowsEntityDescriptorEnum.SaveArtifacts);
	}

	public void _SaveArtifacts() {
		_wEntity(WorkflowsEntityDescriptorEnum.SaveArtifacts);
	}

	public void Parse() {
		wEntity(WorkflowsEntityDescriptorEnum.Parse);
	}

	public void Parse_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Parse);
	}

	public void _Parse() {
		_wEntity(WorkflowsEntityDescriptorEnum.Parse);
	}

	public void Unparse() {
		wEntity(WorkflowsEntityDescriptorEnum.Unparse);
	}

	public void Unparse_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Unparse);
	}

	public void _Unparse() {
		_wEntity(WorkflowsEntityDescriptorEnum.Unparse);
	}

	public void InvokeOperation() {
		wEntity(WorkflowsEntityDescriptorEnum.InvokeOperation);
	}

	public void InvokeOperation_() {
		wEntity_(WorkflowsEntityDescriptorEnum.InvokeOperation);
	}

	public void _InvokeOperation() {
		_wEntity(WorkflowsEntityDescriptorEnum.InvokeOperation);
	}

	public void Operation() {
		wEntity(WorkflowsEntityDescriptorEnum.Operation);
	}

	public void Operation(OperationEnum.Value value) {
		wEntity(WorkflowsEntityDescriptorEnum.Operation, value);
	}

	public void Operation(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.Operation, value);
	}

	public void InvokeQuery() {
		wEntity(WorkflowsEntityDescriptorEnum.InvokeQuery);
	}

	public void InvokeQuery_() {
		wEntity_(WorkflowsEntityDescriptorEnum.InvokeQuery);
	}

	public void _InvokeQuery() {
		_wEntity(WorkflowsEntityDescriptorEnum.InvokeQuery);
	}

	public void InvokeJavaInstanceMethod() {
		wEntity(WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod);
	}

	public void InvokeJavaInstanceMethod_() {
		wEntity_(WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod);
	}

	public void _InvokeJavaInstanceMethod() {
		_wEntity(WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod);
	}

	public void InvokeJavaClassMethod() {
		wEntity(WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod);
	}

	public void InvokeJavaClassMethod_() {
		wEntity_(WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod);
	}

	public void _InvokeJavaClassMethod() {
		_wEntity(WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod);
	}

	public void CreateJavaClassInstance() {
		wEntity(WorkflowsEntityDescriptorEnum.CreateJavaClassInstance);
	}

	public void CreateJavaClassInstance_() {
		wEntity_(WorkflowsEntityDescriptorEnum.CreateJavaClassInstance);
	}

	public void _CreateJavaClassInstance() {
		_wEntity(WorkflowsEntityDescriptorEnum.CreateJavaClassInstance);
	}

	public void Registry() {
		wEntity(WorkflowsEntityDescriptorEnum.Registry);
	}

	public void Registry(RegistryEnum.Value value) {
		wEntity(WorkflowsEntityDescriptorEnum.Registry, value);
	}

	public void Registry(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.Registry, value);
	}

	public void BooleanLiteral() {
		wEntity(WorkflowsEntityDescriptorEnum.BooleanLiteral);
	}

	public void BooleanLiteral(boolean value) {
		wEntity(WorkflowsEntityDescriptorEnum.BooleanLiteral, value);
	}

	public void IntLiteral() {
		wEntity(WorkflowsEntityDescriptorEnum.IntLiteral);
	}

	public void IntLiteral(int value) {
		wEntity(WorkflowsEntityDescriptorEnum.IntLiteral, value);
	}

	public void StringLiteral() {
		wEntity(WorkflowsEntityDescriptorEnum.StringLiteral);
	}

	public void StringLiteral(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.StringLiteral, value);
	}

	public void ObjectLiteral() {
		wEntity(WorkflowsEntityDescriptorEnum.ObjectLiteral);
	}

	public void ObjectLiteral(Object value) {
		wEntity(WorkflowsEntityDescriptorEnum.ObjectLiteral, value);
	}

	public void ObjectLiteral(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.ObjectLiteral, value);
	}

	public void Variable() {
		wEntity(WorkflowsEntityDescriptorEnum.Variable);
	}

	public void Variable(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.Variable, value);
	}

	public void Name() {
		wEntity(WorkflowsEntityDescriptorEnum.Name);
	}

	public void Name(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.Name, value);
	}

	public void Text() {
		wEntity(WorkflowsEntityDescriptorEnum.Text);
	}

	public void Text(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.Text, value);
	}

	public void Declarations() {
		wEntity(WorkflowsEntityDescriptorEnum.Declarations);
	}

	public void Declarations_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Declarations);
	}

	public void Declarations_(int initialCapacity) {
		wEntity_(WorkflowsEntityDescriptorEnum.Declarations, initialCapacity);
	}

	public void _Declarations() {
		_wEntity(WorkflowsEntityDescriptorEnum.Declarations);
	}

	public void Assignments() {
		wEntity(WorkflowsEntityDescriptorEnum.Assignments);
	}

	public void Assignments_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Assignments);
	}

	public void Assignments_(int initialCapacity) {
		wEntity_(WorkflowsEntityDescriptorEnum.Assignments, initialCapacity);
	}

	public void _Assignments() {
		_wEntity(WorkflowsEntityDescriptorEnum.Assignments);
	}

	public void Assign() {
		wEntity(WorkflowsEntityDescriptorEnum.Assign);
	}

	public void Assign_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Assign);
	}

	public void _Assign() {
		_wEntity(WorkflowsEntityDescriptorEnum.Assign);
	}

	public void Expressions() {
		wEntity(WorkflowsEntityDescriptorEnum.Expressions);
	}

	public void Expressions_() {
		wEntity_(WorkflowsEntityDescriptorEnum.Expressions);
	}

	public void Expressions_(int initialCapacity) {
		wEntity_(WorkflowsEntityDescriptorEnum.Expressions, initialCapacity);
	}

	public void _Expressions() {
		_wEntity(WorkflowsEntityDescriptorEnum.Expressions);
	}

	public void Signature() {
		wEntity(WorkflowsEntityDescriptorEnum.Signature);
	}

	public void Signature(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.Signature, value);
	}

	public void ClassPath() {
		wEntity(WorkflowsEntityDescriptorEnum.ClassPath);
	}

	public void ClassPath_() {
		wEntity_(WorkflowsEntityDescriptorEnum.ClassPath);
	}

	public void _ClassPath() {
		_wEntity(WorkflowsEntityDescriptorEnum.ClassPath);
	}

	public void CurrentJavaProject() {
		wEntity(WorkflowsEntityDescriptorEnum.CurrentJavaProject);
	}

	public void CurrentJavaProject_() {
		wEntity_(WorkflowsEntityDescriptorEnum.CurrentJavaProject);
	}

	public void _CurrentJavaProject() {
		_wEntity(WorkflowsEntityDescriptorEnum.CurrentJavaProject);
	}

	public void JavaProject() {
		wEntity(WorkflowsEntityDescriptorEnum.JavaProject);
	}

	public void JavaProject(String value) {
		wEntity(WorkflowsEntityDescriptorEnum.JavaProject, value);
	}
}
