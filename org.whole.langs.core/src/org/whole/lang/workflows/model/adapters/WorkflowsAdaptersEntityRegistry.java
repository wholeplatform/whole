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
package org.whole.lang.workflows.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.workflows.reflect.WorkflowsEntityDescriptorEnum;

/**
 *  @generator Whole
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
        put(new MessageAdapter());
        put(new FaultAdapter());
        put(new ResultAdapter());
        put(new ConditionAdapter());
        put(new ParametersAdapter());
        put(new TimerAdapter());
        put(new EventAdapter());
    }
}
