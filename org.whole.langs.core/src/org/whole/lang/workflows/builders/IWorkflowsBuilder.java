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
package org.whole.lang.workflows.builders;

import org.whole.lang.builders.IBuilder;
import org.whole.lang.workflows.model.TestTimeEnum;
import org.whole.lang.workflows.model.SwitchTypeEnum;
import org.whole.lang.workflows.model.ConditionTestEnum;
import org.whole.lang.workflows.model.ResourceKindEnum;
import org.whole.lang.workflows.model.ArtifactsTraversalStrategyEnum;
import org.whole.lang.workflows.model.ArtifactsSynchronizeStrategyEnum;
import org.whole.lang.workflows.model.OperationEnum;
import org.whole.lang.workflows.model.RegistryEnum;

/**
 *  @generator Whole
 */
public interface IWorkflowsBuilder extends IBuilder {


    public void visit();

    public void expression();

    public void constructor();

    public void method();

    public void typeArguments();

    public void object();

    public void arguments();

    public void queryName();

    public void operation();

    public void nt();

    public void grammar();

    public void text();

    public void defaultPersistence();

    public void synchronizeStrategy();

    public void traversalStrategy();

    public void rootResource();

    public void rootResourceKind();

    public void resource();

    public void resourceKind();

    public void persistence();

    public void classProvider();

    public void className();

    public void bindings();

    public void template();

    public void model();

    public void showVariables();

    public void conditionTest();

    public void hitCount();

    public void disabled();

    public void factory();

    public void assignments();

    public void result();

    public void fault();

    public void timer();

    public void message();

    public void parameters();

    public void defaultCase();

    public void conditionalCases();

    public void switchType();

    public void condition();

    public void testTime();

    public void indexVariable();

    public void elementVariable();

    public void compositeVariable();

    public void flowObjects();

    public void triggerEvent();

    public void faultVariable();

    public void faultName();

    public void faultHandlers();

    public void eventHandlers();

    public void compensationHandler();

    public void label();

    public void endEvent();

    public void flowObject();

    public void startEvent();

    public void declarations();

    public void description();

    public void name();

    public void Workflow();

    public void Workflow_();

    public void _Workflow();

    public void Scope();

    public void Scope_();

    public void _Scope();

    public void FaultHandlers();

    public void FaultHandlers_();

    public void FaultHandlers_(int initialCapacity);

    public void _FaultHandlers();

    public void FaultHandler();

    public void FaultHandler_();

    public void _FaultHandler();

    public void EventHandlers();

    public void EventHandlers_();

    public void EventHandlers_(int initialCapacity);

    public void _EventHandlers();

    public void EventHandler();

    public void EventHandler_();

    public void _EventHandler();

    public void Sequence();

    public void Sequence_();

    public void _Sequence();

    public void Parallel();

    public void Parallel_();

    public void _Parallel();

    public void FlowObjects();

    public void FlowObjects_();

    public void FlowObjects_(int initialCapacity);

    public void _FlowObjects();

    public void ForeachLoop();

    public void ForeachLoop_();

    public void _ForeachLoop();

    public void WhileLoop();

    public void WhileLoop_();

    public void _WhileLoop();

    public void TestTime();

    public void TestTime(TestTimeEnum.Value value);

    public void TestTime(String value);

    public void PickControl();

    public void PickControl_();

    public void _PickControl();

    public void SwitchControl();

    public void SwitchControl_();

    public void _SwitchControl();

    public void SwitchType();

    public void SwitchType(SwitchTypeEnum.Value value);

    public void SwitchType(String value);

    public void ConditionalCases();

    public void ConditionalCases_();

    public void ConditionalCases_(int initialCapacity);

    public void _ConditionalCases();

    public void ConditionalCase();

    public void ConditionalCase_();

    public void _ConditionalCase();

    public void DefaultCase();

    public void DefaultCase_();

    public void _DefaultCase();

    public void OnCallEvent();

    public void OnCallEvent_();

    public void _OnCallEvent();

    public void OnMessageEvent();

    public void OnMessageEvent_();

    public void _OnMessageEvent();

    public void OnTimerEvent();

    public void OnTimerEvent_();

    public void _OnTimerEvent();

    public void FaultEvent();

    public void FaultEvent_();

    public void _FaultEvent();

    public void ReturnEvent();

    public void ReturnEvent_();

    public void _ReturnEvent();

    public void Task();

    public void Task_();

    public void _Task();

    public void Breakpoint();

    public void Breakpoint_();

    public void _Breakpoint();

    public void ConditionTest();

    public void ConditionTest(ConditionTestEnum.Value value);

    public void ConditionTest(String value);

    public void Variables();

    public void Variables_();

    public void Variables_(int initialCapacity);

    public void _Variables();

    public void EmptyActivity();

    public void EmptyActivity_();

    public void _EmptyActivity();

    public void AssignActivity();

    public void AssignActivity_();

    public void _AssignActivity();

    public void CreateModel();

    public void CreateModel_();

    public void _CreateModel();

    public void LoadJavaModel();

    public void LoadJavaModel_();

    public void _LoadJavaModel();

    public void ResourceKind();

    public void ResourceKind(ResourceKindEnum.Value value);

    public void ResourceKind(String value);

    public void LoadModel();

    public void LoadModel_();

    public void _LoadModel();

    public void SaveModel();

    public void SaveModel_();

    public void _SaveModel();

    public void DeleteArtifacts();

    public void DeleteArtifacts_();

    public void _DeleteArtifacts();

    public void ArtifactsTraversalStrategy();

    public void ArtifactsTraversalStrategy(ArtifactsTraversalStrategyEnum.Value value);

    public void ArtifactsTraversalStrategy(String value);

    public void ArtifactsSynchronizeStrategy();

    public void ArtifactsSynchronizeStrategy(ArtifactsSynchronizeStrategyEnum.Value value);

    public void ArtifactsSynchronizeStrategy(String value);

    public void LoadArtifacts();

    public void LoadArtifacts_();

    public void _LoadArtifacts();

    public void SaveArtifacts();

    public void SaveArtifacts_();

    public void _SaveArtifacts();

    public void Parse();

    public void Parse_();

    public void _Parse();

    public void Unparse();

    public void Unparse_();

    public void _Unparse();

    public void InvokeOperation();

    public void InvokeOperation_();

    public void _InvokeOperation();

    public void Operation();

    public void Operation(OperationEnum.Value value);

    public void Operation(String value);

    public void InvokeQuery();

    public void InvokeQuery_();

    public void _InvokeQuery();

    public void InvokeJavaInstanceMethod();

    public void InvokeJavaInstanceMethod_();

    public void _InvokeJavaInstanceMethod();

    public void InvokeJavaClassMethod();

    public void InvokeJavaClassMethod_();

    public void _InvokeJavaClassMethod();

    public void CreateJavaClassInstance();

    public void CreateJavaClassInstance_();

    public void _CreateJavaClassInstance();

    public void Registry();

    public void Registry(RegistryEnum.Value value);

    public void Registry(String value);

    public void BooleanLiteral();

    public void BooleanLiteral(boolean value);

    public void IntLiteral();

    public void IntLiteral(int value);

    public void StringLiteral();

    public void StringLiteral(String value);

    public void ObjectLiteral();

    public void ObjectLiteral(Object value);

    public void ObjectLiteral(String value);

    public void Variable();

    public void Variable(String value);

    public void Name();

    public void Name(String value);

    public void Text();

    public void Text(String value);

    public void Declarations();

    public void Declarations_();

    public void Declarations_(int initialCapacity);

    public void _Declarations();

    public void Assignments();

    public void Assignments_();

    public void Assignments_(int initialCapacity);

    public void _Assignments();

    public void Assign();

    public void Assign_();

    public void _Assign();

    public void Expressions();

    public void Expressions_();

    public void Expressions_(int initialCapacity);

    public void _Expressions();

    public void Signature();

    public void Signature(String value);

    public void ClassPath();

    public void ClassPath_();

    public void _ClassPath();

    public void CurrentJavaProject();

    public void CurrentJavaProject_();

    public void _CurrentJavaProject();

    public void JavaProject();

    public void JavaProject(String value);
}
