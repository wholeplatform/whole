package org.whole.lang.workflows.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.workflows.model.TestTimeEnum.Value;

/** 
 * @generator Whole
 */
public class WorkflowsGenericBuilderAdapter extends GenericIdentityBuilder {
	private IWorkflowsBuilder specificBuilder;

	public WorkflowsGenericBuilderAdapter(IWorkflowsBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public WorkflowsGenericBuilderAdapter(IWorkflowsBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case WorkflowsFeatureDescriptorEnum.name_ord:
			specificBuilder.name();
			break;
		case WorkflowsFeatureDescriptorEnum.description_ord:
			specificBuilder.description();
			break;
		case WorkflowsFeatureDescriptorEnum.declarations_ord:
			specificBuilder.declarations();
			break;
		case WorkflowsFeatureDescriptorEnum.startEvent_ord:
			specificBuilder.startEvent();
			break;
		case WorkflowsFeatureDescriptorEnum.flowObject_ord:
			specificBuilder.flowObject();
			break;
		case WorkflowsFeatureDescriptorEnum.endEvent_ord:
			specificBuilder.endEvent();
			break;
		case WorkflowsFeatureDescriptorEnum.label_ord:
			specificBuilder.label();
			break;
		case WorkflowsFeatureDescriptorEnum.compensationHandler_ord:
			specificBuilder.compensationHandler();
			break;
		case WorkflowsFeatureDescriptorEnum.eventHandlers_ord:
			specificBuilder.eventHandlers();
			break;
		case WorkflowsFeatureDescriptorEnum.faultHandlers_ord:
			specificBuilder.faultHandlers();
			break;
		case WorkflowsFeatureDescriptorEnum.faultName_ord:
			specificBuilder.faultName();
			break;
		case WorkflowsFeatureDescriptorEnum.faultVariable_ord:
			specificBuilder.faultVariable();
			break;
		case WorkflowsFeatureDescriptorEnum.triggerEvent_ord:
			specificBuilder.triggerEvent();
			break;
		case WorkflowsFeatureDescriptorEnum.flowObjects_ord:
			specificBuilder.flowObjects();
			break;
		case WorkflowsFeatureDescriptorEnum.compositeVariable_ord:
			specificBuilder.compositeVariable();
			break;
		case WorkflowsFeatureDescriptorEnum.elementVariable_ord:
			specificBuilder.elementVariable();
			break;
		case WorkflowsFeatureDescriptorEnum.indexVariable_ord:
			specificBuilder.indexVariable();
			break;
		case WorkflowsFeatureDescriptorEnum.testTime_ord:
			specificBuilder.testTime();
			break;
		case WorkflowsFeatureDescriptorEnum.condition_ord:
			specificBuilder.condition();
			break;
		case WorkflowsFeatureDescriptorEnum.switchType_ord:
			specificBuilder.switchType();
			break;
		case WorkflowsFeatureDescriptorEnum.conditionalCases_ord:
			specificBuilder.conditionalCases();
			break;
		case WorkflowsFeatureDescriptorEnum.defaultCase_ord:
			specificBuilder.defaultCase();
			break;
		case WorkflowsFeatureDescriptorEnum.parameters_ord:
			specificBuilder.parameters();
			break;
		case WorkflowsFeatureDescriptorEnum.message_ord:
			specificBuilder.message();
			break;
		case WorkflowsFeatureDescriptorEnum.timer_ord:
			specificBuilder.timer();
			break;
		case WorkflowsFeatureDescriptorEnum.fault_ord:
			specificBuilder.fault();
			break;
		case WorkflowsFeatureDescriptorEnum.result_ord:
			specificBuilder.result();
			break;
		case WorkflowsFeatureDescriptorEnum.assignments_ord:
			specificBuilder.assignments();
			break;
		case WorkflowsFeatureDescriptorEnum.factory_ord:
			specificBuilder.factory();
			break;
		case WorkflowsFeatureDescriptorEnum.disabled_ord:
			specificBuilder.disabled();
			break;
		case WorkflowsFeatureDescriptorEnum.hitCount_ord:
			specificBuilder.hitCount();
			break;
		case WorkflowsFeatureDescriptorEnum.conditionTest_ord:
			specificBuilder.conditionTest();
			break;
		case WorkflowsFeatureDescriptorEnum.showVariables_ord:
			specificBuilder.showVariables();
			break;
		case WorkflowsFeatureDescriptorEnum.model_ord:
			specificBuilder.model();
			break;
		case WorkflowsFeatureDescriptorEnum.registry_ord:
			specificBuilder.registry();
			break;
		case WorkflowsFeatureDescriptorEnum.entityName_ord:
			specificBuilder.entityName();
			break;
		case WorkflowsFeatureDescriptorEnum.arguments_ord:
			specificBuilder.arguments();
			break;
		case WorkflowsFeatureDescriptorEnum.template_ord:
			specificBuilder.template();
			break;
		case WorkflowsFeatureDescriptorEnum.bindings_ord:
			specificBuilder.bindings();
			break;
		case WorkflowsFeatureDescriptorEnum.className_ord:
			specificBuilder.className();
			break;
		case WorkflowsFeatureDescriptorEnum.classProvider_ord:
			specificBuilder.classProvider();
			break;
		case WorkflowsFeatureDescriptorEnum.persistence_ord:
			specificBuilder.persistence();
			break;
		case WorkflowsFeatureDescriptorEnum.resourceKind_ord:
			specificBuilder.resourceKind();
			break;
		case WorkflowsFeatureDescriptorEnum.resource_ord:
			specificBuilder.resource();
			break;
		case WorkflowsFeatureDescriptorEnum.rootResourceKind_ord:
			specificBuilder.rootResourceKind();
			break;
		case WorkflowsFeatureDescriptorEnum.rootResource_ord:
			specificBuilder.rootResource();
			break;
		case WorkflowsFeatureDescriptorEnum.traversalStrategy_ord:
			specificBuilder.traversalStrategy();
			break;
		case WorkflowsFeatureDescriptorEnum.synchronizeStrategy_ord:
			specificBuilder.synchronizeStrategy();
			break;
		case WorkflowsFeatureDescriptorEnum.defaultPersistence_ord:
			specificBuilder.defaultPersistence();
			break;
		case WorkflowsFeatureDescriptorEnum.text_ord:
			specificBuilder.text();
			break;
		case WorkflowsFeatureDescriptorEnum.grammar_ord:
			specificBuilder.grammar();
			break;
		case WorkflowsFeatureDescriptorEnum.nt_ord:
			specificBuilder.nt();
			break;
		case WorkflowsFeatureDescriptorEnum.operation_ord:
			specificBuilder.operation();
			break;
		case WorkflowsFeatureDescriptorEnum.queryName_ord:
			specificBuilder.queryName();
			break;
		case WorkflowsFeatureDescriptorEnum.object_ord:
			specificBuilder.object();
			break;
		case WorkflowsFeatureDescriptorEnum.typeArguments_ord:
			specificBuilder.typeArguments();
			break;
		case WorkflowsFeatureDescriptorEnum.method_ord:
			specificBuilder.method();
			break;
		case WorkflowsFeatureDescriptorEnum.constructor_ord:
			specificBuilder.constructor();
			break;
		case WorkflowsFeatureDescriptorEnum.expression_ord:
			specificBuilder.expression();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case WorkflowsEntityDescriptorEnum.Workflow_ord:
			specificBuilder.Workflow();
			break;
		case WorkflowsEntityDescriptorEnum.Scope_ord:
			specificBuilder.Scope();
			break;
		case WorkflowsEntityDescriptorEnum.FaultHandlers_ord:
			specificBuilder.FaultHandlers();
			break;
		case WorkflowsEntityDescriptorEnum.FaultHandler_ord:
			specificBuilder.FaultHandler();
			break;
		case WorkflowsEntityDescriptorEnum.EventHandlers_ord:
			specificBuilder.EventHandlers();
			break;
		case WorkflowsEntityDescriptorEnum.EventHandler_ord:
			specificBuilder.EventHandler();
			break;
		case WorkflowsEntityDescriptorEnum.Sequence_ord:
			specificBuilder.Sequence();
			break;
		case WorkflowsEntityDescriptorEnum.Parallel_ord:
			specificBuilder.Parallel();
			break;
		case WorkflowsEntityDescriptorEnum.FlowObjects_ord:
			specificBuilder.FlowObjects();
			break;
		case WorkflowsEntityDescriptorEnum.ForeachLoop_ord:
			specificBuilder.ForeachLoop();
			break;
		case WorkflowsEntityDescriptorEnum.WhileLoop_ord:
			specificBuilder.WhileLoop();
			break;
		case WorkflowsEntityDescriptorEnum.PickControl_ord:
			specificBuilder.PickControl();
			break;
		case WorkflowsEntityDescriptorEnum.SwitchControl_ord:
			specificBuilder.SwitchControl();
			break;
		case WorkflowsEntityDescriptorEnum.ConditionalCases_ord:
			specificBuilder.ConditionalCases();
			break;
		case WorkflowsEntityDescriptorEnum.ConditionalCase_ord:
			specificBuilder.ConditionalCase();
			break;
		case WorkflowsEntityDescriptorEnum.DefaultCase_ord:
			specificBuilder.DefaultCase();
			break;
		case WorkflowsEntityDescriptorEnum.OnCallEvent_ord:
			specificBuilder.OnCallEvent();
			break;
		case WorkflowsEntityDescriptorEnum.OnMessageEvent_ord:
			specificBuilder.OnMessageEvent();
			break;
		case WorkflowsEntityDescriptorEnum.OnTimerEvent_ord:
			specificBuilder.OnTimerEvent();
			break;
		case WorkflowsEntityDescriptorEnum.FaultEvent_ord:
			specificBuilder.FaultEvent();
			break;
		case WorkflowsEntityDescriptorEnum.ReturnEvent_ord:
			specificBuilder.ReturnEvent();
			break;
		case WorkflowsEntityDescriptorEnum.Task_ord:
			specificBuilder.Task();
			break;
		case WorkflowsEntityDescriptorEnum.Breakpoint_ord:
			specificBuilder.Breakpoint();
			break;
		case WorkflowsEntityDescriptorEnum.Variables_ord:
			specificBuilder.Variables();
			break;
		case WorkflowsEntityDescriptorEnum.EmptyActivity_ord:
			specificBuilder.EmptyActivity();
			break;
		case WorkflowsEntityDescriptorEnum.AssignActivity_ord:
			specificBuilder.AssignActivity();
			break;
		case WorkflowsEntityDescriptorEnum.CreateEntity_ord:
			specificBuilder.CreateEntity();
			break;
		case WorkflowsEntityDescriptorEnum.CreateModel_ord:
			specificBuilder.CreateModel();
			break;
		case WorkflowsEntityDescriptorEnum.LoadJavaModel_ord:
			specificBuilder.LoadJavaModel();
			break;
		case WorkflowsEntityDescriptorEnum.LoadModel_ord:
			specificBuilder.LoadModel();
			break;
		case WorkflowsEntityDescriptorEnum.SaveModel_ord:
			specificBuilder.SaveModel();
			break;
		case WorkflowsEntityDescriptorEnum.DeleteArtifacts_ord:
			specificBuilder.DeleteArtifacts();
			break;
		case WorkflowsEntityDescriptorEnum.LoadArtifacts_ord:
			specificBuilder.LoadArtifacts();
			break;
		case WorkflowsEntityDescriptorEnum.SaveArtifacts_ord:
			specificBuilder.SaveArtifacts();
			break;
		case WorkflowsEntityDescriptorEnum.Parse_ord:
			specificBuilder.Parse();
			break;
		case WorkflowsEntityDescriptorEnum.Unparse_ord:
			specificBuilder.Unparse();
			break;
		case WorkflowsEntityDescriptorEnum.InvokeOperation_ord:
			specificBuilder.InvokeOperation();
			break;
		case WorkflowsEntityDescriptorEnum.InvokeQuery_ord:
			specificBuilder.InvokeQuery();
			break;
		case WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod_ord:
			specificBuilder.InvokeJavaInstanceMethod();
			break;
		case WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod_ord:
			specificBuilder.InvokeJavaClassMethod();
			break;
		case WorkflowsEntityDescriptorEnum.CreateJavaClassInstance_ord:
			specificBuilder.CreateJavaClassInstance();
			break;
		case WorkflowsEntityDescriptorEnum.Declarations_ord:
			specificBuilder.Declarations();
			break;
		case WorkflowsEntityDescriptorEnum.Assignments_ord:
			specificBuilder.Assignments();
			break;
		case WorkflowsEntityDescriptorEnum.Assign_ord:
			specificBuilder.Assign();
			break;
		case WorkflowsEntityDescriptorEnum.Expressions_ord:
			specificBuilder.Expressions();
			break;
		case WorkflowsEntityDescriptorEnum.ClassPath_ord:
			specificBuilder.ClassPath();
			break;
		case WorkflowsEntityDescriptorEnum.CurrentJavaProject_ord:
			specificBuilder.CurrentJavaProject();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case WorkflowsEntityDescriptorEnum.Workflow_ord:
			specificBuilder.Workflow_();
			break;
		case WorkflowsEntityDescriptorEnum.Scope_ord:
			specificBuilder.Scope_();
			break;
		case WorkflowsEntityDescriptorEnum.FaultHandlers_ord:
			specificBuilder.FaultHandlers_();
			break;
		case WorkflowsEntityDescriptorEnum.FaultHandler_ord:
			specificBuilder.FaultHandler_();
			break;
		case WorkflowsEntityDescriptorEnum.EventHandlers_ord:
			specificBuilder.EventHandlers_();
			break;
		case WorkflowsEntityDescriptorEnum.EventHandler_ord:
			specificBuilder.EventHandler_();
			break;
		case WorkflowsEntityDescriptorEnum.Sequence_ord:
			specificBuilder.Sequence_();
			break;
		case WorkflowsEntityDescriptorEnum.Parallel_ord:
			specificBuilder.Parallel_();
			break;
		case WorkflowsEntityDescriptorEnum.FlowObjects_ord:
			specificBuilder.FlowObjects_();
			break;
		case WorkflowsEntityDescriptorEnum.ForeachLoop_ord:
			specificBuilder.ForeachLoop_();
			break;
		case WorkflowsEntityDescriptorEnum.WhileLoop_ord:
			specificBuilder.WhileLoop_();
			break;
		case WorkflowsEntityDescriptorEnum.PickControl_ord:
			specificBuilder.PickControl_();
			break;
		case WorkflowsEntityDescriptorEnum.SwitchControl_ord:
			specificBuilder.SwitchControl_();
			break;
		case WorkflowsEntityDescriptorEnum.ConditionalCases_ord:
			specificBuilder.ConditionalCases_();
			break;
		case WorkflowsEntityDescriptorEnum.ConditionalCase_ord:
			specificBuilder.ConditionalCase_();
			break;
		case WorkflowsEntityDescriptorEnum.DefaultCase_ord:
			specificBuilder.DefaultCase_();
			break;
		case WorkflowsEntityDescriptorEnum.OnCallEvent_ord:
			specificBuilder.OnCallEvent_();
			break;
		case WorkflowsEntityDescriptorEnum.OnMessageEvent_ord:
			specificBuilder.OnMessageEvent_();
			break;
		case WorkflowsEntityDescriptorEnum.OnTimerEvent_ord:
			specificBuilder.OnTimerEvent_();
			break;
		case WorkflowsEntityDescriptorEnum.FaultEvent_ord:
			specificBuilder.FaultEvent_();
			break;
		case WorkflowsEntityDescriptorEnum.ReturnEvent_ord:
			specificBuilder.ReturnEvent_();
			break;
		case WorkflowsEntityDescriptorEnum.Task_ord:
			specificBuilder.Task_();
			break;
		case WorkflowsEntityDescriptorEnum.Breakpoint_ord:
			specificBuilder.Breakpoint_();
			break;
		case WorkflowsEntityDescriptorEnum.Variables_ord:
			specificBuilder.Variables_();
			break;
		case WorkflowsEntityDescriptorEnum.EmptyActivity_ord:
			specificBuilder.EmptyActivity_();
			break;
		case WorkflowsEntityDescriptorEnum.AssignActivity_ord:
			specificBuilder.AssignActivity_();
			break;
		case WorkflowsEntityDescriptorEnum.CreateEntity_ord:
			specificBuilder.CreateEntity_();
			break;
		case WorkflowsEntityDescriptorEnum.CreateModel_ord:
			specificBuilder.CreateModel_();
			break;
		case WorkflowsEntityDescriptorEnum.LoadJavaModel_ord:
			specificBuilder.LoadJavaModel_();
			break;
		case WorkflowsEntityDescriptorEnum.LoadModel_ord:
			specificBuilder.LoadModel_();
			break;
		case WorkflowsEntityDescriptorEnum.SaveModel_ord:
			specificBuilder.SaveModel_();
			break;
		case WorkflowsEntityDescriptorEnum.DeleteArtifacts_ord:
			specificBuilder.DeleteArtifacts_();
			break;
		case WorkflowsEntityDescriptorEnum.LoadArtifacts_ord:
			specificBuilder.LoadArtifacts_();
			break;
		case WorkflowsEntityDescriptorEnum.SaveArtifacts_ord:
			specificBuilder.SaveArtifacts_();
			break;
		case WorkflowsEntityDescriptorEnum.Parse_ord:
			specificBuilder.Parse_();
			break;
		case WorkflowsEntityDescriptorEnum.Unparse_ord:
			specificBuilder.Unparse_();
			break;
		case WorkflowsEntityDescriptorEnum.InvokeOperation_ord:
			specificBuilder.InvokeOperation_();
			break;
		case WorkflowsEntityDescriptorEnum.InvokeQuery_ord:
			specificBuilder.InvokeQuery_();
			break;
		case WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod_ord:
			specificBuilder.InvokeJavaInstanceMethod_();
			break;
		case WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod_ord:
			specificBuilder.InvokeJavaClassMethod_();
			break;
		case WorkflowsEntityDescriptorEnum.CreateJavaClassInstance_ord:
			specificBuilder.CreateJavaClassInstance_();
			break;
		case WorkflowsEntityDescriptorEnum.Declarations_ord:
			specificBuilder.Declarations_();
			break;
		case WorkflowsEntityDescriptorEnum.Assignments_ord:
			specificBuilder.Assignments_();
			break;
		case WorkflowsEntityDescriptorEnum.Assign_ord:
			specificBuilder.Assign_();
			break;
		case WorkflowsEntityDescriptorEnum.Expressions_ord:
			specificBuilder.Expressions_();
			break;
		case WorkflowsEntityDescriptorEnum.ClassPath_ord:
			specificBuilder.ClassPath_();
			break;
		case WorkflowsEntityDescriptorEnum.CurrentJavaProject_ord:
			specificBuilder.CurrentJavaProject_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case WorkflowsEntityDescriptorEnum.Workflow_ord:
			specificBuilder._Workflow();
			break;
		case WorkflowsEntityDescriptorEnum.Scope_ord:
			specificBuilder._Scope();
			break;
		case WorkflowsEntityDescriptorEnum.FaultHandlers_ord:
			specificBuilder._FaultHandlers();
			break;
		case WorkflowsEntityDescriptorEnum.FaultHandler_ord:
			specificBuilder._FaultHandler();
			break;
		case WorkflowsEntityDescriptorEnum.EventHandlers_ord:
			specificBuilder._EventHandlers();
			break;
		case WorkflowsEntityDescriptorEnum.EventHandler_ord:
			specificBuilder._EventHandler();
			break;
		case WorkflowsEntityDescriptorEnum.Sequence_ord:
			specificBuilder._Sequence();
			break;
		case WorkflowsEntityDescriptorEnum.Parallel_ord:
			specificBuilder._Parallel();
			break;
		case WorkflowsEntityDescriptorEnum.FlowObjects_ord:
			specificBuilder._FlowObjects();
			break;
		case WorkflowsEntityDescriptorEnum.ForeachLoop_ord:
			specificBuilder._ForeachLoop();
			break;
		case WorkflowsEntityDescriptorEnum.WhileLoop_ord:
			specificBuilder._WhileLoop();
			break;
		case WorkflowsEntityDescriptorEnum.PickControl_ord:
			specificBuilder._PickControl();
			break;
		case WorkflowsEntityDescriptorEnum.SwitchControl_ord:
			specificBuilder._SwitchControl();
			break;
		case WorkflowsEntityDescriptorEnum.ConditionalCases_ord:
			specificBuilder._ConditionalCases();
			break;
		case WorkflowsEntityDescriptorEnum.ConditionalCase_ord:
			specificBuilder._ConditionalCase();
			break;
		case WorkflowsEntityDescriptorEnum.DefaultCase_ord:
			specificBuilder._DefaultCase();
			break;
		case WorkflowsEntityDescriptorEnum.OnCallEvent_ord:
			specificBuilder._OnCallEvent();
			break;
		case WorkflowsEntityDescriptorEnum.OnMessageEvent_ord:
			specificBuilder._OnMessageEvent();
			break;
		case WorkflowsEntityDescriptorEnum.OnTimerEvent_ord:
			specificBuilder._OnTimerEvent();
			break;
		case WorkflowsEntityDescriptorEnum.FaultEvent_ord:
			specificBuilder._FaultEvent();
			break;
		case WorkflowsEntityDescriptorEnum.ReturnEvent_ord:
			specificBuilder._ReturnEvent();
			break;
		case WorkflowsEntityDescriptorEnum.Task_ord:
			specificBuilder._Task();
			break;
		case WorkflowsEntityDescriptorEnum.Breakpoint_ord:
			specificBuilder._Breakpoint();
			break;
		case WorkflowsEntityDescriptorEnum.Variables_ord:
			specificBuilder._Variables();
			break;
		case WorkflowsEntityDescriptorEnum.EmptyActivity_ord:
			specificBuilder._EmptyActivity();
			break;
		case WorkflowsEntityDescriptorEnum.AssignActivity_ord:
			specificBuilder._AssignActivity();
			break;
		case WorkflowsEntityDescriptorEnum.CreateEntity_ord:
			specificBuilder._CreateEntity();
			break;
		case WorkflowsEntityDescriptorEnum.CreateModel_ord:
			specificBuilder._CreateModel();
			break;
		case WorkflowsEntityDescriptorEnum.LoadJavaModel_ord:
			specificBuilder._LoadJavaModel();
			break;
		case WorkflowsEntityDescriptorEnum.LoadModel_ord:
			specificBuilder._LoadModel();
			break;
		case WorkflowsEntityDescriptorEnum.SaveModel_ord:
			specificBuilder._SaveModel();
			break;
		case WorkflowsEntityDescriptorEnum.DeleteArtifacts_ord:
			specificBuilder._DeleteArtifacts();
			break;
		case WorkflowsEntityDescriptorEnum.LoadArtifacts_ord:
			specificBuilder._LoadArtifacts();
			break;
		case WorkflowsEntityDescriptorEnum.SaveArtifacts_ord:
			specificBuilder._SaveArtifacts();
			break;
		case WorkflowsEntityDescriptorEnum.Parse_ord:
			specificBuilder._Parse();
			break;
		case WorkflowsEntityDescriptorEnum.Unparse_ord:
			specificBuilder._Unparse();
			break;
		case WorkflowsEntityDescriptorEnum.InvokeOperation_ord:
			specificBuilder._InvokeOperation();
			break;
		case WorkflowsEntityDescriptorEnum.InvokeQuery_ord:
			specificBuilder._InvokeQuery();
			break;
		case WorkflowsEntityDescriptorEnum.InvokeJavaInstanceMethod_ord:
			specificBuilder._InvokeJavaInstanceMethod();
			break;
		case WorkflowsEntityDescriptorEnum.InvokeJavaClassMethod_ord:
			specificBuilder._InvokeJavaClassMethod();
			break;
		case WorkflowsEntityDescriptorEnum.CreateJavaClassInstance_ord:
			specificBuilder._CreateJavaClassInstance();
			break;
		case WorkflowsEntityDescriptorEnum.Declarations_ord:
			specificBuilder._Declarations();
			break;
		case WorkflowsEntityDescriptorEnum.Assignments_ord:
			specificBuilder._Assignments();
			break;
		case WorkflowsEntityDescriptorEnum.Assign_ord:
			specificBuilder._Assign();
			break;
		case WorkflowsEntityDescriptorEnum.Expressions_ord:
			specificBuilder._Expressions();
			break;
		case WorkflowsEntityDescriptorEnum.ClassPath_ord:
			specificBuilder._ClassPath();
			break;
		case WorkflowsEntityDescriptorEnum.CurrentJavaProject_ord:
			specificBuilder._CurrentJavaProject();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case WorkflowsEntityDescriptorEnum.FaultHandlers_ord:
			specificBuilder.FaultHandlers_(initialCapacity);
			break;
		case WorkflowsEntityDescriptorEnum.EventHandlers_ord:
			specificBuilder.EventHandlers_(initialCapacity);
			break;
		case WorkflowsEntityDescriptorEnum.FlowObjects_ord:
			specificBuilder.FlowObjects_(initialCapacity);
			break;
		case WorkflowsEntityDescriptorEnum.ConditionalCases_ord:
			specificBuilder.ConditionalCases_(initialCapacity);
			break;
		case WorkflowsEntityDescriptorEnum.Variables_ord:
			specificBuilder.Variables_(initialCapacity);
			break;
		case WorkflowsEntityDescriptorEnum.Declarations_ord:
			specificBuilder.Declarations_(initialCapacity);
			break;
		case WorkflowsEntityDescriptorEnum.Assignments_ord:
			specificBuilder.Assignments_(initialCapacity);
			break;
		case WorkflowsEntityDescriptorEnum.Expressions_ord:
			specificBuilder.Expressions_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case WorkflowsEntityDescriptorEnum.TestTime_ord:
			specificBuilder.TestTime((Value) value);
			break;
		case WorkflowsEntityDescriptorEnum.SwitchType_ord:
			specificBuilder
					.SwitchType((org.whole.lang.workflows.model.SwitchTypeEnum.Value) value);
			break;
		case WorkflowsEntityDescriptorEnum.ConditionTest_ord:
			specificBuilder
					.ConditionTest((org.whole.lang.workflows.model.ConditionTestEnum.Value) value);
			break;
		case WorkflowsEntityDescriptorEnum.ResourceKind_ord:
			specificBuilder
					.ResourceKind((org.whole.lang.workflows.model.ResourceKindEnum.Value) value);
			break;
		case WorkflowsEntityDescriptorEnum.ArtifactsTraversalStrategy_ord:
			specificBuilder
					.ArtifactsTraversalStrategy((org.whole.lang.workflows.model.ArtifactsTraversalStrategyEnum.Value) value);
			break;
		case WorkflowsEntityDescriptorEnum.ArtifactsSynchronizeStrategy_ord:
			specificBuilder
					.ArtifactsSynchronizeStrategy((org.whole.lang.workflows.model.ArtifactsSynchronizeStrategyEnum.Value) value);
			break;
		case WorkflowsEntityDescriptorEnum.Operation_ord:
			specificBuilder
					.Operation((org.whole.lang.workflows.model.OperationEnum.Value) value);
			break;
		case WorkflowsEntityDescriptorEnum.Registry_ord:
			specificBuilder
					.Registry((org.whole.lang.workflows.model.RegistryEnum.Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, boolean value) {
		switch (entityDesc.getOrdinal()) {
		case WorkflowsEntityDescriptorEnum.BooleanLiteral_ord:
			specificBuilder.BooleanLiteral(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case WorkflowsEntityDescriptorEnum.IntLiteral_ord:
			specificBuilder.IntLiteral(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case WorkflowsEntityDescriptorEnum.StringLiteral_ord:
			specificBuilder.StringLiteral(value);
			break;
		case WorkflowsEntityDescriptorEnum.Variable_ord:
			specificBuilder.Variable(value);
			break;
		case WorkflowsEntityDescriptorEnum.Name_ord:
			specificBuilder.Name(value);
			break;
		case WorkflowsEntityDescriptorEnum.Text_ord:
			specificBuilder.Text(value);
			break;
		case WorkflowsEntityDescriptorEnum.Signature_ord:
			specificBuilder.Signature(value);
			break;
		case WorkflowsEntityDescriptorEnum.JavaProject_ord:
			specificBuilder.JavaProject(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, Object value) {
		switch (entityDesc.getOrdinal()) {
		case WorkflowsEntityDescriptorEnum.ObjectLiteral_ord:
			specificBuilder.ObjectLiteral(value);
			break;
		}
	}
}
