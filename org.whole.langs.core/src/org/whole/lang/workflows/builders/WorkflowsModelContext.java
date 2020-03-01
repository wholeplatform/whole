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

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.workflows.reflect.WorkflowsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class WorkflowsModelContext extends EntityContext {

    public WorkflowsModelContext(IEntity root) {
        super(root);
    }

    public WorkflowsModelContext getName() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.name);
    }

    public void setName(WorkflowsModelContext name) {
        wSet(WorkflowsFeatureDescriptorEnum.name, name);
    }

    public WorkflowsModelContext getDescription() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.description);
    }

    public void setDescription(WorkflowsModelContext description) {
        wSet(WorkflowsFeatureDescriptorEnum.description, description);
    }

    public WorkflowsModelContext getDeclarations() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.declarations);
    }

    public void setDeclarations(WorkflowsModelContext declarations) {
        wSet(WorkflowsFeatureDescriptorEnum.declarations, declarations);
    }

    public WorkflowsModelContext getStartEvent() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.startEvent);
    }

    public void setStartEvent(WorkflowsModelContext startEvent) {
        wSet(WorkflowsFeatureDescriptorEnum.startEvent, startEvent);
    }

    public WorkflowsModelContext getFlowObject() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.flowObject);
    }

    public void setFlowObject(WorkflowsModelContext flowObject) {
        wSet(WorkflowsFeatureDescriptorEnum.flowObject, flowObject);
    }

    public WorkflowsModelContext getEndEvent() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.endEvent);
    }

    public void setEndEvent(WorkflowsModelContext endEvent) {
        wSet(WorkflowsFeatureDescriptorEnum.endEvent, endEvent);
    }

    public WorkflowsModelContext getLabel() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.label);
    }

    public void setLabel(WorkflowsModelContext label) {
        wSet(WorkflowsFeatureDescriptorEnum.label, label);
    }

    public WorkflowsModelContext getCompensationHandler() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.compensationHandler);
    }

    public void setCompensationHandler(WorkflowsModelContext compensationHandler) {
        wSet(WorkflowsFeatureDescriptorEnum.compensationHandler, compensationHandler);
    }

    public WorkflowsModelContext getEventHandlers() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.eventHandlers);
    }

    public void setEventHandlers(WorkflowsModelContext eventHandlers) {
        wSet(WorkflowsFeatureDescriptorEnum.eventHandlers, eventHandlers);
    }

    public WorkflowsModelContext getFaultHandlers() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.faultHandlers);
    }

    public void setFaultHandlers(WorkflowsModelContext faultHandlers) {
        wSet(WorkflowsFeatureDescriptorEnum.faultHandlers, faultHandlers);
    }

    public WorkflowsModelContext getFaultName() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.faultName);
    }

    public void setFaultName(WorkflowsModelContext faultName) {
        wSet(WorkflowsFeatureDescriptorEnum.faultName, faultName);
    }

    public WorkflowsModelContext getFaultVariable() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.faultVariable);
    }

    public void setFaultVariable(WorkflowsModelContext faultVariable) {
        wSet(WorkflowsFeatureDescriptorEnum.faultVariable, faultVariable);
    }

    public WorkflowsModelContext getTriggerEvent() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.triggerEvent);
    }

    public void setTriggerEvent(WorkflowsModelContext triggerEvent) {
        wSet(WorkflowsFeatureDescriptorEnum.triggerEvent, triggerEvent);
    }

    public WorkflowsModelContext getFlowObjects() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.flowObjects);
    }

    public void setFlowObjects(WorkflowsModelContext flowObjects) {
        wSet(WorkflowsFeatureDescriptorEnum.flowObjects, flowObjects);
    }

    public WorkflowsModelContext getCompositeVariable() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.compositeVariable);
    }

    public void setCompositeVariable(WorkflowsModelContext compositeVariable) {
        wSet(WorkflowsFeatureDescriptorEnum.compositeVariable, compositeVariable);
    }

    public WorkflowsModelContext getElementVariable() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.elementVariable);
    }

    public void setElementVariable(WorkflowsModelContext elementVariable) {
        wSet(WorkflowsFeatureDescriptorEnum.elementVariable, elementVariable);
    }

    public WorkflowsModelContext getIndexVariable() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.indexVariable);
    }

    public void setIndexVariable(WorkflowsModelContext indexVariable) {
        wSet(WorkflowsFeatureDescriptorEnum.indexVariable, indexVariable);
    }

    public WorkflowsModelContext getTestTime() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.testTime);
    }

    public void setTestTime(WorkflowsModelContext testTime) {
        wSet(WorkflowsFeatureDescriptorEnum.testTime, testTime);
    }

    public WorkflowsModelContext getCondition() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.condition);
    }

    public void setCondition(WorkflowsModelContext condition) {
        wSet(WorkflowsFeatureDescriptorEnum.condition, condition);
    }

    public WorkflowsModelContext getSwitchType() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.switchType);
    }

    public void setSwitchType(WorkflowsModelContext switchType) {
        wSet(WorkflowsFeatureDescriptorEnum.switchType, switchType);
    }

    public WorkflowsModelContext getConditionalCases() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.conditionalCases);
    }

    public void setConditionalCases(WorkflowsModelContext conditionalCases) {
        wSet(WorkflowsFeatureDescriptorEnum.conditionalCases, conditionalCases);
    }

    public WorkflowsModelContext getDefaultCase() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.defaultCase);
    }

    public void setDefaultCase(WorkflowsModelContext defaultCase) {
        wSet(WorkflowsFeatureDescriptorEnum.defaultCase, defaultCase);
    }

    public WorkflowsModelContext getParameters() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.parameters);
    }

    public void setParameters(WorkflowsModelContext parameters) {
        wSet(WorkflowsFeatureDescriptorEnum.parameters, parameters);
    }

    public WorkflowsModelContext getMessage() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.message);
    }

    public void setMessage(WorkflowsModelContext message) {
        wSet(WorkflowsFeatureDescriptorEnum.message, message);
    }

    public WorkflowsModelContext getTimer() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.timer);
    }

    public void setTimer(WorkflowsModelContext timer) {
        wSet(WorkflowsFeatureDescriptorEnum.timer, timer);
    }

    public WorkflowsModelContext getFault() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.fault);
    }

    public void setFault(WorkflowsModelContext fault) {
        wSet(WorkflowsFeatureDescriptorEnum.fault, fault);
    }

    public WorkflowsModelContext getResult() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.result);
    }

    public void setResult(WorkflowsModelContext result) {
        wSet(WorkflowsFeatureDescriptorEnum.result, result);
    }

    public WorkflowsModelContext getAssignments() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.assignments);
    }

    public void setAssignments(WorkflowsModelContext assignments) {
        wSet(WorkflowsFeatureDescriptorEnum.assignments, assignments);
    }

    public WorkflowsModelContext getFactory() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.factory);
    }

    public void setFactory(WorkflowsModelContext factory) {
        wSet(WorkflowsFeatureDescriptorEnum.factory, factory);
    }

    public WorkflowsModelContext getDisabled() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.disabled);
    }

    public void setDisabled(WorkflowsModelContext disabled) {
        wSet(WorkflowsFeatureDescriptorEnum.disabled, disabled);
    }

    public WorkflowsModelContext getHitCount() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.hitCount);
    }

    public void setHitCount(WorkflowsModelContext hitCount) {
        wSet(WorkflowsFeatureDescriptorEnum.hitCount, hitCount);
    }

    public WorkflowsModelContext getConditionTest() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.conditionTest);
    }

    public void setConditionTest(WorkflowsModelContext conditionTest) {
        wSet(WorkflowsFeatureDescriptorEnum.conditionTest, conditionTest);
    }

    public WorkflowsModelContext getShowVariables() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.showVariables);
    }

    public void setShowVariables(WorkflowsModelContext showVariables) {
        wSet(WorkflowsFeatureDescriptorEnum.showVariables, showVariables);
    }

    public WorkflowsModelContext getModel() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.model);
    }

    public void setModel(WorkflowsModelContext model) {
        wSet(WorkflowsFeatureDescriptorEnum.model, model);
    }

    public WorkflowsModelContext getTemplate() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.template);
    }

    public void setTemplate(WorkflowsModelContext template) {
        wSet(WorkflowsFeatureDescriptorEnum.template, template);
    }

    public WorkflowsModelContext getBindings() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.bindings);
    }

    public void setBindings(WorkflowsModelContext bindings) {
        wSet(WorkflowsFeatureDescriptorEnum.bindings, bindings);
    }

    public WorkflowsModelContext getClassName() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.className);
    }

    public void setClassName(WorkflowsModelContext className) {
        wSet(WorkflowsFeatureDescriptorEnum.className, className);
    }

    public WorkflowsModelContext getClassProvider() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.classProvider);
    }

    public void setClassProvider(WorkflowsModelContext classProvider) {
        wSet(WorkflowsFeatureDescriptorEnum.classProvider, classProvider);
    }

    public WorkflowsModelContext getPersistence() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.persistence);
    }

    public void setPersistence(WorkflowsModelContext persistence) {
        wSet(WorkflowsFeatureDescriptorEnum.persistence, persistence);
    }

    public WorkflowsModelContext getResourceKind() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.resourceKind);
    }

    public void setResourceKind(WorkflowsModelContext resourceKind) {
        wSet(WorkflowsFeatureDescriptorEnum.resourceKind, resourceKind);
    }

    public WorkflowsModelContext getResource() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.resource);
    }

    public void setResource(WorkflowsModelContext resource) {
        wSet(WorkflowsFeatureDescriptorEnum.resource, resource);
    }

    public WorkflowsModelContext getRootResourceKind() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.rootResourceKind);
    }

    public void setRootResourceKind(WorkflowsModelContext rootResourceKind) {
        wSet(WorkflowsFeatureDescriptorEnum.rootResourceKind, rootResourceKind);
    }

    public WorkflowsModelContext getRootResource() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.rootResource);
    }

    public void setRootResource(WorkflowsModelContext rootResource) {
        wSet(WorkflowsFeatureDescriptorEnum.rootResource, rootResource);
    }

    public WorkflowsModelContext getTraversalStrategy() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.traversalStrategy);
    }

    public void setTraversalStrategy(WorkflowsModelContext traversalStrategy) {
        wSet(WorkflowsFeatureDescriptorEnum.traversalStrategy, traversalStrategy);
    }

    public WorkflowsModelContext getSynchronizeStrategy() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.synchronizeStrategy);
    }

    public void setSynchronizeStrategy(WorkflowsModelContext synchronizeStrategy) {
        wSet(WorkflowsFeatureDescriptorEnum.synchronizeStrategy, synchronizeStrategy);
    }

    public WorkflowsModelContext getDefaultPersistence() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.defaultPersistence);
    }

    public void setDefaultPersistence(WorkflowsModelContext defaultPersistence) {
        wSet(WorkflowsFeatureDescriptorEnum.defaultPersistence, defaultPersistence);
    }

    public WorkflowsModelContext getText() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.text);
    }

    public void setText(WorkflowsModelContext text) {
        wSet(WorkflowsFeatureDescriptorEnum.text, text);
    }

    public WorkflowsModelContext getGrammar() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.grammar);
    }

    public void setGrammar(WorkflowsModelContext grammar) {
        wSet(WorkflowsFeatureDescriptorEnum.grammar, grammar);
    }

    public WorkflowsModelContext getNt() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.nt);
    }

    public void setNt(WorkflowsModelContext nt) {
        wSet(WorkflowsFeatureDescriptorEnum.nt, nt);
    }

    public WorkflowsModelContext getOperation() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.operation);
    }

    public void setOperation(WorkflowsModelContext operation) {
        wSet(WorkflowsFeatureDescriptorEnum.operation, operation);
    }

    public WorkflowsModelContext getQueryName() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.queryName);
    }

    public void setQueryName(WorkflowsModelContext queryName) {
        wSet(WorkflowsFeatureDescriptorEnum.queryName, queryName);
    }

    public WorkflowsModelContext getArguments() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.arguments);
    }

    public void setArguments(WorkflowsModelContext arguments) {
        wSet(WorkflowsFeatureDescriptorEnum.arguments, arguments);
    }

    public WorkflowsModelContext getObject() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.object);
    }

    public void setObject(WorkflowsModelContext object) {
        wSet(WorkflowsFeatureDescriptorEnum.object, object);
    }

    public WorkflowsModelContext getTypeArguments() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.typeArguments);
    }

    public void setTypeArguments(WorkflowsModelContext typeArguments) {
        wSet(WorkflowsFeatureDescriptorEnum.typeArguments, typeArguments);
    }

    public WorkflowsModelContext getMethod() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.method);
    }

    public void setMethod(WorkflowsModelContext method) {
        wSet(WorkflowsFeatureDescriptorEnum.method, method);
    }

    public WorkflowsModelContext getConstructor() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.constructor);
    }

    public void setConstructor(WorkflowsModelContext constructor) {
        wSet(WorkflowsFeatureDescriptorEnum.constructor, constructor);
    }

    public WorkflowsModelContext getExpression() {
        return (WorkflowsModelContext) wGet(WorkflowsFeatureDescriptorEnum.expression);
    }

    public void setExpression(WorkflowsModelContext expression) {
        wSet(WorkflowsFeatureDescriptorEnum.expression, expression);
    }
}
