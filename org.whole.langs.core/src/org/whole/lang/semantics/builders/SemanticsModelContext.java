/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.semantics.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.semantics.reflect.SemanticsFeatureDescriptorEnum;

/**
 *  @generator Whole
 */
public class SemanticsModelContext extends EntityContext {

    public SemanticsModelContext(IEntity root) {
        super(root);
    }

    public SemanticsModelContext getUri() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.uri);
    }

    public void setUri(SemanticsModelContext uri) {
        wSet(SemanticsFeatureDescriptorEnum.uri, uri);
    }

    public SemanticsModelContext getNamespace() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.namespace);
    }

    public void setNamespace(SemanticsModelContext namespace) {
        wSet(SemanticsFeatureDescriptorEnum.namespace, namespace);
    }

    public SemanticsModelContext getName() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.name);
    }

    public void setName(SemanticsModelContext name) {
        wSet(SemanticsFeatureDescriptorEnum.name, name);
    }

    public SemanticsModelContext getVersion() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.version);
    }

    public void setVersion(SemanticsModelContext version) {
        wSet(SemanticsFeatureDescriptorEnum.version, version);
    }

    public SemanticsModelContext getFunctions() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.functions);
    }

    public void setFunctions(SemanticsModelContext functions) {
        wSet(SemanticsFeatureDescriptorEnum.functions, functions);
    }

    public SemanticsModelContext getSignature() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.signature);
    }

    public void setSignature(SemanticsModelContext signature) {
        wSet(SemanticsFeatureDescriptorEnum.signature, signature);
    }

    public SemanticsModelContext getRules() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.rules);
    }

    public void setRules(SemanticsModelContext rules) {
        wSet(SemanticsFeatureDescriptorEnum.rules, rules);
    }

    public SemanticsModelContext getSource() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.source);
    }

    public void setSource(SemanticsModelContext source) {
        wSet(SemanticsFeatureDescriptorEnum.source, source);
    }

    public SemanticsModelContext getTarget() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.target);
    }

    public void setTarget(SemanticsModelContext target) {
        wSet(SemanticsFeatureDescriptorEnum.target, target);
    }

    public SemanticsModelContext getCategory() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.category);
    }

    public void setCategory(SemanticsModelContext category) {
        wSet(SemanticsFeatureDescriptorEnum.category, category);
    }

    public SemanticsModelContext getCondition() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.condition);
    }

    public void setCondition(SemanticsModelContext condition) {
        wSet(SemanticsFeatureDescriptorEnum.condition, condition);
    }

    public SemanticsModelContext getMeaning() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.meaning);
    }

    public void setMeaning(SemanticsModelContext meaning) {
        wSet(SemanticsFeatureDescriptorEnum.meaning, meaning);
    }

    public SemanticsModelContext getPremises() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.premises);
    }

    public void setPremises(SemanticsModelContext premises) {
        wSet(SemanticsFeatureDescriptorEnum.premises, premises);
    }

    public SemanticsModelContext getConclusion() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.conclusion);
    }

    public void setConclusion(SemanticsModelContext conclusion) {
        wSet(SemanticsFeatureDescriptorEnum.conclusion, conclusion);
    }

    public SemanticsModelContext getSourceConfiguration() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.sourceConfiguration);
    }

    public void setSourceConfiguration(SemanticsModelContext sourceConfiguration) {
        wSet(SemanticsFeatureDescriptorEnum.sourceConfiguration, sourceConfiguration);
    }

    public SemanticsModelContext getTargetConfiguration() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.targetConfiguration);
    }

    public void setTargetConfiguration(SemanticsModelContext targetConfiguration) {
        wSet(SemanticsFeatureDescriptorEnum.targetConfiguration, targetConfiguration);
    }

    public SemanticsModelContext getVariable() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.variable);
    }

    public void setVariable(SemanticsModelContext variable) {
        wSet(SemanticsFeatureDescriptorEnum.variable, variable);
    }

    public SemanticsModelContext getIndex() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.index);
    }

    public void setIndex(SemanticsModelContext index) {
        wSet(SemanticsFeatureDescriptorEnum.index, index);
    }

    public SemanticsModelContext getTime() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.time);
    }

    public void setTime(SemanticsModelContext time) {
        wSet(SemanticsFeatureDescriptorEnum.time, time);
    }

    public SemanticsModelContext getIdentifier() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.identifier);
    }

    public void setIdentifier(SemanticsModelContext identifier) {
        wSet(SemanticsFeatureDescriptorEnum.identifier, identifier);
    }

    public SemanticsModelContext getNewIdentifier() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.newIdentifier);
    }

    public void setNewIdentifier(SemanticsModelContext newIdentifier) {
        wSet(SemanticsFeatureDescriptorEnum.newIdentifier, newIdentifier);
    }

    public SemanticsModelContext getOldIdentifier() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.oldIdentifier);
    }

    public void setOldIdentifier(SemanticsModelContext oldIdentifier) {
        wSet(SemanticsFeatureDescriptorEnum.oldIdentifier, oldIdentifier);
    }

    public SemanticsModelContext getBindings() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.bindings);
    }

    public void setBindings(SemanticsModelContext bindings) {
        wSet(SemanticsFeatureDescriptorEnum.bindings, bindings);
    }

    public SemanticsModelContext getNestedScope() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.nestedScope);
    }

    public void setNestedScope(SemanticsModelContext nestedScope) {
        wSet(SemanticsFeatureDescriptorEnum.nestedScope, nestedScope);
    }

    public SemanticsModelContext getOp() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.op);
    }

    public void setOp(SemanticsModelContext op) {
        wSet(SemanticsFeatureDescriptorEnum.op, op);
    }

    public SemanticsModelContext getExpression() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.expression);
    }

    public void setExpression(SemanticsModelContext expression) {
        wSet(SemanticsFeatureDescriptorEnum.expression, expression);
    }

    public SemanticsModelContext getEnvironment() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.environment);
    }

    public void setEnvironment(SemanticsModelContext environment) {
        wSet(SemanticsFeatureDescriptorEnum.environment, environment);
    }

    public SemanticsModelContext getType() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.type);
    }

    public void setType(SemanticsModelContext type) {
        wSet(SemanticsFeatureDescriptorEnum.type, type);
    }

    public SemanticsModelContext getArguments() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.arguments);
    }

    public void setArguments(SemanticsModelContext arguments) {
        wSet(SemanticsFeatureDescriptorEnum.arguments, arguments);
    }

    public SemanticsModelContext getEnvironments() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.environments);
    }

    public void setEnvironments(SemanticsModelContext environments) {
        wSet(SemanticsFeatureDescriptorEnum.environments, environments);
    }

    public SemanticsModelContext getStage() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.stage);
    }

    public void setStage(SemanticsModelContext stage) {
        wSet(SemanticsFeatureDescriptorEnum.stage, stage);
    }

    public SemanticsModelContext getWhere() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.where);
    }

    public void setWhere(SemanticsModelContext where) {
        wSet(SemanticsFeatureDescriptorEnum.where, where);
    }

    public SemanticsModelContext getSub() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.sub);
    }

    public void setSub(SemanticsModelContext sub) {
        wSet(SemanticsFeatureDescriptorEnum.sub, sub);
    }

    public SemanticsModelContext getSup() {
        return (SemanticsModelContext) wGet(SemanticsFeatureDescriptorEnum.sup);
    }

    public void setSup(SemanticsModelContext sup) {
        wSet(SemanticsFeatureDescriptorEnum.sup, sup);
    }
}
