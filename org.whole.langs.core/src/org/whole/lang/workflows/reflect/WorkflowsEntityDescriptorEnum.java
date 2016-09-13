package org.whole.lang.workflows.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class WorkflowsEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int Workflow_ord = 0;
	public static final int FlowObject_ord = 1;
	public static final int Scope_ord = 2;
	public static final int FaultHandlers_ord = 3;
	public static final int FaultHandler_ord = 4;
	public static final int EventHandlers_ord = 5;
	public static final int EventHandler_ord = 6;
	public static final int Sequence_ord = 7;
	public static final int Parallel_ord = 8;
	public static final int FlowObjects_ord = 9;
	public static final int ForeachLoop_ord = 10;
	public static final int WhileLoop_ord = 11;
	public static final int TestTime_ord = 12;
	public static final int PickControl_ord = 13;
	public static final int SwitchControl_ord = 14;
	public static final int SwitchType_ord = 15;
	public static final int ConditionalCases_ord = 16;
	public static final int ConditionalCase_ord = 17;
	public static final int DefaultCase_ord = 18;
	public static final int StartEvent_ord = 19;
	public static final int FlowEvent_ord = 20;
	public static final int OnCallEvent_ord = 21;
	public static final int OnMessageEvent_ord = 22;
	public static final int OnTimerEvent_ord = 23;
	public static final int FaultEvent_ord = 24;
	public static final int ReturnEvent_ord = 25;
	public static final int Task_ord = 26;
	public static final int Breakpoint_ord = 27;
	public static final int ConditionTest_ord = 28;
	public static final int Variables_ord = 29;
	public static final int Activity_ord = 30;
	public static final int EmptyActivity_ord = 31;
	public static final int AssignActivity_ord = 32;
	public static final int CreateEntity_ord = 33;
	public static final int CreateModel_ord = 34;
	public static final int LoadJavaModel_ord = 35;
	public static final int PersistenceActivity_ord = 36;
	public static final int ResourceKind_ord = 37;
	public static final int LoadModel_ord = 38;
	public static final int SaveModel_ord = 39;
	public static final int ArtifactsActivity_ord = 40;
	public static final int DeleteArtifacts_ord = 41;
	public static final int SynchronizeArtifactsActivity_ord = 42;
	public static final int ArtifactsTraversalStrategy_ord = 43;
	public static final int ArtifactsSynchronizeStrategy_ord = 44;
	public static final int LoadArtifacts_ord = 45;
	public static final int SaveArtifacts_ord = 46;
	public static final int GrammarActivity_ord = 47;
	public static final int Parse_ord = 48;
	public static final int Unparse_ord = 49;
	public static final int InvokeOperation_ord = 50;
	public static final int Operation_ord = 51;
	public static final int InvokeQuery_ord = 52;
	public static final int InvokeJavaInstanceMethod_ord = 53;
	public static final int InvokeJavaClassMethod_ord = 54;
	public static final int CreateJavaClassInstance_ord = 55;
	public static final int Registry_ord = 56;
	public static final int Expression_ord = 57;
	public static final int Literal_ord = 58;
	public static final int BooleanLiteral_ord = 59;
	public static final int IntLiteral_ord = 60;
	public static final int StringLiteral_ord = 61;
	public static final int ObjectLiteral_ord = 62;
	public static final int Variable_ord = 63;
	public static final int Name_ord = 64;
	public static final int Label_ord = 65;
	public static final int Description_ord = 66;
	public static final int Text_ord = 67;
	public static final int Declarations_ord = 68;
	public static final int Arguments_ord = 69;
	public static final int Assignments_ord = 70;
	public static final int Assign_ord = 71;
	public static final int Expressions_ord = 72;
	public static final int Signature_ord = 73;
	public static final int Declaration_ord = 74;
	public static final int ClassProvider_ord = 75;
	public static final int ClassPath_ord = 76;
	public static final int CurrentJavaProject_ord = 77;
	public static final int JavaProject_ord = 78;
	public static final int Condition_ord = 79;
	public static final int Parameters_ord = 80;
	public static final int Result_ord = 81;
	public static final int Message_ord = 82;
	public static final int Event_ord = 83;
	public static final int Timer_ord = 84;
	public static final int Fault_ord = 85;
	public static final WorkflowsEntityDescriptorEnum instance = new WorkflowsEntityDescriptorEnum();
	public static final EntityDescriptor<Workflow> Workflow = (EntityDescriptor<Workflow>) instance
			.valueOf(Workflow_ord);
	public static final EntityDescriptor<FlowObject> FlowObject = (EntityDescriptor<FlowObject>) instance
			.valueOf(FlowObject_ord);
	public static final EntityDescriptor<Scope> Scope = (EntityDescriptor<Scope>) instance
			.valueOf(Scope_ord);
	public static final EntityDescriptor<FaultHandlers> FaultHandlers = (EntityDescriptor<FaultHandlers>) instance
			.valueOf(FaultHandlers_ord);
	public static final EntityDescriptor<FaultHandler> FaultHandler = (EntityDescriptor<FaultHandler>) instance
			.valueOf(FaultHandler_ord);
	public static final EntityDescriptor<EventHandlers> EventHandlers = (EntityDescriptor<EventHandlers>) instance
			.valueOf(EventHandlers_ord);
	public static final EntityDescriptor<EventHandler> EventHandler = (EntityDescriptor<EventHandler>) instance
			.valueOf(EventHandler_ord);
	public static final EntityDescriptor<Sequence> Sequence = (EntityDescriptor<Sequence>) instance
			.valueOf(Sequence_ord);
	public static final EntityDescriptor<Parallel> Parallel = (EntityDescriptor<Parallel>) instance
			.valueOf(Parallel_ord);
	public static final EntityDescriptor<FlowObjects> FlowObjects = (EntityDescriptor<FlowObjects>) instance
			.valueOf(FlowObjects_ord);
	public static final EntityDescriptor<ForeachLoop> ForeachLoop = (EntityDescriptor<ForeachLoop>) instance
			.valueOf(ForeachLoop_ord);
	public static final EntityDescriptor<WhileLoop> WhileLoop = (EntityDescriptor<WhileLoop>) instance
			.valueOf(WhileLoop_ord);
	public static final EntityDescriptor<TestTime> TestTime = (EntityDescriptor<TestTime>) instance
			.valueOf(TestTime_ord);
	public static final EntityDescriptor<PickControl> PickControl = (EntityDescriptor<PickControl>) instance
			.valueOf(PickControl_ord);
	public static final EntityDescriptor<SwitchControl> SwitchControl = (EntityDescriptor<SwitchControl>) instance
			.valueOf(SwitchControl_ord);
	public static final EntityDescriptor<SwitchType> SwitchType = (EntityDescriptor<SwitchType>) instance
			.valueOf(SwitchType_ord);
	public static final EntityDescriptor<ConditionalCases> ConditionalCases = (EntityDescriptor<ConditionalCases>) instance
			.valueOf(ConditionalCases_ord);
	public static final EntityDescriptor<ConditionalCase> ConditionalCase = (EntityDescriptor<ConditionalCase>) instance
			.valueOf(ConditionalCase_ord);
	public static final EntityDescriptor<DefaultCase> DefaultCase = (EntityDescriptor<DefaultCase>) instance
			.valueOf(DefaultCase_ord);
	public static final EntityDescriptor<StartEvent> StartEvent = (EntityDescriptor<StartEvent>) instance
			.valueOf(StartEvent_ord);
	public static final EntityDescriptor<FlowEvent> FlowEvent = (EntityDescriptor<FlowEvent>) instance
			.valueOf(FlowEvent_ord);
	public static final EntityDescriptor<OnCallEvent> OnCallEvent = (EntityDescriptor<OnCallEvent>) instance
			.valueOf(OnCallEvent_ord);
	public static final EntityDescriptor<OnMessageEvent> OnMessageEvent = (EntityDescriptor<OnMessageEvent>) instance
			.valueOf(OnMessageEvent_ord);
	public static final EntityDescriptor<OnTimerEvent> OnTimerEvent = (EntityDescriptor<OnTimerEvent>) instance
			.valueOf(OnTimerEvent_ord);
	public static final EntityDescriptor<FaultEvent> FaultEvent = (EntityDescriptor<FaultEvent>) instance
			.valueOf(FaultEvent_ord);
	public static final EntityDescriptor<ReturnEvent> ReturnEvent = (EntityDescriptor<ReturnEvent>) instance
			.valueOf(ReturnEvent_ord);
	public static final EntityDescriptor<Task> Task = (EntityDescriptor<Task>) instance
			.valueOf(Task_ord);
	public static final EntityDescriptor<Breakpoint> Breakpoint = (EntityDescriptor<Breakpoint>) instance
			.valueOf(Breakpoint_ord);
	public static final EntityDescriptor<ConditionTest> ConditionTest = (EntityDescriptor<ConditionTest>) instance
			.valueOf(ConditionTest_ord);
	public static final EntityDescriptor<Variables> Variables = (EntityDescriptor<Variables>) instance
			.valueOf(Variables_ord);
	public static final EntityDescriptor<Activity> Activity = (EntityDescriptor<Activity>) instance
			.valueOf(Activity_ord);
	public static final EntityDescriptor<EmptyActivity> EmptyActivity = (EntityDescriptor<EmptyActivity>) instance
			.valueOf(EmptyActivity_ord);
	public static final EntityDescriptor<AssignActivity> AssignActivity = (EntityDescriptor<AssignActivity>) instance
			.valueOf(AssignActivity_ord);
	public static final EntityDescriptor<CreateEntity> CreateEntity = (EntityDescriptor<CreateEntity>) instance
			.valueOf(CreateEntity_ord);
	public static final EntityDescriptor<CreateModel> CreateModel = (EntityDescriptor<CreateModel>) instance
			.valueOf(CreateModel_ord);
	public static final EntityDescriptor<LoadJavaModel> LoadJavaModel = (EntityDescriptor<LoadJavaModel>) instance
			.valueOf(LoadJavaModel_ord);
	public static final EntityDescriptor<PersistenceActivity> PersistenceActivity = (EntityDescriptor<PersistenceActivity>) instance
			.valueOf(PersistenceActivity_ord);
	public static final EntityDescriptor<ResourceKind> ResourceKind = (EntityDescriptor<ResourceKind>) instance
			.valueOf(ResourceKind_ord);
	public static final EntityDescriptor<LoadModel> LoadModel = (EntityDescriptor<LoadModel>) instance
			.valueOf(LoadModel_ord);
	public static final EntityDescriptor<SaveModel> SaveModel = (EntityDescriptor<SaveModel>) instance
			.valueOf(SaveModel_ord);
	public static final EntityDescriptor<ArtifactsActivity> ArtifactsActivity = (EntityDescriptor<ArtifactsActivity>) instance
			.valueOf(ArtifactsActivity_ord);
	public static final EntityDescriptor<DeleteArtifacts> DeleteArtifacts = (EntityDescriptor<DeleteArtifacts>) instance
			.valueOf(DeleteArtifacts_ord);
	public static final EntityDescriptor<SynchronizeArtifactsActivity> SynchronizeArtifactsActivity = (EntityDescriptor<SynchronizeArtifactsActivity>) instance
			.valueOf(SynchronizeArtifactsActivity_ord);
	public static final EntityDescriptor<ArtifactsTraversalStrategy> ArtifactsTraversalStrategy = (EntityDescriptor<ArtifactsTraversalStrategy>) instance
			.valueOf(ArtifactsTraversalStrategy_ord);
	public static final EntityDescriptor<ArtifactsSynchronizeStrategy> ArtifactsSynchronizeStrategy = (EntityDescriptor<ArtifactsSynchronizeStrategy>) instance
			.valueOf(ArtifactsSynchronizeStrategy_ord);
	public static final EntityDescriptor<LoadArtifacts> LoadArtifacts = (EntityDescriptor<LoadArtifacts>) instance
			.valueOf(LoadArtifacts_ord);
	public static final EntityDescriptor<SaveArtifacts> SaveArtifacts = (EntityDescriptor<SaveArtifacts>) instance
			.valueOf(SaveArtifacts_ord);
	public static final EntityDescriptor<GrammarActivity> GrammarActivity = (EntityDescriptor<GrammarActivity>) instance
			.valueOf(GrammarActivity_ord);
	public static final EntityDescriptor<Parse> Parse = (EntityDescriptor<Parse>) instance
			.valueOf(Parse_ord);
	public static final EntityDescriptor<Unparse> Unparse = (EntityDescriptor<Unparse>) instance
			.valueOf(Unparse_ord);
	public static final EntityDescriptor<InvokeOperation> InvokeOperation = (EntityDescriptor<InvokeOperation>) instance
			.valueOf(InvokeOperation_ord);
	public static final EntityDescriptor<Operation> Operation = (EntityDescriptor<Operation>) instance
			.valueOf(Operation_ord);
	public static final EntityDescriptor<InvokeQuery> InvokeQuery = (EntityDescriptor<InvokeQuery>) instance
			.valueOf(InvokeQuery_ord);
	public static final EntityDescriptor<InvokeJavaInstanceMethod> InvokeJavaInstanceMethod = (EntityDescriptor<InvokeJavaInstanceMethod>) instance
			.valueOf(InvokeJavaInstanceMethod_ord);
	public static final EntityDescriptor<InvokeJavaClassMethod> InvokeJavaClassMethod = (EntityDescriptor<InvokeJavaClassMethod>) instance
			.valueOf(InvokeJavaClassMethod_ord);
	public static final EntityDescriptor<CreateJavaClassInstance> CreateJavaClassInstance = (EntityDescriptor<CreateJavaClassInstance>) instance
			.valueOf(CreateJavaClassInstance_ord);
	public static final EntityDescriptor<Registry> Registry = (EntityDescriptor<Registry>) instance
			.valueOf(Registry_ord);
	public static final EntityDescriptor<Expression> Expression = (EntityDescriptor<Expression>) instance
			.valueOf(Expression_ord);
	public static final EntityDescriptor<Literal> Literal = (EntityDescriptor<Literal>) instance
			.valueOf(Literal_ord);
	public static final EntityDescriptor<BooleanLiteral> BooleanLiteral = (EntityDescriptor<BooleanLiteral>) instance
			.valueOf(BooleanLiteral_ord);
	public static final EntityDescriptor<IntLiteral> IntLiteral = (EntityDescriptor<IntLiteral>) instance
			.valueOf(IntLiteral_ord);
	public static final EntityDescriptor<StringLiteral> StringLiteral = (EntityDescriptor<StringLiteral>) instance
			.valueOf(StringLiteral_ord);
	public static final EntityDescriptor<ObjectLiteral> ObjectLiteral = (EntityDescriptor<ObjectLiteral>) instance
			.valueOf(ObjectLiteral_ord);
	public static final EntityDescriptor<Variable> Variable = (EntityDescriptor<Variable>) instance
			.valueOf(Variable_ord);
	public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance
			.valueOf(Name_ord);
	public static final EntityDescriptor<Label> Label = (EntityDescriptor<Label>) instance
			.valueOf(Label_ord);
	public static final EntityDescriptor<Description> Description = (EntityDescriptor<Description>) instance
			.valueOf(Description_ord);
	public static final EntityDescriptor<Text> Text = (EntityDescriptor<Text>) instance
			.valueOf(Text_ord);
	public static final EntityDescriptor<Declarations> Declarations = (EntityDescriptor<Declarations>) instance
			.valueOf(Declarations_ord);
	public static final EntityDescriptor<Arguments> Arguments = (EntityDescriptor<Arguments>) instance
			.valueOf(Arguments_ord);
	public static final EntityDescriptor<Assignments> Assignments = (EntityDescriptor<Assignments>) instance
			.valueOf(Assignments_ord);
	public static final EntityDescriptor<Assign> Assign = (EntityDescriptor<Assign>) instance
			.valueOf(Assign_ord);
	public static final EntityDescriptor<Expressions> Expressions = (EntityDescriptor<Expressions>) instance
			.valueOf(Expressions_ord);
	public static final EntityDescriptor<Signature> Signature = (EntityDescriptor<Signature>) instance
			.valueOf(Signature_ord);
	public static final EntityDescriptor<Declaration> Declaration = (EntityDescriptor<Declaration>) instance
			.valueOf(Declaration_ord);
	public static final EntityDescriptor<ClassProvider> ClassProvider = (EntityDescriptor<ClassProvider>) instance
			.valueOf(ClassProvider_ord);
	public static final EntityDescriptor<ClassPath> ClassPath = (EntityDescriptor<ClassPath>) instance
			.valueOf(ClassPath_ord);
	public static final EntityDescriptor<CurrentJavaProject> CurrentJavaProject = (EntityDescriptor<CurrentJavaProject>) instance
			.valueOf(CurrentJavaProject_ord);
	public static final EntityDescriptor<JavaProject> JavaProject = (EntityDescriptor<JavaProject>) instance
			.valueOf(JavaProject_ord);
	public static final EntityDescriptor<Condition> Condition = (EntityDescriptor<Condition>) instance
			.valueOf(Condition_ord);
	public static final EntityDescriptor<Parameters> Parameters = (EntityDescriptor<Parameters>) instance
			.valueOf(Parameters_ord);
	public static final EntityDescriptor<Result> Result = (EntityDescriptor<Result>) instance
			.valueOf(Result_ord);
	public static final EntityDescriptor<Message> Message = (EntityDescriptor<Message>) instance
			.valueOf(Message_ord);
	public static final EntityDescriptor<Event> Event = (EntityDescriptor<Event>) instance
			.valueOf(Event_ord);
	public static final EntityDescriptor<Timer> Timer = (EntityDescriptor<Timer>) instance
			.valueOf(Timer_ord);
	public static final EntityDescriptor<Fault> Fault = (EntityDescriptor<Fault>) instance
			.valueOf(Fault_ord);

	private WorkflowsEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(Workflow_ord, "Workflow", Workflow.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.name, Name_ord,
						false, true, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.description,
						Description_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.declarations,
						Declarations_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.startEvent,
						StartEvent_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.flowObject,
						FlowObject_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.endEvent,
						FlowEvent_ord);
		putSimpleEntity(FlowObject_ord, "FlowObject", FlowObject.class, true,
				SaveArtifacts_ord, CreateModel_ord, ReturnEvent_ord,
				InvokeJavaClassMethod_ord, CreateJavaClassInstance_ord,
				LoadArtifacts_ord, SwitchControl_ord, Breakpoint_ord,
				InvokeOperation_ord, InvokeQuery_ord,
				InvokeJavaInstanceMethod_ord, FaultEvent_ord,
				EmptyActivity_ord, SaveModel_ord, PersistenceActivity_ord,
				Sequence_ord, ArtifactsActivity_ord, Scope_ord, WhileLoop_ord,
				FlowEvent_ord, DeleteArtifacts_ord, LoadModel_ord,
				CreateEntity_ord, SynchronizeArtifactsActivity_ord,
				Parallel_ord, ForeachLoop_ord, AssignActivity_ord,
				GrammarActivity_ord, Activity_ord, Task_ord, Parse_ord,
				Unparse_ord, PickControl_ord, LoadJavaModel_ord).withFeature(
				WorkflowsFeatureDescriptorEnum.label, Label_ord, true, false,
				false, false, false);
		putSimpleEntity(Scope_ord, "Scope", Scope.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.declarations,
						Declarations_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.flowObject,
						FlowObject_ord)
				.withFeature(
						WorkflowsFeatureDescriptorEnum.compensationHandler,
						FlowObject_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.eventHandlers,
						EventHandlers_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.faultHandlers,
						FaultHandlers_ord, true, false, false, false, false);
		putCompositeEntity(
		FaultHandlers_ord, "FaultHandlers", FaultHandlers.class, false, FaultHandler_ord, true, true);
		putSimpleEntity(FaultHandler_ord, "FaultHandler", FaultHandler.class,
				false)
				.withFeature(WorkflowsFeatureDescriptorEnum.name, Name_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.faultName,
						Fault_ord, false, true, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.faultVariable,
						Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.flowObject,
						FlowObject_ord);
		putCompositeEntity(
		EventHandlers_ord, "EventHandlers", EventHandlers.class, false, EventHandler_ord, true, false);
		putSimpleEntity(EventHandler_ord, "EventHandler", EventHandler.class,
				false)
				.withFeature(WorkflowsFeatureDescriptorEnum.name, Name_ord,
						false, true, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.triggerEvent,
						StartEvent_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.flowObject,
						FlowObject_ord);
		putSimpleEntity(Sequence_ord, "Sequence", Sequence.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false).withFeature(
						WorkflowsFeatureDescriptorEnum.flowObjects,
						FlowObjects_ord);
		putSimpleEntity(Parallel_ord, "Parallel", Parallel.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false).withFeature(
						WorkflowsFeatureDescriptorEnum.flowObjects,
						FlowObjects_ord);
		putCompositeEntity(
		FlowObjects_ord, "FlowObjects", FlowObjects.class, false, FlowObject_ord, true, false);
		putSimpleEntity(ForeachLoop_ord, "ForeachLoop", ForeachLoop.class,
				false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.compositeVariable,
						Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.elementVariable,
						Variable_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.indexVariable,
						Variable_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.flowObject,
						FlowObject_ord);
		putSimpleEntity(WhileLoop_ord, "WhileLoop", WhileLoop.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.testTime,
						TestTime_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.condition,
						Condition_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.flowObject,
						FlowObject_ord);
		putDataEntity(TestTime_ord, "TestTime", TestTime.class, false,
				TestTimeEnum.Value.class);
		putSimpleEntity(PickControl_ord, "PickControl", PickControl.class,
				false).withFeature(WorkflowsFeatureDescriptorEnum.label,
				Label_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.eventHandlers,
						EventHandlers_ord);
		putSimpleEntity(SwitchControl_ord, "SwitchControl",
				SwitchControl.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.switchType,
						SwitchType_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.conditionalCases,
						ConditionalCases_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.defaultCase,
						DefaultCase_ord, true, false, false, false, false);
		putDataEntity(SwitchType_ord, "SwitchType", SwitchType.class, false,
				SwitchTypeEnum.Value.class);
		putCompositeEntity(
		ConditionalCases_ord, "ConditionalCases", ConditionalCases.class, false, ConditionalCase_ord, true, false);
		putSimpleEntity(ConditionalCase_ord, "ConditionalCase",
				ConditionalCase.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.condition,
						Condition_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.flowObject,
						FlowObject_ord);
		putSimpleEntity(DefaultCase_ord, "DefaultCase", DefaultCase.class,
				false).withFeature(WorkflowsFeatureDescriptorEnum.flowObject,
				FlowObject_ord);
		putSimpleEntity(StartEvent_ord, "StartEvent", StartEvent.class, true,
				OnCallEvent_ord, OnTimerEvent_ord, OnMessageEvent_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.name, Name_ord,
						false, true, false, false, false).withFeature(
						WorkflowsFeatureDescriptorEnum.label, Label_ord, true,
						false, false, false, false);
		putSimpleEntity(FlowEvent_ord, "FlowEvent", FlowEvent.class, true,
				ReturnEvent_ord, FaultEvent_ord).withFeature(
				WorkflowsFeatureDescriptorEnum.label, Label_ord, true, false,
				false, false, false);
		putSimpleEntity(OnCallEvent_ord, "OnCallEvent", OnCallEvent.class,
				false)
				.withFeature(WorkflowsFeatureDescriptorEnum.name, Name_ord,
						false, true, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.parameters,
						Parameters_ord, true, false, false, false, false);
		putSimpleEntity(OnMessageEvent_ord, "OnMessageEvent",
				OnMessageEvent.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.name, Name_ord,
						false, true, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.message,
						Message_ord);
		putSimpleEntity(OnTimerEvent_ord, "OnTimerEvent", OnTimerEvent.class,
				false)
				.withFeature(WorkflowsFeatureDescriptorEnum.name, Name_ord,
						false, true, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.timer, Timer_ord);
		putSimpleEntity(FaultEvent_ord, "FaultEvent", FaultEvent.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false).withFeature(
						WorkflowsFeatureDescriptorEnum.fault, Fault_ord);
		putSimpleEntity(ReturnEvent_ord, "ReturnEvent", ReturnEvent.class,
				false).withFeature(WorkflowsFeatureDescriptorEnum.label,
				Label_ord, true, false, false, false, false).withFeature(
				WorkflowsFeatureDescriptorEnum.result, Result_ord, true, false,
				false, false, false);
		putSimpleEntity(Task_ord, "Task", Task.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.description,
						Description_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.assignments,
						Assignments_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.factory,
						Variable_ord, true, false, false, false, false);
		putSimpleEntity(Breakpoint_ord, "Breakpoint", Breakpoint.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.disabled,
						BooleanLiteral_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.hitCount,
						IntLiteral_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.condition,
						Condition_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.conditionTest,
						ConditionTest_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.showVariables,
						Variables_ord, true, false, false, false, false);
		putDataEntity(ConditionTest_ord, "ConditionTest", ConditionTest.class,
				false, ConditionTestEnum.Value.class);
		putCompositeEntity(
		Variables_ord, "Variables", Variables.class, false, Variable_ord, true, false);
		putSimpleEntity(Activity_ord, "Activity", Activity.class, true,
				SaveArtifacts_ord, CreateModel_ord, InvokeJavaClassMethod_ord,
				DeleteArtifacts_ord, LoadModel_ord, CreateEntity_ord,
				CreateJavaClassInstance_ord, SynchronizeArtifactsActivity_ord,
				LoadArtifacts_ord, InvokeOperation_ord, InvokeQuery_ord,
				InvokeJavaInstanceMethod_ord, AssignActivity_ord,
				GrammarActivity_ord, EmptyActivity_ord, SaveModel_ord,
				Parse_ord, Unparse_ord, PersistenceActivity_ord,
				ArtifactsActivity_ord, LoadJavaModel_ord).withFeature(
				WorkflowsFeatureDescriptorEnum.label, Label_ord, true, false,
				false, false, false);
		putSimpleEntity(EmptyActivity_ord, "EmptyActivity",
				EmptyActivity.class, false).withFeature(
				WorkflowsFeatureDescriptorEnum.label, Label_ord, true, false,
				false, false, false);
		putSimpleEntity(AssignActivity_ord, "AssignActivity",
				AssignActivity.class, false).withFeature(
				WorkflowsFeatureDescriptorEnum.label, Label_ord, true, false,
				false, false, false).withFeature(
				WorkflowsFeatureDescriptorEnum.assignments, Assignments_ord);
		putSimpleEntity(CreateEntity_ord, "CreateEntity", CreateEntity.class,
				false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model,
						Variable_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.registry,
						Registry_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.entityName,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.arguments,
						Arguments_ord, true, false, false, false, false);
		putSimpleEntity(CreateModel_ord, "CreateModel", CreateModel.class,
				false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model,
						Variable_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.template,
						Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.bindings,
						Assignments_ord, true, false, false, false, false);
		putSimpleEntity(LoadJavaModel_ord, "LoadJavaModel",
				LoadJavaModel.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model,
						Variable_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.className,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.classProvider,
						ClassProvider_ord);
		putSimpleEntity(PersistenceActivity_ord, "PersistenceActivity",
				PersistenceActivity.class, true, LoadModel_ord, SaveModel_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model, Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.persistence,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.resourceKind,
						ResourceKind_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.resource,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.bindings,
						Assignments_ord, true, false, false, false, false);
		putDataEntity(ResourceKind_ord, "ResourceKind", ResourceKind.class,
				false, ResourceKindEnum.Value.class);
		putSimpleEntity(LoadModel_ord, "LoadModel", LoadModel.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model,
						Variable_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.persistence,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.resourceKind,
						ResourceKind_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.resource,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.bindings,
						Assignments_ord, true, false, false, false, false);
		putSimpleEntity(SaveModel_ord, "SaveModel", SaveModel.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model, Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.persistence,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.resourceKind,
						ResourceKind_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.resource,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.bindings,
						Assignments_ord, true, false, false, false, false);
		putSimpleEntity(ArtifactsActivity_ord, "ArtifactsActivity",
				ArtifactsActivity.class, true, LoadArtifacts_ord,
				SynchronizeArtifactsActivity_ord, SaveArtifacts_ord,
				DeleteArtifacts_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model, Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.rootResourceKind,
						ResourceKind_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.rootResource,
						Expression_ord);
		putSimpleEntity(DeleteArtifacts_ord, "DeleteArtifacts",
				DeleteArtifacts.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model, Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.rootResourceKind,
						ResourceKind_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.rootResource,
						Expression_ord);
		putSimpleEntity(SynchronizeArtifactsActivity_ord,
				"SynchronizeArtifactsActivity",
				SynchronizeArtifactsActivity.class, true, LoadArtifacts_ord,
				SaveArtifacts_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model, Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.rootResourceKind,
						ResourceKind_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.rootResource,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.traversalStrategy,
						ArtifactsTraversalStrategy_ord)
				.withFeature(
						WorkflowsFeatureDescriptorEnum.synchronizeStrategy,
						ArtifactsSynchronizeStrategy_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.defaultPersistence,
						Expression_ord, true, false, false, false, false);
		putDataEntity(ArtifactsTraversalStrategy_ord,
				"ArtifactsTraversalStrategy", ArtifactsTraversalStrategy.class,
				false, ArtifactsTraversalStrategyEnum.Value.class);
		putDataEntity(ArtifactsSynchronizeStrategy_ord,
				"ArtifactsSynchronizeStrategy",
				ArtifactsSynchronizeStrategy.class, false,
				ArtifactsSynchronizeStrategyEnum.Value.class);
		putSimpleEntity(LoadArtifacts_ord, "LoadArtifacts",
				LoadArtifacts.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model, Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.rootResourceKind,
						ResourceKind_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.rootResource,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.traversalStrategy,
						ArtifactsTraversalStrategy_ord)
				.withFeature(
						WorkflowsFeatureDescriptorEnum.synchronizeStrategy,
						ArtifactsSynchronizeStrategy_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.defaultPersistence,
						Expression_ord, true, false, false, false, false);
		putSimpleEntity(SaveArtifacts_ord, "SaveArtifacts",
				SaveArtifacts.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model, Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.rootResourceKind,
						ResourceKind_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.rootResource,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.traversalStrategy,
						ArtifactsTraversalStrategy_ord)
				.withFeature(
						WorkflowsFeatureDescriptorEnum.synchronizeStrategy,
						ArtifactsSynchronizeStrategy_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.defaultPersistence,
						Expression_ord, true, false, false, false, false);
		putSimpleEntity(GrammarActivity_ord, "GrammarActivity",
				GrammarActivity.class, true, Unparse_ord, Parse_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model, Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.text,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.grammar,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.nt, Expression_ord,
						true, false, false, false, false);
		putSimpleEntity(Parse_ord, "Parse", Parse.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model,
						Variable_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.text,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.grammar,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.nt, Expression_ord,
						true, false, false, false, false);
		putSimpleEntity(Unparse_ord, "Unparse", Unparse.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model, Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.text,
						Expression_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.grammar,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.nt, Expression_ord,
						true, false, false, false, false);
		putSimpleEntity(InvokeOperation_ord, "InvokeOperation",
				InvokeOperation.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.model, Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.operation,
						Operation_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.bindings,
						Assignments_ord, true, false, false, false, false);
		putDataEntity(Operation_ord, "Operation", Operation.class, false,
				OperationEnum.Value.class);
		putSimpleEntity(InvokeQuery_ord, "InvokeQuery", InvokeQuery.class,
				false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.queryName,
						Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.arguments,
						Arguments_ord, true, false, false, false, false);
		putSimpleEntity(InvokeJavaInstanceMethod_ord,
				"InvokeJavaInstanceMethod", InvokeJavaInstanceMethod.class,
				false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.result,
						Variable_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.object,
						Variable_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.typeArguments,
						Expressions_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.className,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.method,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.arguments,
						Expressions_ord, true, false, false, false, false);
		putSimpleEntity(InvokeJavaClassMethod_ord, "InvokeJavaClassMethod",
				InvokeJavaClassMethod.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.result,
						Variable_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.typeArguments,
						Expressions_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.className,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.method,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.arguments,
						Expressions_ord, true, false, false, false, false);
		putSimpleEntity(CreateJavaClassInstance_ord, "CreateJavaClassInstance",
				CreateJavaClassInstance.class, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.label, Label_ord,
						true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.result,
						Variable_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.typeArguments,
						Expressions_ord, true, false, false, false, false)
				.withFeature(WorkflowsFeatureDescriptorEnum.className,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.constructor,
						Expression_ord)
				.withFeature(WorkflowsFeatureDescriptorEnum.arguments,
						Expressions_ord, true, false, false, false, false);
		putDataEntity(Registry_ord, "Registry", Registry.class, false,
				RegistryEnum.Value.class);
		putSimpleEntity(Expression_ord, "Expression", Expression.class, true,
				StringLiteral_ord, IntLiteral_ord, ObjectLiteral_ord,
				Literal_ord, Variable_ord, BooleanLiteral_ord);
		putSimpleEntity(Literal_ord, "Literal", Literal.class, true);
		putDataEntity(BooleanLiteral_ord, "BooleanLiteral",
				BooleanLiteral.class, false, boolean.class);
		putDataEntity(IntLiteral_ord, "IntLiteral", IntLiteral.class, false,
				int.class);
		putDataEntity(StringLiteral_ord, "StringLiteral", StringLiteral.class,
				false, String.class);
		putDataEntity(ObjectLiteral_ord, "ObjectLiteral", ObjectLiteral.class,
				false, java.lang.Object.class);
		putDataEntity(Variable_ord, "Variable", Variable.class, false,
				String.class);
		putDataEntity(Name_ord, "Name", Name.class, false, String.class);
		putSimpleEntity(Label_ord, "Label", Label.class, true, Text_ord);
		putSimpleEntity(Description_ord, "Description", Description.class,
				true, Text_ord);
		putDataEntity(Text_ord, "Text", Text.class, false, String.class);
		putCompositeEntity(
		Declarations_ord, "Declarations", Declarations.class, false, Declaration_ord, true, false);
		putSimpleEntity(Arguments_ord, "Arguments", Arguments.class, true,
				Expressions_ord, Assignments_ord);
		putCompositeEntity(
		Assignments_ord, "Assignments", Assignments.class, false, Assign_ord, true, false);
		putSimpleEntity(Assign_ord, "Assign", Assign.class, false).withFeature(
				WorkflowsFeatureDescriptorEnum.name, Variable_ord).withFeature(
				WorkflowsFeatureDescriptorEnum.expression, Expression_ord);
		putCompositeEntity(
		Expressions_ord, "Expressions", Expressions.class, false, Expression_ord, true, false);
		putDataEntity(Signature_ord, "Signature", Signature.class, false,
				String.class);
		putSimpleEntity(Declaration_ord, "Declaration", Declaration.class, true);
		putSimpleEntity(ClassProvider_ord, "ClassProvider",
				ClassProvider.class, true, CurrentJavaProject_ord,
				JavaProject_ord, ClassPath_ord);
		putSimpleEntity(ClassPath_ord, "ClassPath", ClassPath.class, false);
		putSimpleEntity(CurrentJavaProject_ord, "CurrentJavaProject",
				CurrentJavaProject.class, false);
		putDataEntity(JavaProject_ord, "JavaProject", JavaProject.class, false,
				String.class);
		putSimpleEntity(Condition_ord, "Condition", Condition.class, true);
		putSimpleEntity(Parameters_ord, "Parameters", Parameters.class, true);
		putSimpleEntity(Result_ord, "Result", Result.class, true);
		putSimpleEntity(Message_ord, "Message", Message.class, true);
		putSimpleEntity(Event_ord, "Event", Event.class, true, ReturnEvent_ord,
				FlowEvent_ord, OnMessageEvent_ord, StartEvent_ord,
				OnCallEvent_ord, OnTimerEvent_ord, FaultEvent_ord);
		putSimpleEntity(Timer_ord, "Timer", Timer.class, true);
		putSimpleEntity(Fault_ord, "Fault", Fault.class, true);
	}

	protected void initForeignTypeRelations() {
		setAssignableToAll(true, Breakpoint_ord, CreateEntity_ord,
				CreateModel_ord, CreateJavaClassInstance_ord,
				InvokeJavaClassMethod_ord, InvokeJavaInstanceMethod_ord, InvokeOperation_ord,
				LoadModel_ord, SaveModel_ord, LoadJavaModel_ord, LoadArtifacts_ord,
				SaveArtifacts_ord, DeleteArtifacts_ord, Parse_ord, Unparse_ord);
		setAssignableFromAll(true, Expression_ord, Condition_ord);
	}
}
